package Security;

/**
 *
 * @author gstafie
 */
import static java.util.Arrays.asList;
import static javax.security.enterprise.AuthenticationStatus.SEND_FAILURE;

import java.util.HashSet;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.security.enterprise.AuthenticationException;
import javax.security.enterprise.AuthenticationStatus;
import javax.security.enterprise.authentication.mechanism.http.HttpAuthenticationMechanism;
import javax.security.enterprise.authentication.mechanism.http.HttpMessageContext;
import javax.security.enterprise.authentication.mechanism.http.RememberMe;
import javax.security.enterprise.credential.CallerOnlyCredential;
import javax.security.enterprise.credential.Credential;
import javax.security.enterprise.identitystore.IdentityStore;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RequestScoped
@RememberMe(
        cookieMaxAgeSeconds = 3600,
        isRememberMeExpression = "this.isRememberMe(httpMessageContext)"
)
public class AuthMechanism implements HttpAuthenticationMechanism {

    @Inject
    private IdentityStore identityStore;

    @Override
    public AuthenticationStatus validateRequest(HttpServletRequest request, HttpServletResponse response, HttpMessageContext httpMessageContext) throws AuthenticationException {

        if (httpMessageContext.isAuthenticationRequest()) {

            Credential credential = httpMessageContext.getAuthParameters().getCredential();
            if (!(credential instanceof CallerOnlyCredential)) {
                throw new IllegalStateException("This authentication mechanism requires a programmatically provided CallerOnlyCredential");
            }

            CallerOnlyCredential callerOnlyCredential = (CallerOnlyCredential) credential;

            if ("reza".equals(callerOnlyCredential.getCaller())) {
                return httpMessageContext.notifyContainerAboutLogin("reza", new HashSet<>(asList("foo", "bar")));
            }

            if ("rezax".equals(callerOnlyCredential.getCaller())) {
                throw new AuthenticationException();
            }

            return SEND_FAILURE;

        }

        return httpMessageContext.doNothing();
    }
    public Boolean isRememberMe(HttpMessageContext httpMessageContext){
        return httpMessageContext.getRequest().getParameter("rememberme") != null;
    }
    
}
