package Entities;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class WorkbookFactory
{
    public Workbook getWorkbook(FileInputStream inputStream, String excelFilePath)
    throws IOException
    {
        Workbook workbook;

        if (excelFilePath.endsWith("xlsx"))
        {
            workbook = new XSSFWorkbook(inputStream);
        }
        else if (excelFilePath.endsWith("xls"))
        {
            workbook = new HSSFWorkbook(inputStream);
        }
        else
            {
                throw new IllegalArgumentException("The specified file is not Excel file");
            }
        return workbook;
    }
}
