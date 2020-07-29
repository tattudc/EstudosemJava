package tads.eaj.aula.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tads.eaj.aula.model.Emprestimos;
import tads.eaj.aula.model.Livros;
import tads.eaj.aula.model.Usuarios;
import tads.eaj.aula.service.EmprestimosService;

import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@RestController
@RequestMapping("/emprestimos")
public class EmprestimosController {
    private EmprestimosService service;

    @Autowired
    public void setService(EmprestimosService service) {
        this.service = service;
    }

    @PostMapping
    public Emprestimos insert(@RequestBody Emprestimos em){
        return service.insert(em);
    }

    @GetMapping
    public List<Emprestimos> listAll(){
        return service.getAll();
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<Emprestimos> getOne(@PathVariable Long id){

        Optional<Emprestimos> emprestimosOptional = service.findById(id);
        if(emprestimosOptional.isEmpty()){
            return ResponseEntity.notFound().build();
        }else{
            Emprestimos emprestimos = emprestimosOptional.get();
            //Mim msm
            emprestimos.add(linkTo(EmprestimosController.class).slash(id).withSelfRel());
            //Todos
            emprestimos.add(linkTo(EmprestimosController.class).withRel("all-emprestimos"));

            return ResponseEntity.ok().body(emprestimos);
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
    public ResponseEntity<Emprestimos> update(@PathVariable Long id, @RequestBody Emprestimos em){
        return service
                .findById(id)
                .map(record ->{
                    service.saveAndFlush(em);
                    return ResponseEntity.ok().body(em);
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
