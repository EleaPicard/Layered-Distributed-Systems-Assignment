/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author eleap
 */
@Named(value = "jobDescriptionBean")
@SessionScoped
public class JobDescriptionBean implements Serializable {
    
    private static ArrayList<JobDescription> jobs = new ArrayList<>();
    private Integer id;
    private String title;
    private String keywords;
    private String description;
    private double paymentOffer;
    private String state;
    private Integer providerId;

    /**
     * Creates a new instance of JobDescriptionBean
     */
    public JobDescriptionBean() {
        // add job description if list is empty
        if (jobs.size() < 1) {
            jobs.add(new JobDescription(jobs.size()+1,"Engineer","IT","",21053,"open",3));
            jobs.add(new JobDescription(jobs.size()+1,"Mason","Old house","",15869,"closed",1));
            jobs.add(new JobDescription(jobs.size()+1,"Engineer","Electronic","",23000,"open",4));
            jobs.add(new JobDescription(jobs.size()+1,"Senior HR","HR","",25450,"open",4));
        }
    }
    
    /**
     * Returns all Job Descriptions
     *
     * @return all Job Descriptions
     */
    public ArrayList<JobDescription> getAllJobDescriptions() {
        return jobs;
    }
    
    /**
     * Method to add a new Job Description to the collection. values will be taken
     * from attributes
     */
    public void addJobDescription() {
        jobs.add(new JobDescription(jobs.size()+1,title,keywords,description,paymentOffer,state,providerId));
    }

    /**
     * Method to removes a Job Description from the collection
     * @param j Job Description to be removed
     */
    public void removeJobDescription(JobDescription j) {
        jobs.remove(j);
    }
    
    /**
     * Return a list of all job description with a given provider
     *
     * @param id Id of provider to look for
     * @return List containing all job description with given provider
     */
    public List<JobDescription> getJobDescriptionByProviderId(Integer id) {
        ArrayList<JobDescription> result = new ArrayList<>();
        // find all job description with a given provider and add to result
        for (JobDescription j : jobs) {
            if (j.getProviderId().compareTo(id) == 0) {
                result.add(j);
            }
        }
        return result;
    }
    
    /**
     * Return a list of all opened job description
     *
     * @return List containing all open job description
     */
    public List<JobDescription> getJobDescriptionByState() {
        ArrayList<JobDescription> result = new ArrayList<>();
        for (JobDescription j : jobs) {
            if ("open".equals(j.getState())) {
                result.add(j);
            }
        }
        return result;
    }
       
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
     * Get the value of the title
     *
     * @return the value of the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Set the value of the title
     *
     * @param title new value of the title
     */
    public void setTitle(String title) {
        this.title = title;
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
     * Get the value of the description
     *
     * @return the value of the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Set the value of the description
     *
     * @param description new value of the description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Get the value of the payment offer
     *
     * @return the value of the payment offer
     */
    public double getPaymentOffer() {
        return paymentOffer;
    }

    /**
     * Set the value of the paymentOffer
     *
     * @param paymentOffer new value of the paymentOffer
     */
    public void setPaymentOffer(double paymentOffer) {
        this.paymentOffer = paymentOffer;
    }

    /**
     * Get the value of the state
     *
     * @return the value of the state
     */
    public String getState() {
        return state;
    }

    /**
     * Set the value of the state
     *
     * @param state new value of the state
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * Get the value of the provider id
     *
     * @return the value of the provider id
     */
    public Integer getProviderId() {
        return providerId;
    }

    /**
     * Set the value of the provider id
     *
     * @param providerId new value of the provider id
     */
    public void setProviderId(Integer providerId) {
        this.providerId = providerId;
    }
   
    
}
