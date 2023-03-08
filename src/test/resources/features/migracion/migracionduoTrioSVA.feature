#language:es

<<<<<<< HEAD
<<<<<<< HEAD
	# CREADOR: Angel Medina

@BERSERKERS @DoneDevOps @DoneDevOpsPI11 @RegresionPangea @Sanity28
=======
@BERSERKERS @DoneDevOps @DoneDevOpsPI11 @RegresionPangea @Sanity28 @AT-DT065
>>>>>>> 555beea0be65bc959f8b0e12d82448473ba083d9
=======
	# CREADOR: Angel Medina

@BERSERKERS @DoneDevOps @DoneDevOpsPI11 @RegresionPangea @Sanity28 @AT-DT065
>>>>>>> 9e3602de27a813ae282a57d006ab512b6e5b94d5

Característica: AT-DT065_Migracion de duo a Trio + sva


  Antecedentes:
	Dado     que abro la pagina de movistar

  @MigracionduoTrioSVA @MVP07 @Global @General
  Esquema del escenario:Migracion de duo a Trio + sva
	Cuando   presiono el boton Iniciar Sesion
	Y        selecciono el tipo de usuario "<tipoUsuario>"
	Y        ingreso el usuario "<userName>"
	Y        ingreso el password "<password>"
	Y        presiono el boton Continuar hacia el home
	Y         valido el login exitoso mediante el mensaje "<msgHome>"
	Y        valido que se presente la tienda "<tiendaAsesor>"
	Cuando   selecciono el tipo de documento "<tipoDocumento>"
	Y        ingreso el documento "<documento>"
	Y        doy click en el boton consultar
	Y        selecciono la cartilla del plan activo
	Y        selecciono el boton Mostrar ofertas
	#Y       verifico la direccion "SAN MIGUEL,LIMA ,LIMA" actual del servicio
	Y        doy click en el boton "Confirmar direccion"
	Y        selecciono tipo de oferta
	Y        selecciono el tipo de plan Hogar "<tipoPlanHogar>"
	Y        selecciono la oferta "<plan>"
	Y        doy click en Cambiar plan hogar
	Y        valido que este en la seccion de registro
	Y        doy click en agregar "<sva>"
	Cuando   doy clic a iniciar registro
	Y        valido que me encuentre en la pantalla agendamiento
	Y        ingreso los datos de agendamiento
	Y        presiono el boton confirmar agendamiento
	Y        ingreso un correo electronico "<correo>"
	Y        ingreso nuevamente el correo electronico "<correo>"
	Y        doy clic para validar contrato hogar
	Y        me muestra en pantalla el contrato solicitado
	Cuando   doy clic en si acepto
	Y        doy click en el boton de continuar
	Y         presiono el boton Registrar venta
	Entonces visualizo en pantalla el mensaje de exito de la venta generada
	Y        valido que se muestre el detalle del pedido
	Ejemplos:
	  | tipoUsuario     | userName    | password         | msgHome    | tiendaAsesor      | tipoDocumento | documento | correo           | sva                   | nombreMadre | nombrePadre | distritoNac | tipoPlanHogar | plan                                               |
	  | usuario externo | lterrazosce | Telefonica2021   | Bienvenid@ | TIENDA SAN MIGUEL | CE            | 192920952 | correo@gmail.com | PACK ANTIVIRUS MCAFEE | MARIBEL     | JOSE        | SULLANA     | Trío          | TRÍO MOV. VOZ INTERNET ESTANDAR HD RA D22 100 MBPS |
