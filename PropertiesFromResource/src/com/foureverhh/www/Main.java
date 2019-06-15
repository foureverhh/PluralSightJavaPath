import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    private static Properties loadUserProperties(Properties userProperties) throws IOException {
        Path userFile = Paths.get("userValues.xml");
        if(Files.exists(userFile)) {
            try (InputStream input = Files.newInputStream(userFile)) {
                userProperties.loadFromXML(input);
            }
        }
        return userProperties;
    }
}

