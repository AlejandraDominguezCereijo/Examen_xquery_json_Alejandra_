Realiza las siguientes consultas en xquery con el fichero premios.xml (repositorio):
(1 punto) Devuelve la frase "[nombre] ha ganado el premio de [categoria] en el año [año]"
let $premios := doc("premios.xml")/premios_nobel/premios/premio
for $premio in $premios
let $nombre := $premio/premiado
let $categoria := $premio/@categoria
let $año := $premio/año
return concat($nombre, ' ha ganado el premio de ', $categoria, ' en el año ', $año)
(1 punto) Una tabla html [categoria] | [premiado] ordenada de mayor a menor por los [años]
(2 punto) Incluir un nuevo premiado en un nuevo fichero
(2 puntos) Realizar un fichero nuevo incluyendo motivos en los que no tienen
Realiza una aplicación para usar el fichero employees.json (repositorio)
(2 puntos) Que lea el fichero y guarde los datos en un array list
(2 puntos) Despues de modificar algun datos en el array list que lo vuelva a guardar