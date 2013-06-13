package com.example.puzzlemenutest.menus;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.example.puzzlemenutest.R;

public class OnNewGameMenuItemListener implements OnClickListener {
	private NewGameMenuActivity activity;
	private Animation anim;
	
	public OnNewGameMenuItemListener(NewGameMenuActivity activity) {
		anim = AnimationUtils.loadAnimation(activity, R.anim.click_anim);
		this.activity = activity;
	}

	public void onClick(View v) {		
		switch (v.getId()) {
		case R.id.tvGallery:
		case R.id.ivGallery: 
			v.startAnimation(anim);
			activity.onGallery();
			break;
		}
	}
}
