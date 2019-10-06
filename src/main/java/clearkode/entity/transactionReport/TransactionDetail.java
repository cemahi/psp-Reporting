package clearkode.entity.transactionReport;

public class TransactionDetail {
    public Long count;
    public Long total;
    public String currency;

    public Long getCount() { return count; }

    public void setCount(Long count) {
        this.count = count;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

}