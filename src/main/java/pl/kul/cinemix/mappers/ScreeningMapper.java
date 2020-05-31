package pl.kul.cinemix.mappers;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.kul.cinemix.dto.entity.ScreeningDto;
import pl.kul.cinemix.models.Screening;

@Mapper(componentModel = "spring")
public interface ScreeningMapper {

    @Mapping(target = "movieId", source = "movie.id")
    ScreeningDto mapToScreeningDto(Screening screening);

    @InheritInverseConfiguration(name = "mapToScreeningDto")
    Screening mapToScreening(ScreeningDto screeningDto);
}
