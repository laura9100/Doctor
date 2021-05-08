package models;


import java.util.ArrayList;
import java.util.HashSet;
public class Specialist extends RegisteredDoctor {

    private HashSet<String> specialism;
    public Specialist(String name, String dob, char gender, String address, String contactNumber, ArrayList<Qualification> qualifications, boolean qualifiedInIreland, HashSet<String> specialism)
    {
        super(name,dob, gender, address, contactNumber,qualifications, qualifiedInIreland);
        this.specialism = specialism;

    }
    public double  calcRegistrationFee() {
        if (isQualifiedInIreland()) {
            return 425.00;
        } else {
            return 641.00;
        }
    }
//    public String viewContactDetails(){
//
//    return
//    }

    public HashSet<String> getSpecialism() {
        return specialism;
    }

    public void setSpecialism(HashSet<String> specialism) {
        this.specialism = specialism;
    }

    @Override
    public String toString() {
        return super.toString()+ " Specialist in:" +
                 specialism +
                '}';
    }

}
