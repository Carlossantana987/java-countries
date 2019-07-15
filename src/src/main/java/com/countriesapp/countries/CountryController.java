package com.countriesapp.countries;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // Managed by spring boot - mappings of end points - annotation
@RequestMapping("/data") // all endpoints start with  /data/
public class CountryController
{

    // localhost:8080/data/allCountries
    @GetMapping(value = "/allCountries")
    public ResponseEntity<?> getAllCountries()
    {
        return new ResponseEntity<>(CountriesApplication.ourCountryList.countryList, HttpStatus.OK);
    }

}
