package bargain_zone.service.mapper;

import bargain_zone.model.Commodity;
import bargain_zone.model.dto.CommodityRequestDto;
import java.util.Optional;
import org.apache.log4j.Logger;

public class Mapper {
    private static final Logger logger = Logger.getLogger(Mapper.class);
    private static final String PRICE_REGEX = "(\\D+)?(\\d+%)?(\\d+)(,)(\\d+)(\\D+)?";
    private static final String FLOAT_REGEX = "[+-]?([0-9]*[.])?[0-9]+";

    public Commodity mapDtoToCommodity(CommodityRequestDto dto, String category) {
        Commodity commodity = new Commodity();
        String oldPrice = Optional.ofNullable(dto.getOldPrice()).orElse("no old price")
                .replaceAll(PRICE_REGEX, "$3.$5");
        String newPrice = Optional.ofNullable(dto.getNewPrice()).orElse("no new price")
                .replaceAll(PRICE_REGEX, "$3.$5");
        if (oldPrice.matches(FLOAT_REGEX) && newPrice.matches(FLOAT_REGEX)) {
            logger.info(Double.parseDouble(oldPrice));
            logger.info(Double.parseDouble(newPrice));
            commodity.setOldPrice(Double.parseDouble(oldPrice));
            commodity.setNewPrice(Double.parseDouble(newPrice));
        } else {
            return commodity;
        }
        commodity.setCategory(category);
        commodity.setDescription(dto.getDescription());
        commodity.setDiscount((int) ((1 - commodity.getNewPrice() / commodity.getOldPrice()) * 100));
        commodity.setDelivery(dto.getDelivery());
        commodity.setComments(dto.getNewPrice().replaceAll("(\\S+ zł)(\\D+)", "$2"));
        return commodity;
    }
}
