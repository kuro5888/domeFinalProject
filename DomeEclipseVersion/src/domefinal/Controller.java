package domefinal;
/**This interface specifies the methods required to manage a Xanadu dome 
 * which consists of a number of caverns joined by one-way doors.New
 * users(passes)always start in the Outside cavern and may use their 
 * tokens to move to other caverns, provided conditions are met
 *
 * @author A.A.Marczyk 
 * @version 18/11/19
 **/
public interface Controller
{

    /** Returns the name of the dome
     * @return name of the dome
     **/
    public String getDomeName();  
    
    /** Returns all information about the current state of the dome, 
     * including all passes in all caverns, by cavern name
     * @return all information about the current state of the the dome
     **/
    public String toString();  
    
    /** Returns information about all passes (but not location)
     * @return all information about all passes
     **/
    public String getAllPasses();
    
    /** Returns information about cavern names
     * @return all information about all cavern names
     **/
    public String getCavernNames();

    /** Returns a String representation of all the passes in the
     * specified cavern
     * @param cName the name of the specified cavern
     * @return a String representation of all passes in the Cavern
     **/    
    public String passesInCavern(String cName);
    
    /**Returns a String representation of all the passes in all caverns (by cavern)
     * @return a String representation of all passes in all caverns
     **/
    public String passesInAllCaverns();
    
    
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
    public String enterCavern(int pId, int dNo);
    
    
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
    public boolean canEnter(int pId, int dNo);  
    
    /**Returns the cavern which contains the specified pass
     * @param pId is the id of the specified pass
     * @return the name of the Cavern which contains the pass
     **/
    public String findPass(int pId);
    
    /** Allows a pass to top up its tokens.This method is not 
     * concerned with the cost of a token as charges may vary 
     * between facilities.
     * @param pId the id of the pass toping up its tokens
     * @param tkns the number of tokens purchased to be added to
     * the pass.
     */
    public void topUpTokens(int pId, int tkns);
            
    /** Converts a loyalty pass's loyalty points into tokens
     * @param pId the id of the pass whose points are to be converted
     */
    public void convertPoints(int pId);
    
    /** Moves a pass directly to the outside without affecting 
     * tokens or other information and using emergency exits
     * @param pId the id of the pass to be moved to outside
     * @return a message giving the user's name and "to outside"
     */
    public String moveToOutside(int pId);

    /** In an emergency, moves all passes directly back to 
     * the outside  without affecting tokens or other 
     * information using emergency exits
     */
    public void moveAll();
}