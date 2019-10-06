package clearkode.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import java.io.IOException;

public class RedirectionUtil {
    public void redirect(String redirectionUrl){
        FacesContext fc = FacesContext.getCurrentInstance();
        ExternalContext ec = fc.getExternalContext();
        Flash flash = fc.getExternalContext().getFlash();
        flash.setKeepMessages(true);
        if (redirectionUrl.equalsIgnoreCase("/login.jsf")){
            fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Logut successful", "Logut successful"));
        }else {
            fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Login successful", "Login successful"));

        }
        try {
            ec.redirect(redirectionUrl);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
