#language:es
##CREADOR: Angel Medina
##APP: DITO
##MODULO: FIJA
##FUNCIONALIDAD: MIGRACION
##ESTADO: ACTIVO
##CODIGO: AT-DT062
##GDAP: GDAP-608
##SPRINT CREADO:
##FRECUENCIA: DIARIO
##TAG : BERSERKERS
##DATA: UNICA VEZ
##ENCARGADO: Angel Medina
##FECMOD: 31/03/2023

@BERSERKERS @DoneDevOps
Característica: AT-DT062_Migracion de Duo HFC Cambio de tegnologia

  @MigracionRucCambioTegnologia @MVP11 @Global @UPC
  Esquema del escenario: Migración con Cambio de Velocidad de dúo 100 Mbps con tecnología HFC a dúo 200mbps, con ruc,en proactivo, con flujo biométrico
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
    Y        selecciono el ID de Cliente nro "<nro>"
    Y        selecciono el tipo de documento "<tipoDocRepLegal>" del Representante Legal
    E        ingreso el numero de documento "<numDocRepLegal>" del Representante Legal
    Y        doy click en Validar Representa Legal
    Y        selecciono la cartilla del plan activo
    Y        selecciono el boton Mostrar ofertas
    Y        selecciono tipo de oferta
    Y        selecciono el tipo de plan Hogar "<tipoPlanHogar>"
    Y        selecciono la oferta "<plan>"

    Ejemplos:
      | userType | userName   | userPassword   | msgHome    | channelType | documentType | documentNumber | nro | tipoDocRepLegal | numDocRepLegal      | tipoPlanHogar | plan                      |
      | userType | userNameCC | userPasswordCC | Bienvenid@ | Call Center | RUC          | 20100323002    | 1   | DNI             | 75447576       | Duo           | DUO MOVISTAR VOZ INTERNET |
