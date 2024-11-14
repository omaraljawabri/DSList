package com.devsuperior.dslist.controllers;

import com.devsuperior.dslist.dto.GameListDTO;
import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.dto.ReplacementDTO;
import com.devsuperior.dslist.services.GameListService;
import com.devsuperior.dslist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lists")
public class GameListController {

    @Autowired
    private GameListService gameListService;

    @Autowired
    private GameService gameService;

    @GetMapping
    public ResponseEntity<List<GameListDTO>> findAll(){
        return ResponseEntity.ok().body(gameListService.findAll());
    }

    @GetMapping("/{listId}/games")
    public ResponseEntity<List<GameMinDTO>> findByList(@PathVariable Long listId){
        return ResponseEntity.ok().body(gameService.findByList(listId));
    }

    @PostMapping("/{listId}/replacement")
    public ResponseEntity<Void> move(@PathVariable Long listId, @RequestBody ReplacementDTO replacementDTO){
        gameListService.move(listId, replacementDTO.getSourceIndex(), replacementDTO.getDestinationIndex());
        return ResponseEntity.ok().build();
    }
}
