#language:es
##CREADOR: CARLOS RUIZ
##APP: DITO
##MODULO: CAPL
##FUNCIONALIDAD:
##ESTADO: ACTIVO
##CODIGO:AT-DT
##GDAP: GDAP-
##SPRINT CREADO: PI20_SP1
##FRECUENCIA: DIARIA
##TAG : BERSERKERS
##DATA:REUSABLE
##ENCARGADO: CARLOS RUIZ
##FECMOD: 02/07/2024

@BERSERKERS @DoneDevOps @PI18_SP4 @RegresionLegacy
Característica: AT-DT _CAPL B2B con Representante Legal Extranjero en Canal Call Center
  Quiero realizar un CAPL a un cliente B2B con parque movil con Representante Legal Extranjero en Canal Call Center

  @caplB2BCallCenterCE
  Esquema del escenario: Cambio de Plan a un cliente B2B con parque movil con Representante Legal Extranjero en Canal Call Center
    Dado     que abro la pagina de movistar
    Cuando   presiono el boton Iniciar Sesion
    Y        selecciono el tipo de usuario "<tipoUsuario>"
    Y        ingreso el usuario "<userName>"
    Y        ingreso el password "<password>"
    E        ingreso el captcha
    Y        presiono el boton Continuar hacia el home
    Entonces valido el login exitoso mediante el mensaje "<msgHome>"
    Cuando   selecciono el tipo de documento "<tipoDocumento>"
    Y        ingreso el documento "<documento>"
    Y        doy click en el boton consultar
    Y        selecciono el ID de Cliente nro "<nro>"
    Y        selecciono el tipo de documento "<tipoDocRepLegal>" del Representante Legal
    E        ingreso el numero del documento "<numDocRepLegal>" del Representante Legal
    Y        doy click en Validar Representa Legal
    Y        cierro el popup de contraseña Única
    Y        cierro popup de error
    Cuando   selecciono el boton Ver detalle del servicio "650028317"
    Y        doy click en el boton "Renovar plan"
    Cuando   doy clic a iniciar registro
    Y        ingreso un correo electronico "<correo>"
    Y        ingreso nuevamente el correo electronico "<correo>"
    Y        doy clic para validar contrato Movil
    Y        me muestra en pantalla el contrato solicitado
    Y        imprimo el texto del contrato solicitado
    Cuando   doy clic en si acepto
    Y        valido que CAEQ:"False", CAPL: "True" y CASI:"False" en el response del salesLead
    Y        doy clic en continuar
    Entonces visualizo en pantalla el mensaje de exito de la venta generada
    Y        doy click en ver detalle del pedido
    Y        valido que se muestre el detalle del pedido de "Servicio Móvil"
    Y        valido que se muestre el detalle del pedido de "Información adicional"
    Dado     regreso a la pagina de inicio
    Entonces valido el login exitoso mediante el mensaje "Bienvenid@"
    Y        me dirijo a la bandeja de Back Office
    Y        busco por "<documento>"
    Y        selecciono la solicitud
    Y        cargo el audio en la web
    Y        apruebo la solicitud

    Ejemplos:
      | tipoUsuario     | userName   | password | msgHome    | tipoDocumento | documento   | nro | tipoDocRepLegal | numDocRepLegal | correo            |
      | usuario externo | userNameCC | passCC   | Bienvenid@ | RUC           | 20480829809 | 1   | CE              | 102040296      | prueba@prueba.com |
