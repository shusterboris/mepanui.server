package application.config;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Settings {
    private static final String fileSeparator = FileSystems.getDefault().getSeparator();
    public final static String appPath = getAppFolder();
    public final static String imgStorePath = getAppFolder().concat("image").concat(fileSeparator);

    public static String getAppFolder() {
        URL fileURL = Settings.class.getClassLoader().getResource("");
        try {
            URI uri;
            if (fileURL.toString().startsWith("jar")) {
                String urlStr = fileURL.toString();
                int illegalCharPos = urlStr.indexOf("!");
                urlStr = urlStr.substring(4, illegalCharPos);
                uri = new URI(urlStr);
            } else
                uri = fileURL.toURI();
            Path path = Paths.get(uri);
            return path.getParent().toString().concat(fileSeparator);
        } catch (URISyntaxException e) {
            return "";
        }
    }
}
