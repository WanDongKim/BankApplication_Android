package com.example.mrgim.bankapplication;

import java.io.Serializable;

/**
 * Created by mrgim on 2017-10-23.
 */

public class Account implements Serializable{
    private String id;
    private String pwd;
    private String balance;


    public Account(String id, String pwd, String balance) {
        this.id = id;
        this.pwd = pwd;

        this.balance = balance;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Account account = (Account) o;

        if (id != null ? !id.equals(account.id) : account.id != null) return false;
        if (pwd != null ? !pwd.equals(account.pwd) : account.pwd != null) return false;
        return balance != null ? balance.equals(account.balance) : account.balance == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (pwd != null ? pwd.hashCode() : 0);
        result = 31 * result + (balance != null ? balance.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id='" + id + '\'' +
                ", pwd='" + pwd + '\'' +
                ", balance='" + balance + '\'' +
                '}';
    }
}
