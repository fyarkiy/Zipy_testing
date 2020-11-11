package bargain_zone;

import bargain_zone.service.BargainProcessService;
import bargain_zone.service.WriteFileService;

public class Main {
    public static void main(String args[]) throws Exception {

        BargainProcessService reader = new BargainProcessService();
        reader.getAllProducts();
        WriteFileService writer = new WriteFileService();
        writer.writeCsv("bargain_list.csv");
    }
}
