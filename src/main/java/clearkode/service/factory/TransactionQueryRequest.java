package clearkode.service.factory;

import clearkode.entity.dto.BaseRequestDTO;
import clearkode.entity.dto.BaseResponseDTO;
import clearkode.service.RequestService;
import clearkode.service.TransactionService;
import org.springframework.stereotype.Service;

@Service
public class TransactionQueryRequest extends RequestService {
    private final transient TransactionService transactionService;

    public TransactionQueryRequest(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @Override
    public BaseResponseDTO sendRequest(BaseRequestDTO baseRequestDTO) {
        return transactionService.getTransactionListDTO(baseRequestDTO);
    }
}
