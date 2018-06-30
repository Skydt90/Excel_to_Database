package Entities;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Member
{
    private String firstName;
    private String lastName;
    private String mail;
    private int phoneNumber;
    private Date creationDate;
    private Address address;
    private Subscription subscription;
    private String memberType;
    private String isBoard;

    /*
    Constructors
     */
    public Member()
    {
        this.address = new Address();
        this.subscription = new Subscription();
    }

    /*
    Getters
     */
    public String getLastName()
    {
        return lastName;
    }
    public int getPhoneNumber()
    {
        return phoneNumber;
    }
    public String getFirstName()
    {
        return firstName;
    }
    public String getMail()
    {
        return mail;
    }
    public Address getAddress()
    {
        return address;
    }
    public Subscription getSubscription()
    {
        return subscription;
    }
    public String getMemberType()
    {
        return memberType;
    }
    public String getIsBoard()
    {
        return this.isBoard;
    }
    public String getSqlDate()
    {
        DateFormat correctFormat = new SimpleDateFormat("yyyy-MM-dd");
        return correctFormat.format(this.creationDate);
    }

    /*
    Setters
     */
    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }
    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }
    public void setPhoneNumber(int phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }
    public void setMail(String mail)
    {
        this.mail = mail;
    }
    public void setCreationDate(Date creationDate)
    {
        this.creationDate = creationDate;
    }
    public void setMemberType(String memberType)
    {
        this.memberType = memberType;
    }
    public void setIsBoard(String board)
    {
        this.isBoard = board;
    }

    public String toString()
    {
        return "Navn: " + this.firstName + " " + this.lastName + "\nEmail: " + this.mail + "\nAdresse: " +
                getAddress().getStreet() + ", " + getAddress().getZipCode() + " " + getAddress().getCity() + "\n" +
                "Betalings dato: " + getSubscription().getPayDay() + "\n";
    }
}
