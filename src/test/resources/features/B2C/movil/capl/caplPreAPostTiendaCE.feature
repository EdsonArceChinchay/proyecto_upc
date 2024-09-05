#language:es
##CREADOR: Angel Medina
##APP: DITO
##MODULO: MOVÍL
##FUNCIONALIDAD: CAMBIO DE PLAN (CAPL)
##ESTADO: ACTIVO
##CODIGO: AT-DT058
##GDAP: GDAP-606
##SPRINT CREADO:
##FRECUENCIA: DIARIO
##TAG : BERSERKERS
##DATA: REUSABLE (CANCELAR ORDEN EN VUELO)
##ENCARGADO: Edwin De la Cruz
##FECMOD: 04/09/2024
@BERSERKERS @DoneDevOps @DoneDevOpsPI11SP5  @CAPL
Característica: AT-DT058_Cambio de plan (CAPL) de Prepago a Postpago a cliente extranjero (CE) por canal Tienda

  @CaplPreAPostTienda_CE  @RegreDito
  Escenario: CAPL de prepago a postpago a cliente extranjero (CE) por canal Tienda
    Dado     que abro la pagina de movistar
    Cuando   presiono el boton Iniciar Sesion
    Y        selecciono el tipo de usuario "usuario externo"
    Y        ingreso el usuario "userNameST"
    Y        ingreso el password "passST"
    Y        ingreso el captcha
    Y        presiono el boton Continuar hacia el home
    Entonces valido el login exitoso mediante el mensaje "Bienvenid@"
    Cuando   selecciono el tipo de documento "CE"
    Y        ingreso el documento "1632547921"
    Y        doy click en el boton Consultar
    #Y        cierro el popup de contraseña Única
    Y        doy click en el boton Ver detalle del servicio "650028178"
    Y        presiono el boton Renovar Plan
    Entonces valido que se presente la pantalla con el titulo "Ofertas sugeridas"
    Y        selecciono el boton de eleccion de planes
    Y        selecciono el tipo de plan movil "Postpago"
    Y        selecciono un plan movil "RV Plan Ilimitado Mi Movistar S/99.9"
    Y        valido que este en el resumen de venta
    Y        doy click en el boton Iniciar registro
    Y        ingreso correo electronico "automation@gmail.com"
    Y        ingreso nuevamente el correo electronico "automation@gmail.com"
    Y        doy click en Validar contrato "Móvil"
    Y        me muestra en pantalla el contrato solicitado
    Y        imprimo el texto del contrato solicitado
    Cuando   doy clic en si acepto
    Y        valido que CAEQ:"False", CAPL: "True" y CASI:"False" en el response del salesLead
    Y        doy click en el boton Continuar
    Y        doy click en el boton Registrar venta
    Entonces visualizo en pantalla el mensaje de exito de la venta generada
    Y        doy click en ver detalle del pedido
    Y        valido que se muestre el detalle del pedido de "Servicio Móvil"
    Y        valido que se muestre el detalle del pedido de "Información adicional"