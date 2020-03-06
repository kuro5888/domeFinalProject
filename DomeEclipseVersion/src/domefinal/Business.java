package domefinal;

/**
 * A class to represent the business variation of the Pass object. The class inherits from the Pass Class,
 * and creates an object with values flexible to the business users, with ratings and token amounts being set
 * by the company purchasing the pass.
 * 
 * Ben Allan
 * 17/12/19
 */
public class Business extends Pass
{
    private String company;
    
    /** Constructor for the Business object. Constructs an object with a name, rating, ID value,
     * token value,rating value and company name.
     * @param nam is the name of the user of the pass
     * @param rat is the rating of the pass for the user
     * @param tkns is the amount of tokens the user starts with
     * @param comp is the name of the company who's employee is using the pass
     */
    public Business(String nam, int rat, int tkns, String comp)
    {
        super(nam, rat, tkns);
        company = comp;
    }
    
    /** returns the name of the Company who's sponsored the pass
     * @return returns the name of the company
     */
    public String getCompanyName()
    {
        return company;
    }
    
    /** removes 4 tokens upon entry to the cavern
     */
    public void enterCavern()
    {
        deductTokens(4) ;
    }
    /** displays a boolean whether the user has 4 or more tokens left in their balance
     * @return a boolean that returns true if the user has 4 or more tokens in their balance
     */  
    public boolean hasTokens()
    { 
        return getTokens() >=4; 
    }
    
    /** Returns all information on the pass, as well as displaying pass type and company name
     * method calls the toString method from 'Pass' to house the full data of the object
     * @return is a String representation of the Business Pass
     */
    public String toString()
    {
        return "***Business Pass ***" + super.toString() + "\nCompany : " + company + "\n";       
    } 
   
}