package edu.scs.vds.model.dto;

import edu.scs.vds.model.Booth;
import edu.scs.vds.model.User;
import edu.scs.vds.model.enums.ApplicationStatus;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.util.Date;

public class ApplicationDto {

    private Integer id;

    private String testReport;

    private Integer userId;

    private Integer boothId;

    private String emergencyContact;

    private Boolean hasChronicDisease;

    private Boolean hasHeartDisease;

    private Boolean hasAllergy;

    private Boolean hasLungDisease;

    private String note;

    private Integer step;

    private Date preferredAppointmentDate;
    private Date doseOneDate;
    private Date doseTwoDate;

//    private MultipartFile file;
//
//    public MultipartFile getFile() {
//        return file;
//    }
//
//    public void setFile(MultipartFile file) {
//        this.file = file;
//    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTestReport() {
        return testReport;
    }

    public void setTestReport(String testReport) {
        this.testReport = testReport;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getBoothId() {
        return boothId;
    }

    public void setBoothId(Integer boothId) {
        this.boothId = boothId;
    }

    public String getEmergencyContact() {
        return emergencyContact;
    }

    public void setEmergencyContact(String emergencyContact) {
        this.emergencyContact = emergencyContact;
    }

    public Boolean getHasChronicDisease() {
        return hasChronicDisease;
    }

    public void setHasChronicDisease(Boolean hasChronicDisease) {
        this.hasChronicDisease = hasChronicDisease;
    }

    public Boolean getHasHeartDisease() {
        return hasHeartDisease;
    }

    public void setHasHeartDisease(Boolean hasHeartDisease) {
        this.hasHeartDisease = hasHeartDisease;
    }

    public Boolean getHasAllergy() {
        return hasAllergy;
    }

    public void setHasAllergy(Boolean hasAllergy) {
        this.hasAllergy = hasAllergy;
    }

    public Boolean getHasLungDisease() {
        return hasLungDisease;
    }

    public void setHasLungDisease(Boolean hasLungDisease) {
        this.hasLungDisease = hasLungDisease;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Integer getStep() {
        return step;
    }

    public void setStep(Integer step) {
        this.step = step;
    }

    public Date getPreferredAppointmentDate() {
        return preferredAppointmentDate;
    }

    public void setPreferredAppointmentDate(Date preferredAppointmentDate) {
        this.preferredAppointmentDate = preferredAppointmentDate;
    }

    public Date getDoseOneDate() {
        return doseOneDate;
    }

    public void setDoseOneDate(Date doseOneDate) {
        this.doseOneDate = doseOneDate;
    }

    public Date getDoseTwoDate() {
        return doseTwoDate;
    }

    public void setDoseTwoDate(Date doseTwoDate) {
        this.doseTwoDate = doseTwoDate;
    }

}
