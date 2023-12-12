package com.vinlotteri.vinapp.service;

import com.vinlotteri.vinapp.domain.Lodd;
import com.vinlotteri.vinapp.repository.LoddRepository;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class LoddService {
    private final LoddRepository loddRepository;

    //Legg lodd inn i H2 ved oppstart
    @PostConstruct
    public void initLodd() {
        for (int i = 1; i <= 100; i++) {
            loddRepository.save(new Lodd(i, null));
        }
    }

    public List<Lodd> tilgjengeligeLodd(List<Integer> loddNumre) {
        return loddNumre.stream()
                .map(loddRepository::findByNummer)
                .filter(lodd -> lodd.getBruker() == null)
                .toList();
    }

    public List<Lodd> solgteLodd(List<Integer> loddNumre) {
        return loddNumre.stream()
                .map(loddRepository::findByNummer)
                .filter(lodd -> lodd !=  null && lodd.getBruker() != null)
                .toList();
    }

    public List<Lodd> trekkVinnere(int antallPremier) {
        return loddRepository.trekkVinnere(antallPremier);
    }
}
