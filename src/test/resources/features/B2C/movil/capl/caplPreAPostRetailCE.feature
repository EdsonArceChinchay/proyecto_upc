#language: es
##CREADOR: HENRY
##APP: DITO
##MODULO: MOVIL
##FUNCIONALIDAD:  CAMBIO DE PLAN (CAPL)
##ESTADO: ACTIVO
##CODIGO: AT-DT100
##GDAP: GDAP-1249
##SPRINT CREADO: PI14
##FRECUENCIA:
##TAG : BERSERKERS
##DATA:
##ENCARGADO:
##FECMOD: 16/08/2024
@BERSERKERS @DoneDevOps @DoneDevOpsPI14 @CAPL
Característica: AT-DT100_Cambio de plan (CAPL) de Prepago a Postpago a cliente extranjero (CE) por canal Retail

  @CaplPrepAPostRetail_CE
  Escenario: CAPL de Prepago a Postpago a cliente extranjero (CE) por canal Retail
    Dado     que abro la pagina de movistar
    Cuando   presiono el boton Iniciar Sesion
    Y        selecciono el tipo de usuario "usuario externo"
    Y        ingreso el usuario "userNameDLC"
    Y        ingreso el password "passDLC"
    Y        presiono el boton Continuar hacia el home
    Y        valido el login exitoso mediante el mensaje "Bienvenid@"
    Y        valido que se presente el canal "Retail"
    Cuando   selecciono el tipo de documento "CE"
    Y        ingreso el documento "1632547922"
    Y        doy click en el boton Consultar
    Y        cierro el popup de contraseña Única
    Y        doy click en el boton Ver detalle del servicio "650028179"
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
    Y        doy click en el boton Registrar venta
    Entonces visualizo en pantalla el mensaje de exito de la venta generada
    Y        doy click en ver detalle del pedido
    Y        valido que se muestre el detalle del pedido de "Servicio Móvil"
    Y        valido que se muestre el detalle del pedido de "Información adicional"