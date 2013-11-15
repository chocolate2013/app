package com.chocolate.engSoft;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class NotificationScreen extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_notification_screen);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.notification_screen, menu);
		return true;
	}
	
	/** This function changes the current activity displayed */
    public void goBandexScreen(View view) {
    	Intent intent = new Intent(this, GoBandejar.class);
    	startActivity(intent);
    }
}
