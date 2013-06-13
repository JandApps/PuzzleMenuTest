package com.example.puzzlemenutest.refactor.new_game_activity;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.puzzlemenutest.R;
import com.example.puzzlemenutest.utils.Util;

public class NewGameActivity extends Activity {
	private static ArrayList<TextView> textViews;
	private static ArrayList<ImageView> imageViews;
	private static ArrayList<RadioButton> radioButtons;

	private static OnClickListener listener;

	private int[] textViewsIds = { R.id.tvDificulty, R.id.tvGallery };
	private int[] radioButtonIds = { R.id.rbEasy, R.id.rbMedium, R.id.rbHard };
	private int[] imageViewIds = { R.id.ivGallery, R.id.ivPreview_1,
			R.id.ivPreview_2, R.id.ivPreview_3, R.id.ivPreview_4,
			R.id.ivPreview_5 };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.new_game);

		initViews();
		Util.loadFont(textViews, radioButtons, this, "Crystal.otf");
	}

	private void initViews() {
		listener = Handler.getOnClickListener(this);

		initTextViews();
		initRadioButtons();
		initImageViews();
	}

	private void initTextViews() {
		textViews = new ArrayList<TextView>();

		for (int tvId : textViewsIds) {
			TextView tv = (TextView) findViewById(tvId);
			tv.setOnClickListener(listener);
			textViews.add(tv);
		}
	}

	private void initRadioButtons() {
		radioButtons = new ArrayList<RadioButton>();

		for (int rbId : radioButtonIds) {
			RadioButton rb = (RadioButton) findViewById(rbId);
			rb.setOnClickListener(listener);
			radioButtons.add(rb);
		}
	}

	private void initImageViews() {
		imageViews = new ArrayList<ImageView>();

		for (int ivId : imageViewIds) {
			ImageView iv = (ImageView) findViewById(ivId);
			iv.setOnClickListener(listener);
			imageViews.add(iv);
		}
	}

}
