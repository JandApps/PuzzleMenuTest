package com.example.puzzlemenutest.rating;

import com.example.puzzlemenutest.R;
import com.example.puzzlemenutest.R.layout;
import com.example.puzzlemenutest.R.menu;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class RatingActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_rating);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.rating, menu);
		return true;
	}

}
