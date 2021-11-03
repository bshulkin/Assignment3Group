public class Patient {
    private String fName;
    private String lName;
    private Doctor doctor;

    public Patient(String fName, String lName, Doctor doctor) {
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
        
        public Doctor getDoctor(){
            return doctor;
        }
        
        public String getPatientName() {
                return String.format(fName + " " + lName);
        }
        
        public String getDoctorName(){
            return String.format(HasDoctor.getFirstName() + " " + HasDoctor.getLastName());
        }

        public String toString(){
            return String.format("\t" + fName + "\t\t" + lName + "\t\t" + "Dr." + doctor.getLastName());
        }
}