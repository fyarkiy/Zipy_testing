package bargain_zone.db;

import bargain_zone.model.Commodity;
import java.util.ArrayList;
import java.util.List;

public class Storage {
    public static final List<Commodity> products = new ArrayList<>();
    private static long id = 0;

    public static void addItem(Commodity item) {
        id++;
        item.setId(id);
        products.add(item);
    }
}
