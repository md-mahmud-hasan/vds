package edu.scs.vds.controller.api;

import edu.scs.vds.model.Vaccine;
import edu.scs.vds.service.VaccineService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@Api(value = "API Controller", produces = MediaType.APPLICATION_JSON_VALUE, tags = {"Vaccine management"}, description = "API List")
public class VaccineApiController {

    @Autowired
    VaccineService vaccineService;

    @GetMapping("/vaccines")
    public List<Vaccine> list() {
        return vaccineService.listAll();
    }

    @GetMapping("/vaccine/{id}")
    public ResponseEntity<Vaccine> get(@PathVariable Integer id) {
        try {
            Vaccine vaccine = vaccineService.get(id);
            return new ResponseEntity<Vaccine>(vaccine, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Vaccine>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/vaccine")
    public Vaccine addVaccine(@RequestBody Vaccine vaccine){
        vaccineService.save(vaccine);
        return vaccine;
    }

    @PutMapping("/vaccine/{id}")
    public ResponseEntity<?> update(@RequestBody Vaccine vaccine, @PathVariable Integer id) {
        try {
            Vaccine existingVaccine = vaccineService.get(id);
            vaccineService.save(vaccine);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/vaccines/{id}")
    public void delete(@PathVariable Integer id) {
        vaccineService.delete(id);
    }

}
