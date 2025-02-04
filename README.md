# Práctica - IMC App

## Primera parte

El IMC (Índice de Masa Corporal) es un valor obtenido mediante la fórmula ``` peso/altura^2 ```, donde
el peso se expresa en kilogramos y la altura en metros. Este valor es un indicador del estado físico
de la persona y, según el rango en el que se ubique, se obtendrá el estado.
Suele ser un cálculo común para hombres y mujeres, pero también se puede diferenciar, cambiando
ligeramente los valores del rango.

|   **ESTADO**  |     **HOMBRES**     |      **MUJERES**      |
|:-------------:|:-------------------:|:---------------------:|
| Peso inferior |      IMC < 18,5     |       IMC < 18,5      |
|     Normal    | 18,5 <= IMC <= 24,9 | 9 18,5 <= IMC <= 23,9 |
|   Sobrepeso   | 25,0 <= IMC <= 29,9 | 9 24,0 <= IMC <= 28,9 |
|    Obesidad   |      IMC > 30,0     |       IMC > 29,0      |

### Qué se pide

Crea un proyecto en Android Studio + Kotlin (API 21 mínimo), para crear una aplicación que
calcule el IMC según los datos dados. Deberá ser totalmente funcional y en una única ```activity```.
El funcionamiento será sencillo, deberá indicarse el peso, en kilogramos, y la altura, en centímetros,
tras pulsar el botón calcular, se mostrará el IMC y el estado obtenido, según sea hombre o mujer. En
caso de encontrarse uno de los campos vacíos, o ambos, se mostrará un ```Toast``` indicando el error.

Para entregar la práctica deberás enviar el directorio completo del proyecto creado en Android
Studio comprimido.

### Cosas a tener en cuenta

- Trata de reproducir el formato mostrado para la UI.
- Comenta el código fuente para que sea comprensible.
- Puedes utilizar el tipo de entrada de datos de los ```EditText``` para facilitar el control de datos.
- Utiliza el fichero de recursos ```strings.xml``` para eliminar warnings de la UI.
- Para conseguir el formato de dos decimales puedes utilizar la clase ```String```.
```
String.format("%.2f", variable)
```

## Segunda parte

Ya dispones de una primera versión de la aplicación MyIMC realizada en la
práctica anterior. Para esta versión 2.0 se añadirá persistencia de datos y un
histórico.

### Qué se pide

Duplica la versión anterior del proyecto (consulta los anexos), para crear la nueva
versión de la aplicación, MyIMCv2. Deberá respetar el funcionamiento de la
primera versión, a la que se añadirán nuevas funcionalidades.
Esta nueva versión deberá ser capaz de registrar cada uno de los IMCs que se
calculen, por tanto, cada vez que se obtenga un IMC, se guardará en un fichero de
texto con el siguiente formato. Fíjate que cada campo está separado por un punto
y coma (“;”).

```
25-11-2020;Mujer;26.31789777279282;Sobrepeso
29-11-2020;Hombre;23.186695666037103;Normal
7-12-2020;Mujer;30.300149901147677;Obesidad
8-12-2020;Hombre;12.046485260770977;Peso inferior al normal
```

Para obtener la fecha puedes hacer uso de la clase ```Calendar``` de la siguiente forma:

```Kotlin
val hoy = Calendar.getInstance()
// ENERO - 0, FEBRERO - 1, ..., DICIEMBRE - 11
Log.d(
  "FECHA",
  "${hoy.get(Calendar.DAY_OF_MONTH)}" +
    "/${hoy.get(Calendar.MONTH) + 1}" +
    "/${hoy.get(Calendar.YEAR)}"
)
```

Este código mostraría en el log de Android Studio la fecha, por ejemplo 9/12/2020. Debes tener en
cuenta la peculiaridad de los meses, se comienza por 0.
La siguiente modificación consistirá en añadir un botón para mostrar el histórico, éste abrirá una
nueva activity que mostrará, mediante un ```RecyclerView```, la información almacenada en el fichero.

Para entregar la práctica deberás enviar el directorio completo del proyecto creado en Android
Studio comprimido.

### Cosas a tener en cuenta

-  Manejo de ficheros de texto.
- Trata de reproducir el formato mostrado para ```RecyclerView```.
- Uso de la barra de desplazamiento vertical en el RV.
- Comenta el código fuente para que sea comprensible.
- Uso de la propiedad ```parent``` para las nuevas activities.
- Uso el fichero de recursos ```strings.xml```.
- Uso de la clase ```Calendar```.
- Para conseguir el formato de dos decimales puedes utilizar la clase ```String```.
```
String.format("%.2f", variable)
```

## Tercera parte

Partiendo de la segunda versión de la aplicación MyIMC realizada en la práctica
anterior. Para esta versión 3.0 se modificará el aspecto y añadirán nuevos
componentes.

### Qué se pide

Duplica la versión anterior del proyecto (consulta los anexos), para crear la nueva
versión de la aplicación, MyIMCv3. Deberá respetar el funcionamiento de la
versión anterior, el cálculo del IMC y la persistencia de la información.
En esta tercera versión, se sustituirán todos los Toast para mostrar la información
al usuario por Snackbars sencillos, que muestre únicamente la información.

Otra modificación que se deberá añadir es la de mostrar un Dialog en el momento
de pulsar el botón “Calcular”, éste preguntará si se quiere o no almacenar la información. El
Dialog contendrá dos botones que actuarán en consecuencia, mostrando un Snackbar tras la
selección hecha, por ejemplo, “La información se ha registrado en el histórico” o “La información
no ha quedado registrada”.

Una modificación más será el uso de CardView en el RecyclerView que ya dispone la aplicación,
además, se mostrarán dos datos más en el histórico, el peso y la altura, teniendo que encontrarse
estos almacenados en el fichero de texto.

Para finalizar, deberás eliminar el botón “Histórico” y modificar el interfaz para que haga uso de
pestañas. Modifica también la versión de la aplicación para que refleje que se trata de la 3.0 en la
información de la aplicación.

Para entregar la práctica deberás enviar el directorio completo del proyecto creado en Android
Studio comprimido.

### Cosas a tener en cuenta

- Aplicación de ```Snackbar```.
- Uso de ```CardView```.
- Uso de ```DialogFragment```.
- Utilización de ```Tabs``` en la aplicación.
- Comenta el código fuente para que sea comprensible.
- Uso el fichero de recursos ```strings.xml```.

NOTA: A la hora de mostrar un ```Dialog```, si utilizas ```DialogFragment```, es posible que necesites
utilizar ```fragmentManager``` en lugar de ```supportFragmentManager``` para mostrar el diálogo.
Dependerá desde donde hagas la llamada.

## Cuarta parte

Partiendo de la tercera versión de la aplicación MyIMC realizada en la práctica
anterior, se creará una versión 4.0 en la que básicamente se cambiará el sistema
de persistencia de los datos.

### Qué se pide

Duplica la versión anterior del proyecto (consulta los anexos), para crear la
nueva versión de la aplicación, MyIMCv4. Deberá respetar el funcionamiento
de la versión anterior, el cálculo del IMC, el funcionamiento de ```tabs```, los
```fragments``` y el listado mediante el ```recycler view```. Deberá mantenerse también el
uso de los ```diálogos``` y ```SnackBars```.

Esta nueva versión sustituirá el uso de un fichero de texto
para almacenar la información, por una base de datos local.
Concretamente se almacenará la información en una única
tabla con los campos identificador, fecha, sexo, imc, peso, altura y estado.

Deberás añadir la posibilidad de eliminar elementos del listado, y por ende, de
la base de datos. Para activar la eliminación, deberás utilizar una pulsación
larga sobre el elemento en cuestión, tras la cual deberá pedirse confirmación, si
se acepta, se borrará, tanto el elemento de la lista como el registro de la base de
datos.

Modifica la versión de la aplicación para que refleje que se trata de la 4.0 en la información de la
aplicación.

Para entregar la práctica deberás enviar el directorio completo del proyecto creado en Android
Studio comprimido.

### Cosas a tener en cuenta

- DB Adapter.
- Eliminar elementos del listado.
- Comenta el código fuente para que sea comprensible.
- Uso el fichero de recursos ```strings.xml```.

NOTA: Para trabajar con el recycler view y, añadir la opción de eliminar, puede resultar más fácil
pasar la información a mostrar de la base de datos a una lista, en vez de utilizar un ```cursor```.

NOTA 2: Debes saber que el método para activar la pulsación larga se llama
```setOnLongClickListener()``` , el cual siempre devolverá un valor bool para indicar si se ha completado
la acción, suele encontrarse con el siguiente formato: ```return@setOnLongClickListener false``` .

NOTA 3: No se ha visto en los apuntes, pero puedes realizar un trabajo de
investigación y optar por el deslizado para eliminar en lugar de la pulsación
larga, o ambos métodos, es opcional. Para el deslizado, como pista, deberá
implementarse la clase ```itemTouchCallbak``` , la cual se implementa fuera del
```adapter``` del ```recycler view```, para después asociársela. Para la eliminación
mediante deslizado no es necesario mostrar el cuadro de diálogo de
confirmación.
