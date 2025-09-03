#language: es
##CREADOR:
##APP: DITO
##MODULO:
##FUNCIONALIDAD:
##ESTADO:
##CODIGO: AT-DT063
##GDAP: GDAP-723
##SPRINT CREADO:
##FRECUENCIA:
##TAG : BERSERKERS
##DATA:
##ENCARGADO:
##FECMOD: 30/03/2023
##OBS:

@BERSERKERS @DoneDevOps @DoneDevOpsPI13
Característica: AT-DT063_Migracion Duo a Duo por canal CALL CENTER


  @MigracionDuoDuocanalCallCenter
  Esquema del escenario: Migracion de Duo a Duo
    Dado     que abro la pagina de movistar
    Y ingreso los datos para la bitacora
      | Analista QA   | HU         | Test       | Transaccion | Tipo Venta | Tags                            |
      | Jorge Cancino | TIQLT-XXXX | TIQLT-XXXX | Migra       | Contado    | @MigracionDuoDuocanalCallCenter |
    Cuando   presiono el boton Iniciar Sesion
    Y        selecciono el tipo de usuario "<userType>"
    Y        ingreso el usuario "<userName>"
    Y        ingreso el password "<userPassword>"
    E        ingreso el captcha
    Y        presiono el boton Continuar hacia el home
    Y        valido el login exitoso mediante el mensaje "<msgHome>"
    Y        valido que se presente el canal "<channelType>"
    Cuando   selecciono el tipo de documento "<documentType>"
    Y        ingreso el documento "<documentNumber>"
    Y        doy click en el boton Consultar
    Y        selecciono la cartilla del plan activo
    #Y selecciono la linea con numero "<fijoExistente>"
    Y        selecciono el boton Mostrar ofertas
    Y        doy click en el boton "Actualizar direccion"
    Y        ingreso la referencia de la direccion "."
    Y        presiono el boton Consultar ubicacion
    Y        presiono el boton Consultar cobertura
    Y        doy click en el boton "ENTENDIDO"
    #Y        verifico la direccion "LINCE , LIMA , LIMA" actual del servicio
    #Y        doy click en el boton "Confirmar direccion"
    Y        valido que este en la pagina de ofertas sugeridas
    Y        selecciono tipo de oferta
    Y        selecciono el tipo de plan Hogar "<tipoPlanHogar>"
    Y        selecciono el plan "<plan>"
    Y        doy click en Cambiar plan hogar
    Y        valido que este en el resumen de venta
    Cuando   doy click en el boton Iniciar registro
    Y        valido que me encuentre en la pantalla agendamiento
    Y        ingreso los datos de agendamiento
    Y        presiono el boton confirmar agendamiento
    Y        ingreso correo electronico "<correo>"
    Y        ingreso nuevamente el correo electronico "<correo>"
    Y        doy click en Validar contrato "hogar"
    Y        me muestra en pantalla el contrato solicitado
    Y        imprimo el texto del contrato solicitado
    Cuando   doy clic en si acepto
    Y        doy click en el boton de continuar
    Entonces me muestra la pantalla registrar venta
    Y        doy clic para descargar el contrato
    Entonces visualizo en pantalla el mensaje de exito de la venta generada
    Y        doy click en ver detalle del pedido
    Y        valido que se muestre el detalle del pedido de "Servicio Hogar"
    Y        valido que se muestre el detalle del pedido de "Dirección de instalación"
    Y        valido que se muestre el detalle del pedido de "Información adicional"
    Dado     regreso a la pagina de inicio
    Entonces valido el login exitoso mediante el mensaje "<msgHome>"
    Y        me dirijo a la bandeja de Back Office
    Y        busco por "CODIGO DE VENTA"
    Y        selecciono la solicitud
    Y        cargo el audio en la web
    Y        apruebo la solicitud

    Ejemplos:
      | userType | userName     | userPassword     | msgHome    | channelType | documentType | documentNumber | correo            | tipoPlanHogar | plan         | fijoExistente |
      | userType | userNameQAN4 | userPasswordQAN4 | Bienvenid@ | Call Center | CE           | 1100002178     | tester@tester.com | Duo           | Duo Internet | 5010348207    |
