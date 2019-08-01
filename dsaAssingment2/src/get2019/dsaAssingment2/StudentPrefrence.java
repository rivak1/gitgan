package get2019.dsaAssingment2;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class StudentPrefrence {
	ArrayList<String> Student = new ArrayList<String>();
	ArrayList<ArrayList<String>> Branches = new ArrayList<ArrayList<String>>();
	ArrayList<Student> StudentDetails = new ArrayList<Student>();

	public void readExcel() throws BiffException, IOException {
		String FilePath = "C:\\Users\\Rivak\\workspace\\dsaAssingment2\\Students.xls";
		FileInputStream fs = new FileInputStream(FilePath);
		Workbook wb = Workbook.getWorkbook(fs);

		// TO get the access to the sheet
		Sheet sh = wb.getSheet("Sheet1");

		// To get the number of rows present in sheet
		int totalNoOfRows = sh.getRows();

		// To get the number of columns present in sheet
		int totalNoOfCols = sh.getColumns();

		for (int row = 0; row < totalNoOfRows; row++) {
			Student.add(sh.getCell(0, row).getContents());
		}
		
		for (int row = 0; row < totalNoOfRows; row++) {
			ArrayList<String> innerList = new ArrayList<String>();
			for (int col = 1; col < totalNoOfCols; col++) {
				innerList.add(sh.getCell(col, row).getContents());
			}
			Branches.add(innerList);

		}

		for (int i = 0; i < totalNoOfRows; i++) {
			String name = Student.get(i);
			ArrayList<String> studentBranch = new ArrayList<String>();
			studentBranch = Branches.get(i);
			StudentDetails.add(this.addStudent(name, studentBranch));
		}

	}

	private Student addStudent(String name, ArrayList<String> studentBranch) {
		return new Student(name, studentBranch);
	}

	private Programs addPrograms(String string, Integer integer) {
		return new Programs(string, integer);
	}

//	public static void main(String args[]) throws BiffException, IOException {
//		StudentPrefrence DT = new StudentPrefrence();
//		DT.readExcel();
//	}
}
