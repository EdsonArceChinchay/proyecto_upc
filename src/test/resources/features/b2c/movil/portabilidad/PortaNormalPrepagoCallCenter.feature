#language:es
##CREADOR: Angel Medina
##APP: DITO
##MODULO: MOVÍL
##FUNCIONALIDAD: PORTABILIDAD
##ESTADO: ACTIVO
##CODIGO: AT-DT106
##GDAP: GDAP-964
##SPRINT CREADO:
##FRECUENCIA: DIARIO
##TAG : BERSERKERS
##DATA: REUSABLE (CANCELAR ORDENES EN VUELO)
##ENCARGADO: Angel Medina
##FECMOD: 11/10/2024

@BERSERKERS @DoneDevOps
Característica: AT-DT106_Porta Normal Solo Chip Prepago a cliente con DNI en canal Call Center

  @PortaNormalPreCC
  Esquema del escenario: Portabilidad Normal Solo Chip Prepago a cliente con DNI en canal Call Center
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
    Y        cierro pop up de CU
    Y        doy click en el boton portabilidad
    Y        selecciono el boton Mostrar ofertas
    Y        ingreso numero de telefono para portar "<phoneNumber>"
    Y        escojo tipo de linea "Postpago"
    Y        escojo tipo de operador "OPERADOR DE PRUEBA"
    Y        doy click en el boton Consultar Portabilidad
    Y        valido el servicio prevalidateportin
      | phoneNumber   |
      | <phoneNumber> |
    Y        doy tiempo extra
    Y        selecciono el plan "Prepago" que desea
    Y        doy click en el boton Siguiente
    Y        valido que este en la pagina de ofertas sugeridas
    Y        selecciono tipo de oferta
    Y        selecciono el tipo de plan movil "<tipoPlanMovil>"
    Y        selecciono un plan movil "<nombrePlan>"
    Y        valido que este en el resumen de venta
    Y        doy click en el boton Iniciar registro
    Y        selecciono el departamento donde sera la instalacion "LIMA"
    Y        selecciono la provincia donde sera la instalacion "LIMA"
    Y        selecciono el distrito donde sera la instalacion "LINCE"
    Y        ingreso la direccion donde sera la instalacion "JIRON JULIO CESAR TELLO 469"
    Y        ingreso la referencia de la direccion "INKAFARMA"
    Y        presiono el boton Consultar ubicacion
    Y        presiono el boton Confirmar ubicacion
    Y        selecciono un tipo de entrega "Delivery Regular 48 horas"
    Y        selecciono el horario de entrega "3pm-7pm"
    Y        ingreso telefono de contacto "658745259"
    Y        ingreso instrucciones de delivery "En la cuadra 8 a la derecha"
    Y        doy click en confirmar delivery
    Y        valido que este en la seccion completa los datos solicitados
    Y        selecciono el metodo de pago "Contra entrega"
    Y        ingreso correo electronico "jlopez@mail.com"
    Y        ingreso nuevamente el correo electronico "jlopez@mail.com"
    Y        doy click en validar identidad del titular
    Y        ingreso los datos solicitados para la validacion del cliente
      | nombrePadre   | nombreMadre   | distritoNac   |
      | <nombrePadre> | <nombreMadre> | <distritoNac> |
    Y        doy click en Validar contrato "Móvil"
    Y        me muestra en pantalla el contrato solicitado
    Y        imprimo el texto del contrato solicitado
    Cuando   doy clic en si acepto
    Y        doy click en Finalizar registro
    Entonces visualizo en pantalla el mensaje de exito de la venta generada
    Y        doy click en ver detalle del pedido
    Y        valido que se muestre el detalle del pedido de "Servicio Móvil"
    Y        valido que se muestre el detalle del pedido de "Información adicional"
    Dado     regreso a la pagina de inicio
    Entonces valido el login exitoso mediante el mensaje "<msgHome>"
    Y        me dirijo a la bandeja de Back Office
    Y        busco por "<documentNumber>"
    Y        selecciono la solicitud
    Y        cargo el audio en la web
    Y        apruebo la solicitud

    Ejemplos:
      | userType | userName   | userPassword   | msgHome    | channelType | documentType | documentNumber | phoneNumber | tipoPlanMovil | nombrePlan | nombreMadre | nombrePadre | distritoNac |
      | userType | userNameCC | userPasswordCC | Bienvenid@ | Call Center | DNI          | 75102020       | 920956351   | Prepago       | Prepago    | ANGELICA    | SERAPIO     | SANTIAGO    |

