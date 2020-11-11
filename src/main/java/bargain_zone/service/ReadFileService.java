package bargain_zone.service;

import bargain_zone.service.mapper.Mapper;
import bargain_zone.service.impl.CommodityServiceImpl;
import java.io.IOException;
import org.apache.log4j.Logger;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class ReadFileService {
    private static final Logger logger = Logger.getLogger(ReadFileService.class);

    public Elements readJsoupFromWebPage(String url, String header) throws IOException {
        Connection conn = Jsoup.connect(url).ignoreContentType(true);
        Document doc = conn.get();
        return doc.getElementsByClass(header);
    }
}
