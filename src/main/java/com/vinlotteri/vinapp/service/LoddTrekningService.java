package com.vinlotteri.vinapp.service;

import com.vinlotteri.vinapp.domain.Bruker;
import com.vinlotteri.vinapp.domain.Lodd;
import com.vinlotteri.vinapp.domain.Vin;
import com.vinlotteri.vinapp.dto.LoddKjøpDTO;
import com.vinlotteri.vinapp.dto.VinnerDTO;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class LoddTrekningService {
    private VinService vinService;
    private LoddService loddService;
    private BrukerService brukerService;

    public List<VinnerDTO> gjennomførTrekning() {
        List<Vin> allePremier = vinService.hentPremierSortert();
        List<Lodd> vinnere = loddService.trekkVinnere(allePremier.size());

        List<VinnerDTO> vinnerDTOList = new ArrayList<>();

        int antallPremierTilDistribusjon = Math.min(allePremier.size(), vinnere.size());


        for (int i = 0; i < antallPremierTilDistribusjon; i++) {
            VinnerDTO dto = new VinnerDTO(allePremier.get(i), vinnere.get(i));
            vinnerDTOList.add(dto);
        }

        return vinnerDTOList;
    }
    //Feilhåndtering, hvor bruker ikke eksisterer i database. Kaste exception, try catch i controller. Returnere feilkode med melding.

   @Transactional
   public String kjøpLodd(LoddKjøpDTO loddKjøpDTO) {
       List<Lodd> tilgjengeligeLodd = loddService.tilgjengeligeLodd(loddKjøpDTO.getØnskedeLodd());
       Bruker bruker = brukerService.getBruker(loddKjøpDTO.getBrukernavn());

       if(tilgjengeligeLodd.size() != 0) {
           Set<Lodd> brukerLodd = bruker.getLodd();
           if (brukerLodd == null) {
               brukerLodd = new HashSet<>();
               bruker.setLodd(brukerLodd);
           }

           brukerLodd.addAll(tilgjengeligeLodd);
       }


       StringBuilder melding = new StringBuilder();
       melding.append("For bruker " + bruker.getNavn() + " ble disse loddene kjøpt: ");

       melding.append(tilgjengeligeLodd.stream()
               .map(lodd -> lodd.getNummer().toString())
               .collect(Collectors.joining(", ")));

       if(tilgjengeligeLodd.size() != loddKjøpDTO.getØnskedeLodd().size()) {
           List<Lodd> loddSolgtTidligere = loddService.solgteLodd(loddKjøpDTO.getØnskedeLodd());
           melding.append("\n").append("Disse loddene er utsolgt: ");

           melding.append(loddSolgtTidligere.stream()
                   .map(lodd -> lodd.getNummer().toString())
                   .collect(Collectors.joining(", ")));
       }

       return melding.toString();
   }


}
