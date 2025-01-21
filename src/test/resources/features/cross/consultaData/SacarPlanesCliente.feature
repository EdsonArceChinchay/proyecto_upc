#language:es
##CREADOR: Jesus Tornero
##APP: DITO
##MODULO:
##FUNCIONALIDAD:
##ESTADO: ACTIVO
##CODIGO:
##GDAP: GDAP-QANJ#1
##SPRINT CREADO:
##FRECUENCIA:
##TAG :
##DATA: REUSABLE
##ENCARGADO: Jesus Tornero
##FECMOD: 01/08/2024

@BERSERKERS @QAN
Característica: Cliente quiere saber que planes tiene

  @ObtenerPlanesCLiente
  Esquema del escenario: Planes del Cliente
    Dado que abro la pagina de movistar
    Y ingreso los datos para la bitacora
      | Analista QA              | HU         | Test       | Transaccion   | Tipo Venta |
      | Jesus Abel Tornero Rojas | TIQLT-XXXX | TIQLT-XXXX | Consulta Data | NA         |
    Cuando presiono el boton Iniciar Sesion
    Y selecciono el tipo de usuario "<TIPO_USUARIO>"
    Y ingreso el usuario "<USER>"
    Y ingreso el password "<PASSWORD>"
    Y ingreso el captcha
    Y presiono el boton Continuar hacia el home
    Entonces valido el login exitoso mediante el mensaje "<TITLE_HOME>"
    Cuando selecciono el tipo documento "<TIPO_DOC>"
    Y ingreso el numero de documento "<NUM_DOC>"
    Y doy click al boton consultar
    Y doy click al boton Cargar Mas
    Y visualizo los planes del cliente
    Ejemplos:
      | TIPO_USUARIO    | USER         | PASSWORD | TITLE_HOME | TIPO_DOC | NUM_DOC  |
      | usuario interno | userNameQAN3 | passQAN3 | Bienvenid@ | DNI      | 43567890 |

  @ObtenerPlanesCLienteMasivo
  Esquema del escenario: Planes del Cliente
    Dado que abro la pagina de movistar
    Y ingreso los datos para la bitacora
      | Analista QA              | HU          | Test       | Transaccion   | Tipo Venta |
      | Jesus Abel Tornero Rojas | TIQLT-JTXXXX | TIQLT-XXXX | Consulta Data | NA         |
    Cuando presiono el boton Iniciar Sesion
    Y selecciono el tipo de usuario "<TIPO_USUARIO>"
    Y ingreso el usuario "<USER>"
    Y ingreso el password "<PASSWORD>"
    Y ingreso el captcha
    Y presiono el boton Continuar hacia el home
    Entonces valido el login exitoso mediante el mensaje "<TITLE_HOME>"
    Y visualizo los planes de "<TIPO_DOCs>" y "<NUM_DOCs>"
    Ejemplos:
      | TIPO_USUARIO | USER         | PASSWORD         | TITLE_HOME | TIPO_DOCs  | NUM_DOCs                           |
      | userType     | userNameQAN1 | userPasswordQAN1 | Bienvenid@ | CE, CE, CE | 1100000248, 1100002366, 1100000942 |