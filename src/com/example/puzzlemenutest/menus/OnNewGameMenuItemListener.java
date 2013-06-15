package com.example.puzzlemenutest.menus;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

import com.example.puzzlemenutest.PaymentUtils;
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
		case R.id.ivGallery: 
			onGalleryClick(v);
			break;
		}
	}

	private void onGalleryClick(View v) {
		if (PaymentUtils.extraFeaturesHaveBeenPaid()) {
			v.startAnimation(anim);
			activity.onGallery();
		} else {
			Toast.makeText(activity, "Availabled only for gold account", Toast.LENGTH_SHORT)
				.show();
		}
	}
}
