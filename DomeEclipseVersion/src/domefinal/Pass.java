package domefinal;
/**
 * Creates a pass object for other specific pass types to inherit off of.
 * Constructs a base pass using a String name, 
 *
 * @Ben Allan
 * @version (a version number or a date)
 */
public abstract class Pass
{
    private int passId;  
    private String name;
    private int rating;
    private int tokens;
    private static int nextId = 1000;
    
    /**Constructor for the pass object. Creates a pass with a name, rating, tokens and an ID. The ID is created uniformly
     * based upon the static object nextId, and is automatically generated
     * @param nam is the name of the user of the pass
     * @param rat is the rating of the pass for the user
     * @param tkns is the amount of tokens the user starts with
     */
    public Pass(String nam, int rat, int tkns)
    {
        name = nam;
        rating = rat;
        tokens = tkns;
        passId = ++nextId;
    }
    
    /** Returns the name of the pass user
     * @return a string of the name of the pass user
     */
    public String getName()
    {
        return name;
    }
    
    /**Returns the ID of the pass user as an integer
     * @return an integer of the ID of the user
     */
    public int getId()
    {
        return passId;
    }

    /** Returns the rating of the pass user as an integer
     * @return an integer of the User's pass rating
     */
    public int getRating()
    {
        return rating;
    }
    
    /** adds tokens to the users balance
     * @param tkn is an integer of how many tokens to add.
     */
    public void addTokens(int tkn)
    {
        tokens = tokens + tkn;
    }
    
    /** displays the amount of tokens a pass has in it's balance
     *  @return an integer displaying the amount of tokens in the balance.
     */  
    public int getTokens()
    {
        return tokens;
    }
    /** Removes tokens from the account based upon the input
     * @param tkn is an integer representing the amount of tokens to remove
     */
    public void deductTokens(int tkn)
    {
        tokens = tokens - tkn;
    }
    
    /** Abstract method for the entry of a pass into a cavern
     */
    public abstract void enterCavern();
    
    /** Abstract method displaying whether a pass has enough tokens to enter a Cavern
     * @return is a boolean displaying whether the pass has enough tokens.
     */
    public abstract boolean hasTokens();
    
    /** Returns all information about Pass, including ID of the pass, Name of Pass Owner,
     * the rating they have on the pass and the amount of tokens left in their account
     * @return a String with all information about the pass object.
     */
    public String toString()
    {
        return  "\nPass No: " + passId 
            + "\nName: " + name + "\nRating: " + rating 
            + "\nTokens: " + tokens;       
    } 
}
