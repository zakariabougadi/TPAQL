-- Insertion de données de test
INSERT INTO tasks (title, description, created_at, completed)
VALUES 
    ('Tâche initiale 1', 'Description de la tâche 1', NOW(), false),
    ('Tâche initiale 2', 'Description de la tâche 2', NOW(), true); 