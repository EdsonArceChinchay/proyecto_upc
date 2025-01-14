#language:es
##CREADOR:
##APP: DITO
##MODULO: CROSS
##FUNCIONALIDAD: LOGIN
##ESTADO: ACTIVO
##CODIGO: AT-DT053
##GDAP: GDAP-602
##SPRINT CREADO: PI11_SP
##FRECUENCIA: DIARIA
##TAG : BERSERKERS
##DATA: NA
##ENCARGADO:
##FECMOD: 25/10/2024

@VISS-8540
@BERSERKERS @DoneDevOps @DoneDevOpsPI11 @Sanity @Sanity28 @SanityF @DROP-G08
Característica: AT-DT053_Login - FE DITO WEB

  @PRR-107
    @LoginBerserker @LoginExitoso @jbac_Test
  Esquema del escenario: Usuario realiza login exitoso por canal <channelType>
    Dado     que abro la pagina de movistar
    Y ingreso los datos para la bitacora
      | Analista QA        | HU           | Test        | Transaccion | Tipo Venta | Tags          |
      | Jefferson Riobueno | TIQLT-JR1220 | TIQLT-17493 | Login       | Contado    | @LoginExitoso |
    Cuando   presiono el boton Iniciar Sesion
    Y        selecciono el tipo de usuario "<userType>"
    Y        ingreso el usuario "<userName>"
    Y        ingreso el password "<userPassword>"
    E        ingreso el captcha
    Y        presiono el boton Continuar hacia el home
    Entonces valido el login exitoso mediante el mensaje "<msgHome>"
#    Y        valido que se presente el canal "<channelType>"
    Ejemplos:
      | userType | userName     | userPassword     | msgHome    | channelType |
      | userType | userNameQAN5 | userPasswordQAN5 | Bienvenid@ | Call Center |
      | userType | userNameQAN5 | userPasswordQAN5 | Bienvenid@ | Tienda      |
      | userType | userNameQAN5 | userPasswordQAN5 | Bienvenid@ | Retail      |

  @LoginBerserker @LoginCasoNegativo
  Escenario: Login - Caso negativo - Contraseña en blanco
    Dado     que abro la pagina de movistar
    Cuando   presiono el boton Iniciar Sesion
    Y        selecciono el tipo de usuario "userType"
    Y        ingreso el usuario "userNameCC"
    Y        ingreso el password ""
    E        ingreso el captcha
    Y        presiono el boton Continuar
    Entonces valido que se presente el mensaje de error "This information is required."

  @LoginBerserker @LoginCasoNegativo
  Escenario: Login - Caso negativo - Usuario en blanco
    Dado     que abro la pagina de movistar
    Cuando   presiono el boton Iniciar Sesion
    Y        selecciono el tipo de usuario "userType"
    Y        ingreso el usuario ""
    Y        ingreso el password "userPasswordCC"
    E        ingreso el captcha
    Y        presiono el boton Continuar
    Entonces valido que se presente el mensaje de error "This information is required."

  @LoginBerserker @LoginCasoNegativo
  Escenario: Login - Caso negativo - Password incorrecta
    Dado     que abro la pagina de movistar
    Cuando   presiono el boton Iniciar Sesion
    Y        selecciono el tipo de usuario "userType"
    Y        ingreso el usuario "userNameCC"
    Y        ingreso el password "userPasswordDLC"
    E        ingreso el captcha
    Y        presiono el boton Continuar
    Entonces valido que se presente el mensaje de credenciales incorrectas "Usuario y password incorrecto."


