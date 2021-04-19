package Validator;

import database.JobApplication;
import database.JobApplicationBean;
import java.util.ArrayList;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.*;
 
@FacesValidator("myvalidatorapplyid")
public class MyValidatorIdApplication implements Validator
{
        JobApplicationBean appli = new JobApplicationBean();
        ArrayList<JobApplication> jobsAppliList = appli.getAllJobApplications();
    
        private String searchId;

	public MyValidatorIdApplication() {
	}

	@Override
	public void validate(FacesContext fc, UIComponent uic, Object obj)
			throws ValidatorException {
		Integer applicationId = (Integer) obj;
                boolean valid = false;

                //Check if the id is in the job decription
                for (JobApplication j : jobsAppliList) {
                    if (j.getApplicationId().compareTo(applicationId) == 0) {
                        valid = true;
                    }
                }   
                if (valid == false) {
			FacesMessage msg = new FacesMessage(
					" This job application Id is not in the list. "
                                                + "Please enter an other Id.");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(msg);
		}

	}
        
        /**
         * Get the value of search Id
         *
         * @return the value search Id
         */
        public String getSearchId() {
		return searchId;
	}

        /**
         * Set the value of search Id
         *
         * @param searchId new value of the search Id
         */
	public void setSearchId(String searchId) {
		this.searchId = searchId;
	}
}