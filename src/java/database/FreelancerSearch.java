/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author eleap
 */
@Named(value = "freelancerSearch")
@RequestScoped
public class FreelancerSearch {
    
    private Integer id; 
    private String keywords;

    /**
     * Get the value of the id
     *
     * @return the value of the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * Set the value of the id
     *
     * @param id new value of the id
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
     * 
     */ 
    public boolean idNotEmpty() {
        boolean returnvalue = true;
        if (id == null) returnvalue=false;
        return returnvalue;
    }
    
    /**
     * Method to verify if the keywords is not empty
     * 
     */ 
    public boolean keywordsNotEmpty() {
        boolean returnvalue = true;
        if (keywords == null || keywords =="") returnvalue=false;
        return returnvalue;
    }
}
