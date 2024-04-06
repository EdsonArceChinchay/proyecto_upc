#language:es
##CREADOR:
##APP: DITO
##MODULO:
##FUNCIONALIDAD:
##ESTADO: ACTIVO
##CODIGO: AT-DT016
##GDAP: GDAP-1068
##SPRINT CREADO: PI14_SP2
##FRECUENCIA:
##TAG : BERSERKERS
##DATA: REUSABLE
##ENCARGADO:
##FECMOD: 13/02/2024

@BERSERKERS @DoneDevOps @DoneDevOpsPI14SP2 @AltaFija
Característica: AT-DT016_Alta Mono Linea Voz Modem sva linea Call center

  @AltaMonoLineaVoz_Modem_svaLineaCallCenter__11
  Esquema del escenario: Yo como asesor de Tiendas realizare un alta Mono Linea Voz a un cliente nuevo con CE
    Dado     que abro la pagina de movistar
    Cuando   presiono el boton Iniciar Sesion
    Y        selecciono el tipo de usuario "usuario externo"
    Y        ingreso el usuario "userNameCC"
    Y        ingreso el password "passCC"
    Y        presiono el boton Continuar hacia el home
    Entonces valido el login exitoso mediante el mensaje "Bienvenid@"
    Cuando   selecciono el tipo de documento "CE"
    Y        ingreso el documento "1029392827"
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
      | 15           | 1501      | 150116   | JIRON JULIO CESAR TELLO 469 | parque     |
    Y        presiono el boton Consultar Ubicacion
    Y        ingreso la informacion del lugar para la instalacion
      | mz | tipoVivienda      | nombreVivienda | piso | int | conjunto             | conjHabit |
      | A  | alex mancilla | alex mancilla  | 2    | 3   | URBANIZACION POPULAR | casa      |
    Y        presiono el boton Consultar Cobertura
    Y        selecciono tipo de oferta
    Y        selecciono el tipo de plan fija "<tipoPlan>"
    Y        selecciono el plan "<nombrePlan>"
    Y        doy click en agregar Modem
    Cuando   doy clic a iniciar registro
    Y        valido que me encuentre en la pantalla agendamiento
    Y        ingreso telefono de contacto
    Y        presiono el boton Confirmar agendamiento
    Y        ingreso email "prueba@prueba.com" y lo repito
    Y        presiono la opcion validar contrato
    Y        me muestra en pantalla el contrato solicitado
    Y        imprimo el texto del contrato solicitado
    Cuando   doy clic en si acepto
    Y        doy click en el boton de continuar
    Entonces visualizo en pantalla el mensaje de exito de la venta generada

    Ejemplos:
      | tipoPlan | nombrePlan  | bloque | svaInternet           |
      | Trío     | D22 50 MBPS | HBO    | PACK ANTIVIRUS MCAFEE |

#


  @AltaMonoLineaVoz_Modem_svaLineaCallCenter
  Esquema del escenario: Alta Mono TV Bloqueo Hbo + Sva Internet
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
    Y        cierro popup de error
    Y        ingreso los datos del cliente extranjero a registrar
      | nombres           | apellidos     | genero   |
      | Elizabeth Marisol | Lopez Barrios | femenino |
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
      | mz | tipoVivienda | nombreVivienda | piso | int | conjunto             | conjHabit  |
      | D  | EDIFICIO | Familia Lopez  | 3    | 2   | URBANIZACION POPULAR | conjunto c |
    Y        presiono el boton consultar cobertura
    Y        selecciono tipo de oferta
    Y        selecciono el tipo de plan fija "<tipoPlan>"
    Y        selecciono el plan "<nombrePlan>"
    Y        valido que este en la seccion de registro
    Y        doy click en agregar "<svaInternet>"
	#Y doy click en agregar SVA Linea "<svaLinea>"
	  #Y        valido el detalle de la seleccion
    Cuando   doy clic a iniciar registro
    Y        valido que me encuentre en la pantalla agendamiento
    Y        ingreso los datos de agendamiento
    Y        presiono el boton confirmar agendamiento
    Y        ingreso un correo electronico "tester.1.2.3@tester.com"
    Y        ingreso nuevamente el correo electronico "tester.1.2.3@tester.com"
#	Y        doy click en datos del cliente
#	Y        ingreso los datos del cliente
#	  | fechaNac   | estadoCivil | nacionalidad |
#	  | 12/12/1994 | Casado      | Albania      |
    Y        doy click en el boton confirmar
    Y        doy clic para validar contrato hogar
    Y        me muestra en pantalla el contrato solicitado
    Y        imprimo el texto del contrato solicitado
    Cuando   doy clic en si acepto
    Y        doy clic en continuar
    Entonces visualizo en pantalla el mensaje de exito de la venta generada
    Y        doy click en ver detalle del pedido
    Y        valido que se muestre el detalle del pedido de "Servicio Hogar"
    Y        valido que se muestre el detalle del pedido de "Dirección de instalación"
    Y        valido que se muestre el detalle del pedido de "Información adicional"
    Dado     regreso a la pagina de inicio
    Entonces valido el login exitoso mediante el mensaje "Bienvenid@"
    Y        me dirijo a la bandeja de Back Office
    Y        busco por "solicitud"
    Y        selecciono la solicitud
    Y        cargo el audio en la web
    Y        apruebo la solicitud
    Ejemplos:
      | tipoUsuario     | userName | password     | msgHome    | tipoDocumento | documento  | departamento | provincia | distrito | direccion                   | referencia | tipoPlan | nombrePlan                                | bloque | svaInternet           | svaLinea             |
      | usuario externo | userNameCC | passCC | Bienvenid@ | CE            | 1029392562 | 15           | 1501      | 150116   | JIRON JULIO CESAR TELLO 469 | INKAFARMA  | Duo      | DÚO MOVISTAR VOZ INTERNET RA D22 100 MBPS | HBO    | PACK ANTIVIRUS MCAFEE | Plan Multidestino 20 |



