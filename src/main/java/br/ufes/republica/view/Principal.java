package br.ufes.republica.view;

import br.ufes.republica.service.UsuarioService;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Principal {
    
    public static void main(String[] args) {
        
        Principal app = new Principal();
        Properties prop = app.loadPropertiesFile("config.properties");
        System.setProperties(prop);
        
//        new LoginPresenter();

        var service = new UsuarioService();
        try {
            var usuario = service.getByLogin("teste");
            System.out.println(usuario.getSenha());
        } catch(Exception e) {
        }
        
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
