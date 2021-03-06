package br.ufes.republica.view;

import br.ufes.republica.view.login.LoginPresenter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Principal {
    
    public static void main(String[] args) {
        
        Principal app = new Principal();
        Properties prop = app.loadPropertiesFile("config.properties");
        System.setProperty("db.name", prop.getProperty("db.name"));
        
        new LoginPresenter();
        
    }

    public Properties loadPropertiesFile(String filePath) {
        Properties prop = new Properties();

        try (InputStream resourceAsStream = getClass().getClassLoader().getResourceAsStream(filePath)) {
            prop.load(resourceAsStream);
        } catch (IOException e) {
            System.err.println("Unable to load properties file : " + filePath);
        }

        return prop;
    }
    
}
