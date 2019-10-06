package clearkode.entity.transactionQuery;

import clearkode.entity.common.CustomerInfo;
import clearkode.entity.common.FxInformation;

public class TransactionQueryData {
    private FxInformation fx;
    private CustomerInfo customerInfo ;
    private Merchant merchant;
    private IpnInfo ipn;
    private Transaction transaction;
    private AcquirerInfo acquirer;
    private boolean refundable;

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

    public Merchant getMerchant() {
        return merchant;
    }

    public void setMerchant(Merchant merchant) {
        this.merchant = merchant;
    }

    public IpnInfo getIpn() {
        return ipn;
    }

    public void setIpn(IpnInfo ipn) {
        this.ipn = ipn;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    public AcquirerInfo getAcquirer() {
        return acquirer;
    }

    public void setAcquirer(AcquirerInfo acquirer) {
        this.acquirer = acquirer;
    }

    public boolean isRefundable() {
        return refundable;
    }

    public void setRefundable(boolean refundable) {
        this.refundable = refundable;
    }
}
