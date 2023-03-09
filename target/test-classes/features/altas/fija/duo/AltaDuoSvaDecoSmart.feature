#language:es

  # CREADOR: Angel Medina

@BERSERKERS @DoneDevOps @DoneDevOpsPI12 @AltaDuo_Upfront_CE @AT-DT005

Característica: AT-DT005_Alta Duo por call center


  Antecedentes:
    Dado     que abro la pagina de movistar

  @AltaDuo_SvaDecoSmart @MVP15 @Global
  Esquema del escenario: Alta de dúo internet y añadir sva (deco smart) con CEX, en canal call center, web front end, flujo no biométrico
    Cuando   presiono el boton Iniciar Sesion
    Y        selecciono el tipo de usuario "<tipoUsuario>"
    Y        ingreso el usuario "<userName>"
    Y        ingreso el password "<password>"
    Y        presiono el boton Continuar hacia el home
    Entonces valido el login exitoso mediante el mensaje "<msgHome>"
    #Y        valido que se presente la tienda "<tiendaAsesor>"
    Cuando   selecciono el tipo de documento "<tipoDocumento>"
    Y        ingreso el documento "<documento>"
    Y        doy click en el boton consultar
    Y        cierro popup de error
    Y        ingreso los datos del cliente a registrar
      | nombres | apellidos    | genero   |
      | Lana    | Grey Khalifa | femenino |
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
      | A  | 1    | alex mancilla | alex mancilla  | 1    | 1   | URBANIZACION POPULAR |  parque   |
    Y        presiono el boton consultar cobertura
    Y        selecciono tipo de oferta
    Y        selecciono el tipo de plan fija "<plan_hogar>"
    Y        selecciono el plan "<nombrePlan>"
    E        inicio su registro
    Y        valido que me encuentre en la pantalla agendamiento
    Y        ingreso los datos de agendamiento
    Y        presiono el boton confirmar agendamiento
    Y        ingreso un correo electronico "Angel.mf@gmail.com"
    Y        ingreso nuevamente el correo electronico "Angel.mf@gmail.com"
    Y        doy click en datos del cliente
    Y        completo los datos solicitados
      | fechaNac   | nacionalidad | estado_civil |
      | 12/12/1980 | Alemania     | Casado       |
    Y        doy clic para validar contrato Movil
    Y        me muestra en pantalla el contrato solicitado
    Cuando   doy clic en si acepto
    Y        doy click en el boton de continuar
<<<<<<< HEAD
    Y        doy clic en Registrar venta
   # Y        valido que se muestre el detalle del pedido
=======
    Y        presiono el boton Registrar venta
    Y        valido que se muestre el detalle del pedido
>>>>>>> 7c3e34618493a6afb74fd38dbc416b35acec4408

    Ejemplos:
      | tipoUsuario     | userName | password     | msgHome    | tiendaAsesor | tipoDocumento | documento  | departamento | provincia | distrito | direccion                     | referencia | plan_hogar     | nombrePlan                                |
      | usuario externo | evillanuevag | #o2Wy23oA1458 | Bienvenid@ | CAJAMARCA    | CE            | 1000000245 | 15           | 1501      | 150116   | JIRON JULIO CESAR TELLO 460   | Casa       | Duo        | DÚO MOVISTAR VOZ INTERNET RA D22 100 MBPS |