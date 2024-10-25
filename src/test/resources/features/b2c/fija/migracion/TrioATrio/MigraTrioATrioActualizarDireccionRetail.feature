#language:es
##APP: DITO WEB
##MODULO:
##CREADOR: MOISES LLAMOCA
##GDAP: GDAP-1168
##CODIGO: AT-DT111
##SPRINT CREADO: SP5
##FUNCIONALIDAD: ACTUALIZAR DIRECCION
##FRECUENCIA: NO ESPECIFICA
##TAG: @DITO
##DATA: REUSABLE - SE TIENE QUE VARIAR PARAMETROS DE DIRECCION
##ENCARGADO: MOISES
##FECMOD: 30/03/2023

@BERSERKERS @DoneDevOps @DoneDevOpsPI14SP5
Característica: AT-DT111_Migracion de Trio a Trio - Actualizar Dirección, por el canal Retail

  @migraTrioTrioActualizarDireccionRetail
  Esquema del escenario: Migracion de Trio a Trio - Actualizar direccion, con CE  sin productos asociados sin biometria
    Dado     que abro la pagina de movistar
    Cuando   presiono el boton Iniciar Sesion
    Y        selecciono el tipo de usuario "<userType>"
    Y        ingreso el usuario "<userName>"
    Y        ingreso el password "<userPassword>"
    E        ingreso el captcha
    Y        presiono el boton Continuar hacia el home
    Y        valido el login exitoso mediante el mensaje "<msgHome>"
    Cuando   selecciono el tipo de documento "<documentType>"
    Y        ingreso el documento "<documentNumber>"
    Y        doy click en el boton Consultar
    Y        selecciono la cartilla del plan activo
    Y        selecciono el boton Mostrar ofertas
    Y        verifico la direccion "AV, CORONEL JOSE LEAL, 500, LINCE, LIMA , LIMA, PE" actual del servicio
    Y        doy click en el boton "Actualizar direccion"
    Y        ingreso la direccion donde sera la instalacion "Julio cesar tello 469"
    Y        ingreso la referencia de la direccion "Inkafarma"
    Y        presiono el boton Consultar ubicacion
    Y        presiono el boton Consultar cobertura
    Y        valido que se presente el siguiente mensaje "Se actualizo la dirección del servicio correctamente"
    Y        doy click en el boton "Entendido"
    Y        seleccion plan nuevo para ver las ofertas
    Y        selecciono el tipo de plan Hogar "<tipoPlanHogar>"
    Y        selecciono el plan "<plan>"
    Cuando   doy click en el boton Iniciar registro
    Y        valido que me encuentre en la pantalla agendamiento
    Y        ingreso los datos de agendamiento
    Y        presiono el boton confirmar agendamiento
    Y        ingreso correo electronico "prueba@prueba.com"
    Y        ingreso nuevamente el correo electronico "prueba@prueba.com"
    Y        doy click en Validar contrato "hogar"
    Y        me muestra en pantalla el contrato solicitado
    Y        imprimo el texto del contrato solicitado
    Cuando   doy clic en si acepto
    Y        doy click en el boton de continuar
    Y        doy clic para descargar el contrato
    Y        doy click en el boton Registrar venta
    Entonces visualizo en pantalla el mensaje de exito de la venta generada

    Ejemplos:
      | userType     | userName    | userPassword    | msgHome    | documentType | documentNumber | tipoPlanHogar | plan                                               |
      | externalUser | userNameDLC | userPasswordDLC | Bienvenid@ | CE           | 1042464835     | Trio          | TRÍO MOV. VOZ INTERNET ESTANDAR HD RA D22 100 MBPS |
