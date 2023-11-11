package com.agendamentos.FelipeTorres.Resources;

import com.agendamentos.FelipeTorres.Models.Reserve;
import com.agendamentos.FelipeTorres.Services.LaboratoryService;
import com.agendamentos.FelipeTorres.Services.ReserveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/reserve")
public class ReserveResource {

    @Autowired
    private ReserveService reserveService;

    @GetMapping("")
    public ResponseEntity<List<Reserve>> listAll()
    {
        return new ResponseEntity<>(reserveService.listAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reserve> getReserve(@PathVariable("id") int id)
    {
        Optional<Reserve> optionalReserve = Optional.ofNullable(reserveService.getReserve(id));

        if (optionalReserve.isPresent()) {

            return new ResponseEntity<>(optionalReserve.get(), HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Reserve> deleteReserve(@PathVariable("id") int id)
    {
        Optional<Reserve> optionalReserve = Optional.ofNullable(reserveService.getReserve(id));

        if (optionalReserve.isPresent()) {

            reserveService.deleteReserve(optionalReserve.get());

            return new ResponseEntity<>(null, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/save")
    public ResponseEntity<Reserve> saveReserve(@RequestBody Reserve reserve)
    {
        reserveService.saveReserve(reserve);

        return new ResponseEntity<>(reserve, HttpStatus.OK);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Reserve> updateReserve(@PathVariable("id") int id, @RequestBody Reserve reserve)
    {
        Optional<Reserve> optionalReserve = Optional.ofNullable(reserveService.getReserve(id));

        if (optionalReserve.isPresent()) {

            reserve.setId(id);

            reserveService.saveReserve(optionalReserve.get());

            return new ResponseEntity<>(null, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
