#language:es
@BERSERKERS @DoneDevOps @DoneDevOpsPI12

Característica: Cerrar Sesion - FE DITO WEB

  @CerrarSesionBerserker @CanceloCerrarSesion
  Esquema del escenario: Como usuario <userName> de la Tienda <tiendaAsesor> deseo cancelar la accion de cerrar sesion
    Dado     que abro la pagina de movistar
    Cuando   presiono el boton Iniciar Sesion
    Y        selecciono el tipo de usuario "<tipoUsuario>"
    Y        ingreso el usuario "<userName>"
    Y        ingreso el password "<password>"
    Y        presiono el boton Continuar hacia el home
    Entonces valido el login exitoso mediante el mensaje "<msgHome>"
#    Y        valido que se presente la tienda "<tiendaAsesor>"
    Y        doy click en el icono de Asesor
    Y        doy click en Cerrar Sesion
    Y        doy click en Atras
    Ejemplos:
      | tipoUsuario     | userName    | password       | msgHome    | tiendaAsesor                 |
      | usuario externo | jpachaot    | $t3l3f0n1c4$   | Bienvenid@ | CANAL ONLINE-CALL CENTER GSs |
      | usuario externo | lterrazosce | Telefonica2021 | Bienvenid@ | CAJAMARCA                    |
      | usuario externo | vsiguass    | $t3l3f0n1c4$   | Bienvenid@ | CAJAMARCA                    |
      | usuario externo | djormeno    | $t3l3f0n1c4$   | Bienvenid@ | CAJAMARCA                    |
      | usuario externo | nishuizas   | $t3l3f0n1c4$   | Bienvenid@ | TALARA                       |

  @CerrarSesionBerserker  @CierroSesion
  Esquema del escenario: Como usuario <userName> de la Tienda <tiendaAsesor> deseo cerrar sesion
    Dado     que abro la pagina de movistar
    Cuando   presiono el boton Iniciar Sesion
    Y        selecciono el tipo de usuario "<tipoUsuario>"
    Y        ingreso el usuario "<userName>"
    Y        ingreso el password "<password>"
    Y        presiono el boton Continuar hacia el home
    Entonces valido el login exitoso mediante el mensaje "<msgHome>"
#    Y        valido que se presente la tienda "<tiendaAsesor>"
    Y        doy click en el icono de Asesor
    Y        doy click en Cerrar Sesion
    Y        confirmo Cerrar Sesion
    Ejemplos:
      | tipoUsuario     | userName    | password       | msgHome    | tiendaAsesor                 |
      | usuario externo | jpachaot    | $t3l3f0n1c4$   | Bienvenid@ | CANAL ONLINE-CALL CENTER GSs |
      | usuario externo | lterrazosce | Telefonica2021 | Bienvenid@ | CAJAMARCA                    |
      | usuario externo | vsiguass    | $t3l3f0n1c4$   | Bienvenid@ | CAJAMARCA                    |
      | usuario externo | djormeno    | $t3l3f0n1c4$   | Bienvenid@ | CAJAMARCA                    |
      | usuario externo | nishuizas   | $t3l3f0n1c4$   | Bienvenid@ | TALARA                       |


  @CerrarSesionBerserker  @CierroSesionDespuesConsultar
  Esquema del escenario: Como usuario <userName> de la Tienda <tiendaAsesor> deseo cerrar sesion despues de consultar el <tipoDocumento>: <documento>
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
    Y        doy click en el icono de Asesor
    Y        doy click en Cerrar Sesion
    Y        confirmo Cerrar Sesion
    Ejemplos:
      | tipoUsuario     | userName    | password       | msgHome    | tiendaAsesor                 | tipoDocumento | documento |
      | usuario externo | jpachaot    | $t3l3f0n1c4$   | Bienvenid@ | CANAL ONLINE-CALL CENTER GSs | DNI           | 41524632  |
      | usuario externo | lterrazosce | Telefonica2021 | Bienvenid@ | CAJAMARCA                    | CE            | 123456735 |
