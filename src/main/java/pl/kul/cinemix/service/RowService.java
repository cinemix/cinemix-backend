package pl.kul.cinemix.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.kul.cinemix.models.Row;
import pl.kul.cinemix.models.Seat;
import pl.kul.cinemix.repository.RowRepository;

import java.util.Collection;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RowService {

    private final RowRepository rowRepository;

    public void addRow(Row row){
        rowRepository.save(row);
    }

    public Optional<Row> getRow(Long id){
        return rowRepository.findById(id);
    }

    public void deleteRow(Long id ){
        rowRepository.deleteById(id);
    }


    public void getAllRows() {
        rowRepository.findAll();
    }

    public void addEmptyRow(){
        rowRepository.save(new Row());
    }


}
