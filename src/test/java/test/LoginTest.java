package test;

import clearkode.entity.login.LoginResponseDTO;
import clearkode.entity.login.User;
import clearkode.service.CacheManagementService;
import clearkode.service.LoginService;
import clearkode.service.impl.CacheManagementServiceImpl;
import clearkode.util.RequestUtil;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.when;

public class LoginTest {
    @InjectMocks
    CacheManagementServiceImpl cacheManagementService;
    @Mock
    LoginService loginService;


    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void addCache() {
        cacheManagementService.addUserToken("user@user7.com", "tokencase1");
        Assert.assertEquals("tokencase1", cacheManagementService.findTokenByUserName("user@user7.com"));
    }

    @Test
    public void notFoundTest() {
        cacheManagementService.addUserToken("user@user.com", "tokencase1");
        Assert.assertNull(cacheManagementService.findTokenByUserName("test@user.com"));
    }

    @Test
    public void loginTest() {
        User user = new User();
        user.setPassword("123");
        user.setEmail("asd@asd.com");
        LoginResponseDTO responseDTO = new LoginResponseDTO();
        responseDTO.setToken("triltoken");
        when(loginService.login(user)).thenReturn(responseDTO);

        Assert.assertEquals("triltoken", loginService.login(user).getToken());
    }
}
