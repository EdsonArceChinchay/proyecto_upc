#language:es
##CREADOR:
##APP: DITO
##MODULO:
##FUNCIONALIDAD:
##ESTADO:
##CODIGO: AT-DT046
##GDAP: GDAP-712
##SPRINT CREADO:
##FRECUENCIA:
##TAG : BERSERKERS
##DATA:
##ENCARGADO:
##FECMOD: 24/10/2023

@BERSERKERS @DoneDevOps @DoneDevOpsPI12
Característica: AT-DT046_CAEQ Mas CAPL Mas CASI con documento CE por canal Call Center

  @CaeqCaplCasi
  Esquema del escenario: Como usuario <userName> de la Tienda <tiendaAsesor> deseo consultar el cliente con <tipoDocumento>: <documento>
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
    Y        doy click en el boton consultar
    Y        selecciono el boton Ver detalle del plan actual y presiono el boton Renovar Plan
    Y        valido que se presente la pantalla con el titulo "Ofertas sugeridas"
    Y        presiona el boton anadir equipo
    E        ingreso permanencia, tipo de pago y equipo
      | permanencia | tipoPago   | equipoName                               |
      | 12 meses    | Al Contado | SAMSUNG GXY A34 NEGRO A346M 128GB C/CAMP |
    Y        selecciono tipo de pago Al Contado
    Y        valido que existan resultados busqueda de equipos
    Y        presiono el boton Ver detalle valido contenido y selecciono
    Y        doy click en el boton "Cambiar Plan"
    Y        doy click en iniciar registro
    Y        selecciono el departamento donde sera la instalacion "15"
    Y        selecciono la provincia donde sera la instalacion "1501"
    Y        selecciono el distrito donde sera la instalacion "150116"
    Y        ingreso la direccion donde sera la instalacion "JIRON JULIO CESAR TELLO 469"
    Y        ingreso la referencia de la direccion "conjunto b"
    Y        presiono Consultar ubicacion
   #Y        ingreso la informacion del lugar de instalacion
    #  | mz | tipoVivienda | nombreVivienda | piso | int | conjunto             | conjHabit  |
     # | A  | EDIFICIO     | Familia Lopez  | 1    | 1   | URBANIZACION POPULAR | conjunto b |
    Y        presiono el boton consultar cobertura
    Y        selecciono un tipo de entrega "Delivery Regular 24 horas"
    Y        selecciono el horario de entrega "3pm-7pm"
    Y        ingreso el telefono de contacto "956756143"
    Y        ingreso las instrucciones a considerar de la entrega "abc"
    Y        doy clic en confirmar delivery
    Y        selecciono el metodo de pago "Contra entrega"
    Y        ingreso un correo electronico "prueba_qa@gmail.com"
    Y        ingreso nuevamente el correo electronico "prueba_qa@gmail.com"
    Y        doy clic para validar contrato Movil
    Y        me muestra en pantalla el contrato solicitado
    Y        imprimo el texto del contrato solicitado
    Cuando   doy clic en si acepto
    Y        valido que CAEQ:"True", CAPL: "True" y CASI:"True" en el response del salesLead
    Y        doy clic en continuar
    Entonces visualizo en pantalla el mensaje de exito de la venta generada
    Y        doy click en ver detalle del pedido
    Y        valido que se muestre el detalle del pedido de "Servicio Móvil"
    Dado     regreso a la pagina de inicio
    Entonces valido el login exitoso mediante el mensaje "Bienvenid@"
    Y        me dirijo a la bandeja de Back Office
    Y        busco por "<documento>"
    Y        selecciono la solicitud
    Y        cargo el audio en la web
    Y        apruebo la solicitud

    Ejemplos:
      | tipoUsuario     | userName   | password | msgHome    | tiendaAsesor              | tipoDocumento | documento  | tipoPlan | nombrePlan                     |
      | usuario externo | userNameCC | passCC   | Bienvenid@ | PRUEBAS SIST CALLIN VENTA | CE            | 1042464630 | Postpago | Plan Movil Movistar Total ilim |
#      | usuario interno | | | Bienvenid@ | PRUEBAS SIST CALLIN VENTA | CE            | 1100000273 | Postpago | Plan Movil Movistar Total ilim |
#      | usuario interno | | | Bienvenid@ | PRUEBAS SIST CALLIN VENTA | CE            | 1100000808 | Postpago | Plan Movil Movistar Total ilim |
#      | usuario interno | | | Bienvenid@ | PRUEBAS SIST CALLIN VENTA | CE            | 1100000806 | Postpago | Plan Movil Movistar Total ilim |
#      | usuario interno | | | Bienvenid@ | PRUEBAS SIST CALLIN VENTA | CE            | 1100000755 | Postpago | Plan Movil Movistar Total ilim |
