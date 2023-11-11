package com.agendamentos.FelipeTorres.Resources;

import com.agendamentos.FelipeTorres.Models.Laboratory;
import com.agendamentos.FelipeTorres.Services.LaboratoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/laboratory")
public class LaboratoryResource {

    @Autowired
    private LaboratoryService laboratoryService;

    @GetMapping("")
    public ResponseEntity<List<Laboratory>> listAll()
    {
        return new ResponseEntity<>(laboratoryService.listAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Laboratory> getLaboratory(@PathVariable("id") int id)
    {
        Optional<Laboratory> optionalLaboratory = Optional.ofNullable(laboratoryService.getLaboratory(id));

        if (optionalLaboratory.isPresent()) {

            return new ResponseEntity<>(optionalLaboratory.get(), HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Laboratory> deleteLaboratory(@PathVariable("id") int id)
    {
        Optional<Laboratory> optionalLaboratory = Optional.ofNullable(laboratoryService.getLaboratory(id));

        if (optionalLaboratory.isPresent()) {

            laboratoryService.deleteLaboratory(optionalLaboratory.get());

            return new ResponseEntity<>(null, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/save")
    public ResponseEntity<Laboratory> saveLaboratory(@RequestBody Laboratory laboratory)
    {
        laboratoryService.saveLaboratory(laboratory);

        return new ResponseEntity<>(laboratory, HttpStatus.OK);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Laboratory> updateLaboratory(@PathVariable("id") int id, @RequestBody Laboratory laboratory)
    {
        Optional<Laboratory> optionalLaboratory = Optional.ofNullable(laboratoryService.getLaboratory(id));

        if (optionalLaboratory.isPresent()) {

            laboratory.setId(id);

            laboratoryService.saveLaboratory(optionalLaboratory.get());

            return new ResponseEntity<>(null, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}

