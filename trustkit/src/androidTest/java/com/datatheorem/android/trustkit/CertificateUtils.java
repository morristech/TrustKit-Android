package com.datatheorem.android.trustkit;

import android.util.Base64;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;

public class CertificateUtils {

    public static Certificate certificateFromPem(String pemCertificate) {
        InputStream is = new ByteArrayInputStream(Base64.decode(pemCertificate, Base64.DEFAULT));
        CertificateFactory cf = null;
        try {
            cf = CertificateFactory.getInstance("X.509");
            return cf.generateCertificate(is);
        } catch (CertificateException e) {
           throw new RuntimeException("Should never happen");
        }
    }
}