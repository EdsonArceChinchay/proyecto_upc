#language:es
##CREADOR:
##APP: DITO
##MODULO:
##FUNCIONALIDAD:
##ESTADO:
##CODIGO: AT-DT051
##GDAP: GDAP-714
##SPRINT CREADO:
##FRECUENCIA:
##TAG : BERSERKERS
##DATA:
##ENCARGADO:
##FECMOD: 30/03/2023

@BERSERKERS @DoneDevOps @DoneDevOpsPI12
Característica: AT-DT051_Realizar CAPL de prepago a postpago con equipo

  @CAPLprepadoApostpago
  Esquema del escenario: CAPL de prepago a postpago por canal TIENDA
    Dado     que abro la pagina de movistar
    Cuando   presiono el boton Iniciar Sesion
    Y        selecciono el tipo de usuario "<tipoUsuario>"
    Y        ingreso el usuario "<userName>"
    Y        ingreso el password "<password>"
    Y        presiono el boton Continuar hacia el home
    #Entonces valido el login exitoso mediante el mensaje "<msgHome>"
    Cuando   selecciono el tipo de documento "CE"
    Y        ingreso el documento "1042465034"
    Y        doy click en el boton consultar
    Y        selecciono el boton Ver detalle del plan actual y presiono el boton Renovar Plan
    Entonces valido que se presente la pantalla con el titulo "Ofertas sugeridas"
    Y        selecciono el boton de eleccion de planes
    Y        selecciono el plan movil "Postpago"
    Y        selecciono la opcion "Plan Ilimitado Mi Movistar S/114.9"
    Y        doy click en el boton seleccionar oferta
    Y        selecciono añadir equipos
    #Y        ingreso el tiempo de permanencia"12 meses"
    #Y        ingreso el tipo de pago "Al Contado"
    #Y        busco el equipo "HUAWEI P10 NEGRO"
    #Y        doy click en el boton seleccionar
    #Y        selecciono el tipo de plan movil "Postpago"
    #Y        selecciono un plan movil "Plan Ilimitado Mi Movistar S/114.9"
    #Y        selecciono el boton de Seleccionar Oferta
    #Y        presiona el boton anadir equipo
    E        ingreso permanencia, tipo de pago y equipo
             |permanencia    |tipoPago  |equipoName      |
             |12 meses       |Al Contado|HUAWEI P10 NEGRO|
    Y        presiono el boton Ver detalle valido contenido y selecciono
    Y        doy click en el boton "Cambiar Plan"
    #Y        presiono el boton "Cambiar Plan"
    Y        valido que se presente el detalle de el plan
    Y         doy click en iniciar registro
    Y        ingreso email "prueba@gmail.com" y lo confirmo
    Y        doy clic para validar contrato Movil
    Y        me muestra en pantalla el contrato solicitado
    Cuando   doy clic en si acepto
    Y        doy clic en continuar
    Y        presiono el boton Registrar venta
    Entonces visualizo en pantalla el mensaje de exito de la venta generada
    #Y        valido que se muestre el detalle del pedido

    Ejemplos:
      | tipoUsuario     | userName | password     |
      | usuario externo | vsiguass | $t3l3f0n1c4$ |