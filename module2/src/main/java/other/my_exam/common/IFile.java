package other.my_exam.common;

import com.opencsv.exceptions.CsvException;

import java.io.IOException;
import java.util.List;

public interface IFile<T> {
    String path= "src/main/java/other/my_exam/data/";
    void Write(List<T> e) throws Exception;
    List<String[]> Read() throws IOException, CsvException;
}
