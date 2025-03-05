# Parcial Práctico 1 - Sección 7

## Instrucciones

1. Haga un _fork_ de este repositorio
2. Clone SU repositorio en SU máquina
3. Abra el proyecto en Visual Studio Code (o en el editor de su preferencia)
4. Lea el enunciado completamente antes de iniciar

## Punto 1 (20%). Persistencia

En este examen usted creara una app de historias clinicas que se usa en la Universidad de los Alpes. Su tarea es crear la funcionalidad básica del sistema, para esto debe crear las siguientes dos entidades:

- (5%) **Paciente**: id, nombre, correo y telefono.
- (5%) **HistoriaClinica**: id, diagnostico(string), tratamiento(string), fechaDeCreación.

Adicionalmente debe garantizar que existan las siguientes relaciones:

- (5%) Cada paciente tiene 0 o más historias clinicas. Cada historia clinica solo tiene 1 paciente.
- (5%) Cada paciente puede o no tener un acudiente. Este acudiente será otro paciente.


## Punto 2 (40%). Lógica

Cree las clases necesarias para implementar los siguientes servicios:

- (13%) Crear un paciente. El télefono del paciente debe ser de 11 dígitos y debe empezar por 311 o por 601.
- (14%) Asociar un acudiente a un paciente dado el id de ambos. El paciente no puede tener ya un acudiente y el acudiente (al ser también un paciente) no puede tener acudiente. Adicionalmente, el acudiente debe tener ya por lo menos una historia clinica creada a su nombre.
- (13%) Crear una historia clinica para un paciente dado su id. Si el paciente tiene acudiente, el diagnostico se debe modificar para que incluya el texto "HistoriaCompartida-" al inicio del valor recibido por párametro.


## Punto 3 (40%). Prueba de lógica

- Haga 2 pruebas para cada método creado en la lógica, una prueba debe enfocarse en el caso positivo y la otra en un caso de excepción. Cada prueba vale 5%.

## Punto 4 (Bono +0.5) API

- Implemente el controlador que permite crear un paciente.

# Entrega

- Cree un release en SU repositorio.
- Envíe el link de su release por bloqueneon.

