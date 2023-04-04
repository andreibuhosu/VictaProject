package com.victa.victawebsite.model;

public class UserTemp {
    private Integer PatientNumber;
    private String FirstName;
    private String Surname;
    private String Age;
    private String SexGender;
    private String Race;
    private String Tribe;
    private String Clan;
    private String Totem;
    private String Address;
    private String HospitalName;
    private String MaritalStatus;
    private String Nextofkin;
    private String AddressofNextofkin;
    private String DateofBirth;
    private String Col1;
    private String Col2;
    private String Known_Allergies_1;
    private String Known_Allergies_2;
    private String epidemiology;
    private String complaints;
    private String labData;


//    Constructor for patientInfo
    public UserTemp(Integer PatientNumber,String FirstName, String Surname,String Age ,String SexGender,String Race,String Tribe,String Clan,String Totem,String Address,String HospitalName,String MaritalStatus,String Nextofkin,String AddressofNextofkin,String DateofBirth) {
        this.PatientNumber = PatientNumber;
        this.FirstName = FirstName;
        this.Surname = Surname;
        this.Age = Age;
        this.SexGender = SexGender;
        this.Race = Race;
        this.Tribe = Tribe;
        this.Clan = Clan;
        this.Totem = Totem;
        this.Address = Address;
        this.HospitalName = HospitalName;
        this.MaritalStatus = MaritalStatus;
        this.Nextofkin = Nextofkin;
        this.AddressofNextofkin = AddressofNextofkin;
        this.DateofBirth = DateofBirth;





    }
    // Constructor for patient List
    public UserTemp(int PatientNumber, String FirstName, String Surname) {
        this.PatientNumber = PatientNumber;
        this.FirstName = FirstName;
        this.Surname = Surname;
    }

    public UserTemp(String Col1) {
        this.Col1 = Col1;
    }



    // Constructor for getting allergies
    public UserTemp(String Known_Allergies_1, String Known_Allergies_2) {
        this.Known_Allergies_1 = Known_Allergies_1;
        this.Known_Allergies_2 = Known_Allergies_2;

    }

    public UserTemp(String epidemiology, String complaints, String labData) {
        this.epidemiology = epidemiology;
        this.complaints = complaints;
        this.labData = labData;

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

    public String getLabData() {
        return labData;
    }

    public void setLabData(String labData) {
        this.labData = labData;
    }

    public void UserTemp(String Col2) {
        this.Col2 = Col2;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public int getPatientNumber() {
        return PatientNumber;
    }

    public void setPatientNumber(int patientNumber) {
        PatientNumber = patientNumber;
    }

    public void setPatientNumber(Integer patientNumber) {
        PatientNumber = patientNumber;
    }

    public String getAge() {
        return Age;
    }

    public void setAge(String age) {
        Age = age;
    }

    public String getSexGender() {
        return SexGender;
    }

    public void setSexGender(String sexGender) {
        SexGender = sexGender;
    }

    public String getRace() {
        return Race;
    }

    public void setRace(String race) {
        Race = race;
    }

    public String getTribe() {
        return Tribe;
    }

    public void setTribe(String tribe) {
        Tribe = tribe;
    }

    public String getClan() {
        return Clan;
    }

    public void setClan(String clan) {
        Clan = clan;
    }

    public String getTotem() {
        return Totem;
    }

    public void setTotem(String totem) {
        Totem = totem;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getHospitalName() {
        return HospitalName;
    }

    public void setHospitalName(String hospitalName) {
        HospitalName = hospitalName;
    }

    public String getMaritalStatus() {
        return MaritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        MaritalStatus = maritalStatus;
    }

    public String getNextofkin() {
        return Nextofkin;
    }

    public void setNextofkin(String nextofkin) {
        Nextofkin = nextofkin;
    }

    public String getAddressofNextofkin() {
        return AddressofNextofkin;
    }

    public void setAddressofNextofkin(String addressofNextofkin) {
        AddressofNextofkin = addressofNextofkin;
    }

    public String getDateofBirth() {
        return DateofBirth;
    }

    public void setDateofBirth(String dateofBirth) {
        DateofBirth = dateofBirth;
    }

    public String getCol1() {
        return Col1;
    }

    public void setCol1(String col1) {
        Col1 = col1;
    }

    public String getKnown_Allergies_1() {
        return Known_Allergies_1;
    }

    public void setKnown_Allergies_1(String known_Allergies_1) {
        Known_Allergies_1 = known_Allergies_1;
    }

    public String getKnown_Allergies_2() {
        return Known_Allergies_2;
    }

    public void setKnown_Allergies_2(String known_Allergies_2) {
        Known_Allergies_2 = known_Allergies_2;
    }

    public String getCol2() {
        return Col2;
    }

    public void setCol2(String col2) {
        Col2 = col2;
    }
}
