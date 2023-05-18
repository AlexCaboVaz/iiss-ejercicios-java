# Ejercicios 

## Ejercicio 1
### ¿Se realiza inyección de dependencias entre las clases anteriores? Si es así, identifique la clase inyectora, el servicio y el cliente.
Sí, se realiza la inyección de dependencias entre las clases anteriores. En este caso, la clase inyectora es la clase Main, el servicio es la interfaz DBAccess, y el cliente es la clase DBClient.

La clase Main actúa como la clase inyectora porque crea las instancias de los objetos y los pasa a la clase DBClient a través de su constructor y método setDBAccess(). En el método main(), se crean instancias de las implementaciones de DBAccess, es decir, DBAccessB y DBAccessA, y se pasan a la clase DBClient.

La interfaz DBAccess representa el servicio, ya que define los métodos comunes que deben implementar las clases concretas DBAccessA y DBAccessB. Estas clases concretas implementan el método initConnection() de acuerdo con sus propias lógicas.

La clase DBClient es el cliente, ya que utiliza el servicio DBAccess para interactuar con la base de datos. El cliente recibe una instancia de DBAccess a través de su constructor y la almacena en la variable dbAccess. Luego utiliza los métodos initConnection(), getAllFromDataBase() y getSomeDataFromDataBase() de dbAccess para realizar las operaciones requeridas en la base de datos

### En el caso de que exista inyección de dependencias, además indique: El método de inyección que se realiza (constructor, propiedad o método). La/s línea/s donde se realiza la inyección de dependencias

En el código proporcionado, se realiza la inyección de dependencias a través del método de inyección por constructor.

La inyección de dependencias se realiza en las siguientes líneas:

En la clase DBClient:

1. En el constructor DBClient(DBAccess dbAccess): Aquí se realiza la inyección de dependencias al recibir una instancia de DBAccess como parámetro y asignarla a la variable dbAccess.

En la clase Main:

2. En la línea DBClient client = new DBClient(dbAccessB);: Aquí se crea una instancia de DBClient pasando la instancia de DBAccessB como argumento al constructor, lo que realiza la inyección de dependencias.

Además, en la clase DBClient, hay un método adicional llamado setDBAccess(DBAccess dbAccess) que podría ser considerado como un método de inyección de dependencias, ya que permite cambiar la implementación de DBAccess en tiempo de ejecución. Sin embargo, en el código proporcionado, este método no se utiliza en el proceso principal de inyección de dependencias.