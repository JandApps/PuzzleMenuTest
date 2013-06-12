package com.example.puzzlemenutest;

import java.util.ArrayList;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RadioButton;
import android.widget.TextView;

public class NewGameActivity extends Activity {
	private static int[] textViewsIds = { R.id.tvDificulty, R.id.tvGallery };
	private static int[] rbIds = { R.id.rbEasy, R.id.rbMedium, R.id.rbHard };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setFullscreen();
		setContentView(R.layout.new_game);
		loadFont("Crystal.otf");
		
		for (TextView textView : getTextViews(textViewsIds)) {
			if(textView.getId() != R.id.tvDificulty) {
				textView.setOnClickListener(getOnClickListener(getApplicationContext()));
			}
		}
	}
	
	public void setFullscreen() {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
	}

	public OnClickListener getOnClickListener(final Context context) {

		OnClickListener listener = new OnClickListener() {

			@SuppressLint("ShowToast")
			@Override
			public void onClick(View v) {
				int id = v.getId();

				switch (id) {

				case R.id.tvGallery:
				case R.id.ivGallery: {
					// Toast.makeText(context, "You didn't pay for it...", Toast.LENGTH_SHORT).show();
					// кнопка неактивна, поэтому ничего не делает
					
					break;
				}
				}

				Animation anim = AnimationUtils.loadAnimation(context, R.anim.click_anim);
				v.startAnimation(anim);
			}
		};

		return listener;
	}

	private void loadFont(String fontName) {
		Typeface font = Typeface.createFromAsset(getAssets(), "fonts/"+ fontName);
		
		ArrayList<TextView> textViews = getTextViews(textViewsIds);
		ArrayList<RadioButton> radioButtons = getRadioButtons(rbIds);
		
		for (TextView textView : textViews) {
			textView.setTypeface(font);
		}
		
		for(RadioButton radioButton : radioButtons) {
			radioButton.setTypeface(font);
		}
	}

	private ArrayList<TextView> getTextViews(int[] textViewsIds) {
		ArrayList<TextView> textViewList = new ArrayList<TextView>();

		for (int tvId : textViewsIds) {
			Log.d("SEVAK_DEBUG", String.valueOf(tvId));
				
			TextView textViews = (TextView) findViewById(tvId);
			textViewList.add(textViews);

		}

		return textViewList;
	}
	
	private ArrayList<RadioButton> getRadioButtons(int[] rbIds) {
		ArrayList<RadioButton> rbList = new ArrayList<RadioButton>();

		for (int rbId : rbIds) {
			RadioButton rb = (RadioButton) findViewById(rbId);
			rbList.add(rb);
		}

		return rbList;
	}

}
