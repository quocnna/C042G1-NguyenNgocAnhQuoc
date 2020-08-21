package case_study.service;

import case_study.common.IFile;
import case_study.model.House;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.CSVWriter;
import com.opencsv.bean.*;
import com.opencsv.exceptions.CsvException;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;

public class HouseManager implements IFile<House> {
    private static Path housePath = Paths.get(IFile.path+"house.csv");
    @Override
    public void Write(House house) throws Exception {
        String[] columnMapping = { "id", "name", "areaUsed", "price","maxPeople","typeRent","typeBed","typeRoom","description","numberOfFloor"};
        ColumnPositionMappingStrategy<House> mapper = new ColumnPositionMappingStrategy<>();
        mapper.setType(House.class);
        mapper.setColumnMapping(columnMapping);

        boolean isExist = Files.exists(housePath);
        if(!isExist)
            Files.createFile(housePath);
        Writer writer = Files.newBufferedWriter(housePath, StandardCharsets.UTF_8, StandardOpenOption.APPEND);
        CSVWriter csvWriter = new CSVWriter(writer, CSVWriter.DEFAULT_SEPARATOR, CSVWriter.NO_QUOTE_CHARACTER,CSVWriter.DEFAULT_ESCAPE_CHARACTER,CSVWriter.DEFAULT_LINE_END);
        if(!isExist){
            String[] header = { "Id", "Name", "AreaUsed", "Price","Max People","Type Rent","Type Bed","Type Room","Description","Number Of Floor"};
            csvWriter.writeNext(header);
        }
        StatefulBeanToCsv beanToCsv = new StatefulBeanToCsvBuilder(writer)
                .withMappingStrategy(mapper)
                .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
                .withSeparator(CSVWriter.DEFAULT_SEPARATOR)
                .withEscapechar('\\').build();
        beanToCsv.write(house);
        csvWriter.close();
        writer.close();
    }

    @Override
    public List<String[]> Read() throws IOException, CsvException {
        Reader reader = Files.newBufferedReader(housePath);
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
