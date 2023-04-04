package com.victa.victawebsite.model;

import java.sql.Date;
import java.time.LocalDate;

public class feedbackForm {
    private int Grade;
    private String message;
    private int usercaseid;
    private int userid;

    public feedbackForm(int grade, String message, int usercaseid, int userid) {
        this.Grade = grade;
        this.message = message;
        this.usercaseid = usercaseid;
        this.userid = userid;
    }

    public feedbackForm() {

    }

    public int getGrade() {
        return Grade;
    }

    public void setGrade(int grade) {
        Grade = grade;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getUsercaseid() {
        return usercaseid;
    }

    public void setUsercaseid(int usercaseid) {
        this.usercaseid = usercaseid;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    @Override
    public String toString() {
        return "feedbackForm{" +
                "Grade=" + Grade +
                ", message='" + message + '\'' +
                ", usercaseid=" + usercaseid +
                ", userid=" + userid +
                '}';
    }
}
