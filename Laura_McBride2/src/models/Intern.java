package models;

import java.util.ArrayList;

public class Intern extends Doctor{

    public Intern(String name, String dob, char gender, String address, String contactNumber, ArrayList<Qualification> qualifications) {
        super(name,dob, gender, address, contactNumber, qualifications);
    }
    public double  calcRegistrationFee(){
        return 310.00;

    }
//

    @Override
    public String toString() {
        return super.toString();
    }
}
