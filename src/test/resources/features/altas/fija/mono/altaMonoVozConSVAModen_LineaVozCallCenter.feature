#language:es
@BERSERKERS @DoneDevOps @DoneDevOpsPI14SP2

Característica: Alta Mono Linea Voz Tienda

  @AltaMonoLineaVoz_Modem_svaLineaCallCenter
  Esquema del escenario: Yo como asesor de Tiendas realizare un alta Mono Linea Voz a un cliente nuevo con CE
	Dado     que abro la pagina de movistar
	Cuando   presiono el boton Iniciar Sesion
	Y        selecciono el tipo de usuario "usuario externo"
	Y        ingreso el usuario "jpachaot"
	Y        ingreso el password "$t3l3f0n1c4$"
	Y        presiono el boton Continuar hacia el home
	Entonces valido el login exitoso mediante el mensaje "Bienvenid@"
	Cuando   selecciono el tipo de documento "CE"
	Y        ingreso el documento "1029392562"
	Y        doy click en el boton consultar
	#Y        cierro popup de error
#	Y        ingreso los datos del cliente extranjero a registrar
#	  | nombres | apellidos | genero    |
#	  | Carlos  | Vicente   | masculino |
	Y        selecciono el boton Linea Nueva Hogar
	Y        selecciono el boton Mostrar ofertas
	Entonces me muestra la pantalla para ingresar la direccion
	Y        completo los datos para consultar la cobertura
	  | departamento | provincia | distrito | direccion                   | referencia |
	  | 15           | 1501      | 150116   | JIRON JULIO CESAR TELLO 460 | parque     |
	Y        presiono el boton Consultar Ubicacion
	Y        ingreso la informacion del lugar para la instalacion
	  | mz | lote | vivienda      | nombreVivienda | piso | int | conjunto             | conjHabit |
	  | A  | 1    | alex mancilla | alex mancilla  | 2    | 3   | URBANIZACION POPULAR | casa      |
	Y        presiono el boton Consultar Cobertura
	Y        selecciono tipo de oferta
	Y        selecciono el tipo de plan fija "<tipoPlan>"
	Y        selecciono el plan "<nombrePlan>"
	Y doy click en agregar Modem
	Y        doy click en agregar SVA Linea "Plan Multidestino 20"
	Cuando   doy clic a iniciar registro
	Y        valido que me encuentre en la pantalla agendamiento
	Y        ingreso telefono de contacto
	Y        presiono el boton Confirmar agendamiento
	Y        ingreso email "prueba@prueba.com" y lo repito
	Y        doy click en datos del cliente
	Y        ingreso los datos del cliente
	  | fechaNac   | estadoCivil | nacionalidad |
	  | 12/12/1999 | Casado      | Albania      |
	Y        doy click en el boton confirmar
	Y        presiono la opcion validar contrato
	Y        me muestra en pantalla el contrato solicitado
	Cuando   doy clic en si acepto
	Y        doy click en el boton de continuar
	Y        presiono el boton Registrar venta
	Entonces visualizo en pantalla el mensaje de exito de la venta generada
    #Y        valido que se muestre el detalle del pedido

	Ejemplos:
	  | nombrePlan                                         | tipoPlan |
	  | Trío Mov. Voz Internet Estandar HD RA D22 200 Mbps | Trío     |