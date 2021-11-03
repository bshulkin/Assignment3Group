import java.util.ArrayList;
import java.util.*;
public class App {
	// initialize scanner
    static Scanner input = new Scanner(System.in);
    
    // initialize checkNumber variables
    static int newInt = 0;
    static boolean validate = true;
    static String index = "";
    // checkNumber method validates user input, loops until user has entered an integer
    public static void checkNumber(){
        validate = true;
        do {
            index = input.next();
            try
            {
                Integer.parseInt(index);
                validate = false;
                newInt = Integer.parseInt(index);
            } catch (NumberFormatException ex)
            {
                System.out.println(index + " is not an integer. Please enter an integer.");
            }
        } while (validate);
    }

    
  	// initialize printList variable
  	static int lineNumber = 1;
  	// printList method prints all objects in an ArrayList and numbers each row
    public static void printList(ArrayList myArray) {
        lineNumber = 1;
        for( Object s : myArray)
            System.out.println((lineNumber++)+": " + s);
        System.out.println("****************************************");
    }

    // initialize checkIndex variables
    static String indexString = "";
    static int indexInt = 0;
    static int arrSize = 0;
    static boolean arraySize = true;
    // checkIndex method validates the index specified by user input
    public static void checkIndex(ArrayList myArray, String objectName, String actionName){
        validate = true;
        arrSize = myArray.size();
        arraySize = true;
        
        if (arrSize == 0) {
            System.out.println("The list is empty. You must add a new "+ objectName +".");
            arraySize = false;	
        } else {
	        System.out.println("Enter the id of the " + objectName +" you want to " + actionName + ":");
	        do {
	            indexString = input.next();
	            try
	            {
	                indexInt = Integer.parseInt(indexString);
	                if(1 > indexInt || indexInt > arrSize) {
	                    System.out.println("That index is out of range. Enter a number between 1 and "+ arrSize +".");
	                }
	                else {
	                	indexInt -= 1;
	                	validate = false;
	                }
	            } catch (NumberFormatException ex)
	            {
	                System.out.println(indexString + " is not an id. Enter an integer.");
	            }
	        } while (validate);
	    }
    }

    public static void main(String[] args) throws Exception {
       // add doctors
        ArrayList<Doctor> myDoc = new ArrayList<>();
        Doctor Bryan = new Doctor("Bryan", "Shulkin", "Neurosurgeon");
        myDoc.add(Bryan);
        Doctor Ben = new Doctor("Ben", "Perkins", "General Practioner");
        myDoc.add(Ben);
        Doctor Chuck = new Doctor("Chuck", "Polasky", "Physical Therapist");
        myDoc.add(Chuck);
        
        // add assistants
        ArrayList<Assistant> myAssistant = new ArrayList<>();
        Assistant Bob = new Assistant("Bob", "Barker", Ben);
        Assistant Bert = new Assistant("Kate", "Smith", Bryan);
        Assistant Tom = new Assistant("Tom", "Segura", Chuck);
        myAssistant.add(Bob);
        myAssistant.add(Bert);
        myAssistant.add(Tom);
        
        // add patients
        ArrayList<Patient> myPatient = new ArrayList<>();
        Patient Todd = new Patient("Todd", "Petersen", Bryan);
        Patient Tony = new Patient("Tony", "Stark", Ben);
        Patient Teo = new Patient("Teo", "Toes", Chuck);
        myPatient.add(Todd);
        myPatient.add(Tony);
        myPatient.add(Teo);
        
        // add services
        ArrayList<Services> myServices = new ArrayList<>();
        Services emergency = new Services("Emergency", 1250);
        Services physical = new Services("Physical", 200);
        Services brain_scan = new Services("Brain Scan", 5000);
        Services checkup = new Services("Medicine Check", 150);
        Services flu_shot = new Services("Flu Shot", 50);
        myServices.add(emergency);
        myServices.add(physical);
        myServices.add(brain_scan);
        myServices.add(checkup);
        myServices.add(flu_shot);
  	  	
  	  	
        // initialize variables
  	  	boolean running = true; // running boolean creates loop until quit
  	  	String addSelection = ""; // main user input variable for secondary menus
  	  	String header = ""; // updated header string
  	  	boolean whatNext = true; // what next? boolean
  	  	
  	  	// print welcome message
  	  	System.out.println( "Welcome to the Office Management System");
  	  	
  	  	do {
	        // print menu of user options
	        System.out.println("\nWhat would you like to do?\n[1] View/Edit Services\n[2] View/Edit Doctors\n[3] View/Edit Assistants\n[4] View/Edit Patients\n[5] Create Invoice\n[0] Quit\n");
	        String selection = input.next(); // read user input
	        
	        // check if true
	        if("1".equals(selection))
	        {
	            // updated header string
	        	header = "\n************** Updated Services **************\nID\tName\t\tPrice";
	            // print list of services
	            System.out.println("\n************* Our Services *************\nID\tService Name\t\tPrice");
	            printList(myServices);
	            
	            // loop services menu until user exits
	        	boolean servicesMenu = true;
	        	do {	
	                System.out.println( "\nWhat would you like to do?\n[1] Add Service\n[2] Edit Service\n[3] Delete Service\n[0] Return to Main\n");
		            addSelection = input.next(); // read user input
	
                    // return to main menu
		            if("0".equals(addSelection)) {
		            	servicesMenu = false;
		            }

		            else {
                        // add new service
		                if("1".equals(addSelection)){
		                    System.out.println("Enter the name of the service:");
		                    String newName = input.next();
		                    System.out.println("Enter the price for "+ newName + " (as an integer):");
                            
                            // get and validate new price
                            checkNumber();
		                    
							Services userService = new Services(newName, newInt);
		                    myServices.add(userService);
							System.out.println(header);
				            printList(myServices);
		                }
		                
		                // edit existing service
						else if("2".equals(addSelection)){
							boolean editMenu = true;
                            checkIndex(myServices, "service", "edit");                    
		                    if(arraySize) {
			                    do {
			    	                System.out.println( "\nWhat would you like to change?\n[1] Edit Name\n[2] Edit Price\n");
			    		            String editServiceAction = input.next(); // read user input
	                                // update name
			    		            if("1".equals(editServiceAction)) {
										System.out.println("Enter new service name:");
				                    	String newName = input.next();
										myServices.get(indexInt).setServiceName(newName);
										
						            	editMenu = false;
										System.out.println(header);
										printList(myServices);
			    		            }
	                                // update price
			    		            else if("2".equals(editServiceAction)) {
										System.out.println("Enter new service price:");
	                                    // get and validate new price
	                                    checkNumber();
										myServices.get(indexInt).setServicePrice(newInt);
										
						            	editMenu = false;
										System.out.println(header);
										printList(myServices);
			    		            }                    	
			    		            else {
			    		            	System.out.println("Your response was invalid.");
			    		            }
			                    } while(editMenu);
		                    }
						}		               	                
		                
						else if("3".equals(addSelection)) {

                            checkIndex(myServices, "service", "delete");		             
		                    if(arraySize) {
			                    myServices.remove(indexInt);
			                    
								System.out.println(header);
					            printList(myServices);
		                    }
						}
						else {
							System.out.println("\nYour response was invalid.\nPlease enter a number between 0 and 3.");
						}
		            }
	        	} while(servicesMenu);
			}
	        
	        // doctors menu
	        else if("2".equals(selection))
	        {
                // updated header string
                header = "\n************ Updated Doctors ************\nID\tFirst Name\tLast Name\tSpecialty";
                
	            // print list of doctors
	            System.out.println("\n**************** Doctors ****************\nID\tFirst Name\tLast Name\tSpecialty");
                printList(myDoc);
	            
	            // loop doctors menu until user exits
	        	boolean doctorsMenu = true;
	        	do {	
	                System.out.println( "\nWhat would you like to do?\n[1] Add Doctor]\n[2] Edit Doctor\n[3] Delete Doctor\n[0] Return to Main\n");
		            addSelection = input.next(); // read user input
	
                    // return to main menu
		            if("0".equals(addSelection)) {
		            	doctorsMenu = false;
		            }

		            else {
                        // add new service
		                if("1".equals(addSelection)){
                            System.out.println("Enter the new doctor's first name:");
                            String docFirstName = input.next();
                            System.out.println("Enter the new doctor's last name:");
		                    String docLastName = input.next();
		                    System.out.println("Enter the new doctor's specialty:");
		                    String docSpecialty = input.next();
		                    
                            Doctor userDoctor = new Doctor(docFirstName, docLastName, docSpecialty);
                            myDoc.add(userDoctor);

                            System.out.println(header);
				            printList(myDoc);
		                }
		                
		                // edit existing doctor
						else if("2".equals(addSelection)){
							boolean editMenu = true;
                            String newValue = "";
                            checkIndex(myDoc, "doctor", "edit");
		                    if(arraySize) {
			                    do {
			    	                System.out.println( "\nWhat would you like to change?\n[1] First Name\n[2] Last Name\n[3] Specialty\n");
			    		            String editDoctorAction = input.next(); // read user input
	                                // edit first name
			    		            if("1".equals(editDoctorAction)) {
										System.out.println("Enter the new value for first name:");
				                    	newValue = input.next();
										myDoc.get(indexInt).setFirstName(newValue);
	                                                          
	                                    editMenu = false;
	                                    // print updated list
	                                    System.out.println(header);
					                    printList(myDoc);
			    		            }
	                                // edit last name
			    		            else if("2".equals(editDoctorAction)) {
										System.out.println("Enter the new value for last name:");
				                    	newValue = input.next();
										myDoc.get(indexInt).setLastName(newValue);
	                                                                  
	                                    editMenu = false;
	                                    // print updated list
	                                    System.out.println(header);
					                    printList(myDoc);
			    		            }
	                                // edit specialty
	                                else if("3".equals(editDoctorAction)) {
	                                    System.out.println("Enter the new value for specialty:");
	                                    newValue = input.next();
	                                    myDoc.get(indexInt).setSpecialization(newValue);
	
	                                    editMenu = false;
	                                    // print updated list
	                                    System.out.println(header);
					                    printList(myDoc);
			    		            }
	                                else {
								        System.out.println("Your response was invalid.");
	                                }			    		            
						            
			                    } while(editMenu);
		                    }
						}		                
						else if("3".equals(addSelection)) {
                            checkIndex(myDoc, "doctor", "delete");		
		                    if(arraySize) {
		                    	myDoc.remove(indexInt);
		                                                                                            
	                            System.out.println(header);
	                            printList(myDoc);
		                    }
                        }
						else {
							System.out.println("Your response was invalid.\nPlease enter a number between 0 and 3.");
						}
		            }
	        	} while(doctorsMenu);
			}
	        // assistants menu
	        else if("3".equals(selection))
	        {
                // updated header string
                header = "\n********** Updated Assistants **********\nID\tFirst Name\tLast Name\tDoctor";
                
	            // print list of assistants
	            System.out.println("\n************** Assistants ***************\nID\tFirst Name\tLast Name\tDoctor");
                printList(myAssistant);
	            
	            // loop assistants menu until user exits
	        	boolean assistantsMenu = true;
	        	do {	
	                System.out.println( "\nWhat would you like to do?\n[1] Add Assistant\n[2] Edit Assistant\n[3] Delete Assistant\n[0] Return to Main\n");
		            addSelection = input.next(); // read user input
	
                    // return to main menu
		            if("0".equals(addSelection)) {
		            	assistantsMenu = false;
		            }

		            else {
                        // add new assistant
		                if("1".equals(addSelection)){
                            System.out.println("Enter the new assistant's first name:");
                            String assistantFirstName = input.next();
                            System.out.println("Enter the new assistant's last name:");
		                    String assistantLastName = input.next();
                            // print list of doctors
	                        System.out.println("\n**************** Doctors ****************\nID\tFirst Name\tLast Name\tSpecialty");
                            printList(myDoc);
                            checkIndex(myDoc, "doctor", "assign to this assistant");	

                            Doctor doctorName = myDoc.get(indexInt);
                            Assistant userAssistant = new Assistant(assistantFirstName, assistantLastName, doctorName);
                            myAssistant.add(userAssistant);

                            System.out.println(header);
				            printList(myAssistant);
		                }
		                
		                // edit existing assistant
						else if("2".equals(addSelection)){
							boolean editMenu = true;
                            String newValue = "";
                           
                            checkIndex(myAssistant, "assistant", "edit");	                    
		                    if(arraySize) {
			                    do {
			    	                System.out.println( "\nWhat would you like to change?\n[1] First Name\n[2] Last Name\n[3] Doctor\n");
			    		            String editAssistantAction = input.next(); // read user input
	                                // edit first name
			    		            if("1".equals(editAssistantAction)) {
										System.out.println("Enter the new value for first name:");
				                    	newValue = input.next();
										myAssistant.get(indexInt).setFirstName(newValue);
	                                                                     
	                                    editMenu = false;
	                                    // print updated list
	                                    System.out.println(header);
					                    printList(myAssistant);
			    		            }
	                                // edit last name
			    		            else if("2".equals(editAssistantAction)) {
										System.out.println("Enter the new value for last name:");
				                    	newValue = input.next();
										myAssistant.get(indexInt).setLastName(newValue);
	                                                                        
	                                    editMenu = false;
	                                    // print updated list
	                                    System.out.println(header);
					                    printList(myAssistant);
			    		            }
	                                // edit doctor
	                                else if("3".equals(editAssistantAction)) {
	                                    // print list of doctors
	                                    System.out.println("\n**************** Doctors ****************\nID\tFirst Name\tLast Name\tSpecialty");
	                                    printList(myDoc);
	                                    checkIndex(myDoc, "new doctor", "assign to this assistant");	
	
	                                    Doctor doctorName = myDoc.get(indexInt);
	                                    myAssistant.get(indexInt).setDoctor(doctorName);
	                                    
	                                    editMenu = false;
	                                    // print updated list
	                                    System.out.println(header);
					                    printList(myAssistant);
			    		            }
	                                else {
								        System.out.println("Your response was invalid.");
	                                }
						            
			                    } while(editMenu);
							}
						}	               	                
		                
						else if("3".equals(addSelection)) {
                            checkIndex(myAssistant, "assistant", "delete");		            
		                    if(arraySize) {
			                    myAssistant.remove(indexInt);
			                                                                                            
	                            System.out.println(header);
	                            printList(myAssistant);
		                    }
                        }
						else {
							System.out.println("Your response was invalid.\nPlease enter a number between 0 and 3.");
						}
		            }
	        	} while(assistantsMenu);
			}
	        
	        // patients menu
	        else if("4".equals(selection))
	        {
                // updated header string
                header = "\n********* Updated Patients *********\nID\tFirst Name\tLast Name\tDoctor";
                
	            // print list of patients
	            System.out.println("\n************* Patients **************\nID\tFirst Name\tLast Name\tDoctor");
                printList(myPatient);
	            
	            // loop patients menu until user exits
	        	boolean patientsMenu = true;
	        	do {	
	                System.out.println( "\nWhat would you like to do?\n[1] Add Patient\n[2] Edit Patient\n[3] Delete Patient\n[0] Return to Main");
		            addSelection = input.next(); // read user input
	
                    // return to main menu
		            if("0".equals(addSelection)) {
		            	patientsMenu = false;
		            }

		            else {
                        // add new patient
		                if("1".equals(addSelection)){
                            System.out.println("Enter the new patient's first name:");
                            String patientFirstName = input.next();
                            System.out.println("Enter the new patient's last name:");
		                    String patientLastName = input.next();
                            // print list of doctors
	                        System.out.println("\n**************** Doctors ****************\nID\tFirst Name\tLast Name\tSpecialty");
                            printList(myDoc);
                            checkIndex(myDoc, "doctor", "assign to this patient");	

                            Doctor doctorName = myDoc.get(indexInt);
                            Patient userPatient = new Patient(patientFirstName, patientLastName, doctorName);
                            myPatient.add(userPatient);

                            System.out.println(header);
				            printList(myPatient);
		                }
		                
		                // edit existing patient
						else if("2".equals(addSelection)){
							boolean editMenu = true;
                            String newValue = "";
                            
                            checkIndex(myPatient, "patient", "edit");
		                    if(arraySize) {
			                    do {	                    
			    	                System.out.println( "\nWhat would you like to change?\n[1] First Name\n[2] Last Name\n[3] Doctor\n");
			    		            String editPatientAction = input.next(); // read user input
	                                // edit first name
			    		            if("1".equals(editPatientAction)) {
										System.out.println("Enter the new value for first name:");
				                    	newValue = input.next();
										myPatient.get(indexInt).setFirstName(newValue);
	                                                                        
	                                    editMenu = false;
	                                    // print updated list
	                                    System.out.println(header);
					                    printList(myPatient);
			    		            }
	                                // edit last name
			    		            else if("2".equals(editPatientAction)) {
										System.out.println("Enter the new value for last name:");
				                    	newValue = input.next();
										myPatient.get(indexInt).setLastName(newValue);
	                                                                        
	                                    editMenu = false;
	                                    // print updated list
	                                    System.out.println(header);
					                    printList(myPatient);
			    		            }
	                                // edit doctor
	                                else if("3".equals(editPatientAction)) {
	                                    // print list of doctors
	                                    System.out.println("\n**************** Doctors ****************\nID\tFirst Name\tLast Name\tSpecialty");
	                                    printList(myDoc);
	                                    checkIndex(myDoc, "new doctor", "assign to this patient");	
	
	                                    Doctor doctorName = myDoc.get(indexInt);
	                                    myPatient.get(indexInt).setDoctor(doctorName);
	
	                                    editMenu = false;
	                                    // print updated list
	                                    System.out.println(header);
					                    printList(myPatient);
			    		            }
	                                else {
								        System.out.println("Your response was invalid.");
	                                }
						            
			                    } while(editMenu);
		                    }
						}
		               	                
		                
						else if("3".equals(addSelection)) {
                            checkIndex(myPatient, "patient", "delete");		  
		                    if(arraySize) {
			                    myPatient.remove(indexInt);
			                                                                                            
	                            System.out.println(header);
	                            printList(myPatient);
		                    }
                        }
						else {
							System.out.println("Your response was invalid.\nPlease enter a number between 0 and 3.");
						}
		            }
	        	} while(patientsMenu);
			}
	        
	        // invoice menu
	        else if("5".equals(selection))
	        {                
            	if(myPatient.size() == 0) {
            		System.out.println("Patients list is empty. You must add patients first.");
            	}
            	else if(myServices.size() == 0) {
            		System.out.println("Services list is empty. You must add services first.");
            	}
            	else {
		            // print list of patients
		            System.out.println("\n************* Patients **************\nID\tFirst Name\tLast Name\tDoctor");
	                printList(myPatient);
	
	                checkIndex(myPatient, "patient", "create this invoice for");
	                if(arraySize) {
		                Patient invoicePatient = myPatient.get(indexInt);
			            
			            // loop add services until user is finished
		                boolean addInvoiceServices = true;
		                // add services to invoice
		                ArrayList<Services> invoiceServices = new ArrayList<>();
		
			        	do {
		                    // print list of services
		                    System.out.println("\n************* Our Services *************\nID\tService Name\t\tPrice");
		                    printList(myServices);
		                    
		                    // select service to add to invoice
		                    checkIndex(myServices, "service", "add to this invoice");	
		                    
		                    Services newInvoiceService = myServices.get(indexInt);
		                    // add service to invoice
		                    invoiceServices.add(newInvoiceService);
		                        
		                        whatNext = true;
		                        do {
		                            System.out.println( "\nWould you like to add more services to this invoice?\n[1] Yes\n[0] No\n");
		                            String editMore = input.next(); // read user input
		                            
		                            if("0".equals(editMore)) {
		                                addInvoiceServices = false;
		                                whatNext = false;
		                            }
		                            else if("1".equals(editMore)) {
		                                whatNext = false;
		        	                    // select service to add to invoice
		                            }
		                            else {
		                                System.out.println("Your response was invalid.");
		                            }
		                        } while(whatNext);
		
		                    } while(addInvoiceServices);
	
		                Invoice newInvoice = new Invoice(invoicePatient, invoiceServices);
		                newInvoice.print();
                    }
                }
            }
	        
	        else if( "0".equals( selection ))
	        {
	            // end program
	            System.out.println("\nThank you. Have a nice day.");
	            running = false;
	        }
	        else {
	        	System.out.println("Your response was invalid.\nPlease enter a number between 0 and 4.");
	        }
	        
  	  	} while(running);
    }
    
}
