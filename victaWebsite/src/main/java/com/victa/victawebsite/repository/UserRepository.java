package com.victa.victawebsite.repository;

import com.victa.victawebsite.model.User;
import com.victa.victawebsite.model.UserTemp;
import com.victa.victawebsite.model.feedbackForm;
import com.victa.victawebsite.model.userConsul;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Repository
public class UserRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;


    public List<UserTemp> findAllUsers() {
        String sql = "SELECT PatientNumber,FirstName,Surname from paitents";
        return jdbcTemplate.query(sql,
                (rs, rowNum) ->
                        new UserTemp(
                                rs.getInt("PatientNumber"),
                                rs.getString("FirstName"),
                                rs.getString("Surname")

                        ));
    }

    public UserTemp findByID(Integer PatientNumber) {
        String sql = "SELECT PatientNumber,FirstName,Surname,Age,SexGender,Race,Tribe,Clan,Totem,Address,HospitalName,MaritalStatus,Nextofkin,AddressofNextofkin,DateofBirth from paitents WHERE PatientNumber = ?";

        return jdbcTemplate.queryForObject(sql, new Object[]{PatientNumber}, (rs, rowNum) ->
                new UserTemp(
                        rs.getInt("PatientNumber"),
                        rs.getString("FirstName"),
                        rs.getString("Surname"),
                        rs.getString("Age"),
                        rs.getString("SexGender"),
                        rs.getString("Race"),
                        rs.getString("Tribe"),
                        rs.getString("Clan"),
                        rs.getString("Totem"),
                        rs.getString("Address"),
                        rs.getString("HospitalName"),
                        rs.getString("MaritalStatus"),
                        rs.getString("Nextofkin"),
                        rs.getString("AddressofNextofkin"),
                        rs.getString("DateofBirth")
                ));
    }

    public List<UserTemp> findHistoryByID(Integer Patient_Number) {
        String sql = "select Col1\n" +
                "from (\n" +
                "    select Past_Diagnoses_1 as Col1\n" +
                "    from patienthistory\n" +
                "    where Patient_Number = ?\n" +
                "    union\n" +
                "    select Past_Diagnoses_2 as Col1\n" +
                "    from patienthistory" +
                "    where Patient_Number = ?\n" +
                "    union\n" +
                "    select Past_Diagnoses_3 as Col1\n" +
                "    from patienthistory\n" +
                "    where Patient_Number = ?\n" +
                "    union\n" +
                "    select Past_Diagnoses_4 as Col1\n" +
                "    from patienthistory\n" +
                "    where Patient_Number = ?\n" +
                "    union\n" +
                "    select Past_Diagnoses_5 as Col1\n" +
                "    from patienthistory\n" +
                "    union\n" +
                "    select Past_Diagnoses_6 as Col1\n" +
                "    from patienthistory\n" +
                "    where Patient_Number = ?\n" +
                "    union\n" +
                "    select Past_Diagnoses_7 as Col1\n" +
                "    from patienthistory\n" +
                "    where Patient_Number = ?\n" +
                "    union\n" +
                "    select Past_Diagnoses_8 as Col1\n" +
                "    from patienthistory\n" +
                "    where Patient_Number = ?\n" +
                "    union\n" +
                "    select Past_Diagnoses_9 as Col1\n" +
                "    from patienthistory\n" +
                "    where Patient_Number = ?\n" +
                "    ) as T;";

        return jdbcTemplate.query(
                sql, new Integer[]{Patient_Number, Patient_Number, Patient_Number, Patient_Number, Patient_Number, Patient_Number, Patient_Number, Patient_Number}, (rs, rowNum) ->
                        new UserTemp(
                                rs.getString("Col1")

                        ));
    }

    public List<UserTemp> findPastTreatmentByID(Integer Patient_Number) {
        String sql = "select Col2\n" +
                "from (\n" +
                "    select PastPresent_Treatment_1 as Col2\n" +
                "    from patienthistory\n" +
                "    where Patient_Number = ?\n" +
                "    union\n" +
                "    select PastPresent_Treatment_2 as Col2\n" +
                "    from patienthistory" +
                "    where Patient_Number = ?\n" +
                "    union\n" +
                "    select PastPresent_Treatment_3 as Col2\n" +
                "    from patienthistory\n" +
                "    where Patient_Number = ?\n" +
                "    union\n" +
                "    select PastPresent_Treatment_4 as Col2\n" +
                "    from patienthistory\n" +
                "    where Patient_Number = ?\n" +
                "    ) as T;";


        return jdbcTemplate.query(
                sql, new Integer[]{Patient_Number, Patient_Number, Patient_Number, Patient_Number}, (rs, rowNum) ->
                        new UserTemp(
                                rs.getString("Col2")

                        ));
    }


    public UserTemp findAllergiesByID(Integer Patient_Number) {
        String sql = "SELECT Known_Allergies_1,Known_Allergies_2 from patienthistory WHERE Patient_Number = ?";

        return jdbcTemplate.queryForObject(sql, new Object[]{Patient_Number}, (rs, rowNum) ->
                new UserTemp(
                        rs.getString("Known_Allergies_1"),
                        rs.getString("Known_Allergies_2")

                ));
    }



    public List<UserTemp> getConData() {
        String sql = "SELECT Epidemiology,Complaints,LabData from condata";
        return jdbcTemplate.query(sql,
                (rs, rowNum) ->
                        new UserTemp(
                                rs.getString("Epidemiology"),
                                rs.getString("Complaints"),
                                rs.getString("LabData")

                        ));
    }

    public void insertIntoUserCase(String epidemiology,String complaints,String examination,String diagnosis1,String diagnosis2,String diagnosis3,Integer patientid, Integer userid,String message){
        String unmarked = "unmarked";
        Random rnd = new Random();
        int number = rnd.nextInt(9999999);
        jdbcTemplate.update("INSERT INTO userCase VALUES (?,?,?,?,?,?,?,?,?,?,?)",number,epidemiology,complaints,examination,diagnosis1,diagnosis2,diagnosis3,patientid,userid,message,unmarked);
    }



    public List<userConsul> findunMarked() {
        String unmarked = "unmarked";
        String sql = "SELECT userCaseID,epidemiology,complaints,examination,diagnosis1,diagnosis2,diagnosis3,patientid,userid,message,status from usercase WHERE status = 'unmarked'";
        return jdbcTemplate.query(sql,
                (rs, rowNum) ->
                        new userConsul(
                                rs.getInt("userCaseID"),
                                rs.getString("epidemiology"),
                                rs.getString("complaints"),
                                rs.getString("examination"),
                                rs.getString("diagnosis1"),
                                rs.getString("diagnosis2"),
                                rs.getString("diagnosis3"),
                                rs.getInt("patientid"),
                                rs.getInt("userid"),
                                rs.getString("message"),
                                rs.getString("status")

                        ));
    }

    public List<userConsul> findMarked() {
        String sql = "SELECT userCaseID,epidemiology,complaints,examination,diagnosis1,diagnosis2,diagnosis3,patientid,userid,message,status from usercase WHERE status = 'marked'";
        return jdbcTemplate.query(sql,
                (rs, rowNum) ->
                        new userConsul(
                                rs.getInt("userCaseID"),
                                rs.getString("epidemiology"),
                                rs.getString("complaints"),
                                rs.getString("examination"),
                                rs.getString("diagnosis1"),
                                rs.getString("diagnosis2"),
                                rs.getString("diagnosis3"),
                                rs.getInt("patientid"),
                                rs.getInt("userid"),
                                rs.getString("message"),
                                rs.getString("status")

                        ));
    }

    public userConsul findunmarkedByID(Integer usercaseid) {
        String sql = "SELECT userCaseID,epidemiology,complaints,examination,diagnosis1,diagnosis2,diagnosis3,patientid,userid,message,status from usercase WHERE userCaseID = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{usercaseid}, (rs, rowNum) ->
                new userConsul(
                        rs.getInt("userCaseID"),
                        rs.getString("epidemiology"),
                        rs.getString("complaints"),
                        rs.getString("examination"),
                        rs.getString("diagnosis1"),
                        rs.getString("diagnosis2"),
                        rs.getString("diagnosis3"),
                        rs.getInt("patientid"),
                        rs.getInt("userid"),
                        rs.getString("message"),
                        rs.getString("status")

                ));
    }

    public void insertIntoFeedback(Integer grade,String message,Integer usercaseid,Integer userid){



        jdbcTemplate.update("INSERT INTO feedback VALUES (?,?,?,?)",grade,message,usercaseid,userid);
    }

    public void updateUnmarkedToMarked(Integer usercaseid){

        jdbcTemplate.update("UPDATE usercase set status = 'marked' WHERE userCaseID=?",usercaseid);
    }



    public List<Map<String, Object>> findFeedbackByID(Integer userid){
        return jdbcTemplate.queryForList("SELECT grade,message,usercaseid,userid from feedback WHERE userid = ?", userid);
    }

    public feedbackForm findIndividualFeedback(Integer usercaseid) {
        String sql = "SELECT grade,message,usercaseid,userid from feedback WHERE usercaseid = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{usercaseid}, (rs, rowNum) ->
                new feedbackForm(
                        rs.getInt("grade"),
                        rs.getString("message"),
                        rs.getInt("usercaseid"),
                        rs.getInt("userid")

                ));
    }





}

