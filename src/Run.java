import DAO.MemberDAO;
import Filehandlers.ExcelReader;

public class Run
{
    public static void main(String[] args)
    {
        ExcelReader er = new ExcelReader();
        MemberDAO dao = new MemberDAO();

        try
        {
            dao.postMember(er.readMembersFromExcelFile());
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

    }
}
