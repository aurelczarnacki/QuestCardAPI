package com.questcard.questcardapi.config;

import com.questcard.questcardapi.CustomTrustManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;

@Configuration
public class SSLConfig {

    @Bean
    public RestTemplate restTemplate() throws Exception {
        return new RestTemplate(clientHttpRequestFactory());
    }

    private ClientHttpRequestFactory clientHttpRequestFactory() throws Exception {
        return new SimpleClientHttpRequestFactory() {
            @Override
            protected void prepareConnection(java.net.HttpURLConnection connection, String httpMethod)
                    throws java.io.IOException {
                if (connection instanceof javax.net.ssl.HttpsURLConnection) {
                    try {
                        // Create a TrustManager that trusts all certificates
                        TrustManager[] trustAllCertificates = new TrustManager[]{
                                new CustomTrustManager()
                        };

                        // Create an SSLContext with the TrustManager
                        SSLContext sslContext = SSLContext.getInstance("TLS");
                        sslContext.init(null, trustAllCertificates, new SecureRandom());

                        // Set the SSLContext on the HttpsURLConnection
                        ((javax.net.ssl.HttpsURLConnection) connection).setSSLSocketFactory(sslContext.getSocketFactory());
                    } catch (Exception e) {
                        // Handle exception
                    }
                }
                super.prepareConnection(connection, httpMethod);
            }
        };
    }
}