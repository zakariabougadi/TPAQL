# TP2 Unit Tests

## Exercise 4 Answers

### Question 1: Objects to Mock
The objects that must be mocked are `Banque`, `Joueur`, `De de1`, and `De de2`. These are dependencies of the `Jeu` class’s `jouer` method. Mocking isolates the `Jeu` class, allowing control over dice rolls, player solvency, and bank state without relying on their real implementations, which may involve randomness or external state.

### Question 2: Test Scenarios
1. **Game is closed**: `estOuvert()` returns `false`, throwing `JeuFermeException`.
2. **Player is insolvent**: `joueur.debiter` throws `DebitImpossibleException`, no dice or bank interactions.
3. **Sum of dice is not 7**: Player’s bet is debited, credited to bank, dice rolled, no player credit, game stays open.
4. **Sum of dice is 7, bank solvent**: Player’s bet debited, credited to bank, dice rolled, bank pays double, game stays open.
5. **Sum of dice is 7, bank insolvent**: Same as above, but bank becomes insolvent, game closes.

### Question 4: Test Type (Game Closed)
The test for a closed game is a **state test** because it checks the `Jeu` object’s state (`estOuvert()` is `false`) and verifies that `jouer` throws `JeuFermeException`. It does not verify interactions with dependencies.

### Question 5: Test Type (Player Insolvent)
The test for an insolvent player is an **interaction test** because it verifies that no interactions occur with `de1`, `de2`, or `banque` (using `verify(..., never())`) when `joueur.debiter` throws `DebitImpossibleException`. It also checks the exception, but the focus is on interaction absence.

### Question 7: Difference Between Tests
The unit test (`testJouerSommeSeptBanqueInsolvable`) mocks `Banque`, stubbing `est_solvable()` to return `false`, isolating `Jeu`’s behavior. The integration test (`testJouerSommeSeptBanqueInsolvableIntegration`) uses a real `BanqueImpl`, testing its actual funds and solvency logic. The integration test is less isolated but verifies the real interaction between `Jeu` and `BanqueImpl`.