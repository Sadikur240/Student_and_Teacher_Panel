package com.example.studentandteacherpanel;

public class AddAStudentInformation {
    private int id;
    private String name,contactNumber,bloodGroup,uniMail,password,commentFromTeacher,commentToTeacher;
    private double result;

    public AddAStudentInformation() {

    }

    public AddAStudentInformation(int id, String name, String contactNumber, String bloodGroup, String uniMail, String password, String commentFromTeacher, String commentToTeacher, double result) {
        this.id = id;
        this.name = name;
        this.contactNumber = contactNumber;
        this.bloodGroup = bloodGroup;
        this.uniMail = uniMail;
        this.password = password;
        this.commentFromTeacher = commentFromTeacher;
        this.commentToTeacher = commentToTeacher;
        this.result=result;

    }

    @Override
    public String toString() {
        return "AddAStudentInformation{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                ", bloodGroup='" + bloodGroup + '\'' +
                ", uniMail='" + uniMail + '\'' +
                ", password='" + password + '\'' +
                ", commentFromTeacher='" + commentFromTeacher + '\'' +
                ", commentToTeacher='" + commentToTeacher + '\'' +
                ", result=" + result +
                '}';
    }
    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getUniMail() {
        return uniMail;
    }

    public void setUniMail(String uniMail) {
        this.uniMail = uniMail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCommentFromTeacher() {
        return commentFromTeacher;
    }

    public void setCommentFromTeacher(String commentFromTeacher) {
        this.commentFromTeacher = commentFromTeacher;
    }

    public String getCommentToTeacher() {
        return commentToTeacher;
    }

    public void setCommentToTeacher(String commentToTeacher) {
        this.commentToTeacher = commentToTeacher;
    }
}
