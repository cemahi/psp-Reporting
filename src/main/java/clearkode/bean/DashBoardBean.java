package clearkode.bean;

import clearkode.entity.transactionReport.TransactionDetail;
import clearkode.entity.transactionReport.TransactionReportRequestDTO;
import clearkode.entity.transactionReport.TransactionReportResponceDTO;
import clearkode.service.TransactionService;
import clearkode.service.factory.RequestServiceFactory;
import clearkode.util.DateUtil;
import clearkode.util.FacesContextUtil;
import clearkode.util.RedirectionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import java.util.Date;
import java.util.List;

@Component
@Scope("view")
public class DashBoardBean {
    @Autowired
    private transient TransactionService transactionService;

    private String token;
    private TransactionReportRequestDTO requestDTO;
    private List<TransactionDetail> transactionDetails;
    private Date fromDate;
    private Date toDate;

    @PostConstruct
    public void init() {
        requestDTO = new TransactionReportRequestDTO();
        requestDTO.setMerchant(null);
        requestDTO.setAcquirer(null);
    }

    public void inquiry() {
        String token = (String) FacesContextUtil.getFromSession("token");
        requestDTO.setFromDate(DateUtil.genericFormatDate(DateUtil.MYSQL_DATE_FORMAT, fromDate));
        requestDTO.setToDate(DateUtil.genericFormatDate(DateUtil.MYSQL_DATE_FORMAT, toDate));
        requestDTO.setToken(token);
        TransactionReportResponceDTO reportResponceDTO = RequestServiceFactory.getInstance().getRequestFactory("txReport",transactionService).sendRequest(requestDTO);
        transactionDetails = reportResponceDTO.getResponse();
    }

    public void logOut(){
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        new RedirectionUtil().redirect("/login.jsf");
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public TransactionReportRequestDTO getRequestDTO() {
        return requestDTO;
    }

    public void setRequestDTO(TransactionReportRequestDTO requestDTO) {
        this.requestDTO = requestDTO;
    }

    public List<TransactionDetail> getTransactionDetails() {
        return transactionDetails;
    }

    public void setTransactionDetails(List<TransactionDetail> transactionDetails) {
        this.transactionDetails = transactionDetails;
    }
}