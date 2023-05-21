# Ejercicio 1

Este código incluye el método main donde se realiza la prueba de ordenamiento ascendente y descendente utilizando las implementaciones modificadas de DataSorterAsc y DataSorterDesc con programación funcional.

Además, se define la interfaz funcional DataSorter con el método sort que toma un array de cadenas y devuelve el mismo array ordenado. Dentro del método main, se utilizan expresiones lambda para definir los cierres que implementan el método sort en orden ascendente y descendente, respectivamente.

El código se ejecutará y mostrará los resultados del ordenamiento ascendente y descendente en la consola.


# Ejercio 2

En este código, hemos agregado un nuevo cierre llamado dataSorter que realiza la ordenación aleatoria de los elementos del array. Dentro del cierre, convertimos el array en una lista utilizando Arrays.asList(), luego utilizamos Collections.shuffle() para mezclar aleatoriamente los elementos de la lista y finalmente convertimos la lista nuevamente en un array utilizando list.toArray(new String[0]). Así obtenemos el array con los elementos ordenados de forma aleatoria.

La secuencia de ejecución en el main ahora es la siguiente: primero se realiza la ordenación aleatoria, luego la ordenación ascendente y finalmente la ordenación descendente. Los resultados se imprimen en la consola para verificar cada ordenación.

Con estos cambios, ahora tienes tres implementaciones de la interfaz DataSorter utilizando cierres para la ordenación aleatoria, ascendente y descendente de los elementos del array.