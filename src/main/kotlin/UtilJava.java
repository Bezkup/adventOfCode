package main.kotlin;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class UtilJava {

    public static List<String> readInput(String filename) {
        try {
            return Files.readAllLines(Paths.get("src/main/resources/"+filename));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
