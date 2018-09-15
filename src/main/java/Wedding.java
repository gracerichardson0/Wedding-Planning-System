/**

   Name: Nicholas Richardson
   Date: 2/20/2016
   Course/Section: IT 206.001
   Assignment: Programming Assignment 4
   
   Description: This program allows for the simulation of a wedding
   invitation system. The user will be prompted to enter a host name, then followed
   by the option to enter family names and number of family members for that family.
   The user will be able to enter as many names as they wish, either until they wish
   to stop creating invitations or they reach the maximum amount of invitations allowed,
   which is 100.
   
   After the user is done creating invitations, they will be given the ability to see a menu.
   The menu will allow them to select a few options. The options are to remove invitations,
   record responses, print a family report for a single family, see a caterer report with all
   food amount details, and the option to exit the program.
   
   Any and all invalid inputs will be validated, and the user will be required to re-enter when necessary.

**/

import javax.swing.JOptionPane;

public class Wedding {
     
   public static void main(String[] args) {
      
      
      
      int totalChicken=0;
      int totalVeggie=0;
      int totalMeals=0;
    
      final int MAX_NUM_INVITES = 100;
      final int MAX_VENUE_SIZE = 250;
      
      
      Invitation[] invite = new Invitation[MAX_NUM_INVITES];
      
      String hostName = getHostName();
      int totalMembers= addFamily(invite, MAX_NUM_INVITES, MAX_VENUE_SIZE);
      
      
      int menuChoice = getMenuOption();
     
      /**
      
      Case statements for the menu that is presented to the user
      after all inputs are gathered for invitations.
      
      **/
      while (menuChoice != 5) {
         switch(menuChoice) {
            case 1:
               rescindInvite(invite);
               break;
               
            case 2:
               recordResponse(invite, totalMembers);
               break;
               
            case 3:
               printFamilyReport(invite);
               break;
               
            case 4:
              printCatererReport(hostName, totalMembers, totalChicken, totalVeggie);
               break;
               
            default:
               // Program should never reach this condition if logic is correct
               JOptionPane.showMessageDialog(null, "Unknown Error");
               break;
         }
      
         menuChoice = getMenuOption();
         
         totalMembers= calculateTotalMembers(invite);
         totalChicken= calculateTotalChickens(invite);
         totalVeggie= calculateTotalVeggie(invite);

         
         
         
         
   }
  }
   
   
   
   
   public static String getHostName() {
      String hostName = JOptionPane.showInputDialog("Please enter the host name");
      
      return hostName;
   }
 
  
   public static int addFamily(Invitation[] invite, int MAX_NUM_INVITES, int MAX_VENUE_SIZE) {
      int totalMembers=0;
      int index=0;
      boolean invalidInput=false;
      
      while(index<MAX_NUM_INVITES && totalMembers<MAX_VENUE_SIZE) {
      
                  
         invite[index] = new Invitation(index);
         

         invite[index].setFamilyName(JOptionPane.showInputDialog("Enter the name of the family or enter -1 to exit"));
         if(invite[index].getFamilyName().equals("-1")) {
            break;
         
         }
        
            
         do {
            try{
               invite[index].setSize(Integer.parseInt((JOptionPane.showInputDialog("Enter the number of family members" ))));
            }
            catch(NumberFormatException e){
               JOptionPane.showMessageDialog(null, "Error: Please enter a valid size");
            }
            if(invite[index].getSize()<0){
               JOptionPane.showMessageDialog(null, "Error: please enter a valid size"); 
            }else{
               totalMembers+=invite[index].getSize();
           }
                            
         } while (invite[index].getSize()<0);
         index++;
         

      }
      return totalMembers;    
   }
   public static void rescindInvite(Invitation[] invite){
      String output="ID    Name     Size";
            
      int selection=0;
      int i=0;
      for(i=0;i<invite.length;i++){
      if(invite[i]==null){
         break;
        }
         if(invite[i].getResponded()==false){
            output+="\n"+invite[i].getID()+" "+ invite[i].getFamilyName()+" "+invite[i].getSize();
         }
       }
      
       
      
      selection = Integer.parseInt(JOptionPane.showInputDialog(null, output, "Enter the ID of the family you want to remove from the list"));
      for(i=0; i<invite.length;i++){
          if(invite[i]!=null){

         if(selection==invite[i].getID()){
            invite[i]= invite[i+1];
         }           
      }
    }    
   }
  
   public static void recordResponse(Invitation[] invite, int totalMembers){
      String output="ID    Name     Size";
      int i=0;
      int selection;
      for(i=0;i<invite.length;i++){
      if(invite[i]==null){
         if(invite[i].getResponded()==false){
            output+="\n"+invite[i].getID()+" "+ invite[i].getFamilyName()+" "+invite[i].getSize();
         }
       }
      } 
         int numChickens;
         
        selection = Integer.parseInt(JOptionPane.showInputDialog(null, output, "Enter the ID of the family you want to order food for: "));
      for(i=0; i<invite.length;i++){
         if(selection==invite[i].getID()){
          do{
            try{
               numChickens = (Integer.parseInt(JOptionPane.showInputDialog("Enter the number of chickens: ")));
            }catch(NumberFormatException e){
               numChickens=-1;
            }
            if(!invite[i].setNumberOfChickens(numChickens)){
               JOptionPane.showMessageDialog(null, "Error: Please enter your valid number of chicken meals. ");
            }
            if(numChickens>invite[i].getSize()){
               numChickens+=0;
               JOptionPane.showMessageDialog(null, "Error: Chicken meals is greater than size of family.");
            }
           }while(!invite[i].setNumberOfChickens(numChickens)|| numChickens>invite[i].getSize());
           
          int numVeggies;
          
         do{
            try{
               numVeggies= (Integer.parseInt(JOptionPane.showInputDialog("Enter the number of vegetarian meals: ")));
            }catch(NumberFormatException e){
               numVeggies=-1;
            }
            if(!invite[i].setNumberOfVeggies(numVeggies)){
               JOptionPane.showMessageDialog(null, "Error: Please enter your valid number of veggie meals. ");
            }
            if(numVeggies+numChickens > totalMembers){
               numVeggies+=0;
            
               JOptionPane.showMessageDialog(null, "Error: Chicken + Vegetarian meals is greater than size of family.");
             }  
           }while(!invite[i].setNumberOfVeggies(numVeggies) || (numVeggies+numChickens > totalMembers));
     }
    }
   }

   public static void printFamilyReport(Invitation[] invite){
      String output="ID    Name     Size";
      int selection=0;
      String hasResponded="";
      
      
      for(int i=0;i<invite.length;i++){
      if(invite[i]!=null){
         if(invite[i].getResponded()==false){
            output+="\n"+invite[i].getID()+" "+ invite[i].getFamilyName()+" "+invite[i].getSize();
         }
       }
      selection=Integer.parseInt(JOptionPane.showInputDialog(null, output, "Please enter the ID of the family you want to see a report on or enter -1 to exit "));
         
         
         for(int j=0;j<invite.length;j++){
            if(invite[i]!=null){
               if(invite[j].getResponded()==false){
                  hasResponded+="\n"+invite[j].getFamilyName()+"family has responded.";
            }
           }
          } 
           int j=0;
         if(selection==invite[j].getID()){
             JOptionPane.showMessageDialog(null, "Size of family: "+invite[j].getSize()+ "\nNum chicken meals: "+invite[j].getNumberOfChickens()+"Num veg meals: "
             +invite[j].getNumberOfVeggies() + " "+ hasResponded);
           }
          
      } 
     }        
    public static void printCatererReport(String hostName, int totalMembers, int totalChicken, int totalVeggie){
      JOptionPane.showMessageDialog(null, "Host Name: "+hostName+ "\nTotal Number of people attending wedding: "+ totalMembers + 
      "\nTotal Number of chicken meals: "+totalChicken + "\nTotal Number of veggie meals: " + totalVeggie);
    }
    
     private static int getMenuOption() {
      int menuChoice;
      
      do {
         try {
            menuChoice = Integer.parseInt(JOptionPane.showInputDialog(
               "Enter your selection:"
               + "\n(1) RescindInvitation"
               + "\n(2) Record Response"
               + "\n(3) Print Family Report"
               + "\n(4) Print Caterer Report"
               + "\n(5) Exit Program"
               ));
         }
         catch (NumberFormatException e) {
            menuChoice = 0;
         }
         if (menuChoice < 1 || menuChoice > 5) {
            JOptionPane.showMessageDialog(null, "Invalid choice. Please enter a valid menu option.");
         }
      } while (menuChoice < 1 || menuChoice > 5);
      
      return menuChoice;
   }
   
   
   private static int calculateTotalMembers(Invitation[] invite){
      int totalMembers=0;
      for(int i=0;i<invite.length;i++){
         totalMembers+=invite[i].getSize();
      }
      return totalMembers;
     }
     
    private static int calculateTotalChickens(Invitation[] invite){
      int totalChicken=0;
      for(int i=0;i<invite.length;i++){
         totalChicken+=invite[i].getNumberOfChickens();
      }
      return totalChicken;
     }
    
    private static int calculateTotalVeggie(Invitation[] invite){
      int totalVeggie=0;
      for(int i=0;i<invite.length;i++){
         totalVeggie+=invite[i].getNumberOfVeggies();
      }
      return totalVeggie;
     }
    
    
  }