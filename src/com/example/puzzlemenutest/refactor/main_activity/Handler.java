package com.example.puzzlemenutest.refactor.main_activity;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

import com.example.puzzlemenutest.R;
import com.example.puzzlemenutest.refactor.new_game_activity.NewGameActivity;

public class Handler {
	public static OnClickListener getOnClickListener(final Context context) {
		final Animation anim = AnimationUtils.loadAnimation(context, R.anim.click_anim);
		
		OnClickListener listener = new OnClickListener() {

			@Override
			public void onClick(View v) {
				int id = v.getId();
				
				v.startAnimation(anim);
				
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
			}
		};

		return listener;
	}
}
