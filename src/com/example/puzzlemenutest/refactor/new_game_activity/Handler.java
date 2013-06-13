package com.example.puzzlemenutest.refactor.new_game_activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

import com.example.puzzlemenutest.R;

public class Handler {
	// �� ��������� ������ ��������
	private static int clickedImageId = 1;
	
	public static OnClickListener getOnClickListener(final Context context) {
		final Animation anim = AnimationUtils.loadAnimation(context, R.anim.click_anim);
		
		OnClickListener listener = new OnClickListener() {

			@SuppressLint("ShowToast")
			@Override
			public void onClick(View v) {
				int id = v.getId();
				
				switch (id) {
				
				case R.id.tvGallery:
				case R.id.ivGallery: {
					Toast.makeText(context, "You didn't pay for it...", Toast.LENGTH_SHORT).show();
					v.startAnimation(anim);
					break;
				}
				
				case R.id.rbEasy:{
					Toast.makeText(context, "Choosed difficulty mode: Easy", Toast.LENGTH_SHORT).show();
					break;
				}
				case R.id.rbMedium:{
					Toast.makeText(context, "Choosed difficulty mode: Medium", Toast.LENGTH_SHORT).show();
					break;
				}
				case R.id.rbHard:{
					Toast.makeText(context, "Choosed difficulty mode: Hard", Toast.LENGTH_SHORT).show();
					break;
				}
				
				case R.id.ivPreview_1:{
					clickedImageId = 1;
					Toast.makeText(context, "You click on image... id = " + clickedImageId, Toast.LENGTH_SHORT).show();
					break;
				}
				
				case R.id.ivPreview_2:{
					clickedImageId = 2;
					Toast.makeText(context, "You click on image... id = " + clickedImageId, Toast.LENGTH_SHORT).show();
					break;
				}
				
				case R.id.ivPreview_3:{
					clickedImageId = 3;
					Toast.makeText(context, "You click on image... id = " + clickedImageId, Toast.LENGTH_SHORT).show();
					break;
				}
				
				case R.id.ivPreview_4:{
					clickedImageId = 4;
					Toast.makeText(context, "You click on image... id = " + clickedImageId, Toast.LENGTH_SHORT).show();
					break;
				}
				
				case R.id.ivPreview_5:{
					clickedImageId = 5;
					Toast.makeText(context, "You click on image... id = " + clickedImageId, Toast.LENGTH_SHORT).show();
					break;
				}
		
				}
			}
		};

		return listener;
	}
	
	public static int getClickedImageId(){
		return clickedImageId;
	}
}
