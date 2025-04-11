package ee.mainor.classroom.greeting.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Entity
@Table(name = "games")
public class GameEntity {

    // Getters and setters
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Setter
    @Column(nullable = false)
    private int numberToGuess;

    @Setter
    @Column(nullable = false)
    private int attempts;

    // Constructors, getters, and setters
    public GameEntity() {
    }
    public GameEntity(int numberToGuess, int attempts) {
        this.numberToGuess = numberToGuess;
        this.attempts = attempts;
    }
}