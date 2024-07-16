#language:es
##CREADOR:Eloy Milla
##APP: DITO
##MODULO:
##FUNCIONALIDAD:Migra
##ESTADO:
##CODIGO:
##GDAP:GDAP-1442
##SPRINT CREADO:PI18 SP4
##FRECUENCIA:
##TAG : BERSERKERS
##DATA:
##ENCARGADO:
##FECMOD:
@FEMS3-5457
@BERSERKERS @DoneDevOps
Característica: Migracion Mono Voz a Trio por el canal Call Center con CE

  Antecedentes:
    Dado     que abro la pagina de movistar

  @MigraMonoVozATrioCallCenter
  Esquema del escenario: Migracion de Mono voz a Trio por canal Call Center
    Cuando   presiono el boton Iniciar Sesion
    Y        selecciono el tipo de usuario "<tipoUsuario>"
    Y        ingreso el usuario "<userName>"
    Y        ingreso el password "<password>"
    E        ingreso el captcha
    Y        presiono el boton Continuar hacia el home
    Y         valido el login exitoso mediante el mensaje "<msgHome>"
    Cuando   selecciono el tipo de documento "<tipoDocumento>"
    Y        ingreso el documento "<documento>"
    Y        doy click en el boton consultar
    Y        selecciono la cartilla del plan activo
    Y        selecciono el boton Mostrar ofertas
    Y        doy click en el boton "Actualizar direccion"
    Y        ingreso la referencia de la direccion "casa"
    Y        presiono el boton Consultar Ubicacion
    Y        presiono el boton consultar cobertura
    Y        doy clic en el boton "entendido"
    #Y        selecciono tipo de oferta
    #Y        selecciono el tipo de plan Hogar "<tipoPlanHogar>"
    #Y        selecciono la oferta "<plan>"
    Y        doy click en Cambiar plan hogar
    Y        valido que este en el resumen de venta
    Cuando   doy clic a iniciar registro
    Y        valido que muestre la pantalla de Agendamiento
    Y        ingreso los datos de agendamiento
    Y        presiono el boton confirmar agendamiento
    Y        ingreso email "qaAutmator@gmail.com" y lo confirmo
    Y        doy clic para validar contrato hogar
    Y        me muestra en pantalla el contrato solicitado
    Cuando   doy clic en si acepto
    Y        doy click en el boton de continuar
    Entonces visualizo en pantalla el mensaje de exito de la venta generada
    Y        doy click en ver detalle del pedido
    Y        valido que se muestre el detalle del pedido de "Servicio Hogar"
    Y        valido que se muestre el detalle del pedido de "Dirección de instalación"
    Y        valido que se muestre el detalle del pedido de "Información adicional"
    Dado     regreso a la pagina de inicio
    Entonces valido el login exitoso mediante el mensaje "Bienvenid@"
    Y        me dirijo a la bandeja de Back Office
    Y        busco por "<documento>"
    Y        selecciono la solicitud
    Y        cargo el audio en la web
    Y        apruebo la solicitud

    Ejemplos:
      | tipoUsuario     | userName   | password | msgHome    | tipoDocumento | documento | tipoPlanHogar | plan                                           |
      | usuario externo | userNameCC | passCC   | Bienvenid@ | CE            | 202300004 | TRÍO          | TRIO MOV. VOZ INT. ESTANDAR HD RA A24 100 MBPS |
