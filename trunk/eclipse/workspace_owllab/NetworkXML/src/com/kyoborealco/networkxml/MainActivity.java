package com.kyoborealco.networkxml;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        reLoadList(null);
    }
    
	public void reLoadList(View view) {
		
		// android.os.NetworkOnMainThreadException 오류에 대한 처리코드 추가
		// 참고1 : http://aroundck.tistory.com/1240
		// 참고2 : http://rainmaker0303.tistory.com/entry/androidosNetworkOnMainThreadException-%EC%97%90%EB%9F%AC
			// 내용 캡쳐]
			// 해당 Exception 은 진저브레드 ( 2.3.3 )에서는 발생하지 않았고, ICS ( 4.0.0 )부터 발생을 하기 시작한다.
			// 필자가 진저와 ICS 단말 둘다에서 테스트해본 결과 진저에서는 발생하지 않던 exception 이 ICS 에서 발생했기 때문이다.
		if ( android.os.Build.VERSION.SDK_INT > 9 ) {
			StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
			StrictMode.setThreadPolicy(policy);
		}
		
    	loadList();
		// loadList2();
    }


	HashMap<String, String> hm = new HashMap<String, String>();
    private void loadList() {
		String theUrl = "http://152.149.199.23/owllab/food_list.xml";
		cmsHTTP cmsHttp = new cmsHTTP();
		cmsHttp.encoding = "UTF-8";
		cmsHttp.act = this;
		
		String tmpData = cmsHttp.sendGet(theUrl);
		if (tmpData == null ) {
			return;
		}
		
		hm = xml2HashMap(tmpData, "UTF-8");
		System.out.println("hm.toString() = " + hm.toString());
		
		theListAdapter listAdapter = new theListAdapter(this, R.layout.list_row, hm);
		ListView listView = (ListView)findViewById(R.id.listView1);
		listView.setAdapter(listAdapter);
	}

    private HashMap<String, String> xml2HashMap(String tmpData, String encoding) {
    	HashMap<String, String> hm = new HashMap<String, String>();
    	hm.put("count", "0");
    	try {
    		DocumentBuilderFactory docBF = DocumentBuilderFactory.newInstance();
    		DocumentBuilder docB = docBF.newDocumentBuilder();
    		InputStream is = new ByteArrayInputStream(tmpData.getBytes(encoding));
    		Document doc = docB.parse(is);
    		Element lists = doc.getDocumentElement();
    		NodeList dataList = lists.getElementsByTagName("data");
    		int c = 0;
    		
    		for ( int i = 0; i < dataList.getLength(); i++ ) {
    			NodeList dataNodeList = dataList.item(i).getChildNodes();
    			for (int j = 0; j < dataNodeList.getLength(); j++) {
    				Node itemNode = dataNodeList.item(j);
    				if ( itemNode.getFirstChild() != null ) {
    					String nodeName = itemNode.getNodeName();
    					String nodeValue = itemNode.getFirstChild().getNodeValue();
    					hm.put(nodeName + "[" + i + "]", nodeValue);
    				}
    			}
    			c++;
    		}
    		hm.put("count", Integer.toString(c));
    	}
    	catch (Exception e) {
    		Log.e("com.cms.sample.xml2HashMap", e.getMessage());
    	}
		return hm;
	}

	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    
    
    class theListAdapter extends BaseAdapter {
    	
    	LayoutInflater inflater;
    	HashMap<String, String> hm;
    	Context mContext;
    	int mListLayout;
    	public int listCount = 0;
    	
    	public theListAdapter(Context tContext, int listLayout,
    			HashMap<String, String> tmpHm) {
        	
    		/*
    		넘어온 tmpHm
    		{
    			writer[0]=호정,
    			rowid[0]=101,
    			content[0]=하리사 양념, 야채, 특히 chick pea 를 주 재료로 만든 수프로, 얼큰한 맛이 난다.,
    			subject[0]=하리사 수프 Harissa soup,
    			thumb[0]=http://152.149.199.23/owllab/images/101_s.jpg,
    			img[0]=http://152.149.199.23/owllab/images/101.jpg,
    			
    			writer[1]=정웅,
    			rowid[1]=102,
    			content[1]=우유 생크림을 주 재료로 만든 케익, 달콤한 맛이 난다.,
    			subject[1]=케익 cake,
    			thumb[1]=http://152.149.199.23/owllab/images/102_s.jpg,
    			img[1]=http://152.149.199.23/owllab/images/102.jpg

    			count=2,
    		}
    		*/
    		
    		mContext = tContext;
    		mListLayout = listLayout;
    		hm = tmpHm;
    		inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    		listCount = Integer.parseInt(hm.get("count").toString());
    	}

		@Override
		public int getCount() {
			return listCount;
		}

		@Override
		public Object getItem(int position) {
			return position;
		}

		@Override
		public long getItemId(int position) {
			return position;
		}
		
		public HashMap<String, Bitmap> hmImg = new HashMap<String, Bitmap>();

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			if (convertView == null) {
				convertView = inflater.inflate(mListLayout, parent, false);
			}
			
			try {
				if ( hmImg.get("thumb[" + position + "]") == null) {
					String urlstr = hm.get("thumb[" + position + "]");
					URL url = new URL(urlstr);
					
					URLConnection conn = url.openConnection();
					conn.connect();
					BufferedInputStream bis = new BufferedInputStream(conn.getInputStream(),
							512 * 1024);
					Bitmap bm = BitmapFactory.decodeStream(bis);
					bis.close();
					hmImg.put("thumb[" + position + "]", bm);
				}
				
				if ( hmImg.get("thumb["+position + "]") != null) {
					((ImageView)convertView.findViewById(
							R.id.imageView1)).setImageBitmap(
									hmImg.get("thumb[" + position + "]"));
				}
			}
			catch ( IOException e ) {
				System.out.println("class theListAdapter : catch ( IOException e ) = " + e.toString());
			}
			catch ( Exception e ) {
				System.out.println("class theListAdapter : catch ( Exception e ) = " + e.toString());
			}
			
			((TextView) convertView.findViewById(R.id.textView1)).setText(
					"["+hm.get("rowid["+position+"]") + "] " + hm.get("subject[" + position + "]"));
			((TextView) convertView.findViewById(R.id.textView2)).setText(
					hm.get("content[" + position + "]"));
			((TextView) convertView.findViewById(R.id.textView3)).setText(
					hm.get("writer[" + position + "]"));
			
			final int positionInt = position;
			
			((LinearLayout) convertView.findViewById(R.id.LinearLayout1)).setOnClickListener(
					new Button.OnClickListener() {

						@Override
						public void onClick(View v) {
							detailInfo(positionInt);
						}

					});
			
			return convertView;
		}

		public void detailInfo(int position) {
			Dialog dialog = new Dialog(mContext);
			dialog.setContentView(R.layout.detail);
			dialog.setTitle(hm.get(hm.get("rowid["+position+"]")));
			dialog.show();
			
			((TextView)dialog.findViewById(R.id.textView1)).setText(
					hm.get("subject[" + position + "]"));
			((TextView)dialog.findViewById(R.id.textView2)).setText(
					hm.get("writer[" + position + "]"));
			((TextView)dialog.findViewById(R.id.textView3)).setText(
					hm.get("content[" + position + "]"));
			
			Button buttonOK = (Button)dialog.findViewById(R.id.button1);
			buttonOK.setOnClickListener(new detailOKListener(dialog));
			
			try {
				if ( hm.get("img[" + position + "]") != null) {
					String urlstr = hm.get("img[" + position + "]");
					URL url = new URL(urlstr);
					URLConnection conn = url.openConnection();
					conn.connect();
					BufferedInputStream bis = new BufferedInputStream(conn.getInputStream(), 512*1024);
					Bitmap bm = BitmapFactory.decodeStream(bis);
					((ImageView)dialog.findViewById(R.id.imageView1)).setImageBitmap(bm);
					bis.close();
				}
			}
			catch (IOException e) {
				
			}
		}
		
    }
    
    protected class detailOKListener implements OnClickListener {
    	private Dialog dialog;

    	public detailOKListener(Dialog dialog) {
    		this.dialog = dialog;    		
    	}

		@Override
		public void onClick(View v) {
			dialog.dismiss();
		}
    }
}
