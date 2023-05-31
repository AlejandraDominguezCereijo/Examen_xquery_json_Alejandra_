Realiza las siguientes consultas en xquery con el fichero premios.xml (repositorio):

(1 punto) Devuelve la frase "[nombre] ha ganado el premio de [categoria] en el año [año]"
let $premios := doc("premios.xml")/premios_nobel/premios/premio
for $premio in $premios
let $nombre := $premio/premiado
let $categoria := $premio/@categoria
let $año := $premio/año
return concat($nombre, ' ha ganado el premio de ', $categoria, ' en el año ', $año)
(1 punto) Una tabla html [categoria] | [premiado] ordenada de mayor a menor por los [años]

```let $premios := doc("premios.xml")/premios_nobel/premios/premio
let $tabla :=
  <table>
    <tr>
      <th>Categoría</th>
      <th>Premiado</th>
    </tr>
    {
      for $premio in $premios
      let $categoria := $premio/@categoria
      let $premiado := $premio/premiado
      let $año := $premio/año
      order by $año descending
      return
        <tr>
          <td>{$categoria}</td>
          <td>{$premiado}</td>
        </tr>
    }
  </table>
return $tabla```

(2 punto) Incluir un nuevo premiado en un nuevo fichero

let $ruta_archivo := "ruta_de_tu_carpeta/segundos_premios.xml"
let $nueva_categoria := "musica"
let $nuevo_año := 2000
let $nuevo_premiado := "imagine dragons"
let $nuevo_motivo := "son muy buenos"

let $nuevo_premio := <premio categoria="{$nueva_categoria}">
                        <año>{$nuevo_año}</año>
                        <premiado>{$nuevo_premiado}</premiado>
                        <motivo>{$nuevo_motivo}</motivo>
                    </premio>
let $nuevo_archivo := <premios_nobel>
                        <premios>{$nuevo_premio}</premios>
                      </premios_nobel>
let $xml_string := serialize($nuevo_archivo, map { "method": "xml", "indent": true() })

xbase:write-file($ruta_archivo, $xml_string)


(2 puntos) Realizar un fichero nuevo incluyendo motivos en los que no tienen

let $ruta_archivo := "ruta_de_tu_carpeta/segundos_premios.xml"
let $nueva_categoria := "musica"
let $nuevo_año := 2000
let $nuevo_premiado := "imagine dragons"
let $nuevo_motivo := "son muy buenos"

let $nuevo_premio :=
  if (not($nuevo_motivo))
  then
    <premio categoria="{$nueva_categoria}">
      <año>{$nuevo_año}</año>
      <premiado>{$nuevo_premiado}</premiado>
    </premio>
  else
    <premio categoria="{$nueva_categoria}">
      <año>{$nuevo_año}</año>
      <premiado>{$nuevo_premiado}</premiado>
      <motivo>{$nuevo_motivo}</motivo>
    </premio>

let $nuevo_archivo :=
  <premios_nobel>
    <premios>
      {$nuevo_premio}
    </premios>
  </premios_nobel>

let $xml_string := serialize($nuevo_archivo, map { "method": "xml", "indent": true() })

xbase:write-file($ruta_archivo, $xml_string)

Realiza una aplicación para usar el fichero employees.json (repositorio)
(2 puntos) Que lea el fichero y guarde los datos en un array list
(2 puntos) Despues de modificar algun datos en el array list que lo vuelva a guardar