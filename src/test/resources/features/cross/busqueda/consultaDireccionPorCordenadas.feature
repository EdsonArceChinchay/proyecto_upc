#language:es
##CREADOR: CARLOS RUIZ
##APP: DITO
##MODULO: CROSS
##FUNCIONALIDAD: CONSULTA POR CORDENADAS
##ESTADO: ACTIVO
##CODIGO: AT-DT044
##GDAP: GDAP-600
##SPRINT CREADO:
##FRECUENCIA: DIARIA
##TAG : BERSERKERS
##DATA: REUSABLE
##ENCARGADO: CARLOS RUIZ
##FECMOD: 25/10/2024

@BERSERKERS @DoneDevOps @DoneDevOpsPI12 @Sanity @Sanity28
Característica: AT-DT044_Busqueda de direccion por coordenadas DITO WEB

  @ConsultarDireccionCoordenadas @Coordenadasorrectas @SanityF @DROP-G07
  Esquema del escenario: Como usuario <userName> de la Tienda <channelType> deseo consultar la direccion: <direccion> por coordenadas
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
    Y        ingreso los datos del nuevo cliente
      | nombres | apellidos   | genero   |
      | Ana     | Perez Lopez | femenino |
    Y        selecciono el boton Linea Nueva Hogar
    Y        selecciono el boton Mostrar ofertas
    Entonces me muestra la pantalla para ingresar la direccion
    Y        doy click en el boton "Ingresar coordenadas"
    Y        ingreso las coordenadas de Longitud X: "<longitud>" y Latitud Y:"<latitud>"
    Y        doy click en el boton "Buscar"
    Y        valido que la direccion sea "<direccion>"
    Ejemplos:
      | userType | userName    | userPassword    | msgHome    | channelType | documentType | documentNumber | longitud     | latitud       | direccion                |
      | userType | userNameST  | userPasswordST  | Bienvenid@ | Tienda      | C            | 691529632      | -77.03839379 | -12.08616934  | JULIO CESAR TELLO 460    |
      | userType | userNameDLC | userPasswordDLC | Bienvenid@ | Retail      | C            | 693459354      | -77.03498486 | -12.083588836 | JOSE PARDO DE ZELA 175   |
      | userType | userNameCC  | userPasswordCC  | Bienvenid@ | Call Center | C            | 612345675      | -76.91650597 | -12.02665927  | JOSE CARLOS MARIATEGUI 2 |

  @ConsultarDireccionCoordenadas  @CoordenadasIcorrectas
  Esquema del escenario: Como usuario <userName> de la Tienda <channelType> deseo que me muestre un mensaje de error cuando ingreso coordenadas incorrectas
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
    Y        ingreso los datos del nuevo cliente
      | nombres | apellidos   | genero   |
      | Ana     | Perez Lopez | femenino |
    Y        selecciono el boton Linea Nueva Hogar
    Y        selecciono el boton Mostrar ofertas
    Entonces me muestra la pantalla para ingresar la direccion
    Y        doy click en el boton "Ingresar coordenadas"
    Y        ingreso las coordenadas de Longitud X: "<longitud>" y Latitud Y:"<latitud>"
    Y        doy click en el boton Buscar
    Y        valido que que me muestre el mensajde de error "<mensaje>"

    Ejemplos:
      | userType | userName    | userPassword    | msgHome    | channelType | documentType | documentNumber | longitud     | latitud      | mensaje                                                               |
      | userType | userNameDLC | userPasswordDLC | Bienvenid@ | Retail      | C            | 66783452374    | -77.03498486 | 0-           | LAS COORDENADAS SE ENCUENTRAN FUERA DEL RANGO DE COBERTURA.           |
      | userType | userNameCC  | userPasswordCC  | Bienvenid@ | Call Center | C            | 64512345675    | -70-70       | -12.11851901 | PROBLEMAS EN EL SERVICO, FAVOR DE COMUNICARTE CON EL AREA DE SOPORTE. |
      | userType | userNameST  | userPasswordST  | Bienvenid@ | Tienda      | C            | 64991524632    | .            | 9000         | PROBLEMAS EN EL SERVICO, FAVOR DE COMUNICARTE CON EL AREA DE SOPORTE. |
