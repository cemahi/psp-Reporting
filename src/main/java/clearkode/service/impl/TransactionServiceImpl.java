package clearkode.service.impl;

import clearkode.constants.StaticConstants;
import clearkode.entity.clientInfo.ClientInfoResponce;
import clearkode.entity.dto.BaseRequestDTO;
import clearkode.entity.login.LoginResponseDTO;
import clearkode.entity.transactinInfo.TransactionInfoResponce;
import clearkode.entity.transactionQuery.TransactionQueryResponceDTO;
import clearkode.entity.transactionReport.TransactionReportResponceDTO;
import clearkode.service.LoginService;
import clearkode.service.TransactionService;
import clearkode.util.RequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private transient LoginService loginService;

    @Override
    public TransactionQueryResponceDTO getTransactionListDTO(BaseRequestDTO baseRequestDTO) {
        String path = StaticConstants.baseUrl + StaticConstants.listUrl;
        return RequestUtil.sendRequest(baseRequestDTO, path, TransactionQueryResponceDTO.class, baseRequestDTO.getToken());
    }

    @Override
    public ClientInfoResponce getClientInfoDTO(BaseRequestDTO baseRequestDTO) {

        String path = StaticConstants.baseUrl + StaticConstants.clientInfoUrl;
        return RequestUtil.sendRequest(baseRequestDTO, path, ClientInfoResponce.class, baseRequestDTO.getToken());
    }

    @Override
    public TransactionInfoResponce getTransactionInfoDTO(BaseRequestDTO baseRequestDTO) {
        String path = StaticConstants.baseUrl + StaticConstants.transactionUrl;
        return RequestUtil.sendRequest(baseRequestDTO, path, TransactionInfoResponce.class, baseRequestDTO.getToken());
    }

    @Override
    public TransactionReportResponceDTO getTransactionDTO(BaseRequestDTO baseRequestDTO) {
        String path = StaticConstants.baseUrl + StaticConstants.reportUrl;
        return RequestUtil.sendRequest(baseRequestDTO, path, TransactionReportResponceDTO.class, baseRequestDTO.getToken());
    }

    @Override
    public LoginResponseDTO login(BaseRequestDTO baseRequestDTO) {
        return loginService.login(baseRequestDTO);
    }
}
