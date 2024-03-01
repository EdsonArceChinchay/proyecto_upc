#language:es
##CREADOR: Angel Medina
##APP: DITO
##MODULO:
##FUNCIONALIDAD: CAMBIO
##ESTADO: ACTIVO
##CODIGO: AT-DT058
##GDAP: GDAP-606
##SPRINT CREADO:
##FRECUENCIA: DIARIO
##TAG : BERSERKERS
##DATA: UNICA VEZ
##ENCARGADO: Edwin De la Cruz
##FECMOD: 17/01/2024

@BERSERKERS @DoneDevOps @DoneDevOpsPI11SP5
Característica: AT-DT058_Realizar un CAPL al contado con canal Tienda de un Prepago a Postpago

  @CaplPrepagoPospago @MVP05 @Global @RegreDito
  Escenario: CAPL de prepago a postpago plan S/99.90 con CEX en canal tiendas, web front end, flujo no biométrico
    Dado     que abro la pagina de movistar
    Cuando   presiono el boton Iniciar Sesion
    Y        selecciono el tipo de usuario "usuario externo"
    Y        ingreso el usuario "userNameST"
    Y        ingreso el password "passST"
    Y        presiono el boton Continuar hacia el home
    Entonces valido el login exitoso mediante el mensaje "Bienvenid@"
    Cuando   selecciono el tipo de documento "CE"
    Y        ingreso el documento "71693476"
    Y        doy click en el boton consultar
    #Y        cierro el popup de contraseña Única
    Y        selecciono el boton Ver detalle del plan actual y presiono el boton Renovar Plan
    Y        doy click en Entendido para visualizar las ofertas
    Entonces valido que se presente la pantalla con el titulo "Ofertas sugeridas"
    Y        selecciono el boton de eleccion de planes
    Y        selecciono el tipo de plan movil "Postpago"
    Y        selecciono un plan movil "RV Plan Ilimitado Mi Movistar S/99.9 V"
    Y         doy click en iniciar registro
    Y        ingreso email "qaAutmator@gmail.com" y lo confirmo
    Y        doy clic para validar contrato Movil
    Y        me muestra en pantalla el contrato solicitado
    Cuando   doy clic en si acepto
    Y        doy clic en continuar
    Y        presiono el boton Registrar venta
    Entonces visualizo en pantalla el mensaje de exito de la venta generada