# Task Manager Application with Testcontainers

Ce projet est une application de gestion de tâches développée avec Spring Boot et testée avec Testcontainers. Il s'agit d'une implémentation du TP3 sur les tests unitaires et d'intégration.

## Prérequis

- Java 11 ou supérieur
- Maven
- Docker
- IDE (IntelliJ IDEA recommandé)

## Structure du Projet

```
src/
├── main/
│   ├── java/
│   │   └── com/
│   │       └── example/
│   │           └── taskmanager/
│   │               ├── controller/
│   │               ├── model/
│   │               ├── repository/
│   │               ├── service/
│   │               └── TaskManagerApplication.java
│   └── resources/
│       └── application.properties
└── test/
    └── java/
        └── com/
            └── example/
                └── taskmanager/
                    └── integration/
```

## Fonctionnalités

- Création de tâches
- Récupération de toutes les tâches
- Récupération d'une tâche par ID
- Mise à jour d'une tâche
- Suppression d'une tâche

## Configuration

Le projet utilise MySQL comme base de données. Les paramètres de connexion sont configurés dans `application.properties`.

## Tests

Les tests d'intégration utilisent Testcontainers pour créer un environnement de test isolé avec une base de données MySQL en conteneur Docker.

Pour exécuter les tests :

```bash
mvn test
```

## API Endpoints

- `POST /api/tasks` - Créer une nouvelle tâche
- `GET /api/tasks` - Récupérer toutes les tâches
- `GET /api/tasks/{id}` - Récupérer une tâche par ID
- `PUT /api/tasks/{id}` - Mettre à jour une tâche
- `DELETE /api/tasks/{id}` - Supprimer une tâche

## Exemple de Requête

Créer une nouvelle tâche :

```bash
curl -X POST http://localhost:8080/api/tasks \
-H "Content-Type: application/json" \
-d '{
    "title": "Nouvelle tâche",
    "description": "Description de la tâche"
}'
```

## Tests avec Testcontainers

Les tests d'intégration utilisent Testcontainers pour :
1. Démarrer automatiquement un conteneur MySQL
2. Configurer la connexion à la base de données
3. Exécuter les tests dans un environnement isolé
4. Nettoyer les ressources après les tests

## Avantages de Testcontainers

- Environnement de test isolé et reproductible
- Pas besoin d'installer MySQL localement
- Tests plus fiables car ils s'exécutent dans un environnement proche de la production
- Configuration automatique des conteneurs
- Nettoyage automatique des ressources

## Contribution

1. Fork le projet
2. Créer une branche pour votre fonctionnalité
3. Commiter vos changements
4. Pousser vers la branche
5. Créer une Pull Request 