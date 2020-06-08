# TP Examen d'interopérabilité
Développé avec Java Springboot. Utilise les Web Services SOAP et API REST

## Exercice 1 : Web Service SOAP

Service de référencement d'avis sur des produits

| Méthode         | Données en entrée       | Données en sortie                 | Fonctionnalités        |
| :------         | :---:                   | :----:                            | :---:                  |
| enregistrerAvis | Date/Heure de l'avis    | Nombre d'avis pour le fournisseur | Log                    |
|                 | Référence produit       |                                   | Validation des données |
|                 | Note                    |                                   | Enregistrement avis    |
|                 | Commentaire             |                                   | Envoi données sortie   |
|                 | Provenance avis         |                                   |                        |
|                 | Référence fournisseur   |                                   |                        |
| listerAvis      | Référence produit       | Liste des avis du produit         | Log                    |
|                 |                         |                                   | Validation des données |
|                 |                         |                                   | Envoi données sortie   |


Utilisation
1. Lancer le main() de la classe **AvisServiceRunner**
2. Récupérer le fichier **AvisService.wsdl** dans le dossier **resources**
3. Utiliser SOAP-UI ou Postman afin d'interagir

## Exercice 2 : API REST

Gestion de plantations

| Adresse | GET                     | POST                          | DELETE                    |
| :------ | :---:                   | :----:                        | :------:                  |
| /       | Lister les plantations  | Créer une nouvelle plantation | X                         |
| /id     | X                       | X                             | Supprime la plantation id |

Lancement de l'application
1. Lancer la commande Maven **spring-boot:run**
2. Ouvrir un navigateur et se rendre à l'adresse **localhost:9090/plantations**
3. Alternativement, utiliser SOAP-UI ou PostMan

## Exercice 3 : Client Interop Messenger

J'ai utilisé REST afin d'interagir avec le serveur (même si j'ai une implémentation partiel du service en SOAP)
*Voir exo3/Client*

Interaction avec l'API REST
**ATTENTION** Veillez à utiliser vos identifiants pour vous connecter

Fonctionnalités :
- Envoi de messages sur un channel donné
- Récupération de messages sur un channel donné (Toutes les 5 secondes mais bloquant)
- Création d'un nouveau channel
- Connexion à un channel donné

Lancement de l'application
1. Lancer le main() de la classe **ClientInteropMessenger**
2. Suivre les instructions de l'application en ligne de commande
