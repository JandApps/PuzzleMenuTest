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
		case R.id.tvPlay:
		case R.id.ivPlay: 
			Intent intent = new Intent(context, NewGameMenuActivity.class);
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
