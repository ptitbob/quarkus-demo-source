## Demo d'un ensemble de service

> Quarkus & Spring

Lancement de la demo complete : `docker-compose -f docker-compose.yml up -d`

### La demo Ping

Lancement de la demo ping : `docker-compose -f docker-compose-ping.yml up -d`

> Si Utilisation de `ctop`
>
>On remarquera que la version quarkus/jvm prend la moitié (environ 70Mo) de la taille mémoire de la version spring/jvm (185 Mo)
>
>La version quarkus/native prends moins de 4Mo de mémoire
>
> (*Taille indicative mesurée sur mon ordinateur*)

#### Test Ping 

**Appel ping**
* Version quarkus/native : `httpstat http://localhost:8086/ping` ou `http :8086/ping` ou `curl -X GET http://localhost:8086/ping`
* Version quarkus/jvm : `httpstat http://localhost:8096/ping` ou `http :8096/ping` ou `curl -X GET http://localhost:8096/ping`
* Version spring/jvm : `httpstat http://localhost:8087/ping` ou `http :8087/ping` ou `curl -X GET http://localhost:8087/ping`

**Appel health**
* Version quarkus/native : `http :8086/health` ou `curl -X GET http://localhost:8086/health`
* Version quarkus/jvm : `http :8096/health` ou `curl -X GET http://localhost:8096/health`
* Version spring/jvm : `http :8087/actuator/health` ou `curl -X GET http://localhost:8087/actuator/health`

*Rappel* :

Arret : `docker-compose -f docker-compose-ping.yml stop`

Nettoyage des container : `docker-compose -f docker-compose-ping.yml rm -f`

Start des bases de données via kubernetes : `kubectl create -f db.yaml && kubectl create -f db-person.yaml`

Start du mode quarkus natif : `kubectl create -f quarkus-native.yaml` 
Start du mode quarkus jvm : `kubectl create -f quarkus-jvm.yaml` 
Start du mode spring : `kubectl create -f quarkus-spring.yaml`

Pour l'arrêt c'est la même chose en remplaçant le verbe create par delete. 