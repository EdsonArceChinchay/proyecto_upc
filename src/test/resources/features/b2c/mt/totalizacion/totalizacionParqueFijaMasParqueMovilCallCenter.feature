#language: es
##CREADOR: Henry salas
##APP: DITO
##MODULO: MOVISTAR TOTAL
##FUNCIONALIDAD: TOTALIZACION
##ESTADO: ACTIVO
##CODIGO: AT-DT110
##GDAP: GDAP-1152
##SPRINT CREADO:
##FRECUENCIA:
##TAG : BERSERKERS
##DATA:  REUSABLE (CANCELAR ORDENES)
##ENCARGADO:
##FECMOD: 26/02/2025

@BERSERKERS @DoneDevOps @DoneDevOpsPI14
Característica: AT-DT110_Totalizacion MT (parque fijo + parque movil) a cliente con CE por canal Call Center

  @TotalizacionMTTrioMovilCC
  Esquema del escenario: Totalizacion MT - parque fijo + parque movil - a cliente con CE por canal Call Center
    Dado que abro la pagina de movistar
    Y ingreso los datos para la bitacora
      | Analista QA   | HU          | Test        | Transaccion                                  | Tipo Venta | Tags                       |
      | Jorgr Cancino | TIQLT-27349 | TIQLT-27349 | Totalizacion MT (parque fijo + parque movil) | Contado    | @TotalizacionMTTrioMovilCC |
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
    Y selecciono la linea con numero "<fijoExistente>"
    Y selecciono la linea con numero "<celularExistente>"
    Y cierro el popup de validación de estado de contraseña única
    Y selecciono el boton Mostrar ofertas
    Y doy click en el boton "Actualizar direccion"
    Y ingreso la referencia de la direccion "casa"
    Y presiono el boton Consultar ubicacion
    Y "<insertarDireccion>" ingreso la informacion del lugar de instalacion
      | mz | tipoVivienda | nombreVivienda | piso | int | conjunto             | conjHabit |
      | A  | CASA         | alex mancilla  | 1    | 1   | URBANIZACION POPULAR | casa      |
    Y presiono el boton Consultar cobertura
    Y doy click en el boton "ENTENDIDO"
    Y valido que este en la pagina de ofertas sugeridas
    Y selecciono tipo de oferta
    Y selecciono un plan Movistar Total "Trio"
    Y valido que este en el resumen de venta
    Cuando doy click en el boton Iniciar registro
    Y valido que me encuentre en la pantalla agendamiento
    Y ingreso los datos de agendamiento
    Y presiono el boton confirmar agendamiento
    Y ingreso correo electronico "<correo>"
    Y ingreso nuevamente el correo electronico "<correo>"
    Y doy click en Validar contrato ""
    Y me muestra en pantalla el contrato solicitado
    Y imprimo el texto del contrato solicitado
    Cuando doy clic en si acepto
    Y doy click en el boton de continuar
    Entonces visualizo en pantalla el mensaje de exito de la venta generada
    Y doy click en ver detalle del pedido
    Y valido que se muestre el detalle del pedido de "Servicio Hogar"
    Y valido que se muestre el detalle del pedido de "Dirección de instalación"
    Y valido que se muestre el detalle del pedido de "Servicio Móvil"
    Y valido que se muestre el detalle del pedido de "Información adicional"
    Dado regreso a la pagina de inicio
    Y valido que se presente el canal "<channelType>"
    Y me dirijo a la bandeja de Back Office
    Y busco por "codigo de venta"
    Y selecciono la solicitud
    Y cargo el audio en la web
    Y apruebo la solicitud
    Ejemplos:
      | userType | userName     | userPassword     | msgHome    | insertarDireccion | channelType | documentType | documentNumber | fijoExistente | celularExistente | correo                    |
      | userType | userNameQAN6 | userPasswordQAN6 | Bienvenid@ | SI                | Call Center | CE           | 1100000908     | 5010320405    | 975420738        | 1100000908@mailinator.com |