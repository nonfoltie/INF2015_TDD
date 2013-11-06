# TDD

Ce projet sert d'exercice pour les démonstrations du cours INF2015 - Développement Agile.

## Travail pratique

L'objectif de ce TP est de vous introduire au Test Driven Development grâce à JUnit.

Commencez par récupérer le projet sur GitHub, disponible à l'adresse : [https://github.com/Morriar/INF2015_TDD](https://github.com/Morriar/INF2015_TDD)

### Partie 1: Implémentation des méthodes

Certains tests unitaires sont déjà implémentés.
Pour chacun de ces tests unitaires, expliquez quel est le comportement attendu de la méthode et implémentez là.

Un petit peu d'aide pour commencer :

1. Commencez par lire la classe `StudentTest`
2. Renseignez vous sur la classe [SimpleDateFormat](http://docs.oracle.com/javase/1.4.2/docs/api/java/text/SimpleDateFormat.html)
3. Créez la classe `Student`
4. Ecrivez juste l'interface suffisante pour pouvoir jouer les tests (i.e. les méthodes avec le bon nom et la bonne signature)
5. Implémentez le corps des méthodes

*Astuce*: N'oubliez pas que l'annotation `@Ignore` peut vous servir à ignorer un test dont la méthode n'est pas encore implémentée.

### Partie 2: A vous d'écrire les tests !

Cette fois, c'est à vous d'écrire les tests PUIS le corps des méthodes.
On souhaite créer une classe Group qui permet de gérer un groupe d'étudiants.

La classe `Group` devra fournir les fonctionnalités suivantes :

* Ajouter un nouvel étudiant au groupe en lui passant un objet de type `Student`
* Créer puis ajouter un nouvel étudiant au groupe en lui passant nom, prénom et date de naissance
* Récupérer l'instance d'un étudiant dans un groupe grâce à son code permanent
* Calculer la moyenne des moyennes des étudiants du groupe

### Partie 3: Injection de dépendances

Votre client à une nouvelle requêtte !

Il souhaite ajouter la possibilité d'envoyer un email à ses étudiants directement depuis votre API.
Il a déjà fait développer à grand frais une classe d'envoi d'email parcontre l'entreprise refuse de vous la fournir...

Tout ce que vous savez c'est que cette classe implémente l'interface suivante :

    public interface MailSender {
	        public void send(String permaCode, String subject, String message);
	}

Bien entendu, il vous faut tester votre code et voir si tout fonctionne mais sans la bibliothèque d'emailing, cela va être dur...
Heureusement, l'injection de dépendances est là !

Aide :

1. Créez une classe de test `MailTester` qui implémente l'interface `MailSender`
2. Modifiez votre class `Group` pour lui injecter cette dépendance vers MailSender
3. Implémentez le corps de la méthode `MailTester::send` de manière à conserver un historique des appels qui lui sont fait
4. Ecrivez le test unitaire qui va bien

Bon courage !
