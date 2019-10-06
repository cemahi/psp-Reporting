package clearkode.service;

import clearkode.entity.dto.BaseRequestDTO;
import clearkode.entity.login.LoginResponseDTO;

public interface LoginService {
    LoginResponseDTO login(BaseRequestDTO baseRequestDTO);
}
