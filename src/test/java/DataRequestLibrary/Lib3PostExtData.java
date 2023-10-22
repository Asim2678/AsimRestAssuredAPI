package DataRequestLibrary;

import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Lib3PostExtData {
    public String ReadFiletoString() {

        String strpostData = "";
        String strPath = "C:\\Users\\mabassra.SCT\\Downloads\\postrequestdata.json";
        Path path = Paths.get(strPath);

        {
            try {
                strpostData = new String(Files.readAllBytes(path));
            } catch (IOException e) {
                throw new RuntimeException(e);

            }

        }
        return strpostData;

    }
}
