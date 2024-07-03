#language:es
##CREADOR: CARLOS RUIZ
##APP: DITO
##MODULO: CASI
##FUNCIONALIDAD:
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
Característica: AT-DT _CASI B2B con Representante Legal Extranjero en Canal Tienda
  Quiero realizar un CASI a un cliente B2B con parque movil con Representante Legal Extranjero en Canal Tienda

  @casiB2B_CETienda
  Esquema del escenario: Cambio de Simcard a un cliente B2B con parque movil con Representante Legal Extranjero en Canal Tienda
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
    Cuando   selecciono el boton Ver detalle del servicio "650024739"
    Y        selecciono el boton Cambiar Chip
    Y        cierro pop up de Cliente Exonerado
    Y        valido que este en resumen de la venta
    Cuando   doy clic a iniciar registro
    Y        ingreso un correo electronico "<correo>"
    Y        ingreso nuevamente el correo electronico "<correo>"
    Y        doy clic para validar contrato Movil
    Y        me muestra en pantalla el contrato solicitado
    Y        imprimo el texto del contrato solicitado
    Cuando   doy clic en si acepto
    Y        valido que CAEQ:"False", CAPL: "False" y CASI:"True" en el response del salesLead
    Y        doy clic en continuar
    Y        presiono el boton Registrar venta
    Entonces visualizo en pantalla el mensaje de exito de la venta generada
    Y        doy click en ver detalle del pedido
    Y        valido que se muestre el detalle del pedido de "Servicio Móvil"

    Ejemplos:
      | tipoUsuario     | userName   | password | msgHome    | tipoDocumento | documento   | nro | tipoDocRepLegal | numDocRepLegal | correo            |
      | usuario externo | userNameST | passST   | Bienvenid@ | RUC           | 20521390582 | 2   | CE              | 102040170      | prueba@prueba.com |
