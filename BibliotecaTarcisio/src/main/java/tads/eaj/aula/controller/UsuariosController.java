package tads.eaj.aula.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tads.eaj.aula.model.Emprestimos;
import tads.eaj.aula.model.Enderecos;
import tads.eaj.aula.model.Usuarios;
import tads.eaj.aula.service.UsuariosService;

import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@RestController
@RequestMapping("/usuarios")
public class UsuariosController {
    private UsuariosService service;

    @Autowired
    public void setService(UsuariosService service) {
        this.service = service;
    }

    @PostMapping
    public Usuarios insert(@RequestBody Usuarios u){
        return service.insert(u);
    }

    @GetMapping
    public List<Usuarios> listAll(){
        return service.getAll();
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<Usuarios> getOne(@PathVariable Long id){
        Optional<Usuarios> usuariosOptional = service.findById(id);
        if(usuariosOptional.isEmpty()){
            return ResponseEntity.notFound().build();
        }else {
            Usuarios usuarios = usuariosOptional.get();
            //Mim msm
            usuarios.add(linkTo(UsuariosController.class).slash(id).withSelfRel());
            //Todos
            usuarios.add(linkTo(UsuariosController.class).withRel("all-usuarios"));

            Enderecos enderecos = usuarios.getEnderecos();
            //Esse endereco
            enderecos.add(linkTo(EnderecosController.class).slash(id).withSelfRel());
            //Tds enderecos
            enderecos.add(linkTo(EnderecosController.class).withRel("all-enderecos"));

            return ResponseEntity.ok().body(usuarios);
        }
        /*
        return service
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
    public ResponseEntity<Usuarios> update(@PathVariable Long id, @RequestBody Usuarios u){
        return service
                .findById(id)
                .map(record ->{
                    service.saveAndFlush(u);
                    return ResponseEntity.ok().body(u);
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
