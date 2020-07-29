package tads.eaj.aula.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tads.eaj.aula.model.Enderecos;
import tads.eaj.aula.service.EnderecosService;


import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@RestController
@RequestMapping("/enderecos")
public class EnderecosController {
    private EnderecosService service;

    @Autowired
    public void setService(EnderecosService service) {
        this.service = service;
    }

    @PostMapping
    public Enderecos insert(@RequestBody Enderecos e){
        return service.insert(e);
    }

    @GetMapping
    public List<Enderecos> listAll(){
        return service.getAll();
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<Enderecos> getOne(@PathVariable Long id){
        Optional<Enderecos> enderecosOptional = service.findById(id);
        if(enderecosOptional.isEmpty()){
            return ResponseEntity.notFound().build();
        }else{

            Enderecos enderecos = enderecosOptional.get();
            //Esse endereco
            enderecos.add(linkTo(EnderecosController.class).slash(id).withSelfRel());
            //Tds enderecos
            enderecos.add(linkTo(EnderecosController.class).withRel("all-enderecos"));

            return ResponseEntity.ok().body(enderecos);
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
    public ResponseEntity<Enderecos> update(@PathVariable Long id, @RequestBody Enderecos e){
        return service
                .findById(id)
                .map(record ->{
                    service.saveAndFlush(e);
                    return ResponseEntity.ok().body(e);
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
