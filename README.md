````markdown
# 🎯 GuessNumber Game (Java)

A simple console-based number guessing game written in Java!

## 📌 Features

- Random number between 1 and 100 each round
- Feedback system based on how close your guess is
- Input validation (handles invalid or out-of-range inputs)
- Tracks and displays a personal high score
- Option to play again after each round


## 🧠 Gameplay

* The computer randomly selects a number between 1 and 100.
* You keep guessing until you get it right.
* Feedback will help guide your guess:

  * “Way off”
  * “Very Low”
  * “Low”
  * “Low, but close!”
  * ... and similar for high guesses.
* Your number of attempts is tracked.
* If your score beats the previous best, a new high score is set.

## 📄 Example Output

```
+---------------------------------------------------+
        Guess a number between 1 and 100
+---------------------------------------------------+
Guess: 32
Very Low!

Guess: 67
High

Guess: 59

+---------------------------------------------------+
  Congratulations you've guessed the right number!!

               Number 59 in 3 attempts
+---------------------------------------------------+

New High Score: 3 attempts!
```
