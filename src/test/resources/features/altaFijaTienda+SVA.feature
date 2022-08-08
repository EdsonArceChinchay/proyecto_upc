#language:es
@BERSERKERS @DoneDevOps @DoneDevOpsPI11

Característica: Alta Fija por tienda + SVA

  Antecedentes:
	Dado     que abro la pagina de movistar

  @AltaFijaTienda+SVA
  Esquema del escenario: Alta fija por tienda con DNI sin productos asociados sin biometria
	Cuando   presiono el boton Iniciar Sesion
	Y        selecciono el tipo de usuario "<tipoUsuario>"
	Y        ingreso el usuario "<userName>"
	Y        ingreso el password "<password>"
	Y        presiono el boton Continuar hacia el home
	Entonces valido el login exitoso mediante el mensaje "<msgHome>"
	Y        valido que se presente la tienda "<tiendaAsesor>"
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
	  | mz | lote | vivienda | nombreVivienda  | piso | int | conjunto             | conjHabit   |
	  | A  | 1    | EDIFICIO | Familia Barreto | 1    | 1   | URBANIZACION POPULAR | -conjunto b |
	Y        presiono el boton consultar cobertura
	Y        selecciono tipo de oferta
	Y selecciono el tipo de plan fija "tipoPlan"
	Y        selecciono el plan "<nombrePlan>"
	Y        valido que este en la seccion de registro
	Cuando   doy clic a iniciar registro
	Y         selecciono la cartilla Linea Nueva
	Y         agrego el SVA para fija HBO
	Cuando   doy clic a iniciar registro
	Y        valido que me encuentre en la pantalla agendamiento
	Y        ingreso los datos de agendamiento
	Y        presiono el boton confirmar agendamiento
#	Y        ingreso un correo electronico "hola@gmail.com"
#	Y        ingreso nuevamente el correo electronico "hola@gmail.com"
#	Y        doy click en validar identidad del titular
#	Y        elijo el tipo de validacion a realizar "<tipoValidacion>"
#	Y        ingreso los datos del supervisor
#	  | numdoc   | user        | password     |
#	  | 42770472 | rdelatorreg | $t3l3f0n1c4$ |
#	Y        ingreso los datos solicitados para la validacion del cliente
#	  | nombreMadre   | nombrePadre   | distritoNac   |
#	  | <nombreMadre> | <nombrePadre> | <distritoNac> |
#	Entonces valido que me muestre el boton con el texto de identidad validada
	Y        doy clic para validar contrato hogar
	Y        me muestra en pantalla el contrato solicitado
	Cuando   doy clic en si acepto
	Y        doy clic en continuar
	Y        presiono el boton Registrar venta
	Entonces visualizo en pantalla el mensaje de exito de la venta generada

	Ejemplos:
	  | tipoUsuario     | userName    | password       | msgHome    | tiendaAsesor | tipoDocumento | documento | departamento | provincia | distrito | direccion                     | referencia | tipoPlan | nombrePlan          | tipoValidacion | nombreMadre | nombrePadre | distritoNac | tipoPlanes          |
	  | usuario externo | lterrazosce | Telefonica2021 | Bienvenid@ | SAN MIGUEL   | CE           | 313142553 | 15           | 1501      | 150136   | Calle Condesa de Chinchon 107 | casa crema | Mono     | TV Estándar Digital | discapacitado  | TERESA      | CARLOS      | ISLAY       | TV Estándar Digital |

