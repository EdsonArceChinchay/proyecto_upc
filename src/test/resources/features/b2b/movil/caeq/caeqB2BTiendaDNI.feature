#language:es
##CREADOR: CARLOS RUIZ
##APP: DITO
##MODULO:  MOVIL
##FUNCIONALIDAD: CAEQ
##ESTADO: ACTIVO
##CODIGO:AT-DT
##GDAP: GDAP-579
##SPRINT CREADO: PI20_SP1
##FRECUENCIA: DIARIA
##TAG : BERSERKERS
##DATA:REUSABLE
##ENCARGADO: CARLOS RUIZ
##FECMOD: 04/07/2024
@BERSERKERS @DoneDevOps @PI20_SP1 @RegresionLegacy
Característica: AT-DT _CAEQ B2B con Representante Legal Nacional en Canal Tienda
  Quiero realizar un CAEQ a un cliente B2B con parque movil con Representante Legal Nacional en Canal Tienda

  @caeqB2BTiendaDNI
  Esquema del escenario: Cambio de equipo a un cliente B2B con parque movil con Representante Legal Nacional en Canal Tienda
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
    Cuando   doy click en el boton Ver detalle del servicio "920959541"
    Y        doy click en el boton "Renovar plan / Equipo"
    Entonces valido que se presente la pantalla con el titulo "Ofertas sugeridas"
    Y        presiona el boton anadir equipo del mismo plan
    E        ingreso permanencia, tipo de pago y equipo
      | permanencia | tipoPago   | equipoName                        |
      | 12 meses    | Al Contado | SAMSUNG GXY A34 NEGRO A346M 128GB |
    Y        valido que existan resultados busqueda de equipos
    Y        presiono el boton Ver detalle valido contenido y selecciono
    Y        cierro pop up de CU
    Y        doy click en el boton "Mantener Plan"
    Y        valido que este en el resumen de venta
    Cuando   doy click en el boton Iniciar registro
    Y        ingreso correo electronico "<correo>"
    Y        ingreso nuevamente el correo electronico "<correo>"
    Y        doy click en el boton validar identidad representante legal
    Y        elijo el tipo de validacion a realizar "<tipoValidacion>"
    Y        ingreso los datos del supervisor
    Y        ingreso los datos solicitados para la validacion del cliente
      | nombrePadre   | nombreMadre   | distritoNac   |
      | <nombrePadre> | <nombreMadre> | <distritoNac> |
    Y        doy click en Validar contrato "Móvil"
    Y        me muestra en pantalla el contrato solicitado
    Y        imprimo el texto del contrato solicitado
    Cuando   doy clic en si acepto
    Y        valido que CAEQ:"True", CAPL: "False" y CASI:"False" en el response del salesLead
    Y        doy click en el boton de continuar
    Y        doy clic para descargar el contrato
    Y        doy click en el boton Registrar venta
    Entonces visualizo en pantalla el mensaje de exito de la venta generada
    Y        doy click en ver detalle del pedido
    Y        valido que se muestre el detalle del pedido de "Servicio Móvil"
    Y        valido que se muestre el detalle del pedido de "Información adicional"

    Ejemplos:
      | userType | userName   | userPassword   | msgHome    | channelType | documentType | documentNumber | nro | tipoDocRepLegal | numDocRepLegal | correo              | tipoValidacion | nombrePadre | nombreMadre | distritoNac |
      | userType | userNameST | userPasswordST | Bienvenid@ | Tienda      | RUC          | 20504127410    | 1   | DNI             | 75447902       | automation@mail.com | discapacitado  | LAZARO      | AURORA      | CALLAO      |
