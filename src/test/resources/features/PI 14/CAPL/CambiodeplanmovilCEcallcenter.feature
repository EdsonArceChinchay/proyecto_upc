#language: es

@BERSERKERS @DoneDevOps @DoneDevOpsPI14 @AT-DT099

Característica: cambio de plan movil en call center

  Antecedentes:
    Dado     que abro la pagina de movistar

  @CambiodeplanmovilCEcallcenter

  Escenario: cambio de plan movil en call center sin biometria
    Cuando   presiono el boton Iniciar Sesion
    Y        selecciono el tipo de usuario "usuario externo"
    Y        ingreso el usuario "jpachaot"
    Y        ingreso el password "$t3l3f0n1c4$"
    Y        presiono el boton Continuar hacia el home
    Y        valido el login exitoso mediante el mensaje "Bienvenid@"
    Y        valido que se presente la tienda "CANAL ONLINE-CALL CENTER GSS"
    Cuando   selecciono el tipo de documento "CE"
    Y        ingreso el documento "156128901"
    Y        doy click en el boton consultar
    Y        selecciono el boton Ver detalle del servicio "650023093"
    Y        doy click en el boton "Renovar plan"
    Entonces valido que se presente la pantalla con el titulo "Ofertas sugeridas"
    Y selecciono boton Cambiar plan
    Y  doy click en iniciar registro
    Y        ingreso email "brettavoitteiyu-3241@yopmail.com" y lo confirmo
    Y        doy clic para validar contrato Movil
    Y        me muestra en pantalla el contrato solicitado
    Y  doy clic en si acepto
    Y        doy click en el boton de continuar
    Entonces visualizo en pantalla el mensaje de exito de la venta generada