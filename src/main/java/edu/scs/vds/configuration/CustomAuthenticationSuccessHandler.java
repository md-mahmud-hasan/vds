package edu.scs.vds.configuration;

import edu.scs.vds.model.enums.UserRole;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

@Configuration
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {


    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {

        Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());

        if (roles.contains(UserRole.ADMIN.name())) {
            try {
                httpServletResponse.sendRedirect("/admin/home");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (roles.contains(UserRole.DOCTOR.name())){
            try {
                httpServletResponse.sendRedirect("/admin/home");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else{
            try {
                httpServletResponse.sendRedirect("/patient/home");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}