package clearkode.service;

import clearkode.entity.dto.BaseRequestDTO;
import org.springframework.stereotype.Service;

@Service
public abstract class RequestService {
    public abstract <T> T sendRequest(BaseRequestDTO baseRequestDTO);
}
