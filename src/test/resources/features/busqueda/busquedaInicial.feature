#language:es
@BERSERKERS @DoneDevOps @DoneDevOpsPI12

Característica: Busqueda Inicial CE, DNI y RUC DITO WEB

  @BusquedaInicial
  Esquema del escenario: Como usuario <userName> de la Tienda <tiendaAsesor> deseo consultar el cliente con <tipoDocumento>: <documento>
    Dado     que abro la pagina de movistar
    Cuando   presiono el boton Iniciar Sesion
    Y        selecciono el tipo de usuario "<tipoUsuario>"
    Y        ingreso el usuario "<userName>"
    Y        ingreso el password "<password>"
    Y        presiono el boton Continuar hacia el home
    Entonces valido el login exitoso mediante el mensaje "<msgHome>"
#   Y        valido que se presente la tienda "<tiendaAsesor>"
    Cuando   selecciono el tipo de documento "<tipoDocumento>"
    Y        ingreso el documento "<documento>"
    Y        doy click en el boton consultar
    Y        valido que el nombre del cliente sea "<cliente>" y su "<tipoDocumento>" sea "<documento>"
    Y        valido que me traiga los servicios contratados por el cliente
    Y        doy click en el icono de Asesor
    Y        doy click en Cerrar Sesion
    Y        confirmo Cerrar Sesion
    Ejemplos:
      | tipoUsuario     | userName    | password       | msgHome    | tiendaAsesor                 | tipoDocumento | documento | cliente                         |
      | usuario externo | jpachaot    | $t3l3f0n1c4$   | Bienvenid@ | CANAL ONLINE-CALL CENTER GSs | DNI           | 41524632  | LUIGI GUSTAVO REYNOSO DEXTRE    |
      | usuario externo | lterrazosce | Telefonica2021 | Bienvenid@ | TIENDA SAN MIGUEL            | C             | 123456742 | Cuatro De Dos                   |
      | usuario externo | vsiguass    | $t3l3f0n1c4$   | Bienvenid@ | TALARA                       | DNI           | 09822102  | JONNY RAUL NAVARRO ESPEJO       |
      | usuario externo | jpachaot    | $t3l3f0n1c4$   | Bienvenid@ | CAJAMARCA                    | C             | 123456753 | Cinco De Tres                   |
      | usuario externo | lterrazosce | Telefonica2021 | Bienvenid@ | TIENDA SAN MIGUEL            | DNI           | 09822100  | GIOVANNA MARIBEL OCOLA ASENCIO  |
      | usuario externo | jpachaot    | $t3l3f0n1c4$   | Bienvenid@ | CANAL ONLINE-CALL CENTER GSs | C             | 123456775 | Primero De Tercero              |
      | usuario externo | vsiguass    | $t3l3f0n1c4$   | Bienvenid@ | TALARA                       | C             | 123456758 | Cinco De Ocho                   |
      | usuario externo | jpachaot    | $t3l3f0n1c4$   | Bienvenid@ | CAJAMARCA                    | DNI           | 09822078  | CARLOS ALBERTO VALDIVIA ALVAREZ |
      | usuario externo | vsiguass    | $t3l3f0n1c4$   | Bienvenid@ | TALARA                       | C             | 123456776 | Primero De Segundo              |

  @BusquedaInicial         @BusquedaInicialRUC
  Esquema del escenario: Como usuario <userName> de la Tienda <tiendaAsesor> deseo consultar el cliente con <tipoDocumento>: <documento>
    Dado     que abro la pagina de movistar
    Cuando   presiono el boton Iniciar Sesion
    Y        selecciono el tipo de usuario "<tipoUsuario>"
    Y        ingreso el usuario "<userName>"
    Y        ingreso el password "<password>"
    Y        presiono el boton Continuar hacia el home
    Entonces valido el login exitoso mediante el mensaje "<msgHome>"
#   Y        valido que se presente la tienda "<tiendaAsesor>"
    Cuando   selecciono el tipo de documento "<tipoDocumento>"
    Y        ingreso el documento "<documento>"
    Y        doy click en el boton Consultar
    Y        valido que el nombre del cliente sea "<cliente>" y su "<tipoDocumento>" sea "<documento>"
    Y        selecciono el ID de Cliente nro "<nro>"
    Y        selecciono el tipo de documento "<tipoDocRepLegal>" del Representante Legal
    E        ingreso el numero del documento "<numDocRepLegal>" del Representante Legal
    Y        doy click en Validar Representa Legal
#    Y        valido que me traiga los servicios contratados por el cliente
#    Y        doy click en el icono de Asesor
#    Y        doy click en Cerrar Sesion
#    Y        confirmo Cerrar Sesion
    Ejemplos:
      | tipoUsuario     | userName    | password       | msgHome    | tiendaAsesor                 | tipoDocumento | documento   | cliente                    | nro | tipoDocRepLegal | numDocRepLegal |
      | usuario externo | jpachaot    | $t3l3f0n1c4$   | Bienvenid@ | CANAL ONLINE-CALL CENTER GSs | RUC           | 20514559911 | CHIFA HERMANOS S.A.C.      | 3   | DNI             | 75447585       |
#      | usuario externo | lterrazosce  | Telefonica2021 | Bienvenid@ | CAJAMARCA                  | RUC           | 20450685446 | ANDEAN SOUTH EIRL          | 2   | CE              | 6172834231     |
      | usuario externo | lterrazosce | Telefonica2021 | Bienvenid@ | TALARA                       | RUC           | 20409258566 | INVERSIONES PAPER E.I.R.L. | 1   | DNI             | 75447441       |


