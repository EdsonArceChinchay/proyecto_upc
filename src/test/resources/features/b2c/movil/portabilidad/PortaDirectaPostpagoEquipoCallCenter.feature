#language:es
##CREADOR: CARLOS RUIZ
##APP: DITO
##MODULO: MOVÍL
##FUNCIONALIDAD: PORTABILIDAD
##ESTADO: ACTIVO
##CODIGO: AT-DT
##GDAP: GDAP-994
##SPRINT CREADO: PI21_SP1
##FRECUENCIA: DIARIO
##TAG : BERSERKERS
##DATA: REUSABLE (CANCELAR ORDENES EN VUELO)
##ENCARGADO: CARLOS RUIZ
##FECMOD: 11/10/2024

@BERSERKERS @DoneDevOps
Característica: AT-DT_Porta Directa solo chip postpago + equipo movil a cliente con DNI por canal Call Center

  @PortaDirectaEquipoPostCC
  Esquema del escenario: Porta Directa solo chip postpago + equipo movil a cliente con DNI por canal Call Center
    Dado     que abro la pagina de movistar
    Cuando   presiono el boton Iniciar Sesion
    Y        selecciono el tipo de usuario "<userType>"
    Y        ingreso el usuario "<userName>"
    Y        ingreso el password "<userPassword>"
    Y        ingreso el captcha
    Y        presiono el boton Continuar hacia el home
    Entonces valido el login exitoso mediante el mensaje "<msgHome>"
    Y        valido que se presente el canal "<channelType>"
    Y        valido que este activo el flag de Porta Directa
    Cuando   selecciono el tipo de documento "<documentType>"
    Y        ingreso el documento "<documentNumber>"
    Y        doy click en el boton Consultar
    Y        cierro el popup de contraseña Única
    Y        doy click en el boton portabilidad
    Y        selecciono el boton Mostrar ofertas
    Y        ingreso numero de telefono para portar "<phoneNumber>"
    Y        escojo tipo de linea "<tipoLinea>"
    Y        escojo tipo de operador "<operador>"
    Y        doy click en el boton Consultar Portabilidad
    Y        valido que este en la seccion Postpago o Prepago
    Y        selecciono el plan "Postpago" que desea
    Y        doy click en el boton Siguiente
    Y        valido que este en la pagina de ofertas sugeridas
    Y        selecciono tipo de oferta
    Y        selecciono el tipo de plan movil "<tipoPlanMovil>"
    Y        selecciono la opcion "<nombrePlan>"
    Y        doy click en el boton seleccionar oferta
    Y        selecciono añadir equipos
    E        ingreso permanencia, tipo de pago y equipo
      | permanencia     | tipoPago   | equipoName               |
      | sin permanencia | Al Contado | VIVO V21 NEGRO 5G C/PACK |
    Y        valido que existan resultados busqueda de equipos
    Y        presiono el boton Ver detalle valido contenido y selecciono
    Y        doy click en el boton Porta Movil
    Y        valido que este en el resumen de venta
    Y        doy click en el boton Iniciar registro
    Y        valido el servicio prevalidateportin
      | phoneNumber   |
      | <phoneNumber> |
    Y        doy tiempo extra
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
    Y        ingreso correo electronico "jufeufecenno-3027@yopmail.com"
    Y        ingreso nuevamente el correo electronico "jufeufecenno-3027@yopmail.com"
    Y        doy click en validar identidad del titular
    Y        ingreso los datos solicitados para la validacion del cliente
      | nombrePadre   | nombreMadre   | distritoNac   |
      | <nombrePadre> | <nombreMadre> | <distritoNac> |
    Entonces valido que me muestre el boton con el texto de identidad validada
    Y        doy click en Validar contrato "Móvil"
    Y        me muestra en pantalla el contrato solicitado
    Y        imprimo el texto del contrato solicitado
    Cuando   doy clic en si acepto
    Y        doy click en Finalizar registro
    Entonces visualizo en pantalla el mensaje de exito de la venta generada
    Y        doy click en ver detalle del pedido
    Y        valido que se muestre el detalle del pedido de "Servicio Móvil"
    Y        valido que se muestre el detalle del pedido de "Delivery"
    Y        valido que se muestre el detalle del pedido de "Información adicional"
    Dado     regreso a la pagina de inicio
    Entonces valido el login exitoso mediante el mensaje "<msgHome>"
    Y        me dirijo a la bandeja de Back Office
    Y        busco por "codigo de venta"
    Y        selecciono la solicitud
    Y        cargo el audio en la web
    Y        apruebo la solicitud

    Ejemplos:
      | userType | userName   | userPassword   | msgHome    | channelType | documentType | documentNumber | phoneNumber | tipoLinea | operador | tipoPlanMovil | nombrePlan                    | nombreMadre | nombrePadre | distritoNac  |
      | userType | userNameCC | userPasswordCC | Bienvenid@ | Call Center | DNI          | 75102008       | 920956251   | Postpago  | ENTEL    | Postpago      | RV Plan Ilimitado Mi Movistar | EMERITA     | GONZALO     | LA ESPERANZA |

