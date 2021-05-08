package models;

public class Qualification {
    //Attributes
    private String degreeType;
    private String degreeName;
    private String college;
    private String conferringYear;

    //Constructor
    public Qualification(String degreeType, String degreeName, String college, String conferringYear) {
        this.degreeType = degreeType;
        this.degreeName = degreeName;
        this.college = college;
        this.conferringYear = conferringYear;
    }

    //Getters
    public String getDegreeType() {
        return degreeType;
    }

    public String getDegreeName() {
        return degreeName;
    }

    public String getCollege() {
        return college;
    }

    public String getConferringYear() {
        return conferringYear;
    }

    //Setters
    public void setDegreeType(String degreeType) {
        this.degreeType = degreeType;
    }

    public void setDegreeName(String degreeName) {
        this.degreeName = degreeName;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public void setConferringYear(String conferringYear) {
        this.conferringYear = conferringYear;
    }

    @Override
    public String toString() {
        return " Qualifications:" +
                "Type of Degree:'" + degreeType + '\'' +
                ", Name of Degree'" + degreeName + '\'' +
                ", College:'" + college + '\'' +
                ", Year of Graduation:'" + conferringYear + '\'' +
                '}';
    }


}


