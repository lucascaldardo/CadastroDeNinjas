package dev.java.x.CadastroDeNinjas.Missoes;

import dev.java.x.CadastroDeNinjas.Ninjas.NinjaModel;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MissoesService {

    private MissoesRepository missoesRepository;
    private MissoesMapper missoesMapper;

    public MissoesService(MissoesRepository missoesRepository, MissoesMapper missoesMapper) {
        this.missoesRepository = missoesRepository;
        this.missoesMapper = missoesMapper;
    }

    public MissoesDTO criarMissoes(MissoesDTO missoesDTO){
        MissoesModel missao = missoesMapper.map(missoesDTO);
        missao = missoesRepository.save(missao);
        return missoesMapper.map(missao);
    }

    public List<MissoesDTO> listarMissoes(){
        List<MissoesModel> missoes = missoesRepository.findAll();
        return missoes.stream()
                .map(missoesMapper::map)
                .collect(Collectors.toList());
    }

    public MissoesDTO listarMissoesPorId(Long id){
        Optional<MissoesModel> missoesPorId = missoesRepository.findById(id);
        return missoesPorId.map(missoesMapper::map).orElse(null);
    }

    public MissoesDTO alterarMissaoPorId(@PathVariable Long id, MissoesDTO missoesDTO){
       Optional<MissoesModel> missaoExistente = missoesRepository.findById(id);
       if (missaoExistente.isPresent()){
           MissoesModel missaoAtualizada = missoesMapper.map(missoesDTO);
           missaoAtualizada.setId(id);
           MissoesModel missaoSalva = missoesRepository.save(missaoAtualizada);
           return missoesMapper.map(missaoSalva);
       }
        return null;
    }

    public void deletarMissaoPorId(Long id){
        missoesRepository.deleteById(id);
    }


}
