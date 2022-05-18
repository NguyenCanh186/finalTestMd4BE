package canhnguyen.testmd4.controller;

import canhnguyen.testmd4.model.City;
import canhnguyen.testmd4.model.Country;
import canhnguyen.testmd4.service.ICityService;
import canhnguyen.testmd4.service.ICountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

@Controller
@RequestMapping("/city")
@CrossOrigin("*")
public class CityController {
    @Autowired
    private ICityService cityService;

    @Autowired
    private ICountryService countryService;

    @GetMapping("/country")
    public ResponseEntity<Iterable<Country>> showAllCate(){
        return new ResponseEntity<>(countryService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/list")
    public  ResponseEntity<Iterable<City>> showAll(){
        return new ResponseEntity<>(cityService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<City> saveCity(@RequestBody City city){
        return new ResponseEntity<>(cityService.save(city), HttpStatus.CREATED);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<City> deleteCity(@PathVariable Long id) {
        Optional<City> cityOptional = cityService.findById(id);
        if (!cityOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        cityService.remove(id);
        return new ResponseEntity<>(cityOptional.get(), HttpStatus.NO_CONTENT);
    }


    @PutMapping ("/edit/{id}")
    public ResponseEntity<City> updateBook(@PathVariable Long id, @RequestBody City city){
        city.setId(id);
        return new ResponseEntity<>(cityService.save(city), HttpStatus.OK);
    }

    @GetMapping("findOne/{id}")
    public ResponseEntity<City> findOne(@PathVariable Long id){
        City city = cityService.findById(id).get();
        return new ResponseEntity<>(city,HttpStatus.OK);
    }

}
