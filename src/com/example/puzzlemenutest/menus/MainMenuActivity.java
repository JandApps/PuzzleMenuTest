package com.example.puzzlemenutest.menus;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

import com.example.puzzlemenutest.R;

public class MainMenuActivity extends Activity {

	private static final int[] itemsIds = new int[] {
			R.id.playItem, R.id.loadItem, R.id.ratingItem, R.id.paidItem
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_menu_activity);
		
		initMenuItems();
	}

	private void initMenuItems() {
		OnClickListener listener = new OnMainMenuItemClickListener(this);
		for (int i = 0; i < itemsIds.length; ++i) {
			findViewById(itemsIds[i]).setOnClickListener(listener);
		}
	}

	@Override
	protected void onResume() {
		super.onResume();
		if (PaymentUtils.extraFeaturesHaveBeenPaid()) {
			hidePaidFeaturesItem();
		}
	}

	private void hidePaidFeaturesItem() {
		findViewById(R.id.paidItem).setVisibility(View.INVISIBLE);
	}
}
