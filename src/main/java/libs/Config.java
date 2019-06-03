package libs;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Config {

    public static String getConfig(String key) {
        try {
            Properties prop = new Properties();
            prop.load(new FileInputStream("Config/Config.properties"));
            return prop.getProperty(key);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;

    }

}
