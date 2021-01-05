package edu.scs.vds.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;

import javax.sql.DataSource;

@Configuration
@EnableAuthorizationServer
public class OAuth2AuthorizationServer extends AuthorizationServerConfigurerAdapter
{

    @Autowired
    DataSource dataSource;

    @Autowired
    private Environment env;

//    private final String CLIENT = env.getProperty("security.oauth2.client.client-id");
//
//    private final String SECRET = env.getProperty("security.oauth2.client.client-secret");

    private final String CLIENT = "sdsd";

    private final String SECRET = "sdsd";

    private static final String SCOPE_READ = "read";
    private static final String SCOPE_WRITE = "write";
    private static final String RESOURCE_ID = "restservice";
    private static final String AUTHORITY_USER = "USER";
    private static final String GRANT_TYPE_PASSWORD = "password";
    private static final String GRANT_TYPE_REFRESH_TOKEN = "refresh_token";

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security
                .tokenKeyAccess("permitAll()")
                .checkTokenAccess("permitAll()")
                .allowFormAuthenticationForClients();
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients
                .jdbc(dataSource)
                .withClient(CLIENT).secret(SECRET)
                .authorizedGrantTypes(GRANT_TYPE_PASSWORD, GRANT_TYPE_REFRESH_TOKEN)
                .authorities(AUTHORITY_USER)
                .scopes(SCOPE_READ, SCOPE_WRITE)
                .resourceIds(RESOURCE_ID)
                .accessTokenValiditySeconds(120)
                .refreshTokenValiditySeconds(240000);
    }
}