package com.example.puzzlemenutest.refactor.main_activity;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.puzzlemenutest.R;
import com.example.puzzlemenutest.utils.Util;

public class MainActivity extends Activity {
	
	private static ArrayList<TextView> textViews;
	private static ArrayList<ImageView> imageViews;
	
	private static OnClickListener listener;
	
	private int[] textViewIds = {R.id.tvPlay, R.id.tvLoad, R.id.tvRating, R.id.tvPaid };
	private int[] imageViewIds = {R.id.ivPlay, R.id.ivLoad, R.id.ivRating, R.id.ivPaid};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);		
		setContentView(R.layout.main_menu);
		
		initViews();
		Util.loadFont(textViews, this, "Crystal.otf");
	}
	
	private void initViews(){
		listener = Handler.getOnClickListener(this);
		
		initTextViews();
		initImageViews();
	}

	private void initTextViews() {
		textViews = new ArrayList<TextView>();
		for (int tvId : textViewIds) {
			TextView tv = (TextView) findViewById(tvId);
			tv.setOnClickListener(listener);
			textViews.add(tv);
		}
	}
	
	private void initImageViews() {
		imageViews = new ArrayList<ImageView>();
		
		for (int ivId : imageViewIds) {
			ImageView iv = (ImageView) findViewById(ivId);
			iv.setOnClickListener(listener);
			imageViews.add(iv);
		}
	}

}
