/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 *
 * @author eleap
 */
@Named(value = "logBean")
@SessionScoped
public class LogBean implements Serializable {
    
    private static ArrayList<Log> logs = new ArrayList<>();
    private String actioner;
    private String actionerName;
    private String action;


    /**
     * Creates a new instance of LogBean
     */
    public LogBean() {
        // add log if list is empty
        if (logs.size() < 1) {
            logs.add(new Log("Provider","Tom Gallagher","Has accepted a freelancer"));
            logs.add(new Log("Freelancer","Juan Martinez","Has offer to undertake a job"));
            logs.add(new Log("Provider","Sean Conway","Has marked a job as closed"));
        }
    }
    
    /**
     * Returns all logs
     *
     * @return all logs
     */
    public ArrayList<Log> getAllLogs() {
        return logs;
    }
    
    /**
     * Method to add a new log to the collection. values will be taken
     * from attributes
     */
    public void addLog() {
        logs.add(new Log(actioner, actionerName, action));
    }

    /**
     * Method to removes a log from the collection
     * @param l Log to be removed
     */
    public void removeLog(Log l) {
        logs.remove(l);
    }
    
    /**
     * Get the value of the actioner
     *
     * @return the value of the actioner
     */
    public String getActioner() {
        return actioner;
    }

    /**
     * Set the value of the actioner
     *
     * @param actioner new value of the actioner
     */
    public void setActioner(String actioner) {
        this.actioner = actioner;
    }

    /**
     * Get the value of the actionerName
     *
     * @return the value of the actioner name
     */
    public String getActionerName() {
        return actionerName;
    }

    /**
     * Set the value of the actionerName
     *
     * @param actionerName new value of the actioner name
     */
    public void setActionerName(String actionerName) {
        this.actionerName = actionerName;
    }
    
    

    /**
     * Get the value of the action
     *
     * @return the value of the action
     */
    public String getAction() {
        return action;
    }

    /**
     * Set the value of the action
     *
     * @param action new value of the action
     */
    public void setAction(String action) {
        this.action = action;
    }

}
