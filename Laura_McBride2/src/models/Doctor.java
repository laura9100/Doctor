package models;


import java.util.ArrayList;


public abstract class Doctor implements IDoctor {
    private String name;
    private String dob;
    private char gender;
    private String address;
    private String contactNumber;
    private ArrayList<Qualification> qualifications;

    public Doctor(String name, String dob, char gender, String address, String contactNumber, ArrayList<Qualification> qualifications) {
        this.name = name;
        this.dob = dob;
        this.gender = gender;
        this.address = address;
        this.contactNumber = contactNumber;
        this.qualifications = qualifications;
    }

    public String viewContactDetails(){
        return name + " " + contactNumber + " " + address;

    }
    private String getFullGender(){
        if(gender == 'f') {
            return "Female";
        }
        else if(gender == 'm'){
            return "Male";
        }
        else
            return "Unknown";
    }

    public void addQualification(Qualification qualification){
        qualifications.add(qualification);
    }
    //getters
    public String getName() {
        return name;
    }

    public String getDob() {
        return dob;
    }

    public char getGender() {
        return gender;
    }

    public String getAddress() {
        return address;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public ArrayList<Qualification> getQualifications() {
        return qualifications;
    }

    //Setters

    public void setName(String name) {
        this.name = name;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public void setQualifications(ArrayList<Qualification> qualifications) {
        this.qualifications = qualifications;
    }

    @Override
    public String toString() {
        return "Doctor: " +
                "Name: '" + name + '\'' +
                ", Date of Birth:'" + dob + '\'' +
                ", Gender: " + getFullGender() +
                ", Address: '" + address + '\'' +
                ", Contact Number: '" + contactNumber + '\'' +
                "" + qualifications +
                '}';
    }

}