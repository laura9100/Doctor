package controllers;
import models.Doctor;
import models.General;
import models.Qualification;
import models.Specialist;
import models.Intern;
import java.util.*;
import java.util.Scanner;
import java.util.ArrayList;

public class Driver {
    private Scanner input = new Scanner(System.in);
    private Qualification qualifications;
    HashSet<String>specialism = new HashSet<>();
    private DoctorAPI med1 = new DoctorAPI();


    public Driver() {
        runMenu();
    }

    public static void main(String[] args){
        new Driver();

    }
    private int mainMenu() {
        System.out.println("Medical Council Menu");
        System.out.println("---------");
        System.out.println("  1) Add Doctor");
        System.out.println("  2) List Doctors");
        System.out.println("  3) List Doctors by Name");
        System.out.println("  4) Update Doctor details");
        System.out.println("  5) Update Doctor qualifications");
        System.out.println("  6) Update Doctor specialism");
        System.out.println("  7) Delete Doctor");
        System.out.println("  --------------------");
        System.out.println("  8) List Doctors by gender");
        System.out.println("  9) Annual Fees Report");
        System.out.println("  --------------------");
        System.out.println("  10) Save to XML");
        System.out.println("  11) Load to XML");
        System.out.println("  0) Exit");
        System.out.print("==>> ");
        int option = input.nextInt();
        return option;
    }
    private void runMenu() {
        int option = mainMenu();
        while (option != 0) {

            switch (option) {
                case 1:
                    addDoctor();
                    break;
                case 2:
                    listDoctors();
                    break;
                case 3:
                    listDoctorsByName();
                    break;
                case 4:
                    updateDetails();
                    break;
                case 5:
                    updateQualifications();
                    break;
                case 6:
                    updateSpecialisms();
                    break;
                case 7:
                    deleteDoctor();
                    break;
//                case 8:
//                    listDoctorsByGender();
//                    break;
//                case 9:
//                    calculateAnnualFees();
//                    break;
                case 10:
                    try{
                        med1.save();
                    }
                    catch(Exception e){
                        System.err.println("Error saving to file: "+e);
                    }
                    break;
                case 11:
                    try{
                        med1.load();
                    }
                    catch(Exception e){
                        System.err.println("Error loading from file: "+e);
                    }
                    break;
                default:
                    System.out.println("Invalid option entered: " + option);
                    break;
            }


            System.out.println("\nPress any key to continue...");
            input.nextLine();
            input.nextLine();

            option = mainMenu();
        }

        //the user chose option 0, so exit the program
        System.out.println("Exiting... bye");
        System.exit(0);
    }

    private void addDoctor() {
        System.out.println("Enter the number of the doctor you want to add:");
        System.out.println("  1) General");
        System.out.println("  2) Specialist");
        System.out.println("  3) Intern");
        int doc = input.nextInt();
        String y=input.nextLine();
        System.out.println("Enter the name of the doctor:");
        String name = input.nextLine();
        System.out.println("Enter the date of birth of the doctor: ");
        String dob = input.nextLine();
        System.out.println("Enter m or f for the doctors gender: ");
        char gender = input.nextLine().charAt(0);
        System.out.println("Enter the doctors address: ");
        String address = input.nextLine();
        System.out.println("Enter the doctors contact number: ");
        String number = input.nextLine();
        ArrayList<Qualification> qualifications = addQualification();

        if (doc == 1) {
            System.out.println("Is the doctor qualified in Ireland? true = yes false = no : ");
            boolean qualified = input.nextBoolean();

            med1.addDoctor(new General(name, dob, gender, address, number, qualifications, qualified));

        }
        if (doc == 2) {
            System.out.println("Is the doctor qualified in Ireland? true = yes false =no : ");
            boolean qualified = input.nextBoolean();
            HashSet<String> specialism = addSpecialism();
            med1.addDoctor(new Specialist(name, dob, gender, address, number, qualifications, qualified, specialism));
        }
        if (doc == 3) {
            med1.addDoctor(new Intern(name, dob, gender, address, number, qualifications));

        }
    }

    public ArrayList<Qualification> addQualification(){
        ArrayList<Qualification>qualifications = new ArrayList<>();
        char x;
        System.out.println("Enter the Doctors Qualifications:");
        do {
            System.out.println("Enter the type of degree the doctor has: ");
            String type = input.nextLine();
            System.out.println("Enter the name of the degree the Doctor has:");
            String name = input.nextLine();
            System.out.println("Enter the name of the college the Doctor went to:");
            String college = input.nextLine();
            System.out.println("Enter the year the Doctor graduated college:");
            String year = input.nextLine();
            Qualification qualification=new Qualification(type,name,college,year);
            qualifications.add(qualification);

            System.out.println("To enter another qualification press Y if not press N");
            x = input.nextLine().charAt(0);
        }
        while(x == 'Y' || x == 'y');
        return qualifications;
    }

    public HashSet<String> addSpecialism(){
        char x;
        do {
            String y = input.nextLine();
            System.out.println("Enter the Doctor's speciality:");
            String spec = input.nextLine();
            specialism.add(spec);
            System.out.println("To enter another speciality Y if not press N");
            x = input.nextLine().charAt(0);
        } while(x == 'Y' || x == 'y');
        return specialism;

    }

    public void listDoctors(){
        System.out.println(med1.listDoctors());
    }

    public void listDoctorsByName(){
        System.out.println("Enter the name of the doctor you want to list:");
        String name = input.nextLine();
        System.out.println(med1.searchDoctorByName(input.nextLine()));
    }
    private void updateDetails(){
        System.out.println(med1.listDoctors());
        System.out.println("Enter the index of the Doctor to update");
        int index = input.nextInt();
        System.out.println("Enter the name of the doctor:");
        String name = input.nextLine();
        System.out.println("Enter The date of birth of the doctor: ");
        String dob = input.nextLine();
        System.out.println("Enter m or f for the doctors gender: ");
        char gender = input.nextLine().charAt(0);
        System.out.println("Enter the doctors address: ");
        String address = input.nextLine();
        System.out.println("Enter the doctors contact number: ");
        String number = input.nextLine();
        Doctor doctor = med1.getDoctor(index);
        doctor.setName(name);
        doctor.setDob(dob);
        doctor.setGender(gender);
        doctor.setAddress(address);
        doctor.setContactNumber(number);
    }

    private void updateQualifications(){
            System.out.println(med1.listDoctors());
            System.out.println("Enter the index of the Doctor's qualifications to update");
            int index = input.nextInt();
            System.out.println(med1.listDoctors());
            System.out.println("Enter the index of which qualification to update");
            int index2 = input.nextInt();
            System.out.println("");
            String x = input.nextLine();
            System.out.println("Enter the type of degree the doctor has: ");
            String type = input.nextLine();
            System.out.println("Enter the name of the degree the Doctor has:");
            String name = input.nextLine();
            System.out.println("Enter the name of the college the Doctor went to:");
            String college = input.nextLine();
            System.out.println("Enter the year the Doctor graduated college:");
            String year = input.nextLine();
            Qualification qualifications = med1.getDoctor(index).getQualifications().get(index2);
            qualifications.setDegreeType(type);
            qualifications.setDegreeName(name);
            qualifications.setCollege(college);
            qualifications.setConferringYear(year);


    }
    private void updateSpecialisms(){
        System.out.println(med1.listDoctors());
        System.out.println("Enter the index of the Doctor's specialism to update");
        int index = input.nextInt();
       specialism.remove(index);
       int x =input.nextInt();
        System.out.println("Enter the Doctor's speciality");
        String spec= input.nextLine();
        specialism.add(spec);

    }


    private void deleteDoctor(){

        System.out.println(med1.listDoctors());

        if (med1.numberOfDoctors()>0) {

            System.out.print("Enter the index of the Doctor to delete: ");
            int index = input.nextInt();
            med1.removeDoctor(index);
        }
        else
        {
            System.out.println("There is no Doctor for this index number");
        }
    }

//    private void calculateAnnualFees(){
//        System.out.println("The annual fee report is:"+ med1.calculateAnnualFees());
//    }
//
//    private void listDoctorsByGender(){
//        System.out.println("Enter the gender (m/f) of the doctor you want to list:");
//        char gender = input.nextLine().charAt(0);
//        System.out.println(med1.searchDoctorByGender(input.nextLine().charAt(0)));
//    }


}

