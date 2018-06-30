package Entities;

public class Address
{
    private String street;
    private int zipCode;
    private String city;

    /*
    Constructors
     */
    public Address()
    {
    }

    public Address(String street, int zipCode, String city)
    {
        this.street = street;
        this.zipCode = zipCode;
        this.city = city;
    }

    /*
    Getters
     */
    public String getStreet()
    {
        return street;
    }
    public int getZipCode()
    {
        return zipCode;
    }
    public String getCity()
    {
        return city;
    }

    /*
    Setters
     */
    public void setStreet(String street)
    {
        this.street = street;
    }
    public void setZipCode(int zipCode)
    {
        this.zipCode = zipCode;
    }
    public void setCity(String city)
    {
        this.city = city;
    }

    public String toString()
    {
        return "Vej: " + this.street + " By: " + this.city;
    }
}
