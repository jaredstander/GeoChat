package com.jaredstander.geochat;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

import com.getpebble.android.kit.PebbleKit;
import com.getpebble.android.kit.util.PebbleDictionary;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void sendPebble(View view) {
	    final Intent i = new Intent("com.getpebble.action.SEND_NOTIFICATION");
	    
	    EditText editText = (EditText) findViewById(R.id.message_text);
	    String message = editText.getText().toString(); 

	    final Map<String, String> data = new HashMap<String, String>();
	    data.put("title", "This location has a message for you:");
	    data.put("body", message);

	    final JSONObject jsonData = new JSONObject(data);
	    final String notificationData = new JSONArray().put(jsonData).toString();
	    i.putExtra("messageType", "PEBBLE_ALERT");
	    i.putExtra("sender", "GeoChat");
	    i.putExtra("notificationData", notificationData);

	    Log.d("Test", "Sending to Pebble: " + notificationData);
	    sendBroadcast(i);
	}

}
