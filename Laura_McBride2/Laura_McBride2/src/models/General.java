package models;

import java.util.ArrayList;
public class General extends RegisteredDoctor {

    public General(String name, String dob, char gender, String address, String contactNumber, ArrayList<Qualification> qualifications, boolean qualifiedInIreland)
    {
        super(name,dob, gender, address, contactNumber ,qualifications , qualifiedInIreland);

    }
    public double  calcRegistrationFee() {
        if (isQualifiedInIreland() == true) {
            return 194.00;
        } else {
            return 410.00;
        }
    }



}

