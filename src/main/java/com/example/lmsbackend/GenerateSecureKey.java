package com.example.lmsbackend;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import java.security.Key;
import java.util.Base64;

public class GenerateSecureKey {
    public static void main(String[] args) {
        Key key = Keys.secretKeyFor(SignatureAlgorithm.HS512); // Generate the key
        String base64Key = Base64.getEncoder().encodeToString(key.getEncoded());
        System.out.println(base64Key); // Print the generated key
    }
}
