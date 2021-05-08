package models;

import java.util.ArrayList;

public abstract class RegisteredDoctor extends Doctor {
    //Attributes
    private boolean qualifiedInIreland;

    //constructor
    public RegisteredDoctor(String name, String dob, char gender, String address, String contactNumber, ArrayList<Qualification> qualifications, boolean qualifiedInIreland)
    {
        super(name,dob, gender, address, contactNumber, qualifications);
        this.qualifiedInIreland = qualifiedInIreland;

    }

    public boolean isQualifiedInIreland(){
        if(isQualifiedInIreland()== false){
            return false;
        }
        else
            return true;

    }

    public void setQualifiedInIreland(boolean qualifiedInIreland) {
        this.qualifiedInIreland = qualifiedInIreland;
    }


    @Override
    public String toString() {
        return super.toString()+
                "Qualified in Ireland: " + qualifiedInIreland +
                '}';
    }
}
