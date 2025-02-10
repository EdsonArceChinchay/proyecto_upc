#language: es
##CREADOR: HENRY
##APP: DITO
##MODULO: MOVÍL
##FUNCIONALIDAD: CAMBIO DE PLAN (CAPL)
##ESTADO: ACTIVO
##CODIGO: AT-DT099
##GDAP: GDAP-1147
##SPRINT CREADO: PI14
##FRECUENCIA:
##TAG : BERSERKERS
##DATA: REUSABLE (CANCELAR ORDEN EN VUELO)
##ENCARGADO:
##FECMOD: 23/08/2024

@BERSERKERS @DoneDevOps @DoneDevOpsPI14 @CAPL
Característica: AT-DT099_Cambio de plan (CAPL) de Control a Postpago a cliente extranjero (CE) por canal Call Center

  @CaplControlAPostCC_CE
  Esquema del escenario: CAPL de Control a Postpago a cliente extranjero (CE) por canal Call Center
    Dado     que abro la pagina de movistar
    Cuando   presiono el boton Iniciar Sesion
    Y        selecciono el tipo de usuario "<userType>"
    Y        ingreso el usuario "<userName>"
    Y        ingreso el password "<userPassword>"
    Y        ingreso el captcha
    Y        presiono el boton Continuar hacia el home
    Y        valido el login exitoso mediante el mensaje "<msgHome>"
    Y        valido que se presente el canal "<channelType>"
    Cuando   selecciono el tipo de documento "<documentType>"
    Y        ingreso el documento "<documentNumber>"
    Y        doy click en el boton Consultar
    Y        doy click en el boton Ver detalle del servicio "920957608"
    Y        doy click en el boton "Renovar plan"
    Entonces valido que se presente la pantalla con el titulo "Ofertas sugeridas"
    Y        selecciono boton Cambiar plan
    Y        valido que este en el resumen de venta
    Y        doy click en el boton Iniciar registro
    Y        ingreso correo electronico "automation@gmail.com"
    Y        ingreso nuevamente el correo electronico "automation@gmail.com"
    Y        doy click en Validar contrato "Móvil"
    Y        me muestra en pantalla el contrato solicitado
    Y        imprimo el texto del contrato solicitado
    Y        doy clic en si acepto
    Y        valido que CAEQ:"False", CAPL: "True" y CASI:"False" en el response del salesLead
    Y        doy click en el boton de continuar
    Entonces visualizo en pantalla el mensaje de exito de la venta generada
    Y        doy click en ver detalle del pedido
    Y        valido que se muestre el detalle del pedido de "Servicio Móvil"
    Y        valido que se muestre el detalle del pedido de "Información adicional"
    Dado     regreso a la pagina de inicio
    Entonces valido el login exitoso mediante el mensaje "<msgHome>"
    Y        me dirijo a la bandeja de Back Office
    Y        busco por "codigo de venta"
    Y        selecciono la solicitud
    Y        cargo el audio en la web
    Y        apruebo la solicitud
    Ejemplos:

      | userType | userName   | userPassword   | msgHome    | channelType | documentType | documentNumber |
      | userType | userNameCC | userPasswordCC | Bienvenid@ | Call Center | CE           | 1042464725     |


