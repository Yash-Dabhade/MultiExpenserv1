package com.example.multiexpenserv1;

public class balance {
    private String amount,description;
    private String day,month,year;
    private int ID;

    public balance(int ID,String amount, String day, String month, String year, String description) {
        this.amount = amount;
        this.description = description;
        this.day = day;
        this.month = month;
        this.year = year;
        this.ID=ID;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}
