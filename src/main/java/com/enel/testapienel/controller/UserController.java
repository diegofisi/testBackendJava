package com.enel.testapienel.controller;

import com.enel.testapienel.dto.UserDTO;
import com.enel.testapienel.exception.ModeloNotFoundException;
import com.enel.testapienel.model.Useru;
import com.enel.testapienel.service.IUserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService service;

    @Autowired
    private ModelMapper mapper;

    @GetMapping
    public ResponseEntity<List<UserDTO>> listar() throws Exception{
        List<UserDTO> lista = service.listar().stream().map(p -> mapper.map(p, UserDTO.class)).collect(Collectors.toList());
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> listarPorId(@PathVariable("id") Integer id) throws Exception{
        UserDTO dtoResponse;
        Useru obj = service.listarPorId(id);
        if(obj == null) {
            throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
        }else {
            dtoResponse = mapper.map(obj, UserDTO.class);
        }
        return new ResponseEntity<>(dtoResponse, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> registrar(@Valid @RequestBody UserDTO dtoRequest) throws Exception {
        Useru p = mapper.map(dtoRequest, Useru.class);
        Useru obj = service.registrar(p);
        UserDTO dtoResponse = mapper.map(obj, UserDTO.class);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dtoResponse.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping
    public ResponseEntity<UserDTO> modificar(@Valid @RequestBody UserDTO dtoRequest) throws Exception {
        Useru pac = service.listarPorId(dtoRequest.getId());

        if(pac == null) {
            throw new ModeloNotFoundException("ID NO ENCONTRADO " + dtoRequest.getId());
        }

        Useru p = mapper.map(dtoRequest, Useru.class);
        Useru obj = service.modificar(p);
        UserDTO dtoResponse = mapper.map(obj, UserDTO.class);

        return new ResponseEntity<>(dtoResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable("id") Integer id) throws Exception {
        Useru pac = service.listarPorId(id);

        if(pac == null) {
            throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
        }

        service.eliminar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
