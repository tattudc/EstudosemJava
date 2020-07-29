package tads.eaj.aula.service;

import org.springframework.stereotype.Service;
import tads.eaj.aula.model.Enderecos;
import tads.eaj.aula.model.Usuarios;
import tads.eaj.aula.repository.EnderecosRepository;
import tads.eaj.aula.repository.UsuariosRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EnderecosService {
    private EnderecosRepository repository;

    public EnderecosService(EnderecosRepository repository) {
        this.repository = repository;
    }

    public Enderecos insert(Enderecos e){
        return repository.save(e);
    }

    public Enderecos update(Enderecos e){
        return repository.save(e);
    }

    public void delete(Enderecos e){
        repository.deleteById(e.getId());
    }

    public Enderecos getOne(Long id){
        return repository.findById(id).orElse(null);
    }

    public Enderecos saveAndFlush(Enderecos e){return repository.saveAndFlush(e);}

    public Optional<Enderecos> findById(Long id){return repository.findById(id);}

    public List<Enderecos> getAll(){return repository.findAll();}
}
