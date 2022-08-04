#language:es
@BERSERKERS @DoneDevOps @DoneDevOpsPI11 @Regresion_Carlos

Característica: Alta Fija por Retail


  Antecedentes:
    Dado     que abro la pagina de movistar

  @AltaFijaPorRetail_CE
  Esquema del escenario: Alta fija Retail con Nuevo Cliente Extranjero
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
    Y        cierro popup de error
    Y        ingreso los datos del cliente a registrar
      | nombres | apellidos   | genero   |
      | Ana     | Lopez Lopez | femenino |
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
      | mz | lote | vivienda      | nombreVivienda | piso | int | conjunto             | conjHabit |
      | A  | 1    | alex mancilla | alex mancilla  | 1    | 1   | EDIFICIO             | casa      |
    Y        presiono el boton consultar cobertura
    Y        selecciono tipo de oferta
    Y        selecciono el tipo de plan fija "<tipoPlan>"
    Y        selecciono el plan "<nombrePlan>"
    Cuando   doy clic a iniciar registro
    Y        valido que me encuentre en la pantalla agendamiento
    Y        ingreso los datos de agendamiento
    Y        presiono el boton confirmar agendamiento
    Y        ingreso un correo electronico "hola@gmail.com"
    Y        ingreso nuevamente el correo electronico "hola@gmail.com"
    Y        doy click en datos del cliente
    Y        ingreso los datos del cliente
             | fechaNac   | estadoCivil | nacionalidad |
             | 12/12/1980 | Casado      | Albania      |
    Y        doy click en el boton confirmar
    Y        doy clic para validar contrato Movil
    Y        me muestra en pantalla el contrato solicitado
    Cuando   doy clic en si acepto
    Y        doy click en el boton de continuar
    Y        presiono el boton descargar contrato
    Y        presiono el boton Registrar venta
    Entonces visualizo en pantalla el mensaje de exito de la venta generada
    Y        valido que se muestre el detalle del pedido

    Ejemplos:
      | tipoUsuario     | userName | password     | msgHome    | tiendaAsesor | tipoDocumento | documento  | departamento | provincia | distrito | direccion                     | referencia | tipoPlan | nombrePlan                                        |
      | usuario externo | vsiguass | $t3l3f0n1c4$ | Bienvenid@ | MOQUEGUA     | CE            | 1000000006 | 15           | 1501      | 150136   | Calle Condesa de Chinchon 107 | Casa       | Trio        | TRÍO MOVISTAR VOZ INTERNET ESTANDAR HD RA 70 MBPS |

  @AltaFijaTiendaMigra_DECOHD_A_DECO_SMART_1
  Esquema del escenario: alta Fija migracion deco HD a Smart HD
	Cuando   presiono el boton Iniciar Sesion
	Y        selecciono el tipo de usuario "<tipoUsuario>"
	Y        ingreso el usuario "<userName>"
	Y        ingreso el password "<password>"
	Y        presiono el boton Continuar hacia el home
	Y         valido el login exitoso mediante el mensaje "<msgHome>"
	Cuando   selecciono el tipo de documento "<tipoDocumento>"
	Y        ingreso el documento "<documento>"
	Y        doy click en el boton consultar
	Y        cierro popup de error
	Y        selecciono agregar sva fija
	Y 		 seleccionamos agregar decodificador Smart HD
	Y        seleccionamos guardar cambios
	Cuando   doy clic a iniciar registro
	Y        valido que me encuentre en la pantalla agendamiento
	Y        ingreso los datos de agendamiento
	Y        presiono el boton confirmar agendamiento
	Y        ingreso un correo electronico "hola@gmail.com"
	Y        ingreso nuevamente el correo electronico "hola@gmail.com"
#	Y doy click en validar identidad del titular
#	Y elijo el tipo de validacion a realizar "discapacitado"
#	Y ingreso los datos del supervisor
#	  |numdoc  |user       |password    |
#	  |42770472|rdelatorreg|$t3l3f0n1c4$|
#	Y ingreso los datos solicitados para la validacion del cliente
#	  |nombreMadre|nombrePadre|distritoNac         |
#	  |EMMA    |EDILBERTO    |GUADALUPE|
#	Entonces valido que me muestre el boton con el texto de identidad validada
	Y doy clic para validar contrato Movil
	Y me muestra en pantalla el contrato solicitado
	Cuando doy clic en si acepto
	Y doy clic en continuar
	Y        doy clic en Registrar venta
	Entonces visualizo en pantalla el mensaje de exito de la venta generada


	Ejemplos:
	  | tipoUsuario     | userName    | password       | msgHome    | tiendaAsesor                 | tipoDocumento | documento | correo           | tipoValidacion | nombreMadre | nombrePadre | distritoNac | tipoPlanHogar | planTrio                                           |decoficador|
	  | usuario externo | lterrazosce | Telefonica2021 | Bienvenid@ | CANAL ONLINE-CALL CENTER GSS | CE           | 856575426 | correo@gmail.com | discapacitado  | MARIBEL     | JOSE        | SULLANA     | Trío          | Trío Movistar Voz Internet Estandar HD RA 100 Mbps |SMART HD   |
  @AltaDuoPorCallCenter_1
  Esquema del escenario: Alta Duo Por Call Center
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
	Y        cierro popup de error
	Y        ingreso los datos del cliente a registrar
	  | nombres | apellidos    | genero   |
	  | Juan    | Lopez Anibal | masculino |
	Y        valido que muestre el nombre completo del cliente "Juan Lopez Anibal"
	Y        selecciono el boton Linea Nueva Hogar
	Y        presiono el boton Mostrar ofertas
	Entonces me muestra la pantalla para ingresar la direccion
	Y        selecciono el departamento donde sera la instalacion "15"
	Y        selecciono la provincia donde sera la instalacion "1501"
	Y        selecciono el distrito donde sera la instalacion "150136"
	Y        ingreso la direccion donde sera la instalacion "Calle Condesa de Chinchon 107"
	Y        ingreso la referencia de la direccion "casa naranja"
	Y        presiono el boton Consultar ubicacion
	Y        ingreso la informacion del lugar de instalacion
	  | mz | lote |vivienda     |nombreVivienda  |piso | int | conjunto            | conjHabit  |
	  | A  | 1    |EDIFICIO     |Familia Barreto |1    | 1   | URBANIZACION POPULAR| conjunto b |
	Y        presiono el boton consultar cobertura
	Y        valido que este en la pagina de ofertas sugeridas
	Y        selecciono tipo de oferta
	Y        selecciono el tipo de plan fija "<tipoPlan>"
	Y        selecciono el plan "<nombrePlan>"
	Y        valido que este en la seccion de registro
	Cuando   doy clic a iniciar registro
	Y        valido que me encuentre en la pantalla agendamiento
	Y        ingreso los datos de agendamiento
	Y        presiono el boton confirmar agendamiento
	Y        ingreso un correo electronico "hola@gmail.com"
	Y        ingreso nuevamente el correo electronico "hola@gmail.com"
#    Y        ingreso el call id "2BE1772E-ADDB-51B6-865A-7E356D944955"
	Y        doy click en datos del cliente
	Y        ingreso los datos del cliente
	  | fechaNac   | estadoCivil | nacionalidad |
	  | 12/12/1980 | Casado      | Alemania     |
	Y       doy click en el boton confirmar
	Y        doy clic para validar contrato hogar
	Y        me muestra en pantalla el contrato solicitado
	Cuando   doy clic en si acepto
	Y        doy click en el boton de continuar
	Entonces visualizo en pantalla el mensaje de exito de la venta generada
	Y        valido que se muestre el detalle del pedido

	Ejemplos:
	  | tipoUsuario     | userName    | password       | msgHome    | tiendaAsesor                 | tipoDocumento | documento |tipoPlan  | nombrePlan  |
	  | usuario externo | jpachaot    | $t3l3f0n1c4$   | Bienvenid@ | CANAL ONLINE-CALL CENTER GSS | CE            | 1000000006|Duo       | RA 100 MBPS  |
      #| usuario externo | jpachaot    | $t3l3f0n1c4$   | Bienvenid@ | CANAL ONLINE-CALL CENTER GSS | CE            | 1000000003|Trío      | RA 100 MBPS |
