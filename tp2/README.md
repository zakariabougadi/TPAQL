# TP2 - Tests Unitaires avec Mockito

## Exercice 4 : Jeu de dés - Réponses aux questions

### 1. Objets mockés dans le test de la classe Jeu

Les objets qui doivent être forcément mockés sont :
- `Banque` : Car c'est une dépendance externe qui gère l'argent
- `Joueur` : Car il représente un acteur externe avec son propre état
- `De` (les deux dés) : Car ils représentent des composants qui génèrent de l'aléatoire

Ces objets doivent être mockés car :
- Ils ont leur propre état qui pourrait influencer les tests
- Ils peuvent avoir des comportements non déterministes (les dés)
- Ils représentent des dépendances externes dont le comportement doit être contrôlé pour les tests

### 2. Scénarios de test pour la méthode jouer

1. **Test du jeu fermé**
   - Vérifier que le jeu lance une exception quand il est fermé
   
2. **Test du joueur insolvable**
   - Vérifier que le jeu s'arrête quand le joueur ne peut pas payer sa mise
   - Vérifier qu'aucune interaction avec les dés n'a lieu
   
3. **Test du joueur qui perd**
   - Vérifier le comportement quand la somme des dés n'est pas 7
   - Vérifier que le joueur est débité et la banque créditée
   
4. **Test du joueur qui gagne**
   - Vérifier le comportement quand la somme des dés est 7
   - Vérifier que le joueur reçoit son gain
   - Vérifier que la banque est débitée du gain
   
5. **Test de la banque qui devient insolvable**
   - Vérifier que le jeu se ferme quand la banque n'est plus solvable après un gain

### 3. Test du jeu fermé

Le test du jeu fermé (`testJouerQuandJeuFerme`) est un **test d'état** car :
- Il vérifie l'état du jeu (fermé) via l'attribut `estOuvert`
- Il ne s'intéresse pas aux interactions avec les autres objets
- Il vérifie uniquement le comportement de l'objet Jeu en fonction de son état interne

### 4. Test du joueur insolvable

Le test du joueur insolvable (`testJouerQuandJoueurInsolvable`) est un **test d'interactions** car :
- Il vérifie les interactions entre le jeu et ses dépendances
- Il s'assure que certaines méthodes sont appelées (mise, debiter)
- Il vérifie qu'aucune interaction n'a lieu avec les dés
- Il utilise les méthodes verify() de Mockito pour vérifier les interactions

### 7. Différence entre test avec mock et test avec implémentation réelle

La principale différence entre un test utilisant un mock de la banque et un test utilisant une vraie implémentation est :

1. **Avec mock** :
   - Le comportement est totalement contrôlé
   - Le test est isolé des autres composants
   - Le test est plus rapide et plus prévisible
   - On teste uniquement les interactions

2. **Avec implémentation réelle** :
   - On teste le véritable comportement de la banque
   - Le test est plus intégré
   - On peut détecter des problèmes d'intégration
   - Le test est plus proche des conditions réelles d'utilisation

Le choix entre les deux approches dépend de l'objectif du test :
- Les mocks sont préférables pour les tests unitaires purs
- L'implémentation réelle est préférable pour les tests d'intégration 