#language:es
##CREADOR:
##APP: DITO
##MODULO:
##FUNCIONALIDAD:
##ESTADO:
##CODIGO: AT-DT050
##GDAP: GDAP-891
##SPRINT CREADO:
##FRECUENCIA:
##TAG : BERSERKERS
##DATA:
##ENCARGADO:
##FECMOD: 20/05/2024

@BERSERKERS @DoneDevOps @DoneDevOpsPI12
Característica: AT-DT050_CAPL con CAEQ por canal Tienda de un Control a Prepago

  @CaplconCaeqTienda
  Esquema del escenario: CAPL con CAEQ por canal Call Center de un Control a Prepago
    Dado     que abro la pagina de movistar
    Cuando   presiono el boton Iniciar Sesion
    Y        selecciono el tipo de usuario "<tipoUsuario>"
    Y        ingreso el usuario "<userName>"
    Y        ingreso el password "<password>"
    E        ingreso el captcha
    Y        presiono el boton Continuar hacia el home
    #Entonces valido el login exitoso mediante el mensaje "<msgHome>"
    Cuando   selecciono el tipo de documento "CE"
    Y        ingreso el documento "1042465034"
    Y        doy click en el boton Consultar
    Y        selecciono el boton Ver detalle del plan actual y presiono el boton Renovar Plan
    Entonces valido que se presente la pantalla con el titulo "Ofertas sugeridas"
    Y        selecciono el boton de eleccion de planes
    Y        selecciono el plan movil "Prepago"
    Y        selecciono la opcion "Prepago con Tarifa Única"
    Y        doy click en el boton seleccionar oferta
    Y        presiona el boton anadir equipo
    E        ingreso permanencia, tipo de pago y equipo
      | permanencia     | tipoPago   | equipoName               |
      | Sin permanencia | Al Contado | VIVO V21 NEGRO 5G C/PACK |
    Y        presiono el boton Ver detalle valido contenido y selecciono
    Y        cierro pop up de Cliente Exonerado
    Y        doy click en el boton "Cambiar Plan"
    Y        valido que este en el resumen de venta
    Y        valido que este en el resumen de venta
    Y        doy click en el boton Iniciar registro
    Y        ingreso correo electronico "automation@gmail.com"
    Y        ingreso nuevamente el correo electronico "automation@gmail.com"
    Y        doy click en Validar contrato "Móvil"
    Y        me muestra en pantalla el contrato solicitado
    Y        imprimo el texto del contrato solicitado
    Cuando   doy clic en si acepto
    Y        valido que CAEQ:"True", CAPL: "True" y CASI:"False" en el response del salesLead
    Y        doy click en el boton Continuar
    Y        presiono el boton Registrar venta
    Entonces visualizo en pantalla el mensaje de exito de la venta generada
    Y        doy click en ver detalle del pedido
    Y        valido que se muestre el detalle del pedido de "Servicio Móvil"
    Y        valido que se muestre el detalle del pedido de "Información adicional"
    Ejemplos:
      | tipoUsuario     | userName   | password |
      | usuario externo | userNameST | passST   |