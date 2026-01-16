import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;

public class ReadExcel {
    String path = "C:/Users/Rajesh Ramdev/Desktop/FileHandlingExcel.xlsx";
    public void readData()  {
        try{
            FileInputStream fis = new FileInputStream(path);
            Workbook workbook = new XSSFWorkbook(fis);
            Sheet student = workbook.getSheet("Stud");
            for(Row row: student)
            {
                for(Cell cell: row)
                {
                    System.out.print(cell+" | ");
                }
                System.out.println();
            }

        } catch (Exception e) {
            throw new RuntimeException(" File Not found");
        }
    }

    public static void main(String[] args){
        ReadExcel re = new ReadExcel();
        re.readData();
    }
}


