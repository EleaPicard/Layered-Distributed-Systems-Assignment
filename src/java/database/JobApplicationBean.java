package database;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vince
 */
@Named(value = "jobApplicationBean")
@SessionScoped
public class JobApplicationBean implements Serializable {
    private static ArrayList<JobApplication> applications = new ArrayList<>();
    private Integer applicationId;
    private Integer providerId;
    private Integer descriptionId;
    private Integer freelancerId;
    private String state;

    public JobApplicationBean() {
        // add job application if list is empty
        if (applications.size() < 1) {
            applications.add(new JobApplication(
                    applications.size()+1,4,4,1, "Pending"));
            applications.add(new JobApplication(
                    applications.size()+1,4,4,2, "Pending"));
            applications.add(new JobApplication(
                    applications.size()+1,1,2,3, "Accepted"));
            applications.add(new JobApplication(
                    applications.size()+1,3,1,1, "Pending"));
        }
    }
    
    //////////////
    // GETTERS //
    ////////////

    /**
     * Returns all job Applications
     *
     * @return all job Applications
     */
    public ArrayList<JobApplication> getAllJobApplications() {
        return applications;
    }

    /**
     * Get the Id of a Job Application
     *
     * @return ID of the application
     */
    public Integer getApplicationId() {
        return applicationId;
    }
    
    /**
     * Get the Id of the job provider for a job application
     *
     * @return ID of the job provider
     */
    public Integer getProviderId() {
        return providerId;
    }

    /**
     * Get the Id of the job description for a job application
     *
     * @return ID of the job description
     */
    public Integer getDescriptionId() {
        return descriptionId;
    }

    /**
     * Get the Id of the freelancer for a job application
     *
     * @return ID of the freelancer
     */
    public Integer getFreelancerId() {
        return freelancerId;
    }
    
    /**
     * Get the state of a job application
     *
     * @return state of the application
     */
    public String getState() {
        return state;
    }
    
    //////////////
    // SETTERS //
    ////////////

    /**
     * Set the Id of a job application
     *
     * @param applicationId ID of the application
     */
    public void setApplicationId(Integer applicationId) {
        this.applicationId = applicationId;
    }
    
    /**
     * Set the job provider Id of a job application
     *
     * @param providerId ID of the job provider
     */
    public void setProviderId(Integer providerId) {
        this.providerId = providerId;
    }

    /**
     * Set the job description Id of a job application
     *
     * @param descriptionId ID of the job description
     */
    public void setDescriptionId(Integer descriptionId) {
        this.descriptionId = descriptionId;
    }

    /**
     * Set the freelancer Id of a job application
     *
     * @param freelancerId ID of the freelancer
     */
    public void setFreelancerId(Integer freelancerId) {
        this.freelancerId = freelancerId;
    }
    
    public void setState(String newState) {
        this.state = newState;
    }
    
    //////////////
    // METHODS //
    ////////////
    
    /**
     * Method to add a new Job Application to the collection.
     * values will be taken from attributes
     */
    public void addJobApplication() {
        applications.add(new JobApplication(
                applications.size()+1, providerId, descriptionId, freelancerId, "Pending"));
    }
    
    /**
     * Method to add a new Job Application to the collection.
     * values will be taken from descriptionId attribute and the freelancer ID
     * 
     * @param userID
     * @param jobs
     */
    public void addJobApplicationFreelancer(Integer userID, JobDescriptionBean jobs) {
        JobDescription j = jobs.getJobDescriptionById(descriptionId);
        applications.add(new JobApplication(
                applications.size()+1, j.getId(), descriptionId, userID, "Pending"));
    }
    
    /**
     * Method to removes a Job Application from the collection
     * @param a application to be removed
     */
    public void removeJobApplication(JobApplication a){
        applications.remove(a);
    }
    
    /**
     * Return a list of all job applications with a given job description id
     *
     * @param id Id of job description to look for
     * @return List containing all job applications with given description
     */
    public List<JobApplication> getJobApplicationByProviderId(Integer id) {
        ArrayList<JobApplication> result = new ArrayList<>();
        // find all applications for a given job description and add to result
        for (JobApplication a : applications) {
            if (a.getProviderId().compareTo(id) == 0) {
                result.add(a);
            }
        }
        return result;
    }
    
    /**
     * Return a list of all job applications with a given freelancer id
     *
     * @param id Id of job description to look for
     * @return List containing all job applications with given description
     */
    public List<JobApplication> getJobApplicationByFreelancerId(Integer id) {
        ArrayList<JobApplication> result = new ArrayList<>();
        // find all applications for a given job description and add to result
        for (JobApplication a : applications) {
            if (a.getFreelancerId().compareTo(id) == 0) {
                result.add(a);
            }
        }
        return result;
    }
    
    public String acceptApplication(JobDescriptionBean jobDesc) {
        Integer des_id = 0;
        JobApplication a = new JobApplication();
        for (JobApplication app : applications) {
            if (app.getApplicationId().compareTo(applicationId) == 0) {
                app.setState("Accepted");
                des_id = app.getDescriptionId();
                a = new JobApplication(app);
            }
        }
        for (JobApplication app : applications) {
            if (app.getDescriptionId().compareTo(des_id) == 0) {
                if ("Pending".equals(app.getState())) {
                    applications.remove(app);
                }
            }
        }
        
        jobDesc.jobClosed(a);
        
        return "providerTables";
    }
    
    public Integer getFreelancerFromDescription(Integer descId) {
        Integer freeId = 0;
        for (JobApplication a : applications) {
            if (a.getDescriptionId().compareTo(descId) == 0) {
                if("Accepted".equals(a.getState())) {
                    freeId = a.getFreelancerId();
                }
            }
        }
        return freeId;
    }
    
}
