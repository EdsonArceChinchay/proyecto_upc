#language:es
##CREADOR: Moises Llamoca
##APP: DITO
##MODULO: MOVÍL
##FUNCIONALIDAD: CAMBIO DE SIMCARD (CASI)
##ESTADO: ACTIVO
##CODIGO:AT-DT113
##GDAP:GDAP-1386
##SPRINT CREADO: PI15_SP5
##FRECUENCIA:
##TAG : BERSERKERS
##DATA:  REUSABLE (CANCELAR ORDENES EN VUELO)
##ENCARGADO:Brandon
##FECMOD: 05/12/2024

@BERSERKERS @DoneDevOps @casiRetail
Característica: AT-DT113_Cambio de Simcard (CASI) a cliente con CE por canal Retail
  Quiero realizar un CASI a un cliente con CE y parque movil

  @casiRetail
  Esquema del escenario: Cambio de Simcard (CASI) a cliente con CE por canal Retail
    Dado     que abro la pagina de movistar
    Cuando   presiono el boton Iniciar Sesion
    Y        selecciono el tipo de usuario "<userType>"
    Y        ingreso el usuario "<userName>"
    Y        ingreso el password "<userPassword>"
    E        ingreso el captcha
    Y        presiono el boton Continuar hacia el home
    Entonces valido el login exitoso mediante el mensaje "<msgHome>"
    Cuando   selecciono el tipo de documento "<documentType>"
    Y        ingreso el documento "<documentNumber>"
    Y        doy click en el boton Consultar
    Y        cierro el popup de contraseña Única
    Y        cierro popup de error
    Cuando   doy click en el boton Ver detalle del servicio "920957608"
    Y        selecciono el boton Cambiar Chip
    Y        cierro pop up de Cliente Exonerado
    Cuando   doy click en el boton Iniciar registro
    Y        ingreso correo electronico "<correo>"
    Y        ingreso nuevamente el correo electronico "<correo>"
    Y        doy click en Validar contrato "Móvil"
    Y        me muestra en pantalla el contrato solicitado
    Y        imprimo el texto del contrato solicitado
    Cuando   doy clic en si acepto
    Y        valido que CAEQ:"False", CAPL: "False" y CASI:"True" en el response del salesLead
    Y        doy click en el boton Continuar
    Entonces visualizo en pantalla el mensaje de exito de la venta generada
    Y        doy click en ver detalle del pedido
    Y        valido que se muestre el detalle del pedido de "Servicio Móvil"
    Y        valido que se muestre el detalle del pedido de "Información adicional"
    Cuando   regreso a la pagina de inicio
    Entonces valido el login exitoso mediante el mensaje "<msgHome>"
    Y        selecciono el tipo de documento "<documentType>"
    Y        ingreso el documento "<documentNumber>"
    Y        doy click en el boton Consultar
    Y        selecciono la orden
    Y        doy click en el boton continuar
    E        ingreso el codigo de SIMCARD
    Y        doy click Validar Stock
    E        ingreso el numero de caja "123456"
    E        ingreso el numero de ticket "654321"
    Y        doy click en el boton confirmar
    Y        doy clic para descargar el contrato
    Y        doy click en el boton Registrar venta
    Entonces visualizo en pantalla el mensaje de exito de la venta generada
    Y        doy click en ver detalle del pedido
    Y        valido que se muestre el detalle del pedido de "Servicio Móvil"
    Y        valido que se muestre el detalle del pedido de "Información adicional"
    Ejemplos:
      | userType | userName    | userPassword    | msgHome    | documentType | documentNumber | correo            |
      | userType | userNameDLC | userPasswordDLC | Bienvenid@ | CE           | 1042464725     | prueba@prueba.com |
