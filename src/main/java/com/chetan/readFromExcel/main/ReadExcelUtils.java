package com.chetan.readFromExcel.main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.chetan.readFromExcel.models.FavoriteSubject;

public class ReadExcelUtils {

	public ReadExcelUtils() {
		// TODO Auto-generated constructor stub
	}

	private static Workbook getWorkbook(FileInputStream inputStream,
			String excelFilePath) throws IOException {
		Workbook workbook = null;

		if (excelFilePath.endsWith("xlsx")) {
			workbook = new XSSFWorkbook(inputStream);
		} else if (excelFilePath.endsWith("xls")) {
			workbook = new HSSFWorkbook(inputStream);
		} else {
			throw new IllegalArgumentException(
					"The specified file is not Excel file");
		}

		return workbook;
	}

	private static Object getCellValue(Cell cell) {
		switch (cell.getCellType()) {
		case Cell.CELL_TYPE_STRING:
			return cell.getStringCellValue();
		case Cell.CELL_TYPE_BOOLEAN:
			return cell.getBooleanCellValue();
		case Cell.CELL_TYPE_NUMERIC:
			return cell.getNumericCellValue();
		}

		return null;
	}

	private static FileInputStream getInputStreamFromExcelFile(
			String excelFilePath) {
		FileInputStream inputStream = null;
		try {
			inputStream = new FileInputStream(new File(excelFilePath));
		} catch (FileNotFoundException e) {
			System.out
					.println("\n Error while getting a Input Stream from the Excel file");
			e.printStackTrace();
		}
		return inputStream;
	}

	public static List<FavoriteSubject> readBooksFromExcelFile(
			String excelFilePath) throws IOException {

		List<FavoriteSubject> listFavSubjects = new ArrayList<>();
		FileInputStream inputStream = getInputStreamFromExcelFile(excelFilePath);

		Workbook workbook = getWorkbook(inputStream, excelFilePath);
		Sheet firstSheet = workbook.getSheetAt(0);
		Iterator<Row> iterator = firstSheet.iterator();

		while (iterator.hasNext()) {

			Row nextRow = iterator.next();
			Iterator<Cell> cellIterator = nextRow.cellIterator();
			FavoriteSubject subject = new FavoriteSubject();

			while (cellIterator.hasNext()) {
				Cell nextCell = cellIterator.next();
				int columnIndex = nextCell.getColumnIndex();

				switch (columnIndex) {
				case 0:
					subject.setStudentName((String) getCellValue(nextCell));
					break;
				case 1:
					subject.setSubjectName((String) getCellValue(nextCell));
					break;
				}
			}

			listFavSubjects.add(subject);
		}

		workbook.close();
		inputStream.close();

		return listFavSubjects;

	}
}
