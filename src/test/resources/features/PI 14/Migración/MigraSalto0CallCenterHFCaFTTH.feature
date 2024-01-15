#language:es

##CREADOR:
##APP: DITO
##MODULO:
##FUNCIONALIDAD:
##ESTADO:
##CODIGO: AT-DT104
##GDAP: GDAP-1143
##SPRINT CREADO:
##FRECUENCIA:
##TAG : BERSERKERS
##DATA:
##ENCARGADO:
##FECMOD: 30/03/2023
@BERSERKERS @QAN @DoneDevOps @DoneDevOpsPI13 @AT-DT104
Característica: AT-DT104_Migracion salto 0 HFC FTTH canal Call Center

  Antecedentes:
    Dado     que abro la pagina de movistar

@migraSalto0HFC_FTTHCallCenter
  Esquema del escenario: Migracion salto 0 HFC FTTH con CE  por canal Call Center
    Cuando   presiono el boton Iniciar Sesion
    Y        selecciono el tipo de usuario "<tipoUsuario>"
    Y        ingreso el usuario "<userName>"
    Y        ingreso el password "<password>"
    Y        ingreso el captcha
    Y        presiono el boton Continuar hacia el home
    Y        valido el login exitoso mediante el mensaje "<msgHome>"
    Cuando   selecciono el tipo de documento "<tipoDocumento>"
    Y        ingreso el documento "<documento>"
    Y        doy click en el boton consultar
    Y        selecciono la cartilla del plan activo
    Y        selecciono el boton Mostrar ofertas
    Y        doy click en el boton "Confirmar direccion"
    Y        valido que este en la pagina de ofertas sugeridas
    Y        selecciono la opcion Migrar a fibra
    Cuando   doy clic en iniciar registro
    Y        valido que muestre la pantalla de Agendamiento
    #Y        ingreso datos de agendamiento "987654321" y doy clic en continuar
    #Y        valido que me encuentre en la pantalla agendamiento
    Y        ingreso los datos de agendamiento
    Y        presiono el boton confirmar agendamiento
    Y        ingreso email "qaAutmator@gmail.com" y lo confirmo
    Y        doy clic para validar contrato hogar
    Y        me muestra en pantalla el contrato solicitado
    Y        imprimo el texto del contrato solicitado
    Y        guardo el numero de solicitud
    Cuando   doy clic en si acepto
    Y        doy click en el boton de continuar
    #Y        presiono el boton Registrar venta
    Entonces visualizo en pantalla el mensaje de exito de la venta generada
    Dado     regreso a la pagina de inicio
    Entonces valido el login exitoso mediante el mensaje "Bienvenid@"
    Y        me dirijo a la bandeja de Back Office
    Y         busco por el documento
    Y        selecciono la solicitud
    Y        cargo el audio en la web
    Y        apruebo la solicitud

    Ejemplos:
      | tipoUsuario     | userName | password     | msgHome    | tipoDocumento | documento  | correo           | tipoValidacion | nombreMadre | nombrePadre | distritoNac | tipoPlanHogar | planTrio                                           |
      | usuario interno |  | | Bienvenid@ | CE            | 1100000756 | correo@gmail.com | discapacitado  | MARIBEL     | JOSE        | SULLANA     | Trío          | Trío Movistar Voz Internet Estandar HD RA 100 Mbps |
