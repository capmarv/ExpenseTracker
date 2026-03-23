package ExpnTckr;

import java.io.File;
import java.io.IOException;

public class FileService {
    public static void initializeFile() throws IOException {
        File file = new File("csv.txt");

        if(!file.exists()){
            file.createNewFile();
            System.out.println("File created");
        }
    }
}
