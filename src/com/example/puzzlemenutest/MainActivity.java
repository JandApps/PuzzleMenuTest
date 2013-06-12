package com.example.puzzlemenutest;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	private static int[] textViewsIds = {R.id.tvPlay, R.id.tvLoad, R.id.tvRating, R.id.tvPaid };
	private static int[] imageViewIds = {R.id.ivPlay, R.id.ivLoad, R.id.ivRating, R.id.ivPaid};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_menu);

		loadFont("Crystal.otf");

		for (TextView textView : getTextViews(textViewsIds)) {
			textView.setOnClickListener(getOnClickListener(this));
		}
		
		for(ImageView imageView : getImageViews(imageViewIds)) {
			imageView.setOnClickListener(getOnClickListener(this));
		}
	}

	public OnClickListener getOnClickListener(final Context context) {

		OnClickListener listener = new OnClickListener() {

			@Override
			public void onClick(View v) {
				int id = v.getId();

				switch (id) {
				case R.id.tvPlay:
				case R.id.ivPlay: { 
					Intent intent = new Intent(context, NewGameActivity.class);
					context.startActivity(intent);
					
					break;
				}
				
				case R.id.tvLoad:
				case R.id.ivLoad:{
					Toast.makeText(context, "Loading game...", Toast.LENGTH_SHORT).show();
					
					//Intent intent = new Intent(context, ContinueActivity.class);
					//context.startActivity(intent);
					
					break;
				}
				
				case R.id.tvRating:
				case R.id.ivRating:{
					Toast.makeText(context, "Showing rating...", Toast.LENGTH_SHORT).show();
					
					//Intent intent = new Intent(context, RatingActivity.class);
					//context.startActivity(intent);
					
					break;
				}
				
				case R.id.tvPaid:
				case R.id.ivPaid:{
					Toast.makeText(context, "Showing paid features...", Toast.LENGTH_SHORT).show();
					
					//Intent intent = new Intent(context, PaidFeaturesActivity.class);
					//context.startActivity(intent);
					
					break;
				}

				}

				Animation anim = AnimationUtils.loadAnimation(context, R.anim.click_anim);
				v.startAnimation(anim);
			}
		};

		return listener;
	}

	private void loadFont(String fontName) {
		Typeface font = Typeface.createFromAsset(getAssets(), "fonts/"
				+ fontName);
		ArrayList<TextView> textViews = getTextViews(textViewsIds);

		for (TextView textView : textViews) {
			textView.setTypeface(font);
		}
	}

	private ArrayList<TextView> getTextViews(int[] textViewsId) {
		ArrayList<TextView> textViewList = new ArrayList<TextView>();

		for (int tvId : textViewsId) {
			TextView textViews = (TextView) findViewById(tvId);
			textViewList.add(textViews);

		}

		return textViewList;
	}
	
	private ArrayList<ImageView> getImageViews(int[] imageViewIds) {
		ArrayList<ImageView> imageViewList = new ArrayList<ImageView>();

		for (int ivId : imageViewIds) {
			ImageView imageView = (ImageView) findViewById(ivId);
			imageViewList.add(imageView);

		}

		return imageViewList;
	}

}
