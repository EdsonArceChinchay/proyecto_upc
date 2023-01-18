#language:es
@BERSERKERS @DoneDevOps @DoneDevOpsPI11 @DROP35

Característica: Migracion de MT a MT

  Antecedentes:
	Dado     que abro la pagina de movistar

  @migracionTrioMT
  Esquema del escenario: Migracion de MT a MT  en el canal CALL CENTER
	Cuando   presiono el boton Iniciar Sesion
	Y        selecciono el tipo de usuario "<tipoUsuario>"
	Y        ingreso el usuario "<userName>"
	Y        ingreso el password "<password>"
	Y        presiono el boton Continuar hacia el home
	Y        valido el login exitoso mediante el mensaje "<msgHome>"
	Y        valido que se presente la tienda "<tiendaAsesor>"
	Cuando   selecciono el tipo de documento "<tipoDocumento>"
	Y        ingreso el documento "<documento>"
	Y        doy click en el boton consultar
	Y        selecciono la cartilla del plan activo
	Y        selecciono el boton Mostrar ofertas
    #Y        verifico la direccion "JULIO CESAR TELLO,469,LINCE,LIMA" actual del servicio
	Y        doy click en en el boton "Confirmar direccion"
	Y        luego doy click en la cartilla ir a Movistar Total
	Cuando   doy clic a iniciar registro
	#Y        valido que me encuentre en la pantalla agendamiento
	#Y        ingreso los datos de agendamiento
	#Y        presiono el boton confirmar agendamiento
	Y        ingreso un correo electronico "<correo>"
	Y        ingreso nuevamente el correo electronico "<correo>"
	Y        doy clic para validar contrato hogar
	Y        me muestra en pantalla el contrato solicitado
	Cuando   doy clic en si acepto
	Y        doy click en el boton de continuar
	Y        presiono el boton Registrar venta
	Entonces visualizo en pantalla el mensaje de exito de la venta generada
	Y        valido que se muestre el detalle del pedido

	Ejemplos:
	  | tipoUsuario     | userName | password     | msgHome    | tiendaAsesor      | tipoDocumento | documento | sva MT                | correo           | tipoValidacion | nombreMadre | nombrePadre | distritoNac | tipoPlanHogar | planTrio                                           |
	  | usuario externo | jpachaot | $t3l3f0n1c4$ | Bienvenid@ | TIENDA SAN MIGUEL | CE            | 102030051 | PACK ANTIVIRUS MCAFEE | correo@gmail.com | discapacitado  | MARIBEL     | JOSE        | SULLANA     | Trío          | Trío Movistar Voz Internet Estandar HD RA 100 Mbps |
