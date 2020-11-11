package bargain_zone.service.impl;

import bargain_zone.model.dto.CommodityRequestDto;
import bargain_zone.service.SettingDtoFieldsService;

public class SettinOldPriceServiceImpl implements SettingDtoFieldsService {
    @Override
    public CommodityRequestDto apply(CommodityRequestDto dto, String text) {
        dto.setOldPrice(text);
        return dto;
    }
}
