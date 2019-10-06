package clearkode.entity.transactionReport;

import clearkode.entity.dto.BaseRequestDTO;

public class TransactionReportRequestDTO extends BaseRequestDTO {
    public String fromDate;
    public String toDate;
    public Integer merchant;
    public Integer acquirer;

    public Integer getMerchant() {
        return merchant;
    }

    public void setMerchant(Integer merchant) {
        this.merchant = merchant;
    }

    public Integer getAcquirer() {
        return acquirer;
    }

    public void setAcquirer(Integer acquirer) {
        this.acquirer = acquirer;
    }

    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public String getToDate() {
        return toDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }
}
