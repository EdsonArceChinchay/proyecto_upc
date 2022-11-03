#language:es
@BERSERKERS @DoneDevOps @DoneDevOpsPI11 @DROP35

Característica: Alta Trio por el canal Proactivo

  Antecedentes:
	Dado     que abro la pagina de movistar

  @AltaTrioProactivo
  Esquema del escenario: Alta fija por tienda con DNI sin productos asociados sin biometria
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
	Y        ingreso los datos del cliente a registrar
	  | nombres | apellidos    | genero    |
	  | Juan    | Lopez Garcia | masculino |
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
	  | A  | 1    | EDIFICIO | Familia Barreto | 1    | 1   | URBANIZACION POPULAR | conjunto b |
	Y        presiono el boton consultar cobertura
	Y        selecciono tipo de oferta
	Y        selecciono el tipo de plan fija "<tipoPlan>"
	Y        selecciono el nombre del plan "<nombrePlan>"
	Y         doy click en el boton seleccionar la oferta
	Y         selecciono la cartilla Linea Nueva
	Y        selecciono en iniciar registro
	Y        valido que me encuentre en la pantalla agendamiento
	Y        ingreso los datos de agendamiento
	Y        presiono el boton confirmar agendamiento
	Y        ingreso un correo electronico "hola@gmail.com"
	Y        ingreso nuevamente el correo electronico "hola@gmail.com"
	Y        doy click en datos del cliente
	Y        ingreso los datos del cliente
	  | fechaNac   | estadoCivil | nacionalidad |
	  | 12/12/1980 | Casado      | Albania      |
	Y       doy click en el boton confirmar
	Y        doy clic para validar contrato hogar
	Cuando   doy clic en si acepto
	Y        doy click en el boton de continuar
	Y 		presiono el boton Registrar venta
	  Entonces visualizo en pantalla el mensaje de exito de la venta generada
	  Y        valido que se muestre el detalle del pedido

	Ejemplos:
	  | tipoUsuario     | userName | password     | msgHome    | tiendaAsesor                 | tipoDocumento | documento  | departamento | provincia | distrito | direccion                     | referencia | tipoPlan | nombrePlan                           | tipoValidacion | nombreMadre | nombrePadre | distritoNac |
#      | usuario externo | lterrazosce | Telefonica2021 | Bienvenid@ |  SAN MIGUEL    | DNI           | 75504508  | 15           | 1501      | 150136   | Calle Condesa de Chinchon 107 | casa verde    | Internet RA 40 Mbps | discapacitado  | ELIZABETH   | JORGE       | LIMA        |
	  | usuario externo | evillanuevag | $t3l3f0n1c4$ | Bienvenid@ | CANAL ONLINE-CALL CENTER GSS | CE            | 1000123456006 | 15           | 1501      | 150136   | Calle Condesa de Chinchon 107 | casa crema | Duo      | Dúo Internet Estándar HD RA 100 Mbps | discapacitado  | ODELIA      | CIPRIANO    | EL AGUSTINO |


  @AltaDuoProactivo
  Esquema del escenario: Alta fija por tienda con DNI sin productos asociados sin biometria
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
	Y        ingreso los datos del cliente a registrar
	  | nombres | apellidos    | genero    |
	  | Juan    | Lopez Garcia | masculino |
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
	  | A  | 1    | EDIFICIO | Familia Barreto | 1    | 1   | URBANIZACION POPULAR | conjunto b |
	Y        presiono el boton consultar cobertura
	Y        selecciono tipo de oferta
	Y        selecciono el tipo de plan fija "<tipoPlan>"
	Y        selecciono el nombre del plan "<nombrePlan>"
	Y         doy click en el boton seleccionar la oferta
	Y         selecciono la cartilla Linea Nueva
	Y        selecciono en iniciar registro
	Y        valido que me encuentre en la pantalla agendamiento
	Y        ingreso los datos de agendamiento
	Y        presiono el boton confirmar agendamiento
	Y        ingreso un correo electronico "hola@gmail.com"
	Y        ingreso nuevamente el correo electronico "hola@gmail.com"
	Y        doy click en datos del cliente
	Y        ingreso los datos del cliente
	  | fechaNac   | estadoCivil | nacionalidad |
	  | 12/12/1980 | Casado      | Albania      |
	Y       doy click en el boton confirmar
	Y        doy clic para validar contrato hogar
	Cuando   doy clic en si acepto
	Y        doy click en el boton de continuar
	Y 		presiono el boton Registrar venta
	Entonces visualizo en pantalla el mensaje de exito de la venta generada


	Ejemplos:
	  | tipoUsuario     | userName | password     | msgHome    | tiendaAsesor                 | tipoDocumento | documento  | departamento | provincia | distrito | direccion                     | referencia | tipoPlan | nombrePlan                                         | tipoValidacion | nombreMadre | nombrePadre | distritoNac |
#      | usuario externo | lterrazosce | Telefonica2021 | Bienvenid@ |  SAN MIGUEL    | DNI           | 75504508  | 15           | 1501      | 150136   | Calle Condesa de Chinchon 107 | casa verde    | Internet RA 40 Mbps | discapacitado  | ELIZABETH   | JORGE       | LIMA        |
	  | usuario externo | evillanuevag | $t3l3f0n1c4$ | Bienvenid@ | CANAL ONLINE-CALL CENTER GSS | CE            | 10004454006 | 15           | 1501      | 150136   | Calle Condesa de Chinchon 107 | casa crema | Trío     | Trío Movistar Voz Internet Estandar HD RA 100 Mbps | discapacitado  | ODELIA      | CIPRIANO    | EL AGUSTINO |


