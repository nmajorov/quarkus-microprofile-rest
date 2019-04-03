package org.acme.health;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.health.Health;
import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.HealthCheckResponseBuilder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.enterprise.context.ApplicationScoped;

@Health
@ApplicationScoped
public class DatabaseConnectionHealthCheck implements HealthCheck {

    @ConfigProperty(name = "database.up", defaultValue = "false")
    private boolean databaseUp;

    @ConfigProperty(name = "database.url")
    private String databaseURL;
    
    @ConfigProperty(name = "database.user")
    private String databaseUser;
    
    @ConfigProperty(name = "database.password")
    private String databasePWD;

    
    

    @Override
    public HealthCheckResponse call() {

        HealthCheckResponseBuilder responseBuilder = HealthCheckResponse.named("Database connection health check");

        try {
            simulateDatabaseConnectionVerification();
            responseBuilder.up();
        } catch (IllegalStateException e) {
            // cannot access the database
            responseBuilder.down()
                    .withData("error", e.getMessage());
        }

        return responseBuilder.build();
    }

    private void simulateDatabaseConnectionVerification() {
        
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
        
        
        try {
           
            
            Connection conn = DriverManager.getConnection(databaseURL+"?" +
                                           "user="+ databaseUser + "&password="+ databasePWD);
         
         
            System.out.println(conn.getMetaData().getDatabaseProductName() );
            System.out.println(conn.getMetaData().getDatabaseMajorVersion() );
           //...
        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
           throw new IllegalStateException(ex);
        }
    }
}
