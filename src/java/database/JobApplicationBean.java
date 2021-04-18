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
    private Integer descriptionId;
    private Integer freelancerId;

    public JobApplicationBean() {
        // add job application if list is empty
        if (applications.size() < 1) {
            applications.add(new JobApplication(applications.size()+1,2,1));
            applications.add(new JobApplication(applications.size()+1,4,2));
            applications.add(new JobApplication(applications.size()+1,2,4));
            applications.add(new JobApplication(applications.size()+1,1,1));
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
    
    //////////////
    // METHODS //
    ////////////
    
    /**
     * Method to add a new Job Application to the collection.
     * values will be taken from attributes
     */
    public void addJobApplication() {
        applications.add(new JobApplication(
                applications.size()+1, descriptionId, freelancerId));
    }
    
    /**
     * Method to add a new Job Application to the collection.
     * values will be taken from descriptionId attribute and the freelancer ID
     * @param userID
     */
    public void addJobApplicationFreelancer(Integer userID) {
        applications.add(new JobApplication(
                applications.size()+1, descriptionId, userID));
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
    public List<JobApplication> getJobApplicationByDesciptionId(Integer id) {
        ArrayList<JobApplication> result = new ArrayList<>();
        // find all applications for a given job description and add to result
        for (JobApplication a : applications) {
            if (a.getDescriptionId().compareTo(id) == 0) {
                result.add(a);
            }
        }
        return result;
    }
    
    /**
     * Return a list of all job applications with a given job description id
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
    
}
