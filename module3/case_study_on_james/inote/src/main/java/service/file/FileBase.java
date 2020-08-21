package service.file;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

interface FileBase<T> {
    String path= "src/main/resources/";
    void Write(List<T> e) throws Exception;
    default List<String[]> Read(String filename) throws IOException, CsvException {
        Path pathDetail = Paths.get(path+filename);
        boolean isExist = Files.exists(pathDetail);
        if (!isExist)
            return new ArrayList<>();

        Reader reader = Files.newBufferedReader(pathDetail);
        CSVReader csvReader = new CSVReaderBuilder(reader).build();
        List<String[]> records = csvReader.readAll();
        csvReader.close();
        reader.close();
        return records;
    };
}
