package net.moewes.projectB.poc.erpmock;

import org.keycloak.adapters.KeycloakConfigResolver;
import org.keycloak.adapters.KeycloakDeployment;
import org.keycloak.adapters.KeycloakDeploymentBuilder;
import org.keycloak.adapters.OIDCHttpFacade;
import org.keycloak.representations.adapters.config.AdapterConfig;

import java.util.logging.Logger;

public class MyKeycloakConfigResolver  implements KeycloakConfigResolver {

    @Override
    public KeycloakDeployment resolve(OIDCHttpFacade.Request request) {

        Logger log = Logger.getLogger("Keycloak Resolver"); // TODO: Inject zentralen Logger

        log.info("werde aufgerufen");

        System.out.println("Out: werde aufgerufen!");

        AdapterConfig config = new AdapterConfig();

        config.setRealm("master");
        config.setAuthServerUrl("http://localhost:8880/auth");
        config.setResource("pocerp");
        config.setPublicClient(true);
       /*
                "realm": "master",
                "auth-server-url": "http://localhost:8880/auth",
                "ssl-required": "external",
                "resource": "pocerp",
                "public-client": true
});*/

        return KeycloakDeploymentBuilder.build(config);

    }
}
