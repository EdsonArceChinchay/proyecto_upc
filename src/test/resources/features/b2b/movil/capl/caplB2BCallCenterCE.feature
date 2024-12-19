#language:es
##CREADOR: CARLOS RUIZ
##APP: DITO
##MODULO: MOVIL
##FUNCIONALIDAD: CAPL
##ESTADO: ACTIVO
##CODIGO:AT-DT
##GDAP: GDAP-1377
##SPRINT CREADO: PI20_SP1
##FRECUENCIA: DIARIA
##TAG : BERSERKERS
##DATA:REUSABLE
##ENCARGADO: CARLOS RUIZ
##FECMOD: 03/07/2024

@BERSERKERS @DoneDevOps @PI20_SP1 @RegresionLegacy
Característica: AT-DT _CAPL B2B con Representante Legal Extranjero por canal Call Center
  Quiero realizar un CAPL a un cliente B2B con parque movil con Representante Legal Extranjero por canal Call Center

  @caplB2BCallCenterCE
  Esquema del escenario: Cambio de Plan a un cliente B2B con parque movil con Representante Legal Extranjero por canal Call Center
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
    Y        selecciono el ID de Cliente nro "<nro>"
    Y        selecciono el tipo de documento "<tipoDocRepLegal>" del Representante Legal
    E        ingreso el numero de documento "<numDocRepLegal>" del Representante Legal
    Y        doy click en Validar Representa Legal
    Y        cierro el popup de contraseña Única
    Y        cierro popup de error
    Cuando   doy click en el boton Ver detalle del servicio "650030665"
    Y        doy click en el boton "Renovar plan"
    Entonces valido que se presente la pantalla con el titulo "Ofertas sugeridas"
    Y        selecciono el boton de eleccion de planes
    Y        selecciono el tipo de plan movil "Postpago"
    Y        selecciono un plan movil "Plan Elige Todo"
    Y        valido que este en el resumen de venta
    Cuando   doy click en el boton Iniciar registro
    Y        ingreso correo electronico "<correo>"
    Y        ingreso nuevamente el correo electronico "<correo>"
    Y        doy click en Validar contrato "Móvil"
    Y        me muestra en pantalla el contrato solicitado
    Y        imprimo el texto del contrato solicitado
    Cuando   doy clic en si acepto
    Y        valido que CAEQ:"False", CAPL: "True" y CASI:"False" en el response del salesLead
    Y        doy click en el boton Continuar
    Entonces visualizo en pantalla el mensaje de exito de la venta generada
    Y        doy click en ver detalle del pedido
    Y        valido que se muestre el detalle del pedido de "Servicio Móvil"
    Y        valido que se muestre el detalle del pedido de "Información adicional"
    Dado     regreso a la pagina de inicio
    Entonces valido el login exitoso mediante el mensaje "<msgHome>"
    Y        me dirijo a la bandeja de Back Office
    Y        busco por "<documentNumber>"
    Y        selecciono la solicitud
    Y        cargo el audio en la web
    Y        apruebo la solicitud

    Ejemplos:
      | userType | userName   | userPassword   | msgHome    | channelType | documentType | documentNumber | nro | tipoDocRepLegal | numDocRepLegal | correo              |
      | userType | userNameCC | userPasswordCC | Bienvenid@ | Call Center | RUC          | 20510628684    | 1   | CE              | 102040298      | automation@mail.com |
