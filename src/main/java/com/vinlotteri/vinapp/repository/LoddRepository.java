package com.vinlotteri.vinapp.repository;

import com.vinlotteri.vinapp.domain.Lodd;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LoddRepository extends JpaRepository<Lodd, Integer> {
    Lodd findByNummer(Integer nummer);


    @Query(value = "SELECT * FROM lodd WHERE bruker_navn IS NOT NULL ORDER BY RAND() LIMIT :antallPremier", nativeQuery = true)
    List<Lodd> trekkVinnere(@Param("antallPremier") int antallPremier);
}
