package fr.sihm.ping.configuration.health;

import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Liveness;

import javax.enterprise.context.ApplicationScoped;

@Liveness
@ApplicationScoped
public class PingHealth implements HealthCheck {

  @Override
  public HealthCheckResponse call() {
    return HealthCheckResponse.named("Ping health check").up().build();
  }

}
