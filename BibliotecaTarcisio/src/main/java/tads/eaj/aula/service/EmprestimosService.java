package tads.eaj.aula.service;

import org.springframework.stereotype.Service;
import tads.eaj.aula.model.Emprestimos;
import tads.eaj.aula.repository.EmprestimosRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EmprestimosService {
    private EmprestimosRepository repository;

    public EmprestimosService(EmprestimosRepository repository) {
        this.repository = repository;
    }

    public Emprestimos insert(Emprestimos em){
        return repository.save(em);
    }

    public Emprestimos update(Emprestimos em){
        return repository.save(em);
    }

    public void delete(Emprestimos em){
        repository.deleteById(em.getId());
    }

    public Emprestimos getOne(Long id){
        return repository.findById(id).orElse(null);
    }

    public Emprestimos saveAndFlush(Emprestimos em){return repository.saveAndFlush(em);}

    public Optional<Emprestimos> findById(Long id){return repository.findById(id);}

    public List<Emprestimos> getAll(){return repository.findAll();}
}
