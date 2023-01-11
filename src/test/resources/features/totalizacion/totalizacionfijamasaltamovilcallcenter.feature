#language: es

@BERSERKERS @DoneDevOps @DoneDevOpsPI14

  Característica: totalizacion servicio fijo mas alta movil por canal call center

    Antecedentes:
      Dado     que abro la pagina de movistar

    @totalizaciontriomasaltamovil

    Escenario: scenario: totalizazion del servicio fijo mas una alta movil por call center sin biometria
      Cuando   presiono el boton Iniciar Sesion
      Y        selecciono el tipo de usuario "usuario externo"
      Y        ingreso el usuario "jpachaot"
      Y        ingreso el password "$t3l3f0n1c4$"
      Y        presiono el boton Continuar hacia el home
      Y        valido el login exitoso mediante el mensaje "Bienvenid@"
      Y        valido que se presente la tienda "CANAL ONLINE-CALL CENTER GSS"
      Cuando   selecciono el tipo de documento "CE"
      Y        ingreso el documento "1233286899"
      Y        doy click en el boton consultar
      Y        selecciono la cartilla del plan activo
      Y        selecciono el boton Linea Nueva Movil
      Y        selecciono el boton Mostrar ofertas
      #Y        verifico la direccion "JULIO CESAR TELLO,469" actual del servicio
      #Y        doy click en en el boton "Confirmar direccion"
      Entonces me muestra la pantalla de ofertas sugeridos
      Y        luego doy click en la cartilla ir a Movistar Total
      Cuando   doy clic a iniciar registro
    #Y        valido que me encuentre en la pantalla agendamiento
    #Y        ingreso los datos de agendamiento
    #Y        presiono el boton confirmar agendamiento
     # Entonces  me muestra la pantalla para ingresar la direccion
   Y        selecciono el departamento donde sera la instalacion "15"
    Y        selecciono la provincia donde sera la instalacion "1501"
    Y        selecciono el distrito donde sera la instalacion "150116"
    Y        ingreso la direccion donde sera la instalacion "JIRON JULIO CESAR TELLO 469"
      Y        ingreso la referencia de la direccion "Inkafarma"
      Y        presiono el boton Consultar ubicacion
      Y        ingreso la informacion del lugar de instalacion
        | mz | lote | vivienda | nombreVivienda | piso | int | conjunto             | conjHabit |
        | A  | 1    | casa     | alex mancilla  | 1    | 1   | URBANIZACION POPULAR | casa      |
      Y        Consulto ubicacion
      Y        selecciono un tipo de entrega "Delivery Regular 48 horas"
      Y        selecciono horario "2pm-7pm"
      E        ingreso telefono del titular "998877665"
      E        ingreso instrucciones de delivery "cerca al parque"
      Y        doy clic en confirmar delivery
      Y        ingreso un correo electronico "PRUEBA@GMAIL.COM"
      Y        ingreso nuevamente el correo electronico "PRUEBA@GMAIL.COM"
      Y        doy clic para validar contrato Movil
      Y        me muestra en pantalla el contrato solicitado
      Cuando   doy clic en si acepto
      Y        doy click en el boton de continuar
      Y         presiono el boton Registrar venta
      Entonces visualizo en pantalla el mensaje de exito de la venta generada
      Y        valido que se muestre el detalle del pedido
