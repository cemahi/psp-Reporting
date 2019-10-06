package clearkode.bean;

import clearkode.entity.login.LoginResponseDTO;
import clearkode.entity.login.User;
import clearkode.service.RequestService;
import clearkode.service.TransactionService;
import clearkode.service.factory.RequestServiceFactory;
import clearkode.util.FacesContextUtil;
import clearkode.util.HashUtil;
import clearkode.util.RedirectionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

@Component
@Scope("view")
public class LoginBean {
    @Autowired
    private TransactionService transactionService;
    private User user;

    @PostConstruct
    public void init() {
        user = new User();
        user.setEmail("demo@financialhouse.io");
        user.setPassword("cjaiU8CV");
    }

    public void login() throws Exception {
        String hashedEmail = HashUtil.getSHA1Text(user.getEmail());
        RequestService requestService = RequestServiceFactory.getInstance().getRequestFactory("login",transactionService);
        LoginResponseDTO response = requestService.sendRequest(user);
        if (response.getStatus().equals("APPROVED")) {
            FacesContextUtil.setIntoSession("email", hashedEmail);
            FacesContextUtil.setIntoSession("token", response.getToken());
            new RedirectionUtil().redirect("/transaction.jsf");
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, response.getMessage(), ""));

        }
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}