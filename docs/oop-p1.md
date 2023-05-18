# Ejercicios P1

## Ejercicio 1

1. La salida del codigo seria 3 en vez de 6, esto es debido a que el metodo 'addAll'' cuenta el numero de elementos de la coleccion como argumento y los agrega al conjunto, por lo que se agregan 3 elemntos. El metodo 'getNumberOfAddedElements' simplemente devuelve ese 3. Y no, este codigo no esta bien implementado debido a que hay una baja cohesión y alto acoplamiento, En el caso de la clase ElementsSet<E>, se puede observar una baja cohesión porque está combinando dos responsabilidades distintas: actuar como un conjunto de elementos (HashSet<E>) y realizar el seguimiento del número de elementos agregados. Estas dos responsabilidades podrían separarse en clases distintas para mejorar la cohesión.

Además, hay un alto acoplamiento debido a que la clase ElementsSet<E> extiende directamente HashSet<E>. Esto crea una dependencia fuerte entre las dos clases, lo que significa que cualquier cambio en la implementación de HashSet<E> podría afectar directamente a ElementsSet<E>. Este nivel de acoplamiento puede hacer que el código sea más frágil y difícil de mantener.

Una forma de abordar estos problemas podría ser utilizar la composición en lugar de la herencia. En lugar de extender directamente HashSet<E>, se podría tener una instancia de HashSet<E> dentro de la clase ElementsSet<E> y delegar las operaciones correspondientes. Esto permitiría una mayor flexibilidad y modularidad, separando las responsabilidades y reduciendo el acoplamiento entre las clases.

En resumen, se podría argumentar que el código presentado tiene una baja cohesión debido a la combinación de responsabilidades y un alto acoplamiento debido a la herencia directa. Revisar y refactorizar el diseño para mejorar la cohesión y reducir el acoplamiento podría ser beneficioso en términos de mantenibilidad y extensibilidad del código.

2. 
Una posible solucion al ejercicio es realizando como hemos comentado anteriormente con composición en vez de herencia.
```
import java.util.Collection;
import java.util.HashSet;
import java.util.Arrays;

public class ElementsSet<E> {
    private HashSet<E> set;
    private int numberOfAddedElements;

    public ElementsSet() {
        set = new HashSet<>();
        numberOfAddedElements = 0;
    }

    public boolean add(E element) {
        numberOfAddedElements++;
        return set.add(element);
    }

    public boolean addAll(Collection<? extends E> elements) {
        numberOfAddedElements += elements.size();
        return set.addAll(elements);
    }

    public int getNumberOfAddedElements() {
        return numberOfAddedElements;
    }

    public static void main(String[] args) {
        ElementsSet<String> set = new ElementsSet<String>();
        set.addAll(Arrays.asList("One", "Two", "Three"));
        System.out.println(set.getNumberOfAddedElements());
    }
}
```
En esta solución, se crea una instancia de HashSet<E> llamada set dentro de la clase ElementsSet<E>. Los métodos add, addAll y getNumberOfAddedElements se implementan para realizar el seguimiento del número de elementos agregados y delegar las operaciones correspondientes al conjunto interno set.

Al utilizar la composición en lugar de la herencia, se logra una mayor separación de responsabilidades y se reduce el acoplamiento entre las clases. Además, se mejora la cohesión al enfocar la clase ElementsSet<E> únicamente en el seguimiento de los elementos agregados y no en la funcionalidad completa de un conjunto.

Es importante tener en cuenta que en esta solución no se están proporcionando todos los métodos de HashSet<E>. Si se requiere utilizar otros métodos de HashSet<E>, es necesario implementarlos en la clase ElementsSet<E> según sea necesario y delegar las llamadas al conjunto interno set.


## Ejercicio 2

1. Sí, el uso de herencia en las clases Cat y Dog es apropiado y cumple con los principios de abstracción y modularidad. Ambas clases heredan de la clase abstracta Animal, lo que permite establecer una relación de tipo "es-un" entre las subclases y la superclase. Esta relación se basa en el hecho de que tanto los gatos como los perros son tipos de animales.

La herencia permite que las subclases Cat y Dog hereden los miembros y comportamientos de la clase Animal. Esto significa que no es necesario volver a implementar los métodos speak(), eat(), y getNumberOfLegs() en cada subclase, ya que se pueden heredar directamente de la clase Animal. Sin embargo, cada subclase puede proporcionar su propia implementación específica para estos métodos según sea necesario.

El uso de herencia en este caso también ayuda a lograr la cohesión y el acoplamiento adecuados. La cohesión se refiere a que las responsabilidades y comportamientos relacionados se agrupen en una sola clase o módulo, y la herencia permite agrupar los comportamientos comunes a todos los animales en la clase abstracta Animal. El acoplamiento, por otro lado, se refiere a la dependencia entre diferentes clases. En este caso, las subclases Cat y Dog dependen de la clase Animal, pero no tienen una dependencia directa entre ellas, lo que reduce el acoplamiento entre las clases.

Al utilizar la herencia de esta manera, se obtienen beneficios como la reutilización de código y la capacidad de extender y especializar comportamientos. Por ejemplo, si se desea agregar una nueva subclase como Bird en el futuro, se puede heredar de la clase Animal y proporcionar su propia implementación de los métodos abstractos. Esto promueve la flexibilidad y el mantenimiento del código, ya que se pueden agregar nuevos tipos de animales fácilmente sin afectar el código existente.

En resumen, el uso de herencia en las clases Cat y Dog es apropiado y cumple con los principios de abstracción y modularidad. Proporciona beneficios como la reutilización de código, la flexibilidad y la capacidad de extender y especializar comportamientos.


2. 
```
public interface Animal {
    String speak();
    boolean eat(String typeOfFeed);
    int getNumberOfLegs();
}

public class Cat implements Animal {
    private int numberOfLegs;

    public Cat() {
        numberOfLegs = 4;
    }

    @Override
    public String speak() {
        return "Meow";
    }

    @Override
    public boolean eat(String typeOfFeed) {
        return typeOfFeed.equals("fish");
    }

    @Override
    public int getNumberOfLegs() {
        return numberOfLegs;
    }
}

public class Dog implements Animal {
    private int numberOfLegs;

    public Dog() {
        numberOfLegs = 4;
    }

    @Override
    public String speak() {
        return "Woof";
    }

    @Override
    public boolean eat(String typeOfFeed) {
        return typeOfFeed.equals("meat");
    }

    @Override
    public int getNumberOfLegs() {
        return numberOfLegs;
    }
}

public class Main {
    public static void main(String[] args) {
        Animal cat = new Cat();
        Animal dog = new Dog();
        System.out.println(cat.speak());
        System.out.println(dog.speak());
    }
}
```

- En esta solución, la interfaz Animal define los métodos comunes que deben ser implementados por las clases Cat y Dog. Luego, las clases Cat y Dog implementan la interfaz Animal y proporcionan su propia implementación para los métodos requeridos.

La principal ventaja de esta solución alternativa es que evita el acoplamiento fuerte entre las clases Cat y Dog y la clase Animal. En cambio, las clases Cat y Dog dependen solo de la interfaz Animal, lo que permite una mayor flexibilidad y un mejor mantenimiento del código. Además, se puede utilizar la composición para agregar más comportamientos o características a cada clase, sin afectar la estructura de las demás clases.

Además, la solución con composición también permite manejar casos donde un animal puede tener características o comportamientos adicionales que no son comunes a todos los animales. Por ejemplo, se podría agregar una clase Bird que implemente la interfaz Animal, pero también tenga métodos específicos para volar.

En resumen, la solución alternativa con composición en lugar de herencia permite una mayor flexibilidad, menor acoplamiento y un mejor mantenimiento del código. Proporciona una estructura más modular y extensible, lo que facilita la incorporación de nuevos tipos de animales y la adición de características específicas a cada clase.
