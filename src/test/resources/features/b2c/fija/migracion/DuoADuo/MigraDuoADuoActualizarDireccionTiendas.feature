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

  @migraDuoDuoActualizarDireccionTiendas
  Esquema del escenario: Migracion de Duo a duo - Actualizar direccion, con CE  sin productos asociados sin biometria
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
    Y        selecciono la cartilla del plan activo
    Y        selecciono el boton Mostrar ofertas
    Y        doy click en el boton "Actualizar direccion"
    Y        ingreso la direccion donde sera la instalacion "JULIO CESAR TELLO,469"
    Y        ingreso la referencia de la direccion "Inkafarma"
    Y        presiono el boton Consultar ubicacion
    Y        presiono el boton Consultar cobertura
    Y        valido que se presente el siguiente mensaje "Se actualizo la dirección del servicio correctamente"
    Y        doy click en el boton "Entendido"
    Y        selecciono tipo de oferta
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
    Y        doy click en ver detalle del pedido
    Y        valido que se muestre el detalle del pedido de "Servicio Hogar"
    Y        valido que se muestre el detalle del pedido de "Dirección de instalación"

    Ejemplos:
      | tipoUsuario     | userName   | password | msgHome    | tipoDocumento | documento  | tipoPlanHogar | plan               |
      | usuario externo | userNameST | passST   | Bienvenid@ | CE            | 1042465127 | Duo           | HD RA M23 200 MBPS |