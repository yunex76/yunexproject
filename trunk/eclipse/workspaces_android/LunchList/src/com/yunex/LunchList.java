package com.yunex;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class LunchList extends Activity {

	Restaurant r = new Restaurant();

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        Button save = (Button)findViewById(R.id.save);
        
		save.setOnClickListener(onSave);
    }

	private View.OnClickListener onSave = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			EditText name = (EditText)findViewById(R.id.name);
			EditText address = (EditText)findViewById(R.id.addr);
			
			r.setName(name.getText().toString());
			r.setAddress(address.getText().toString());

			// LogCat 상단의 V,D,I,W,E 조건에 따라 메소드가 결정됨
			Log.d("DEBUG", r.toString());
		}
	};
}