#language:es
##CREADOR:
##APP: DITO
##MODULO:
##FUNCIONALIDAD:
##ESTADO:
##CODIGO: AT-DT012
##GDAP: GDAP-1069
##SPRINT CREADO:
##FRECUENCIA:
##TAG : BERSERKERS
##DATA:
##ENCARGADO:
##FECMOD: 30/03/2023

@BERSERKERS @DoneDevOps @DoneDevOpsPI14 @Sanity28 @DROP

  Característica: AT-DT012_Alta Mono Internet Sva Repetidor + Sva Internet Canal Call Center

	Antecedentes:
	  Dado     que abro la pagina de movistar

	@AltaMonoInternetSvaRepetidorSvaInternetCallCenter
	Esquema del escenario: Alta Mono Internet Sva Repetidor + Sva Internet
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
	  ##Y        cierro popup de error
	  Y        ingreso los datos del cliente extranjero a registrar
		| nombres         | apellidos      | genero   |
		| Esther Marisol  | Lopez Bernardo | femenino |
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
		| mz | lote | vivienda | nombreVivienda  | piso | int | conjunto             | conjHabit  |
		| D  | 11   | EDIFICIO | Familia Lopez   | 3    | 2   | URBANIZACION POPULAR | conjunto c |
	  Y        presiono el boton consultar cobertura
	  Y        selecciono tipo de oferta
	  Y        selecciono el tipo de plan fija "<tipoPlan>"
	  Y        selecciono el plan "<nombrePlan>"
	  Y        valido que este en la seccion de registro
	  Entonces doy click en Agregar Sva
	  Y        agrego "<svainternet>"
	  ##Y        elegimos sva repetidor "<svarepetidor>"
		## se comenta el paso porque no ecuentra el elemento
	  Y        doy click en Guardar cambios
	  #Y        valido el detalle de la seleccion
	  Cuando   doy clic a iniciar registro
	  Y        valido que me encuentre en la pantalla agendamiento
	  Y        ingreso los datos de agendamiento
	  Y        presiono el boton confirmar agendamiento
	  Y        ingreso un correo electronico "hola@gmail.com"
	  Y        ingreso nuevamente el correo electronico "hola@gmail.com"
		Y ingreso el call id "1"
      	## agregado nuevo paso
	  Y        doy click en datos del cliente
	  Y        ingreso los datos del cliente
		| fechaNac   | estadoCivil | nacionalidad |
		| 01/01/1990 | Casado      | Albania      |
	  Y        doy click en el boton confirmar
	  Y        doy clic para validar contrato hogar
	  Y        me muestra en pantalla el contrato solicitado
	  Cuando   doy clic en si acepto
	  Y        doy clic en continuar
	  #Y        presiono el boton Registrar venta
	  Entonces visualizo en pantalla el mensaje de exito de la venta generada
	  Ejemplos:
		| tipoUsuario     | userName  | password     | msgHome    |  tipoDocumento | documento  | departamento | provincia | distrito | direccion                   | referencia | tipoPlan | nombrePlan                        |  svainternet           |  svarepetidor            |
		| usuario externo |  jpachaot | $t3l3f0n1c4$ | Bienvenid@ |  CE            | 1123123149 | 15           | 1501      | 150116   | JIRON JULIO CESAR TELLO 460 | INKAFARMA  | Mono     | INTERNET MOVISTAR RA D22 100 MBPS |  PACK ANTIVIRUS MCAFEE | Repetidor WIFI PLUS Venta |
