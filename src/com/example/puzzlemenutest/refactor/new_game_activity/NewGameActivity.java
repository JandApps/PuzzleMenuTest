package com.example.puzzlemenutest.refactor.new_game_activity;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.puzzlemenutest.R;
import com.example.puzzlemenutest.util.Util;

public class NewGameActivity extends Activity {
	
	private static OnNewGameClickListener listener;
	private static Typeface textFont;

	private int[] textViewsIds = { R.id.tvDificulty, R.id.tvGallery };
	private int[] radioButtonIds = { R.id.rbEasy, R.id.rbMedium, R.id.rbHard };
	private int[] imageViewIds = { R.id.ivGallery, R.id.ivPreview_1,
			R.id.ivPreview_2, R.id.ivPreview_3, R.id.ivPreview_4,
			R.id.ivPreview_5 };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.new_game);

		initMenuViews();
	}

	private void initMenuViews() {
		listener = new OnNewGameClickListener(this);
		textFont = Util.loadFont(this, "Crystal.otf");
		
		initTextViews();
		initRadioButtons();
		initImageViews();
	}

	private void initTextViews() {
		for (int tvId : textViewsIds) {
			TextView tv = (TextView) findViewById(tvId);
			tv.setTypeface(textFont);
			
			if(tvId != R.id.tvDificulty){
				tv.setOnClickListener(listener);
			}
		}
	}

	private void initRadioButtons() {
		for (int rbId : radioButtonIds) {
			RadioButton rb = (RadioButton) findViewById(rbId);
			rb.setOnClickListener(listener);
			rb.setTypeface(textFont);
		}
	}

	private void initImageViews() {

		for (int ivId : imageViewIds) {
			ImageView iv = (ImageView) findViewById(ivId);
			iv.setOnClickListener(listener);
		}
	}

}
