package domefinal;


/**
 * Creates a door object which connects between two caverns to create a link between them. The door object
 * allows passes to pass between two different caverns via pre-determined links, with the methods called
 * allowing the movement.
 *
 * @Ben Allan
 * @17/12/19
 */
public class Door
{
    private Cavern entryC;
    private Cavern exitC;
    private int doorNo;
    private static int nextDoor = 0;
    
    /** Constructor object for the cavern object. Consists of creating an entrance and
     * exit cavern, as well as expanding a static door object so the doors automatically
     * generate their values without user specific input
     * @param source takes a Cavern object as the starting location of a pass
     * @param destination takes a Cavern object as the finishing location for a pass  
     */
    public Door(Cavern source, Cavern destination)
    {
       entryC = source;
       exitC = destination; 
       doorNo = nextDoor++;
    }
    
    /** returns the door number
     * @return returns the door number as an integer
     */
    public int getDoorNo()
    {
        return doorNo;
    }
    
    /** returns the Cavern the pass is entering from
     * @param returns the Cavern the Pass is entering from
     */
    public Cavern getSource()
    {
        return entryC;
    }
    
    /** returns the Cavern the pass is exiting from
     * @param returns the Cavern the Pass is exiting from
     */
    public Cavern getDestination()
    {
        return exitC;
    }
    
    /** moves a user pass between the two Caverns defined by the door if all the conditions in 
     * the canEnter method are met. It calls methods in the users class to apply appropriate
     * functions for tokens and loyalty also if successful, otherwise the object simply does nothing
     * @param user is the Pass the user wishes to move between caverns
     */
    public void movePass(Pass user)
    {
        boolean check = canEnter(user);
        if (check == true)
        {
            exitC.enterCavern(user);
            entryC.exitCavern(user);
            user.enterCavern();
        }
    }
    
    /** Checks whether the User can pass between two objects through 4 checks; whether
     * the user has enough tokens, whether the user has a high enough rating,
     * with the exit cavern is full and whether the user is in the source cavern.
     * If all conditions are met the boolean returns true
     * @param User is the user that wishes to move between caverns
     * @return returns true if all conditions are met
     */
    public boolean canEnter(Pass user)
    {
        boolean a = user.hasTokens();
        boolean b = ratingCheck(user);
        boolean c = exitC.isFull();
        boolean d = entryC.inCavern(user);
        if ((a && b && d == true)&&(c==false))
        {
            return true;
        }
        return false;
    }
    
    /**checks whether the user has a high enough rating to pass through the door
     * @param User is the user that wishes to move between caverns
     * @return returns true if the user has enough tokens
     */
    public boolean hasTokens(Pass user)
    {
        return user.hasTokens();
    }
    
    /** checks whether the user has a high enough rating to enter the destination cavern
     *  @param User is the user that wishes to move between caverns
     * @return returns true if the user has a high enough rating
     */
    public boolean ratingCheck(Pass user)
    {
        int userR = user.getRating();
        int cavernR = exitC.getRating();
        if (userR >= cavernR)
        {
            return true;
        }
        return false;
    }
    
    /** finds the points location of a pass within an ArrayList and returns it as an integer
     * @param User is the user that wishes to move between caverns
     * @return returns the location of the point as an integer
     */
    public int getLocation (Pass p)
    {
        int location = entryC.findPass(p);
        return location;
    }
    
    /** returns the name of the source cavern as a String
     * @return returns source cavern as a String
     */
    public String getEnterance()
    {
        String s = entryC.getName();
        return s;
    }
    
    /** returns the name of the destination cavern as a String
     * @return returns destination cavern as a String
     */
    public String getExit()
    {
        String s = exitC.getName();
        return s;
    }
    
    /** returns all information about the door as a String
     * @returns information about the door in the form of a string
     */
    public String toString()
    {
       String s;
       s = "door " + doorNo + " goes from " + getEnterance() + " to " + getExit() + ".";
       return s;
    }
}
