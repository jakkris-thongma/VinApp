package com.vinlotteri.vinapp.service;

import com.vinlotteri.vinapp.domain.Bruker;
import com.vinlotteri.vinapp.repository.BrukerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BrukerService {
    private final BrukerRepository brukerRepository;

    public void saveBruker(Bruker bruker) {
        brukerRepository.save(bruker);
    }

    // Legge til feilhåndtering, ifPresent()
    public Bruker getBruker(String brukernavn) {
        return brukerRepository.findById(brukernavn).get();
    }

    public List<Bruker> getBrukere() {
        return brukerRepository.findAll();
    }
}
