package clearkode.service.factory;

import clearkode.entity.clientInfo.ClientInfoResponce;
import clearkode.entity.dto.BaseRequestDTO;
import clearkode.service.RequestService;
import clearkode.service.TransactionService;
import org.springframework.stereotype.Service;

@Service
public class ClientInfoRequest extends RequestService {
    private final transient TransactionService transactionService;

    public ClientInfoRequest(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @Override
    public ClientInfoResponce sendRequest(BaseRequestDTO baseRequestDTO) {
        return transactionService.getClientInfoDTO(baseRequestDTO);
    }
}
