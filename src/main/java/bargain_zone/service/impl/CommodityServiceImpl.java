package bargain_zone.service.impl;

import bargain_zone.dao.GenericDao;
import bargain_zone.dao.implementation.GenericDaoImpl;
import bargain_zone.model.Commodity;
import bargain_zone.service.CommodityService;
import java.util.List;

public class CommodityServiceImpl implements CommodityService {
    private GenericDao genericDao = new GenericDaoImpl();

    @Override
    public Commodity add(Commodity item) {
        if (item.getOldPrice() != 0 && item.getNewPrice() != 0 && item.getDiscount() != 0) {
            genericDao.create(item);
        }
        return item;
    }

    @Override
    public List<Commodity> getTopItems() {
        return genericDao.getTopItems();
    }
}
