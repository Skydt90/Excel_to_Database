package Filehandlers;

import Entities.Member;
import Entities.WorkbookFactory;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class ExcelReader
{

    private WorkbookFactory wf = new WorkbookFactory();


    // Member object creation, from excel file
    public List<Member> readMembersFromExcelFile() throws IOException
    {

        // Local variables
        List<Member> memberList = new ArrayList<>();
        List data = new ArrayList();
        String EXCEL_FILE_PATH = "C:/Users/Chris/Desktop/Enggårdens venner 2018 test.xlsx";
        System.out.println("Locating Excel file...");
        FileInputStream inputStream = new FileInputStream(new File(EXCEL_FILE_PATH));
        System.out.println("Excel successfully located!\n");
        Workbook wb = wf.getWorkbook(inputStream, EXCEL_FILE_PATH);
        Sheet firstSheet = wb.getSheetAt(0);

        // Iterator for every row in sheet
        Iterator<Row> rowIterator = firstSheet.iterator();

        // While there is another row
        System.out.println("Attempting to create members from Excel file...");


        while (rowIterator.hasNext())
        {
            Row nextRow = rowIterator.next();
            Iterator<Cell> cellIterator = nextRow.cellIterator();
            Member member = new Member();



            // While row has cells
            while (cellIterator.hasNext())
            {
                Cell nextCell = cellIterator.next();

                // Index to control switch
                int columnIndex = nextCell.getColumnIndex();

                switch (columnIndex)
                {
                    case 1:
                        member.setLastName((String) getCellValue(nextCell));
                        break;
                    case 2:
                        if (nullCheck(nextCell))
                        {
                            member.setFirstName("");
                        }
                        else
                        {
                            member.setFirstName((String) getCellValue(nextCell));
                        }
                        break;
                    case 3:
                        member.getAddress().setStreet((String) getCellValue(nextCell));
                        break;
                    case 4:
                        if (nullCheck(nextCell))
                        {
                            member.getAddress().setZipCode(0);
                        }
                        else
                        {
                            member.getAddress().setZipCode((Integer) getCellValue(nextCell));
                        }
                        break;
                    case 5:
                        member.getAddress().setCity((String) getCellValue(nextCell));
                        break;
                    case 6:
                        if(nullCheck(nextCell))
                        {
                            member.setMail("");
                        }
                        else
                        {
                            member.setMail((String) getCellValue(nextCell));
                        }
                        break;
                    case 7:
                        if (nullCheck(nextCell))
                        {
                            member.getSubscription().setPayDay(null);
                        }
                        else
                        {
                            member.getSubscription().setPayDay(new Date());
                            break;
                        }
                    case 8:
                        if (nullCheck(nextCell))
                        {
                            member.getSubscription().setPayDay(null);
                        }
                        else
                        {
                            member.getSubscription().setPayDay(new Date());
                            break;
                        }
                }
                member.setCreationDate(new Date());
                member.setMemberType("Ekstern");
                member.setPhoneNumber(0);
                member.setIsBoard("Nej");
            }
            memberList.add(member);
        }
        System.out.println("Members successfully created!\n");
        wb.close();
        inputStream.close();
        return memberList;
    }

    // Cell value method
    private Object getCellValue(Cell cell)
    {
        switch (cell.getCellTypeEnum())
        {
            case STRING:
                return cell.getStringCellValue();

            case NUMERIC:
                return Integer.parseInt((int)cell.getNumericCellValue() + "");
        }
        return null;
    }

    private boolean nullCheck(Cell nextCell)
    {
        return getCellValue(nextCell) == null;
    }
}



