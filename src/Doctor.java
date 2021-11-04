public class Doctor extends Person{
    
    private String specialization;

    public Doctor(String fName, String lName, String specialization) {
        this.firstName = fName;
        this.lastName = lName;
        this.specialization = specialization;
    }

    public void setFirstName(String newPatientFirstName){
        this.firstName = newPatientFirstName;
    }
    public void setLastName(String newPatientLastName){
        this.lastName = newPatientLastName;
    }
    public void setSpecialization(String newSpecializaiton){
        specialization = newSpecializaiton;
    }
    

    public String toString(){
        return String.format("\t" + this.getFirstName() + "\t\t" + this.getLastName() + "\t\t" + specialization);
    }
}