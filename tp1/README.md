# TP1 - Tests Unitaires et Couverture de Code

## Bugs détectés et corrections

### Exercice 1 : Palindrome
- **Bug** : Syntaxe incorrecte `s = s lst = 0`. Remplacé par `s = s.toLowerCase().replaceAll("\\s+", "")`.
- **Bug** : Indices dans la boucle (`j++`, `i--`) incorrects. Corrigé en `i++`, `j--`.
- **Correction** : Fichier `Palindrome.java` mis à jour.
- **Note** : Les tests pour la couverture des branches et des conditions sont similaires, car il n'y a pas de conditions composées.

### Exercice 2 : Anagram
- **Bug** : Syntaxe `s1 lst = 0` et regex incorrecte. Corrigé en `s1.toLowerCase().replaceAll("\\s+", "")`.
- **Bug** : Boucle `i <= s1.length()` provoque une exception. Corrigé en `i < s1.length()`.
- **Bug** : Syntaxe `sl` et `52`. Corrigé en `s1` et `s2`.
- **Correction** : Fichier `Anagram.java` mis à jour avec validation des caractères alphabétiques.
- **Note** : Les tests des branches et conditions diffèrent légèrement en raison des conditions dans `if (s1 == null || s2 == null)`.

### Exercice 3 : BinarySearch
- **Bug** : Condition `while (low < high)` manque le dernier élément. Corrigé en `while (low <= high)`.
- **Bug** : Condition `array[mid] <= element` incorrecte. Corrigé en `array[mid] < element`.
- **Correction** : Fichier `BinarySearch.java` mis à jour avec vérification du tableau vide.
- **Note** : Tests similaires pour branches et conditions.

### Exercice 4 : QuadraticEquation
- **Bug** : Aucun bug majeur, mais ajout de validation pour `NaN` et `Infinity`.
- **Correction** : Fichier `QuadraticEquation.java` mis à jour.
- **Note** : Tests identiques pour les trois critères, car les conditions sont simples.

### Exercice 5 : RomanNumeral
- **Bug** : Symboles `"Y"` incorrects. Corrigé en `"V"` et `"IV"`.
- **Bug** : Logique `while (n > values[i])` et `n = values[i]`. Corrigé en `while (n >= values[i])` et `n -= values[i]`.
- **Correction** : Fichier `RomanNumeral.java` mis à jour.
- **Note** : Tests des branches et conditions similaires.

### Exercice 6 : FizzBuzz
- **Bug** : Aucun bug détecté.
- **Note** : Tests complets pour les trois critères.

## Structure du projet
- `TP1/LineCoverageTest/ExoXTest.java` : Tests pour la couverture des lignes.
- `TP1/BranchCoverageTest/ExoXTest.java` : Tests pour la couverture des branches.
- `TP1/ConditionCoverageTest/ExoXTest.java` : Tests pour la couverture des conditions.
- Classes corrigées : `Palindrome.java`, `Anagram.java`, `BinarySearch.java`, `QuadraticEquation.java`, `RomanNumeral.java`.