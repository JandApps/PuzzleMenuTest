package com.example.puzzlemenutest.menus;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View.OnClickListener;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.puzzlemenutest.DimensionLoader;
import com.example.puzzlemenutest.R;
import com.example.puzzlemenutest.SaverLoader;
import com.example.puzzlemenutest.StarterActivity;
import com.example.puzzlemenutest.util.Dimension;

public class NewGameMenuActivity extends MenuActivity {
	private int[] menuItemsTextViewsIds = { R.id.tvGallery };
	private int[] menuItemsImageViewsIds = { R.id.ivGallery };
	private int[] imageViewIds = { R.id.ivPreview_1, R.id.ivPreview_2,
			R.id.ivPreview_3, R.id.ivPreview_4, R.id.ivPreview_5 };

	@Override
	protected int getLayoutId() {
		return R.layout.new_game;
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
		// TODO:
		OnPickImageListener listener = new OnPickImageListener(this);
		for (int id : imageViewIds) {
			findViewById(id).setOnClickListener(listener);
		}
	}

	public void startGame(int imageId) {
		DimensionLoader loader = new DimensionLoader(getResources());
		Dimension dim = loader.dimension(getDifficultyName());

		Bitmap bitmap = BitmapFactory.decodeResource(getResources(), imageId);
		startGame(bitmap, dim);
	}

	private void startGame(Bitmap bitmap, Dimension dim) {
		SaverLoader.save("bitmap", bitmap);
		SaverLoader.save("dim", dim);
		Intent intent = new Intent(this, StarterActivity.class);
		startActivity(intent);
	}

	private String getDifficultyName() {
		RadioGroup radioGroup = (RadioGroup) findViewById(R.id.rbDificultMode);
		int checkedId = radioGroup.getCheckedRadioButtonId();
		RadioButton radioButton = (RadioButton) radioGroup.findViewById(checkedId);
		String difficultyName = radioButton.getText().toString();
		return difficultyName;
	}

	public void onGallery() {
		// TODO: Предоставление пользователю возможности загрузки из галереи
	}
}
