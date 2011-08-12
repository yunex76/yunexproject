package com.yunex;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.ItemizedOverlay;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapView;
import com.google.android.maps.OverlayItem;

// maps.jar 구하는 법 : http://code.google.com/intl/ko-KR/android/add-ons/google-apis/installing.html
// 구글맵 api 가입방법 : http://tobe30.com/tc/entry/Android_GoogleMapsAPI_Using
/*
안드로이드 지도 API 키에 가입해주셔서 감사합니다.
사용자 키:
	00IXiZdsImfa1ynZ64nkdT4BWXUKvnTkEYD-n8g
이 키는
	B3:AB:9E:B4:80:34:8B:14:CA:B4:2F:C1:4E:AD:4A:AE
지문이 등록된 사용자 인증서가 있는 모든 애플리케이션에서 사용할 수 있습니다.
 */
public class RestaurantMap extends MapActivity {
	
	public static final String EXTRA_LATITUDE = "com.yunex.EXTRA_LATITUDE";
	public static final String EXTRA_LONGITUDE = "com.yunex.EXTRA_LONGITUDE";
	public static final String EXTRA_NAME = "com.yunex.EXTRA_NAME";
	
	private MapView map = null;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.map);
		
		double lat = getIntent().getDoubleExtra(EXTRA_LATITUDE, 0);
		double lon = getIntent().getDoubleExtra(EXTRA_LONGITUDE, 0);
		
		map = (MapView)findViewById(R.id.mapview);
		map.getController().setZoom(17);
		GeoPoint status = new GeoPoint((int)(lat*1000000.0), (int)(lon*1000000.0));
		map.getController().setCenter(status);
		map.setBuiltInZoomControls(true);
		
		Drawable marker = getResources().getDrawable(R.drawable.marker);
		marker.setBounds(0, 0, marker.getIntrinsicWidth(), marker.getIntrinsicHeight());
		map.getOverlays().add(new RestaurantOverlay(marker, status, getIntent().getStringExtra(EXTRA_NAME)));
		
	}
	
	@Override
	protected boolean isRouteDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}
	
	private class RestaurantOverlay extends ItemizedOverlay<OverlayItem> {
		private OverlayItem item = null;
		
		public RestaurantOverlay(Drawable marker, GeoPoint point, String name) {
			super(marker);
			
			boundCenterBottom(marker);
			
			item = new OverlayItem(point, name, name);
			
			populate();
		}
		
		@Override
		protected OverlayItem createItem(int i) {
			return item;
		}
		
		@Override
		public int size() {
			return 1;
		}
		
		@Override
		protected boolean onTap(int i) {
			Toast.makeText(RestaurantMap.this, item.getSnippet(), Toast.LENGTH_SHORT).show();
			return true;
		}
	}
}
