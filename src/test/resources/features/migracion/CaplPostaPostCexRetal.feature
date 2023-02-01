#language:es
@BERSERKERS @DoneDevOps @DoneDevOpsPI11SP5
Característica: Realizar un CAPL al contado con canal Tienda de un Control a Postpago

  @CaplControlAPostpagoRetail
  Escenario: CAPL Post a Post CEX por canal Retail
    Dado     que abro la pagina de movistar
    Cuando   presiono el boton Iniciar Sesion
    Y        selecciono el tipo de usuario "usuario externo"
    Y        ingreso el usuario "lterrazosce"
    Y        ingreso el password "Telefonica2021"
    Y        presiono el boton Continuar hacia el home
    Entonces valido el login exitoso mediante el mensaje "Bienvenid@"
    Cuando   selecciono el tipo de documento "CE"
    Y        ingreso el documento "1042465085"
    Y        doy click en el boton consultar
    Y        selecciono el boton Ver detalle del plan actual y presiono el boton Renovar Plan
    Entonces valido que se presente la pantalla con el titulo "Ofertas sugeridas"
    Y        selecciono el boton de eleccion de planes Plan Nuevo
    Y        selecciono el tipo "Postpago"
    Y        selecciono el tipo de plan movil "<tipoPlanMovil>"
    Y        selecciono un plan movil "<nombrePlan>"
    Y        selecciono el boton de eleccion de planes
    Y        selecciono el boton de eleccion de planes
    Y        selecciono el plan movil "Postpago"
    Y        selecciono la opcion "RV Plan Ilimitado Mi Movistar S/69.9 II"
    Y        doy click en el boton seleccionar oferta
    Y         doy click en iniciar registro
    Y        ingreso email "qaAutmator@gmail.com" y lo confirmo
    Y        doy clic para validar contrato Movil
    Y        me muestra en pantalla el contrato solicitado
    Cuando   doy clic en si acepto
    Y        doy clic en continuar
    Y        presiono el boton descargar contrato
    Y        presiono el boton Registrar venta
    Entonces visualizo en pantalla el mensaje de exito de la venta generada
    Y        valido que se muestre el detalle del pedido

