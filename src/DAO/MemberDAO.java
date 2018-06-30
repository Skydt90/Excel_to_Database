package DAO;

import Entities.Member;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

public class MemberDAO
{


    public void postMember(List<Member> members) throws Exception
    {
        String url = "jdbc:mysql://localhost:3306/kartotek_db";
        String user = "root";
        String pw = "sesame";

        try
        {
            Class.forName("com.mysql.jdbc.Driver");

            System.out.println("Attempting to establish database connection...");
            Connection con = DriverManager.getConnection(url, user, pw);
            System.out.println("Connection successfully established!\n");

            Statement statement = con.createStatement();
            int counter = 0;

            System.out.println("Attempting to post new members to the database...");

            for (Member member : members)
            {
                ResultSet set = statement.executeQuery("SELECT MAX(memberId) FROM Members;");
                int id = 0;

                while(set.next())
                {
                    id = set.getInt(1);
                    counter++;
                }

                String sqlMem = "INSERT INTO members VALUES" +
                        "(" + (id + 1) + ", '" +
                        member.getFirstName() + "', '" +
                        member.getLastName() + "', '" +
                        member.getMail() + "', " +
                        member.getPhoneNumber() + ", '" +
                        member.getSqlDate() + "', '" +
                        member.getMemberType() + "', '" +
                        member.getIsBoard() + "');";

                statement.executeUpdate(sqlMem);

                String sqlAdd = "INSERT INTO addresses VALUES(" +
                        (id + 1) + ", '" +
                        member.getAddress().getStreet() + "', " +
                        member.getAddress().getZipCode() + ", '" +
                        member.getAddress().getCity() + "');";

                statement.executeUpdate(sqlAdd);

                if (member.getSubscription().getSqlDate() == null)
                {
                    String sqlSub = "INSERT INTO subscriptions VALUES(" +
                            (id + 1) + ", " +
                            member.getSubscription().getSqlDate() + ")";

                    statement.executeUpdate(sqlSub);
                }
                else
                {
                    String sqlSub = "INSERT INTO subscriptions VALUES(" +
                            (id + 1) + ", '" +
                            member.getSubscription().getSqlDate() + "');";

                    statement.executeUpdate(sqlSub);
                }
            }
            System.out.println("Successfully posted " + counter + " new members to the database!\n");
            con.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
