package domefinal;
/**
 * The object created to manage and maintain and Xanadu Dome. It contains a constructor wherein all the data for the objects
 * created from lower classes. The dome is then generated, and new pass objects are created outside of the Dome when the object
 * is first defined.
 * 
 * @Ben Allan
 * @17/12/19
 */
public class Dome implements Controller
{
    private String name;
    private PassMap passes = new PassMap();
    private DoorArray doors = new DoorArray();
    private CavernMap caverns = new CavernMap();
    /** constructor
     * Add all passes and add to collection
     * Create caverns with doors; add each to its collection
     * @param domeName the dome name
     */
    public Dome(String domeName) 
    {
       name = domeName;
       passes = new PassMap();
       caverns = new CavernMap();
       DoorArray doors = new DoorArray();
       createCavernsWithDoors();
       addAllPasses();
    }
    
    /** Returns the name of the dome
     * @return name of the dome
     **/
    public String getDomeName()
    {
        return name;
    }  
    
    /** Returns a String representation of all the passes in the
     * specified cavern
     * @param cName the name of the specified cavern
     * @return a String representation of all passes in the Cavern
     **/    
    public String passesInCavern(String cName)
    {
        Cavern temp = caverns.getCavern(cName);
        if (temp!=null)
        {
            return "Users in " + cName + "\n" + temp.getAllPasses();
        }
        return "No cavern found.";
    }
    
    /** Returns information about all passes (but not location)
     * @return all information about all passes
     **/
    public String getCavernNames()
    {
        return caverns.getAllCavernNames();
    }
    
    /**Returns a String representation of all the passes in all caverns (by cavern)
     * @return a String representation of all passes in all caverns
     **/
    public String passesInAllCaverns()
    {
        return caverns.toString();
    }
    
    /** Returns information about all passes (but not location)
     * @return all information about all passes
     **/
    public String getAllPasses()
    {
        String s = passes.toString();
        return s;
    }
    
    /** Returns all information about the current state of the dome, 
     * including all passes in all caverns, by cavern name
     * @return all information about the current state of the the dome
     **/
    public String toString()
    {
        String s = "***********************************************";
        s = s + caverns.toString(); 
        s = s + doors.toString();
        s = s + "\n***********************************************";
        return s;
    }
    
    /**Returns the result of a pass wanting to enter through a 
     * door.Entry will be successful if:  
     * the rating of the pass  >= the rating of the destination cavern
     * AND the destination cavern is not full
     * AND the pass has sufficient tokens
     * AND the pass is currently in the source cavern
     * If the door allows entry, the pass is removed from the 
     * source cavern, added to the destination cavern and a suitable 
     * message returned.If the door does not allow entry, the 
     * state of the system remains unchanged and a suitable message 
     * specifying the reason is returned.
     * @param pId is the id of the pass requesting to enter
     * @param dNo is the number of the door through which the pass
     * wants to enter
     * @return a String which includes pass id, pass name, name of 
     * destination cavern and giving the result of the request 
     **/
    public String enterCavern(int pId, int dNo)
    {
        boolean a = canEnter (pId, dNo);
        Pass temp = getPass(pId); 
        String s = "*********************" +"\nPass ID: " + pId + "\n" + temp.getName();
        if (a == true)
        {
            Door move = getDoor(dNo);
            move.movePass(temp);
            String enterance = move.getEnterance();
            String exit = move.getExit();
            s = s + "\nPass has been moved from " + enterance + " into " + exit +".";
        }
        else
        {
            Door move = getDoor(dNo);
            Cavern in = move.getSource();
            Cavern out = move.getDestination();
            boolean e = move.hasTokens(temp);
            boolean f = move.ratingCheck(temp);
            boolean g = out.isFull();
            boolean h = in.inCavern(temp);
            s = s + "\nPass could not be moved into cavern.";
            if      (e == false){s = s + "\nUser does not have enough tokens.";}
            else if (f == false){s = s + "\nUser does not have a high enough Pass rating.";}
            else if (g == true){s = s + "\nCavern is full.";}
            else if (h == false){s = s + "\nUser is not in source cavern.";}
        }
        return s;
    }
    
    
    /**Returns true if a pass is allowed to enter through the door, 
     * false otherwise.Entry can be made if:  
     * the rating of the pass  >= the rating of the destination cavern
     * AND the destination cavern is not full
     * AND the pass has sufficient tokens
     * AND the pass is currently in the source cavern
     * @param pId is the id of the pass requesting the move
     * @param dNo is the number of the door through which the pass 
     * wants to enter
     * @return true if the pass can enter through the door,else 
     * false
     **/
    public boolean canEnter(int pId, int dNo)
    {
        Door tempD = getDoor(dNo);
        Pass tempP = getPass(pId);
        boolean a = tempD.getLocation(tempP) >= 0;
        boolean b = passes.checkPass(pId);
        boolean c = tempD.canEnter(tempP);
        if (a && b && c == true)
        {
            return true;
        }
        return false;
    }  
    
    /**Returns the cavern which contains the specified pass
     * @param pId is the id of the specified pass
     * @return the name of the Cavern which contains the pass
     **/
    public String findPass(int pId)
    {
        return "Pass " + pId + " is located at " + caverns.findPassInCavern(pId) + ".";
    }

    /** Allows a pass to top up its tokens.This method is not 
     * concerned with the cost of a token as charges may vary 
     * between facilities.
     * @param pId the id of the pass toping up its tokens
     * @param tkns the number of tokens purchased to be added to
     * the pass.
     */
    public void topUpTokens(int pId, int tkns)
    {
         Pass temp = getPass(pId);
         temp.addTokens(tkns);
    }
            
    /** Converts a loyalty pass's loyalty points into tokens
     * @param pId the id of the pass whose points are to be converted
     */
    public void convertPoints(int pId)
    {
        Pass temp = getPass(pId);  
        if (temp.getClass()==Gold.class)
            {
                int loyalty = ((Gold)temp).returnLoyalty();
                int pointsN = loyalty/5;
                int loyaltyN = loyalty%5;
                temp.addTokens(pointsN);
                ((Gold)temp).setLoyalty(loyaltyN);
            }   
    }
    
    /** Moves a pass directly to the outside without affecting 
     * tokens or other information and using emergency exits
     * @param pId the id of the pass to be moved to outside
     * @return a message giving the user's name and "to outside"
     */
    public String moveToOutside(int pId)
    {
        String location = caverns.findPassInCavern(pId);
        Cavern start = caverns.getCavern(location);
        Cavern end = caverns.getCavern("Outside");
        Pass temp = passes.getUser(pId);
        String name = temp.getName();
        end.enterCavern(temp);
        start.exitCavern(temp);
        return "User: " + name + " has been moved to Outside";
    }

    /** In an emergency, moves all passes directly back to 
     * the outside  without affecting tokens or other 
     * information using emergency exits
     */
    public void moveAll()
    {
        int j = passes.getSize();
        for (int i = 1; i <= j; i++)
        {
            int id = i + 1000;
            moveToOutside(id);
        }
    }
    // ***************private methods***********************
    private void createCavernsWithDoors()
    {
        //cavernList
        Cavern c1 = new Cavern ("Outside", 0, 100);
        Cavern c2 = new Cavern ("Party", 1, 30);
        Cavern c3 = new Cavern ("Sports", 3, 10);
        Cavern c4 = new Cavern ("Techno", 5, 2);
        Cavern c5 = new Cavern ("Solo", 1, 1);
        //door list
        Door d0 = new Door (c1, c2);//Outside to Party
        Door d1 = new Door (c2, c3);//Party to Sports
        Door d2 = new Door (c3, c2);//Sports to Party
        Door d3 = new Door (c4, c2);//Techno to Party
        Door d4 = new Door (c2, c5);//Party to Solo
        Door d5 = new Door (c5, c2);//Solo to Party
        Door d6 = new Door (c3, c4);//Sports to Techno
        //creating Cavern HashMap
        caverns.addCavern(c1);
        caverns.addCavern(c2);
        caverns.addCavern(c3);
        caverns.addCavern(c4);
        caverns.addCavern(c5);
        //create Door ArrayList
        doors.addDoor(d0);
        doors.addDoor(d1);
        doors.addDoor(d2);
        doors.addDoor(d3);
        doors.addDoor(d4);
        doors.addDoor(d5);
        doors.addDoor(d6);
    }
    
    private void addAllPasses()
    {
        //Define Passes
        Pass p1 = new Business ("Anil", 5, 10, "Oxo");
        Pass p2 = new Gold ("Bob", 3);
        Pass p3 = new Staff ("Chen", 123, "Catering");
        Pass p4 = new Business ("Dan", 1, 12, "Knorr");
        Pass p5 = new Business ("Ezra", 5, 3, "Oxo");
        Pass p6 = new Gold ("Felek", 3);
        Pass p7 = new Staff ("Guy", 234, "Security");
        Pass p8 = new Business ("Han", 5, 20, "Knorr");
        //Add to HashMap
        passes.addPass(p1);
        passes.addPass(p2);
        passes.addPass(p3);
        passes.addPass(p4);
        passes.addPass(p5);
        passes.addPass(p6);
        passes.addPass(p7);
        passes.addPass(p8);
        //add to ArrayList
        Cavern start = caverns.getCavern("Outside");
        int j = passes.getSize();
        for (int i = 1; i <= j; i++)
        {
            int id = i + 1000;
            Pass temp = passes.getUser(id);
            start.enterCavern(temp);
        }
    }
    //     
    /** Returns the cavern with the name specified by the parameter
     * @return the cavern with the specified name
     **/
    private Cavern getCavern(String cavernName)
    {        
        return caverns.getCavern(cavernName);
    }    

    /** Returns the door with the number specified by the parameter
     * @return the door with the specified number
     **/
    private Door getDoor(int dNo)
    {
        return doors.getDoor(dNo);
    }
    
    /** Returns the pass with the id specified by the parameter
     * @return the pass with the specified id
     **/
    private Pass getPass(int id)
    {
        return passes.getUser(id); 
    }
}