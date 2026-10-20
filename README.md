# Projet Microservices - E-Bank

Ce projet est réalisé dans le cadre du module Architecture Microservices.
L'objectif est de créer une petite application bancaire basée sur des microservices avec Spring Boot et Spring Cloud.

## Description

L'application contient deux services métier :
- **Customer-Service** : gestion des clients
- **EBank-Service** : gestion des comptes bancaires

Le service EBank récupère les informations du client en appelant Customer-Service avec OpenFeign.

On a aussi :
- un **Discovery Service** (Eureka) pour enregistrer les services
- une **Gateway** pour accéder aux services depuis un seul point d'entrée

## Travail demandé

1. Développer le service Customer-Service
2. Développer le service EBank-Service
3. Communication entre les deux services avec OpenFeign
4. Fault Tolerance avec Circuit Breaker (Resilience4J)
5. Développer la Gateway
6. Développer le Discovery Service
7. Tester les services avec Postman et Swagger-UI

## Technologies utilisées

- Java 17
- Spring Boot
- Spring Data JPA, H2
- Spring Cloud (Eureka, Gateway, OpenFeign)
- Resilience4J
- Lombok
- Swagger (SpringDoc)
- IntelliJ IDEA, Maven

## Ports

- discovery-service : 8761
- gateway-service : 8888
- customer-service : 8081
- ebank-service : 8082

## Réalisation

(Captures d'écran et explications à ajouter au fur et à mesure)

## Réalisé par

Hanae Bouichnad - Étudiante en 5e année, Ingénierie Informatique : Développement Digital et Systèmes d'Information (DSI) - EMSI
