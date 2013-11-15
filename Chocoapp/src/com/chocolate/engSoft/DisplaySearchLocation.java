package com.chocolate.engSoft;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class DisplaySearchLocation extends Activity {

	    @Override
		public void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);

			// Get the message from the intent
			Intent intent = getIntent();
			String message = intent.getStringExtra(SearchLocation.EXTRA_MESSAGE);

			// Create the text view
			TextView textView = new TextView(this);
			textView.setTextSize(40);
			textView.setText(message);

			// Set the text view as the activity layout
			setContentView(textView);
		}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.display_search_location, menu);
		return true;
	}

}