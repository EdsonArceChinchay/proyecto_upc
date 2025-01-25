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
    Y selecciono el tipo de usuario "<userType>"
    Y ingreso el usuario "<userName>"
    Y ingreso el password "<userPassword>"
    Y ingreso el captcha
    Y presiono el boton Continuar hacia el home
    Entonces valido el login exitoso mediante el mensaje "<msgHome>"
    Cuando selecciono el tipo documento "<documentType>"
    Y ingreso el numero de documento "<documentNumber>"
    Y doy click al boton consultar
    Y cierro popup de error
    Y ingreso los datos del nuevo cliente
      | nombres | apellidos | genero   |
      | Pruebas | Qan       | femenino |
    Y doy click al boton Cargar Mas
    Y visualizo los planes del cliente
    Ejemplos:
      | userType | userName     | userPassword     | msgHome    | documentType | documentNumber |
      | userType | userNameQAN7 | userPasswordQAN7 | Bienvenid@ | DNI          | 43567890       |

  @ObtenerPlanesCLienteMasivo
  Esquema del escenario: Planes del Cliente
    Dado que abro la pagina de movistar
    Y ingreso los datos para la bitacora
      | Analista QA              | HU          | Test        | Transaccion   | Tipo Venta |
      | Jesus Abel Tornero Rojas | TIQLT-25648 | TIQLT-25648 | CONSULTA DATA | NA         |
    Cuando presiono el boton Iniciar Sesion
    Y selecciono el tipo de usuario "<userType>"
    Y ingreso el usuario "<userName>"
    Y ingreso el password "<userPassword>"
    Y ingreso el captcha
    Y presiono el boton Continuar hacia el home
    Entonces valido el login exitoso mediante el mensaje "<msgHome>"
    Y visualizo los planes de "<TIPO_DOCs>" y "<NUM_DOCs>"
    Ejemplos:
      | userType | userName     | userPassword     | msgHome    | TIPO_DOCs | NUM_DOCs                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   |
      | userType | userNameQAN8 | userPasswordQAN8 | Bienvenid@ | CE        | 1100000939, 1100000941, 1100000942, 1100000949, 1100000953, 1100000955, 1100000964, 1100000965, 1100000967, 1100000968, 1100000969, 1100000970, 1100000971, 1100000972, 1100000973, 1100000974, 1100000975, 1100000976, 1100000977, 1100000978, 1100000979, 1100000980, 1100000981, 1100000982, 1100000983, 1100000984, 1100000985, 1100000986, 1100000987, 1100000989, 1100000990, 1100000992, 1100000993, 1100000994, 1100000995, 1100000997, 1100001000, 1100001001, 1100001002, 1100001003, 1100001004, 1100001006, 1100001007, 1100001008, 1100001009, 1100001011, 1100001012, 1100001013, 1100001014, 1100001017, 1100001018, 1100001026, 1100001029, 1100001034, 1100001036, 1100001037, 1100001501, 1100001503, 1100001506, 1100001507, 1100001509, 1100001510, 1100001512, 1100001514, 1100001517, 1100001518, 1100001519, 1100001520, 1100001521, 1100001522, 1100002100, 1100002118, 1100002120, 1100002121, 1100002123, 1100002124, 1100002125, 1100002126, 1100002128, 1100002129, 1100002131, 1100002133, 1100002134, 1100002135, 1100002137, 1100002143, 1100002146, 1100002147, 1100002152, 1100002153, 1100002154, 1100002155, 1100002156, 1100002157, 1100002158, 1100002159, 1100002160, 1100002161, 1100002162, 1100002163, 1100002164, 1100002165, 1100002166, 1100002167, 1100002168 |