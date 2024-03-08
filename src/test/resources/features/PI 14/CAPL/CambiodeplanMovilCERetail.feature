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

Característica: AT-DT100_cambio de plan movil en Retail

  Antecedentes:
    Dado     que abro la pagina de movistar

  @CambiodeplanmovilCERetail
  Escenario: cambio de plan movil en Retail sin biometria
    Cuando   presiono el boton Iniciar Sesion
    Y        selecciono el tipo de usuario "usuario externo"
    Y        ingreso el usuario "userNameDLC"
    Y        ingreso el password "passDLC"
    Y        presiono el boton Continuar hacia el home
    Y        valido el login exitoso mediante el mensaje "Bienvenid@"
    #Y        valido que se presente la tienda "TALARA"
    Cuando   selecciono el tipo de documento "CE"
    Y        ingreso el documento "1042464930"
    Y        doy click en el boton consultar
    Y        cierro el popup de contraseña Única
    Y        selecciono el boton Ver detalle del servicio "920955629"
    Y        doy click en el boton "Renovar plan"
    Entonces valido que se presente la pantalla con el titulo "Ofertas sugeridas"
    Y        selecciono boton Cambiar plan
    Y        doy click en iniciar registro
    Y        ingreso email "brettavoitteiyu-3241@yopmail.com" y lo confirmo
    Y        doy clic para validar contrato Movil
    Y        me muestra en pantalla el contrato solicitado
    Y        doy clic en si acepto
    Y        doy click en el boton de continuar
    Y        presiono el boton Registrar venta
    Entonces visualizo en pantalla el mensaje de exito de la venta generada
    Y        doy click en ver detalle del pedido
    Y        valido que se muestre el detalle del pedido de "Servicio Móvil"