package ee.mainor.classroom.greeting.api;

import ee.mainor.classroom.greeting.dto.GuessResponse;
import ee.mainor.classroom.greeting.service.GameService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/game")
public class GameController {

    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @PostMapping
    public String startGame() {
        return gameService.createGame();
    }

    @GetMapping("/{gameId}/guess/{number}")
    public GuessResponse guessNumber(@PathVariable String gameId, @PathVariable int number) {
        return gameService.guess(gameId, number);
    }
}
