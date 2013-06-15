package com.example.puzzlemenutest.game;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

import com.example.puzzlemenutest.R;
import com.example.puzzlemenutest.gameutils.SaverLoader;

public class FullImageActivity extends Activity {
	private ImageView fullImageView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fullimage_activity);
		fullImageView = (ImageView) findViewById(R.id.imageView);
		setPreview();
		SaverLoader.save("StartGame", Boolean.FALSE);
		fullImageView.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(FullImageActivity.this, PuzzlesActivity.class);
				startActivity(intent);
			}
		});
	}
	
	private void setPreview() {
		Bitmap bitmap = (Bitmap) SaverLoader.load("bitmap");
		Drawable drawable = new BitmapDrawable(getResources(), bitmap);
		setPreview(drawable);
	}

	@SuppressLint("NewApi")
	@SuppressWarnings("deprecation")
	private void setPreview(Drawable drawable) {
		if (Build.VERSION.SDK_INT < 16) {
			fullImageView.setBackgroundDrawable(drawable);
		} else {
			fullImageView.setBackground(drawable);
		}
	}
}
