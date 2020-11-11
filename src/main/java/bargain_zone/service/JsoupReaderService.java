package bargain_zone.service;

import java.io.IOException;
import org.apache.log4j.Logger;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class JsoupReaderService {
    private static final Logger logger = Logger.getLogger(JsoupReaderService.class);

    public Elements readJsoupFromWebPage(String url, String header) throws IOException {
        Connection conn = Jsoup.connect(url).ignoreContentType(true);
        logger.info("connection details " +  conn);
        Document doc = conn.get();
        return doc.getElementsByClass(header);
    }
}
