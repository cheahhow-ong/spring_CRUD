package com.javatutorial.mission2;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class GamesService {
    private List<Game> gameList = new ArrayList<>(Arrays.asList(
            new Game("L4D", "ps4", "horror game"),
            new Game("pokemon", "nintendo switch", "RPG"),
            new Game("PUBG", "pc", "shooting game")
    ));

    public List<Game> getAllGameList() {
        return gameList;
    }

    public Game getGame(String name) {
        return gameList.stream().filter(game -> game.getName().equals(name)).findFirst().get();
    }

    public void addGame(Game game) {
        gameList.add(game);
    }

    public void updateGame(Game game, String name) {
        int counter = 0;
        for (Game game1: gameList) {
            if (game1.getName().equals(name)) {
                gameList.set(counter, game);
            }
            counter++;
        }
    }

    public void deleteGame(String name) {
        gameList.removeIf(game -> game.getName().equals(name));
    }
}
