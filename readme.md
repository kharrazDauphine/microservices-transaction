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
{
    "src": "xxx",
    "dst": "xxx",
    "montant": xxx,
    "date": "yyyy-MM-dd"
}
```

## Read a transaction
```
GET http://localhost:8001/transactions/{id}
```
## Update a transaction
```
PUT http://localhost:8001/transactions/{id}
```
{
    "id": {id},
    "src": "xxx",
    "dst": "xxx",
    "montant": xxx,
    "date": "yyyy-MM-dd",
    "taux": xxx
}
```
json object
```
## Delete a transaction
```
DELETE http://localhost:8001/transactions/{id}
```
