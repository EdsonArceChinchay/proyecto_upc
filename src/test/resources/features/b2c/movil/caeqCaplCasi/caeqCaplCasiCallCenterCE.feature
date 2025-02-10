#language:es
##CREADOR:
##APP: DITO
##MODULO: MOVÍL
##FUNCIONALIDAD:
##ESTADO:
##CODIGO: AT-DT046
##GDAP: GDAP-712
##SPRINT CREADO:
##FRECUENCIA:
##TAG : BERSERKERS
##DATA: REUSABLE (CANCELAR ORDEN EN VUELO)
##ENCARGADO:
##FECMOD: 30/09/2024

@BERSERKERS @DoneDevOps @DoneDevOpsPI12
Característica: AT-DT046_Cambio de Equipo (CAEQ) mas Cambio de plan (CAPL) sin Cambio de SIM (CASI) a cliente con CE por canal Call Center

  @CaeqCapl
  Esquema del escenario: Como usuario <userName> de la Tienda <channelType> realizo un CAEQ mas CAPL sin CASI a cliente con CE por canal Call Center
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
    Y        selecciono el boton Ver detalle del plan actual y presiono el boton Renovar Plan
    Y        valido que se presente la pantalla con el titulo "Ofertas sugeridas"
    Y        presiona el boton anadir equipo
    E        ingreso permanencia, tipo de pago y equipo
      | permanencia | tipoPago   | equipoName                        |
      | 12 meses    | Al Contado | SAMSUNG GXY A34 NEGRO A346M 128GB |
    Y        valido que existan resultados busqueda de equipos
    Y        presiono el boton Ver detalle valido contenido y selecciono
    Y        doy click en el boton "Cambiar Plan"
    Y        valido que este en el resumen de venta
    Y        doy click en el boton Iniciar registro
    Y        selecciono el departamento donde sera la instalacion "LIMA"
    Y        selecciono la provincia donde sera la instalacion "LIMA"
    Y        selecciono el distrito donde sera la instalacion "LINCE"
    Y        ingreso la direccion donde sera la instalacion "JIRON JULIO CESAR TELLO 469"
    Y        ingreso la referencia de la direccion "conjunto b"
    Y        presiono el boton Consultar ubicacion
    Y        presiono el boton Confirmar ubicacion
    Y        selecciono un tipo de entrega "Delivery Regular 24 horas"
    Y        selecciono el horario de entrega "3pm-7pm"
    Y        ingreso telefono de contacto "956756143"
    Y        ingreso instrucciones de delivery "abc"
    Y        doy click en confirmar delivery
    Y        selecciono el metodo de pago "Contra entrega"
    Y        ingreso correo electronico "prueba_qa@gmail.com"
    Y        ingreso nuevamente el correo electronico "prueba_qa@gmail.com"
    Y        doy click en Validar contrato "Móvil"
    Y        me muestra en pantalla el contrato solicitado
    Y        imprimo el texto del contrato solicitado
    Cuando   doy clic en si acepto
    Y        valido que CAEQ:"True", CAPL: "True" y CASI:"False" en el response del salesLead
     Y        doy click en el boton de continuar
    Entonces visualizo en pantalla el mensaje de exito de la venta generada
    Y        doy click en ver detalle del pedido
    Y        valido que se muestre el detalle del pedido de "Servicio Móvil"
    Y        valido que se muestre el detalle del pedido de "Delivery"
    Y        valido que se muestre el detalle del pedido de "Información adicional"
    Dado     regreso a la pagina de inicio
    Entonces valido el login exitoso mediante el mensaje "Bienvenid@"
    Y        me dirijo a la bandeja de Back Office
    Y        busco por "codigo de venta"
    Y        selecciono la solicitud
    Y        cargo el audio en la web
    Y        apruebo la solicitud

    Ejemplos:
      | userType | userName   | userPassword   | msgHome    | channelType | documentType | documentNumber |
      | userType | userNameCC | userPasswordCC | Bienvenid@ | Call Center | CE           | 1042464630     |

