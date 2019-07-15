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
    @GetMapping(value = "/names/allCountries")
    public ResponseEntity<?> getAllCountries()
    {
        CountriesApplication.ourCountryList.countryList.sort((c1, c2) -> c1.getCname().compareToIgnoreCase(c2.getCname()));
        return new ResponseEntity<>(CountriesApplication.ourCountryList.countryList, HttpStatus.OK);
    }

    @GetMapping(value = "/names/start/{letter}")
    public ResponseEntity<?> getStartCountries()
    {
        CountriesApplication.ourCountryList.countryList
        return new ResponseEntity<>(CountriesApplication.ourCountryList.countryList, HttpStatus.OK);
    }

}
