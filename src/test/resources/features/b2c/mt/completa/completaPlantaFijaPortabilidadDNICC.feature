#language:es
##CREADOR:
##APP: DITO
##MODULO: MOVISTAR TOTAL
##FUNCIONALIDAD: COMPLETA MOVIL
##ESTADO: ACTIVO
##CODIGO: AT-DT0
##GDAP: GDAP-1661
##SPRINT CREADO:
##FRECUENCIA: SEMANAL
##TAG : BERSERKERS
##DATA: REUSABLE (CANCELAR ORDENES)
##FECMOD: 27/02/2025

@BERSERKERS @QAN @DoneDevOps @DoneDevOpsPI11 @Sanity28 @DROP-G01
Característica: AT-DT0_Completa Movil MT (Planta Fija + Porta Directa Movil) a cliente con DNI por canal Call Center

  @CompletaPlantaFijaPortabilidadCC
  Esquema del escenario: Completa Planta Fija Porta Directa Movil
    Dado que abro la pagina de movistar
    Y ingreso los datos para la bitacora
      | Analista QA              | HU          | Test        | Transaccion         | Tipo Venta | Tags                              |
      | Jesus Abel Tornero Rojas | TIQLT-XXXX | TIQLT-27344 | Alta movil postpago | Contado    | @CompletaPlantaFijaPortabilidadCC |
    Cuando presiono el boton Iniciar Sesion
    Y selecciono el tipo de usuario "<userType>"
    Y ingreso el usuario "<userName>"
    Y ingreso el password "<userPassword>"
    Y ingreso el captcha
    Y presiono el boton Continuar hacia el home
    Entonces valido el login exitoso mediante el mensaje "<msgHome>"
    Y valido que se presente el canal "<channelType>"
    Cuando selecciono el tipo de documento "<documentType>"
    Y ingreso el documento "<documentNumber>"
    Y doy click en el boton Consultar
    Y selecciono la linea con numero "<numeroExistente>"
    Y doy click en el boton portabilidad
    Y selecciono el boton Mostrar ofertas
    Y ingreso numero de telefono para portar "<numero>"
    Y escojo tipo de linea "<tipoLinea>"
    Y escojo tipo de operador "<operador>"
    Y doy click en el boton Consultar Portabilidad
    Y valido que este en la seccion Postpago o Prepago
    Y selecciono el plan "<tipoPlan>" que desea
    Y doy click en el boton Siguiente
    Entonces me muestra la pantalla para verificar la direccion
    Y doy click en el boton "Actualizar direccion"
    Y selecciono el departamento donde sera la instalacion "LIMA"
    Y selecciono la provincia donde sera la instalacion "LIMA"
    Y selecciono el distrito donde sera la instalacion "LINCE"
    Y ingreso la direccion donde sera la instalacion "JR MARISCAL JUAN MILLER 2236"
    Y ingreso la referencia de la direccion "."
    Y presiono el boton Consultar ubicacion
    Y "<insertarDireccion>" ingreso la informacion del lugar de instalacion
      | mz | tipoVivienda | nombreVivienda | piso | int | conjunto             | conjHabit |
      | A  | CASA         | alex mancilla  | 1    | 1   | URBANIZACION POPULAR | casa      |
    Y presiono el boton Consultar cobertura
    Y doy click en el boton "Entendido"
    Y selecciono tipo de oferta
    Y selecciono un plan Movistar Total "<nombrePlan>"
    Y valido que este en el resumen de venta
    Cuando doy click en el boton Iniciar registro
    Y valido que me encuentre en la pantalla agendamiento
    Y ingreso los datos de agendamiento
    Y presiono el boton confirmar agendamiento
    Entonces me muestra la pantalla para ingresar la direccion de entrega
    Y presiono el boton Consultar ubicacion
    Y presiono el boton Confirmar ubicacion
    Y selecciono un tipo de entrega "Delivery Regular 48 horas"
    Y selecciono el horario de entrega "3pm-7pm"
    E ingreso telefono de contacto "998877665"
    E ingreso instrucciones de delivery "cerca al parque"
    Y doy click en confirmar delivery
    Y valido que este en la seccion completa los datos solicitados
    Y selecciono el metodo de pago "Contra entrega"
    Y ingreso correo electronico "<correo>"
    Y ingreso nuevamente el correo electronico "<correo>"
    Y doy click en validar identidad del titular
    Y ingreso los datos solicitados para la validacion del cliente
      | nombrePadre   | nombreMadre   | distritoNac   |
      | <nombrePadre> | <nombreMadre> | <distritoNac> |
    Y doy click en Validar contrato ""
    Y me muestra en pantalla el contrato solicitado
    Y imprimo el texto del contrato solicitado
    Cuando doy clic en si acepto
    Y doy click en Finalizar registro
    Entonces visualizo en pantalla el mensaje de exito de la venta generada
    Y doy click en ver detalle del pedido
    Y valido que se muestre el detalle del pedido de "Servicio Hogar"
    Y valido que se muestre el detalle del pedido de "Dirección de instalación"
    Y valido que se muestre el detalle del pedido de "Servicio Móvil"
    Y valido que se muestre el detalle del pedido de "Delivery"
    Y valido que se muestre el detalle del pedido de "Información adicional"
    Dado regreso a la pagina de inicio
    Y valido que se presente el canal "<channelType>"
    Y me dirijo a la bandeja de Back Office
    Y busco por "codigo de venta"
    Y selecciono la solicitud
    Y cargo el audio en la web
    Y apruebo la solicitud

    Ejemplos:
      | userType | userName     | userPassword     | msgHome    | channelType | documentType | documentNumber | correo                  | insertarDireccion | numero    | tipoLinea | operador | tipoPlan | nombrePlan | nombreMadre | nombrePadre | distritoNac | numeroExistente |
      | userType | userNameQAN4 | userPasswordQAN4 | Bienvenid@ | Call Center | DNI          | 76181879       | 76181879@mailinator.com | No                | 902921279 | Prepago   | ENTEL    | Postpago | Duo        | ROSA        | BRADY       | CHEPEN      | 5010320750      |


