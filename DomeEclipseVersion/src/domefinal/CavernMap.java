package domefinal;

import java.util.*;
/**
 * A class to call a methods on a hashmap for cavern objects. 
 *
 * @Ben Allan
 * @17/12/19
 */
public class CavernMap
{
   private HashMap<String, Cavern> caverns;
   /** constructs a HashMap names caverns
    */
   public CavernMap()
   {
        caverns = new HashMap<String, Cavern>();
   }    
   /** adds a Cavern object to the HashMap. Automatically generates the key
    * as the cavern name all in upper case letters to prevent problems calling the key later
    * @param xx is the cavern the user wishes to add
    */
   public void addCavern(Cavern xx)
   { 
        caverns.put(xx.getName().toUpperCase(),xx);
   }
   
   /** removes a Cavern from the HashMap using a key String
    * @param name is the cavern name that's also used as the key for the cavern
    */
   public void removeCavern(String name)
   {
       String search = name.toUpperCase(); 
       caverns.remove(search);
   }
   
   /** returns a cavern with the key String. It sets the input to upper case when removing to
    * prevent case based string confusing when comparing texts
    * @param cav is the key for the cavern object
    * @return returns the cavern searched for with the key
    */
   public Cavern getCavern(String cav)
   {
        String search = cav.toUpperCase(); 
        return caverns.containsKey(search)?caverns.get(search):null;
   }
   
   /** Returns a Strings object with the name of all Caverns in the Map
    * @return A String Interpretation of all the cavern names in the map
    */
   public String getAllCavernNames()
   {
       String s = "";
       for (String key:caverns.keySet())
       {
           s = s + key +"\n";
       }
       return s;
   }
   
   /** returns a string with the cavern name if an ID is within the cavern
    * if it is not it returns a failure value within the output String instead of crashing
    * @param id is the ID number the user is looking for in the HashMap
    * @return Returns either the cavern the pass is in or that it is not in the Map
    */
   public String findPassInCavern(int id)
   {
       for (String key:caverns.keySet())
       {
           Cavern temp = caverns.get(key);
           boolean a = temp.inCavern(id);
           if (a == true)
           {
               return temp.getName();
           }
       }
       return "not in any cavern";
   }
   
   /** returns a string with the cavern name a pass is in if it is in the HashMap
    * if it is not it returns a failure value within the output String instead of crashing
    * @param p is the Pass the user is looking for in the HashMap
    * @return Returns either the cavern the pass is in or that it is not in the Map
    */
   public String findPassInCavern(Pass p)
   {
       for (String key:caverns.keySet())
       {
           Cavern temp = caverns.get(key);
           boolean a = temp.inCavern(p);
           if (a == true)
           {
               return temp.getName();
           }
       }
       return "not in any cavern";
   }
   
   /**prints a list of all the content within every Cavern in the list
    */
   public void printCaverns()
   {
        for (String key:caverns.keySet())
        {
            Cavern temp = caverns.get(key);
            System.out.println(temp.toString());
        }
   }
  
   /** creates a String of all the values of Cavern within the HashMap
    * @return returns a String with all the values in the HashMap
    */
   public String toString()
   {
       String ss = "";
       for (String key:caverns.keySet())
       {
           Cavern temp = caverns.get(key);
           ss = ss + temp.toString() + temp.getAllPasses() +"\n";
       }
       return ss;
    }
}