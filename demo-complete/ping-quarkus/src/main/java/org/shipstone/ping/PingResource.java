package org.shipstone.ping;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Optional;

@Path("/ping")
public class PingResource {

    @ConfigProperty(name = "ping.message")
    private Optional<String> message;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String ping() {
        return message.orElse("pong");
    }
}
