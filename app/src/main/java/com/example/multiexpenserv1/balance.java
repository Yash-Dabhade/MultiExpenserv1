package com.example.multiexpenserv1;

public class balance {
    private String title,amount;
    private String day,month,year,status;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public balance(String title, String amount, String day, String month, String year) {

        this.amount = amount;
        this.day = day;
        this.month = month;
        this.year = year;
        this.title=title;

    }


    public String getAmount() {
        return amount;
    }
    public  String getAmountWithRS(){
        return "RS "+amount;
    }
    public void setAmount(String amount) {
        this.amount = amount;
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
