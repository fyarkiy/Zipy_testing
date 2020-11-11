package bargain_zone.service.impl;

import bargain_zone.model.dto.CommodityRequestDto;
import bargain_zone.service.SettingDtoFieldsService;

public class SettingDeliveryServiceImpl implements SettingDtoFieldsService {
    @Override
    public CommodityRequestDto apply(CommodityRequestDto dto, String text) {
        dto.setDelivery(text);
        return dto;
    }
}
