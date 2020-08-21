package case_study.service;

import case_study.common.IFile;
import case_study.model.Booking;
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

public class BookingManager implements IFile<Booking> {
    private static Path bookingPath = Paths.get(IFile.path+"booking.csv");
    @Override
    public void Write(Booking e) throws Exception {
        String[] columnMapping = { "idCustomer","idService"};
        ColumnPositionMappingStrategy<Booking> mapper = new ColumnPositionMappingStrategy<>();
        mapper.setType(Booking.class);
        mapper.setColumnMapping(columnMapping);

        boolean isExist = Files.exists(bookingPath);
        if(!isExist)
            Files.createFile(bookingPath);
        Writer writer = Files.newBufferedWriter(bookingPath, StandardCharsets.UTF_8, StandardOpenOption.APPEND);
        CSVWriter csvWriter = new CSVWriter(writer, CSVWriter.DEFAULT_SEPARATOR, CSVWriter.NO_QUOTE_CHARACTER,CSVWriter.DEFAULT_ESCAPE_CHARACTER,CSVWriter.DEFAULT_LINE_END);
        if(!isExist){
            String[] header = { "IdCustomer", "IdService"};
            csvWriter.writeNext(header);
        }
        StatefulBeanToCsv beanToCsv = new StatefulBeanToCsvBuilder(writer)
                .withMappingStrategy(mapper)
                .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
                .withSeparator(CSVWriter.DEFAULT_SEPARATOR)
                .withEscapechar('\\').build();
        beanToCsv.write(e);
        csvWriter.close();
        writer.close();
    }

    @Override
    public List<String[]> Read() throws IOException, CsvException {
        Reader reader = Files.newBufferedReader(bookingPath);
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
