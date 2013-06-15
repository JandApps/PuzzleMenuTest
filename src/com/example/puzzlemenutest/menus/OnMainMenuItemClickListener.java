package com.example.puzzlemenutest.menus;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

import com.example.puzzlemenutest.R;

public class OnMainMenuItemClickListener implements OnClickListener {
	private Context context;
	private Animation anim;
	
	public OnMainMenuItemClickListener(Context context) {
		this.context = context;
		anim = AnimationUtils.loadAnimation(context, R.anim.click_anim);
	}

	@Override
	public void onClick(View v) {
		v.startAnimation(anim);
		switch (v.getId()) {
		case R.id.playItem:
			onPlayClick();
			break;
		
		case R.id.loadItem:
			onLoadClick();
			break;

		case R.id.ratingItem:
			onRatingClick();
			break;
		
		case R.id.paidItem:
			onPaidClick();
			break;
		}
	}
	
	private void onPlayClick() {
		Intent intent = new Intent(context, NewGameMenuActivity.class);
		context.startActivity(intent);
	}

	private void onLoadClick() {
		// TODO Auto-generated method stub
		Toast.makeText(context, "Loading game...", Toast.LENGTH_SHORT).show();
	}
	
	private void onRatingClick() {
		// TODO Auto-generated method stub
		Toast.makeText(context, "Showing rating...", Toast.LENGTH_SHORT).show();
	}

	private void onPaidClick() {
		// TODO Auto-generated method stub
		Toast.makeText(context, "Showing paid features...", Toast.LENGTH_SHORT).show();
	}
}
