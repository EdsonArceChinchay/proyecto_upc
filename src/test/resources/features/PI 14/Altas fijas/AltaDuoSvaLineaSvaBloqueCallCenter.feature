#language:es

##CREADOR:
##APP: DITO
##MODULO:
##FUNCIONALIDAD:
##ESTADO:
##CODIGO: AT-DT088
##GDAP: GDAP-1138
##SPRINT CREADO:
##FRECUENCIA:
##TAG : BERSERKERS
##DATA:
##ENCARGADO:
##FECMOD: 30/03/2023

@BERSERKERS @DoneDevOps @DoneDevOpsPI14 @Sanity28 @AltaFija

Característica: AT-DT088_Alta Duo (Voz + TV) + Sva Linea + Sva bloque  con documento CE por canal Call Center

  @AltaDuoSvaLineaSvaBloqueCallCenter
  Esquema del escenario: Alta Duo Sva Linea + Sva bloque Call Center
    Dado     que abro la pagina de movistar
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
      | nombres | apellidos     | genero    |
      | Elvis   | Lopez Barrios | masculino |
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
      | D  | EDIFICIO     | Familia Lopez  | 3    | 2   | URBANIZACION POPULAR | conjunto c |
    Y        presiono el boton consultar cobertura
    Y        selecciono tipo de oferta
    Y        selecciono el tipo de plan fija "<tipoPlan>"
    Y        selecciono el plan "<nombrePlan>"
    Y        valido que este en la seccion de registro
    Y        doy click en agregar SVA Linea "<svaLinea>"
    Entonces doy click en Agregar Sva
    Y        doy click en agregar Bloque "<bloque>"
    Y        doy click en Guardar cambios
	  #Y        valido el detalle de la seleccion
    Cuando   doy clic a iniciar registro
    Y        valido que me encuentre en la pantalla agendamiento
    Y        ingreso los datos de agendamiento
    Y        presiono el boton confirmar agendamiento
    Y        ingreso un correo electronico "1tester@tester.com"
    Y        ingreso nuevamente el correo electronico "1tester@tester.com"
    Y        doy click en datos del cliente
    Y        ingreso los datos del cliente
      | fechaNac   | estadoCivil | nacionalidad |
      | 08/09/1994 | Casado      | Albania      |
    Y        doy click en el boton confirmar
    Y        doy clic para validar contrato hogar
    Y        me muestra en pantalla el contrato solicitado
    Y        imprimo el texto del contrato solicitado
    Cuando   doy clic en si acepto
    Y        doy clic en continuar
    Entonces visualizo en pantalla el mensaje de exito de la venta generada
    Y        doy click en ver detalle del pedido
    Y        valido que se muestre el detalle del pedido de "Servicio Hogar"
    Dado     regreso a la pagina de inicio
    Entonces valido el login exitoso mediante el mensaje "Bienvenid@"
    Y        me dirijo a la bandeja de Back Office
    Y        busco por "solicitud"
    Y        selecciono la solicitud
    Y        cargo el audio en la web
    Y        apruebo la solicitud
    Ejemplos:
      | tipoUsuario     | userName   | password | msgHome    | tipoDocumento | documento  | departamento | provincia | distrito | direccion            | referencia             | tipoPlan | nombrePlan                      | svaLinea             | bloque |
      | usuario externo | userNameCC | passCC   | Bienvenid@ | CE            | 1058908648 | 15           | 1501      | 150136   | CALLE SAN MARTIN 399 | AL FRENTE DE LA BOTICA | Duo      | DÚO MOVISTAR VOZ ESTÁNDAR HD RA | Plan Multidestino 20 | FOX    |