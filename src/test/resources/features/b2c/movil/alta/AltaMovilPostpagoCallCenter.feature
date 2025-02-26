#language:es
##CREADOR: Angel Medina
##APP: DITO
##MODULO: MOVIL
##FUNCIONALIDAD: ALTA
##ESTADO: ACTIVO
##CODIGO: AT-DT027
##GDAP: GDAP-1151
##SPRINT CREADO:
##FRECUENCIA: DIARIO
##TAG : BERSERKERS
##DATA: REUSABLE
##ENCARGADO: Angel Medina
##FECMOD: 01/08/2024

@BERSERKERS @DoneDevOps @DoneDevOpsPI11 @AT-DT027 @AltaMovil
Característica: AT-DT027_Alta movil postpago a cliente con CE por canal Call Center

  @Alta_Postpago_sim_CC @MVP13 @Global
  Esquema del escenario: Alta movil postpago a cliente con CE por canal Call Center
    Dado que abro la pagina de movistar
    Y ingreso los datos para la bitacora
      | Analista QA              | HU          | Test        | Transaccion         | Tipo Venta | Tags                  |
      | Jesus Abel Tornero Rojas | TIQLT-27350 | TIQLT-27350 | Alta movil postpago | Contado    | @Alta_Postpago_sim_CC |
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
    Y cierro popup de error
    Y ingreso los datos del nuevo cliente
      | nombres | apellidos    | genero    |
      | Pruebas | QANDOCIENTOS | masculino |
    Y selecciono el boton Linea Nueva Movil
    Y cierro el popup de validación de estado de contraseña única
    Y selecciono el boton Mostrar ofertas
    Y selecciono el plan "Postpago" que desea
    Y doy click en el boton Siguiente
    Y valido que este en la pagina de ofertas sugeridas
    Y selecciono tipo de oferta
    Y selecciono el tipo de plan movil "<tipoPlanMovil>"
    Y selecciono un plan movil "<nombrePlan>"
    Y valido que este en el resumen de venta
    Y doy click en el boton Iniciar registro
    Y selecciono el departamento donde sera la instalacion "LIMA"
    Y selecciono la provincia donde sera la instalacion "LIMA"
    Y selecciono el distrito donde sera la instalacion "LINCE"
    Y ingreso la direccion donde sera la instalacion "JIRON JULIO CESAR TELLO 469"
    Y ingreso la referencia de la direccion "INKAFARMA"
    Y presiono el boton Consultar ubicacion
    Y presiono el boton Confirmar ubicacion
    Y selecciono un tipo de entrega "Delivery Regular 48 horas"
    Y selecciono el horario de entrega "3pm-7pm"
    Y ingreso telefono de contacto "658745259"
    Y ingreso instrucciones de delivery "En la cuadra 8 a la derecha"
    Y doy click en confirmar delivery
    Y valido que este en la seccion completa los datos solicitados
    Y selecciono el metodo de pago "Contra entrega"
    Y ingreso correo electronico "jlopez@mail.com"
    Y ingreso nuevamente el correo electronico "jlopez@mail.com"
    Y doy click en datos del cliente
    Y completo los datos del cliente
      | fechaNac   | estadoCivil | nacionalidad |
      | 10/02/1996 | Divorciado  | Alemania     |
    Y doy click en el boton confirmar
    Y doy click en Validar contrato "Móvil"
    Y me muestra en pantalla el contrato solicitado
    Y imprimo el texto del contrato solicitado
    Cuando doy clic en si acepto
    Y doy click en el boton de continuar
    Entonces visualizo en pantalla el mensaje de exito de la venta generada
    Y doy click en ver detalle del pedido
    Y valido que se muestre el detalle del pedido de "Servicio Móvil"
    Y valido que se muestre el detalle del pedido de "Información adicional"
    Dado regreso a la pagina de inicio
    Entonces valido el login exitoso mediante el mensaje "<msgHome>"
    Y me dirijo a la bandeja de Back Office
    Y busco por "codigo de venta"
    Y selecciono la solicitud
    Y cargo el audio en la web
    Y apruebo la solicitud
    Ejemplos:
      | userType | userName     | userPassword     | msgHome    | channelType | documentType | documentNumber | tipoPlanMovil | nombrePlan                           |
      | userType | userNameQAN5 | userPasswordQAN5 | Bienvenid@ | Call Center | CE           | 1100007777     | Postpago      | RV Plan Ilimitado Mi Movistar S/74.9 |
