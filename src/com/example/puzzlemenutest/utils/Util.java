package com.example.puzzlemenutest.utils;
import java.util.ArrayList;

import android.content.Context;
import android.graphics.Typeface;
import android.widget.RadioButton;
import android.widget.TextView;


public class Util {
	
	public static void loadFont(ArrayList<TextView> textViews, Context context, String fontName) {
		Typeface font = Typeface.createFromAsset(context.getAssets(), "fonts/"+ fontName);
		
		for (TextView textView : textViews) {
			textView.setTypeface(font);
		}
	}
	

	public static void loadFont(ArrayList<TextView> textViews, ArrayList<RadioButton> radioButtons, Context context, String fontName) {
		Typeface font = Typeface.createFromAsset(context.getAssets(), "fonts/"+ fontName);
		
		for (TextView textView : textViews) {
			textView.setTypeface(font);
		}
		
		for(RadioButton radioButton : radioButtons) {
			radioButton.setTypeface(font);
		}
	}
}
