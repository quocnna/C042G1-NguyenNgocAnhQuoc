package case_study.service;

import case_study.common.IFile;
import case_study.model.Villa;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.CSVWriter;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvException;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;

public class VillaManager implements IFile<Villa> {
    private static Path villaePath = Paths.get(IFile.path+"villa.csv");
    @Override
    public void Write(Villa villa) throws Exception {
        String[] columnMapping = { "id", "name", "areaUsed", "price","maxPeople","typeRent","typeBed","typeRoom","description","areaPool","numberOfFloor"};
        ColumnPositionMappingStrategy<Villa> mapper = new ColumnPositionMappingStrategy<>();
        mapper.setType(Villa.class);
        mapper.setColumnMapping(columnMapping);

        boolean isExist = Files.exists(villaePath);
        if(!isExist)
            Files.createFile(villaePath);
        Writer writer = Files.newBufferedWriter(villaePath, StandardCharsets.UTF_8, StandardOpenOption.APPEND);
        CSVWriter csvWriter = new CSVWriter(writer, CSVWriter.DEFAULT_SEPARATOR, CSVWriter.NO_QUOTE_CHARACTER,CSVWriter.DEFAULT_ESCAPE_CHARACTER,CSVWriter.DEFAULT_LINE_END);
        if(!isExist){
            String[] header = { "Id", "Name", "AreaUsed", "Price","Max People","Type Rent","Type Bed","Type Room","Description","Area Pool","Number Of Floor"};
            csvWriter.writeNext(header);
        }
        StatefulBeanToCsv beanToCsv = new StatefulBeanToCsvBuilder(writer)
                .withMappingStrategy(mapper)
                .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
                .withSeparator(CSVWriter.DEFAULT_SEPARATOR)
                .withEscapechar('\\').build();
        beanToCsv.write(villa);
        csvWriter.close();
        writer.close();
    }

    @Override
    public List<String[]> Read() throws IOException, CsvException {
        Reader reader = Files.newBufferedReader(villaePath);
        CSVReader csvReader = new CSVReaderBuilder(reader).build();
        List<String[]> records = csvReader.readAll();
        for (String[] record : records) {
            Arrays.stream(record).forEach(e-> System.out.print(e+"\t"));
            System.out.println(System.lineSeparator());
        }

        csvReader.close();
        reader.close();
        return records;
    }
}
