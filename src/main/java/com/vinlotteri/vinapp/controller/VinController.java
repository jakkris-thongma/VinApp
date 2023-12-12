package com.vinlotteri.vinapp.controller;

import com.vinlotteri.vinapp.domain.Vin;
import com.vinlotteri.vinapp.service.VinService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("api/vin")
public class VinController {
    private final VinService vinService;

    @PostMapping
    public Vin leggTilVin(@RequestBody Vin vin) {
        return vinService.lagreVin(vin);
    }

    @GetMapping
    public List<Vin> hentAlleVin() {
        return vinService.hentAlleVin();
    }

}
