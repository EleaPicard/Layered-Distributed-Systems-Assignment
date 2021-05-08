/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntrepriseBeans;

import database.AdministratorBean;
import database.FreelancerBean;
import database.ProviderBean;
import database.Administrator;
import database.BCrypt;
import database.Freelancer;
import database.Provider;
import java.util.ArrayList;

import javax.ejb.Stateless;

/**
 * Stateless EJB used to verify if there is a user with matching username 
 * and password in the databases ; retrieve its type and ID if so.
 *
 * @author vince
 */
@Stateless
public class UserLogIn implements UserLogInRemote{
    
    /**
     * Method to check if there is a matching username and password 
     * in the lists of users, and return his type
     *
     * @param userName username entered by the user connecting to the website
     * @param password password entered by the user connecting to the website
     * @return type of the user (Administrator/Provider/Freelancer)
     */
    @Override
    public String lookForType(String userName, String password) {
        // Create an empty String
        String type = "";
        // Create instances of the managed beans of the three user databases
        AdministratorBean administrators = new AdministratorBean();
        ProviderBean providers = new ProviderBean();
        FreelancerBean freelancers = new FreelancerBean();
        
        // Retrieve the list of all the administrators
        ArrayList<Administrator> admins = administrators.getAllAdministrators();
        // Retrieve the list of all the job providers
        ArrayList<Provider> pro = providers.getAllProviders();
        // Retrieve the list of all the freelancers
        ArrayList<Freelancer> free = freelancers.getAllFreelancers();
        
        // Initialise a String representing the name of each admin
        String adminName;
        // Go through the list of administrators
        for (Administrator a : admins) {
            // Retrieve the name of the current admin in the list
            adminName = a.getName();
            // If the name match the one entered by the connecting user
            if(userName.equals(adminName)) {
                // Retrieve the password of the current admin in the list
                String adminPassword = a.getPassword();
                // If the password match the one entered by the connecting user 
                boolean matched = BCrypt.checkpw(password, adminPassword);
                if (matched) {
                    // Set the user type to "Administrator"
                    type = "Administrator";
                    // Exit the loop
                    break;   
                }
            }
        }
        // If the user type has not been set to "Administrator"
        if (!type.equals("Administrator")){
            // Initialise a String representing the name of each provider
            String providerName;
            // Go through the list of providers
            for (Provider p : pro) {
                // Retrieve the name of the current provider in the list
                providerName = p.getName();
                // If the name match the one entered by the connecting user
                if (userName.equals(providerName)) {
                    // Retrieve the password of the current provider in the list
                    String providerPassword = p.getPassword();
                    // If the password match the one entered by 
                    // the connecting user
                    boolean matched = BCrypt.checkpw(password, 
                            providerPassword);
                    if (matched) {
                        // Set the user type to "Provider"
                        type = "Provider";
                        // Exit the loop
                        break;
                    }
                }
            }
        }
        // If the user type has not been set to "Administrator" 
        // and not "Provider"    
        if (!type.equals("Administrator") && !type.equals("Provider")) {
            // Initialise a String representing the name of each freelancer
            String freelancerName;
            // Go through the list of freelancers
            for (Freelancer f : free) {
                // Retrieve the name of the current freelancer in the list
                freelancerName = f.getName();
                // If the name match the one entered by the connecting user
                if (userName.equals(freelancerName)) {
                    // Retrieve the password of the current 
                    // freelancer in the list
                    String freelancerPassword = f.getPassword();
                    // If the password match the one entered by 
                    // the connecting user
                    boolean matched = BCrypt.checkpw(password, 
                            freelancerPassword);
                    if (matched) {
                        // Set the user type to "Freelancer"
                        type = "Freelancer";
                        // Exit the loop
                        break;
                    }
                }
            }
            // If the user type is not set to "Administrator", "Provider" 
            // or "Freelancer" i.e. the username or the password is not matching
            // Set the type to "error"
            if (!type.equals("Freelancer")) {
                type = "error";
            }
        }
        // Return the user type
        return type;
    }
    
    /**
     * Method to retrieve the user ID.
     * This method is called only if the user has successfully signed in to the 
     * website
     *
     * @param userName Name of the user
     * @param type User type (Administrator/Provider/Freelancer)
     * @return User ID
     */
    @Override
    public Integer lookForId(String userName, String type) {
        // Initialise the user ID
        Integer id = 0;
        // Create instances of the managed beans of the three user databases
        AdministratorBean administrators = new AdministratorBean();
        ProviderBean providers = new ProviderBean();
        FreelancerBean freelancers = new FreelancerBean();
        // If the user type is set to "Administrator"
        if ("Administrator".equals(type)) {
            // Retrieve the list of all the administrators
            ArrayList<Administrator> admins = 
                    administrators.getAllAdministrators();
            // Go through the list of administrators
            for (Administrator a : admins) {
                // Retrieve the name of the current administrator
                String amdinName = a.getName();
                // If the admin name matches with the connected user
                if (userName.equals(amdinName)) {
                    // Retrieve the ID
                    id = a.getId();
                }
            }
        } else if("Provider".equals(type)) {
            // Retrieve the list of all the providers
            ArrayList<Provider> pro = providers.getAllProviders();
            // Go through the list of providers
            for (Provider p : pro) {
                // Retrieve the name of the current provider
                String providerName = p.getName();
                // If the provider name matches with the connected user
                if (userName.equals(providerName)) {
                    // Retrieve the ID
                    id = p.getId();
                }
            }
        } else {
            // Retrieve the list of all the freelancers
            ArrayList<Freelancer> free = freelancers.getAllFreelancers();
            // Go through the list of freelancers
            for (Freelancer f : free) {
                // Retrieve the name of the current freelancer
                String freelancerName = f.getName();
                // If the freelancer name matches with the connected user
                if (userName.equals(freelancerName)) {
                    // Retrieve the ID
                    id = f.getId();
                }
            }
        }
        // Return the ID
        return id;
    }
}
