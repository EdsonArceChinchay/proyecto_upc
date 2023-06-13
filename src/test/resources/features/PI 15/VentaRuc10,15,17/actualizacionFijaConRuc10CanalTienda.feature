#language: es
##CREADOR:Eloy Milla
##APP: DITO
##MODULO:
##FUNCIONALIDAD:
##ESTADO:
##CODIGO:
##GDAP: GDAP-1291
##SPRINT CREADO: P15-SP1
##FRECUENCIA:
##TAG : BERSERKERS
##DATA:
##ENCARGADO:Eloy Milla
##FECMOD: 11/04/2023

@BERSERKERS @DoneDevOps @DoneDevOpsPI15
Característica: Actualizacion fija todo los planes con ruc 10 canal Tienda

  Antecedentes:
    Dado     que abro la pagina de movistar

  @ActualizacionRuc10Tienda
  Esquema del escenario: Actualizacion fija todo los planes con ruc 10 canal Tienda
    Cuando   presiono el boton Iniciar Sesion
    Y        selecciono el tipo de usuario "<tipoUsuario>"
    Y        ingreso el usuario "<userName>"
    Y        ingreso el password "<password>"
    Y        presiono el boton Continuar hacia el home
    Y         valido el login exitoso mediante el mensaje "<msgHome>"
    Cuando   selecciono el tipo de documento "<tipoDocumento>"
    Y        ingreso el documento "<documento>"
    Y        doy click en el boton consultar
    Y        selecciono el boton Ver detalle del plan actual y actualizar ruc
    Y        ingreso el ruc "<ruc>" y actualizo
    Y        valido el mensaje de la actualizacion de ruc correcta
    Y        selecciono la cartilla del plan activo


    Ejemplos:
      | tipoUsuario     | userName     | password      | msgHome    | tipoDocumento | documento |ruc     |
      | usuario externo | evillanuevag | $Telefonica2020$ | Bienvenid@ | CE           | 7241133113 |10112233440|