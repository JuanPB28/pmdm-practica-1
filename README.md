# Práctica 1 

## IMC App

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
calcule el IMC según los datos dados. Deberá ser totalmente funcional y en una única activity.
El funcionamiento será sencillo, deberá indicarse el peso, en kilogramos, y la altura, en centímetros,
tras pulsar el botón calcular, se mostrará el IMC y el estado obtenido, según sea hombre o mujer. En
caso de encontrarse uno de los campos vacíos, o ambos, se mostrará un Toast indicando el error.

Para entregar la práctica deberás enviar el directorio completo del proyecto creado en Android
Studio comprimido.

### Cosas a tener en cuenta

- Trata de reproducir el formato mostrado para la UI.
- Comenta el código fuente para que sea comprensible.
- Puedes utilizar el tipo de entrada de datos de los EditText para facilitar el control de datos.
- Utiliza el fichero de recursos strings.xml para eliminar warnings de la UI.
- Para conseguir el formato de dos decimales puedes utilizar la clase String.
```
String.format("%.2f", variable)
```
