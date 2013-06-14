package com.example.puzzlemenutest.menus;

import android.view.View.OnClickListener;

import com.example.puzzlemenutest.R;

public class MainMenuActivity extends MenuActivity {	
	private int[] textViewsIds = { R.id.tvPlay, R.id.tvLoad, R.id.tvRating, R.id.tvPaid };
	private int[] imageViewsIds = { R.id.ivPlay, R.id.ivLoad, R.id.ivRating, R.id.ivPaid };

	@Override
	protected int getLayoutId() {
		return R.layout.main_menu_activity;
	}

	@Override
	protected OnClickListener createOnClickListener() {
		return new OnMainMenuItemClickListener(this);
	}

	@Override
	protected int[] getMenuItemsTextViewsIds() {
		return textViewsIds;
	}

	@Override
	protected int[] getMenuItemsImagetViewsIds() {
		return imageViewsIds;
	}

}
