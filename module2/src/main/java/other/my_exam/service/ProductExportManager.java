package other.my_exam.service;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.CSVWriter;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvException;
import other.my_exam.common.IFile;
import other.my_exam.model.ProductExport;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class ProductExportManager implements IFile<ProductExport> {
    private static Path productPath = Paths.get(IFile.path + "product.csv");
    @Override
    public void Write(List<ProductExport> e) throws Exception {
        String[] columnMapping = {"id", "code", "name", "price", "quantity","brand","priceImport","cityImport","taxImport"};
        ColumnPositionMappingStrategy<ProductExport> mapper = new ColumnPositionMappingStrategy<>();
        mapper.setType(ProductExport.class);
        mapper.setColumnMapping(columnMapping);

        boolean isExist = Files.exists(productPath);
        if (!isExist)
            Files.createFile(productPath);
        Writer writer = Files.newBufferedWriter(productPath, StandardCharsets.UTF_8, StandardOpenOption.APPEND);
        CSVWriter csvWriter = new CSVWriter(writer, CSVWriter.DEFAULT_SEPARATOR, CSVWriter.NO_QUOTE_CHARACTER, CSVWriter.DEFAULT_ESCAPE_CHARACTER, CSVWriter.DEFAULT_LINE_END);
        if (!isExist) {
            String[] header = {"Id","Code", "Name", "Price","Quantity","Brand", "Price Import","City Import","Tax Import"};
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
        boolean isExist = Files.exists(productPath);
        if (!isExist)
            return new ArrayList<>();

        Reader reader = Files.newBufferedReader(productPath);
        CSVReader csvReader = new CSVReaderBuilder(reader).build();
        List<String[]> records = csvReader.readAll();
        csvReader.close();
        reader.close();
        return records;
    }
}
