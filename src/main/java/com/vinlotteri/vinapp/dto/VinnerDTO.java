package com.vinlotteri.vinapp.dto;

import com.vinlotteri.vinapp.domain.Lodd;
import com.vinlotteri.vinapp.domain.Vin;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class VinnerDTO {
    public Vin vin;
    public Lodd lodd;
}
