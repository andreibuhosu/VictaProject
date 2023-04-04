package com.victa.victawebsite.model;

public class userConsul {
    private Integer userCaseID;
    private String epidemiology;
    private String complaints;
    private String examination;
    private String diagnosis1;
    private String diagnosis2;
    private String diagnosis3;
    private Integer patientid;
    private Integer userid;
    private String message;
    private String status;

    public userConsul(int userCaseID, String epidemiology, String complaints, String examination, String diagnosis1, String diagnosis2, String diagnosis3, int patientid, int userid, String message, String status) {
        this.userCaseID = userCaseID;
        this.epidemiology = epidemiology;
        this.complaints = complaints;
        this.diagnosis1 = diagnosis1;
        this.diagnosis2 = diagnosis2;
        this.diagnosis3 = diagnosis3;
        this.patientid = patientid;
        this.userid = userid;
        this.message = message;
        this.status = status;
    }

    public userConsul() {

    }


    public Integer getUserCaseID() {
        return userCaseID;
    }

    public void setUserCaseID(Integer userCaseID) {
        this.userCaseID = userCaseID;
    }

    public String getEpidemiology() {
        return epidemiology;
    }

    public void setEpidemiology(String epidemiology) {
        this.epidemiology = epidemiology;
    }

    public String getComplaints() {
        return complaints;
    }

    public void setComplaints(String complaints) {
        this.complaints = complaints;
    }

    public String getExamination() {
        return examination;
    }

    public void setExamination(String examination) {
        this.examination = examination;
    }

    public String getDiagnosis1() {
        return diagnosis1;
    }

    public void setDiagnosis1(String diagnosis1) {
        this.diagnosis1 = diagnosis1;
    }


    public String getDiagnosis2() {
        return diagnosis2;
    }

    public void setDiagnosis2(String diagnosis2) {
        this.diagnosis2 = diagnosis2;
    }

    public String getDiagnosis3() {
        return diagnosis3;
    }

    public void setDiagnosis3(String diagnosis3) {
        this.diagnosis3 = diagnosis3;
    }

    public Integer getPatientid() {
        return patientid;
    }

    public void setPatientid(Integer patientid) {
        this.patientid = patientid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "userConsul{" +
                "userCaseID=" + userCaseID +
                ", epidemiology='" + epidemiology + '\'' +
                ", complaints='" + complaints + '\'' +
                ", examination='" + examination + '\'' +
                ", diagnosis1='" + diagnosis1 + '\'' +
                ", diagnosis2='" + diagnosis2 + '\'' +
                ", diagnosis3='" + diagnosis3 + '\'' +
                ", patientid=" + patientid +
                ", userid=" + userid +
                ", message='" + message + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
