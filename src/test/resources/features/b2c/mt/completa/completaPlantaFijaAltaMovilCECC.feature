#language:es
##CREADOR: CARLOS RUIZ
##APP: DITO
##MODULO: MOVISTAR TOTAL
##FUNCIONALIDAD: COMPLETA MOVIL
##ESTADO: ACTIVO
##CODIGO: AT-DT0
##GDAP: GDAP-716
##SPRINT CREADO: PI20_SP2
##FRECUENCIA: SEMANAL
##TAG : BERSERKERS
##DATA: REUSABLE (CANCELAR ORDENES EN VUELO)
##ENCARGADO: CARLOS RUIZ
##FECMOD: 17/07/2024

@BERSERKERS @DoneDevOps @DoneDevOpsPI11 @Sanity28  @DROP-G01
Característica: AT-DT0_Completa Movil MT (Planta Fija + Alta Movil) a cliente con CE por canal Call Center

  @CompletaMovilCC
  Esquema del escenario: Completa Planta Fija Alta Movil a cliente con CE
    Dado     que abro la pagina de movistar
    Cuando   presiono el boton Iniciar Sesion
    Y        selecciono el tipo de usuario "<userType>"
    Y        ingreso el usuario "<userName>"
    Y        ingreso el password "<userPassword>"
    Y        ingreso el captcha
    Y        presiono el boton Continuar hacia el home
    Entonces valido el login exitoso mediante el mensaje "<msgHome>"
    Y        valido que se presente el canal "<channelType>"
    Cuando   selecciono el tipo de documento "<documentType>"
    Y        ingreso el documento "<documentNumber>"
    Y        doy click en el boton Consultar
    Y        selecciono el boton de la Linea Hogar Existente "<numeroExistente>"
    Y        selecciono el boton Linea Nueva Movil
    Y        selecciono el boton Mostrar ofertas
    Y        doy click en el boton "Actualizar direccion"
    Y        ingreso la referencia de la direccion "."
    Y        presiono el boton Consultar ubicacion
    Y        presiono el boton Consultar cobertura
    Y        doy click en el boton "ENTENDIDO"
    Y        valido que este en la pagina de ofertas sugeridas
    Y        selecciono tipo de oferta
    Y        selecciono un plan Movistar Total "<nombrePlan>"
    Y        valido que este en el resumen de venta
    Cuando   doy click en el boton Iniciar registro
    Y        valido que me encuentre en la pantalla agendamiento
    Y        ingreso los datos de agendamiento
    Y        presiono el boton confirmar agendamiento
    Entonces me muestra la pantalla para ingresar la direccion de entrega
    Y        presiono el boton Consultar ubicacion
    Y        presiono el boton Confirmar ubicacion
    Y        selecciono un tipo de entrega "Delivery Regular 48 horas"
    Y        selecciono el horario de entrega "3pm-7pm"
    E        ingreso telefono de contacto "998877665"
    E        ingreso instrucciones de delivery "cerca al parque"
    Y        doy click en confirmar delivery
    Y        selecciono el metodo de pago "Contra entrega"
    Y        ingreso correo electronico "hola@gmail.com"
    Y        ingreso nuevamente el correo electronico "hola@gmail.com"
    Y        doy click en Validar contrato ""
    Y        me muestra en pantalla el contrato solicitado
    Y        imprimo el texto del contrato solicitado
#    Cuando   doy clic en si acepto
#    Y        doy click en el boton de continuar
#    Entonces visualizo en pantalla el mensaje de exito de la venta generada
#    Y        doy click en ver detalle del pedido
#    Y        valido que se muestre el detalle del pedido de "Servicio Hogar"
#    Y        valido que se muestre el detalle del pedido de "Dirección de instalación"
#    Y        valido que se muestre el detalle del pedido de "Servicio Móvil"
#    Y        valido que se muestre el detalle del pedido de "Delivery"
#    Y        valido que se muestre el detalle del pedido de "Información adicional"
#    Dado     regreso a la pagina de inicio
#    Entonces valido el login exitoso mediante el mensaje "Bienvenid@"
#    Y        me dirijo a la bandeja de Back Office
#    Y        busco por "<documentNumber>"
#    Y        selecciono la solicitud
#    Y        cargo el audio en la web
#    Y        apruebo la solicitud
    Ejemplos:
      | userType     | userName     | userPassword     | msgHome    | channelType | documentType | documentNumber | nombrePlan | numeroExistente |
#      | userType     | userNameCC   | userPasswordCC   | Bienvenid@ | Call Center | CE           | 202300009      | Trio       | 9234828220      |

#      | externalUser | userNameQAN2 | userPasswordQAN2 | Bienvenid@ | Call Center | CE           | 1100000667      | Trio       | 14073845      |
      | externalUser | userNameQAN2 | userPasswordQAN2 | Bienvenid@ | Call Center | CE           | 1100000772      | Trio       | 5010302330      |