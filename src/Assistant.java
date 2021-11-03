
public class Assistant extends HasDoctor{

    private String fName;
    private String lName;
    private Doctor doctor;

    public Assistant(String fName, String lName, Doctor doctor) {
        super();
        this.fName = fName;
        this.lName = lName;
        this.doctor = doctor;
    }

    public void setFirstName(String newPatientFirstName){
        this.fName = newPatientFirstName;
    }
    public void setLastName(String newPatientLastName){
        this.lName = newPatientLastName;
    }
    public void setDoctor(Doctor newDoctorName){
        this.doctor = newDoctorName;
    }
    public String toString(){
        return String.format("\t" + fName + "\t\t" + lName + "\t\t" + "Dr." + doctor.getLastName());//+ Doctor.firstName + " " + Doctor.lastName);
    }
}