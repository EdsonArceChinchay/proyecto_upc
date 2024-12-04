#language:es
##CREADOR: Eloy Milla
##APP: DITO
##MODULO: MOVIL
##FUNCIONALIDAD: ALTA
##ESTADO: ACTIVO
##CODIGO:AT-DT
##GDAP: GDAP-1662
##SPRINT CREADO: PI19_SP1
##FRECUENCIA: DIARIA
##TAG : BERSERKERS
##DATA:REUSABLE
##ENCARGADO: Eloy Milla
##FECMOD: 08/04/2024

@BERSERKERS @DoneDevOps
Característica: AT-DT Alta Movil B2B con permanencia 18 meses + equipo con Representante Legal Extranjero en Canal Tienda
  Quiero realizar un alta movil + equipo a un cliente B2B con Representante Legal Extranjero en Canal Tienda

  @altaMovilB2BCETienda
  Esquema del escenario: Alta movil B2B con permanencia 18 meses + Equipo con Representante Legal Extranjero en Canal Tienda
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
    Y        selecciono el boton Linea Nueva Movil
    Y        cierro el popup de validación de estado de contraseña única
    Y        selecciono el boton Mostrar ofertas
    Y        selecciono el plan "Postpago" que desea
    Y        doy click en el boton Siguiente
    Y        selecciono añadir equipos
    E        ingreso permanencia, tipo de pago y equipo
      | permanencia | tipoPago   | equipoName                     |
      | 18 meses    | Al Contado | HONOR X8A VERDE CRT-LX3 C/PACK |
    Y        doy click en el boton seleccionar
    Y        doy click en el boton Linea Nueva
    Y        doy click en el boton Iniciar registro
    Y        ingreso correo electronico "<correo>"
    Y        ingreso nuevamente el correo electronico "<correo>"
    Y        doy click en Validar contrato "Móvil"
    Y        me muestra en pantalla el contrato solicitado
    Y        imprimo el texto del contrato solicitado
    Cuando   doy clic en si acepto
    Y        doy click en el boton Continuar
    Y        doy clic para descargar el contrato
    Y        doy click en el boton Registrar venta
    Entonces visualizo en pantalla el mensaje de exito de la venta generada
    Y        doy click en ver detalle del pedido
    Y        valido que se muestre el detalle del pedido de "Servicio Móvil"
    Y        valido que se muestre el detalle del pedido de "Información adicional"

    Ejemplos:
      | userType | userName   | userPassword   | msgHome    | channelType | documentType | documentNumber | nro | tipoDocRepLegal | numDocRepLegal | correo            |
      | userType | userNameST | userPasswordST | Bienvenid@ | Tienda      | RUC          | 20000000003    | 1   | C               | 143625134      | prueba@prueba.com |
