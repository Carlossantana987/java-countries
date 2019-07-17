package com.countriesapp.countries;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;

import static com.countriesapp.countries.CountriesApplication.ourCountryList;

@RestController // Managed by spring boot - mappings of end points - annotation
@RequestMapping("/data") // all endpoints start with  /data/
public class CountryController
{

    //localhost:8080/data/names/allCountries
    @GetMapping(value = "/names/allCountries")
    public ResponseEntity<?> getAllCountries()
    {
        ourCountryList.countryList.sort((c1, c2) -> c1.getCname().compareToIgnoreCase(c2.getCname()));
        return new ResponseEntity<>(ourCountryList.countryList, HttpStatus.OK);
    }

    //localhost:8080/data/names/start/{letter}
    @GetMapping(value = "/names/start/{letter}")
    public ResponseEntity<?> getStartCountries(@PathVariable char letter)
    {
        ArrayList<Country> rtnCountries = ourCountryList.
                findCountries(e -> e.getCname().toUpperCase().charAt(0) == Character.toUpperCase(letter));
        return new ResponseEntity<>(rtnCountries, HttpStatus.OK);
    }

    //localhost:8080/data/names/size/{number}
    @GetMapping(value = "/names/size/{number}")
    public ResponseEntity<?> getStartCountriesNum(@PathVariable int number)
    {
        ArrayList<Country> rtnCountries = ourCountryList.
                findCountries(e -> e.getCname().length() >= number);
        return new ResponseEntity<>(rtnCountries, HttpStatus.OK);
    }

    //localhost:8080/data/size/{people}
    @GetMapping(value = "/size/{people}")
    public ResponseEntity<?> getPopulation(@PathVariable int people)
    {
        ArrayList<Country> rtnCountries = ourCountryList.
                findCountries(e -> e.getPopulation() >= people);
        return new ResponseEntity<>(rtnCountries, HttpStatus.OK);
    }

    //localhost:8080/data/population/min
    @GetMapping(value = "/population/min")
    public ResponseEntity<?> getMinPopulation()
    {
        Collections.sort(ourCountryList.countryList, (c1, c2) -> c1.getPopulation() - c2.getPopulation());
        return new ResponseEntity<>(ourCountryList.countryList, HttpStatus.OK);
    }

    //localhost:8080/data/population/min
    @GetMapping(value = "/population/max")
    public ResponseEntity<?> getMaxPopulation()
    {
        Collections.sort(ourCountryList.countryList, (c1, c2) -> c2.getPopulation() - c1.getPopulation());
        return new ResponseEntity<>(ourCountryList.countryList, HttpStatus.OK);
    }

}
