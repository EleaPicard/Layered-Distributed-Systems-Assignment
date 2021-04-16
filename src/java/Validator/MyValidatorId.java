package Validator;

import database.JobDescription;
import database.JobDescriptionBean;
import java.util.ArrayList;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.*;
 
@FacesValidator("myvalidatorid")
public class MyValidatorId implements Validator
{
        JobDescriptionBean jobs = new JobDescriptionBean();
        ArrayList<JobDescription> jobsList = jobs.getAllJobDescriptions();
    
        private String searchId;

	public MyValidatorId() {
	}

	@Override
	public void validate(FacesContext fc, UIComponent uic, Object obj)
			throws ValidatorException {
		Integer jobId = (Integer) obj;
                boolean valid = false;

                //Check if the id is in the job decription
                for (JobDescription j : jobsList) {
                    if (j.getId().compareTo(jobId) == 0) {
                        if (j.getState().compareTo("Open") == 0 ){
                            valid = true;
                        }
                    }
                }   
                if (valid == false) {
			FacesMessage msg = new FacesMessage(
					" This job Id is not in the list of open jobs. Please enter an other Id.");
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