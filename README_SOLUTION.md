# Documentación

La solución debería contener un fichero README donde se respondan estas preguntas:
- ¿Qué has empezado implementando y por qué?
  R: He empezado extrayendo la clase Http y centrándome en el proceso de extraer la información de la ciudad de manera asíncrona.
  El motivo es porque eran los blóques de código más evidentes a refactorizar. Misma estructura y una funcionalidad idéntica.

- ¿Qué problemas te has encontrado al implementar los tests y cómo los has solventado?
  R: El código no era testeable porque estaba todo mezclado en una clase y no había forma de testear los casos de uso de forma aislada, por lo que ha sido necesario separar en distintas clases las diferentes responsabilidades y usar inyección de dependencias e interfaces para inyectar los mocks.

- ¿Qué componentes has creado y por qué?
  R: Entidades asociadas a la respuesta y tratamiento de peticiones. Interfaces y repositorios para la obtención de las entidades.

- Si has utilizado dependencias externas, ¿por qué has escogido esas dependencias?
  R: He utilizado Gson para facilitar la recogida de información a partir de los Json que se reciben en las peticiones get.

- ¿Has utilizado  streams, lambdas y optionals de Java 8? ¿Qué te parece la programación funcional?
  R: R: Sí, me parecen muy útiles y más legibles a la hora de escribir código. Personalmente, prefiero trabajar con ellos sobre colecciones de objetos.

- ¿Qué piensas del rendimiento de la aplicación?
  R: Que era mejorable en muchos aspectos.

- ¿Qué harías para mejorar el rendimiento si esta aplicación fuera a recibir al menos 100 peticiones por segundo?
  R: Utilizar procesos asíncronos y evitar bloquear el hilo principal como se ha aplicado en la solución propuesta.

- ¿Cuánto tiempo has invertido para implementar la solución?
  R: 8 horas en ratos muertos.

- ¿Crees que en un escenario real valdría la pena dedicar tiempo a realizar esta refactorización?
  R: Muchas veces por cuestiones de tiempo y recursos no es posible hacer refactorizaciones y más cuando se trata de código legacy, lo que es un inconveniente porque a largo plazo, cuando hay que modificar o extender el código se pierde tiempo innecesario y es más propenso a errores. Por lo tanto, dedicarle tiempo a tareas de refactorización y aplicar principios SOLID y arquitectura clean nos permitiría tener un código más fácilmente mantenible y testeable.
