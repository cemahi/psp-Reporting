package clearkode.bean;

import clearkode.entity.clientInfo.ClientInfoRequest;
import clearkode.entity.clientInfo.ClientInfoResponce;
import clearkode.entity.common.CustomerInfo;
import clearkode.service.TransactionService;
import clearkode.service.factory.RequestServiceFactory;
import clearkode.util.FacesContextUtil;
import clearkode.util.RedirectionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;

@Component
@Scope("view")
public class ClientInfoBean {

    @Autowired
    private transient TransactionService transactionService;

    private ClientInfoRequest requestDTO;
    private CustomerInfo customerInfo;
    private String hashedEmail;

    @PostConstruct
    public void init() {
        requestDTO = new ClientInfoRequest();
    }

    public void inquiry() {
        hashedEmail = (String) FacesContextUtil.getFromSession("email");
        String token = (String) FacesContextUtil.getFromSession("token");
        requestDTO.setToken(token);
        ClientInfoResponce clientInfoResponce = RequestServiceFactory.getInstance().getRequestFactory("clientInfo",transactionService).sendRequest(requestDTO);
        customerInfo = clientInfoResponce.getCustomerInfo();
    }
    public void logOut(){
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        new RedirectionUtil().redirect("/login.jsf");
    }

    public ClientInfoRequest getRequestDTO() {
        return requestDTO;
    }

    public void setRequestDTO(ClientInfoRequest requestDTO) {
        this.requestDTO = requestDTO;
    }

    public CustomerInfo getCustomerInfo() {
        return customerInfo;
    }

    public void setCustomerInfo(CustomerInfo customerInfo) {
        this.customerInfo = customerInfo;
    }

    public String getHashedEmail() {
        return hashedEmail;
    }

    public void setHashedEmail(String hashedEmail) {
        this.hashedEmail = hashedEmail;
    }
}