public class Invitation{
   
   private int id;
   private String familyName;
   private int size;
   private boolean responded;
   private boolean isAttending;
   private int numberOfChickens;
   private int numberOfVeggies;
   
   /**
   Constructs a default Invitation constructor
   
   */
   public Invitation() {
   
   }
   
   /**
   Constructs an Invitation object with a specific id
   
   @param id the unique id for each invitation object created
   
   */
   public Invitation(int id){
      this.id=id;
   }
   
   /**
   Constructs an Invitation object with a family name and size
   
   @param familyName the name of the family for the invitation
   @param size the size of the family being invited
      
   */

   public Invitation(String familyName, int size) {
      this.familyName=familyName;
      this.size=size;
      
   }
   
   /**
   Accessor that returns the id of the family 
   
   @return id the id of the family
   */

   public int getID() {
      return id;
   }
   
   /**
   Mutator that sets the id of the family
   
   @param id the id of the family
   */
   
   public void setID(int id) {
      this.id = id;
   }
   /**
   Accessor that returns the name of the family
   
   @return the name of the family
   */
   
   public String getFamilyName() {
      return familyName;
   }
   
   /**
   Mutator that sets the name of the family
   
   @param familyName the name of the family   
   */
   public void setFamilyName(String familyName) {
      this.familyName = familyName;
   }
   
   /**
   Accessor that returns the size of the family
   
   @return size the size of the family  
   */
   public int getSize(){
      return size;
   }
   
   /**
   Mutator that sets the size of the family
   
   @param size the size of the family  
   */
   public void setSize(int size) {
      this.size = size;
   }
   
   /**
   Accessor that returns a boolean true or false, used for
   seeing if the family has responded to invitation
   
   
   @return responded a boolean true or false 
   */
   public boolean getResponded() {
      return responded;
   }
   
   /**
   Mutator that sets a boolean true or false, used for
   seeing if the family has responded to invitation
   
   
   @param responded a boolean true or false 
   */
   public void setResponded(boolean responded) {
      this.responded = responded;
   }
   
   /**
   Accessor that returns the number of chicken meals for a family   
   
   @return numberOfChickens an integer number of chickens
   */
   public int getNumberOfChickens() {
        return numberOfChickens;
    }
    
   /**
   Validating mutator that checks if the number of chicken meals is greater
   than the number of family members.
   
   @param numberOfChickens the number of chicken meals a family can have
      
   @return boolean a boolean true or false
   */
    public boolean setNumberOfChickens(int numberOfChickens) {
        if(numberOfChickens<= this.size){
        
           this.numberOfChickens = numberOfChickens;
           return true;
        
        }else{
        
           return false;
      }
    }
    
   /**
   Accessor that returns the number of vegetarian meals ordered
   
   @return numberOfVeggies the number of vegetarian meals ordered
   
   */
    public int getNumberOfVeggies() {
        return numberOfVeggies;
    }
    
   /**
      Validating mutator that checks if the number of veggie meals is greater
      than the number of family members.
      
      @param numberOfVeggies the number of chicken meals a family can have
         
      @return boolean a boolean true or false
      */

     public boolean setNumberOfVeggies(int numberOfVeggies) {
        if(numberOfVeggies<= this.size){
        
           this.numberOfVeggies = numberOfVeggies;
           return true;
        
        }else{
        
           return false;
      }
    }
}