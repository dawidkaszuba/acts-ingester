package pl.dawidkaszuba.acts_ingester.mapper;

import org.mapstruct.Mapper;
import pl.dawidkaszuba.acts_ingester.model.PublishingHouse;
import pl.dawidkaszuba.acts_ingester.model.dto.PublishingHouseDto;

@Mapper(componentModel = "spring")
public interface PublishingHouseMapper {

    PublishingHouseDto toDto(PublishingHouse publishingHouse);
}
