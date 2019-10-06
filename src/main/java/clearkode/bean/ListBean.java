package clearkode.bean;

import clearkode.entity.transactionQuery.TransactionQueryData;
import clearkode.entity.transactionQuery.TransactionQueryRequestDTO;
import clearkode.entity.transactionQuery.TransactionQueryResponceDTO;
import clearkode.enums.Operation;
import clearkode.enums.PaymentMethod;
import clearkode.enums.Status;
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
import java.util.stream.Collectors;

@Component
@Scope("view")
public class ListBean {

    @Autowired
    private transient TransactionService transactionService;

    private String token;
    private TransactionQueryRequestDTO requestDTO;
    private List<TransactionQueryData> transactionDetails;
    private List<TransactionQueryData> errorTransactionDetails;
    private Date fromDate;
    private Date toDate;
    private List<String> operationTypeList;
    private List<String> statusTypeList;
    private List<String> paymentMethodList;
    private boolean statusError;

    private String selectedOperation;
    private String selectedStatus;
    private String selectedPaymentMethod;

    @PostConstruct
    public void init() {
        requestDTO = new TransactionQueryRequestDTO();
        operationTypeList = Operation.valueList();
        statusTypeList = Status.valueList();
        paymentMethodList = PaymentMethod.valueList();
    }

    public void inquiry() {
        String token = (String) FacesContextUtil.getFromSession("token");
        if (selectedOperation != null && selectedOperation.equalsIgnoreCase("")) {
            selectedOperation = null;
        }
        if (selectedPaymentMethod != null && selectedPaymentMethod.equalsIgnoreCase("")) {
            selectedPaymentMethod = null;
        }
        if (selectedStatus != null && selectedStatus.equalsIgnoreCase("")) {
            selectedStatus = null;
        }
        statusError = false;
        requestDTO.setOperation(selectedOperation);
        requestDTO.setStatus(selectedStatus);
        requestDTO.setPaymentMethod(selectedPaymentMethod);
        requestDTO.setPage(1);
        requestDTO.setToken(token);
        requestDTO.setFromDate(DateUtil.genericFormatDate(DateUtil.MYSQL_DATE_FORMAT, fromDate));
        requestDTO.setToDate(DateUtil.genericFormatDate(DateUtil.MYSQL_DATE_FORMAT, toDate));
        TransactionQueryResponceDTO reportResponceDTO = RequestServiceFactory.getInstance().getRequestFactory("txQuery",transactionService).sendRequest(requestDTO);
        transactionDetails = reportResponceDTO.getData();
        errorTransactionDetails = transactionDetails.stream().filter(transactionQueryData-> Status.ERROR.getText().equalsIgnoreCase(transactionQueryData.getTransaction().getMerchant().getStatus())).collect(Collectors.toList());
    }

    public void logOut(){
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        new RedirectionUtil().redirect("/login.jsf");
    }

    public void doneStatusError(){
        this.statusError = true;
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

    public TransactionQueryRequestDTO getRequestDTO() {
        return requestDTO;
    }

    public void setRequestDTO(TransactionQueryRequestDTO requestDTO) {
        this.requestDTO = requestDTO;
    }

    public List<TransactionQueryData> getTransactionDetails() {
        return transactionDetails;
    }

    public void setTransactionDetails(List<TransactionQueryData> transactionDetails) {
        this.transactionDetails = transactionDetails;
    }

    public List<String> getStatusTypeList() {
        return statusTypeList;
    }

    public void setStatusTypeList(List<String> statusTypeList) {
        this.statusTypeList = statusTypeList;
    }

    public List<String> getPaymentMethodList() {
        return paymentMethodList;
    }

    public void setPaymentMethodList(List<String> paymentMethodList) {
        this.paymentMethodList = paymentMethodList;
    }

    public List<String> getOperationTypeList() {
        return operationTypeList;
    }

    public void setOperationTypeList(List<String> operationTypeList) {
        this.operationTypeList = operationTypeList;
    }

    public String getSelectedOperation() {
        return selectedOperation;
    }

    public void setSelectedOperation(String selectedOperation) {
        this.selectedOperation = selectedOperation;
    }

    public String getSelectedStatus() {
        return selectedStatus;
    }

    public void setSelectedStatus(String selectedStatus) {
        this.selectedStatus = selectedStatus;
    }

    public String getSelectedPaymentMethod() {
        return selectedPaymentMethod;
    }

    public void setSelectedPaymentMethod(String selectedPaymentMethod) {
        this.selectedPaymentMethod = selectedPaymentMethod;
    }

    public List<TransactionQueryData> getErrorTransactionDetails() {
        return errorTransactionDetails;
    }

    public void setErrorTransactionDetails(List<TransactionQueryData> errorTransactionDetails) {
        this.errorTransactionDetails = errorTransactionDetails;
    }

    public boolean isStatusError() {
        return statusError;
    }

    public void setStatusError(boolean statusError) {
        this.statusError = statusError;
    }
}