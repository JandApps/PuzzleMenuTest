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

public class Handler implements OnClickListener {
	private Context context;
	private Animation anim;
	
	public Handler(Context context) {
		this.context = context;
		anim = AnimationUtils.loadAnimation(context, R.anim.click_anim);
	}
			

	@Override
	public void onClick(View v) {		
		v.startAnimation(anim);
		
		switch (v.getId()) {
		case R.id.tvPlay:
		case R.id.ivPlay: 
			Intent intent = new Intent(context, NewGameActivity.class);
			context.startActivity(intent);
			break;
		
		
		case R.id.tvLoad:
		case R.id.ivLoad:
			Toast.makeText(context, "Loading game...", Toast.LENGTH_SHORT).show();
			break;
		
		
		case R.id.tvRating:
		case R.id.ivRating:
			Toast.makeText(context, "Showing rating...", Toast.LENGTH_SHORT).show();
			break;
		
		
		case R.id.tvPaid:
		case R.id.ivPaid:
			Toast.makeText(context, "Showing paid features...", Toast.LENGTH_SHORT).show();
			break;
		

		}
	}
}
