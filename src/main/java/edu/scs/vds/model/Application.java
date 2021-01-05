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

    @Column(nullable = false)
    private String testReport;

    @OneToOne()
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false )
    private ApplicationStatus status;

    @Column(columnDefinition = "text")
    private String note;

    @Column(columnDefinition = "tinyint(1) default 1", nullable = false)
    private boolean isActive;

    @CreatedDate
    private Date createdDate;

    @LastModifiedDate
    private Date lastModifiedDate;

    @Override
    public String toString() {
        return "Application{" +
                "id=" + id +
                ", testReport='" + testReport + '\'' +
                ", user=" + user +
                ", status='" + status + '\'' +
                ", note='" + note + '\'' +
                ", isActive=" + isActive +
                ", createdDate=" + createdDate +
                ", lastModifiedDate=" + lastModifiedDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Application that = (Application) o;
        return isActive == that.isActive &&
                Objects.equals(id, that.id) &&
                Objects.equals(testReport, that.testReport) &&
                Objects.equals(user, that.user) &&
                Objects.equals(status, that.status) &&
                Objects.equals(note, that.note) &&
                Objects.equals(createdDate, that.createdDate) &&
                Objects.equals(lastModifiedDate, that.lastModifiedDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, testReport, user, status, note, isActive, createdDate, lastModifiedDate);
    }

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
}