package com.ista.music.controller;

import com.ista.music.model.Song;
import com.ista.music.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/song/")
public class SongCtrl {

    @Autowired
    SongService service;

    @PostMapping("/crear")
    public ResponseEntity<Song> crear(@RequestBody Song c){
        return new ResponseEntity<>(service.save(c), HttpStatus.CREATED);
    }
    @GetMapping("/listar")
    public ResponseEntity<List<Song>> obtenerLista() {
        return new ResponseEntity<>(service.findByAll(), HttpStatus.OK);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Song> eliminar(@PathVariable Integer id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Song> actualizarUsuario(@PathVariable Integer id, @RequestBody Song c) {
        Song current = service.findById(id);
        if (current == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            try {
                current.setTitle(c.getTitle());
                current.setArtist(c.getArtist());
                current.setAlbum(c.getAlbum());
                current.setYear(c.getYear());
                return new ResponseEntity<>(service.save(current), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        }

    }

}
