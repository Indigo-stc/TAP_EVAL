package com.ista.music.controller;

import com.ista.music.model.PlayList;
import com.ista.music.service.PlayListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PlayListCtrl {

    @Autowired
    PlayListService service;

    @PostMapping("/crear")
    public ResponseEntity<PlayList> crear(@RequestBody PlayList c){
        return new ResponseEntity<>(service.save(c), HttpStatus.CREATED);
    }
    @GetMapping("/listar")
    public ResponseEntity<List<PlayList>> obtenerLista() {
        return new ResponseEntity<>(service.findByAll(), HttpStatus.OK);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<PlayList> eliminar(@PathVariable Integer id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<PlayList> actualizarUsuario(@PathVariable Integer id, @RequestBody PlayList c) {
        PlayList current = service.findById(id);
        if (current == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            try {
                current.setNombre(c.getNombre());
                current.setDescription(c.getDescription());
                return new ResponseEntity<>(service.save(current), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        }

    }
}
