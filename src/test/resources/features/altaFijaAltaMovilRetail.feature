#language:es
@BERSERKERS @DoneDevOps @DoneDevOpsPI11

Característica: Alta Fija + Alta Movil

  @AltaFijaRetail
  Esquema del escenario: Alta Retail
    Dado     que abro la pagina de movistar
    Cuando   presiono el boton Iniciar Sesion
    Y        selecciono el tipo de usuario "<tipoUsuario>"
    Y        ingreso el usuario "<userName>"
    Y        ingreso el password "<password>"
    Y        presiono el boton Continuar hacia el home
    Entonces valido el login exitoso mediante el mensaje "<msgHome>"
    Y        valido que se presente la tienda "<tiendaAsesor>"
    Y        selecciono el tipo de documento "<tipoDocumento>"
    Y        ingreso el documento "<documento>"
    Y        doy click en el boton consultar
    Y        selecciono el boton Linea Nueva Hogar
    Y        selecciono el boton Linea Nueva Movil
    Y        selecciono el boton Mostrar ofertas
    Y        selecciono el departamento donde sera la instalacion "<departamento>"
    Y        selecciono la provincia donde sera la instalacion "<provincia>"
    Y        selecciono el distrito donde sera la instalacion "<distrito>"
    Y        ingreso la direccion donde sera la instalacion "<direccion>"
    Y        ingreso la referencia de la direccion "<referencia>"
    Y        presiono el boton Consultar ubicacion
    Y        ingresamos la Manzana o bloque "<mz>"
    Y        ingresamos el Lote "<lote>"
    Y        ingresamos el Piso "<piso>"
    Y        ingresamos el interior "<int>"
    Y        ingresamos el Tipo de conjunto habitacional "<conjunto>"
    Y        ingresamos el Nombre del conjunto habitacional "<conjHabit>"
    Y        presionamos el boton Consultar Cobertura

    Ejemplos:
      |tipoUsuario    |userName    |password     |msgHome   |tiendaAsesor|tipoDocumento|documento|departamento|provincia|distrito|direccion         | referencia|mz |lote | piso | int | conjunto |conjHabit|
      |usuario externo|evillanuevag|$t3l3f0n1c4$ |Bienvenid@|TALARA      |DNI          |47163584 |15          |1501     | 150136 | Av.La Marina 3431| Casa      | A | 1 | 1 | 1 | UR| casa |