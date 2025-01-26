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
      | userType | userName     | userPassword     | msgHome    | TIPO_DOCs | NUM_DOCs |
      | userType | userNameQAN8 | userPasswordQAN8 | Bienvenid@ | CE        |          |

  @ObtenerPlanesCLienteMasivoExcel
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
    Y visualizo los planes leyendo la WhiteList
    Ejemplos:
      | userType | userName     | userPassword     | msgHome    |
      | userType | userNameQAN8 | userPasswordQAN8 | Bienvenid@ |

    # Se necesita crear la carpeta Clientes
    # Se necesita el excel con el nobre de WhiteList
    # Clientes/WhiteList.xlsx