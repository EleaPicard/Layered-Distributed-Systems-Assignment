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

    public JobApplicationBean() {
        // add job application if list is empty
        if (applications.size() < 1) {
            applications.add(new JobApplication(
                    applications.size()+1,4,4,jobs.getJobDescriptionTitleById(4),1, fre.getFreelancerNameById(1), "Pending"));
            applications.add(new JobApplication(
                    applications.size()+1,4,4,jobs.getJobDescriptionTitleById(4),2, fre.getFreelancerNameById(2), "Pending"));
            applications.add(new JobApplication(
                    applications.size()+1,1,2,jobs.getJobDescriptionTitleById(2),3, fre.getFreelancerNameById(3), "Accepted"));
            applications.add(new JobApplication(
                    applications.size()+1,3,1,jobs.getJobDescriptionTitleById(1),1, fre.getFreelancerNameById(1), "Pending"));
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
     * @param state state of the application
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
     * values will be taken from descriptionId attribute and the freelancer ID
     * 
     * @param userID
     * @param jobs
     */
    public void addJobApplicationFreelancer(Integer userID, JobDescriptionBean jobs,
            String type, String userName) {
        JobDescription j = jobs.getJobDescriptionById(descriptionId);
        applications.add(new JobApplication(
                applications.size()+1, j.getId(), descriptionId, j.getTitle(), userID, userName, "Pending"));
        
        jobs.undertakeJob(type, userName);
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
                if (!"Rejected".equals(a.getState())) {
                    result.add(a);
                }
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
    
    /**
     * Return a list of Pending job applications with a given freelancer id
     *
     * @param id Id of job description to look for
     * @return List containing all job applications with given description
     */
    public List<JobApplication> getPendingApplicationByFreelancerId(Integer id) {
        ArrayList<JobApplication> result = new ArrayList<>();
        // find all applications for a given job description and add to result
        for (JobApplication a : applications) {
            if (a.getFreelancerId().compareTo(id) == 0) {
                if ("Pending".equals(a.getState())) {
                    result.add(a);
                }
            }
        }
        return result;
    }
    
    /**
     * Return a list of Accepted job applications with a given freelancer id
     *
     * @param id Id of job description to look for
     * @return List containing all job applications with given description
     */
    public List<JobApplication> getAcceptedApplicationByFreelancerId(Integer id) {
        ArrayList<JobApplication> result = new ArrayList<>();
        // find all applications for a given job description and add to result
        for (JobApplication a : applications) {
            if (a.getFreelancerId().compareTo(id) == 0) {
                if ("Accepted".equals(a.getState())) {
                    result.add(a);
                }
            }
        }
        return result;
    }
    
    public String acceptApplication(JobDescriptionBean jobDesc, String type, 
            String user, Integer userId) {
        Integer des_id = 0;
        JobApplication a = new JobApplication();
        for (JobApplication app : applications) {
            if ((app.getApplicationId().compareTo(applicationId) == 0)&& 
                    (app.getProviderId().compareTo(userId) == 0)) {
                app.setState("Accepted");
                des_id = app.getDescriptionId();
                a = new JobApplication(app);
            }
        }
        for (JobApplication app : applications) {
            if ((app.getDescriptionId().compareTo(des_id) == 0)&& 
                    (app.getProviderId().compareTo(userId) == 0)) {
                if ("Pending".equals(app.getState())) {
                    app.setState("Rejected");
                }
            }
        }
        // Add a new entry in the log
        jobDesc.jobClosedProvider(a, type, user);
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
    
    public TreeSet<Freelancer> showApplicantByProviderId(Integer id, FreelancerBean freBean) {
        TreeSet<Freelancer> result = new TreeSet<>();
        List<JobApplication> providerDesc = this.getJobApplicationByProviderId(id);
        for (JobApplication a : providerDesc) {
            if (!"Rejected".equals(a.getState())) {
                result.add(freBean.getFreelancerById(a.getFreelancerId()));
            }
        }
        return result;
    }
    
}
