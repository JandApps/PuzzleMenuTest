package com.example.puzzlemenutest.game;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.Toast;

import com.example.puzzlemenutest.R;
import com.example.puzzlemenutest.gameutils.SaverLoader;
import com.example.puzzlemenutest.puzzlesview.OnPuzzleAssembledListener;
import com.example.puzzlemenutest.puzzlesview.PuzzlesView;
import com.example.puzzlemenutest.rating.RatingActivity;
import com.example.puzzlemenutest.utils.Dimension;

public class PuzzlesActivity extends Activity implements OnPuzzleAssembledListener {

	private PuzzlesView puzzlesView;
	private boolean first = true;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_puzzles);
		puzzlesView = (PuzzlesView) findViewById(R.id.puzzlesView);
		puzzlesView.addOnPuzzleAssembledListener(this);
	}

	@Override
	public void onGameFinished() {
		SaverLoader.save("GameFinished", Boolean.TRUE);
		Toast.makeText(this, "Excellent!", Toast.LENGTH_SHORT).show();
		Intent intent = new Intent(this, RatingActivity.class);
		startActivityForResult(intent, 1234);
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		finish();
	}
	
	@Override
	public void onWindowFocusChanged(boolean hasFocus) {
		super.onWindowFocusChanged(hasFocus);
		if (hasFocus && first) {
			initPuzzles();
			first = false;
		}
	}

	private void initPuzzles() {
		Bitmap bitmap = (Bitmap) SaverLoader.load("bitmap");
		Dimension dim = (Dimension) SaverLoader.load("dim");
		puzzlesView.set(bitmap, dim);
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		puzzlesView.releaseImageResources();
	}

}
