package edu.scs.vds.model.dto;

import edu.scs.vds.model.User;

public class UserDto {
    Integer id;
    String firstname;
    String lastname;
    String email;
    String nid;
    String password;
    String street;
    String city;
    String zip;
    String country;

    public UserDto(){
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public User getUser(){
        User user = new User();
        user.setId(this.getId());
        user.setNid(this.getNid());
        user.setEmail(this.getEmail());
        user.setFirstName(this.getFirstname());
        user.setLastName(this.getLastname());
        user.setPassword(this.getPassword());
        user.setCity(this.getCity());
        user.setStreet(this.getStreet());
        user.setZip(this.getZip());
        user.setCountry(this.getCountry());
        return user;
    }
}
