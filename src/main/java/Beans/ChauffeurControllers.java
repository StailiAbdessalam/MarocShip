package Beans;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

@Named("chauffeurcontrollers")
@RequestScoped
public class ChauffeurControllers {

    public String DemandeChauffeur()
    {
        return "DemandeChauffeur";
    }

    public String LoginChauffeur()
    {
        return "LoginChauffeur";
    }

}
