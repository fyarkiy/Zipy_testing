package bargain_zone.service;

import bargain_zone.model.dto.CommodityRequestDto;
import java.util.Map;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.apache.log4j.Logger;

public class Parser {
    private static final Logger logger = Logger.getLogger(Parser.class);

    public CommodityRequestDto parseElement(Elements children, Map<String, String> mapUrl){
        CommodityRequestDto commodityRequestDto = new CommodityRequestDto();
        for (Element el : children) {
            if (el.attr("class").equals(mapUrl.get("commName"))) {
                commodityRequestDto.setDescription(el.text());
            } else if (el.attr("class").equals(mapUrl.get("oldPrice"))) {
                commodityRequestDto.setOldPrice(el.text());
            } else if (el.attr("class").equals(mapUrl.get("newPrice"))) {
                commodityRequestDto.setNewPrice(el.text());
            } else if (el.attr("class").equals(mapUrl.get("delivery"))) {
                commodityRequestDto.setDelivery(el.text());
            }
            logger.info(el.text());
        }
        return commodityRequestDto;
    }
}
