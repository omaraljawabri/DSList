package com.devsuperior.dslist.dto;

import com.devsuperior.dslist.entities.GameList;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class GameListDTO {

    private Long id;
    private String name;

    public GameListDTO(GameList list){
        this.id = list.getId();
        this.name = list.getName();
    }
}
