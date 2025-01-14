#language:es
##CREADOR:
##APP: DITO
##MODULO:
##FUNCIONALIDAD:
##ESTADO:
##CODIGO: AT-DT052
##GDAP:
##SPRINT CREADO:
##FRECUENCIA:
##TAG: BERSERKERS
##DATA:
##ENCARGADO:
##FECMOD: 09/01/2025

@cambio-clave

Característica: Cambio de contraseña

  @robotQAN @QAN
  Esquema del escenario: Usuario realiza un cambio de su contraseña
    Dado     que abro la pagina de movistar
    Y        ingreso los datos para la bitacora
      | Analista QA   | HU           | Test        | Transaccion          | Tipo Venta | Tags          |
      | Lucero Obispo | TIQLT-JR1220 | TIQLT-17493 | Cambio de contraseña | Contado    | @cambio-clave |
    Cuando   presiono el boton Iniciar Sesion
    Y        selecciono el tipo de usuario "<userType>"
    Y        ingreso el usuario "<userName>"
    Y        ingreso el password "<userPassword>"
    E        ingreso el captcha
    Y        presiono el boton Continuar hacia el home
    Entonces valido el login exitoso mediante el mensaje "<msgHome>"
    Cuando   doy click en el icono de Asesor
    Y        doy click en el boton cambio de contraseña
    Y        ingreso la contraseña actual "<userPassword>"
    Y        ingreso la nueva contraseña "<userNewPassword>"
    Y        confirmo la nueva contraseña "<userNewPassword>"
    Y        doy click en el boton cambiar contraseña
    Entonces visualizo el mensaje de exito en el cambio de contraseña
    Y        presiono el boton entendido
    Ejemplos:
      | userType | userName     | userPassword     | msgHome    | userNewPassword |
      | userType | userNameQAN4 | userPasswordQAN4 | Bienvenid@ | Ntt#98QaT!!jk   |