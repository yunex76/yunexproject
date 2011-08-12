package com.yunex;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class OnAlarmReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context ctxt, Intent intent) {
		Log.e("LunchList", "onReceive 1");
		Intent i = new Intent(ctxt, AlarmActivity.class);
		Log.e("LunchList", "onReceive 2");
		i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		Log.e("LunchList", "onReceive 3");
		ctxt.startActivity(i);
		Log.e("LunchList", "onReceive 4");
	}
}
