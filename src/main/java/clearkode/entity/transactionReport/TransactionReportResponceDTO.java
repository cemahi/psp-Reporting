package clearkode.entity.transactionReport;

import clearkode.entity.dto.BaseResponseDTO;

import java.util.List;

public class TransactionReportResponceDTO extends BaseResponseDTO {
    private String status;
    private List<TransactionDetail> response;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<TransactionDetail> getResponse() {
        return response;
    }

    public void setResponse(List<TransactionDetail> response) {
        this.response = response;
    }
}
