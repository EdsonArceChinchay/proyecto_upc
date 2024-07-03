#language:es
##CREADOR: Angel Medina
##APP: DITO
##MODULO:
##FUNCIONALIDAD:
##ESTADO: ACTIVO
##CODIGO: AT-DT005
##GDAP: GDAP-572
##SPRINT CREADO: PI12
##FRECUENCIA: DIARIO
##TAG : BERSERKERS
##DATA: REUSABLE
##ENCARGADO: Angel Medina
##FECMOD: 08/04/2024

@BERSERKERS @DoneDevOps @DoneDevOpsPI12 @AT-DT005 @AltaFija @AltaDuo
Característica: AT-DT005_Alta Duo (Voz + Internet) con documento CE en canal Call Center

  @AltaDuoCC @MVP15 @Global
  Esquema del escenario: Alta de dúo internet con CEX, en canal call center, web front end, flujo no biométrico
    Dado     que abro la pagina de movistar
    Cuando   presiono el boton Iniciar Sesion
    Y        selecciono el tipo de usuario "<tipoUsuario>"
    Y        ingreso el usuario "<userName>"
    Y        ingreso el password "<password>"
    E        ingreso el captcha
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
      | mz | tipoVivienda  | nombreVivienda | piso | int | conjunto             | conjHabit |
      | A  | alex mancilla | CASA           | 1    | 1   | URBANIZACION POPULAR | RISSO     |
    Y        presiono el boton consultar cobertura
    Y        selecciono tipo de oferta
    Y        selecciono el tipo de plan fija "<plan_hogar>"
    Y        selecciono el plan "<nombrePlan>"
    Y        valido que este en el resumen de venta
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
    Y        imprimo el texto del contrato solicitado
    Cuando   doy clic en si acepto
    Y        doy click en el boton de continuar
    Entonces visualizo en pantalla el mensaje de exito de la venta generada
    Y        doy click en ver detalle del pedido
    Y        valido que se muestre el detalle del pedido de "Servicio Hogar"
    Y        valido que se muestre el detalle del pedido de "Dirección de instalación"
    Y        valido que se muestre el detalle del pedido de "Información adicional"
    Dado     regreso a la pagina de inicio
    Entonces valido el login exitoso mediante el mensaje "Bienvenid@"
    Y        me dirijo a la bandeja de Back Office
    Y        busco por "<documento>"
    Y        selecciono la solicitud
    Y        cargo el audio en la web
    Y        apruebo la solicitud

    Ejemplos:
      | tipoUsuario     | userName   | password | msgHome    | tiendaAsesor | tipoDocumento | documento  | departamento | provincia | distrito | direccion                   | referencia | plan_hogar | nombrePlan                |
      | usuario externo | userNameCC | passCC   | Bienvenid@ | CAJAMARCA    | CE            | 1000000245 | 15           | 1501      | 150116   | JIRON JULIO CESAR TELLO 469 | Casa       | Duo        | DUO MOVISTAR VOZ INTERNET |