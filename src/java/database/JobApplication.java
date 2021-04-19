package database;

/**
 *
 * @author vince
 */
public class JobApplication {
    private Integer applicationId;
    private Integer providerId;
    private Integer descriptionId;
    private Integer freelancerId;
    private String state;
    
    /**
     * Generate a job Application with the given information
     *
     * @param applicationId unique application ID
     * @param providerId ID of the provider
     * @param descriptionId ID of the job description
     * @param freelancerId ID of the freelancer
     * @param state state of the application
     */
    public JobApplication(Integer applicationId, Integer providerId, Integer descriptionId, Integer freelancerId, String state) {
        this.applicationId = applicationId;
        this.providerId = providerId;
        this.descriptionId = descriptionId;
        this.freelancerId = freelancerId;
        this.state = state;
    }
    
    public JobApplication() {
    }
    
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
     * Get the Id of a freelancer applying for a Job Application
     *
     * @return Integer of freelancer ID
     */
    public Integer getFreelancerId() {
        return freelancerId;
    }
    
    /**
     * Get the state of a Job Application
     * either "Accepted" or "Pending"
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
     * Set the Id of a freelancer on a Job Application
     *
     * @param freelancerId new freelancer ID
     */
    public void setFreelancerId(Integer freelancerId) {
        this.freelancerId = freelancerId;
    }
    
    /**
     * Set the state of a Job Application
     * either "Accepted" or "Pending"
     *
     * @param newState new state of an application
     */
    public void setState(String newState) {
        this.state = newState;
    }
    
}
