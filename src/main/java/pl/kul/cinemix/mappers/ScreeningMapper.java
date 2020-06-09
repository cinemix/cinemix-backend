package pl.kul.cinemix.mappers;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.kul.cinemix.dto.entity.ScreeningDto;
import pl.kul.cinemix.models.Screening;

@Mapper(componentModel = "spring")
public interface ScreeningMapper {

    @Mapping(target = "room", source = "hall.id")
    @Mapping(target = "movie", source = "movie")
    ScreeningDto mapToScreeningDto(Screening screening);

    @InheritInverseConfiguration(name = "mapToScreeningDto")
    @Mapping(ignore = true, target = "movie.screenings")
    Screening mapToScreening(ScreeningDto screeningDto);
}
