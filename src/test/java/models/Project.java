package models;

import java.util.ArrayList;

public class Project {

    private String projectName;
    private String projectDescription;
    private String domains;

    public Project(String name, String description, String domains) {
        this.projectName = name;
        this.projectDescription = description;
        this.domains = domains;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectDescription() {
        return projectDescription;
    }

    public void setProjectDescription(String projectDescription) {
        this.projectDescription = projectDescription;
    }

    public String getDomains() {
        return domains;
    }

    public void setDomains(String domains) {
        this.domains = domains;
    }
}
