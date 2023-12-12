package com.vinlotteri.vinapp.dto;

import com.vinlotteri.vinapp.domain.Bruker;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class LoddKjøpDTO {
    String brukernavn;
    List<Integer> ønskedeLodd;
}
