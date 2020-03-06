package domefinal;

import java.util.*;
/**
* A class to call a methods on a HashMap for Pass objects. 
* @Ben Allan
* @17/12/19
*/
public class PassMap
{
  private HashMap<Integer, Pass> passes;
  
  /** creates a HashMap of Pass objects, using the ID as a key
   */
  public PassMap()
  {
      passes = new HashMap<Integer, Pass>();
  } 
  
  /** Adds a Pass to the hash map using the ID number as the key for the map
   * @param xx is the Pass the user wants to add to the Map
   */
  public void addPass(Pass xx)
  {
      int key = xx.getId();
      passes.put(key,xx);
  }
  
  /** removes an object from the HashMap using the ID as a key
   * @param Id is an integer object of the Passes unique indentity
   */
  public void removePass(int Id)
  {
      passes.remove(Id);
  }
  
  /** returns the length of the HashMap
   * @return returns HashMap length as integer
   */
  public int getSize ()
  {
      return passes.size();
  }
  
  /** returns a pass if there is a user with the key defined in Id
   * @param Id is the Pass ID as an integer
   * @Return returns a user if there's a Pass at the key position
   */
  public Pass getUser(int Id)
  {
       boolean map = false;
       map = passes.containsKey(Id);
       if (map == true)
       {
           Pass xx = passes.get(Id);
           return xx;
       }
       return null;        
  }
  
  /** checks whether the list of passes contains a pass with the user defined ID
   * @param Id is the User defined ID that's being searched for
   * @return a boolean as true if the ID is in the HashMap
   */
  public boolean checkPass(int Id)
  {
      return passes.containsKey(Id);
  }
  
  /** Prints a full list of passes in the HashMap
   */
  public void printPasses()
  {
       Collection<Pass>pass_data=passes.values();
       Iterator<Pass> it = pass_data.iterator();
       while (it.hasNext()){
           System.out.println(it.next());
       }
  }
  
  /** creates a String of all the values of Pass within the HashMap
   * @return creates a String with all the values in the HashMap
   */
  public String toString()
  {
       String ss = "";
       Collection<Pass>pass_data=passes.values();
       Iterator<Pass> it = pass_data.iterator();
       while (it.hasNext())
       {
           ss = ss + "\n" + (it.next());
       }
       return ss;
  }
}