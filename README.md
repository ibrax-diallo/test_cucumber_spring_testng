Un projet from scratch spring boot, H2, java 8, Cucumber, maven, testNG environnement installer java 8 remarquer la
commande mvn spring-boot: run pour lancer l'api exécuter la commande mvn clean test pour lancer le test L'api contient
quatre services utilisateurs, abonné, contrat, mouvement -Pour accéder au service utilisateur:
http://localhost:5000/api/v1/users/ pour créer un utilisateur avec la requête post {username: "texte", password: "votre
mot de passe"} .http://localhost:5000/api/v1/users/login pour se connecter avec la requête post {username: "texte",
password: "votre mot de passe"} .http://localhost:5000/api/v1/abonne/ pour créer un abonné avec la requête post
.http://localhost:5000/api/v1/abonne/ pour récuperer la liste de tous les abonnés avec la requête get;
.http://localhost:5000/api/v1/abonne/id pour recuperer un abonné avec son id; .http://localhost:5000/api/v1/contrats/
pour souscrire un abonné à un contrat;
http://localhost:5000/api/v1/mouvements/ pour créer un mouvement de modification d'adresse;
http://localhost:5000/api/v1/mouvements/abonne/id pour l'historique de modification d'un abonné.

Pour visualiser le résultat du test, vous pourrez accéder au fichier /src/target/cucumber/abonne/index.html
