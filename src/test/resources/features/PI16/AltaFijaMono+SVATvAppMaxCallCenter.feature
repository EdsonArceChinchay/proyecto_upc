#language:es

##CREADOR:Maria Sanchez
##APP: DITO
##MODULO:
##FUNCIONALIDAD:
##ESTADO:
##CODIGO: AT-DT114
##GDAP: GDAP-1388
##SPRINT CREADO: PI16 SP1
##FRECUENCIA:
##TAG : BERSERKERS
##DATA:
##ENCARGADO:
##FECMOD: 07/07/2023

@BERSERKERS @DoneDevOps @DoneDevOpsPI15

Característica: ALTA FIJA MONO + SVA Movistar Tv App Max Call center
  Antecedentes:
	Dado     que abro la pagina de movistar

  @AltaFijaMonoSVATvAppMaxCallCenter
  Esquema del escenario: ALTA FIJA MONO + SVA Tv App Max Call Center
	Cuando   presiono el boton Iniciar Sesion
	Y        selecciono el tipo de usuario "<tipoUsuario>"
	Y        ingreso el usuario "<userName>"
	Y        ingreso el password "<password>"
	Y        presiono el boton Continuar hacia el home
	Entonces valido el login exitoso mediante el mensaje "<msgHome>"
	Cuando   selecciono el tipo de documento "<tipoDocumento>"
	Y        ingreso el documento "<documento>"
	Y        doy click en el boton consultar
	Y        cierro popup de error
	Y        ingreso los datos del cliente extranjero a registrar
	  | nombres  | apellidos    | genero    |
	  | Elias    | Lopez Lopez  | masculino |
	Y        selecciono el boton Linea Nueva Hogar
	Y        selecciono el boton Mostrar ofertas
	Entonces me muestra la pantalla para ingresar la direccion
	Y        selecciono el departamento donde sera la instalacion "<departamento>"
	Y        selecciono la provincia donde sera la instalacion "<provincia>"
	Y        selecciono el distrito donde sera la instalacion "<distrito>"
	Y        ingreso la direccion donde sera la instalacion "<direccion>"
	Y        ingreso la referencia de la direccion "<referencia>"
	Y        presiono el boton Consultar ubicacion
    #Y        ingreso la informacion del lugar de instalacion
	  # | mz | lote | vivienda | nombreVivienda  | piso | int | conjunto             | conjHabit  |
      #| D  | 11   | EDIFICIO | Familia Lopez   | 3    | 2   | URBANIZACION POPULAR | conjunto c |
	Y        presiono el boton consultar cobertura
	Y        selecciono tipo de oferta
	Y        selecciono el tipo de plan fija "<tipoPlan>"
	Y        selecciono el plan "<nombrePlan>"
	Y        valido que este en la seccion de registro
	Entonces doy click en Agregar Sva
	Y        doy click en agregar Movistar TV App
	Y        doy click en Guardar cambios
	Cuando   doy clic a iniciar registro
	Y        valido que me encuentre en la pantalla agendamiento
	Y        ingreso los datos de agendamiento
	Y        presiono el boton confirmar agendamiento
	Y        ingreso un correo electronico "tester_1@tester.com"
	Y        ingreso nuevamente el correo electronico "tester_1@tester.com"
	Y        doy click en datos del cliente
	Y        ingreso los datos del cliente
	  | fechaNac   | estadoCivil | nacionalidad |
	  | 15/09/1993 | Casado      | Angola       |
	Y        doy click en el boton confirmar
	Y        doy clic para validar contrato hogar
	Y        me muestra en pantalla el contrato solicitado
	Cuando   doy clic en si acepto
	Y        doy clic en continuar
	#Y        presiono el boton Registrar venta
	Entonces visualizo en pantalla el mensaje de exito de la venta generada
	Ejemplos:
	  | tipoUsuario     | userName | password     | msgHome    |  tipoDocumento | documento  | departamento | provincia | distrito | direccion             | referencia | tipoPlan | nombrePlan                       |
	  | usuario externo | jpachaot | $t3l3f0n1c4$ | Bienvenid@ |  CE            | 1548788787 | 15           | 1501      | 150116   | JULIO CESAR TELLO 469 | casa       | Mono     | INTERNET MOVISTAR RA D22 200 MBPS|