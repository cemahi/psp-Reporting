package clearkode.service.impl;

import clearkode.service.CacheManagementService;
import org.springframework.stereotype.Service;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class CacheManagementServiceImpl implements CacheManagementService {

    private static Map<String, String> userMap;

    @Override
    public String findTokenByUserName(String userName) {
        if (userMap != null && userMap.size() > 0) {
            for (String email : userMap.keySet()) {
                if (userName.equalsIgnoreCase(email)) {
                    return userMap.get(email);
                }
            }
        } else {
            FacesContext fc = FacesContext.getCurrentInstance();
            ExternalContext ec = fc.getExternalContext();
            try {
                ec.redirect("/login.jsf");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public void addUserToken(String email, String token) {
        if (userMap != null && userMap.size() > 0) {
            userMap.put(email, token);
        } else {
            userMap = new HashMap<>();
            userMap.put(email, token);
        }
    }

}
