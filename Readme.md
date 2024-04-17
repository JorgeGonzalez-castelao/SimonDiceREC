# Simon Dice

Introducción:

En este proyecto, nos sumergiremos en la creación de una versión digital del clásico juego de memoria "Simón Dice". Este juego, que ha entretenido a personas de todas las edades durante décadas, 
desafía tu capacidad para recordar secuencias de colores y sonidos.

Para empezar Creamos las clases Data.kt , MainActivity.kt y MyViewModel en la clase simondicerec

empezamos en el Data, que es donde se incluyen todos los datos para irlos implementando cuando se precise en el viewmodel

# DATA.KT

---

**Data Object Para el juego Simon Dice**

Este objeto `Data` en Kotlin se utiliza para almacenar datos importantes relacionados con el juego "Simón Dice" en Android

- `round`: Número de rondas jugadas.
- `playStatus`: Estado actual del juego (por ejemplo, "Start", "Playing", "GameOver").
- `UserSecuence`: Secuencia de entrada del usuario.
- `botSecuence`: Secuencia generada por el bot del juego.
- `record`: Mejor puntuación del jugador.
- `state`: Estado actual del juego (por ejemplo, `State.START`).
- `colors`: Lista de colores disponibles en el juego.

Estas variables son utilizadas para controlar el flujo del juego, registrar el progreso del jugador y almacenar información relevante para la interfaz de usuario.

--- 

![img_3.png](img_3.png)

- `colorsMyColors`: Una lista de los colores disponibles en el juego, obtenidos a partir de la enumeración `MyColors.values()`.

- `colorFlag`: Una variable que almacena el color de la bandera actual en el juego. Se inicializa con el color blanco (`Color.White`).

- `colorUserFlag`: Una variable que almacena el color de la bandera seleccionada por el usuario. Se inicializa con el color blanco (`Color.White`).

- `enum class MyColors`: Una enumeración que define los colores disponibles en el juego. Cada color tiene asociado un objeto de estado mutable que almacena su valor actual.

Esta estructura proporciona un medio para gestionar y acceder a los colores utilizados en el juego "Simón Dice", permitiendo un control fácil y centralizado sobre la apariencia visual del juego.

---

![img_4.png](img_4.png)



Este enum en Kotlin define los diferentes estados posibles del juego "Simón Dice". Que implementaremos en nuestro ViewModel:

- `START`: Indica el estado inicial del juego, donde se establecen las configuraciones iniciales y se prepara para comenzar.

- `SEQUENCE`: Representa el estado en el que el juego muestra la secuencia de colores generada por el bot o la computadora.

- `WAITING`: Indica que el juego está esperando la entrada del jugador después de mostrar la secuencia.

- `INPUT`: Es el estado en el que el jugador está ingresando su propia secuencia de colores en respuesta a la secuencia mostrada.

- `CHECKING`: Representa el estado en el que el juego está verificando si la secuencia ingresada por el jugador es correcta.

- `FINISH`: Indica que el juego ha terminado, ya sea porque el jugador cometió un error o porque completó con éxito todas las rondas.

Esta enumeración proporciona una estructura clara y fácil de entender para representar los diferentes estados del juego "Simón Dice", lo que facilita el control del flujo del juego y la gestión de las interacciones del usuario.

--- 

![img_5.png](img_5.png)


# MyViewModel

**ViewModel para el Juego "Simón Dice"**

Este ViewModel en Kotlin es responsable de gestionar la lógica del juego "Simón Dice" en una aplicación de Android. Contiene métodos para inicializar el juego, generar números aleatorios, restablecer elementos del juego, gestionar la entrada del usuario, mostrar secuencias, verificar la corrección de la secuencia del usuario y controlar el estado del juego.

**Métodos:**

- `generateRandomNumber(max: Int)`: Genera un número aleatorio dentro del rango especificado.
 
![img_6.png](img_6.png)

- `initGame()`: Inicializa el juego restableciendo los elementos del juego y estableciendo el estado del juego en `State.START` (Inicio).

![img_7.png](img_7.png)

- `resetRound()`: Reinicia la ronda actual a 0.

![img_8.png](img_8.png)

- `resetUserSecuence()`: Borra la secuencia del usuario.

![img_9.png](img_9.png)

- `resetBotSecuence()`: Borra la secuencia del bot.

![img_10.png](img_10.png)

- `increaseShowBotSecuence()`: Aumenta la secuencia del bot, muestra la secuencia al usuario y establece el estado del juego en `State.SEQUENCE` (Secuencia).

![img_11.png](img_11.png)

- `showbotSequence()`: Muestra la secuencia del bot al usuario cambiando los colores de los botones.

![img_13.png](img_13.png)

- `showButtonPressed(color: MutableState<Color>)`: Cambia el color del botón presionado por el usuario y establece el estado del juego en `State.INPUT` (Entrada).

![img_14.png](img_14.png)

- `increaseUserSecuence(color: Int)`: Aumenta la secuencia del usuario con el color proporcionado y establece el estado del juego en `State.INPUT`.

![img_15.png](img_15.png)

- `checkSecuence()`: Verifica si la secuencia del usuario es correcta. Si es correcta, aumenta la ronda y reinicia la secuencia del usuario. Si es incorrecta, termina el juego.

![img_16.png](img_16.png)

- `getRound()`: Devuelve la ronda actual.

![img_17.png](img_17.png)

- `getRecord()`: Devuelve el récord actual.

![img_18.png](img_18.png)

- `changePlayStatus()`: Cambia el estado de juego entre "Start" (Inicio) y "Reset", iniciando o reiniciando el juego según corresponda.

![img_19.png](img_19.png)

- `getPlayStatus()`: Devuelve el estado actual del juego.

![img_20.png](img_20.png)

---

# MainActivity

**MainActivity para el Juego "Simón Dice"**

es la actividad principal de la aplicación "Simón Dice" en Android. Su función principal es iniciar y configurar la interfaz de usuario de la aplicación, así como establecer la conexión con el ViewModel para manejar la lógica del juego.

![img_21.png](img_21.png)

`class MainActivity` : ComponentActivity(): Define la clase MainActivity que extiende ComponentActivity, que es una clase proporcionada por Jetpack Compose para manejar actividades en aplicaciones modernas de Android.

`override fun onCreate(savedInstanceState: Bundle?)`: Método onCreate que se llama cuando se crea la actividad.

`super.onCreate(savedInstanceState)`: Llama al método onCreate de la clase base.

`var myViewModel = MyViewModel()`: Crea una instancia del ViewModel MyViewModel.

`setContent { ... }`: Establece el contenido de la actividad con una estructura de composición de Jetpack Compose.

`SimonDiceRECTheme { ... }`: Aplica el tema SimonDiceRECTheme a la interfaz de usuario.

`Surface { ... }`: Define una superficie como contenedor principal de la interfaz de usuario, con un color de fondo especificado.

`UserInterface(miViewModel = myViewModel)`: Llama al composable UserInterface pasándole el ViewModel myViewModel como parámetro.

![img_22.png](img_22.png)

Este bloque de código define una función de vista previa que muestra cómo se vería la interfaz de usuario en el diseño de diseño de Compose.

---

# MyView

**Myview para el Juego "Simón Dice"**

En esta sección, explicaremos el código que define la interfaz de usuario del juego "Simón Dice" utilizando Jetpack Compose. Este código se encuentra en el archivo MyView.kt y está diseñado para crear la interfaz de usuario del juego y manejar las interacciones del usuario.

UserInterface

![img_23.png](img_23.png)

**README: Interfaz de Usuario en Jetpack Compose**

En esta sección, explicaremos el código que define la interfaz de usuario del juego "Simón Dice" utilizando Jetpack Compose. Este código se encuentra en el archivo `MyView.kt` y está diseñado para crear la interfaz de usuario del juego y manejar las interacciones del usuario.

### Función `UserInterface`

![img_27.png](img_27.png)

- Esta función `UserInterface` es el punto de entrada para la creación de la interfaz de usuario del juego.
- Se compone de tres secciones: `round`, `botonesSimon` y `startIncreaseRound`.
- `miViewModel` es el ViewModel que controla la lógica del juego.

### Función `round`

![img_26.png](img_26.png)

- Esta función representa la sección de la interfaz de usuario que muestra el récord y la ronda actual del juego.
- Utiliza composable de Jetpack Compose para mostrar los datos del ViewModel.

### Función `botonesSimon`

![img_25.png](img_25.png)

- Esta función representa la sección de la interfaz de usuario que muestra los botones de colores para que el usuario interactúe con ellos.
- Utiliza composable de Jetpack Compose para crear y manejar los botones de colores.

### Función `botonesSimon`

![img_28.png](img_28.png)

- Esta función representa un botón de color en la interfaz de usuario del juego "Simón Dice".
- Utiliza un composable Column para colocar el botón en una columna vertical.
- El botón se crea utilizando el composable Button de Jetpack Compose.
- El onClick del botón está configurado para ejecutar ciertas acciones cuando se hace clic en él.
- Llama a los métodos increaseUserSecuence y showButtonPressed del ViewModel para manejar la secuencia del usuario y mostrar el efecto de presionar el botón, respectivamente.

### Función `startIncreaseRound`

![img_24.png](img_24.png)

- Esta función representa la sección de la interfaz de usuario que contiene los botones para iniciar y reiniciar el juego, así como para enviar la secuencia introducida por el usuario.
- Utiliza composable de Jetpack Compose para crear y manejar estos botones.

![img_29.png](img_29.png)

- hace referencia al ícono que se muestra en un botón dentro de la interfaz de usuario del juego "Simón Dice"
- se utiliza para iniciar el juego cuando el estado actual del juego es "Start" o para reanudar el juego cuando el estado es "Reset".
- para acceder a el o cambiarlo iríamos a res
- 
![img_31.png](img_31.png)

- luego al drawable


![img_32.png](img_32.png)

- le daríamos a new y luego new vector asset

- ![img_33.png](img_33.png)

- así quedaría el resultado final

- ![img_34.png](img_34.png)

### Con esto ya temdríamos todo lo necesario para realizar nuestra APP Simon Dice
