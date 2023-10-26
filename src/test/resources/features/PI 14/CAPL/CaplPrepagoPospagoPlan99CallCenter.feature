#language:es

##CREADOR:
##APP: DITO
##MODULO:
##FUNCIONALIDAD:
##ESTADO: REFACTORIZADO 24/08/2023 OK
##CODIGO: AT-DT101
##GDAP: GDAP-962
##SPRINT CREADO:
##FRECUENCIA:
##TAG : BERSERKERS
##DATA:
##ENCARGADO:
##FECMOD: 31/03/2023
@BERSERKERS @DoneDevOps @DoneDevOpsPI11SP5
Característica: AT-DT101_Realizar un CAPL al contado con canal Call Center de un Control a Postpago

  @CaplPrepagoPospago1
  Escenario: CAPL con Caeq al contado con canal Tienda de un Control CE
    Dado     que abro la pagina de movistar
    Cuando   presiono el boton Iniciar Sesion
    Y        selecciono el tipo de usuario "usuario interno"
    Y        ingreso el usuario "echavezloay"
    Y        ingreso el password "Tele#6%vk&a25"
    Y        ingreso el captcha
    Y        presiono el boton Continuar hacia el home
    Entonces valido el login exitoso mediante el mensaje "Bienvenid@"
    Cuando   selecciono el tipo de documento "CE"
    Y        ingreso el documento "1100000776"
    Y        doy click en el boton consultar
    Y        selecciono el boton Ver detalle del plan actual y presiono el boton Renovar Plan
    Entonces valido que se presente la pantalla con el titulo "Ofertas sugeridas"
    Y        selecciono el boton de eleccion de planes
    Y        selecciono el tipo de plan movil "Postpago"
    Y        selecciono un plan movil "RV Plan Ilimitado Mi Movistar S/ 74.9 VI"
    Y        doy click en iniciar registro
    Y        ingreso email "qaAutmator@gmail.com" y lo confirmo
    Y        doy clic para validar contrato Movil
    Y        me muestra en pantalla el contrato solicitado
    Cuando   doy clic en si acepto
    Y        doy clic en continuar
    Y        presiono el boton Registrar venta
    Entonces visualizo en pantalla el mensaje de exito de la venta generada
    Y        valido que se muestre el detalle del pedido


#    1598886623
