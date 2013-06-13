package com.example.puzzlemenutest.refactor.main_activity;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.puzzlemenutest.R;
import com.example.puzzlemenutest.util.Util;

public class MainActivity extends Activity {
	
	private static Typeface textFont;
	private static OnMainMenuClickListener listener;
	
	private int[] textViewIds = {R.id.tvPlay, R.id.tvLoad, R.id.tvRating, R.id.tvPaid };
	private int[] imageViewIds = {R.id.ivPlay, R.id.ivLoad, R.id.ivRating, R.id.ivPaid};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);		
		setContentView(R.layout.main_menu);
		
		initMenuViews();
	}
	
	private void initMenuViews(){
		listener = new OnMainMenuClickListener(this);
		textFont = Util.loadFont(this, "Crystal.otf");
		
		initTextViews();
		initImageViews();
	}

	private void initTextViews() {		
		for (int tvId : textViewIds) {
			TextView tv = (TextView) findViewById(tvId);
			tv.setOnClickListener(listener);
			tv.setTypeface(textFont);
		}
	}
	
	private void initImageViews() {		
		for (int ivId : imageViewIds) {
			ImageView iv = (ImageView) findViewById(ivId);
			iv.setOnClickListener(listener);
		}
	}

}
