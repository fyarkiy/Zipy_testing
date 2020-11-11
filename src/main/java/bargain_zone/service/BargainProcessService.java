package bargain_zone.service;

import bargain_zone.db.Storage;
import bargain_zone.model.Commodity;
import bargain_zone.model.dto.CommodityRequestDto;
import bargain_zone.service.impl.CommodityServiceImpl;
import bargain_zone.service.mapper.Mapper;
import bargain_zone.util.Util;
import java.io.IOException;
import java.util.Map;
import org.apache.log4j.Logger;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class BargainProcessService {
    private static final Logger logger = Logger.getLogger(BargainProcessService.class);
    private CommodityService commodityService = new CommodityServiceImpl();
    private Mapper mapper = new Mapper();
    private ReadFileService readFileService = new ReadFileService();
    private Parser parser = new Parser();

    public void getAllBargains() throws IOException {
        for (int i = 0; i < Util.categories.size(); ) {
            String category = Util.categories.get(i);
            String sitePage = String.format(Util.GENERAL, category);
            i++;
            int pageNumber = 1;
            String header = Util.categoriesMap.get(category).get("divHead");
            while (Storage.products.size() < (100 * i)) {
                Elements productName = readFileService.readJsoupFromWebPage(sitePage + "&p=" + pageNumber, header);
                getBargainsFromPage(productName, category, i);
                pageNumber++;
            }
        }
    }

    private void getBargainsFromPage(Elements productName, String category, int counter) {
        Map<String, String> mapUrl = Util.categoriesMap.get(category);
        for (int i = 0; i < productName.size(); i++) {
            Element element = productName.get(i);
            Elements children = element.children();
            CommodityRequestDto dto = parser.parseElement(children, mapUrl);
            if (Storage.products.size() < (100 * counter)) {
                addCommodityToStorage(dto, category);
            } else {
                i = productName.size();
            }
        }
    }

    private Commodity addCommodityToStorage(CommodityRequestDto dto, String category) {
        return commodityService.add(mapper.mapDtoToCommodity(dto, category));
    }
}
