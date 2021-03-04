package edu.scs.vds.model;

import edu.scs.vds.model.enums.ApplicationStatus;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;
@Entity
@Table(name = "applications")
public class Application {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @OneToOne()
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToOne()
    @JoinColumn(name = "booth_id", nullable = true)
    private Booth booth;

    @Column(nullable = false)
    private String emergencyContact;

    @Column(nullable = true)
    private String testReport;

    @Column(columnDefinition = "boolean default false", nullable = false)
    private Boolean hasChronicDisease=false;

    @Column(columnDefinition = "boolean default false", nullable = false)
    private Boolean hasHeartDisease=false;

    @Column(columnDefinition = "boolean default false", nullable = false)
    private Boolean hasAllergy=false;

    @Column(columnDefinition = "boolean default false", nullable = false)
    private Boolean hasLungDisease=false;

    @Column(columnDefinition = "text", nullable = true)
    private String reportSummery;

    @Column(nullable = false )
    private ApplicationStatus status;

    @Column(columnDefinition = "text")
    private String note;

    @Column(columnDefinition = "tinyint(1) default 1", nullable = false)
    private boolean isActive;

    private  Date preferredAppointmentDate;
    private  Date doseOneDate;
    private  Date doseTwoDate;


    @CreatedDate
    private Date createdDate;

    @LastModifiedDate
    private Date lastModifiedDate;

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ApplicationStatus getStatus() {
        return status;
    }

    public void setStatus(ApplicationStatus status) {
        this.status = status;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public Booth getBooth() {
        return booth;
    }

    public void setBooth(Booth booth) {
        this.booth = booth;
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

    public String getReportSummery() {
        return reportSummery;
    }

    public void setReportSummery(String reportSummery) {
        this.reportSummery = reportSummery;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Application that = (Application) o;
        return isActive == that.isActive && Objects.equals(id, that.id) && Objects.equals(testReport, that.testReport) && Objects.equals(user, that.user) && Objects.equals(booth, that.booth) && Objects.equals(emergencyContact, that.emergencyContact) && Objects.equals(hasChronicDisease, that.hasChronicDisease) && Objects.equals(hasHeartDisease, that.hasHeartDisease) && Objects.equals(hasAllergy, that.hasAllergy) && Objects.equals(hasLungDisease, that.hasLungDisease) && status == that.status && Objects.equals(note, that.note) && Objects.equals(createdDate, that.createdDate) && Objects.equals(lastModifiedDate, that.lastModifiedDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, testReport, user, booth, emergencyContact, hasChronicDisease, hasHeartDisease, hasAllergy, hasLungDisease, status, note, isActive, createdDate, lastModifiedDate);
    }

    @Override
    public String toString() {
        return "Application{" +
                "id=" + id +
                ", testReport='" + testReport + '\'' +
                ", user=" + user +
                ", booth=" + booth +
                ", emergencyContact='" + emergencyContact + '\'' +
                ", hasChronicDisease=" + hasChronicDisease +
                ", hasHeartDisease=" + hasHeartDisease +
                ", hasAllergy=" + hasAllergy +
                ", hasLungDisease=" + hasLungDisease +
                ", status=" + status +
                ", note='" + note + '\'' +
                ", preferredAppointmentDate='" + preferredAppointmentDate + '\'' +
                ", isActive=" + isActive +
                ", createdDate=" + createdDate +
                ", lastModifiedDate=" + lastModifiedDate +
                '}';
    }
}