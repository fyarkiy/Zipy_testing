package bargain_zone;

import bargain_zone.service.BargainProductDataProcessService;
import bargain_zone.service.WriteFileService;
import bargain_zone.util.Util;

public class Main {
    public static void main(String args[]) throws Exception {

        BargainProductDataProcessService reader = new BargainProductDataProcessService();
        reader.getAllProducts();
        WriteFileService writer = new WriteFileService();
        writer.writeCsv(Util.OUTPUT_FILE);
    }
}
