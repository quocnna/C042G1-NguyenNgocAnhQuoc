package case_study.service;

import case_study.common.IFile;
import case_study.model.Customer;
import case_study.model.CustomerComparator;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.CSVWriter;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvException;
import case_study.common.Enum;
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

public class CustomerManager implements IFile<Customer> {
    private static Path customerPath = Paths.get(IFile.path + "customer.csv");

    @Override
    public void Write(Customer e) throws Exception {
        String[] columnMapping = {"id", "fullName", "birthday", "gender", "phone", "email", "typeCustomer", "address", "service"};
        ColumnPositionMappingStrategy<Customer> mapper = new ColumnPositionMappingStrategy<>();
        mapper.setType(Customer.class);
        mapper.setColumnMapping(columnMapping);

        boolean isExist = Files.exists(customerPath);
        if (!isExist)
            Files.createFile(customerPath);
        Writer writer = Files.newBufferedWriter(customerPath, StandardCharsets.UTF_8, StandardOpenOption.APPEND);
        CSVWriter csvWriter = new CSVWriter(writer, CSVWriter.DEFAULT_SEPARATOR, CSVWriter.NO_QUOTE_CHARACTER, CSVWriter.DEFAULT_ESCAPE_CHARACTER, CSVWriter.DEFAULT_LINE_END);
        if (!isExist) {
            String[] header = {"Id", "FullName", "Birthday", "Gender", "Phone", "Email", "Type Customer", "Address", "Service"};
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
        List<Customer> customerList = new ArrayList<>();
        String[] header = new String[9];
        Reader reader = Files.newBufferedReader(customerPath);
        CSVReader csvReader = new CSVReaderBuilder(reader).build();
        List<String[]> records = csvReader.readAll();
        for (int i = 0; i < records.size(); i++) {
            if (i == 0)
                header = records.get(0);
            else {
                Customer customer = new Customer();
                customer.setId(Integer.parseInt(records.get(i)[0]));
                customer.setFullName(records.get(i)[1]);
                customer.setBirthday(records.get(i)[2]);
                customer.setGender(records.get(i)[3]);
                customer.setPhone(records.get(i)[4]);
                customer.setEmail(records.get(i)[5]);
                Customer.TypeCustomer tmp =Enum.getTypeCustomer(records.get(i)[6]);
                customer.setTypeCustomer(tmp);
                customer.setAddress(records.get(i)[7]);
                customer.setService(null);
                customerList.add(customer);
            }
        }

        customerList.sort(new CustomerComparator());
        for (int i = 0; i < header.length; i++) {
            System.out.print(header[i] + "\t");
        }
        System.out.println(System.lineSeparator());
        customerList.stream().forEach(e -> {
            System.out.print(e.getId() + "\t");
            System.out.print(e.getFullName() + "\t");
            System.out.print(e.getBirthday() + "\t");
            System.out.print(e.getGender() + "\t");
            System.out.print(e.getPhone() + "\t");
            System.out.print(e.getEmail() + "\t");
            System.out.print(e.getTypeCustomer() + "\t");
            System.out.print(e.getAddress() + "\t");
            System.out.print(e.getService() + "\t");
            System.out.println(System.lineSeparator());
        });

        csvReader.close();
        reader.close();
        return records;
    }
}
