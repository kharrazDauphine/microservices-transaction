# Compile Project

```
mvn install
```

a jar file is generated in target folder as microservice-transaction.jar

# Project Execution

Run the jar file using the command
```
java -jar microservice-transaction.jar
```
## Create a transaction
```
POST http://localhost:8001/transactions/
```
```
json object
```

## Read a transaction
```
GET http://localhost:8001/transactions/{id}
```
## Update a transaction
```
PUT http://localhost:8001/transactions/{id}
```
```
json object
```
## Delete a transaction
```
DELETE http://localhost:8001/transactions/{id}
```
```
json object
```
