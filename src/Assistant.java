public class Assistant extends Person{

    private Doctor doctor;

    public Assistant(String fName, String lName, Doctor doctor) {
        super();
        this.firstName = fName;
        this.lastName = lName;
        this.doctor = doctor;
    }

    public void setFirstName(String newPatientFirstName){
        this.firstName = newPatientFirstName;
    }
    public void setLastName(String newPatientLastName){
        this.lastName = newPatientLastName;
    }
    public void setDoctor(Doctor newDoctorName){
        this.doctor = newDoctorName;
    }
    public Doctor getDoctor(){
        return doctor;
    }
    public String toString(){
        return String.format("\t" + this.getFirstName() + "\t\t" + this.getLastName() + "\t\t" + "Dr." + this.getDoctor().getLastName());
    }
}