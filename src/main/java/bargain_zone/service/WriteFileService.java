package bargain_zone.service;

import bargain_zone.dao.GenericDao;
import bargain_zone.dao.implementation.GenericDaoImpl;
import bargain_zone.model.Commodity;
import java.io.FileWriter;
import java.io.IOException;
import org.supercsv.cellprocessor.Optional;
import org.supercsv.cellprocessor.ParseDouble;
import org.supercsv.cellprocessor.ParseInt;
import org.supercsv.cellprocessor.constraint.NotNull;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

public class WriteFileService {
    private static final GenericDao genericDao = new GenericDaoImpl();

    public void writeCsv(String csvFileName) throws IOException {
        try (ICsvBeanWriter beanWriter = new CsvBeanWriter(new FileWriter(csvFileName),
                CsvPreference.STANDARD_PREFERENCE)) {

            final String[] header = new String[]{"category", "description", "newPrice", "oldPrice",
                    "discount", "delivery", "comments"};
            final CellProcessor[] processors = getProcessors();
            beanWriter.writeHeader(header);

            for (final Commodity item : genericDao.getTopItems()) {
                beanWriter.write(item, header, processors);
            }
        } catch (IOException e) {
            throw new RuntimeException("can't create file");
        }
    }

    private static CellProcessor[] getProcessors() {
        return new CellProcessor[]{
                new NotNull(),
                new NotNull(),
                new ParseDouble(),
                new ParseDouble(),
                new ParseInt(),
                new Optional(),
                new Optional()};
    }
}
