package com.chocolate.engSoft;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

public class SearchLocation extends Activity {

	public final static String EXTRA_MESSAGE = "com.chocolate.engSoft.MESSAGE";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_search_location);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.search_location, menu);
		return true;
	}
	
	/** This function changes the current activity displayed */
    public void backToMap(View view) {
    	Intent intent = new Intent(this, MainActivity.class);
    	startActivity(intent);
    }
    
    public void sendSearch(View view) {
        Intent intent = new Intent(this, DisplaySearchLocation.class);
        EditText editText = (EditText) findViewById(R.id.txt_buscar);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    
}