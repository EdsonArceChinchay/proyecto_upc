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
    Y        presiono el boton Continuar hacia el home
    Y         valido el login exitoso mediante el mensaje "<msgHome>"
    Cuando   selecciono el tipo de documento "<tipoDocumento>"
    Y        ingreso el documento "<documento>"
    Y        doy click en el boton consultar
    Y        selecciono la cartilla del plan activo
    Y        selecciono el boton Mostrar ofertas
    Y        doy click en el boton "Confirmar direccion"
    Y        selecciono tipo de oferta
    Y        selecciono el tipo de plan Hogar "<tipoPlanHogar>"
    Y        selecciono la oferta "<plan>"
    Y        doy click en Cambiar plan hogar
    Y        valido que este en la seccion de registro
    Cuando   doy clic a iniciar registro
    Y        valido que muestre la pantalla de Agendamiento
    Y        ingreso los datos de agendamiento
    Y        presiono el boton confirmar agendamiento
    Y        ingreso email "qaAutmator@gmail.com" y lo confirmo
    Y        doy clic para validar contrato hogar
    Y        me muestra en pantalla el contrato solicitado
    Y        guardo el numero de solicitud
    Cuando   doy clic en si acepto
    Y        doy click en el boton de continuar
    Entonces visualizo en pantalla el mensaje de exito de la venta generada
    Dado     regreso a la pagina de inicio
    Entonces valido el login exitoso mediante el mensaje "Bienvenid@"
    Y        me dirijo a la bandeja de Back Office
    Y        busco por "solicitud"
    Y        selecciono la solicitud
    Y        cargo el audio en la web
    Y        apruebo la solicitud

    Ejemplos:
      | tipoUsuario     | userName   | password | msgHome    | tipoDocumento | documento | correo            | tipoPlanHogar | plan                        |
      | usuario externo | userNameCC | passCC   | Bienvenid@ | CE            | 202300004 | tester@tester.com | TRÍO          | TRÍO MOVISTAR VOZ INTERNET ESTANDAR HD RA 150 MBPS |