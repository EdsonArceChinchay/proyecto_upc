#language: es
##CREADOR:Eloy Milla
##APP: DITO
##MODULO:
##FUNCIONALIDAD:
##ESTADO:
##CODIGO:
##GDAP: GDAP-1382
##SPRINT CREADO: P15-SP3
##FRECUENCIA:
##TAG : BERSERKERS
##DATA:
##ENCARGADO:Eloy Milla
##FECMOD: 18/05/2023

@BERSERKERS @DoneDevOps @DoneDevOpsPI15
Característica: Actualizacion fija con ruc 17 canal Tienda

  @ActualizacionRuc17Tienda
  Esquema del escenario: Actualizacion fija todo los planes con ruc 17 canal Tienda
    Dado     que abro la pagina de movistar
    Cuando   presiono el boton Iniciar Sesion
    Y        selecciono el tipo de usuario "<tipoUsuario>"
    Y        ingreso el usuario "<userName>"
    Y        ingreso el password "<password>"
    E        ingreso el captcha
    Y        presiono el boton Continuar hacia el home
    Y        valido el login exitoso mediante el mensaje "<msgHome>"
    Cuando   selecciono el tipo de documento "<tipoDocumento>"
    Y        ingreso el documento "<documento>"
    Y        doy click en el boton Consultar
    Y        cierro el popup de contraseña Única
    Y        selecciono el boton Ver detalle del plan actual y actualizar ruc
    Y        ingreso el ruc "<ruc>", digito verificador "<digito>" y actualizo
    Y        valido el mensaje de la actualizacion de ruc correcta
    Y        selecciono la cartilla del plan activo

    Ejemplos:
      | tipoUsuario     | userName    | password | msgHome    | tipoDocumento | documento | ruc | digito |
      | usuario externo | userNameDLC | passDLC  | Bienvenid@ | DNI           | 70756041  | 17  | 3      |