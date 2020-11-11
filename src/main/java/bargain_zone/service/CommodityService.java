package bargain_zone.service;

import bargain_zone.model.Commodity;

import java.util.List;

public interface CommodityService {
    Commodity add (Commodity item);

    List<Commodity> getTopItems();
}
