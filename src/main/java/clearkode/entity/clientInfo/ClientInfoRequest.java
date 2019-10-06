package clearkode.entity.clientInfo;
import clearkode.entity.dto.BaseRequestDTO;

public class ClientInfoRequest extends BaseRequestDTO {
    private String transactionId;

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }
}
