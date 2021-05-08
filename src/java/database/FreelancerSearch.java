/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 * Managed Bean for the job search by ID and by Keywords for the Freelancers
 *
 * @author eleap
 */
@Named(value = "freelancerSearch")
@RequestScoped
public class FreelancerSearch {
    
    private Integer id; 
    private String keywords;

    /**
     * Get the value of the ID
     *
     * @return the value of the ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * Set the value of the ID
     *
     * @param id new value of the ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Get the value of the keywords
     *
     * @return the value of the keywords
     */
    public String getKeywords() {
        return keywords;
    }

    /**
     * Set the value of the keywords
     *
     * @param keywords new value of the keywords
     */
    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }
  

    /**
     * Creates a new instance of FreelancerSearch
     */
    public FreelancerSearch() {
    }
    
    /**
     * Method to verify if the id is not empty
     */ 
    public boolean idNotEmpty() {
        // Initialise a boolean to "true"
        boolean returnvalue = true;
        // If the ID is "empty", set the boolean to "false"
        if (id == null) returnvalue=false;
        // Return the boolean
        return returnvalue;
    }
    
    /**
     * Method to verify if the keywords is not empty
     */ 
    public boolean keywordsNotEmpty() {
        // Initialise a boolean to "true"
        boolean returnvalue = true;
        // If the keyword is null or an empty Sring, set the boolean to "false"
        if (keywords == null || keywords =="") returnvalue=false;
        // Return the boolean
        return returnvalue;
    }
}
