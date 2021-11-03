public class Services 
{
    // Constructor Declaration of Class
    public Services( String name, int price )
    {
        this.name = name;
        this.price = price;
    }
    
    private String name; // service name
    private int price; // service price
    
    // Get Name
    public String getName() {
        return name;
      }
    
    // Get Price
    public int getPrice() {
        return price;
      }

    public String toString(){
        return String.format("\t" + name + "\t\t$" + price);
    }
   
    // Set Service Name
    public void setServiceName(String newServiceName) {
      this.name = newServiceName;
    }
    
    // Set Service Price
    public void setServicePrice(int newServicePrice) {
      this.price = newServicePrice;
    }  
    
}