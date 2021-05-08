package database;

import database.Freelancer;
import database.FreelancerBean;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

/**
 * Managed Bean Database for Job Applications
 *
 * @author vince
 */
@Named(value = "jobApplicationBean")
@SessionScoped
public class JobApplicationBean implements Serializable {
    private static ArrayList<JobApplication> applications = new ArrayList<>();
    FreelancerBean fre = new FreelancerBean();
    ArrayList<Freelancer> freList = fre.getAllFreelancers();
    JobDescriptionBean jobs = new JobDescriptionBean();
    ArrayList<JobDescription> jobsList = jobs.getAllJobDescriptions();
    private Integer applicationId;
    private Integer providerId;
    private Integer descriptionId;
    private String descriptionTitle;
    private Integer freelancerId;
    private String freelancerName;
    private String state;

    /**
     * Creates a new instance of JobApplicationBean
     */
    public JobApplicationBean() {
        // add job application if list is empty
        if (applications.size() < 1) {
            applications.add(new JobApplication(
                    applications.size()+1, 4, 4, 
                    jobs.getJobDescriptionTitleById(4), 1, 
                    fre.getFreelancerNameById(1), "Pending"));
            applications.add(new JobApplication(
                    applications.size()+1, 4, 4, 
                    jobs.getJobDescriptionTitleById(4), 2, 
                    fre.getFreelancerNameById(2), "Pending"));
            applications.add(new JobApplication(
                    applications.size()+1, 1, 2, 
                    jobs.getJobDescriptionTitleById(2), 3, 
                    fre.getFreelancerNameById(3), "Accepted"));
            applications.add(new JobApplication(
                    applications.size()+1, 3, 1, 
                    jobs.getJobDescriptionTitleById(1), 1, 
                    fre.getFreelancerNameById(1), "Pending"));
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
     * Get the Title of the job description for a job application
     *
     * @return Title of the job description
     */
    public String getDescriptionTitle() {
        return descriptionTitle;
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
     * Get the Name of the freelancer for a job application
     *
     * @return Name of the freelancer
     */
    public String getFreelancerName() {
        return freelancerName;
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
     * Set the job description title of a job application
     *
     * @param descriptionTitle Title of the job description
     */
    public void setDescriptionTitle(String descriptionTitle) {
        this.descriptionTitle = descriptionTitle;
    }

    /**
     * Set the freelancer Id of a job application
     *
     * @param freelancerId ID of the freelancer
     */
    public void setFreelancerId(Integer freelancerId) {
        this.freelancerId = freelancerId;
    }

    /**
     * Set the freelancer name of a job application
     *
     * @param freelancerName Name of the freelancer
     */
    public void setFreelancerName(String freelancerName) {
        this.freelancerName = freelancerName;
    }
    
    /**
     * Set the state of a job application
     *
     * @param newState state of the application
     */
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
                applications.size()+1, providerId, descriptionId, descriptionTitle, freelancerId, freelancerName, "Pending"));
    }
    
    /**
     * Method to add a new Job Application to the collection. 
     * Values will be taken from descriptionId attribute and the freelancer ID
     * 
     * @param userID ID of the Freelancer applying for a job
     * @param jobs Instance of the managedBean JobDescription
     * @param type User type, either Admin, Provider or Freelancer 
     * (the applicant is normally a Freelancer)
     * @param userName Name of the user applying for a job
     */
    public void addJobApplicationFreelancer(Integer userID, 
            JobDescriptionBean jobs, String type, String userName) {
        // Retrieve the job description the Freelancer is applying for
        JobDescription j = jobs.getJobDescriptionById(descriptionId);
        // Create a new application for the job
        applications.add(new JobApplication(
                applications.size()+1, j.getId(), descriptionId, j.getTitle(), userID, userName, "Pending"));
        // Call the method in JobDescriptionBean to add a new log entry
        jobs.undertakeJob(type, userName);
    }
    
    /**
     * Method to removes a Job Application from the collection
     * 
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
        // Create an empty list of job application
        ArrayList<JobApplication> result = new ArrayList<>();
        // Go through all the job applications
        for (JobApplication a : applications) {
            // If the Provider ID is matching
            if (a.getProviderId().compareTo(id) == 0) {
                // If the application is NOT marked as "Rejected"
                if (!"Rejected".equals(a.getState())) {
                    // Add the application to the list
                    result.add(a);
                }
            }
        }
        // Return the list of all non rejected applications for a given provider
        return result;
    }
    
    /**
     * Return a list of all job applications with a given freelancer id
     *
     * @param id Id of job description to look for
     * @return List containing all job applications with given description
     */
    public List<JobApplication> getJobApplicationByFreelancerId(Integer id) {
        // Create an empty list of job application
        ArrayList<JobApplication> result = new ArrayList<>();
        // Go through all the job applications
        for (JobApplication a : applications) {
            // If the Freelancer ID is matching
            if (a.getFreelancerId().compareTo(id) == 0) {
                // Add the application to the list
                result.add(a);
            }
        }
        // Return the list of all applications for a given Freelancer
        return result;
    }
    
    /**
     * Return a list of Pending job applications with a given freelancer id
     *
     * @param id Id of job description to look for
     * @return List containing all job applications with given description
     */
    public List<JobApplication> getPendingApplicationByFreelancerId(Integer id) {
        // Create an empty list of job application
        ArrayList<JobApplication> result = new ArrayList<>();
        // Go through all the job applications
        for (JobApplication a : applications) {
            // If the Freelancer ID is matching
            if (a.getFreelancerId().compareTo(id) == 0) {
                // If the application is marked as "Pending"
                if ("Pending".equals(a.getState())) {
                    // Add the application to the list
                    result.add(a);
                }
            }
        }
        // Return the list of all pending applications for a given Freelancer
        return result;
    }
    
    /**
     * Return a list of Accepted job applications with a given freelancer id
     *
     * @param id Id of job description to look for
     * @return List containing all job applications with given description
     */
    public List<JobApplication> getAcceptedApplicationByFreelancerId(Integer id) {
        // Create an empty list of job application
        ArrayList<JobApplication> result = new ArrayList<>();
        // Go through all the job applications
        for (JobApplication a : applications) {
            // If the Freelancer ID is matching
            if (a.getFreelancerId().compareTo(id) == 0) {
                // If the application is marked as "Accepted"
                if ("Accepted".equals(a.getState())) {
                    // Add the application to the list
                    result.add(a);
                }
            }
        }
        // Return the list of all accepted applications for a given Freelancer
        return result;
    }
    
   /**
     * Method to accept an application
     *
     * @param jobDesc DataTable of job description 
     * @param type Role of the user
     * @param user Name of the user
     * @param userId Id of the user
     * @return the destination
     */
    public String acceptApplication(JobDescriptionBean jobDesc, String type, 
            String user, Integer userId) {
        // Initialise an Integer
        Integer des_id = 0;
        // Create an empty job application
        JobApplication a = new JobApplication();
        // Go through all the job applications
        for (JobApplication app : applications) {
            // If the application ID and the ID of the provider are matching
            if ((app.getApplicationId().compareTo(applicationId) == 0)&& 
                    (app.getProviderId().compareTo(userId) == 0)) {
                // Set the application as "Accepted"
                app.setState("Accepted");
                // Retrieve the ID of the job description in the application
                des_id = app.getDescriptionId();
                // The empty job application copy the matching application
                a = new JobApplication(app);
            }
        }
        // Go through all the job applications, again
        for (JobApplication app : applications) {
            // Find the other applications for the job
            if ((app.getDescriptionId().compareTo(des_id) == 0)&& 
                    (app.getProviderId().compareTo(userId) == 0)) {
                // Set applications that have not been accepted to "Rejected"
                if ("Pending".equals(app.getState())) {
                    app.setState("Rejected");
                }
            }
        }
        // Add a new entry in the log
        jobDesc.jobClosedProvider(a, type, user);
        
        // Return value used for HTML navigation
        return "providerTables";
    }
    
    /**
     * Method to obtain a Freelancer from a description
     *
     * @param descId Id of the description
     * @return Id of the freelancer
     */
    public Integer getFreelancerFromDescription(Integer descId) {
        // Initialise an Integer
        Integer freeId = 0;
        // Go through all the job applications
        for (JobApplication a : applications) {
            // If the job description ID of the application is matching
            if (a.getDescriptionId().compareTo(descId) == 0) {
                // If the application is marked as "Accepted"
                if("Accepted".equals(a.getState())) {
                    // Retrieve the ID of the freelancer that 
                    // has been accepted for the job
                    freeId = a.getFreelancerId();
                }
            }
        }
        // Return the freelancer ID
        return freeId;
    }
    
    /**
     * Method to show applicants by provider id
     *
     * @param freBean DataTable of freelancer 
     * @param id Id of the provider
     * @return the tree set of the applicants
     */
    public TreeSet<Freelancer> showApplicantByProviderId(Integer id, 
            FreelancerBean freBean) {
        // Create an empty TreeSet of Freelancer
        // TreeSet have the advantage of avoiding duplicates and 
        // keeping the objects inside in order
        TreeSet<Freelancer> result = new TreeSet<>();
        // Get the list of job applications for a given provider ID
        List<JobApplication> providerDesc = 
                this.getJobApplicationByProviderId(id);
        // Go through all the applications for the provider
        for (JobApplication a : providerDesc) {
            // If the application is not rejected
            if (!"Rejected".equals(a.getState())) {
                // Add the application to the TreeSet
                result.add(freBean.getFreelancerById(a.getFreelancerId()));
            }
        }
        // Return the TreeSet of not rejected applications for a given provider
        return result;
    }
    
}
