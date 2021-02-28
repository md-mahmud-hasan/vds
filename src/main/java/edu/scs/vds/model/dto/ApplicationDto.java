package edu.scs.vds.model.dto;

import edu.scs.vds.model.Booth;
import edu.scs.vds.model.User;
import edu.scs.vds.model.enums.ApplicationStatus;

import javax.persistence.*;

public class ApplicationDto {

    private Integer id;

    @Column(nullable = false)
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
}
