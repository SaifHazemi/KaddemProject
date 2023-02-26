package tn.inetum.blm.kaddemproject.Services.Equipe;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.inetum.blm.kaddemproject.Entities.Equipe;
import tn.inetum.blm.kaddemproject.Repository.EquipeRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EquipeService implements IEquipeService {


    private final EquipeRepository equipeRepository;
    @Override
    public List<Equipe> retrieveAllEquipes() {
        return (List<Equipe>) equipeRepository.findAll() ;
    }
    @Override
    public Equipe addEquipe(Equipe e) {
        return equipeRepository.save(e);
    }
    @Override
    public Equipe updateEquipe(Equipe e) {
        return equipeRepository.save(e);
    }
    @Override
    public Equipe retrieveEquipe(Integer idEquipe) {
        return equipeRepository.findById(idEquipe).orElse(null);
    }

}
