package com.javatutorial.mission2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GameController {

    @Autowired
    private GamesService gamesService;

    @RequestMapping("/games")
    public List<Game> all_games() {
        return gamesService.getAllGameList();
    }

    @RequestMapping("/games/{name}")
    public Game getGame(@PathVariable("name") String name) {
        return gamesService.getGame(name);
    }

    @PostMapping("/games")
    public void addGame(@RequestBody Game game) {
        gamesService.addGame(game);
    }

    @PutMapping("/games/{name}")
    public void updateGame(@RequestBody Game game, @PathVariable("name") String name) {
        gamesService.updateGame(game, name);
    }

    @DeleteMapping ("/games/{name}")
    public void deleteGame(@PathVariable("name") String name) {
        gamesService.deleteGame(name);
    }
}
