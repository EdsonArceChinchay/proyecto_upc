#language: es
##CREADOR:Eloy Milla
##APP: DITO
##MODULO:
##FUNCIONALIDAD:
##ESTADO:
##CODIGO:
##GDAP: GDAP-1381
##SPRINT CREADO: P15-SP2
##FRECUENCIA:
##TAG : BERSERKERS
##DATA:
##ENCARGADO:Eloy Milla
##FECMOD: 25/04/2023

@BERSERKERS @DoneDevOps @DoneDevOpsPI15
Característica: Actualizacion fija todo los planes con ruc 15 canal Tienda

  @ActualizacionRuc15Tienda
  Esquema del escenario: Actualizacion fija todo los planes con ruc 15 canal Tienda
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
    Y        cierro el popup de contraseña Única
    Y        selecciono el boton Ver detalle del plan actual y actualizar ruc
    Y        ingreso el ruc "<ruc>" y actualizo
    Y        valido el mensaje de la actualizacion de ruc correcta
    Y        selecciono la cartilla del plan activo
    Ejemplos:
      | userType | userName    | userPassword    | msgHome    | documentType | documentNumber | ruc         |
      | userType | userNameDLC | userPasswordDLC | Bienvenid@ | CE           | 7241133112     | 15112233442 |