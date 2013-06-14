package com.example.puzzlemenutest.menus;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View.OnClickListener;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.puzzlemenutest.DimensionLoader;
import com.example.puzzlemenutest.PaymentUtils;
import com.example.puzzlemenutest.R;
import com.example.puzzlemenutest.SaverLoader;
import com.example.puzzlemenutest.GameActivity;
import com.example.puzzlemenutest.util.Dimension;

public class NewGameMenuActivity extends AbstractMenuActivity {
	private int[] menuItemsTextViewsIds = { R.id.tvGallery };
	private int[] menuItemsImageViewsIds = { R.id.ivGallery };
	private int[] imageViewIds = { R.id.ivPreview_1, R.id.ivPreview_2,
			R.id.ivPreview_3, R.id.ivPreview_4, R.id.ivPreview_5 };

	@Override
	protected int getLayoutId() {
		return R.layout.new_game_menu_activity;
	}

	@Override
	protected OnClickListener createOnClickListener() {
		return new OnNewGameMenuItemListener(this);
	}

	@Override
	protected int[] getMenuItemsTextViewsIds() {
		return menuItemsTextViewsIds;
	}

	@Override
	protected int[] getMenuItemsImagetViewsIds() {
		return menuItemsImageViewsIds;
	}

	@Override
	protected void otherActions() {
		OnPickImageListener listener = new OnPickImageListener(this);
		for (int id : imageViewIds) {
			findViewById(id).setOnClickListener(listener);
		}
	}

	@Override
	protected void onResume() {
		super.onResume();
		if (!PaymentUtils.extraFeaturesHaveBeenPaid()) {
			disableExtraFeatures();
		}
	}

	private void disableExtraFeatures() {
		findViewById(R.id.tvGallery).setEnabled(false);
		findViewById(R.id.ivGallery).setEnabled(false);
	}

	public void startGame(int imageId) {
		Bitmap bitmap = BitmapFactory.decodeResource(getResources(), imageId);
		startGame(bitmap);
	}

	private void startGame(Bitmap bitmap) {
		SaverLoader.save("bitmap", bitmap);
		SaverLoader.save("dim", dimensionByCurrentDifficulty());
		Intent intent = new Intent(this, GameActivity.class);
		startActivity(intent);
	}

	private Dimension dimensionByCurrentDifficulty() {
		DimensionLoader loader = new DimensionLoader(getResources());
		return loader.dimension(getDifficultyName());
	}

	private String getDifficultyName() {
		RadioGroup radioGroup = (RadioGroup) findViewById(R.id.rbDificultMode);
		int checkedId = radioGroup.getCheckedRadioButtonId();
		RadioButton radioButton = (RadioButton) radioGroup.findViewById(checkedId);
		String difficultyName = radioButton.getText().toString();
		return difficultyName;
	}

	public void onGallery() {
		// TODO: Открыть галерею, и если пользователь выберет изображение,
		// начать игру с этим изображением, а если изображение не удовлетворяет критериям,
		// то сообщить пользователю об этом
	}
}
