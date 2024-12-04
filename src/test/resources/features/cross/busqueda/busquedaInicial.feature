#language:es
##CREADOR: CARLOS RUIZ
##APP: DITO
##MODULO: CROSS
##FUNCIONALIDAD: CONSULTA DE CLIENTES
##ESTADO: ACTIVO
##CODIGO: AT-DT043
##GDAP: GDAP-596
##SPRINT CREADO: PI12
##FRECUENCIA: DIARIA
##TAG : BERSERKERS
##DATA: REUSABLE
##ENCARGADO: CARLOS RUIZ
##FECMOD: 25/10/2024

@BERSERKERS @DoneDevOps @DoneDevOpsPI12 @Sanity28 @DROP-G07
Característica: AT-DT043_Busqueda Inicial CE, DNI y RUC DITO WEB

  @BusquedaInicial @BusquedaInicialB2C
  Esquema del escenario: Como usuario <userName> del canal <channelType> deseo consultar el cliente con <documentType>: <documentNumber>
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
    Y        valido que el nombre del cliente sea "<cliente>" y su "<documentType>" sea "<documentNumber>"
    Y        valido que me traiga los servicios contratados por el cliente
    Y        doy click en el icono de Asesor
    Y        doy click en Cerrar Sesion
    Y        confirmo Cerrar Sesion
    Ejemplos:
      | userType | userName    | userPassword    | msgHome    | channelType | documentType | documentNumber | cliente                      |
      | userType | userNameCC  | userPasswordCC  | Bienvenid@ | Call Center | DNI          | 41524632       | LUIGI GUSTAVO REYNOSO DEXTRE |
      | userType | userNameST  | userPasswordST  | Bienvenid@ | Tienda      | C            | 123456742      | Cuatro De Dos                |
      | userType | userNameDLC | userPasswordDLC | Bienvenid@ | Retail      | C            | 123456753      | Cinco De Tres                |

  @BusquedaInicial         @BusquedaInicialB2B
  Esquema del escenario: Como usuario <userName> de la Tienda <channelType> deseo consultar el cliente con <documentType>: <documentNumber>
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
    Y        valido que el nombre del cliente sea "<cliente>" y su "<documentType>" sea "<documentNumber>"
    Y        selecciono el ID de Cliente nro "<nro>"
    Y        selecciono el tipo de documento "<tipoDocRepLegal>" del Representante Legal
    E        ingreso el numero de documento "<numDocRepLegal>" del Representante Legal
    Y        doy click en Validar Representa Legal
    Y        valido que me traiga los servicios contratados por el cliente
    Y        doy click en el icono de Asesor
    Y        doy click en Cerrar Sesion
    Y        confirmo Cerrar Sesion
    Ejemplos:
      | userType | userName   | userPassword   | msgHome    | channelType | documentType | documentNumber | cliente               | nro | tipoDocRepLegal | numDocRepLegal |
      | userType | userNameCC | userPasswordCC | Bienvenid@ | Call Center | RUC          | 20514559911    | CHIFA HERMANOS S.A.C. | 3   | DNI             | 75447585       |
#      | userType |userNameST |  userPasswordST  | Bienvenid@ | Tienda    | RUC           | 20450685446 | ANDEAN SOUTH EIRL          | 2   | CE              | 6172834231     |
#     | userType |userNameST |  userPasswordST  | Bienvenid@ | Tienda     | RUC           | 20409258566 | INVERSIONES PAPER E.I.R.L. | 1   | DNI             | 75447441       |