package clearkode.entity.transactinInfo;

import clearkode.entity.common.CustomerInfo;
import clearkode.entity.common.FxInformation;
import clearkode.entity.dto.BaseResponseDTO;

public class TransactionInfoResponce extends BaseResponseDTO {
    private FxInformation fx;
    private CustomerInfo customerInfo;
    private AcquirerTransactionInfo acquirerTransactionInfo;
    private MerchantInfo merchant;
    private MerchantTransactionInfo transaction;

    public FxInformation getFx() {
        return fx;
    }

    public void setFx(FxInformation fx) {
        this.fx = fx;
    }

    public CustomerInfo getCustomerInfo() {
        return customerInfo;
    }

    public void setCustomerInfo(CustomerInfo customerInfo) {
        this.customerInfo = customerInfo;
    }

    public AcquirerTransactionInfo getAcquirerTransactionInfo() {
        return acquirerTransactionInfo;
    }

    public void setAcquirerTransactionInfo(AcquirerTransactionInfo acquirerTransactionInfo) {
        this.acquirerTransactionInfo = acquirerTransactionInfo;
    }

    public MerchantInfo getMerchant() {
        return merchant;
    }

    public void setMerchant(MerchantInfo merchant) {
        this.merchant = merchant;
    }

    public MerchantTransactionInfo getTransaction() {
        return transaction;
    }

    public void setTransaction(MerchantTransactionInfo transaction) {
        this.transaction = transaction;
    }
}
