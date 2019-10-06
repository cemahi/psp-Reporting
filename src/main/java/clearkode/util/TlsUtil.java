package clearkode.util;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import javax.net.ssl.SSLContext;

public class TlsUtil extends RestTemplate {

    public TlsUtil() {
        super();
        SSLContext context;
        try {
            context = SSLContext.getInstance("TLSv1.2");
            context.init(null, null, null);

            CloseableHttpClient httpClient = HttpClientBuilder
                    .create()
                    .setSSLContext(context)
                    .build();
            HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory(httpClient);
            setRequestFactory(factory);
        } catch (Exception e) {
        }

    }

    public TlsUtil(int timeout) {
        super();
        SSLContext context;
        try {
            context = SSLContext.getInstance("TLSv1.2");
            context.init(null, null, null);
            RequestConfig config = RequestConfig.custom()
                    .setConnectTimeout(timeout)
                    .setConnectionRequestTimeout(timeout)
                    .setSocketTimeout(timeout)
                    .build();

            CloseableHttpClient httpClient = HttpClientBuilder
                    .create()
                    .setSSLContext(context)
                    .setDefaultRequestConfig(config)
                    .build();
            HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory(httpClient);
            setRequestFactory(factory);
        } catch (Exception e) {
        }


    }
}
