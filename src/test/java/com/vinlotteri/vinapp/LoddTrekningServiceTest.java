package com.vinlotteri.vinapp;

import com.vinlotteri.vinapp.domain.Bruker;
import com.vinlotteri.vinapp.domain.Lodd;
import com.vinlotteri.vinapp.domain.Vin;
import com.vinlotteri.vinapp.dto.VinnerDTO;
import com.vinlotteri.vinapp.service.BrukerService;
import com.vinlotteri.vinapp.service.LoddService;
import com.vinlotteri.vinapp.service.LoddTrekningService;
import com.vinlotteri.vinapp.service.VinService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;

class LoddTrekningServiceTest {
    private final LoddService loddService = mock(LoddService.class);
    private final VinService vinService = mock(VinService.class);
    private final BrukerService brukerService = mock(BrukerService.class);
    private final LoddTrekningService loddTrekningService = new LoddTrekningService(vinService, loddService, brukerService);

    @Test
    void testGjennomførTrekningFærreLoddEnnPremier() {
        List<Vin> mockPremier = Arrays.asList(new Vin(1L, "Vin 1", "beskrivelse 1", 99), new Vin(2L, "Vin 2", "beskrivelse 2", 200), new Vin(3L, "Vin 3", "beskrivelse 3", 500));
        List<Lodd> mockVinnere = Arrays.asList(new Lodd(1, new Bruker("Are", null)), new Lodd(1, new Bruker("Peter", null)));

        Mockito.when(vinService.hentPremierSortert()).thenReturn(mockPremier);
        Mockito.when(loddService.trekkVinnere(anyInt())).thenReturn(mockVinnere);


        List<VinnerDTO> resultater = loddTrekningService.gjennomførTrekning();


        assertEquals(2, resultater.size());
        assertEquals(mockPremier.get(0), resultater.get(0).getVin());
        assertEquals(mockVinnere.get(0), resultater.get(0).getLodd());
        assertEquals(mockPremier.get(1), resultater.get(1).getVin());
        assertEquals(mockVinnere.get(1), resultater.get(1).getLodd());
    }

    @Test
    void testGjennomførTrekningFlereLoddEnnPremier() {
        List<Vin> mockPremier = Arrays.asList(new Vin(1L, "Vin 1", "beskrivelse 1", 99));
        List<Lodd> mockVinnere = Arrays.asList(new Lodd(1, new Bruker("Are", null)), new Lodd(1, new Bruker("Peter", null)));

        Mockito.when(vinService.hentPremierSortert()).thenReturn(mockPremier);
        Mockito.when(loddService.trekkVinnere(anyInt())).thenReturn(mockVinnere);


        List<VinnerDTO> resultater = loddTrekningService.gjennomførTrekning();


        assertEquals(1, resultater.size());
        assertEquals(mockPremier.get(0), resultater.get(0).getVin());
        assertEquals(mockVinnere.get(0), resultater.get(0).getLodd());

    }

    /*

     */
}
