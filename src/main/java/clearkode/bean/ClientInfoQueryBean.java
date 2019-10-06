package clearkode.bean;

import clearkode.entity.clientInfo.ClientInfoRequest;
import clearkode.entity.transactinInfo.TransactionInfoResponce;
import clearkode.service.TransactionService;
import clearkode.service.factory.RequestServiceFactory;
import clearkode.util.FacesContextUtil;
import clearkode.util.RedirectionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;

@Component
@Scope("view")
public class ClientInfoQueryBean {

    @Autowired
    private TransactionService transactionService;

    private ClientInfoRequest requestDTO;
    private TransactionInfoResponce transactionInfoResponce;
    private String hashedEmail;

    @PostConstruct
    public void init() {
        requestDTO = new ClientInfoRequest();
        requestDTO.setTransactionId("1011028-1539357144-1293");
    }

    public void inquiry() {
        hashedEmail = (String) FacesContextUtil.getFromSession("email");
        String token = (String) FacesContextUtil.getFromSession("token");
        //String token2 = cacheManagementService.findTokenByUserName(hashedEmail);
        requestDTO.setToken(token);
        transactionInfoResponce = RequestServiceFactory.getInstance().getRequestFactory("txInfo", transactionService).sendRequest(requestDTO);

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

    public TransactionInfoResponce getTransactionInfoResponce() {
        return transactionInfoResponce;
    }

    public void setTransactionInfoResponce(TransactionInfoResponce transactionInfoResponce) {
        this.transactionInfoResponce = transactionInfoResponce;
    }

    public String getHashedEmail() {
        return hashedEmail;
    }

    public void setHashedEmail(String hashedEmail) {
        this.hashedEmail = hashedEmail;
    }
}