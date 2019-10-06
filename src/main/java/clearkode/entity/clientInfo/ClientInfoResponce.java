package clearkode.entity.clientInfo;

import clearkode.entity.common.CustomerInfo;
import clearkode.entity.dto.BaseResponseDTO;

public class ClientInfoResponce extends BaseResponseDTO {
    private CustomerInfo customerInfo;

    public CustomerInfo getCustomerInfo() {
        return customerInfo;
    }

    public void setCustomerInfo(CustomerInfo customerInfo) {
        this.customerInfo = customerInfo;
    }
}
