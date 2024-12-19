#language:es
##CREADOR: CARLOS RUIZ
##APP: DITO
##MODULO: MOVIL
##FUNCIONALIDAD: CASI
##ESTADO: ACTIVO
##CODIGO:AT-DT
##GDAP: GDAP-1658
##SPRINT CREADO: PI18_SP4
##FRECUENCIA: DIARIA
##TAG : BERSERKERS
##DATA:REUSABLE
##ENCARGADO: CARLOS RUIZ
##FECMOD: 11/04/2024

@BERSERKERS @DoneDevOps @PI18_SP4 @RegresionLegacy
Característica: AT-DT _CASI B2B con Representante Legal Extranjero por canal Tienda
  Quiero realizar un CASI a un cliente B2B con parque movil con Representante Legal Extranjero por canal Tienda

  @casiB2B_CETienda
  Esquema del escenario: Cambio de Simcard a un cliente B2B con parque movil con Representante Legal Extranjero por canal Tienda
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
    Cuando   doy click en el boton Ver detalle del servicio "650024739"
    Y        selecciono el boton Cambiar Chip
    Y        cierro pop up de Cliente Exonerado
    Y        valido que este en el resumen de venta
    Cuando   doy click en el boton Iniciar registro
    Y        ingreso correo electronico "<correo>"
    Y        ingreso nuevamente el correo electronico "<correo>"
    Y        doy click en Validar contrato "Móvil"
    Y        me muestra en pantalla el contrato solicitado
    Y        imprimo el texto del contrato solicitado
    Cuando   doy clic en si acepto
    Y        valido que CAEQ:"False", CAPL: "False" y CASI:"True" en el response del salesLead
    Y        doy click en el boton de continuar
    Y        doy clic para descargar el contrato
    Y        doy click en el boton Registrar venta
    Entonces visualizo en pantalla el mensaje de exito de la venta generada
    Y        doy click en ver detalle del pedido
    Y        valido que se muestre el detalle del pedido de "Servicio Móvil"
    Y        valido que se muestre el detalle del pedido de "Información adicional"

    Ejemplos:
      | userType | userName   | userPassword   | msgHome    | channelType | documentType | documentNumber | nro | tipoDocRepLegal | numDocRepLegal | correo              |
      | userType | userNameST | userPasswordST | Bienvenid@ | Tienda      | RUC          | 20521390582    | 2   | CE              | 102040170      | automation@mail.com |
