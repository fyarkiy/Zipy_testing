package bargain_zone.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Util {

    public static final String GENERAL = "https://allegro.pl/kategoria/%s?string=bargain_zone&bmatch=dict55-ctx-fas-1-4-1106";
    public static final List<String> categories = new ArrayList<>(Arrays.asList("moda","uroda", "elektronika"));

    public static Map<String,String> modaMap;
    static {
        modaMap = new HashMap<>();
        modaMap.put("divHead", "mh36_8 mvrt_8 mj7a_8 mg9e_8");
        modaMap.put("commName", "mj7a_4 mjyo_lo mqu1_16 mgn2_14");
        modaMap.put("oldPrice", "mj7a_4 mjyo_lo _9c44d_jt8SR");
        modaMap.put("newPrice", "mj7a_4 mgn2_23");
        modaMap.put("delivery", "_1y62o");
    }

    public static Map<String,String> urodaMap;
    static {
        urodaMap = new HashMap<>();
        urodaMap.put("divHead", "mpof_ki myre_zn _9c44d_1Hxbq");
        urodaMap.put("commName", "m7er_k4 _9c44d_3TzmE");
        urodaMap.put("oldPrice", "mp0t_ji mpof_vs _9c44d_1VS-Y _9c44d_3_DDQ mpof_vs _9c44d_2MDwk");
        urodaMap.put("newPrice", "_9c44d_3AMmE");
        urodaMap.put("delivery", "_9c44d_3K52C");
    }
    public static Map<String,String> elMap;
    static {
        elMap = new HashMap<>();
        elMap.put("divHead", "mpof_ki myre_zn _9c44d_1Hxbq");
        elMap.put("commName", "m7er_k4 _9c44d_3TzmE");
        elMap.put("oldPrice", "mp0t_ji mpof_vs _9c44d_1VS-Y _9c44d_3_DDQ mpof_vs _9c44d_2MDwk");
        elMap.put("newPrice", "_9c44d_3AMmE");
        elMap.put("delivery", "_9c44d_3K52C");
    }

    public static Map<String, Map<String,String>> categoriesMap;
    static{
        categoriesMap = new HashMap<>();
        categoriesMap.put("moda", modaMap);
        categoriesMap.put("uroda", urodaMap);
        categoriesMap.put("elektronika", elMap);
    }
}
