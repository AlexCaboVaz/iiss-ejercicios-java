# Primer Ejercicio

 ## Clase AsynchronousAPI

 - En la clase AsynchronousAPI, hemos utilizado CompletableFuture para representar el resultado futuro de la suma. Dentro del submit del ExecutorService, realizamos la suma iterando sobre cada elemento de la lista. Imprimimos el mensaje "Adding (element)" antes de sumar cada elemento y agregamos un retardo de 5 segundos con Thread.sleep(5000).

    ## Main

- En la clase Main, creamos una lista de enteros y luego llamamos al método additionAsync de la clase AsynchronousAPI para obtener el resultado futuro. Utilizamos get() en el Future para obtener el resultado final de la suma y lo mostramos en la consola.