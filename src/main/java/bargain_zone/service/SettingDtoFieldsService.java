package bargain_zone.service;

import bargain_zone.model.dto.CommodityRequestDto;

public interface SettingDtoFieldsService {
    CommodityRequestDto apply(CommodityRequestDto dto, String text);
}
