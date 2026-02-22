package pl.dawidkaszuba.acts_ingester.mapper;

import org.mapstruct.Mapper;
import pl.dawidkaszuba.acts_ingester.model.ActInYear;
import pl.dawidkaszuba.acts_ingester.model.ActMetadataEvent;
import pl.dawidkaszuba.acts_ingester.model.dto.ActInYearDto;

@Mapper(componentModel = "spring")
public interface ActInYearMapper {

    ActInYearDto toDto(ActInYear actInYear);
    ActMetadataEvent toEvent(ActInYearDto actInYear);
}
