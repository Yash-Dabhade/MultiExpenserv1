package com.example.multiexpenserv1;

import java.util.Date;

public class expense {
    private String Title,amount,description;
    private String day,month,year;

    public expense(String title, String amount, String day, String month, String year, String description) {
        Title = title;
        this.amount = amount;
        this.description = description;
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getAmount() {
        return (amount);
    }

    public  String getAmountWithRS(){
        return "RS "+amount;
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

    public String getDate(){
        return (getDay()+"/"+getMonth()+"/"+getYear());
    }

}
