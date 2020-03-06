package domefinal;

import java.util.*;
/**
 * An object to display the data of a Cavern within the pleasure Dome. It defines a name, minimum rating for entry,
 * maximum capacity and number of guests within it. Furthermore, it contains an ArrayList to store passes
 * within the cavern itself, to allow the cavern to display who is inside of it
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Cavern
{
    private String name;
    private int rating;
    private int capacity;
    private int currentGuests;
    private ArrayList<Pass> passes = new ArrayList <Pass>(); 
    
    /** constructs the Cavern object with a name, rating, capacity and a current
     * guestcount of 0, as there will be an empty ArrayList when initialised
     * @param nm is the name of the cavern
     * @param rat is the minimum rating of the cavern
     * @param cap is the maximum capacity of the cavern
     */
    public Cavern(String nm, int rat, int cap)
    {
        name = nm;
        rating = rat;
        capacity = cap;
        currentGuests = 0;
    }
    
    /** returns the name of the cavern
     * @return returns a string with the cavern name
     */
    public String getName()
    {
        return name;
    }
   
    /** returns the minimum rating of the cavern
     * @return returns an integer with the cavern rating
     */
    public int getRating()
    {
        return rating;
    }
    
    /** displays the maximum size capacity of the cavern
     * @return is an integer of maximum cavern size
     */
    public int getCapacity()
    {
        return capacity;
    }
    
    /** returns the number of passes in the cavern by counting the amount of passes within the ArrayList currently
     * @return is the number of passes in the cavern
     */
    public int getCurrentGuests()
    {
        return currentGuests = passes.size();
    }
    
    /** moves a pass object into the ArrayList in cavern
     * @param p is the pass object the user wants to enter into the cavern
     */
    public void enterCavern(Pass p)
    {
        passes.add(p);
    }
    
    /** removes a pass from the cavern. The method's if statement is to prevent null statements
     * generated from the potential -1 from indexOf if there is that pass is not in the ArrayList
     * @param p is the pass object the user wishes to remove from the list
     */
    public void exitCavern(Pass p)
    {
        int id = passes.indexOf(p);
        if (id >= 0)
        {
            passes.remove(id);
        }
    }
    
    /** returns the pointer position of an object within the ArrayList. Returns
     * -1 if the object is not found within the list
     * @param p is the Pass the user wishes to find
     * @return returns the list position of the object the user is looking for
     */
    public int findPass(Pass p)
    {
        int out = passes.indexOf(p);
        return out;
    }
    
    /** returns a boolean if an object with the desired ID is within the ArrayList
     * @param id is the id the user is searching for within the ArrayList
     * @return is a boolean that returns true if a pass with the correct ID is in the ArrayList
     */
    public boolean inCavern (int id)
    {
        for (Pass item:passes)
        {
            if (item.getId() == id)
            {
                return true;
            }
        }
        return false;
    }
    
    /** returns a boolean if an object is within the ArrayList
     * @param p is the Pass object the user is searching for 
     * @return returns true if the correct Pass is in the ArrayList
     */
    public boolean inCavern (Pass p)
    {
        return passes.contains(p);
    }
    
    /** Returns a Pass from the ArrayList at a pointer position
     * @param i is the position of the Pass in the ArrayList
     * @return returns the pass at position i
     */
    public Pass getPass(int i)
    {
        return passes.get(i);
    }
    
    /** returns all passes within the ArrayList
     * @return returns a String representation of all passes within the ArrayList
     */
    public String getAllPasses()
    {
        String s = "";
        for (Pass temp: passes)
        {
            s = s + "\n" + temp.toString();
        }
        return s;
    }
    
    /** returns a boolean that returns true if the capacity of the room is at maximum
     * @return returns true if there is room within the Cavern
     */
    public boolean isFull()
    {
        getCurrentGuests();
        if (currentGuests < capacity)
        {
            return false;
        }
        return true;
    }
    
    /** Shows the current state of the Cavern object, with name, capacity, rating and current guests all displayed
     * @return returns a String representation of the Cavern Object.
     */
    public String toString()
    {
        return "**********************" 
        + "\nCavern Name: " + name 
        + "\n Cavern Rating: " + rating
        + "\n Cavern Capacity: " + capacity + 
        "\n Current Guests inside: " + currentGuests + 
        "\n**********************" + "\n";
    }
}