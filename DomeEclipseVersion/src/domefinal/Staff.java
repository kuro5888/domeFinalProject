package domefinal;
/**
 * A class to represent the staff variation of the Pass object. The class inherits from the Pass Class,
 * and creates an object with Staff ID and employee number attached to it.
 *
 * Ben Allan
 * 17/12/19
 */
public class Staff extends Pass
{
    private int employeeNo;
    private String jobTitle;
    
    /** constructor for the Staff Pass variation of the pass object. Calls values from the Pass 
     * class as well as applying it's own variations on abstract methods. Includes the unique fields
     * of employee number and job title
     * @param nam is the name of the user of the pass
     * @param emNo is the employee number of the pass owner
     * @param jobT is the job title of the pass owner
     */
    public Staff(String nam, int emNo, String jobT)
    {
        super(nam,10,5);
        employeeNo = emNo;
        jobTitle = jobT;
    }
    
    /** gets the employee number of the pass owner
     * @return returns an integer of the employee number of the pass owner
     */
    public int getEmployeeNo()
    {
        return employeeNo;
    }
    
    /** returns the job title of the staff member
     * @return a string with the job title of the staff member
     */
    public String getJobTitle()
    {
        return jobTitle;
    }
    
    /** removes 1 token from the Pass when the user enters a cavern
     */
    public void enterCavern()
    {
        deductTokens(1) ;
    }
    
    /** returns a boolean on whether the user has 1 or more tokens left in their account
     * @return a boolean that returns true if the user has more than 1 token in their account
     */
    public boolean hasTokens()
    { 
        return getTokens() >=1; 
    }
    
    /** Returns all information on the pass, as well as displaying pass type, employee number and Job title
     * method calls the toString method from 'Pass' to house the full data of the object
     * @return is a String representation of the Staff Pass
     */
    public String toString()
    {
        return "***Staff Pass ***" + super.toString() + "\nEmployee Number : " + employeeNo + "\nJob Title : " + jobTitle + "\n";       
    } 
}