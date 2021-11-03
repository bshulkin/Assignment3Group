public class HasDoctor {
    


    private static String firstName;
    private static String lastName;

    public void setFirstName(String newFirstName){
        firstName = newFirstName;
    }

    public void setLastName(String newLastName){
        lastName = newLastName;
    }
    
    public static String getLastName(){
        return lastName;
    }
    
    public static String getFirstName(){
        return firstName;
    }

}
