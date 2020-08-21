package examination.service;
import com.opencsv.CSVWriter;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import examination.common.IData;
import examination.model.Contact;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class ContactManager implements IData<Contact> {
    private static Path contactPath = Paths.get(IData.path + "contact.csv");
    @Override
    public void Write(List<Contact> e) throws Exception {
        String[] columnMapping = {"phoneNumber", "contactGroup", "fullName", "gender", "address","birthday","email"};
        ColumnPositionMappingStrategy<Contact> mapper = new ColumnPositionMappingStrategy<>();
        mapper.setType(Contact.class);
        mapper.setColumnMapping(columnMapping);

        boolean isExist = Files.exists(contactPath);
        if (!isExist)
            Files.createFile(contactPath);
        Writer writer = Files.newBufferedWriter(contactPath, StandardCharsets.UTF_8, StandardOpenOption.APPEND);
        CSVWriter csvWriter = new CSVWriter(writer, CSVWriter.DEFAULT_SEPARATOR, CSVWriter.NO_QUOTE_CHARACTER, CSVWriter.DEFAULT_ESCAPE_CHARACTER, CSVWriter.DEFAULT_LINE_END);
        if (!isExist) {
            String[] header = {"Phone Number","Contact Group", "Full Name", "Gender","Address","Birthday","Email"};
            csvWriter.writeNext(header);
        }

        StatefulBeanToCsv beanToCsv = new StatefulBeanToCsvBuilder(writer)
                .withMappingStrategy(mapper)
                .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
                .withSeparator(CSVWriter.DEFAULT_SEPARATOR)
                .withEscapechar('\\').build();

        List<Contact> res = new ArrayList<>();
        for (int i = 0; i < e.size(); i++) {
            Contact contact = new Contact(e.get(i).getPhoneNumber(),e.get(i).getContactGroup(), e.get(i).getFullName(),
                    e.get(i).getGender(),e.get(i).getAddress(),e.get(i).getBirthday(),e.get(i).getEmail());
            res.add(contact);
        }
        beanToCsv.write(res);
        csvWriter.close();
        writer.close();
    }
}
