package com.vinlotteri.vinapp.controller;

import com.vinlotteri.vinapp.domain.Bruker;
import com.vinlotteri.vinapp.service.BrukerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("api/bruker")
public class BrukerController {
    private final BrukerService brukerService;
    @GetMapping()
    public List<Bruker> getBrukere() {
        return brukerService.getBrukere();
    }
}
