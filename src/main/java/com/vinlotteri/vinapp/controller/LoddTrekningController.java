package com.vinlotteri.vinapp.controller;

import com.vinlotteri.vinapp.dto.LoddKjøpDTO;
import com.vinlotteri.vinapp.dto.VinnerDTO;
import com.vinlotteri.vinapp.service.LoddTrekningService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("api/loddtrekning")
public class LoddTrekningController {
    private final LoddTrekningService loddTrekningService;

    @PostMapping("/kjøp")
    public ResponseEntity<String> kjopLodd(@RequestBody LoddKjøpDTO loddKjøpDTO) {
        return ResponseEntity.ok(loddTrekningService.kjøpLodd(loddKjøpDTO));
    }

    @PostMapping("/trekning")
    public ResponseEntity<List<VinnerDTO>> trekning() {
        return ResponseEntity.ok(loddTrekningService.gjennomførTrekning());
    }



}
