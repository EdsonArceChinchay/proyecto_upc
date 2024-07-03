#language:es
##CREADOR:
##APP: DITO
##MODULO:
##FUNCIONALIDAD:
##ESTADO:
##CODIGO: AT-DT056
##GDAP: GDAP-597
##SPRINT CREADO:
##FRECUENCIA:
##TAG : BERSERKERS
##DATA:
##ENCARGADO:
##FECMOD: 30/03/2023

@BERSERKERS @DoneDevOps @DoneDevOpsPI11SP5 @Sanity28 @DROP-G07
Característica: AT-DT056_Realizar un CAPL al contado con canal Tienda de un Control a Postpago

  @CaplPorTiendaControlAPostpago
  Escenario: CAPL al contado con canal Tienda de un Control a Postpago exitoso
    Dado     que abro la pagina de movistar
    Cuando   presiono el boton Iniciar Sesion
    Y        selecciono el tipo de usuario "usuario externo"
    Y        ingreso el usuario "userNameST"
    Y        ingreso el password "passST"
    E        ingreso el captcha
    Y        presiono el boton Continuar hacia el home
    Entonces valido el login exitoso mediante el mensaje "Bienvenid@"
    Cuando   selecciono el tipo de documento "CE"
    Y        ingreso el documento "1632547931"
    Y        doy click en el boton consultar
    Y        cierro el popup de contraseña Única
    Y        selecciono el boton Ver detalle del servicio "650028344"
    Y        doy click en el boton "Renovar plan"
    Entonces valido que se presente la pantalla con el titulo "Ofertas sugeridas"
    Y        selecciono el boton de eleccion de planes
    Y        selecciono el tipo de plan movil "Postpago"
    Y        selecciono un plan movil "Plan Ilimitado Mi Movistar S/75.9"
    Y        doy click en iniciar registro
    Y        ingreso email "qaAutmator@gmail.com" y lo confirmo
    Y        doy clic para validar contrato Movil
    Y        me muestra en pantalla el contrato solicitado
    Y        imprimo el texto del contrato solicitado
    Cuando   doy clic en si acepto
    Y        valido que CAEQ:"False", CAPL: "True" y CASI:"False" en el response del salesLead
    Y        doy clic en continuar
    Y        presiono el boton Registrar venta
    Entonces visualizo en pantalla el mensaje de exito de la venta generada


#    1598886623  1598886623
