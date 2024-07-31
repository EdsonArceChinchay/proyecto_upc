#language:es
##CREADOR:
##APP: DITO
##MODULO:
##FUNCIONALIDAD:
##ESTADO: ACTIVO
##CODIGO:
##GDAP: GDAP-1420
##SPRINT CREADO:
##FRECUENCIA:
##TAG : BERSERKERS
##DATA: REUSABLE (CANCELAR ORDENES EN VUELO)
##ENCARGADO:
##FECMOD: 17/07/2024

@BERSERKERS @DoneDevOps @DoneDevOpsPI12
Característica: Cambio de equipo mas cambio de simcard a cliente extranjero (CE) por canal Call Center

  @CaeqCasiCallCenter
  Esquema del escenario: Cambio de equipo mas cambio de simcard a cliente extranjero (CE) por canal Call Center
    Dado     que abro la pagina de movistar
    Cuando   presiono el boton Iniciar Sesion
    Y        selecciono el tipo de usuario "<tipoUsuario>"
    Y        ingreso el usuario "<userName>"
    Y        ingreso el password "<password>"
    Y        ingreso el captcha
    Y        presiono el boton Continuar hacia el home
    Entonces valido el login exitoso mediante el mensaje "<msgHome>"
    Cuando   selecciono el tipo de documento "<tipoDocumento>"
    Y        ingreso el documento "<documento>"
    Y        doy click en el boton Consultar
    Y        selecciona el boton de detalle del numero de celular existente "<EncontrarCelular>"
    Y        doy click en el boton "Renovar plan"
    Y        valido que se presente la pantalla con el titulo "Ofertas sugeridas"
    Y        presiona el boton anadir equipo del mismo plan
    E        ingreso permanencia, tipo de pago y equipo
      | permanencia | tipoPago   | equipoName                        |
      | 12 meses    | Al Contado | SAMSUNG GXY A34 NEGRO A346M 128GB |
    Y        valido que existan resultados busqueda de equipos
    Y        presiono el boton Ver detalle valido contenido y selecciono
    Y        doy click en el boton "Mantener Plan"
    Y        valido que este en el resumen de venta
    Y        doy click en el boton Iniciar registro
    Y        selecciono el departamento donde sera la instalacion "15"
    Y        selecciono la provincia donde sera la instalacion "1501"
    Y        selecciono el distrito donde sera la instalacion "150116"
    Y        ingreso la direccion donde sera la instalacion "JIRON JULIO CESAR TELLO 469"
    Y        ingreso la referencia de la direccion "conjunto b"
    Y        presiono el boton Consultar ubicacion
    Y        ingreso la informacion del lugar de instalacion
      | mz | tipoVivienda | nombreVivienda | piso | int | conjunto             | conjHabit  |
      | A  | EDIFICIO     | Familia Lopez  | 1    | 1   | URBANIZACION POPULAR | conjunto b |
    Y        presiono el boton Confirmar ubicacion
    Y        selecciono un tipo de entrega "Delivery Regular 24 horas"
    Y        selecciono el horario de entrega "3pm-7pm"
    Y        ingreso telefono de contacto "984093119"
    Y        ingreso instrucciones de delivery "abc"
    Y        doy click en confirmar delivery
    Y        selecciono el metodo de pago "Contra entrega"
    Y        ingreso correo electronico "prueba_qa@gmail.com"
    Y        ingreso nuevamente el correo electronico "prueba_qa@gmail.com"
    Y        doy click en Validar contrato "Móvil"
    Y        me muestra en pantalla el contrato solicitado
    Y        imprimo el texto del contrato solicitado
    Cuando   doy clic en si acepto
    Y        valido que CAEQ:"True", CAPL: "False" y CASI:"True" en el response del salesLead
    Y        doy click en el boton Continuar
    Entonces visualizo en pantalla el mensaje de exito de la venta generada
    Y        doy click en ver detalle del pedido
    Y        valido que se muestre el detalle del pedido de "Servicio Móvil"
    Y        valido que se muestre el detalle del pedido de "Delivery"
    Y        valido que se muestre el detalle del pedido de "Información adicional"
    Dado     regreso a la pagina de inicio
    Entonces valido el login exitoso mediante el mensaje "Bienvenid@"
    Y        me dirijo a la bandeja de Back Office
    Y        busco por "<documento>"
    Y        selecciono la solicitud
    Y        cargo el audio en la web
    Y        apruebo la solicitud

    Ejemplos:
      | tipoUsuario     | userName   | password | msgHome    | tipoDocumento | documento | EncontrarCelular |
      | usuario externo | userNameCC | passCC   | Bienvenid@ | CE            | 723456454 | 650034426        |


