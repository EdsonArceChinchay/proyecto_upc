#language:es
  @BERSERKERS @DoneDevOps @DoneDevOpsPI11

  Característica: Login - FE DITO WEB

    @LoginBerserker @LoginExitoso
    Esquema del escenario: Usuario realiza login exitoso: Canal online - Call center Gss, Tienda San Miguel, Talara
      Dado que abro la pagina de movistar
      Cuando presiono el boton Iniciar Sesion
      Y selecciono el tipo de usuario "<tipoUsuario>"
      Y ingreso el usuario "<userName>"
      Y ingreso el password "<password>"
      Y presiono el boton Continuar hacia el home
      Entonces valido el login exitoso mediante el mensaje "<msgHome>"
      Y valido que se presente la tienda "<tiendaAsesor>"
      Ejemplos:
      |tipoUsuario    |userName    |password      |msgHome   |tiendaAsesor                |
      |usuario externo|jpachaot    |$t3l3f0n1c4$  |Bienvenid@|CANAL ONLINE-CALL CENTER GSs|
      |usuario externo|lterrazosce |Telefonica2021|Bienvenid@|TIENDA SAN MIGUEL           |
      |usuario externo|evillanuevag|$t3l3f0n1c4$  |Bienvenid@|TALARA                      |

    @LoginBerserker @LoginCasoNegativo
    Escenario: Login - Caso negativo - Contraseña en blanco
      Dado que abro la pagina de movistar
      Cuando presiono el boton Iniciar Sesion
      Y selecciono el tipo de usuario "usuario externo"
      Y ingreso el usuario "jpachaot"
      Y ingreso el password ""
      Y presiono el boton Continuar
      Entonces valido que se presente el mensaje de error "This information is required."

    @LoginBerserker @LoginCasoNegativo
    Escenario: Login - Caso negativo - Usuario en blanco
      Dado que abro la pagina de movistar
      Cuando presiono el boton Iniciar Sesion
      Y selecciono el tipo de usuario "usuario externo"
      Y ingreso el usuario ""
      Y ingreso el password "$t3l3f0n1c4$"
      Y presiono el boton Continuar
      Entonces valido que se presente el mensaje de error "This information is required."

    @LoginBerserker @LoginCasoNegativo
    Escenario: Login - Caso negativo - Password incorrecta
      Dado que abro la pagina de movistar
      Cuando presiono el boton Iniciar Sesion
      Y selecciono el tipo de usuario "usuario externo"
      Y ingreso el usuario "jpachaot"
      Y ingreso el password "$t3l3f0n1c4$$"
      Y presiono el boton Continuar para intentar el ingreso
      Entonces valido que se presente el mensaje de credenciales incorrectas "Usuario y password incorrecto."


