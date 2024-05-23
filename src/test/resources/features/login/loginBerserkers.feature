#language:es
##CREADOR:
##APP: DITO
##MODULO:
##FUNCIONALIDAD:
##ESTADO: ACTIVO
##CODIGO: AT-DT053
##GDAP: GDAP-602
##SPRINT CREADO: PI11_SP
##FRECUENCIA:
##TAG : BERSERKERS
##DATA: NA
##ENCARGADO:
##FECMOD: 13/04/2024

@BERSERKERS @DoneDevOps @DoneDevOpsPI11 @Sanity @Sanity28 @SanityF @DROP-G08
Característica: AT-DT053_Login - FE DITO WEB

  @LoginBerserker @LoginExitoso @jbac_Test
  Esquema del escenario: Usuario realiza login exitoso: canal Call Center, Tienda y Retail
    Dado que abro la pagina de movistar
    Cuando presiono el boton Iniciar Sesion
    Y selecciono el tipo de usuario "<tipoUsuario>"
    Y ingreso el usuario "<userName>"
    Y ingreso el password "<password>"
    E ingreso el captcha
    Y presiono el boton Continuar hacia el home
    Entonces valido el login exitoso mediante el mensaje "<msgHome>"
#    Y valido que se presente la tienda "<tiendaAsesor>"
    Ejemplos:
      | tipoUsuario     | userName    | password | msgHome    | tiendaAsesor      |
      | usuario externo | userNameCC  | passCC   | Bienvenid@ | nameStoreCC       |
      | usuario externo | userNameST  | passST   | Bienvenid@ | TIENDA SAN MIGUEL |
      | usuario externo | userNameDLC | passDLC  | Bienvenid@ | TALARA            |

  @LoginBerserker @LoginCasoNegativo
  Escenario: Login - Caso negativo - Contraseña en blanco
    Dado que abro la pagina de movistar
    Cuando presiono el boton Iniciar Sesion
    Y selecciono el tipo de usuario "usuario externo"
    Y ingreso el usuario "userNameCC"
    Y ingreso el password ""
    E ingreso el captcha
    Y presiono el boton Continuar
    Entonces valido que se presente el mensaje de error "This information is required."

  @LoginBerserker @LoginCasoNegativo
  Escenario: Login - Caso negativo - Usuario en blanco
    Dado que abro la pagina de movistar
    Cuando presiono el boton Iniciar Sesion
    Y selecciono el tipo de usuario "usuario externo"
    Y ingreso el usuario ""
    Y ingreso el password "passCC"
    E ingreso el captcha
    Y presiono el boton Continuar
    Entonces valido que se presente el mensaje de error "This information is required."

  @LoginBerserker @LoginCasoNegativo
  Escenario: Login - Caso negativo - Password incorrecta
    Dado que abro la pagina de movistar
    Cuando presiono el boton Iniciar Sesion
    Y selecciono el tipo de usuario "usuario externo"
    Y ingreso el usuario "userNameCC"
    Y ingreso el password "passDLC"
    E ingreso el captcha
    Y presiono el boton Continuar para intentar el ingreso
    Entonces valido que se presente el mensaje de credenciales incorrectas "Usuario y password incorrecto."


