package clearkode.service;

import clearkode.entity.clientInfo.ClientInfoResponce;
import clearkode.entity.dto.BaseRequestDTO;
import clearkode.entity.login.LoginResponseDTO;
import clearkode.entity.transactinInfo.TransactionInfoResponce;
import clearkode.entity.transactionQuery.TransactionQueryResponceDTO;
import clearkode.entity.transactionReport.TransactionReportResponceDTO;
import org.springframework.stereotype.Service;

@Service
public interface TransactionService {
    TransactionQueryResponceDTO getTransactionListDTO(BaseRequestDTO baseRequestDTO);

    ClientInfoResponce getClientInfoDTO(BaseRequestDTO baseRequestDTO);

    TransactionInfoResponce getTransactionInfoDTO(BaseRequestDTO baseRequestDTO);

    TransactionReportResponceDTO getTransactionDTO(BaseRequestDTO baseRequestDTO);

    LoginResponseDTO login(BaseRequestDTO baseRequestDTO);
}
