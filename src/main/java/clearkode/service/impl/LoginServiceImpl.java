package clearkode.service.impl;

import clearkode.constants.StaticConstants;
import clearkode.entity.dto.BaseRequestDTO;
import clearkode.entity.login.LoginResponseDTO;
import clearkode.service.LoginService;
import clearkode.util.RequestUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class LoginServiceImpl implements LoginService {
    @Override
    public LoginResponseDTO login(BaseRequestDTO baseRequestDTO) {
        String path = StaticConstants.baseUrl + StaticConstants.loginUrl;
        return RequestUtil.sendRequest(baseRequestDTO, path, LoginResponseDTO.class, null);
    }
}
