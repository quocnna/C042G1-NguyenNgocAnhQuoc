package examination.service;

import com.opencsv.CSVWriter;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import examination.common.IData;
import examination.model.ProductDTO;
import examination.model.ProductImport;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class ProductImportManager implements IData<ProductImport> {
    private static Path productPath = Paths.get(IData.path + "product.csv");
    @Override
    public void Write(List<ProductImport> e) throws Exception {
        String[] columnMapping = {"id", "code", "name", "price", "quantity","brand","priceImport","cityImport","taxImport","priceExport","countryExport"};
        ColumnPositionMappingStrategy<ProductDTO> mapper = new ColumnPositionMappingStrategy<>();
        mapper.setType(ProductDTO.class);
        mapper.setColumnMapping(columnMapping);

        boolean isExist = Files.exists(productPath);
        if (!isExist)
            Files.createFile(productPath);
        Writer writer = Files.newBufferedWriter(productPath, StandardCharsets.UTF_8, StandardOpenOption.APPEND);
        CSVWriter csvWriter = new CSVWriter(writer, CSVWriter.DEFAULT_SEPARATOR, CSVWriter.NO_QUOTE_CHARACTER, CSVWriter.DEFAULT_ESCAPE_CHARACTER, CSVWriter.DEFAULT_LINE_END);
        if (!isExist) {
            String[] header = {"Id","Code", "Name", "Price","Quantity","Brand","Price Import","City Import","Tax Import","Price Export","Country Export"};
            csvWriter.writeNext(header);
        }

        StatefulBeanToCsv beanToCsv = new StatefulBeanToCsvBuilder(writer)
                .withMappingStrategy(mapper)
                .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
                .withSeparator(CSVWriter.DEFAULT_SEPARATOR)
                .withEscapechar('\\').build();

        List<ProductDTO> res = new ArrayList<>();
        for (int i = 0; i < e.size(); i++) {
            ProductDTO productDTO= new ProductDTO(e.get(i).getId(),e.get(i).getCode(),e.get(i).getName(),e.get(i).getPrice()
                    ,e.get(i).getQuantity(),e.get(i).getBrand(),e.get(i).getPriceImport(),e.get(i).getCityImport(),e.get(i).getTaxImport(),
                    0,"");
            res.add(productDTO);
        }
        beanToCsv.write(res);
        csvWriter.close();
        writer.close();
    }
}
