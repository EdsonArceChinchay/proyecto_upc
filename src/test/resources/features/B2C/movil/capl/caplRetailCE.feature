#language: es

##CREADOR: HENRY
##APP: DITO
##MODULO:
##FUNCIONALIDAD:
##ESTADO:
##CODIGO: AT-DT100
##GDAP: GDAP-1249
##SPRINT CREADO: PI14
##FRECUENCIA:
##TAG : BERSERKERS
##DATA:
##ENCARGADO:
##FECMOD: 31/03/2023
@BERSERKERS @DoneDevOps @DoneDevOpsPI14
Característica: AT-DT100_Cambio de plan movil a cliente extranjero (CE) en Canal Retail

  @CambiodeplanmovilCERetail
  Escenario: cambio de plan movil en Retail sin biometria
    Dado     que abro la pagina de movistar
    Cuando   presiono el boton Iniciar Sesion
    Y        selecciono el tipo de usuario "usuario externo"
    Y        ingreso el usuario "userNameDLC"
    Y        ingreso el password "passDLC"
    Y        presiono el boton Continuar hacia el home
    Y        valido el login exitoso mediante el mensaje "Bienvenid@"
    #Y        valido que se presente la tienda "TALARA"
    Cuando   selecciono el tipo de documento "CE"
    Y        ingreso el documento "1042464930"
    Y        doy click en el boton Consultar
    Y        cierro el popup de contraseña Única
    Y        doy click en el boton Ver detalle del servicio "920955629"
    Y        doy click en el boton "Renovar plan"
    Entonces valido que se presente la pantalla con el titulo "Ofertas sugeridas"
    Y        selecciono boton Cambiar plan
    Y        valido que este en el resumen de venta
    Y        doy click en el boton Iniciar registro
    Y        ingreso correo electronico "automation@gmail.com"
    Y        ingreso nuevamente el correo electronico "automation@gmail.com"
    Y        doy clic para validar contrato Movil
    Y        me muestra en pantalla el contrato solicitado
    Y        imprimo el texto del contrato solicitado
    Y        doy clic en si acepto
    Y        valido que CAEQ:"False", CAPL: "True" y CASI:"False" en el response del salesLead
    Y        doy click en el boton de continuar
    Y        presiono el boton Registrar venta
    Entonces visualizo en pantalla el mensaje de exito de la venta generada
    Y        doy click en ver detalle del pedido
    Y        valido que se muestre el detalle del pedido de "Servicio Móvil"
    Y        valido que se muestre el detalle del pedido de "Información adicional"