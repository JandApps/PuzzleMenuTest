package com.example.puzzlemenutest.menus;

import java.io.File;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View.OnClickListener;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.puzzlemenutest.R;
import com.example.puzzlemenutest.game.FullImageActivity;
import com.example.puzzlemenutest.gameutils.DimensionLoader;
import com.example.puzzlemenutest.gameutils.SaverLoader;
import com.example.puzzlemenutest.utils.Dimension;

public class NewGameMenuActivity extends Activity {

	private final int[] previewsImageViewsIds = {
		R.id.ivPreview_1, R.id.ivPreview_2,
		R.id.ivPreview_3, R.id.ivPreview_4,
		R.id.ivPreview_5
	};
	
	private final int galleryMenuItemId = R.id.ivGallery;
	private final int PICK_IMAGE = 1234;
	private OnClickListener listener;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.new_game_menu_activity);
		
		listener = new OnNewGameMenuItemListener(this);
		setListeners();
	}

	private void setListeners() {
		findViewById(galleryMenuItemId).setOnClickListener(listener);
		OnPickImageListener listener = new OnPickImageListener(this);
		for (int id : previewsImageViewsIds) {
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
		findViewById(R.id.ivGallery).setEnabled(true);
	}

	public void startGame(int imageId) {
		Bitmap bitmap = BitmapFactory.decodeResource(getResources(), imageId);
		startGame(bitmap);
	}

	private void startGame(Bitmap bitmap) {
		SaverLoader.save("bitmap", bitmap);
		SaverLoader.save("dim", dimensionByCurrentDifficulty());
		Intent intent = new Intent(this, FullImageActivity.class);
		startActivity(intent);
	}

	private Dimension dimensionByCurrentDifficulty() {
		DimensionLoader loader = new DimensionLoader(getResources());
		return loader.dimension(getDifficultyName());
	}

	private String getDifficultyName() {
		RadioGroup radioGroup = (RadioGroup) findViewById(R.id.rbDificultMode);
		int checkedId = radioGroup.getCheckedRadioButtonId();
		RadioButton radioButton = (RadioButton) radioGroup
				.findViewById(checkedId);
		String difficultyName = radioButton.getText().toString();
		return difficultyName;
	}

	void onGallery() {
		Intent intent = new Intent();
		intent.setType("image/*");
		intent.setAction(Intent.ACTION_GET_CONTENT);
		startActivityForResult(Intent.createChooser(intent, "Select Picture"),
				PICK_IMAGE);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (resultCode == RESULT_OK && requestCode == PICK_IMAGE
				&& data != null) {
			Uri uri = data.getData();
			if (uri != null) {
				onImagePicked(uri);
			}
		}
	}

	private void onImagePicked(Uri uri) {
		String imageFilePath = imageFilePathByUri(uri);
		try {
			Bitmap bitmap = getBitmapByPath(imageFilePath);
			startGame(bitmap);
		} catch (Exception e) {
			String message = "Cannot load image. Please, choose other image.\n"
					+ e.getMessage();
			Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
		}
	}

	private String imageFilePathByUri(Uri uri) {
		String[] projection = new String[] { android.provider.MediaStore.Images.ImageColumns.DATA };
		Cursor cursor = getContentResolver().query(uri, projection, null, null,
				null);
		cursor.moveToFirst();
		String imageFilePath = cursor.getString(0);
		cursor.close();
		return imageFilePath;
	}

	private Bitmap getBitmapByPath(String imageFilePath) {
		File imgFile = new File(imageFilePath);
		return BitmapFactory.decodeFile(imgFile.getAbsolutePath());
	}
}
