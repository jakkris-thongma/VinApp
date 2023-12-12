package com.vinlotteri.vinapp.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Bruker {
    @Id
    String navn;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "bruker_navn")
    private Set<Lodd> lodd;
}
