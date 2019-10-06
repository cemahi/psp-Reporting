package clearkode.entity.transactinInfo;

import clearkode.entity.dto.BaseRequestDTO;

public class TransactionInfoRequest extends BaseRequestDTO {
    private String transactionId;

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }
}
