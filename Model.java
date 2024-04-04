package Exceptions_SeminarHW;

import java.io.FileWriter;
import java.io.IOException;

public class Model {

    public void saveToFile(String[] userDetails) throws IOException {
        try (FileWriter fileWriter = new FileWriter(userDetails[1] + ".txt", true)) {
            fileWriter.write(userDetails[0]);
            for (int i = 1; i < userDetails.length; i++) {
                fileWriter.write(", ");
                fileWriter.write(userDetails[i]);
            }
            fileWriter.write("\n");
            fileWriter.flush();
        }
    }
}