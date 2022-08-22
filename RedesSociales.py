# Jose Julian Rodriguez Chagoya
# Estructura de Datos  1358

"""
Hacer un programa que haga lo siguiente:
- Lea el archivo "presenciaredes.csv" (se anexa a la tarea).
- Mostrar en pantalla la diferencia de seguidores (followers) en Twitter entre el mes de enero y junio.
- Permita calcular la diferencia de visualizaciones de
  YouTube entre los meses seleccionados por teclado (enero a junio).
- Calcular el promedio de crecimiento de Twitter y Facebook entre los meses de enero a junio.
"""

import locale
import csv

locale.setlocale(locale.LC_ALL, 'en_US.UTF-8')  # Ajuste de localizacion para los numeros
try:
  archivoCSV = open('presenciaredes.csv', encoding='UTF-8')  # Cargamos el archivo csv en una variable
  lista = list(csv.reader(archivoCSV))  # Lo guardamos en una lista
except FileNotFoundError:
  print("Archivo no encontrado")

# Mostrar la diferencia de seguidores en Twitter entre el mes de Enero y Junio
# Restamos la cantidad de seguidores en Junio con el de Enero para obtener la diferencia
diferencia = int(locale.atof(lista[8][8])) - int(locale.atof(lista[8][3]))
print("La diferencia de seguidores en Twitter entre Enero y Junio es de", diferencia, "seguidores")

# Calcular la diferencia de visualizaciones de YouTube
meses = {"ENERO", "FEBRERO", "MARZO", "ABRIL", "MAYO", "JUNIO"}  # Rango de meses permitidos
mes1 = input("Introduce un mes (Enero a Junio) -> ")
mes2 = input("Intruduce otro mes (Enero a Junio) -> ")
diferencia = 0
if meses.__contains__(mes1.upper()) and meses.__contains__(mes2.upper()):
    for columna in range(3, 9):
        if lista[0][columna] == mes1.upper():
            diferencia += int(locale.atof(lista[16][columna]))
        if lista[0][columna] == mes2.upper():
            diferencia -= int(locale.atof((lista[16][columna])))
    print("La diferencia de visualizacion de Youtube entre " + mes1 + " y " + mes2 + " es de", abs(diferencia))
else:
    print("Ingreso de dato(s) no valido")

# Calcular el promedio de crecimiento de Twitter y Facebook de Enero a Junio
promedioFace = 0
promedioTwitter = 0
for columna in range(3, 9):
    promedioFace += float(locale.atof(lista[2][columna]))
    promedioTwitter += float(locale.atof((lista[9][columna])))
promedioFace /= 6
promedioTwitter /= 6
print("El promedio de crecimiento de Facebook es de {:.1f}".format(promedioFace))
print("EL promedio de crecimiento de Twitter es de {:.1f}".format(promedioTwitter))
