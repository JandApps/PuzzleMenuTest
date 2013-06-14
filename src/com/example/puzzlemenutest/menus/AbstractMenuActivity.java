package com.example.puzzlemenutest.menus;

import android.app.Activity;
import android.os.Bundle;
import android.view.View.OnClickListener;

public abstract class AbstractMenuActivity extends Activity {
	
	private static OnClickListener listener;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(getLayoutId());
		
		listener = createOnClickListener();
		initMenuItems();
		otherActions();
	}

	protected abstract int getLayoutId();
	protected abstract OnClickListener createOnClickListener();
	
	private void initMenuItems() {
		int[] textViewsIds = getMenuItemsTextViewsIds();
		int[] imageViewsIds = getMenuItemsImagetViewsIds();
		int numberOfItems = textViewsIds.length;
		for (int i = 0; i < numberOfItems; ++i) {
			findViewById(textViewsIds[i]).setOnClickListener(listener);
			findViewById(imageViewsIds[i]).setOnClickListener(listener);
		}
	}

	protected abstract int[] getMenuItemsTextViewsIds();
	protected abstract int[] getMenuItemsImagetViewsIds();
	
	protected void otherActions() {
		// By default - do nothing
	}
	
}
