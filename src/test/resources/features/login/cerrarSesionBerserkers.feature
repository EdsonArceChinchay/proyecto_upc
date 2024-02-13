#language:es
##CREADOR:
##APP: DITO
##MODULO:
##FUNCIONALIDAD:
##ESTADO:
##CODIGO: AT-DT052
##GDAP: GDAP-598
##SPRINT CREADO:
##FRECUENCIA:
##TAG : BERSERKERS
##DATA:
##ENCARGADO:
##FECMOD: 30/03/2023

@BERSERKERS @DoneDevOps @DoneDevOpsPI12 @Sanity28 @DROP-G07
Característica: AT-DT052_Cerrar Sesion - FE DITO WEB

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
      | tipoUsuario     | userName     | password | msgHome    | tiendaAsesor              |
      | usuario externo | userNameCC   | passCC   | Bienvenid@ | PRUEBAS SIST CALLIN VENTA |
      | usuario externo | userNameSTCE | passSTCE | Bienvenid@ | CAJAMARCA                 |
      | usuario externo | userNameCC2  | passCC2  | Bienvenid@ | CAJAMARCA                 |
      | usuario externo | userNameDLC  | passDLC  | Bienvenid@ | CAJAMARCA                 |
      | usuario externo | userNameST   | passST   | Bienvenid@ | TALARA                    |

  @CerrarSesionBerserker  @CierroSesion
  Esquema del escenario: Como usuario <userName> del canal <tiendaAsesor> deseo cerrar sesion
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
      | tipoUsuario     | userName     | password | msgHome    | tiendaAsesor              |
      | usuario externo | userNameCC   | passCC   | Bienvenid@ | PRUEBAS SIST CALLIN VENTA |
      | usuario externo | userNameSTCE | passSTCE | Bienvenid@ | CAJAMARCA                 |
      | usuario externo | userNameCC2  | passCC2  | Bienvenid@ | CAJAMARCA                 |
      | usuario externo | userNameDLC  | passDLC  | Bienvenid@ | CAJAMARCA                 |
      | usuario externo | userNameST   | passST   | Bienvenid@ | TALARA                    |


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
      | tipoUsuario     | userName   | password | msgHome    | tiendaAsesor              | tipoDocumento | documento |
      | usuario externo | userNameCC | passCC   | Bienvenid@ | PRUEBAS SIST CALLIN VENTA | DNI           | 41524632  |
      | usuario externo | userNameST | passST   | Bienvenid@ | CAJAMARCA                 | CE            | 123456735 |
