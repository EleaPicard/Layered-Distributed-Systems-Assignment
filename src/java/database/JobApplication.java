package database;

/**
 * Entity Class for Job Applications
 *
 * @author vince
 */
public class JobApplication {
    private Integer applicationId;
    private Integer providerId;
    private Integer descriptionId;
    private String descriptionTitle;
    private Integer freelancerId;
    private String state;
    private String freelancerName;
    
    /**
     * Generate a job Application with the given information
     *
     * @param applicationId unique application ID
     * @param providerId ID of the provider
     * @param descriptionId ID of the job description
     * @param descriptionTitle Title of the job description
     * @param freelancerId ID of the freelancer
     * @param freelancerName Name of the freelancer 
     * @param state state of the application
     */
    public JobApplication(Integer applicationId, Integer providerId, 
            Integer descriptionId, String descriptionTitle,Integer freelancerId,
            String freelancerName, String state) {
        this.applicationId = applicationId;
        this.providerId = providerId;
        this.descriptionId = descriptionId;
        this.descriptionTitle = descriptionTitle;
        this.freelancerId = freelancerId;
        this.freelancerName = freelancerName;
        this.state = state;
    }
    
    /**
     * Default constructor
     */
    public JobApplication() {
    }
    
    /**
     * Copy constructor
     *
     * @param o JobApplication object to copy
     */
    public JobApplication(JobApplication o) {
        this.applicationId = o.getApplicationId();
        this.providerId = o.getProviderId();
        this.descriptionId = o.getDescriptionId();
        this.state = o.getState();
    }
    
    //////////////
    // GETTERS //
    ////////////

    /**
     * Get the Id of a Job Application
     *
     * @return Integer of application ID
     */
    public Integer getApplicationId() {
        return applicationId;
    }
    
    /**
     * Get the Id of a Job Provider in a Job Application
     *
     * @return Integer of provider ID
     */
    public Integer getProviderId() {
        return providerId;
    }
    
    /**
     * Get the Id of a Job Description in a Job Application
     *
     * @return Integer of description ID
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
     * Get the Id of a freelancer applying for a Job Application
     *
     * @return Integer of freelancer ID
     */
    public Integer getFreelancerId() {
        return freelancerId;
    }

    /**
     * Get the name of a freelancer applying for a Job Application
     *
     * @return Integer of freelancer name
     */
    public String getFreelancerName() {
        return freelancerName;
    }
    
    /**
     * Get the state of a Job Application.
     * Either "Accepted", "Pending" or "Rejected"
     *
     * @return String of a application state
     */
    public String getState() {
        return state;
    }
    
    //////////////
    // SETTERS //
    ////////////

    /**
     * Set the Id of a Job Application
     *
     * @param applicationId new application ID
     */

    public void setApplicationId(Integer applicationId) {
        this.applicationId = applicationId;
    }
    
    /**
     * Set the Id of a Job Provider on a Job Application
     *
     * @param providerId new provider ID
     */
    public void setProviderId(Integer providerId) {
        this.providerId = providerId;
    }

    /**
     * Set the Id of a Job Description on a Job Application
     *
     * @param descriptionId new description ID
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
     * Set the Id of a freelancer on a Job Application
     *
     * @param freelancerId new freelancer ID
     */
    public void setFreelancerId(Integer freelancerId) {
        this.freelancerId = freelancerId;
    }

    /**
     * Set the name of a freelancer on a Job Application
     *
     * @param freelancerName new freelancer name
     */
    public void setFreelancerName(String freelancerName) {
        this.freelancerName = freelancerName;
    }
    
    /**
     * Set the state of a Job Application.
     * Either "Accepted", "Pending" or "Rejected"
     *
     * @param newState new state of an application
     */
    public void setState(String newState) {
        this.state = newState;
    }
    
}
