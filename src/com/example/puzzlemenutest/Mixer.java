package com.example.puzzlemenutest;
import java.util.Random;

import android.graphics.Bitmap;

import com.example.puzzlemenutest.util.Matrix;
import com.example.puzzlemenutest.util.Matrix.Position;

public class Mixer {
	private Random random;
	
	public void mix(Matrix<Bitmap> puzzles) {
		random = new Random(System.nanoTime());

		int numberOfSwaps = numberOfSwaps(puzzles);
		for (int i = 0; i < numberOfSwaps; ++i) {
			puzzles.swap(generateRandomPosition(puzzles), generateRandomPosition(puzzles));
		}
	}

	private int numberOfSwaps(Matrix<Bitmap> puzzles) {
		return puzzles.rows * puzzles.columns * 2;
	}

	private Position generateRandomPosition(Matrix<Bitmap> puzzles) {
		int row = random.nextInt(puzzles.rows);
		int column = random.nextInt(puzzles.columns);
		return new Position(row, column);
	}
}
