package edu.scs.vds.controller.api;

import edu.scs.vds.model.Booth;
import edu.scs.vds.service.BoothService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@Api(value = "API Controller", produces = MediaType.APPLICATION_JSON_VALUE, tags = {"Booths"}, description = "API List")
public class BoothApiController {

    @Autowired
    BoothService boothService;

    @GetMapping("/booths")
    public List<Booth> list() {
        return boothService.listAll();
    }

    @GetMapping("/booth/{id}")
    public ResponseEntity<Booth> get(@PathVariable Integer id) {
        try {
            Booth booth = boothService.get(id);
            return new ResponseEntity<Booth>(booth, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Booth>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/booth")
    public Booth addBooth(@RequestBody Booth booth){
        boothService.save(booth);
        return booth;
    }

    @PutMapping("/booth/{id}")
    public ResponseEntity<?> update(@RequestBody Booth booth, @PathVariable Integer id) {
        try {
            Booth existingBooth = boothService.get(id);
            boothService.save(booth);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/booths/{id}")
    public void delete(@PathVariable Integer id) {
        boothService.delete(id);
    }

}
