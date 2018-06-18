package warsztaty.java.ailleronLab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import warsztaty.java.ailleronLab.model.RestResponse;
import warsztaty.java.ailleronLab.services.CountryService;

@RestController
public class CountryController {

    @Autowired
    CountryService countryService;

    @GetMapping("/country/{code}")
    public RestResponse getCountryCode(@PathVariable() String code){
        return countryService.getCountryFromRestApi(code);
    }
}
