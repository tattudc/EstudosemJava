package tads.eaj.aula.service;

import org.springframework.stereotype.Service;
import tads.eaj.aula.model.Livros;
import tads.eaj.aula.repository.LivrosRepository;

import java.util.List;
import java.util.Optional;

@Service
public class LivrosService {
    private LivrosRepository repository;

    public LivrosService(LivrosRepository repository) {
        this.repository = repository;
    }

    public Livros insert(Livros l){
        return repository.save(l);
    }

    public Livros update(Livros l){
        return repository.save(l);
    }

    public void delete(Livros l){
        repository.deleteById(l.getId());
    }

    public Livros getOne(Long id){
        return repository.findById(id).orElse(null);
    }

    public Livros saveAndFlush(Livros l){return repository.saveAndFlush(l);}

    public Optional<Livros> findById(Long id){return repository.findById(id);}

    public List<Livros> getAll(){return repository.findAll();}
}
