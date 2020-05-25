package MyProject.db;

import org.flywaydb.core.Flyway;
import org.flywaydb.core.api.configuration.FluentConfiguration;

public class DbSetup {
    public static void migrate(String url, String username, String password){
        FluentConfiguration fluentConfiguration = new FluentConfiguration().dataSource(url, username, password);
        Flyway flyway = new Flyway(fluentConfiguration);
        flyway.migrate();
    }
}
