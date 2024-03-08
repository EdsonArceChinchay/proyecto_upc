#language:es
##CREADOR:
##APP: DITO
##MODULO:
##FUNCIONALIDAD:
##ESTADO:
##CODIGO: AT-DT066
##GDAP: GDAP-581
##SPRINT CREADO:
##FRECUENCIA:
##TAG : BERSERKERS
##DATA:
##ENCARGADO:
##FECMOD: 30/03/2023

@BERSERKERS @DoneDevOps @DoneDevOpsPI11 @DROP35 @AT-DT066

Característica: AT-DT066_Migracion de MT a MT en Call Center

  Antecedentes:
    Dado     que abro la pagina de movistar

  @migracionMTaMT_CC_CE
  Esquema del escenario: Migracion de MT a MT  en el canal CALL CENTER
    Cuando   presiono el boton Iniciar Sesion
    Y        selecciono el tipo de usuario "<tipoUsuario>"
    Y        ingreso el usuario "<userName>"
    Y        ingreso el password "<password>"
    Y        presiono el boton Continuar hacia el home
    Y        valido el login exitoso mediante el mensaje "<msgHome>"
	#Y        valido que se presente la tienda "<tiendaAsesor>"
    Cuando   selecciono el tipo de documento "<tipoDocumento>"
    Y        ingreso el documento "<documento>"
    Y        doy click en el boton consultar
    Y        Selecciono la cartilla del plan Motvistar Total
    #Y        selecciono la cartilla del plan activo
    Y        selecciono el boton Mostrar ofertas
    #Y        verifico la direccion "JULIO CESAR TELLO,469,LINCE,LIMA" actual del servicio
    Y        doy click en el boton "Confirmar direccion"
    Y        selecciono tipo de oferta
    Y        selecciono un plan Movistar Total "<nombrePlan>"
    #Y        luego doy click en la cartilla ir a Movistar Total
    #Y        valido que este en la seccion de registro
    Cuando   doy clic a iniciar registro
    #Cuando   doy clic a iniciar registro
    Y        valido que me encuentre en la pantalla agendamiento
    Y        ingreso los datos de agendamiento
    Y        presiono el boton confirmar agendamiento
    #Y        ingreso un correo electronico "<correo>"
    #Y        ingreso nuevamente el correo electronico "<correo>"
    Y        ingreso un correo electronico "<correo>"
    Y        ingreso nuevamente el correo electronico "<correo>"
    Y        doy clic para validar contrato hogar
    Y        me muestra en pantalla el contrato solicitado
    Cuando   doy clic en si acepto
    Y        doy click en el boton de continuar
    Entonces visualizo en pantalla el mensaje de exito de la venta generada
    Y        valido que se muestre el detalle del pedido
    Dado     regreso a la pagina de inicio
    Entonces valido el login exitoso mediante el mensaje "Bienvenid@"
    Y        me dirijo a la bandeja de Back Office
    Y         busco por el documento
    Y        selecciono la solicitud
    Y        cargo el audio en la web
    Y        apruebo la solicitud

    Ejemplos:
     # | tipoUsuario     | userName | password     | msgHome    | tiendaAsesor      | tipoDocumento | documento | sva MT                | correo           | tipoValidacion | nombreMadre | nombrePadre | distritoNac | tipoPlanHogar | planTrio                                           |
      #| usuario externo | userNameCC | passCC | Bienvenid@ | TIENDA SAN MIGUEL | CE            | 102030051 | PACK ANTIVIRUS MCAFEE | correo@gmail.com | discapacitado  | MARIBEL     | JOSE        | SULLANA     | Trío          | Trío Movistar Voz Internet Estandar HD RA 100 Mbps |
      | tipoUsuario     | userName | password     | msgHome    | tiendaAsesor              | tipoDocumento | documento  | nombrePlan                      | correo            |
      | usuario externo | userNameCC | passCC | Bienvenid@ | PRUEBAS SIST CALLIN VENTA | CE            | 1042464679 | Mono BA 1 Gb RV + 135 Gb RV | tester@tester.com |