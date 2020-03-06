package domefinal;
/**
 * A Class to represent the Gold variation of the Pass object. The class inherits from the Pass Class
 * for it's constructor values, and constructs some data based on abstract methods from Pass.
 * @Ben Allan
 * @17/12/19
 */
public class Gold extends Pass
{
    private int loyalty;
    
    /** A constructor to generate a variant of the Pass object, with a new field of Loyalty
     * The variant also contains a fixed loyalty value in it's constructor
     * @param nam is the name of the user of the pass
     * @param rat is the rating of the pass for the user
     */
    public Gold(String nam, int rat)
    {
        super(nam, rat, 30);
        loyalty = 10;
    }
    
    /** Increments loyalty by 2 when called
     */
    public void addLoyalty()
    {
        loyalty+=2;
    }
    
    /** Sets Loyalty to a defined value
     * @param loyal is the new setting for loyalty rating, used in the convert tokens method
     */
    public void setLoyalty(int loyal)
    {
        loyalty = loyal;
    }
    
    /** Returns the Loyalty balance for the user
     * @return is an integer of the amount of Loyalty
     */
    public int returnLoyalty()
    {
        return loyalty;
    }
    
    /** Removes 3 tokens from the pass upon entry and adds two loyalty counters to the pass
     */
    public void enterCavern()
    {
        deductTokens(3);
        addLoyalty();
    }
    
    /** Checks whether the user has enough tokens to move between caverns
     * Returns true if they have 3 or more tokens
     * @return is a boolean whether the user has more than 3 tokens.
     */
    public boolean hasTokens()
    { 
        return getTokens() >=3; 
    }
    
    /** Returns all information on the pass, as well as displaying pass type and amount of loyalty
     * method calls the toString method from 'Pass' to house the full data of the object
     * @return is a String representation of the Gold Pass
     */
    public String toString()
    {
        return "***Gold Pass ***" + super.toString() + "\nLoyalty Points : " + loyalty + "\n";       
    } 
}