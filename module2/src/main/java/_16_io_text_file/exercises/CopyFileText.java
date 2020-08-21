package _16_io_text_file.exercises;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

public class CopyFileText {
    private static final String path="Module2/src/main/java/_16_io_text_file/exercises/";

    public static void main(String[] args) {
        try {
            copyFile("a.txt","b.txt");
            //copyFileObsolete("a.txt","b.txt");
            readFile("a.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void copyFile(String source,String desPath) throws IOException {
        Path original = Paths.get(path+source);
        Path copy= Paths.get(path+desPath);
        Files.copy(original.toAbsolutePath(),copy.toAbsolutePath(), StandardCopyOption.REPLACE_EXISTING);
    }
    private static void copyFileObsolete(String source,String desPath) throws IOException {
        FileInputStream sourceFile = new FileInputStream(path+source);
        FileOutputStream destFile = new FileOutputStream(path+desPath);
        byte[] array = new byte[50];
        sourceFile.read(array);
        destFile.write(array);
        sourceFile.close();
        destFile.close();
    }
    private static void readFile(String source) throws IOException {
        List<String> lSt= Files.readAllLines(Paths.get(path+source));
        lSt.stream().forEach(s->{
            System.out.println(s);
        });
    }
}
