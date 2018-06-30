package Entities;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Subscription
{
    private Date payDay;

    public Subscription()
    {
    }

    /*
    Getters
     */
    public Date getPayDay()
    {
        return this.payDay;
    }
    public String getSqlDate()
    {
        if (this.payDay == null)
        {
            return null;
        }
        else
        {
            DateFormat correctFormat = new SimpleDateFormat("yyyy-MM-dd");
            return correctFormat.format(this.payDay);
        }
    }

    /*
    Setters
     */
    public void setPayDay(Date payDay)
    {
        this.payDay = payDay;
    }
}
