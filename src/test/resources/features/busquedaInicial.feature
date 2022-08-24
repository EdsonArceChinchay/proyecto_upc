#language:es
@BERSERKERS @DoneDevOps @DoneDevOpsPI12

Característica: Busqueda Inicial FE DITO WEB

  @BusquedaInicial
  Esquema del escenario: Como usuario <userName> de la Tienda <tiendaAsesor> deseo consultar el <tipoDocumento>: <documento>
    Dado     que abro la pagina de movistar
    Cuando   presiono el boton Iniciar Sesion
    Y        selecciono el tipo de usuario "<tipoUsuario>"
    Y        ingreso el usuario "<userName>"
    Y        ingreso el password "<password>"
    Y        presiono el boton Continuar hacia el home
    Entonces valido el login exitoso mediante el mensaje "<msgHome>"
    Y        valido que se presente la tienda "<tiendaAsesor>"
    Cuando   selecciono el tipo de documento "<tipoDocumento>"
    Y        ingreso el documento "<documento>"
    Y        doy click en el boton consultar
    Y        valido que el nombre del cliente sea "<cliente>" y su "<tipoDoc>" sea "<documento>"
    Y        doy click en el icono de Asesor
    Y        doy click en Cerrar Sesion
    Y        confirmo Cerrar Sesion
    Ejemplos:
      | tipoUsuario     | userName    | password       | msgHome    | tiendaAsesor                 | tipoDocumento | documento | cliente                      | tipoDoc |
      | usuario externo | jpachaot    | $t3l3f0n1c4$   | Bienvenid@ | CANAL ONLINE-CALL CENTER GSs | DNI           | 41524632  | LUIGI GUSTAVO REYNOSO DEXTRE | DNI     |
      | usuario externo | lterrazosce | Telefonica2021 | Bienvenid@ | SAN MIGUEL                   | CE            | 123456735 | Tres De Cinco                | C       |
      | usuario externo | jpachaot    | $t3l3f0n1c4$   | Bienvenid@ | CANAL ONLINE-CALL CENTER GSs | DNI           | 43457947  | CLARIVEL ROMERO BALTAZAR     | DNI     |
      | usuario externo | lterrazosce | Telefonica2021 | Bienvenid@ | SAN MIGUEL                   | CE            | 123211233 | JORGE RAMOS                  | C       |


#  @BusquedaInicial         @BusquedaInicialRUC
#  Esquema del escenario: Como usuario <userName> de la Tienda <tiendaAsesor> deseo consultar el <tipoDocumento>: <documento>
#    Dado     que abro la pagina de movistar
#    Cuando   presiono el boton Iniciar Sesion
#    Y        selecciono el tipo de usuario "<tipoUsuario>"
#    Y        ingreso el usuario "<userName>"
#    Y        ingreso el password "<password>"
#    Y        presiono el boton Continuar hacia el home
#    Entonces valido el login exitoso mediante el mensaje "<msgHome>"
#    Y        valido que se presente la tienda "<tiendaAsesor>"
#    Cuando   selecciono el tipo de documento "<tipoDocumento>"
#    Y        ingreso el documento "<documento>"
#    Y        doy click en el boton Consultar
#    Y        selecciono el ID de Cliente nro "<nro>"
#    Y        valido que el nombre del cliente sea "<cliente>" y su "<tipoDoc>" sea "<documento>"
#    Y        doy click en el icono de Asesor
#    Y        doy click en Cerrar Sesion
#    Y        confirmo Cerrar Sesion
#    Ejemplos:
#      | tipoUsuario     | userName | password     | msgHome    | tiendaAsesor                 | tipoDocumento | documento   | cliente                    | tipoDoc | nro |
#      | usuario externo | jpachaot | $t3l3f0n1c4$ | Bienvenid@ | CANAL ONLINE-CALL CENTER GSs | RUC           | 20409258566 | INVERSIONES PAPER E.I.R.L. | RUC     | 1   |