#language: es

##CREADOR: Henry salas
##APP: DITO
##MODULO:
##FUNCIONALIDAD:
##ESTADO: REFACTORIZADO 24/08/2023 OK
##CODIGO: AT-DT110
##GDAP: GDAP-1152
##SPRINT CREADO:
##FRECUENCIA:
##TAG : BERSERKERS
##DATA:
##ENCARGADO:
##FECMOD: 31/03/2023

@BERSERKERS @DoneDevOps @DoneDevOpsPI14

Característica: AT-DT110_totalizacion servicio fijo mas alta movil por canal call center

  Antecedentes:
    Dado     que abro la pagina de movistar

  @totalizaciontriomasaltamovil

  Escenario: totalizazion del servicio fijo mas una alta movil por call center sin biometria
    Cuando   presiono el boton Iniciar Sesion
    Y        selecciono el tipo de usuario "usuario externo"
    Y        ingreso el usuario "userNameCC"
    Y        ingreso el password "passCC"
    Y        presiono el boton Continuar hacia el home
    Y        valido el login exitoso mediante el mensaje "Bienvenid@"
    Cuando   selecciono el tipo de documento "CE"
    Y        ingreso el documento "109084827"
    Y        doy click en el boton consultar
    Y        cierro el popup de contraseña Única
    Y        selecciono la cartilla del plan activo
    Y        selecciono el boton Linea Nueva Movil
    Y        cierro el popup de validación de estado de contraseña única
    Y        selecciono el boton Mostrar ofertas
      #Y        verifico la direccion "JULIO CESAR TELLO,469" actual del servicio
    Y        doy click en el boton "Confirmar direccion"
    Entonces valido que se presente la pantalla con el titulo "Ofertas sugeridas"
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
    Y        Consulto ubicacion
    Y        selecciono un tipo de entrega "Delivery Regular 48 horas"
    Y        selecciono horario "3pm-7pm"
    E        ingreso telefono del titular "998877665"
    E        ingreso instrucciones de delivery "cerca al parque"
    Y        doy clic en confirmar delivery
    Y        ingreso un correo electronico "PRUEBA@GMAIL.COM"
    Y        ingreso nuevamente el correo electronico "PRUEBA@GMAIL.COM"
    Y        doy clic para validar contrato Movil
    Y        me muestra en pantalla el contrato solicitado
    Y        imprimo el texto del contrato solicitado
    Cuando   doy clic en si acepto
    Y        doy click en el boton de continuar
    Entonces visualizo en pantalla el mensaje de exito de la venta generada
    Y        valido que se muestre el detalle del pedido
    Dado     regreso a la pagina de inicio
    Entonces valido el login exitoso mediante el mensaje "Bienvenid@"
    Y        me dirijo a la bandeja de Back Office
    Y        busco por "solicitud"
    Y        selecciono la solicitud
    Y        cargo el audio en la web
    Y        apruebo la solicitud