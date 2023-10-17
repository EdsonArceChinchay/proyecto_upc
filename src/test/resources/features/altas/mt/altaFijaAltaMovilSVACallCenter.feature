#language:es
##CREADOR:
##APP: DITO
##MODULO:
##FUNCIONALIDAD:
##ESTADO:
##CODIGO: AT-DT035
##GDAP: GDAP-725
##SPRINT CREADO:
##FRECUENCIA:
##TAG : BERSERKERS
##DATA:
##ENCARGADO:
##FECMOD: 30/03/2023

@BERSERKERS @DoneDevOps @DoneDevOpsPI11 @DROP35 @AT-DT035

Característica: AT-DT035_Alta Fija + Alta Movil+ SVA por Call Center

  Antecedentes:
    Dado     que abro la pagina de movistar

  @AltaFijaMovilSVACallCenter
  Esquema del escenario: Alta fija mas alta movil  + SVA por Call Center
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
    Y        ingreso los datos del cliente a registrar
      | nombres | apellidos | genero    |
      | Jose    | LLamoca   | masculino |
    #Y        valido que muestre el nombre completo del cliente "Jose Llamoca"
    Y        selecciono el boton Linea Nueva Hogar
    Y        selecciono el boton Linea Nueva Movil
    #Y cierro el popup de validación de estado de contraseña única
    Y        selecciono el boton Mostrar ofertas
    Entonces me muestra la pantalla para ingresar la direccion
    Y        selecciono el departamento donde sera la instalacion "<departamento>"
    Y        selecciono la provincia donde sera la instalacion "<provincia>"
    Y        selecciono el distrito donde sera la instalacion "<distrito>"
    Y        ingreso la direccion donde sera la instalacion "<direccion>"
    Y        ingreso la referencia de la direccion "<referencia>"
    Y        presiono el boton Consultar ubicacion
    #Y        ingreso la informacion del lugar de instalacion
       #| vivienda | nombreVivienda   | piso | int | conjunto             | conjHabit  |
       #| EDIFICIO | Familia Torres   | 1    | 1   | URBANIZACION POPULAR | conjunto b |
    Y        presiono el boton consultar cobertura
    Entonces me muestra la pantalla de ofertas sugeridos
    Y        selecciono tipo de oferta
    Y        selecciono un plan Movistar Total "<nombrePlan>"
    Y        valido el detalle de la seleccion
    Y        doy click en agregar "<sva>"
    Cuando   doy clic a iniciar registro
    Y        valido que me encuentre en la pantalla agendamiento
    Y        ingreso los datos de agendamiento
    Y        presiono el boton confirmar agendamiento
    Y        presiono Consultar ubicacion
    Y        ingreso la informacion del lugar de instalacion
      | mz | vivienda | nombreVivienda | piso | int | conjunto             | conjHabit  |
      | A  | EDIFICIO | Familia Perez  | 1    | 1   | URBANIZACION POPULAR | conjunto a |
    Y        presiono el boton confirmar ubicacion
    Y        selecciono un tipo de entrega "Delivery Regular 24 horas"
    Y        selecciono el horario de entrega "2pm-7pm"
    Y        ingreso el telefono de contacto "908123789"
    Y        ingreso las instrucciones a considerar de la entrega "Al frente de la farmacia central"
    Y        doy clic en confirmar delivery
    #Se agregaron los pasos
    Y        valido que este en la seccion completa los datos solicitados
    Y        selecciono el metodo de pago "Contra entrega"
    Y        ingreso un correo electronico "hola_mundo@gmail.com"
    Y        ingreso nuevamente el correo electronico "hola_mundo@gmail.com"
    #Se agregaron los pasos
    Y        doy click en datos del cliente
    Y        ingreso los datos del cliente
      | fechaNac   | estadoCivil | nacionalidad |
      | 12/09/1988 | Soltero     | Aruba        |
    Y        doy click en el boton confirmar
    Y        doy clic para validar contrato Movil
    Y        me muestra en pantalla el contrato solicitado
    Cuando   doy clic en si acepto
    Y        doy clic en continuar
    Y        presiono el boton Registrar venta
    Entonces visualizo en pantalla el mensaje de exito de la venta generada

    Ejemplos:
      | tipoUsuario     | userName | password     | msgHome    | tiendaAsesor              | tipoDocumento | documento  | departamento | provincia | distrito | direccion                   | referencia | nombrePlan            | sva                   |
      | usuario externo | jpachaot | $t3l3f0n1c4$ | Bienvenid@ | PRUEBAS SIST CALLIN VENTA | CE            | 1325049087 | 15           | 1501      | 150116   | JIRON JULIO CESAR TELLO 469 | Casa       | HD 1 Gb RA + 95 Gb RA | PACK ANTIVIRUS MCAFEE |
