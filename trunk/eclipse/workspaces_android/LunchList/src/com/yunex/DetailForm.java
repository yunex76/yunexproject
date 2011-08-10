package com.yunex;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

public class DetailForm extends Activity {

	EditText name = null;
	EditText address = null;
	EditText notes = null;
	RadioGroup types = null;
	RestaurantHelper helper = null;
	
	String restaurantId = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.detail_form);

        helper = new RestaurantHelper(this);
        
        name = (EditText)findViewById(R.id.name);
        address = (EditText)findViewById(R.id.addr);
        types = (RadioGroup)findViewById(R.id.types);
        notes = (EditText)findViewById(R.id.notes);
        
        Button save = (Button)findViewById(R.id.save);
		save.setOnClickListener(onSave);
		
		restaurantId = getIntent().getStringExtra(LunchList.ID_EXTRA);
		if (restaurantId != null) {
			load();
		}
	}
	
	private void load() {
		Cursor c = helper.getById(restaurantId);
		
		c.moveToFirst();
		name.setText(helper.getName(c));
		address.setText(helper.getAddress(c));
		notes.setText(helper.getNotes(c));
		
		if (helper.getType(c).equals("sit_down")) {
			types.check(R.id.sit_down);
		}
		else if (helper.getType(c).equals("take_out")) {
			types.check(R.id.take_out);
		}
		else {
			types.check(R.id.delivery);
		}
		
		c.close();
	}

	@Override
	protected void onDestroy() {

		super.onDestroy();
		helper.close();
	}
	
	@Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		
		outState.putString("name", name.getText().toString());
		outState.putString("address", address.getText().toString());
		outState.putString("notes", notes.getText().toString());
		outState.putInt("type", types.getCheckedRadioButtonId());
	}
	
	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState) {
		super.onRestoreInstanceState(savedInstanceState);
		
		name.setText(savedInstanceState.getString("name"));
		address.setText(savedInstanceState.getString("address"));
		notes.setText(savedInstanceState.getString("notes"));
		types.check(savedInstanceState.getInt("type"));
	}
	
	private View.OnClickListener onSave = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			String type = null;
			
			switch (types.getCheckedRadioButtonId()) {
			case R.id.sit_down:
				type = "sit_down";
				break;
			case R.id.take_out:
				type = "take_out";
				break;
			case R.id.delivery:
				type = "delivery";
				break;
			}
			
			if (restaurantId == null) {
				helper.insert(name.getText().toString(), address.getText().toString(),
						type, notes.getText().toString());
			}
			else {
				helper.update(restaurantId, name.getText().toString(),
						address.getText().toString(),
						type, notes.getText().toString());
			}
			
			finish();
		}
	};
	
}
