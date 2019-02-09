package org.skafcommunity.emsikeep.manageusers.models;

public class Student extends User {

    private String schoolClassID;

    public Student() {
        super();
        this.setRole(UserRole.student);
    }

    public Student(User u) {
        super(u);
    }

    public Student(String uid, String lastName, String fistName, String email, String phone, String schoolClassID) {
        super(uid, lastName, fistName, email, phone, UserRole.student);
        this.setSchoolClassID(schoolClassID);
    }

    public Student(String lastName, String fistName, String email, String phone, String schoolClassID) {
        super(lastName, fistName, email, phone, UserRole.student);
        this.setSchoolClassID(schoolClassID);
    }

    public String getSchoolClassID() {
        return schoolClassID;
    }

    public void setSchoolClassID(String schoolClassID) {
        this.schoolClassID = schoolClassID;
    }

    @Override
    public String toString() {
        return this.getFistName() + " " + this.getLastName();
    }
}
