package bargain_zone.controller;

import bargain_zone.dao.implementation.GenericDaoImpl;
import java.io.FileWriter;
import java.io.IOException;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

public class WriteController {
    private static final String HEADERS = "Extract from allegro site";
    private GenericDaoImpl modaDao = new GenericDaoImpl();
    private static final String FILE_PATH = "bargain_list.csv";


    public void createCSVFile() throws IOException {
        FileWriter out = new FileWriter(FILE_PATH);

        try (final CSVPrinter printer = new CSVPrinter(out, CSVFormat.DEFAULT)) {
            modaDao.getTopItems().forEach((i) -> {
                try {
                    printer.printRecord(i);
                } catch (IOException e) {
                    throw new RuntimeException("can't write file", e);
                }
            });
        }
    }
}
