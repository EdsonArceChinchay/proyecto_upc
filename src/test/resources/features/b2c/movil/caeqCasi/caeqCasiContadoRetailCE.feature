#language:es
##CREADOR:
##APP: DITO
##MODULO: MOVÍL
##FUNCIONALIDAD:
##ESTADO:
##CODIGO: AT-DT049
##GDAP: GDAP-590
##SPRINT CREADO:
##FRECUENCIA:
##TAG : BERSERKERS
##DATA: REUSABLE (CANCELAR ORDENES EN VUELO)
##ENCARGADO:
##FECMOD: 30/09/2024

@BERSERKERS @DoneDevOps @DoneDevOpsPI12
Característica: AT-DT049_Cambio de Equipo (CAEQ) con Cambio de SIM (CASI) a cliente extranjero(CE) por canal Retail

  @CaeqCasi
  Esquema del escenario: Como usuario <userName> del canal <channelType> realizo CAEQ sin CASI a cliente extranjero(CE) por canal Tienda
    Dado     que abro la pagina de movistar
    Cuando   presiono el boton Iniciar Sesion
    Y        selecciono el tipo de usuario "<userType>"
    Y        ingreso el usuario "<userName>"
    Y        ingreso el password "<userPassword>"
    E        ingreso el captcha
    Y        presiono el boton Continuar hacia el home
    Entonces valido el login exitoso mediante el mensaje "<msgHome>"
    Y        valido que se presente el canal "<channelType>"
    Cuando   selecciono el tipo de documento "<documentType>"
    Y        ingreso el documento "<documentNumber>"
    Y        doy click en el boton Consultar
    Y        cierro el popup de contraseña Única
    Y        cierro popup de error
    Y        selecciono el boton Ver detalle del plan actual y presiono el boton Renovar Plan
    Y        valido que se presente la pantalla con el titulo "Ofertas sugeridas"
    Y        presiona el boton anadir equipo del mismo plan
    E        ingreso permanencia, tipo de pago y equipo
      | permanencia | tipoPago   | equipoName |
      | 12 meses    | Al Contado | <device>   |
    Y        valido que existan resultados busqueda de equipos
    Y        presiono el boton Ver detalle valido contenido y selecciono
    Y        cierro el popup de validación de estado de contraseña única
    Y        selecciono boton mantener plan
    Y        valido que este en el resumen de venta
    Y        doy click en el boton Iniciar registro
    Y        ingreso correo electronico "prueba@prueba.com"
    Y        ingreso nuevamente el correo electronico "prueba@prueba.com"
    Y        doy click en Validar contrato "Móvil"
    Y        me muestra en pantalla el contrato solicitado
    Y        imprimo el texto del contrato solicitado
    Cuando   doy clic en si acepto
    Y        valido que CAEQ:"True", CAPL: "False" y CASI:"True" en el response del salesLead
    Y        doy click en el boton Continuar
    Entonces visualizo en pantalla el mensaje de exito del ticket generado
    Y        doy click en ver detalle del pedido
    Y        valido que se muestre el detalle del pedido de "Servicio Móvil"
    Y        valido que se muestre el detalle del pedido de "Información adicional"
    Cuando   regreso a la pagina de inicio
    Entonces valido el login exitoso mediante el mensaje "<msgHome>"
    Y        selecciono el tipo de documento "<documentType>"
    Y        ingreso el documento "<documentNumber>"
    Y        doy click en el boton Consultar
    Y        selecciono la orden
    Y        doy click en el boton continuar
    E        ingreso el codigo de SIMCARD
    E        ingreso el codigo de IMEI de "<device>"
    Y        doy click Validar Stock
    E        ingreso el numero de caja "123456"
    E        ingreso el numero de ticket "654321"
    Y        doy click en el boton confirmar
    Y        doy clic para descargar el contrato
    Y        doy click en el boton Registrar venta
    Entonces visualizo en pantalla el mensaje de exito de la venta generada
    Y        doy click en ver detalle del pedido
    Y        valido que se muestre el detalle del pedido de "Servicio Móvil"
    Y        valido que se muestre el detalle del pedido de "Información adicional"

    Ejemplos:
      | userType | userName    | userPassword    | msgHome    | channelType | documentType | documentNumber | device                            |
      | userType | userNameDLC | userPasswordDLC | Bienvenid@ | Retail      | CE           | 1042465085     | SAMSUNG GXY A34 NEGRO A346M 128GB |
