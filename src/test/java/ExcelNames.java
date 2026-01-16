import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;

public class ExcelNames {
    String path = "C:/Users/Rajesh Ramdev/Desktop/FileHandlingExcel.xlsx";
    public void readData()  {
        try{
            FileInputStream fis = new FileInputStream(path);
            Workbook workbook = new XSSFWorkbook(fis);
            Sheet student = workbook.getSheet("Stud");
            for(Row row: student)
            {
                for (int i = 0; i <=0;i++)
                {
                    Cell Names = row.getCell(i);
                    System.out.println(Names);
                }
                System.out.println();
                }
            } catch (Exception e) {
            throw new RuntimeException("File Not found");
        }

        }

    public static void main(String[] args) {
        ExcelNames en = new ExcelNames();
        en.readData();
    }
}
