#language:es
##CREADOR: CARLOS RUIZ
##APP: DITO
##MODULO: CASI
##FUNCIONALIDAD:
##ESTADO: ACTIVO
##CODIGO:AT-DT
##GDAP: GDAP-
##SPRINT CREADO: PI18_SP4
##FRECUENCIA: DIARIA
##TAG : BERSERKERS
##DATA:REUSABLE
##ENCARGADO: CARLOS RUIZ
##FECMOD: 23/02/2024

@BERSERKERS @DoneDevOps @PI18_SP4 @RegresionLegacy
Característica: AT-DT112_CASI Stand Alone B2B con Representate Legal Extranjero en Canal Tienda
  Quiero realizar un CASI a un cliente B2B con parque movil con Representate Legal Extranjero en Canal Tienda

  @casiB2B_CETienda
  Esquema del escenario: Cambio de Simcard a un cliente B2B con parque movil con Representate Legal Extranjero en Canal Tienda
    Dado     que abro la pagina de movistar
    Cuando   presiono el boton Iniciar Sesion
    Y        selecciono el tipo de usuario "<tipoUsuario>"
    Y        ingreso el usuario "<userName>"
    Y        ingreso el password "<password>"
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
    Cuando   doy clic a iniciar registro
    Y        ingreso un correo electronico "<correo>"
    Y        ingreso nuevamente el correo electronico "<correo>"
#    Y        doy clic en el boton validar identidad representante legal
#    Y        elijo el tipo de validacion a realizar "biometrica"
#    Y        doy click en el boton continuar
#    Y        elijo el tipo de validacion a realizar "discapacitado"
#    Y        ingreso los datos del supervisor
#      | numdoc   | user     | password     |
#      | 73261531 | vsiguass | $t3l3f0n1c4$ |
#    Y        ingreso los datos solicitados para la validacion del cliente
#      | nombreMadre | nombrePadre | distritoNac |
#      | DEISY       | CESAR       | MALA        |
    Y        doy clic para validar contrato Movil
    Y        me muestra en pantalla el contrato solicitado
    Y        imprimo el texto del contrato solicitado
    Y        guardo el numero de solicitud
    Cuando   doy clic en si acepto
    Y        doy clic en continuar
    Y        presiono el boton Registrar venta
    Entonces visualizo en pantalla el mensaje de exito de la venta generada
    Y        doy click en ver detalle del pedido
    Y        valido que se muestre el detalle del pedido del "Servicio Móvil"
    Ejemplos:
      | tipoUsuario     | userName   | password | msgHome    | tipoDocumento | documento   | nro | tipoDocRepLegal | numDocRepLegal | correo            |
      | usuario externo | userNameST | passST   | Bienvenid@ | RUC           | 20521390582 | 2   | CE             | 102040170       | prueba@prueba.com |
