package ee.mainor.classroom.greeting.service;

import ee.mainor.classroom.greeting.dto.GuessResponse;
import ee.mainor.classroom.greeting.model.GameEntity;
import ee.mainor.classroom.greeting.repository.GameRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class GameService {

    private final GameRepository gameRepository;

    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public String createGame() {
        int numberToGuess = (int) (Math.random() * 100) + 1;
        GameEntity game = new GameEntity(numberToGuess, 0);
        game = gameRepository.save(game);
        return game.getId().toString();
    }

    @Transactional
    public GuessResponse guess(String gameId, int number) {
        UUID id;
        try {
            id = UUID.fromString(gameId);
        } catch (IllegalArgumentException e) {
            return new GuessResponse("Invalid game ID");
        }

        GameEntity game = gameRepository.findById(id)
                .orElse(null);

        if (game == null) {
            return new GuessResponse("Game not found");
        }

        game.setAttempts(game.getAttempts() + 1);
        String message;

        if (number < game.getNumberToGuess()) {
            message = "Nr is bigger";
        } else if (number > game.getNumberToGuess()) {
            message = "Nr is smaller";
        } else {
            message = "Correct, it took you " + game.getAttempts() + " times";
        }

        gameRepository.save(game);
        return new GuessResponse(message);
    }
}