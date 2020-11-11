package bargain_zone.dao;

import bargain_zone.model.Commodity;
import java.util.List;

public interface GenericDao {
    Commodity create(Commodity item);

    List<Commodity> getTopItems();
}
