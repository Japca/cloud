package net.japca.admin;

import de.codecentric.boot.admin.server.domain.entities.Instance;
import de.codecentric.boot.admin.server.web.client.HttpHeadersProvider;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.util.Base64Utils;

import java.nio.charset.StandardCharsets;

/**
 * Created by Jakub krhovják on 4/23/19.
 */
public class AuthHttpHeadersProvider implements HttpHeadersProvider {

    @Value("${spring.security.user.name}")
    private String username;

    @Value("${spring.security.user.password}")
    private String password;

    @Override
    public HttpHeaders getHeaders(Instance instance) {
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.AUTHORIZATION, encode(username, password));

        return headers;
    }

    protected String encode(String username, String password) {
        String token = Base64Utils.encodeToString((username + ":" + password).getBytes(StandardCharsets.UTF_8));
        return "Basic " + token;
    }
}
