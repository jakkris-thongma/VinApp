package com.vinlotteri.vinapp.repository;

import com.vinlotteri.vinapp.domain.Bruker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrukerRepository extends JpaRepository<Bruker, String> {
}
