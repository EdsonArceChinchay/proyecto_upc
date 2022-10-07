#language:es
@BERSERKERS @DoneDevOps @DoneDevOpsPI11SP5
Característica: Realizar un CAPL al contado con canal Tienda de un Control a Postpago

  @CaplPorTiendaControlAPostpago
  Escenario: CAPL con Caeq al contado con canal Tienda de un Control a Postpago exitoso
    Dado     que abro la pagina de movistar
    Cuando   presiono el boton Iniciar Sesion
    Y        selecciono el tipo de usuario "usuario externo"
    Y        ingreso el usuario "lterrazosce"
    Y        ingreso el password "Telefonica2021"
    Y        presiono el boton Continuar hacia el home
    Entonces valido el login exitoso mediante el mensaje "Bienvenid@"
#    Y        valido que se presente la tienda "CAJAMARCA"
    Cuando   selecciono el tipo de documento "CE"
    Y        ingreso el documento "1598886623"
    Y        doy click en el boton consultar
    Y        selecciono el boton Ver detalle del plan actual y presiono el boton Renovar Plan
    Entonces valido que se presente la pantalla con el titulo "Ofertas sugeridas"
#    Y        selecciono el boton de eleccion de planes Plan Nuevo
#    Y        selecciono el tipo "Postpago"
#    Y        selecciono el tipo de plan movil "<tipoPlanMovil>"
#    Y        selecciono un plan movil "<nombrePlan>"
#    Y        selecciono el boton de eleccion de planes
#    Y        selecciono el tipo de plan movil "Postpago"
#    Y        selecciono un plan movil "Plan Ilimitado Mi Movistar S/99.9"
    Y        selecciono el boton de eleccion de planes
#    Y        selecciono el plan movil "Postpago"
#    Y        selecciono la opcion "RV Plan Ilimitado Mi Movistar S/69.9 II"
#    Y        doy click en el boton seleccionar oferta
#    Y        selecciono el nombre del plan "<nombrePlan>"
#    Y         doy click en el boton seleccionar la oferta
    Y        selecciono el tipo de plan movil "Postpago"
    Y        selecciono un plan movil "Plan Ilimitado Mi Movistar S/99.9"
#    Y        selecciono el plan "POSTPAGO" y presiono Seleccionar Oferta
#    Y        valido que se haya seleccionado el plan "Plan Ilimitado Mi Movistar" correctamente
#      Y        presiono la opcion Añadir equipo en el card del plan actual
#      E        ingreso permanencia, tipo de pago y equipo
#               |permanencia    |tipoPago  |equipoName      |
#               |Sin permanencia|Al Contado|HUAWEI P10 NEGRO|
#      Y        presiono el boton Ver detalle valido contenido y selecciono
#    Y        doy click en en el boton "Cambiar Plan"
#    Y        presiono el boton "Cambiar Plan"
#    Y        valido que se presente el detalle de el plan
#      Y        presiono el boton con shadow Iniciar Registro
    Y         doy click en iniciar registro
    Y        ingreso email "qaAutmator@gmail.com" y lo confirmo
#    Y        doy click en validar identidad del titular
#    Y        elijo el tipo de validacion a realizar "discapacitado"
#    Y        ingreso los datos del supervisor
#      | numdoc   | user        | password     |
#      | 42770472 | rdelatorreg | $t3l3f0n1c4$ |
#    Y        ingreso los datos solicitados para la validacion del cliente
#      | nombreMadre | nombrePadre | distritoNac |
#      | NAZARIA     | LUCIO       | RONDOCAN    |
#    Entonces valido que me muestre el boton con el texto de identidad validada
    Y        doy clic para validar contrato Movil
    Y        me muestra en pantalla el contrato solicitado
    Cuando   doy clic en si acepto
    Y        doy clic en continuar
    Y        presiono el boton descargar contrato
    Y        presiono el boton Registrar venta
    Entonces visualizo en pantalla el mensaje de exito de la venta generada
    Y        valido que se muestre el detalle del pedido


#    1598886623
