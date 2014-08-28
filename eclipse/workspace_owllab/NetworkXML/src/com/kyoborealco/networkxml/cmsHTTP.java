package com.kyoborealco.networkxml;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

import android.app.Activity;
import android.util.Log;
import android.widget.Toast;

public class cmsHTTP {

	public String mimeType = "text/html";
	public String encoding = "UTF-8";
	public int REGISTRATION_TIMEOUT = 10 * 1000;
	public String TAG = "cmsHTTP";
	public Activity act;
	public String noData = "죄송합니다.\n네트웍 장애가 있습니다.\n다시 시도해주세요.";

	public cmsHTTP() {
		
	}
	
	public String sendGet(String url) {
		String result = null;
		HttpResponse resp;
		
		HttpGet httpGet = new HttpGet(url);
		
		HttpClient httpClient = new DefaultHttpClient();
		HttpParams tmpparms = httpClient.getParams();
		HttpConnectionParams.setConnectionTimeout(tmpparms, REGISTRATION_TIMEOUT);
		HttpConnectionParams.setSoTimeout(tmpparms, REGISTRATION_TIMEOUT);
		ConnManagerParams.setTimeout(tmpparms, REGISTRATION_TIMEOUT);
		
		try {
			System.out.println("resp = httpClient.execute(httpGet); 처리전");
			resp = httpClient.execute(httpGet);
			System.out.println("resp = httpClient.execute(httpGet); 처리후");
			if (resp.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				if (Log.isLoggable(TAG, Log.VERBOSE)) {
					Log.v(TAG, "Successful authentication");
				}
				
				HttpEntity respEntity = resp.getEntity();
				if (respEntity != null) {
					InputStream instream = respEntity.getContent();
					result = convertStreamToString(instream);
					instream.close();
				}
			}
			else {
				if (Log.isLoggable(TAG, Log.VERBOSE)) {
					Log.v(TAG, "Error Process" + resp.getStatusLine());
				}
			}
		}
		catch (final IOException e) {
			System.out.println("catch (final IOException e) : " + e.toString());
			if (Log.isLoggable(TAG, Log.VERBOSE)) {
				Log.v(TAG, "IOException when getting authtoken", e);
			}
		}
		catch (Exception e) {
			// 오류가 자꾸 발생해서 Exception 이라고 모든 오류를 받는 catch 문을 추가함
			// 그랬더니 LogCat에 다음과 같은 오류를 확인했다.
			// 다행히 블로그들에 해당 오류 해결 방안이 나오는구나!!
			// 08-28 00:55:08.515: I/System.out(798): catch (Exception e) : android.os.NetworkOnMainThreadException

			System.out.println("catch (Exception e) : " + e.toString());
		}
		finally {
			System.out.println("finally...");
			if (Log.isLoggable(TAG, Log.VERBOSE)) {
				Log.v(TAG, "completing");
			}
		}
		
		if (result == null) {
			Toast.makeText(act, noData, Toast.LENGTH_SHORT).show();
		}
		
		return result;
	}
	
	public String convertStreamToString( InputStream is ) {
		
		StringBuilder sb = new StringBuilder();
		String line = null;
		
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(is, encoding), 8);
			while ( (line = reader.readLine()) != null) {
				sb.append(line + "\n");
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			try {
				is.close();
			}
			catch (IOException e) {
				e.printStackTrace();
			}
		}
		return sb.toString();
	}
	
}
