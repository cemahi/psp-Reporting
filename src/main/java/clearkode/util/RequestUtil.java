package clearkode.util;

import com.google.gson.Gson;
import org.apache.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

public class RequestUtil {
    public static <T> T sendRequest(Object requestEntity, String path, Class<T> responseClass, String token) {
        RestTemplate restTemplate = new TlsUtil();
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_UTF8_VALUE);
        if (token != null){
            headers.add("Authorization",token);
        }
        try {
            RequestEntity entity = new RequestEntity<>(requestEntity, headers, HttpMethod.POST, UriComponentsBuilder.fromHttpUrl(path).build().toUri());
            ResponseEntity<T> responseEntity = restTemplate.exchange(entity, responseClass);
            return responseEntity.getBody();
        } catch (RestClientResponseException e) {
            String errorResult = e.getResponseBodyAsString();
            Gson gson = new Gson();
            return gson.fromJson(errorResult,responseClass);
        }
    }
}
