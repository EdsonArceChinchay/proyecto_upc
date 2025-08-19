#language:es
##CREADOR: Moises Llamoca
##APP: DITO
##MODULO: MOVÍL
##FUNCIONALIDAD: CAMBIO DE SIMCARD (CASI)
##ESTADO: ACTIVO
##CODIGO:AT-DT112
##GDAP: GDAP-1418
##SPRINT CREADO: PI15_SP4
##FRECUENCIA: DIARIA
##TAG : BERSERKERS
##DATA:  REUSABLE (CANCELAR ORDENES EN VUELO)
##ENCARGADO:Brandon
##FECMOD: 26/02/2024

@BERSERKERS @DoneDevOps @casiTienda
Característica: AT-DT112_Cambio de Simcard (CASI) a cliente con CE por canal Tienda
  Quiero realizar un CASI a un cliente con parque movil a un usuario a cliente con CE

  @casiTienda
  Esquema del escenario: Cambio de Simcard (CASI) a cliente con CE por canal Tienda
    Dado     que abro la pagina de movistar
    Y ingreso los datos para la bitacora
      | Analista QA   | HU        | Test      | Transaccion | Tipo Venta |
      | Jorge Cancino | TIQLT-XXX | TIQLT-XXX | CASI        | Contado    |
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
    Y        cierro el popup de contraseña Única
    Y        cierro popup de error
    Cuando   doy click en el boton Ver detalle del servicio "943244907"
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
    Y        doy click en el boton de continuar
    Y        doy clic para descargar el contrato
    Y        doy click en el boton Registrar venta
    Entonces visualizo en pantalla el mensaje de exito de la venta generada
    Y        doy click en ver detalle del pedido
    Y        valido que se muestre el detalle del pedido de "Servicio Móvil"
    Y        valido que se muestre el detalle del pedido de "Información adicional"

    Ejemplos:
      | userType | userName     | userPassword     | msgHome    | channelType | documentType | documentNumber | correo            |
      | userType | userNameQAN5 | userPasswordQAN5 | Bienvenid@ | Tienda      | CE           | 1100002104     | prueba@prueba.com |
