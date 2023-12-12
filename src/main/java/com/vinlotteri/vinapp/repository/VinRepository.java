package com.vinlotteri.vinapp.repository;

import com.vinlotteri.vinapp.domain.Vin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VinRepository extends JpaRepository<Vin, Long> {
    List<Vin> findAllByOrderByPrisAsc();
}
