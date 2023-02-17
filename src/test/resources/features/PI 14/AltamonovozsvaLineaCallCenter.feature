#language:es

@BERSERKERS @DoneDevOps @DoneDevOpsPI14 @Sanity28

Característica: Alta mono voz + sva Linea  en Canal Call Center

  Antecedentes:
	Dado     que abro la pagina de movistar

  @AltamonovozsvaLineaCallCenter
  Esquema del escenario: Alta mono voz + sva Linea  en Canal Call Center
	Cuando   presiono el boton Iniciar Sesion
	Y        selecciono el tipo de usuario "<tipoUsuario>"
	Y        ingreso el usuario "<userName>"
	Y        ingreso el password "<password>"
	Y        presiono el boton Continuar hacia el home
	Entonces valido el login exitoso mediante el mensaje "<msgHome>"
#    Y        valido que se presente la tienda "<tiendaAsesor>"
	Cuando   selecciono el tipo de documento "<tipoDocumento>"
	Y        ingreso el documento "<documento>"
	Y        doy click en el boton consultar
	Y        selecciono el boton Linea Nueva Hogar
	Y        selecciono el boton Mostrar ofertas
	Entonces me muestra la pantalla para ingresar la direccion
	Y        selecciono el departamento donde sera la instalacion "<departamento>"
	Y        selecciono la provincia donde sera la instalacion "<provincia>"
	Y        selecciono el distrito donde sera la instalacion "<distrito>"
	Y        ingreso la direccion donde sera la instalacion "<direccion>"
	Y        ingreso la referencia de la direccion "<referencia>"
	Y        presiono el boton Consultar ubicacion
	Y        ingreso la informacion del lugar de instalacion
	  | mz | lote | vivienda | nombreVivienda    | piso | int | conjunto             | conjHabit  |
	  | D  | 11   | EDIFICIO | Familia Barrios   | 3    | 2   | URBANIZACION POPULAR | conjunto c |
	Y        presiono el boton consultar cobertura
	Y        selecciono tipo de oferta
	Y        selecciono el tipo de plan fija "<tipoPlan>"
	Y        selecciono el plan "<nombrePlan>"
	Y        valido que este en la seccion de registro
	Y        doy click en agregar SVA Linea "<svaLinea>"
	Cuando   doy clic a iniciar registro
	Y        valido que me encuentre en la pantalla agendamiento
	Y        ingreso los datos de agendamiento
	Y        presiono el boton confirmar agendamiento
	Y        ingreso un correo electronico "testing-1@tester.com"
	Y        ingreso nuevamente el correo electronico "testing-1@tester.com"
	Y        ingreso el call id "2BE1772E-ADDB-51B6-865A-7E356D944955"
	Y        doy click en validar identidad del titular
	Y        ingreso los datos solicitados para la validacion del cliente
	  | nombreMadre   | nombrePadre   | distritoNac   |
	  | <nombreMadre> | <nombrePadre> | <distritoNac> |
	Entonces valido que me muestre el boton con el texto de identidad validada
	Y        doy clic para validar contrato Movil
	Y        me muestra en pantalla el contrato solicitado
	Cuando   doy clic en si acepto
	Y        doy click en Finalizar registro
	Entonces visualizo en pantalla el mensaje de exito de la venta generada

	Ejemplos:
	  | tipoUsuario     | userName  | password     | msgHome    |  tipoDocumento | documento  | departamento | provincia | distrito | direccion            | referencia              | tipoPlan | nombrePlan                    |svaLinea                |nombreMadre |nombrePadre |distritoNac|
	  | usuario externo |  jpachaot | $t3l3f0n1c4$ | Bienvenid@ |  DNI           | 75411211   | 15           | 1501      | 150136   | CALLE SAN MARTIN 399 | AL FRENTE DE LA BOTICA  | Mono     | LÍNEA TARIFA PLANA LOCAL VOIP | Plan Multidestino 20   |  CARMEN    |  SANTOS    | TRUJILLO  |