/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntrepriseBeans;

import javax.ejb.Remote;

/**
 * Remote interface for the EJB UserLogIn
 *
 * @author vince
 */
@Remote
public interface UserLogInRemote {
    // Method to check if there is a matching username and password 
    // in the lists of users, and return his type
    public String lookForType(String userName, String password);
    // Method to retrieve the user ID
    public Integer lookForId(String userName, String type);
}
