# Ubiquitous Trains
### Running the app
#### Compile:
mvn clean install
#### Run the app
java -jar target/ubiquitous-trains-0.0.1-SNAPSHOT.jar
#### Run the app in debug moge with logger turned on
java -Xdebug -Xrunjdwp:server=y,transport=dt_socket,address=8000,suspend=n      \  -jar target/ubiquitous-trains-0.0.1-SNAPSHOT.jar --trace

### Login
You can log in either via github or directly on site.
## Web login
http://localhost:8080/login
## GitHub
http://localhost:8080/login/oauth.html
### Trains live view
Navigate to:
http://localhost:8080/
Make a topic subscription by clicking Websocket Connection.
You can use below ready curl's to send PUT requests and see new train locations, their speed, coordinates etc.
curl -X PUT -H "Content-Type: application/json" -d '{"name":"Supaplex","destination":"Lodz","speed":123.3,"coordinates":[51.0052,19.0053]}' http://localhost:8080/trains/12/location
curl -X PUT -H "Content-Type: application/json" -d '{"name":"Supaplex","destination":"Helsinki","speed":123.3,"coordinates":[60.1699,24.9384]}' http://localhost:8080/trains/11/location

