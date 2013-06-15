package com.example.puzzlemenutest;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.puzzlemenutest.util.Dimension;

public class GameActivity extends Activity {
	private ImageView fullImageView;
	private PuzzlesView puzzlesView;
	private ImageButton toPuzzlesButton;
	private ImageButton toFullImageButton;
	private boolean gameStarted;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.game_activity);
		findViews();
		setPreview();
		setListeners();
	}

	private void findViews() {
		puzzlesView = (PuzzlesView) findViewById(R.id.puzzlesView);
		fullImageView = (ImageView) findViewById(R.id.imageView);
		toPuzzlesButton = (ImageButton) findViewById(R.id.toPuzzlesButton);
		toFullImageButton = (ImageButton) findViewById(R.id.toFullImageButton);
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

	private void setListeners() {
		puzzlesView.addOnPuzzleAssembledListener(new OnPuzzleAssembledListener() {
			@Override
			public void onGameFinished() {
				onPuzzleAssembled();
			}
		});
		toPuzzlesButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				onStartGame();
			}
		});
		toFullImageButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				onReturnToFullImage();
			}
		});
	}

	private void onStartGame() {
		resetScreen(View.INVISIBLE, View.VISIBLE);
		if (!gameStarted) {
			setPuzzles();
		}
		gameStarted = true;
	}

	private void resetScreen(int previewVisibility, int puzzlesVisibility) {
		changeVisibility(previewVisibility, fullImageView, toPuzzlesButton);
		changeVisibility(puzzlesVisibility, puzzlesView, toFullImageButton);
	}

	private void setPuzzles() {
		Bitmap bitmap = (Bitmap) SaverLoader.load("bitmap");
		Dimension dim = (Dimension) SaverLoader.load("dim");
		puzzlesView.set(bitmap, dim);
	}

	private void changeVisibility(int visibility, View... views) {
		for (View each : views) {
			each.setVisibility(visibility);
		}
	}

	private void onPuzzleAssembled() {
		Toast.makeText(GameActivity.this, "Excellent", Toast.LENGTH_SHORT).show();
		gameStarted = false;
		onPreview();
	}

	private void onPreview() {
		resetScreen(View.VISIBLE, View.INVISIBLE);
	}
	

	private void onReturnToFullImage() {
		onPreview();
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		puzzlesView.releaseImageResources();
	}

}
