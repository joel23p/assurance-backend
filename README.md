# Action' elles assurance



## Introduction

Ce projet est l'application   backend Spring Boot du test technique  .

## Prérequis

Avant de commencer, assurez-vous d'avoir les éléments suivants installés sur votre machine :
- Java 17
- Node 20.9.0
- PostgreSQL 13 ou supérieur
- Angular CLI 17
- Git

## Installation


### 1. Cloner le projet
Créer un dossier de votre choix dans C:\dossier_votre_choix
```
cd dossier_votre_choix
```
git clone https://github.com/joel23p/assurance-backend.git
```

### 2. Installation des dépendances du backend

```
cd assurance-backend
gradlew build
```

## Base de données

Créer un utilisateur assurance avec le mot de passe assurance et une base donnée assurance dont il est propriétaire.

```
psql -U postgres
CREATE ROLE assurance WITH password 'assurance' login;
CREATE DATABASE assurance OWNER assurance;
```

## Démarrage

### 3. Démarrage backend
```
cd assurance-backend
gradlew bootRun
```
### 4. Architecture backend 
```
##Controleur:

Rôle : Point d’entrée des requêtes HTTP.

Responsabilités :

Gérer les routes (@GetMapping, @PostMapping, etc.).

Recevoir les données envoyées par le client (ex: via un formulaire ou une API).

Appeler les méthodes du Service pour effectuer le traitement.

Retourner les réponses au format JSON .

##Service:

Rôle : Contient la logique métier de l’application.

Responsabilités :

Orchestrer les appels vers le Repository.

Effectuer les vérifications ou règles de gestion.

Manipuler les entités, DTOs, etc.

##Repository:

Rôle : Accès aux données (base de données).

Responsabilités :

Interagir directement avec la base de données via Spring Data JPA.

Fournir des méthodes pour sauvegarder, mettre à jour, supprimer ou rechercher des entités.

##Domain :
Rôle : Représentation des o entités .

Responsabilités :

Contenir les attributs liés à une table (avec des annotations JPA).

Être manipulés dans le Service ou le Repository.

##Dto :
Rôle : Objets utilisés pour transférer les données entre les couches (surtout entre Controleur ↔ Service).

Responsabilités :

Masquer certaines informations sensibles.

Adapter les données pour l’interface (ex: simplifier une entité complexe).

Faciliter la conversion vers des formats utiles pour le front-end.
```

### 5.  Migration table vers bd postgres avec flyway 
```
Flyway est utilisé pour gérer les migrations de la base de données de manière versionnée et automatisée vers PostgreSQL.
Cela permet de conserver une trace claire et fiable de toutes les modifications appliquées au schéma de la base de données au fil du temps.

Les scripts de migration Flyway sont placés dans le dossier suivant :
src/main/resources/db/migration

```
### 6.  configuration 

## application.properties: 
```

Voici les principales configurations utilisées dans ce projet :

server.port=8086
→ Définit le port de l’application Spring Boot.

spring.application.name=assurance
→ Nom de l’application.

spring.datasource.*
→ Connexion à la base de données PostgreSQL (assurance).

spring.flyway.*
→ Active Flyway pour gérer les migrations SQL situées dans src/main/resources/db/migration.

spring.jpa.*
→ Paramètres JPA/Hibernate pour l'interaction avec la base de données.

client.url.local=http://localhost:4200
→ URL du client Angular autorisé pour les requêtes CORS.
Cette variable est utilisée dans la classe de configuration CORS (@Configuration) pour autoriser les appels cross-origin.

logging.level.org.springframework.web=DEBUG
→ Active les logs détaillés pour les requêtes web.

server.error.include-message=always
→ Affiche toujours les messages d'erreur dans les réponses HTTP.
```


## configuration cros origin Configuration CORS (Cross-Origin Resource Sharing): 
```
Le CORS permet à l' application front-end(front_end_assurance) 
d'accéder aux differnetes API Car mes deux applications communique avec des ports different 4200 pour frontend et le port 8086 pour le backend.
```


### 7.  Documentation API  et composant

## API de Simulation d’Assurance
```
Cette API permet d’effectuer une simulation du prix d’une assurance en fonction de plusieurs paramètres :

Le produit d’assurance sélectionné

La valeur initiale du véhicule

La valeur actuelle du véhicule

La puissance fiscale du véhicule

Ces données sont envoyées depuis un formulaire côté frontend (Angular) au backend via une requête HTTP POST.

 Fonctionnement côté backend
Le contrôleur SimulationControleur expose l’endpoint :
POST /api/v1/simulations

Cette route reçoit un SimulationDto en entrée, qui contient les informations du formulaire.

Le contrôleur appelle la méthode Simulation() de la classe SimulationService, qui se charge de :

Récupérer le produit d’assurance sélectionné

Identifier les garanties incluses (ex : RC, VOL, INCENDIE…)

Appliquer les formules de calcul associées à chaque type de garantie

Générer une référence de devis (quoteReference)

Calculer un prix total

Enregistrer la simulation en base de données

Retourner un objet json contenant le prix, la date de validité du devis, la reference et
les autres informations ayant servi au calcul.
```




## POST /api/v1/subscriptions
```
API de Souscription
Cette API permet d'enregistrer une souscription à une assurance à partir des informations saisies dans un formulaire (client, véhicule, catégorie).

Endpoint exposé : POST /api/v1/subscriptions

Données reçues : informations client, véhicule, et catégorie choisie

Traitements effectués :

Création et enregistrement du client

Récupération de la catégorie de véhicule

Création et enregistrement du véhicule

Création de la souscription, liée au client et au véhicule

L’API retourne un objet SouscriptionDto avec les détails de la souscription créée.
```

## GET /api/v1/lister
```
But : Récupérer toutes les catégories de véhicules, pour les lier à la souscription dans le formulaire.
Retourne : Une liste de CategorieVehiculeDto contenant :

id

description
```
#GET /api/v1/recuperer
```
But : Récupérer tous les produits d’assurance disponibles (ex : Tiers, Tous Risques…), pour les lier à la simulation.
Retourne : Une liste de ProduitAssuranceDto contenant :

id

nomProduit
```

```
