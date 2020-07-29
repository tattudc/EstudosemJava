package tads.eaj.aula.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tads.eaj.aula.model.Usuarios;
import tads.eaj.aula.repository.UsuariosRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UsuariosService {
    private UsuariosRepository repository;

    public UsuariosService(UsuariosRepository repository) {
        this.repository = repository;
    }

    public Usuarios insert(Usuarios u){
        return repository.save(u);
    }
    
    public Usuarios update(Usuarios u){
        return repository.save(u);
    }

    public void delete(Usuarios u){
        repository.deleteById(u.getId());
    }

    public Usuarios getOne(Long id){
        return repository.findById(id).orElse(null);
    }

    public Usuarios saveAndFlush(Usuarios u){return repository.saveAndFlush(u);}

    public Optional<Usuarios> findById(Long id){return repository.findById(id);}

    public List<Usuarios> getAll(){return repository.findAll();}
}
