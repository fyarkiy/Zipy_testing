package bargain_zone.dao.implementation;

import bargain_zone.dao.GenericDao;
import bargain_zone.db.Storage;
import bargain_zone.model.Commodity;
import java.util.ArrayList;
import java.util.List;

public class GenericDaoImpl implements GenericDao {

    public Commodity create(Commodity item) {
        Storage.addItem(item);
        return item;
    }

    public List<Commodity> getTopItems() {
        return new ArrayList<>(Storage.products);
    }
}
