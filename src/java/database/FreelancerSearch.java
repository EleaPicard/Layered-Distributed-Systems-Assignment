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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }
  

    /**
     * Creates a new instance of FreelancerSearch
     */
    public FreelancerSearch() {
    }
    
    public boolean idNotEmpty() {
        boolean returnvalue = true;
        if (id == null) returnvalue=false;
        return returnvalue;
    }
    
    public boolean keywordsNotEmpty() {
        boolean returnvalue = true;
        if (keywords == null || keywords =="") returnvalue=false;
        return returnvalue;
    }
}
