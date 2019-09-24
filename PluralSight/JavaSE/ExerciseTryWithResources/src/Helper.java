import java.io.*;

public class Helper{

    public static Reader openReader(String file) throws IOException {
        return new FileReader(file);

                //new InputStreamReader(new FileInputStream(file));
    }

    public static Writer openWriter(String file) throws IOException {
        return new OutputStreamWriter(new FileOutputStream(file));
    }
}
