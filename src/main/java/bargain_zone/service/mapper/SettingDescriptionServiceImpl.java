package bargain_zone.service.mapper;

import bargain_zone.model.dto.CommodityRequestDto;
import bargain_zone.service.SettingDtoFieldsService;

public class SettingDescriptionServiceImpl implements SettingDtoFieldsService {
    @Override
    public CommodityRequestDto apply(CommodityRequestDto dto, String text) {
        dto.setDescription(text);
        return dto;
    }
}
