package com.example.multiexpenserv1;

public class user {
    private String first_name,last_name,email;
    private long monthly_income,current_balance,extra_income;

    // Adding Getters and Setters
    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getMonthly_income() {
        return monthly_income;
    }

    public void setMonthly_income(long monthly_income) {
        this.monthly_income = monthly_income;
    }

    public long getCurrent_balance() {
        return current_balance;
    }

    public void setCurrent_balance(long current_balance) {
        this.current_balance = current_balance;
    }

    public long getExtra_income() {
        return extra_income;
    }

    public void setExtra_income(long extra_income) {
        this.extra_income = extra_income;
    }
    // End

}
