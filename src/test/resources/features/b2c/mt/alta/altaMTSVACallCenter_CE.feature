#language:es
##CREADOR:
##APP: DITO
##MODULO: MOVISTAR TOTAL
# #FUNCIONALIDAD: ALTA
##ESTADO: ACTIVO
##CODIGO: AT-DT035
##GDAP: GDAP-725
##SPRINT CREADO:
##FRECUENCIA:
##TAG : BERSERKERS
##DATA: REUSABLE
##ENCARGADO:
##FECMOD: 15/08/2024

@BERSERKERS @DoneDevOps @DoneDevOpsPI11 @DROP35 @AT-DT035 @AltaMTSVA
Característica: AT-DT035_Alta MT (Alta fija + alta movil) + SVA a cliente con CE por canal Call Center

  @AltaMTSVACallCenter_CE @robotQAN @QAN
  Esquema del escenario: Alta MT (Alta fija + alta movil) + SVA a cliente con CE por canal Call Center
    Dado     que abro la pagina de movistar
    Y ingreso los datos para la bitacora
      | Analista QA        | HU           | Test        | Transaccion | Tipo Venta |
      | Jefferson Riobueno | TIQLT-JR0111 | TIQLT-20528 | Alta MT + SVA    | Contado    |
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
    Y        ingreso los datos del nuevo cliente
      | nombres      | apellidos     | genero    |
      | JOSE SEGUNDO | LLAMOCA LOPEZ | masculino |
    Y        selecciono el boton Linea Nueva Hogar
    Y        selecciono el boton Linea Nueva Movil
    Y        selecciono el boton Mostrar ofertas
    Entonces me muestra la pantalla para ingresar la direccion
    Y        selecciono el departamento donde sera la instalacion "<departamento>"
    Y        selecciono la provincia donde sera la instalacion "<provincia>"
    Y        selecciono el distrito donde sera la instalacion "<distrito>"
    Y        ingreso la direccion donde sera la instalacion "<direccion>"
    Y        ingreso la referencia de la direccion "<referencia>"
    Y        presiono el boton Consultar ubicacion
    Y        presiono el boton Consultar cobertura
    Y        selecciono tipo de oferta
    Y        selecciono el tipo de plan "<planType>"
    Y        selecciono un plan Movistar Total "<planName>"
    Y        valido que este en el resumen de venta
    Y        doy click en el boton Agregar SVA
    Y        valido que me encuentre en la pantalla "Añade tus servicios adicionales (SVA's)"
    Y        agrego SVA internet "<sva>"
    Y        doy click en el boton Guardar cambios
    Cuando   doy click en el boton Iniciar registro
    Y        valido que me encuentre en la pantalla agendamiento
    Y        ingreso los datos de agendamiento
    Y        presiono el boton confirmar agendamiento
    Y        presiono el boton Consultar ubicacion
    Y        presiono el boton Confirmar ubicacion
    Y        selecciono un tipo de entrega "Delivery Regular 24 horas"
    Y        selecciono el horario de entrega "3pm-7pm"
    Y        ingreso telefono de contacto "908123789"
    Y        ingreso instrucciones de delivery "Al frente de la farmacia central"
    Y        doy click en confirmar delivery
    Y        valido que este en la seccion completa los datos solicitados
    Y        selecciono el metodo de pago "Contra entrega"
    Y        ingreso correo electronico "hola_mundo@gmail.com"
    Y        ingreso nuevamente el correo electronico "hola_mundo@gmail.com"
    Y        doy click en datos del cliente
    Y        completo los datos del cliente
      | fechaNac   | estadoCivil | nacionalidad |
      | 12/09/1988 | Divorciado  | Aruba        |
    Y        doy click en el boton confirmar
    Y        doy click en Validar contrato ""
    Y        me muestra en pantalla el contrato solicitado
    Y        imprimo el texto del contrato solicitado
    Cuando   doy clic en si acepto
    Y        doy click en el boton Continuar
    Entonces visualizo en pantalla el mensaje de exito de la venta generada
    Y        doy click en ver detalle del pedido
    Y        valido que se muestre el detalle del pedido de "Servicio Hogar"
    Y        valido que se muestre el detalle del pedido de "Dirección de instalación"
    Y        valido que se muestre el detalle del pedido de "Servicio Móvil"
    Y        valido que se muestre el detalle del pedido de "Delivery"
    Y        valido que se muestre el detalle del pedido de "Información adicional"
    Dado     regreso a la pagina de inicio
    Entonces valido el login exitoso mediante el mensaje "<msgHome>"
    Y        me dirijo a la bandeja de Back Office
    Y        busco por "<documentNumber>"
    Y        selecciono la solicitud
    Y        cargo el audio en la web
    Y        apruebo la solicitud
    Ejemplos:
      | userType | userName   | userPassword   | msgHome    | channelType | documentType | documentNumber | departamento | provincia | distrito | direccion                   | referencia | planType | planName | sva                   |
      | userType | userNameQAN5 | userPasswordQAN5 | Bienvenid@ | Call Center | CE           | 1100002303     | LIMA         | LIMA      | LINCE    | JIRON JULIO CESAR TELLO 469 | Casa       | Duo MT   | Duo BA   | PACK ANTIVIRUS MCAFEE |
