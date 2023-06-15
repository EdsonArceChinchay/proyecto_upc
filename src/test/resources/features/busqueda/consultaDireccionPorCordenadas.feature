#language:es
##CREADOR:
##APP: DITO
##MODULO:
##FUNCIONALIDAD:
##ESTADO:
##CODIGO: AT-DT044
##GDAP: GDAP-600
##SPRINT CREADO:
##FRECUENCIA:
##TAG : BERSERKERS
##DATA:
##ENCARGADO:
##FECMOD: 30/03/2023

@BERSERKERS @DoneDevOps @DoneDevOpsPI12 @Sanity @Sanity28

Característica: AT-DT044_Busqueda de direccion por coordenadas DITO WEB

  @ConsultarDireccionCoordenadas @Coordenadasorrectas @SanityF @DROP-G07
  Esquema del escenario: Como usuario <userName> de la Tienda <tiendaAsesor> deseo consultar la direccion: <direccion> por coordenadas
    Dado     que abro la pagina de movistar
    Cuando   presiono el boton Iniciar Sesion
    Y        selecciono el tipo de usuario "<tipoUsuario>"
    Y        ingreso el usuario "<userName>"
    Y        ingreso el password "<password>"
    Y        presiono el boton Continuar hacia el home
    Entonces valido el login exitoso mediante el mensaje "<msgHome>"
#    Y        valido que se presente la tienda "<tiendaAsesor>"
    Cuando   selecciono el tipo de documento "<tipoDocumento>"
    Y        ingreso el documento "<documento>"
    Y        doy click en el boton consultar
    Y        cierro popup de error
    Y        ingreso los datos del cliente a registrar
      | nombres | apellidos   | genero   |
      | Ana     | Perez Lopez | femenino |
    Y        selecciono el boton Linea Nueva Hogar
    Y        presiono el boton Mostrar ofertas
    Entonces me muestra la pantalla para ingresar la direccion
    Y        doy click en el boton "Ingresar coordenadas"
    Y        ingreso las coordenadas de Longitud X: "<longitud>" y Latitud Y:"<latitud>"
    Y        doy click en el boton "Buscar"
    Y        valido que la direccion sea "<direccion>"
    Ejemplos:
      | tipoUsuario     | userName    | password       | msgHome    | tiendaAsesor                 | tipoDocumento | documento | longitud      | latitud       | direccion                |
      | usuario externo | jpachaot    | $t3l3f0n1c4$   | Bienvenid@ | CANAL ONLINE-CALL CENTER GSs | C             | 691529632 | -77.03498486  | -12.09465486  | CAMINO REAL 155          |
      | usuario externo | evillanuevag | $Telefonica2099% | Bienvenid@ | TIENDA SAN MIGUEL            | C             | 693459354 | -77.03839379  | -12.08616934  | JULIO CESAR TELLO 460    |
 #     | usuario externo | vsiguass    | $t3l3f0n1c4$   | Bienvenid@ | TALARA                       | C             | 642153634 | -77.072328892 | -12.083588836 | CONDESA DE CHINCHON 109  |
      | usuario externo | jpachaot    | $t3l3f0n1c4$   | Bienvenid@ | CAJAMARCA                    | C             | 612345675 | -76.91650597  | -12.02665927  | JOSE CARLOS MARIATEGUI 2 |
 #     | usuario externo | vsiguass    | $t3l3f0n1c4$   | Bienvenid@ | TIENDA SAN MIGUEL            | C             | 699982210 | -77.05523368  | -12.0949854   | JAVIER PRADO OESTE 2291  |
 #     | usuario externo | jpachaot    | $t3l3f0n1c4$   | Bienvenid@ | CANAL ONLINE-CALL CENTER GSs | C             | 691664632 | -77.00525705  | -12.11851901  | AV PRINCIPAL 722           |

  @ConsultarDireccionCoordenadas  @CoordenadasIcorrectas
  Esquema del escenario: Como usuario <userName> de la Tienda <tiendaAsesor> deseo que me muestre un mensaje de error cuando ingreso coordenadas incorrectas
    Dado     que abro la pagina de movistar
    Cuando   presiono el boton Iniciar Sesion
    Y        selecciono el tipo de usuario "<tipoUsuario>"
    Y        ingreso el usuario "<userName>"
    Y        ingreso el password "<password>"
    Y        presiono el boton Continuar hacia el home
    Entonces valido el login exitoso mediante el mensaje "<msgHome>"
#    Y        valido que se presente la tienda "<tiendaAsesor>"
    Cuando   selecciono el tipo de documento "<tipoDocumento>"
    Y        ingreso el documento "<documento>"
    Y        doy click en el boton consultar
    Y        cierro popup de error
    Y        ingreso los datos del cliente a registrar
      | nombres | apellidos   | genero   |
      | Ana     | Perez Lopez | femenino |
    Y        selecciono el boton Linea Nueva Hogar
    Y        presiono el boton Mostrar ofertas
    Entonces me muestra la pantalla para ingresar la direccion
    Y        doy click en el boton "Ingresar coordenadas"
    Y        ingreso las coordenadas de Longitud X: "<longitud>" y Latitud Y:"<latitud>"
    Y        doy click en el boton "Buscar"
    Y        valido que que me muestre el mensajde de error "<mensaje>"
    Y        doy click en el boton "Entendido"
    Ejemplos:
      | tipoUsuario     | userName    | password       | msgHome    | tiendaAsesor                 | tipoDocumento | documento   | longitud     | latitud      | mensaje                                                               |
      | usuario externo | evillanuevag | $Telefonica2099% | Bienvenid@ | TIENDA SAN MIGUEL            | C             | 66783452374 | -77.03498486 | 0-           | LAS COORDENADAS SE ENCUENTRAN FUERA DEL RANGO DE COBERTURA            |
      | usuario externo | vsiguass    | $t3l3f0n1c4$   | Bienvenid@ | TALARA                       | C             | 64802153624 | 12           | -            | PROBLEMAS EN EL SERVICO, FAVOR DE COMUNICARTE CON EL AREA DE SOPORTE. |
     | usuario externo | jpachaot    | $t3l3f0n1c4$   | Bienvenid@ | CAJAMARCA                    | C             | 64512345675 | -70-70       | -12.11851901 | PROBLEMAS EN EL SERVICO, FAVOR DE COMUNICARTE CON EL AREA DE SOPORTE. |
      | usuario externo | jpachaot    | $t3l3f0n1c4$   | Bienvenid@ | CANAL ONLINE-CALL CENTER GSs | C             | 64991524632 | .            | 9000         | PROBLEMAS EN EL SERVICO, FAVOR DE COMUNICARTE CON EL AREA DE SOPORTE. |
