/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eui.miw.pfm.controllers.beans;

import eui.miw.pfm.controllers.ejb.CreateProjectValidatorEjb;
import eui.miw.pfm.models.entities.ProjectEntity;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author César Martínez
 */
@RequestScoped
@Named
public class CreateProjectValidatorBean extends Bean implements Serializable {

    private static final long serialVersionUID = 1L;
    private ProjectEntity projectEntity;

    /**
     * Creates a new instance of CreateProjectValidatorBean
     */
    public CreateProjectValidatorBean() {
        super();
        this.projectEntity = new ProjectEntity();
    }

//function to validate that the suggested name doesn't exist already. 
    public ProjectEntity getProjectEntity() {
        return projectEntity;
    }

    public void setProjectEntity(final ProjectEntity projectEntity) {
        this.projectEntity = projectEntity;
    }

    public boolean nameValidator() {
        CreateProjectValidatorEjb cPVEjb;
        cPVEjb = new CreateProjectValidatorEjb();
        boolean nameExist; //name validation flag
        nameExist = false;//NOPMD
        for (ProjectEntity project : cPVEjb.nameValidator()) {         
            if (project.getName().equals(this.projectEntity.getName())) {
                nameExist = true;//NOPMD
            }
        }
        return nameExist;
    }

}
