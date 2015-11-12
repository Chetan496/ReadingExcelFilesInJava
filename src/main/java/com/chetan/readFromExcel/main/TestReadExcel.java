package com.chetan.readFromExcel.main;

import java.io.IOException;
import java.util.List;

import com.chetan.readFromExcel.models.FavoriteSubject;

public class TestReadExcel {

	public TestReadExcel() {
		// TODO Auto-generated constructor stub
	}

	/*
	 * ReadExcelUtils is the main class where you can find the code implemented
	 * for reading from Excel files. We are using Apache POI for reading from
	 * Excel files.
	 */
	public static void main(String[] args) throws IOException {
		/*
		 * Replace the file path in your code..
		 */
		String excelFilePath = "/home/MAC/Documents/favSubjects.xlsx";
		List<FavoriteSubject> subjects = ReadExcelUtils
				.readBooksFromExcelFile(excelFilePath);

		System.out.println(subjects);

	}

}
