#language:es
@BERSERKERS @DoneDevOps @DoneDevOpsPI11

Característica: Alta Fija + Alta Movil por Retail

  Antecedentes:
    Dado     que abro la pagina de movistar


  @AltaFijaMovilRetail_CE_Nuevo
  Esquema del escenario: Alta fija mas alta movil Retail con Nuevo Cliente Extranjero
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
    Y        ingreso los datos del cliente a registrar
      | nombres | apellidos   | genero   |
      | Ana     | Lopez Lopez | femenino |
    Y        selecciono el boton Linea Nueva Hogar
    Y        selecciono el boton Linea Nueva Movil
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
      | A  | 1    | alex mancilla | alex mancilla  | 1    | 1   | URBANIZACION POPULAR | casa      |
    Y        presiono el boton consultar cobertura

    Entonces me muestra la pantalla de ofertas sugeridos
    Y        selecciono el tipo de oferta "<tipoOferta>"
    Y        selecciono el tipo de plan "<tipoPlan>"
    Y        valido el detalle de la seleccion
    Cuando   doy clic a iniciar registro
    Y        valido que me encuentre en la pantalla agendamiento
    #Y        escojo un turno de agendamiento
    Y        ingreso datos del contacto en la pantalla agendamiento "999888777"
    Y        doy clic en confirmar agendamiento
    Entonces me muestra el detalle de la instalacion
    Y        doy clic en confirmar
    Y        completo el correo "<correo>"
    Y        doy click en datos del cliente
    Y        completo los datos del cliente
      | fechaNac   | estadoCivil |
      | 12/12/1980 | soltero     |
    Y        doy clic para validar contrato Movil
    Y        me muestra en pantalla el contrato solicitado
    Cuando   doy clic en si acepto
    Y        doy clic en continuar
    #Y        me muestra pantalla para Descargar contrato
    Y        doy clic para descargar el contrato
    Y        doy clic en Registrar venta
    Entonces visualizo en pantalla el mensaje de exito de la venta generada

    Ejemplos:
      | tipoUsuario     | userName | password     | msgHome    | tiendaAsesor | tipoDocumento | documento  | departamento | provincia | distrito | direccion                     | referencia | tipoOferta     | tipoPlan            | correo           |
      | usuario externo | vsiguass | $t3l3f0n1c4$ | Bienvenid@ | MOQUEGUA     | CE            | 1000000006 | 15           | 1501      | 150136   | Calle Condesa de Chinchon 107 | Casa       | MOVISTAR TOTAL | HD 70 Mbps + 26 Gb | correo@gmail.com |
