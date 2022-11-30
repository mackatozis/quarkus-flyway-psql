package com.github.mackatozis.quarkus.flyway.psql.config;

import io.quarkus.runtime.StartupEvent;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.flywaydb.core.Flyway;

@ApplicationScoped
public class FlywayMigration {

    @ConfigProperty(name = "quarkus.datasource.reactive.url")
    String dbUrl;

    @ConfigProperty(name = "quarkus.datasource.username")
    String dbUsername;

    @ConfigProperty(name = "quarkus.datasource.password")
    String dbPassword;

    @ConfigProperty(name = "quarkus.flyway.default-schema")
    String defaultSchema;

    @ConfigProperty(name = "quarkus.flyway.locations")
    String locations;

    @ConfigProperty(name = "quarkus.flyway.out-of-order")
    boolean outOfOrder;

    public void runFlywayMigration(@Observes StartupEvent event) {
        Flyway flyway = Flyway.configure()
            .dataSource("jdbc:" + dbUrl, dbUsername, dbPassword)
            .defaultSchema(defaultSchema)
            .locations(locations)
            .outOfOrder(outOfOrder)
            .load();

        flyway.migrate();
    }

}
