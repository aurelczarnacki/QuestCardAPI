package com.questcard.questcardapi;

import javax.net.ssl.X509TrustManager;
import java.security.cert.X509Certificate;

public class CustomTrustManager implements X509TrustManager {

    @Override
    public void checkClientTrusted(X509Certificate[] chain, String authType) {
        // Implementacja wg potrzeb
    }

    @Override
    public void checkServerTrusted(X509Certificate[] chain, String authType) {
        // Implementacja wg potrzeb
    }

    @Override
    public X509Certificate[] getAcceptedIssuers() {
        return null;
    }
}