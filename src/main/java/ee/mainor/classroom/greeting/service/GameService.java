package ee.mainor.classroom.greeting.service;

import ee.mainor.classroom.greeting.dto.GuessResponse;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class GameService {

    private final Map<String, Game> games = new ConcurrentHashMap<>();

    public String createGame() {
        String id = UUID.randomUUID().toString();
        games.put(id, new Game());
        return id;
    }

    public GuessResponse guess(String gameId, int number) {
        Game game = games.get(gameId);
        if (game == null) {
            return new GuessResponse("Game not found");
        }
        return new GuessResponse(game.guess(number));
    }
}