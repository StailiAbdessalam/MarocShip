package Beans;

import java.io.Serializable;

import DAO.DaoEntity.ManagerDao;
import Utils.SessionUtils;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import jakarta.servlet.http.HttpSession;

@Named("login")
@SessionScoped
public class Login implements Serializable {


    private static final long serialVersionUID = 1094801825228386363L;

    private String role;
    private String password;
    private String email;

    public String getpassword() {
        return password;
    }


    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getEmail() {
        return email;
    }

    public void setUser(String email) {
        this.email = email;
    }

    //validate login
    public String validateUsernamePassword() {
        boolean valid = ManagerDao.validateAdminLogin(new String[]{email, password});
        if (valid) {
            HttpSession session = SessionUtils.getSession();
            session.setAttribute("username", email);
            return "admin";
        } else {
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                            "Incorrect Username and Passowrd",
                            "Please enter correct username and Password"));
            return "login";
        }
    }

    //logout event, invalidate session
    public String logout() {
        HttpSession session = SessionUtils.getSession();
        session.invalidate();
        return "login";
    }
}