package com.myapp.tcontact;

/**
 * Created by hugo on 04/03/17.
 */

public class Contact {
    private int id;
    private String name;
    private String number;
    private String hnumber;
    private String email;
    public Contact()
    {

    }
    public Contact(int id,String name,String number,String hnumber,String email)
    {
        this.id=id;
        this.name=name;
        this.number=number;
        this.hnumber=hnumber;
        this.email=email;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setNumber(String number) {
        this.number = number;
    }
    public void setHnumber(String hnumber){
        this.hnumber = hnumber;
    }
    public void setEmail(String email){
        this.email = email;
    }


    public int getId() {
        return id;
    }
    public String getNumber() {
        return number;
    }
    public String getName() {
        return name;
    }
    public String getHnumber() {
        return hnumber;
    }

    public String getEmail() {
        return email;
    }
}