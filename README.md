# Student Management App (Gestion des Étudiants)

## Description

Application Android native permettant la gestion simple d’une base de données d’étudiants en utilisant SQLite.
Ce projet a été réalisé dans un cadre académique afin de comprendre la **persistance des données locales** et les opérations CRUD.

##  Fonctionnalités

* ➕ **Ajouter un étudiant** (Nom, Prénom)
* 🔍 **Rechercher un étudiant** via son ID
* ❌ **Supprimer un étudiant**
* 📋 **Visualisation via Logcat** (suivi en temps réel)
* 💾 **Persistance locale** avec SQLite (données conservées après fermeture)

---
## 🛠 Stack Technique

* **Langage** : Java
* **Base de données** : SQLite
* **Interface utilisateur** : XML (Android natif)
* **Outils** : Android Studio, Android SDK, Gradle
---
## Structure du Projet
```
ma.ensa.app_model
├── classes
│   └── Etudiant.java        # Modèle
├── service
│   └── EtudiantService.java # Logique métier / CRUD
├── util
│   └── MySQLiteHelper.java  # Gestion de la base SQLite
└── MainActivity.java        # Interface utilisateur
```
##  Démo

Vous pouvez consulter la démonstration vidéo de l'application ici :

[Voir la vidéo DEMO](./Demo_LAB15.mp4)


application réalisée dans un cadre académique à l’ENSA.

