package domefinal;

import java.util.*;
/**
 *Interface to process data for the Xanadu dome in a readable format for the user.
 * @Ben Allan 
 * @18/12/19
 */
public class DomeUI
{
    private Scanner reader = new Scanner(System.in);
    private Controller paradise = new Dome("Paradise Park Dome");
    
    public void doTest()
    {   
        
        int choice = getOption();        
        while (choice != 0)
        {            
            // process choice
            if      (choice == 1){displayDome();}
            else if (choice == 2){listAllCaverns();}
            else if (choice == 3){listOneCavern();}
            else if (choice == 4){listCavernNames();}
            else if (choice == 5){findPass();}
            else if (choice == 6){enterCavern();}
            else if (choice == 7){addTokens();}
            else if (choice == 8){convertPts();}
            else if (choice == 9){goOutside();}
            else if (choice == 10){evacuate();}
            // output menu & get choice
            choice = getOption();
        }
    }
    
    private int getOption()
    {
       System.out.println("What would you like to do ?");
       System.out.println("0. Quit");
       System.out.println("1. Display the dome");
       System.out.println("2. List all passes in all caverns");
       System.out.println("3. List all passes in one cavern");
       System.out.println("4. List Cavern names");
       System.out.println("5. Find a pass");
       System.out.println("6. Enter a cavern");
       System.out.println("7. Top up credits");
       System.out.println("8. Convert points to tokens - Gold only");
       System.out.println("9. Move pass to outside");
       System.out.println("10. Evacuate all");

       System.out.println("Enter your choice");
       // read choice
       int option = reader.nextInt();
       reader.nextLine();
       return option;
    }
    
    public void displayDome()
    {
        System.out.println(paradise.toString());
    }    
    
    public void listAllCaverns()
    {
        System.out.println(paradise.passesInAllCaverns());
    }
    
    public void listOneCavern()
    {
        System.out.println("Enter name of cavern: ");
        String option = reader.next();
        if (option != null){
            System.out.println(paradise.passesInCavern(option));
        }
        reader.nextLine();
    }  
    
    public void listCavernNames()
    {
        System.out.println(paradise.getCavernNames());    
    }
            
    public void findPass()
    {
        System.out.println("Enter pass id: ");
        int id = reader.nextInt();
        String ccc = paradise.findPass(id);
        System.out.println(ccc);
    }
    
    public void enterCavern()
    {
        System.out.println("Enter pass id: ");
        int id = reader.nextInt();
        System.out.println("Enter door number: ");
        int dr = reader.nextInt();
        System.out.println(paradise.enterCavern(id,dr));
    }    
       
    public void addTokens()
    {
       System.out.println("Enter pass id: ");
        int id = reader.nextInt();
        System.out.println("Enter Tokens Added: ");
        int tk = reader.nextInt();
        paradise.topUpTokens(id,tk);
        System.out.println("Token top up successful!");
    }
      
    public void convertPts()
    {
       System.out.println("Enter pass id: ");
       int id = reader.nextInt();
       paradise.convertPoints(id);
       System.out.println("Points converted for: " + id);
    }
   
    public void goOutside()
    {
        System.out.println("Enter pass id: ");
        int id = reader.nextInt();
        System.out.println(paradise.moveToOutside(id));
    }
   
    public void evacuate()
    {
       paradise.moveAll();
       System.out.println(" All evacuated to outside");
    }

    public static void main(String[] args)
    {
       new DomeUI().doTest();
    }
}