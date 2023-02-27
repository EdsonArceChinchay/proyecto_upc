#language:es
@BERSERKERS @DoneDevOps @DoneDevOpsPI11 @Sanity28

Característica: Alta Movil Prepago Call center CE


  Antecedentes:
	Dado     que abro la pagina de movistar

  @AltaMovilPrepagoCallCenter1
  Esquema del escenario: Alta movil Prepago por call center
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
    #Y        cierro popup de error
	Y        ingreso los datos del cliente a registrar
	  | nombres | apellidos   | genero   |
	  | Ana     | Lopez Lopez | femenino |
	Y        selecciono el boton Linea Nueva Movil
	Y        selecciono el boton Mostrar ofertas
	Y        selecciono el plan "Prepago" que desea
	Y        doy click en el boton Siguiente
	Y        selecciono la oferta de plan movil "<oferta>"
	Y        selecciono un plan movil "<nombrePlan>"
	Y        selecciono el boton de iniciar registro
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
	Y        selecciono un tipo de entrega "Delivery Regular 48 horas"
	Y        selecciono el horario de entrega "2pm-7pm"
	Y        ingreso el telefono de contacto "658745259"
	Y        ingreso las instrucciones a considerar de la entrega "En la cuadra 8 a la derecha"
	Y        doy clic en confirmar delivery
	Y        selecciono el metodo de pago "Contra entrega"
	Y        ingreso un correo electronico "hola@gmail.com"
	Y        ingreso nuevamente el correo electronico "hola@gmail.com"
	Y        doy click en datos del cliente
	Y        ingreso los datos del cliente
	  | fechaNac   | estadoCivil | nacionalidad |
	  | 12/12/1980 | Casado      | Albania      |
	Y        doy click en el boton confirmar
	Entonces doy clic para validar contrato Movil
	Y        me muestra en pantalla el contrato solicitado
	Cuando   doy clic en si acepto
	Y        doy click en el boton de continuar
	Entonces visualizo en pantalla el mensaje de exito de la venta generada
	Ejemplos:
	  | tipoUsuario     | userName | password     | msgHome    | tiendaAsesor | tipoDocumento | documento  | oferta       | nombrePlan | departamento | provincia | distrito | direccion                                | referencia |
	  | usuario externo | jpachaot | $t3l3f0n1c4$ | Bienvenid@ | CAJAMARCA    | CE            | 1042464781 | PLAN PREPAGO | Preplan    | 15           | 1501      | 150116   | JR JULIO CESAR TELLO 460 PISO 1 UR RISSO | INKAFARMA  |
#      | usuario externo | lterrazosce | Telefonica2021 | Bienvenid@ | CAJAMARCA    | CE            | 1000000006 | PLAN PREPAGO | Prepago con Tarifa |
