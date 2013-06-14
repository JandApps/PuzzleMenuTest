package com.example.puzzlemenutest.menus;

import android.view.View;
import android.view.View.OnClickListener;

import com.example.puzzlemenutest.PaymentUtils;
import com.example.puzzlemenutest.R;

public class MainMenuActivity extends AbstractMenuActivity {

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

	@Override
	protected void onResume() {
		super.onResume();
		if (PaymentUtils.extraFeaturesHaveBeenPaid()) {
			hidePaidFeaturesItem();
		}
	}

	private void hidePaidFeaturesItem() {
		findViewById(R.id.ivPaid).setVisibility(View.INVISIBLE);
		findViewById(R.id.tvPaid).setVisibility(View.INVISIBLE);
	}

}
