package case_study.common;

import com.opencsv.exceptions.CsvException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public interface IFile<T> {
    String path= "src/main/java/case_study/data/";
    void Write(T e) throws Exception;
    List<String[]> Read() throws IOException, CsvException;
}
