package get2019.dsaAssingment2;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class CounselingProcess {
	ArrayList<String> Branch = new ArrayList<String>();
	ArrayList<Integer> capacity = new ArrayList<Integer>();
	ArrayList<Programs> Programs = new ArrayList<Programs>();

	public void readExcel() throws BiffException, IOException {
		String FilePath = "C:\\Users\\Rivak\\workspace\\dsaAssingment2\\Programs.xls";
		FileInputStream fs = new FileInputStream(FilePath);
		Workbook wb = Workbook.getWorkbook(fs);

		// TO get the access to the sheet
		Sheet sh = wb.getSheet("Sheet1");

		// To get the number of rows present in sheet
		int totalNoOfRows = sh.getRows();

		// To get the number of columns present in sheet
		int totalNoOfCols = sh.getColumns();

		for (int row = 0; row < totalNoOfRows; row++) {

			Branch.add(sh.getCell(0, row).getContents());
		}

		for (int row = 0; row < totalNoOfRows; row++) {

			capacity.add(Integer.parseInt(sh.getCell(1, row).getContents()));
		}
		for (int i = 0; i < totalNoOfRows; i++) {
			Programs.add(this.addPrograms(Branch.get(i), capacity.get(i)));
		}

	}

	 private get2019.dsaAssingment2.Programs addPrograms(String string,
			Integer integer) {
		return new Programs(string, integer);
	}

//	public static void main(String args[]) throws BiffException, IOException {
//		CounselingProcess DT = new CounselingProcess();
//		DT.readExcel();
//	}
}
