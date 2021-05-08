package controllers;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import models.Doctor;


import java.util.ArrayList;
public class DoctorAPI {
    private ArrayList<Doctor> doctors;


    public DoctorAPI(){
        for (Doctor doctor : doctors = new ArrayList<Doctor>());

    }



    public void addDoctor(Doctor doctor){
        doctors.add(doctor);

    }

    public Doctor getDoctor(int index )
    {
        if (doctors.size() > 0) {
            return (Doctor) doctors.get(index);
        }
        else{
            return null;
        }
    }

    public boolean removeDoctor(int index){
        if(index<0 || index>= doctors.size()) {
            return false;
        }
        else{
            doctors.remove(index);
            return true;
        }
    }

    public int numberOfDoctors(){
        return doctors.size();
    }

    public String listDoctors()
    {
        String str = "";
        int index = 0;
        if(doctors.size()>0) {
             //to display the index number for deleting

            for (Doctor doctor : doctors) {
                str += index + ": " + doctor.toString() + "\n\n";
                index++;
            }
            return str;
        }else return "No Doctors";
    }

//    public String listDoctors(String x){
//
//    }
    public String searchDoctorByName(String name) {
        if (doctors.size() > 0) {
            String str = "";
            for (int i = 0; i < doctors.size(); i++) {
                if (doctors.get(i).getName().toLowerCase().equals(name)) {
                    str = str + i + ": " + doctors.get(i).toString() + "\n";
                    return str;

                } else {
                    return "There are no Doctors with this name";
                }
            }

        }
        return null;
    }
    public String searchDoctorByGender(char gender) {
        if (doctors.size() > 0) {
            String str = "";
            for (int i = 0; i < doctors.size(); i++) {
                if (doctors.get(i).getGender() == gender ) {
                    str = str + i + ": " + doctors.get(i).toString() + "\n";
                    return str;

                } else {
                    return "There are no Doctors with this gender";
                }
            }

        }
        return null;
    }
    public double calculateAnnualFees(){
        if (doctors.size() != 0){
            double totalPrice = 0;
            for (int i = 0; i < doctors.size(); i++){
                totalPrice = totalPrice + doctors.get(i).calcRegistrationFee();
            }
            return toTwoDecimalPlaces(totalPrice );
        }
        else{
            return 0.0;
        }


    }
    private double toTwoDecimalPlaces(double num){
        return (int) (num *100 ) /100.0;
    }
    @SuppressWarnings("unchecked")
    public void load() throws Exception
    {
        XStream xstream = new XStream(new DomDriver());
        ObjectInputStream is = xstream.createObjectInputStream(new FileReader("doctors.xml"));
        doctors = (ArrayList<Doctor>) is.readObject();
        is.close();
    }

    public void save() throws Exception
    {
        XStream xstream = new XStream(new DomDriver());
        ObjectOutputStream out = xstream.createObjectOutputStream(new FileWriter("doctors.xml"));
        out.writeObject(doctors);
        out.close();
    }

}