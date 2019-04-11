import java.io.*;
import java.nio.file.*;
import java.net.*;

public class Download {
    public static void main(String[] args) throws Exception {
        InputStream in = new URL("https://coinmetrics.io/data/doge.csv").openStream();
        Files.copy(in, Paths.get("test.csv"), StandardCopyOption.REPLACE_EXISTING);
    }
}