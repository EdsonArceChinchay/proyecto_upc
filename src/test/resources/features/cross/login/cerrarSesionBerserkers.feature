#language:es
##CREADOR: CARLOS RUIZ
##APP: DITO
##MODULO: CROSS
##FUNCIONALIDAD: CERRAR SESION
##ESTADO: ACTIVO
##CODIGO: AT-DT052
##GDAP: GDAP-598
##SPRINT CREADO: PI12_SP
##FRECUENCIA: DIARIA
##TAG : BERSERKERS
##DATA: REUSABLE
##ENCARGADO: CARLOS RUIZ
##FECMOD: 25/10/2024
@BERSERKERS @DoneDevOps @DoneDevOpsPI12 @Sanity28 @DROP-G07
Característica: AT-DT052_Cerrar Sesion - FE DITO WEB

  @CerrarSesionBerserker @CanceloCerrarSesion
  Esquema del escenario: Como usuario <userName> del canal <channelType> deseo cancelar la accion de cerrar sesion
    Dado     que abro la pagina de movistar
    Cuando   presiono el boton Iniciar Sesion
    Y        selecciono el tipo de usuario "<userType>"
    Y        ingreso el usuario "<userName>"
    Y        ingreso el password "<userPassword>"
    E        ingreso el captcha
    Y        presiono el boton Continuar hacia el home
    Entonces valido el login exitoso mediante el mensaje "<msgHome>"
    Y        valido que se presente el canal "<channelType>"
    Y        doy click en el icono de Asesor
    Y        doy click en Cerrar Sesion
    Y        doy click en Atras
    Ejemplos:
      | userType | userName    | userPassword    | msgHome    | channelType |
      | userType | userNameCC  | userPasswordCC  | Bienvenid@ | Call Center |
      | userType | userNameDLC | userPasswordDLC | Bienvenid@ | Retail      |
      | userType | userNameST  | userPasswordST  | Bienvenid@ | Tienda      |

  @CerrarSesionBerserker  @CierroSesion
  Esquema del escenario: Como usuario <userName> del canal <channelType> deseo cerrar sesion
    Dado     que abro la pagina de movistar
    Cuando   presiono el boton Iniciar Sesion
    Y        selecciono el tipo de usuario "<userType>"
    Y        ingreso el usuario "<userName>"
    Y        ingreso el password "<userPassword>"
    E        ingreso el captcha
    Y        presiono el boton Continuar hacia el home
    Entonces valido el login exitoso mediante el mensaje "<msgHome>"
    Y        valido que se presente el canal "<channelType>"
    Y        doy click en el icono de Asesor
    Y        doy click en Cerrar Sesion
    Y        confirmo Cerrar Sesion
    Ejemplos:
      | userType | userName    | userPassword    | msgHome    | channelType |
      | userType | userNameCC  | userPasswordCC  | Bienvenid@ | Call Center |
      | userType | userNameDLC | userPasswordDLC | Bienvenid@ | Retail      |
      | userType | userNameST  | userPasswordST  | Bienvenid@ | Tienda      |


  @CerrarSesionBerserker  @CierroSesionDespuesConsultar
  Esquema del escenario: Como usuario <userName> del canal <channelType> deseo cerrar sesion despues de consultar el cliente con <documentType>: <documento>
    Dado     que abro la pagina de movistar
    Cuando   presiono el boton Iniciar Sesion
    Y        selecciono el tipo de usuario "<userType>"
    Y        ingreso el usuario "<userName>"
    Y        ingreso el password "<userPassword>"
    E        ingreso el captcha
    Y        presiono el boton Continuar hacia el home
    Entonces valido el login exitoso mediante el mensaje "<msgHome>"
    Y        valido que se presente el canal "<channelType>"
    Cuando   selecciono el tipo de documento "<documentType>"
    Y        ingreso el documento "<documentNumber>"
    Y        doy click en el boton Consultar
    Y        cierro popup de error
    Y        doy click en el icono de Asesor
    Y        doy click en Cerrar Sesion
    Y        confirmo Cerrar Sesion
    Ejemplos:
      | userType | userName   | userPassword   | msgHome    | channelType | documentType | documentNumber |
      | userType | userNameCC | userPasswordCC | Bienvenid@ | Call Center | DNI          | 41524632       |
      | userType | userNameST | userPasswordST | Bienvenid@ | Tienda      | CE           | 123456735      |
