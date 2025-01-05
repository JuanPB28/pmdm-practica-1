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

