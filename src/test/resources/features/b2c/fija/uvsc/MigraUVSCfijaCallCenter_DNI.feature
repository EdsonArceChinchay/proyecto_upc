#language:es
##CREADOR: ELOY MILLA
##APP: DITO
##MODULO: FIJA
##FUNCIONALIDAD: MIGRACION UVSC
##ESTADO: ACTIVO
##CODIGO: AT-DT064
##GDAP: GDAP-888
##SPRINT CREADO:
##FRECUENCIA: DIARIO
##TAG : BERSERKERS
##DATA: REUSABLE (CANCELAR ORDEN EN VUELO)
##ENCARGADO:
##FECMOD: 30/07/2024

@BERSERKERS @DoneDevOps
Característica: AT-DT064_Migracion UVSC fija con cliente a DNI por canal Call Center

  @migraUVSCcallCenter @QAN
  Esquema del escenario: Migracion UVSC fija con cliente a DNI por canal Call Center
    Dado que abro la pagina de movistar
    Y ingreso los datos para la bitacora
      | Analista QA              | HU          | Test        | Transaccion         | Tipo Venta | Tags                 |
      | Jesus Abel Tornero Rojas | TIQLT-27354 | TIQLT-27354 | Migracion UVSC fija | Contado    | @migraUVSCcallCenter |
    Cuando presiono el boton Iniciar Sesion
    Y selecciono el tipo de usuario "<userType>"
    Y ingreso el usuario "<userName>"
    Y ingreso el password "<userPassword>"
    Y ingreso el captcha
    Y presiono el boton Continuar hacia el home
    Y valido el login exitoso mediante el mensaje "<msgHome>"
    Y valido que se presente el canal "<channelType>"
    Cuando selecciono el tipo de documento "<documentType>"
    Y ingreso el documento "<documentNumber>"
    Y doy click en el boton Consultar
    Y selecciono la linea con numero "<numeroExistente>"
    Y selecciono el boton Mostrar ofertas
    Y doy click en el boton "ACTUALIZAR DIRECCION"
    Y ingreso la referencia de la direccion "."
    Y presiono el boton Consultar ubicacion
    Y "<insertarDireccion>" ingreso la informacion del lugar de instalacion
      | mz | tipoVivienda | nombreVivienda | piso | int | conjunto             | conjHabit |
      | A  | CASA         | alex mancilla  | 1    | 1   | URBANIZACION POPULAR | casa      |
    Y presiono el boton Consultar cobertura
    Y doy click en el boton "ENTENDIDO"
    Entonces valido que se presente la pantalla con el titulo "Ofertas sugeridas"
    Y valido que se muestre la etiqueta "Fibra+Velocidad, COSTO 0"
    Y doy click en Cambiar plan hogar
    Y valido que este en el resumen de venta
    Cuando doy click en el boton Iniciar registro
    Y valido que me encuentre en la pantalla agendamiento
    Y ingreso los datos de agendamiento
    Y presiono el boton confirmar agendamiento
    Y ingreso correo electronico "<correo>"
    Y ingreso nuevamente el correo electronico "<correo>"
    Y doy click en Validar contrato "hogar"
    Y me muestra en pantalla el contrato solicitado
    E imprimo el texto del contrato solicitado
    Cuando doy clic en si acepto
    Y doy click en el boton de continuar
    Entonces visualizo en pantalla el mensaje de exito de la venta generada
    Y doy click en ver detalle del pedido
    Y valido que se muestre el detalle del pedido de "Servicio Hogar"
    Y valido que se muestre el detalle del pedido de "Dirección de instalación"
    Y valido que se muestre el detalle del pedido de "Información adicional"
    Dado regreso a la pagina de inicio
    Y valido que se presente el canal "<channelType>"
    Y me dirijo a la bandeja de Back Office
    Y busco por "codigo de venta"
    Y selecciono la solicitud
    Y cargo el audio en la web
    Y apruebo la solicitud
    Ejemplos:
      | userType | userName     | userPassword     | msgHome    | insertarDireccion | channelType | documentType | documentNumber | numeroExistente | correo                 |
      | userType | userNameQAN8 | userPasswordQAN8 | Bienvenid@ | SI                | Call Center | DNI          | 72079848       | 5066694236      | 72079848@malinator.com |