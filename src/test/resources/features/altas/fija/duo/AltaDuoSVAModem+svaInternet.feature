#language:es
@BERSERKERS @DoneDevOps @DoneDevOpsPI12

Característica: Alta Duo sva Modem + SVA Internet

  Antecedentes:
	Dado     que abro la pagina de movistar

  @AltaDuo_Sva_Modem_Sva_Internet
  Esquema del escenario: Alta Duo SVA HBO CALL CENTER
	Cuando   presiono el boton Iniciar Sesion
	Y        selecciono el tipo de usuario "<tipoUsuario>"
	Y        ingreso el usuario "<userName>"
	Y        ingreso el password "<password>"
	Y        presiono el boton Continuar hacia el home
	Entonces valido el login exitoso mediante el mensaje "<msgHome>"
    #Y        valido que se presente la tienda "<tiendaAsesor>"
	Cuando   selecciono el tipo de documento "<tipoDocumento>"
	Y        ingreso el documento "<documento>"
	Y        doy click en el boton consultar
	#Y        cierro popup de error
	Y        ingreso los datos del cliente a registrar
	  | nombres | apellidos    | genero   |
	  | Lana    | Grey Khalifa | femenino |
	Y        selecciono el boton Linea Nueva Hogar
	Y        selecciono el boton Mostrar ofertas
	Entonces me muestra la pantalla para ingresar la direccion
	Y        selecciono el departamento donde sera la instalacion "<departamento>"
	Y        selecciono la provincia donde sera la instalacion "<provincia>"
	Y        selecciono el distrito donde sera la instalacion "<distrito>"
	Y        ingreso la direccion donde sera la instalacion "<direccion>"
	Y        ingreso la referencia de la direccion "<referencia>"
	Y        presiono el boton Consultar ubicacion
	Y        ingreso la informacion del lugar para la instalacion
	  | mz | lote | vivienda      | nombreVivienda | piso | int | conjunto             | conjHabit |
	  | A  | 1    | alex mancilla | alex mancilla  | 2    | 3   | URBANIZACION POPULAR | casa      |
	Y        presiono el boton consultar cobertura
	Y        selecciono tipo de oferta
	Y        selecciono el tipo de plan fija "<tipoPlan>"
	Y        selecciono el plan "<nombrePlan>"
	Y        doy click en agregar "<svaInternet>"
	Y 		 doy click en agregar Modem
	E        inicio su registro
	Y        valido que me encuentre en la pantalla agendamiento
	Y        ingreso los datos de agendamiento
	Y        presiono el boton confirmar agendamiento
	Y        ingreso un correo electronico "Angel.mf@gmail.com"
	Y        ingreso nuevamente el correo electronico "Angel.mf@gmail.com"
#	Y        doy click en datos del cliente
#	Y        completo los datos solicitados
#	  | fechaNac   | nacionalidad | estado_civil |
#	  | 12/12/1980 | Alemania     | Casado       |
	Y        doy clic para validar contrato Movil
	Y        me muestra en pantalla el contrato solicitado
	Cuando   doy clic en si acepto
	Y        doy click en el boton de continuar
	Y        valido que se muestre el detalle del pedido

	Ejemplos:
	  | tipoUsuario     | userName | password     | msgHome    | tiendaAsesor | tipoDocumento | documento  | departamento | provincia | distrito | direccion                   | referencia | plan_hogar | nombrePlan                        | bloque | tipoPlan | svaInternet           |
	  | usuario externo | jpachaot | $t3l3f0n1c4$ | Bienvenid@ | CAJAMARCA    | CE            | 1022233148 | 15           | 1501      | 150116   | JIRON JULIO CESAR TELLO 460 | Casa       | Duo        | DÚO INTERNET ESTÁNDAR HD RA D22 150 MBPS | HBO    | Duo     | PACK ANTIVIRUS MCAFEE |