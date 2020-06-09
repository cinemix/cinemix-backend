package pl.kul.cinemix.controllers;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.kul.cinemix.models.Hall;
import pl.kul.cinemix.models.Row;
import pl.kul.cinemix.service.RowService;

import java.util.Collection;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/rows")
@RequiredArgsConstructor
public class RowController {

    RowService rowService;

    @GetMapping("/{id}")
    public Optional<Row> getHall(@PathVariable Long id){
        return rowService.getRow(id);
    }

    @PostMapping("/add")
    public void addHall(@RequestBody Row row){
        rowService.addRow(row);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteHall(@PathVariable Long id){
        rowService.deleteRow(id);
    }

    @GetMapping("/all")
    public void allRows(){
        rowService.getAllRows();
    }
}
