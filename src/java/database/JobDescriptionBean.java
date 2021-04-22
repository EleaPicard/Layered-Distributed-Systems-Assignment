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
    LogBean logs = new LogBean();
    ArrayList<Log> logsList = logs.getAllLogs();
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

            jobs.add(new JobDescription(jobs.size()+1,"Engineer","IT",
                    "",21053,"Open",3));
            jobs.add(new JobDescription(jobs.size()+1,"Mason","Old house",
                    "",15869,"Closed",1));
            jobs.add(new JobDescription(jobs.size()+1,"Plumber","Old house",
                    "",16500,"Completed",1));
            jobs.add(new JobDescription(jobs.size()+1,"Engineer","Electronic",
                    "",23000,"Open",4));
            jobs.add(new JobDescription(jobs.size()+1,"Senior HR","HR",
                    "",25450,"Open",4));
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
     * Method to add a new Job Description to the collection. 
     * values will be taken from attributes
     */
    public void addJobDescription() {
        jobs.add(new JobDescription(jobs.size()+1,title,keywords,description,
                paymentOffer,state,providerId));
    }
    
    /**
     * Method to add a new Job Description to the collection.
     * values will be taken from attributes and the user ID
     * @param UserID
     */
    public void addJobDescriptionProvider(Integer UserID) {
        state="Open";
        jobs.add(new JobDescription(jobs.size()+1,title,keywords,
                description,paymentOffer,state,UserID));
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
     * Return a the title of a job description with a given provider
     *
     * @param id Id of provider to look for
     * @return Title of a job description with given provider
     */
    public String getJobDescriptionTitleById(Integer id) {
        String title="";
        // find all job description with a given provider
        for (JobDescription j : jobs) {
            if (j.getId().compareTo(id) == 0) {
                title=j.getTitle();
            }
        }
        return title;
    }
    
    /**
     * Return a list of all job description with a given provider that are not 
     * marked as Completed
     *
     * @param id Id of provider to look for
     * @return List containing all open/closed job description of given provider
     */
    public List<JobDescription> 
        getNotCompletedJobDescriptionByProviderId(Integer id) {
        ArrayList<JobDescription> result = new ArrayList<>();
        // find all job description with a given provider and add to result
        for (JobDescription j : jobs) {
            if (j.getProviderId().compareTo(id) == 0 
                    && !"Completed".equals(j.getState())) {
                result.add(j);
            }
        }
        return result;
    }
        
    /**
     * Return a list of all job description with a given provider that are  
     * marked as Open
     *
     * @param id Id of provider to look for
     * @return List containing all Open job description of given provider
     */
    public List<JobDescription> getOpenJobDescriptionByProviderId(Integer id) {
        ArrayList<JobDescription> result = new ArrayList<>();
        // find all job description with a given provider and add to result
        for (JobDescription j : jobs) {
            if (j.getProviderId().compareTo(id) == 0 
                    && "Open".equals(j.getState())) {
                result.add(j);
            }
        }
        return result;
    }
    
    /**
     * Return a list of all job description with a given provider that are  
     * marked as Closed
     *
     * @param id Id of provider to look for
     * @return List containing all Closed job description of given provider
     */
    public List<JobDescription> getClosedJobDescriptionByProviderId(Integer id) {
        ArrayList<JobDescription> result = new ArrayList<>();
        // find all job description with a given provider and add to result
        for (JobDescription j : jobs) {
            if (j.getProviderId().compareTo(id) == 0 
                    && "Closed".equals(j.getState())) {
                result.add(j);
            }
        }
        return result;
    }
        
    /**
     * Return a list of all job description with a given provider that are 
     * marked as completed
     *
     * @param id Id of provider to look for
     * @return List containing all open/closed job description of given provider
     */
    public List<JobDescription> 
        getCompletedJobDescriptionByProviderId(Integer id) {
        ArrayList<JobDescription> result = new ArrayList<>();
        // find all job description with a given provider and add to result
        for (JobDescription j : jobs) {
            if (j.getProviderId().compareTo(id) == 0 
                    && "Completed".equals(j.getState())) {
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
    public List<JobDescription> getAllOpenJobDescription() {
        ArrayList<JobDescription> result = new ArrayList<>();
        for (JobDescription j : jobs) {
            if ("Open".equals(j.getState())) {
                result.add(j);
            }
        }
        return result;
    }
    
    /**
     * Return a list of opened job description with corresponding id
     *
     * @param id Id of job description to look for
     * @return list containing open job description with corresponding id
     */
    public List<JobDescription> getOpenJobDescriptionById(Integer id) {
        ArrayList<JobDescription> result = new ArrayList<>();
        for (JobDescription j : jobs) {
            if ("Open".equals(j.getState()) && j.getId().compareTo(id) == 0) {
                result.add(j);
            }
        }
        return result;
    }
    
    /**
     * Return a list of opened job description with corresponding keyword
     *
     * @param keyword Keyword of job description to look for
     * @return list containing open job description with corresponding keyword
     */
    public List<JobDescription> getOpenJobDescriptionByKeyword(String keyword) {
        ArrayList<JobDescription> result = new ArrayList<>();
        if (!"".equals(keyword)) {
            for (JobDescription j : jobs) {
                String chaine = j.getKeywords();
                int pos = chaine.indexOf(keyword);
                if ("Open".equals(j.getState()) 
                        && (pos != -1)) {
                    result.add(j);
                }
            }
        }
        return result;
    }
    
    /**
     * Return a job description with corresponding id
     *
     * @param id Id of job description to look for
     * @return a job description with corresponding id
     */
    public JobDescription getJobDescriptionById(Integer id) {
        JobDescription result = new JobDescription();
        for (JobDescription j : jobs) {
            if (j.getId().compareTo(id) == 0) {
                result = j;
            }
        }
        return result;
    }
    
    /**
     * Method to complete a Job and pay the freelancer
     * Values will be taken from attributes 
     * @param j Job description
     * @param appBean DataTable of JobApplication
     * @param freeBean DataTable of Freelancer
     */ 
    public void jobCompleted (JobDescription j, JobApplicationBean appBean, FreelancerBean freeBean) {
        j.setState("Completed");
        double payment = j.getPaymentOffer();
        Integer descId = j.getId();
        Integer freeId = appBean.getFreelancerFromDescription(descId);
        freeBean.payFreelancer(freeId, payment);
    }
    
    /**
     * Method to close a Job and add a log of the action
     * Values will be taken from attributes 
     * @param a Job application
     * @param type Role of the person doing the action
     * @param user Name of the person doing the action
     */ 
    public void jobClosedProvider (JobApplication a, String type, String user) {
        for (JobDescription j : jobs) {
            if (j.getId().compareTo(a.getDescriptionId()) == 0) {
                j.setState("Closed");
                logs.addLogJobClosed(type, user);
            }
        }
    }
   
    /**
     * Method to add a log when a Job is undertaken
     * Values will be taken from attributes 
     * @param type Role of the person doing the action
     * @param user Name of the person doing the action
     */  
    public void undertakeJob (String type, String user) {
        logs.addLogUndertakeJob(type, user);
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
