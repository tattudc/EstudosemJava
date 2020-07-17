package tads.eaj.aula;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivrosService {
    LivrosRepository livrosRepository;

    @Autowired
    public void setLivrosRepository(LivrosRepository livrosRepository) {
        this.livrosRepository = livrosRepository;
    }

    public List<Livros> findAll(){
        return livrosRepository.findAll();
    }

    public void add(Livros livros){
        livrosRepository.save(livros);
    }

    public Livros get(Long id){
        return livrosRepository.getOne(id);
    }

    public void delete(Long id){
        livrosRepository.deleteById(id);
    }
}
