package org.skafcommunity.emsikeep.manageusers.models;

import java.io.Serializable;

public class User implements Serializable {
    private String id;
    private String uid;
    private String lastName;
    private String fistName;
    private String email;
    private String phone;
    private UserRole role;
    private String urlPicture;

    public User(User u) {
        this.id = u.id;
        this.uid = u.uid;
        this.lastName = u.lastName;
        this.fistName = u.fistName;
        this.email = u.email;
        this.phone = u.phone;
        this.role = u.role;
        this.urlPicture = u.urlPicture;
    }

    public User() {
        super();
    }

    public User(String email, UserRole role) {
        super();
        this.email = email;
        this.role = role;
    }

    public User(String uid, String lastName, String fistName, String email, String phone, UserRole role) {
        super();
        this.uid = uid;
        this.lastName = lastName;
        this.fistName = fistName;
        this.email = email;
        this.phone = phone;
        this.role = role;
    }

    public User(String lastName, String fistName, String email, String phone, UserRole role) {
        super();
        this.lastName = lastName;
        this.fistName = fistName;
        this.email = email;
        this.phone = phone;
        this.role = role;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFistName() {
        return fistName;
    }

    public void setFistName(String fistName) {
        this.fistName = fistName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public String getUrlPicture() {
        return urlPicture;
    }

    public void setUrlPicture(String urlPicture) {
        this.urlPicture = urlPicture;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", uid='" + uid + '\'' +
                ", lastName='" + lastName + '\'' +
                ", fistName='" + fistName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", role=" + role +
                '}';
    }
}
