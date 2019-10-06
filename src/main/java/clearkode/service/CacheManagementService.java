package clearkode.service;

public interface CacheManagementService {
    String findTokenByUserName(String email);

    void addUserToken(String email, String token);
}
