package bargain_zone.util;

import bargain_zone.service.SettingDtoFieldsService;
import bargain_zone.service.impl.SettinOldPriceServiceImpl;
import bargain_zone.service.impl.SettingDeliveryServiceImpl;
import bargain_zone.service.impl.SettingDescriptionServiceImpl;
import bargain_zone.service.impl.SettingNewPriceServiceImpl;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Util {
    public static final String GENERAL = "https://allegro.pl/kategoria/%s?string=bargain_zone&bmatch=dict55-ctx-fas-1-4-1106";
    public static final List<String> CATEGORIES = new ArrayList<>(Arrays.asList("moda","uroda", "elektronika"));

    public static Map<String, String> productClassesMap;
    static{
        productClassesMap = new HashMap<>();
        productClassesMap.put("moda", "mh36_8 mvrt_8 mj7a_8 mg9e_8");
        productClassesMap.put("uroda", "mpof_ki myre_zn _9c44d_1Hxbq");
        productClassesMap.put("elektronika", "mpof_ki myre_zn _9c44d_1Hxbq");
    }

    private static final Map<String, SettingDtoFieldsService> modaFieldsMap;
    static {
        modaFieldsMap = new HashMap<>();
        modaFieldsMap.put("mj7a_4 mjyo_lo mqu1_16 mgn2_14", new SettingDescriptionServiceImpl());
        modaFieldsMap.put("mj7a_4 mjyo_lo _9c44d_jt8SR", new SettinOldPriceServiceImpl());
        modaFieldsMap.put("mj7a_4 mgn2_23", new SettingNewPriceServiceImpl());
        modaFieldsMap.put("_1y62o", new SettingDeliveryServiceImpl());
    }

    private static Map<String,SettingDtoFieldsService> urodaFieldsMap;
    static {
        urodaFieldsMap = new HashMap<>();
        urodaFieldsMap.put("m7er_k4 _9c44d_3TzmE", new SettingDescriptionServiceImpl());
        urodaFieldsMap.put("mp0t_ji mpof_vs _9c44d_1VS-Y _9c44d_3_DDQ mpof_vs _9c44d_2MDwk", new SettinOldPriceServiceImpl());
        urodaFieldsMap.put("_9c44d_3AMmE", new SettingNewPriceServiceImpl());
        urodaFieldsMap.put("_9c44d_3K52C", new SettingDeliveryServiceImpl());
    }

    private static Map<String,SettingDtoFieldsService> elektronikaFieldsMap;
    static {
        elektronikaFieldsMap = new HashMap<>();
        elektronikaFieldsMap.put("m7er_k4 _9c44d_3TzmE", new SettingDescriptionServiceImpl());
        elektronikaFieldsMap.put("mp0t_ji mpof_vs _9c44d_1VS-Y _9c44d_3_DDQ mpof_vs _9c44d_2MDwk", new SettinOldPriceServiceImpl());
        elektronikaFieldsMap.put("_9c44d_3AMmE", new SettingNewPriceServiceImpl());
        elektronikaFieldsMap.put("_9c44d_3K52C", new SettingDeliveryServiceImpl());
    }

    public static Map<String, Map<String,SettingDtoFieldsService>> categoriesMap;
    static{
        categoriesMap = new HashMap<>();
        categoriesMap.put("moda", modaFieldsMap);
        categoriesMap.put("uroda", urodaFieldsMap);
        categoriesMap.put("elektronika", elektronikaFieldsMap);
    }
}
