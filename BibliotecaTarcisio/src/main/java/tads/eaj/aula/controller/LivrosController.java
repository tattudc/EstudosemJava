package tads.eaj.aula.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tads.eaj.aula.model.Emprestimos;
import tads.eaj.aula.model.Livros;
import tads.eaj.aula.service.LivrosService;

import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@RestController
@RequestMapping("/livros")
public class LivrosController {
    private LivrosService service;

    @Autowired
    public void setService(LivrosService service) {
        this.service = service;
    }

    @PostMapping
    public Livros insert(@RequestBody Livros l){
        return service.insert(l);
    }

    @GetMapping
    public List<Livros> listAll(){
        return service.getAll();
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<Livros> getOne(@PathVariable Long id){

        Optional<Livros> livrosOptional = service.findById(id);
        if(livrosOptional.isEmpty()){
            return ResponseEntity.notFound().build();
        }else{
            Livros livros = livrosOptional.get();
            //livro atual
            livros.add(linkTo(LivrosController.class).slash(id).withSelfRel());
            //Todos livros
            livros.add(linkTo(LivrosController.class).withRel("all-Livros"));

            return ResponseEntity.ok().body(livros);
        }

        /*return service
                .findById(id)
                .map(record ->{
                    return ResponseEntity.ok().body(record);
                }).orElse(ResponseEntity.notFound().build());
        */
        /*Optional<Usuarios> usuariosOptional = service.findById(id);
        if(usuariosOptional.isPresent()){
            return ResponseEntity.ok().body(usuariosOptional.get());
        }else{
            return ResponseEntity.notFound().build();
        }*/
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Livros> update(@PathVariable Long id, @RequestBody Livros l){
        return service
                .findById(id)
                .map(record ->{
                    service.saveAndFlush(l);
                    return ResponseEntity.ok().body(l);
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        return service
                .findById(id)
                .map(record ->{
                    service.delete(record);
                    return ResponseEntity.status(202).build();
                }).orElse(ResponseEntity.notFound().build());
    }
}
