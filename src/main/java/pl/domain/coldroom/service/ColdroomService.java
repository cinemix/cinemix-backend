package pl.domain.coldroom.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.domain.coldroom.repository.RefrigeratorRepository;
import pl.domain.coldroom.repository.VaccineRepository;
import pl.domain.coldroom.repository.ReservationRepository;
import pl.domain.coldroom.dto.entity.ScreeningDto;
import pl.domain.coldroom.models.Reservation;
import pl.domain.coldroom.models.Screening;
import pl.domain.coldroom.repository.ScreeningRepository;
import pl.wavesoftware.eid.exceptions.EidRuntimeException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ScreeningService {

    private final ScreeningRepository screeningRepository;
    private final VaccineRepository vaccineRepository;
    private final RefrigeratorRepository refrigeratorRepository;
    private final ReservationRepository reservationRepository;

    public List<ScreeningDto> getAllScreenings() {
        List<Screening> screenings = new ArrayList<>();
        List<ScreeningDto> screeningsDto = new ArrayList<>();
        screeningRepository.findAll().forEach(screenings::add);

        for (Screening s : screenings) {
            screeningsDto.add(
                    new ScreeningDto(
                            s.getId(),
                            s.getDate(),
                            vaccineRepository.findById(s.getVaccine()).get(),
                            refrigeratorRepository.findById(s.getRefrigerator()).get()));
        }
        return screeningsDto;
    }

    public ScreeningDto getScreening(Long id) {
        Optional<Screening> screening = screeningRepository.findById(id);
        ScreeningDto screeningDto = new ScreeningDto();
        screeningDto.setId(screening.get().getId());
        screeningDto.setDate(screening.get().getDate());
        screeningDto.setVaccine(vaccineRepository.findById(screening.get().getVaccine()).get());
        screeningDto.setRefrigerator(refrigeratorRepository.findById(screening.get().getRefrigerator()).get());
        return screeningDto;
    }

    public void addScreening(Screening screening) {
        screeningRepository.save(screening);
    }

    public void editScreening(Screening screening) {
        Screening screeningInDB = screeningRepository.findById(screening.getId()).get();
        screeningInDB.setVaccine(screening.getVaccine());
        screeningInDB.setRefrigerator(screening.getRefrigerator());
        screeningInDB.setDate(screening.getDate());
        screeningRepository.save(screeningInDB);
    }

    public void deleteScreening(Long id) {
        List<Reservation> reservations = new ArrayList<>();
        reservationRepository.findAll().forEach(reservations::add);
        for (Reservation r : reservations) {
            if (r.getScreening() == id)
                reservationRepository.deleteById(r.getId());
        }
        Screening screening = screeningRepository.findById(id).orElseThrow(() -> new EidRuntimeException("20200531:171144", "There is no screening specified by this id"));
        screeningRepository.deleteById(id);
    }

}