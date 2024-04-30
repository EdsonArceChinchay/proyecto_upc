#language:es
##CREADOR:
##APP: DITO
##MODULO:
##FUNCIONALIDAD:
##ESTADO:
##CODIGO: AT-DT072
##GDAP: GDAP-1106
##SPRINT CREADO:
##FRECUENCIA:
##TAG : BERSERKERS
##DATA:
##ENCARGADO: Edwin De la Cruz
##FECMOD: 01/09/2023

@BERSERKERS @DoneDevOps @DoneDevOpsPI14SP3

Característica: AT-DT072_Migracion de Duo a Duo - Actualizar Dirección, por el canal Tienda

  Antecedentes:
    Dado     que abro la pagina de movistar

  @migraDuoDuoActualizarDireccionTiendas
  Esquema del escenario: Migracion de Duo a duo - Actualizar direccion, con CE  sin productos asociados sin biometria
    Cuando   presiono el boton Iniciar Sesion
    Y        selecciono el tipo de usuario "<tipoUsuario>"
    Y        ingreso el usuario "<userName>"
    Y        ingreso el password "<password>"
    E        ingreso el captcha
    Y        presiono el boton Continuar hacia el home
    Y        valido el login exitoso mediante el mensaje "<msgHome>"
    Cuando   selecciono el tipo de documento "<tipoDocumento>"
    Y        ingreso el documento "<documento>"
    Y        doy click en el boton consultar
    Y        selecciono la cartilla del plan activo
    Y        selecciono el boton Mostrar ofertas
    Y        doy click en el boton "Actualizar direccion"
    Y        ingreso la direccion donde sera la instalacion "JULIO CESAR TELLO,469"
    Y        ingreso la referencia de la direccion "Inkafarma"
    Y        presiono el boton Consultar ubicacion
    Y        presiono el boton consultar cobertura
    Y        valido que se presente el siguiente mensaje "Se actualizo la dirección del servicio correctamente"
    Y        doy click en el boton "Entendido"
    Y        selecciono tipo de oferta
    Y        selecciono el tipo de plan Hogar "<tipoPlanHogar>"
    Y        selecciono el plan "<plan>"
    Cuando   doy clic a iniciar registro
    Y        valido que me encuentre en la pantalla agendamiento
    Y        ingreso los datos de agendamiento
    Y        presiono el boton confirmar agendamiento
    Y        ingreso un correo electronico "prueba@prueba.com"
    Y        ingreso nuevamente el correo electronico "prueba@prueba.com"
    Y        doy clic para validar contrato hogar
    Y        me muestra en pantalla el contrato solicitado
    Y        imprimo el texto del contrato solicitado
    Cuando   doy clic en si acepto
    Y        doy click en el boton de continuar
    Y        presiono el boton Registrar venta
    Entonces visualizo en pantalla el mensaje de exito de la venta generada

    Ejemplos:
      | tipoUsuario     | userName  | password     | msgHome    | tipoDocumento | documento  | correo            | tipoPlanHogar | plan               |
      | usuario externo | userNameST | passST | Bienvenid@ | CE            | 1042465127 | tester@tester.com | Duo           | HD RA M23 200 MBPS |