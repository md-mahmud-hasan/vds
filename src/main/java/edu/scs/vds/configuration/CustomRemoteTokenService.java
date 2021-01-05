package edu.scs.vds.configuration;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.*;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.common.exceptions.InvalidTokenException;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.AccessTokenConverter;
import org.springframework.security.oauth2.provider.token.DefaultAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

public class CustomRemoteTokenService implements ResourceServerTokenServices {

    private RestOperations restTemplate;

    private AccessTokenConverter tokenConverter = new DefaultAccessTokenConverter();

    @Autowired
    private Environment env;

    private final String URL = "sdsdsdsd";

    @Autowired
    public CustomRemoteTokenService() {
        restTemplate = new RestTemplate();
        ((RestTemplate) restTemplate).setErrorHandler(new DefaultResponseErrorHandler() {
            @Override
            // Ignore 400
            public void handleError(ClientHttpResponse response) throws IOException {
                if (response.getRawStatusCode() != 400) {
                    super.handleError(response);
                }
            }
        });
    }

    @Override
    public OAuth2Authentication loadAuthentication(String accessToken) throws AuthenticationException, InvalidTokenException {
        HttpHeaders headers = new HttpHeaders(){
            @Override
            public void set(String headerName, String headerValue) {
                super.set("Authorization", "Bearer 8NywYXuNJG3VVSoHbKVEZy5nrsXrEt");
            }
        };

        System.out.println("hitting intersect");

        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> data= new LinkedMultiValueMap<String, String>();
        data.add("token", accessToken);

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(data, headers);

        Map response = restTemplate.postForEntity( URL, request , Map.class ).getBody();
        System.out.println(response);
        Map<String, Object> result = response;
        return tokenConverter.extractAuthentication(result);
    }

    @Override
    public OAuth2AccessToken readAccessToken(String accessToken) {
        throw new UnsupportedOperationException("Not supported: read access token");
    }
}