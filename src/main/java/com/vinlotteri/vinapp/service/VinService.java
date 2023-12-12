package com.vinlotteri.vinapp.service;

import com.vinlotteri.vinapp.domain.Vin;
import com.vinlotteri.vinapp.repository.VinRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class VinService {
    private final VinRepository vinRepository;

    public List<Vin> hentAlleVin() {
        return vinRepository.findAll();
    }

    public Vin lagreVin(Vin vin) {
        return vinRepository.save(vin);
    }

    public List<Vin> hentPremierSortert() {
        return vinRepository.findAllByOrderByPrisAsc();
    }
}
