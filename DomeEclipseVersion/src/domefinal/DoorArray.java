package domefinal;

import java.util.*;
/**
 * Creates a Class to call methods on the ArrayList object in Dome
 *
 * @Ben Allan
 * @17/12/19
 */
public class DoorArray
{
    // instance variables - replace the example below with your own
    private ArrayList<Door> dList = new ArrayList<Door>();
    
    /** adds a Door object to the ArrayList
     * @param d is the door the user wishes to add 
     */
    public void addDoor(Door d)
    {
        dList.add(d);
    }
    
    /** removes a Door at the pointer position defined in pos
     * @param pos is the position the object the user wants to remove is at
     */
    public void removeDoor(int pos)
    {
        dList.remove(pos);
    }
    
    /** returns a Door object if there is a door at the position, otherwise it returns null
     * @param pos is the position of the Door object to fetch
     * @return returns the Door the user wishes to find
     */
    public Door getDoor (int pos)
    {
        int arraySize = dList.size();
        if (pos < arraySize)
        {
            Door xx = dList.get(pos);
            return xx;
        }
        return null;
    }
    
    /** returns a list of all Door's in the ArrayList as a String
     * @return returns all doors as a String
     */ 
    public String toString()
    {
        String ss = "\n";
        for(Door temp: dList)
        {
            ss = ss + temp.toString() + "\n";
        }
        return ss;
    }  
}