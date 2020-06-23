import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PageObject {

    private static final String SAMPLE_XLSX_FILE_PATH = "C:\\Users\\46720\\Downloads\\TestExcel.xlsx";


    public List<Row> getAllUsers(){
        List<Row> allUsers = new ArrayList<>();
        try {
            Workbook workbook = WorkbookFactory.create( new File(SAMPLE_XLSX_FILE_PATH));

            for (Row row: workbook.getSheetAt(0)) {
                allUsers.add(row);
            }
        }catch (InvalidFormatException e) {
            System.out.println("Error creating workbook: " + e.getMessage());
        }catch (IOException e) {
            System.out.println("Error creating workbook: " + e.getMessage());
        }
        return allUsers;
    }
}