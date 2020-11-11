package bargain_zone.service;

import bargain_zone.model.dto.CommodityRequestDto;
import java.util.Map;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.apache.log4j.Logger;

public class Parser {
    private static final Logger logger = Logger.getLogger(Parser.class);

    public CommodityRequestDto parseElement(Elements children, Map<String, SettingDtoFieldsService> mapUrl){
        CommodityRequestDto dto = new CommodityRequestDto();
        for (Element el : children) {
            if (mapUrl.get(el.attr("class"))!= null) {
                mapUrl.get(el.attr("class")).apply(dto, el.text());
            }
            logger.info(el.text());
        }
        return dto;
    }
}
