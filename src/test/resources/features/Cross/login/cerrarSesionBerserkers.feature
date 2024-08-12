#language:es
##CREADOR:
##APP: DITO
##MODULO:
##FUNCIONALIDAD:
##ESTADO: ACTIVO
##CODIGO: AT-DT052
##GDAP: GDAP-598
##SPRINT CREADO: PI12_SP
##FRECUENCIA:
##TAG : BERSERKERS
##DATA: REUSABLE
##ENCARGADO:
##FECMOD: 25/05/2024
@BERSERKERS @DoneDevOps @DoneDevOpsPI12 @Sanity28 @DROP-G07
Característica: AT-DT052_Cerrar Sesion - FE DITO WEB

  @CerrarSesionBerserker @CanceloCerrarSesion
  Esquema del escenario: Como usuario <userName> del canal <channelType> deseo cancelar la accion de cerrar sesion
    Dado     que abro la pagina de movistar
    Cuando   presiono el boton Iniciar Sesion
    Y        selecciono el tipo de usuario "<tipoUsuario>"
    Y        ingreso el usuario "<userName>"
    Y        ingreso el password "<password>"
    E        ingreso el captcha
    Y        presiono el boton Continuar hacia el home
    Entonces valido el login exitoso mediante el mensaje "<msgHome>"
    Y        valido que se presente el canal "<channelType>"
    Y        doy click en el icono de Asesor
    Y        doy click en Cerrar Sesion
    Y        doy click en Atras
    Ejemplos:
      | tipoUsuario     | userName    | password | msgHome    | channelType |
      | usuario externo | userNameCC  | passCC   | Bienvenid@ | Call Center |
      | usuario externo | userNameDLC | passDLC  | Bienvenid@ | Retail      |
      | usuario externo | userNameST  | passST   | Bienvenid@ | Tienda      |

  @CerrarSesionBerserker  @CierroSesion
  Esquema del escenario: Como usuario <userName> del canal <channelType> deseo cerrar sesion
    Dado     que abro la pagina de movistar
    Cuando   presiono el boton Iniciar Sesion
    Y        selecciono el tipo de usuario "<tipoUsuario>"
    Y        ingreso el usuario "<userName>"
    Y        ingreso el password "<password>"
    E        ingreso el captcha
    Y        presiono el boton Continuar hacia el home
    Entonces valido el login exitoso mediante el mensaje "<msgHome>"
    Y        valido que se presente el canal "<channelType>"
    Y        doy click en el icono de Asesor
    Y        doy click en Cerrar Sesion
    Y        confirmo Cerrar Sesion
    Ejemplos:
      | tipoUsuario     | userName    | password | msgHome    | channelType |
      | usuario externo | userNameCC  | passCC   | Bienvenid@ | Call Center |
      | usuario externo | userNameDLC | passDLC  | Bienvenid@ | Retail      |
      | usuario externo | userNameST  | passST   | Bienvenid@ | Tienda      |


  @CerrarSesionBerserker  @CierroSesionDespuesConsultar
  Esquema del escenario: Como usuario <userName> del canal <channelType> deseo cerrar sesion despues de consultar el cliente con <tipoDocumento>: <documento>
    Dado     que abro la pagina de movistar
    Cuando   presiono el boton Iniciar Sesion
    Y        selecciono el tipo de usuario "<tipoUsuario>"
    Y        ingreso el usuario "<userName>"
    Y        ingreso el password "<password>"
    E        ingreso el captcha
    Y        presiono el boton Continuar hacia el home
    Entonces valido el login exitoso mediante el mensaje "<msgHome>"
    Y        valido que se presente el canal "<channelType>"
    Cuando   selecciono el tipo de documento "<tipoDocumento>"
    Y        ingreso el documento "<documento>"
    Y        doy click en el boton Consultar
    Y        cierro popup de error
    Y        doy click en el icono de Asesor
    Y        doy click en Cerrar Sesion
    Y        confirmo Cerrar Sesion
    Ejemplos:
      | tipoUsuario     | userName   | password | msgHome    | channelType | tipoDocumento | documento |
      | usuario externo | userNameCC | passCC   | Bienvenid@ | Call Center | DNI           | 41524632  |
      | usuario externo | userNameST | passST   | Bienvenid@ | Tienda      | CE            | 123456735 |
