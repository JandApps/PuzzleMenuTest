package com.example.puzzlemenutest.menus;

import android.view.View;
import android.view.View.OnClickListener;

import com.example.puzzlemenutest.R;

public class OnPickImageListener implements OnClickListener {

	@Override
	public void onClick(View v) {
		NewGameMenuActivity activity = (NewGameMenuActivity) v.getContext();
		switch (v.getId()) {
		case R.id.ivPreview_1:
			activity.startGame(R.drawable.animal_1);
			break;
			
		case R.id.ivPreview_2:
			activity.startGame(R.drawable.animal_2);
			break;
			
		case R.id.ivPreview_3:
			activity.startGame(R.drawable.nature_1);
			break;
			
		case R.id.ivPreview_4:
			activity.startGame(R.drawable.nature_2);
			break;
			
		case R.id.ivPreview_5:
			activity.startGame(R.drawable.nature_3);
			break;
		}
	}
}
