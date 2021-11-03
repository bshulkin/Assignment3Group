import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Invoice {
    private static Patient patient;
	private static ArrayList<Services> arrayList;
	
    public Invoice(Patient patient, ArrayList arrayList) {

        this.patient = patient;
        this.arrayList = arrayList;
    }

    public void setPatient(Patient invoicePatient){
        this.patient = invoicePatient;
    }

    public void setServices(ArrayList servicesList){
        this.arrayList = servicesList;
    }
    // print invoice
    public void print(){
    	// get current date
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        String date = myDateObj.format(myFormatObj);
        
    	System.out.println("\n*********** INVOICE *******************\n");
    	System.out.println(" Date: " + date +"\n Patient: " + patient.getPatientName() + "\n Doctor: " + patient.getDoctorName());
      	int totalPrice = 0;
      	int price = 0;
      	int x = 0;
      	int j = 1;
        System.out.println("\n --------- Services ---------\n ID\tService Name\t\tPrice");
        int arrSize = arrayList.size() - 1;
      	for(x = 0; x <= arrSize; x++, j++ ) {
      		price = arrayList.get(x).getPrice();
      		System.out.println(" " + j + "\t" + arrayList.get(x).getName() + "\t\t$" + price);
            totalPrice += price;
      	}
        System.out.println("\n \t\t\tTotal:\t$" + totalPrice + "\n");
        System.out.println("***************************************");

    }
}