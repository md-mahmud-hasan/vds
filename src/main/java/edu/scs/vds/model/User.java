package edu.scs.vds.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import edu.scs.vds.model.enums.UserRole;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String firstName;

    private String lastName;

    private String email;

    private Date dob;

    private UserRole role;

    @Column(nullable = false)
    private String nid;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    private String street;

    private String city;

    private String zip;

    private String country;

    @Column(columnDefinition = "int(1) default 1", nullable = false)
    private Integer appointmentStep;

    private boolean isActive;


//    @OneToOne(targetEntity=Application.class, mappedBy="user",
//            fetch=FetchType.LAZY)
//    private Application application;

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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNid() {
        return nid;
    }

    public void setNid(String nid) {
        this.nid = nid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        this.isActive = active;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public Integer getAppointmentStep() {
        return appointmentStep;
    }

    public void setAppointmentStep(Integer appointmentStep) {
        this.appointmentStep = appointmentStep;
    }

//    public Application getApplication() {
//        return application;
//    }
//
//    public void setApplication(Application application) {
//        this.application = application;
//    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return isActive == user.isActive && Objects.equals(id, user.id) && Objects.equals(firstName, user.firstName) && Objects.equals(lastName, user.lastName) && Objects.equals(email, user.email) && Objects.equals(dob, user.dob) && role == user.role && Objects.equals(nid, user.nid) && Objects.equals(password, user.password) && Objects.equals(street, user.street) && Objects.equals(city, user.city) && Objects.equals(zip, user.zip) && Objects.equals(country, user.country) && Objects.equals(appointmentStep, user.appointmentStep) && Objects.equals(createdDate, user.createdDate) && Objects.equals(lastModifiedDate, user.lastModifiedDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, email, dob, role, nid, password, street, city, zip, country, appointmentStep, isActive, createdDate, lastModifiedDate);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", dob=" + dob +
                ", role=" + role +
                ", nid='" + nid + '\'' +
                ", password='" + password + '\'' +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", zip='" + zip + '\'' +
                ", country='" + country + '\'' +
                ", appointmentStep=" + appointmentStep +
                ", isActive=" + isActive +
                ", createdDate=" + createdDate +
                ", lastModifiedDate=" + lastModifiedDate +
                '}';
    }
}
