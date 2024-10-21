#language:es
##CREADOR:
##APP: DITO
##MODULO:
##FUNCIONALIDAD:
##ESTADO:
##CODIGO: AT-DT043
##GDAP: GDAP-596
##SPRINT CREADO:
##FRECUENCIA:
##TAG : BERSERKERS
##DATA:
##ENCARGADO:
##FECMOD: 30/03/2023

@BERSERKERS @DoneDevOps @DoneDevOpsPI12 @Sanity28 @DROP-G07
Característica: AT-DT043_Busqueda Inicial CE, DNI y RUC DITO WEB

  @BusquedaInicial @BusquedaInicialB2C
  Esquema del escenario: Como usuario <userName> del canal <channelType> deseo consultar el cliente con <tipoDocumento>: <documento>
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
    Y        valido que el nombre del cliente sea "<cliente>" y su "<tipoDocumento>" sea "<documento>"
    Y        valido que me traiga los servicios contratados por el cliente
    Y        doy click en el icono de Asesor
    Y        doy click en Cerrar Sesion
    Y        confirmo Cerrar Sesion
    Ejemplos:
      | tipoUsuario     | userName    | password | msgHome    | channelType | tipoDocumento | documento | cliente                      |
      | usuario externo | userNameCC  | passCC   | Bienvenid@ | Call Center | DNI           | 41524632  | LUIGI GUSTAVO REYNOSO DEXTRE |
      | usuario externo | userNameST  | passST   | Bienvenid@ | Tienda      | C             | 123456742 | Cuatro De Dos                |
      | usuario externo | userNameDLC | passDLC  | Bienvenid@ | Retail      | C             | 123456753 | Cinco De Tres                |

  @BusquedaInicial         @BusquedaInicialB2B
  Esquema del escenario: Como usuario <userName> de la Tienda <channelType> deseo consultar el cliente con <tipoDocumento>: <documento>
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
    Y        valido que el nombre del cliente sea "<cliente>" y su "<tipoDocumento>" sea "<documento>"
    Y        selecciono el ID de Cliente nro "<nro>"
    Y        selecciono el tipo de documento "<tipoDocRepLegal>" del Representante Legal
    E        ingreso el numero de documento "<numDocRepLegal>" del Representante Legal
    Y        doy click en Validar Representa Legal
    Y        valido que me traiga los servicios contratados por el cliente
    Y        doy click en el icono de Asesor
    Y        doy click en Cerrar Sesion
    Y        confirmo Cerrar Sesion
    Ejemplos:
      | tipoUsuario     | userName   | password | msgHome    | channelType | tipoDocumento | documento   | cliente               | nro | tipoDocRepLegal | numDocRepLegal |
      | usuario externo | userNameCC | passCC   | Bienvenid@ | Call Center | RUC           | 20514559911 | CHIFA HERMANOS S.A.C. | 3   | DNI             | 75447585       |
#      | usuario externo |userNameST | passST | Bienvenid@ | Tienda    | RUC           | 20450685446 | ANDEAN SOUTH EIRL          | 2   | CE              | 6172834231     |
#     | usuario externo |userNameST | passST | Bienvenid@ | Tienda     | RUC           | 20409258566 | INVERSIONES PAPER E.I.R.L. | 1   | DNI             | 75447441       |