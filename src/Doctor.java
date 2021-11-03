public class Doctor {
    
    private String specialization;
    private String fName;
    private String lName;

    public Doctor(String fName, String lName, String specialization) {
        super();
        this.fName = fName;
        this.lName = lName;
        this.specialization = specialization;
    }

    public void setFirstName(String newPatientFirstName){
        this.fName = newPatientFirstName;
    }
    public void setLastName(String newPatientLastName){
        this.lName = newPatientLastName;
    }
    public void setSpecialization(String newSpecializaiton){
        specialization = newSpecializaiton;
    }
    
    public String getLastName(){
        return lName;
    }
    
    public String getFirstName(){
        return fName;
    }

    public String toString(){
        return String.format("\t" + fName + "\t\t" + lName + "\t\t" + specialization);
    }
}