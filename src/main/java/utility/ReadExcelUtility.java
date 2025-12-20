package utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ReadExcelUtility {
	public static List<String[]> readExcelData(String filePath) throws IOException {
        List<String[]> data = new ArrayList<>();
        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(fis)) {
            Sheet sheet = workbook.getSheetAt(0);

            for (Row row : sheet) {
                String[] rowData = new String[row.getPhysicalNumberOfCells()];
                int cellIndex = 0;
                for (Cell cell : row) {
                    rowData[cellIndex++] = cell.toString();
                }
                data.add(rowData);
            }
        }
        return data;
    }

}
