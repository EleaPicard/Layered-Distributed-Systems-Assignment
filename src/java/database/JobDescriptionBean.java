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
 * Managed Bean Database for Job Descriptions
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
     * 
     * @param UserID
     */
    public void addJobDescriptionProvider(Integer UserID) {
        state="Open";
        jobs.add(new JobDescription(jobs.size()+1,title,keywords,
                description,paymentOffer,state,UserID));
    }
    
    /**
     * Method to removes a Job Description from the collection
     * 
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
        // Create an empty list of job description
        ArrayList<JobDescription> result = new ArrayList<>();
        // Go through all the job descriptions
        for (JobDescription j : jobs) {
            // If the provider ID is matching
            if (j.getProviderId().compareTo(id) == 0) {
                // Add the job to the list
                result.add(j);
            }
        }
        // Return the list of jobs for a given provider
        return result;
    }
    
    /**
     * Return a the title of a job description with a given provider
     *
     * @param id Id of provider to look for
     * @return Title of a job description with given provider
     */
    public String getJobDescriptionTitleById(Integer id) {
        // Create an empty String that will retrieve the value of the job title
        String jobTitle="";
        // Go through all the job descriptions
        for (JobDescription j : jobs) {
            // If the job ID is matching with the one in parameter
            if (j.getId().compareTo(id) == 0) {
                // jobTitle take the title of the matching Job description
                jobTitle=j.getTitle();
            }
        }
        return jobTitle;
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
        // Create an empty list of job description
        ArrayList<JobDescription> result = new ArrayList<>();
        // Go through all the job descriptions
        for (JobDescription j : jobs) {
            // If the job is NOT marked as "Completed" 
            // and has a matching provider ID
            if (j.getProviderId().compareTo(id) == 0 
                    && !"Completed".equals(j.getState())) {
                // Add the job to the list
                result.add(j);
            }
        }
        // Return the list of not completed jobs for a given provider
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
        // Create an empty list of job description
        ArrayList<JobDescription> result = new ArrayList<>();
        // Go through all the job descriptions
        for (JobDescription j : jobs) {
            // If the job is marked as "Open" 
            // and has a matching provider ID
            if (j.getProviderId().compareTo(id) == 0 
                    && "Open".equals(j.getState())) {
                // Add the job to the list
                result.add(j);
            }
        }
        // Return the list of open jobs for a given provider
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
        // Create an empty list of job description
        ArrayList<JobDescription> result = new ArrayList<>();
        // Go through all the job descriptions
        for (JobDescription j : jobs) {
            // If the job is marked as "Closed" 
            // and has a matching provider ID
            if (j.getProviderId().compareTo(id) == 0 
                    && "Closed".equals(j.getState())) {
                // Add the job to the list
                result.add(j);
            }
        }
        // Return the list of closed jobs for a given provider
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
        // Create an empty list of job description
        ArrayList<JobDescription> result = new ArrayList<>();
        // Go through all the job descriptions
        for (JobDescription j : jobs) {
            // If the job is marked as "Completed" 
            // and has a matching provider ID
            if (j.getProviderId().compareTo(id) == 0 
                    && "Completed".equals(j.getState())) {
                // Add the job to the list
                result.add(j);
            }
        }
        // Return the list of completed jobs for a given provider
        return result;
    }
    
    /**
     * Return a list of all opened job description
     *
     * @return List containing all open job description
     */
    public List<JobDescription> getAllOpenJobDescription() {
        // Create an empty list of job description
        ArrayList<JobDescription> result = new ArrayList<>();
        // Go through all the job descriptions
        for (JobDescription j : jobs) {
            // If the job is marked as "Open"
            if ("Open".equals(j.getState())) {
                // Add the job to the list
                result.add(j);
            }
        }
        // Return the list of opened jobs
        return result;
    }
    
    /**
     * Return a list of opened job description with corresponding id
     *
     * @param id Id of job description to look for
     * @return list containing open job description with corresponding id
     */
    public List<JobDescription> getOpenJobDescriptionById(Integer id) {
        // Create an empty list of job description
        ArrayList<JobDescription> result = new ArrayList<>();
        // Go through all the job descriptions
        for (JobDescription j : jobs) {
            // If a job is marked as "Open" and has a matching id
            if ("Open".equals(j.getState()) && j.getId().compareTo(id) == 0) {
                // Add the job to the list
                result.add(j);
            }
        }
        // return the list (Theorically, only one job should be on the list)
        return result;
    }
    
    /**
     * Return a list of opened job description with corresponding keyword
     *
     * @param keyword Keyword of job description to look for
     * @return list containing open job description with corresponding keyword
     */
    public List<JobDescription> getOpenJobDescriptionByKeyword(String keyword) {
        // Create an empty list of job description
        ArrayList<JobDescription> result = new ArrayList<>();
        // If a keyword has been entered by a user
        if (!"".equals(keyword)) {
            // Go through all the job descriptions
            for (JobDescription j : jobs) {
                String chaine = j.getKeywords();
                int pos = chaine.indexOf(keyword);
                // If a job in the database has the wanted keyword 
                // and is marked as "Open"
                if ("Open".equals(j.getState()) 
                        && (pos != -1)) {
                    // Add the job description to the list of results
                    result.add(j);
                }
            }
        }
        // Return the list
        return result;
    }
    
    /**
     * Return a job description with corresponding id
     *
     * @param id Id of job description to look for
     * @return a job description with corresponding id
     */
    public JobDescription getJobDescriptionById(Integer id) {
        // Create a new empty job description
        JobDescription result = new JobDescription();
        // Go through all the job descriptions
        for (JobDescription j : jobs) {
            // If the id in parameter match with a job in the list
            if (j.getId().compareTo(id) == 0) {
                // assign the job in the list to the created job description
                result = j;
            }
        }
        return result;
    }
    
    /**
     * Method to complete a Job and pay the freelancer.
     * Values will be taken from attributes 
     * 
     * @param j Job description
     * @param appBean DataTable of JobApplication
     * @param freeBean DataTable of Freelancer
     */ 
    public void jobCompleted (JobDescription j, JobApplicationBean appBean, 
            FreelancerBean freeBean) {
        // Set the job to "Completed"
        j.setState("Completed");
        // Retrieve the values for payment in the job description
        double payment = j.getPaymentOffer();
        // Retrieve the values for job ID in the job description
        Integer descId = j.getId();
        // Find in the list of job application who is 
        // the freelancer working on the job
        Integer freeId = appBean.getFreelancerFromDescription(descId);
        // Call the method to pay the freelancer
        freeBean.payFreelancer(freeId, payment);
    }
    
    /**
     * Method to close a Job and add a log of the action.
     * Values will be taken from attributes 
     * 
     * @param a Job application
     * @param type Role of the person doing the action
     * @param user Name of the person doing the action
     */ 
    public void jobClosedProvider (JobApplication a, String type, String user) {
        // Go through all the job descriptions
        for (JobDescription j : jobs) {
            // If the job id in parameter match with a job in the list
            if (j.getId().compareTo(a.getDescriptionId()) == 0) {
                // Mark the job as closed
                j.setState("Closed");
                // Add a log entry
                logs.addLogJobClosed(type, user);
            }
        }
    }
   
    /**
     * Method to add a log when a Job is undertaken.
     * Values will be taken from attributes 
     * 
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
