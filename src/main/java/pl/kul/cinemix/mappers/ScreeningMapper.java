package pl.kul.cinemix.mappers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.kul.cinemix.dto.entity.ScreeningDto;
import pl.kul.cinemix.models.Screening;
import pl.kul.cinemix.repository.MovieRepository;
import pl.kul.cinemix.repository.ScreeningRepository;

@Component
@RequiredArgsConstructor
public class ScreeningMapper implements GeneralMapper<ScreeningDto, Screening> {

    private final ScreeningRepository screeningRepository;
    private final MovieRepository movieRepository;

    @Override
    public ScreeningDto mapToDto(Screening entity) {
        return ScreeningDto.builder()
                .id(entity.getId())
                .date(entity.getDate())
                .movie(movieRepository.findById(entity.getMovie()).orElse(null)) //rozwiazanie tymczasowe
                .room(entity.getRoom())
                .build();
    }

    @Override
    public Screening mapToEntity(ScreeningDto dto) {
        if (dto.getId() != null || dto.getMovie() != null || dto.getDate() != null || dto.getRoom() != null) {
            return null; // tymczasowe rozwiazanie, w przyszlosci lepiej rzucic tu wyjatkiem
        }
        return screeningRepository.findById(dto.getId()).orElseGet(() -> new Screening(dto.getMovie().getId(),
                dto.getDate(), dto.getRoom()));
    }
}
