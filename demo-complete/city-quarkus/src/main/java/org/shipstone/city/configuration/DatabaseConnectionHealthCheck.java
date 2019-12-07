package org.shipstone.city.configuration;

import io.agroal.api.AgroalDataSource;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.HealthCheckResponseBuilder;
import org.eclipse.microprofile.health.Liveness;
import org.eclipse.microprofile.health.Readiness;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.sql.SQLException;

@Liveness
@ApplicationScoped
public class DatabaseConnectionHealthCheck implements HealthCheck {

  @Inject
  AgroalDataSource defaultDataSource;

  @Override
  public HealthCheckResponse call() {
    HealthCheckResponseBuilder responseBuilder = HealthCheckResponse.named("Connection à la base de donnée INSEE");
    try {
      simulateDatabaseConnectionVerification();
      responseBuilder.up();
    } catch (IllegalStateException | SQLException e) {
      responseBuilder.down();
    }
    return responseBuilder.build();
  }

  private void simulateDatabaseConnectionVerification() throws SQLException {
    if (defaultDataSource != null) {
      defaultDataSource.getConnection().isValid(0);
    }
  }

}
