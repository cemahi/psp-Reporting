package clearkode.service.factory;

import clearkode.entity.dto.BaseRequestDTO;
import clearkode.entity.dto.BaseResponseDTO;
import clearkode.service.RequestService;
import clearkode.service.TransactionService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("view")
public class LoginRequest extends RequestService {

    private final TransactionService transactionService;

    public LoginRequest(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @Override
    public BaseResponseDTO sendRequest(BaseRequestDTO baseRequestDTO) {
        return transactionService.login(baseRequestDTO);
    }
}
