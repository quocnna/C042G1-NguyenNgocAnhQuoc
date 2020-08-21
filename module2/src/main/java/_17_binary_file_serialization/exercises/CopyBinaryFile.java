package _17_binary_file_serialization.exercises;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class CopyBinaryFile {
    private static final String path="Module2/src/main/java/_17_binary_file_serialization/exercises/";
    public static void main(String[] args) {
        try {
            copyBinaryFile("a.jpg","b.jpg");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void copyBinaryFile(String s, String d) throws IOException {
        Files.copy(Paths.get(path+s),Paths.get(path+d), StandardCopyOption.REPLACE_EXISTING);
    }
}
