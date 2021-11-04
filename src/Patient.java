public class Patient extends Person{
    private Doctor doctor;

    public Patient(String fName, String lName, Doctor doctor) {
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
        
        public String getPatientName() {
                return String.format(this.firstName + " " + this.lastName);
        }
        
        public String getDoctorName(){
            return String.format(this.getFirstName() + " " + this.getLastName());
        }

        public String toString(){
            return String.format("\t" + this.firstName + "\t\t" + this.lastName + "\t\t" + "Dr." + this.getDoctor().getLastName());
        }
}