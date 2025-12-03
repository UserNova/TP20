###  Mise en place du service discovery Eureka

Le service discovery Eureka est un composant essentiel dans une architecture microservices. Il permet aux services de se découvrir mutuellement sans avoir à coder en dur les adresses IP et les ports. Cela facilite le déploiement, la mise à l'échelle et la résilience de l'application.

<img width="370" height="647" alt="image" src="https://github.com/user-attachments/assets/9c74db86-4d07-4b5f-b666-833a8320e7ea" />

### Microservice Client

Le microservice "Client" est une application Spring Boot qui gère les opérations associées à la gestion des clients. Ce service repose sur une base de données MySQL pour le stockage des informations essentielles des clients, telles que le nom et l'âge. Des points de terminaison RESTful sont exposés afin de permettre la récupération de la liste des clients, la recherche d'un client par identifiant, ainsi que l'ajout de nouveaux clients. L'intégration au service de découverte Eureka garantit la découverte automatique des services dans un environnement de type microservices.
L'application est exécutée en utilisant la classe CarApplication et sa méthode main. Aucune erreur ne doit être présente au démarrage.

<img width="446" height="854" alt="image" src="https://github.com/user-attachments/assets/2e52d0a9-e19a-45a5-89a4-de8f2a0c059d" />

### Service Gateway

Le service "Gateway" assure la gestion centralisée des requêtes en utilisant Spring Cloud Gateway. Ce service permet la redirection des requêtes vers les microservices enregistrés dans le registre Eureka.


<img width="421" height="641" alt="image" src="https://github.com/user-attachments/assets/a45c708a-b32d-4312-881a-f1281a95919a" />

### Service Voiture

Le service "Voiture" assure la gestion des informations sur les voitures. Les principales opérations incluent la récupération de toutes les voitures, la recherche d'une voiture par identifiant et l'affichage des détails de la voiture ainsi que ceux du client associé.

<img width="412" height="913" alt="image" src="https://github.com/user-attachments/assets/e9319349-40dc-4007-8afc-f562aca2b892" />


http://localhost:8761

<img width="1808" height="416" alt="image" src="https://github.com/user-attachments/assets/2a2fcb83-f517-4f44-9520-220bf93a26d1" />

http://localhost:8888/SERVICE-VOITURE/api/car

<img width="873" height="937" alt="image" src="https://github.com/user-attachments/assets/1cd391ea-201f-4197-9237-722ccd8a20f0" />

http://localhost:8888/SERVICE-VOITURE/api/car/8

<img width="659" height="371" alt="image" src="https://github.com/user-attachments/assets/ef2ef7ca-7d6c-4425-970e-57561dbd809a" />

http://localhost:8888/SERVICE-VOITURE/api/car/10

<img width="709" height="447" alt="image" src="https://github.com/user-attachments/assets/5fbd1384-ae50-43da-97cd-e7c100e21bc4" />



