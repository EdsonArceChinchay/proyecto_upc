#language:es

  # CREADOR: Angel Medina

@BERSERKERS @DoneDevOps @DoneDevOpsPI11SP5
Característica: CAPL Prepago a postpago S/99.90 canal tienda

  @CaplPrepagoPospago @MVP05 @Global @General
  Escenario: CAPL de prepago a postpago plan S/99.90 con CEX en canal tiendas,web  front end, flujo no biométrico
    Dado     que abro la pagina de movistar
    Cuando   presiono el boton Iniciar Sesion
    Y        selecciono el tipo de usuario "usuario externo"
    Y        ingreso el usuario "lterrazosce"
    Y        ingreso el password "Telefonica2021"
    Y        presiono el boton Continuar hacia el home
    Entonces valido el login exitoso mediante el mensaje "Bienvenid@"
    Cuando   selecciono el tipo de documento "CE"
    Y        ingreso el documento "1598886623"
    Y        doy click en el boton consultar
    Y        selecciono el boton Ver detalle del plan actual y presiono el boton Renovar Plan
    Entonces valido que se presente la pantalla con el titulo "Ofertas sugeridas"
    Y        selecciono el boton de eleccion de planes
    Y        selecciono el tipo de plan movil "Postpago"
    Y        selecciono un plan movil "Plan Ilimitado Mi Movistar S/99.9"
    Y         doy click en iniciar registro
    Y        ingreso email "qaAutmator@gmail.com" y lo confirmo
    Y        doy clic para validar contrato Movil
    Y        me muestra en pantalla el contrato solicitado
    Cuando   doy clic en si acepto
    Y        doy clic en continuar
    Y        presiono el boton Registrar venta
    Entonces visualizo en pantalla el mensaje de exito de la venta generada
    Y        valido que se muestre el detalle del pedido


#    1598886623
