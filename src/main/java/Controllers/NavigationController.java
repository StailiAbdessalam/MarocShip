package Controllers;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

import java.io.Serializable;
@Named("navigationController")
@RequestScoped
public class NavigationController implements Serializable {

    public String moveToPageDemandeChauffeur() {
        return "/Views/Chauffeur/DemandeChauffeur?faces-redirect=true";
    }

    public String moveToPageLoginChauffeur() {
        return "/Views/Chauffeur/LoginChauffeur?faces-redirect=true";
    }

}
