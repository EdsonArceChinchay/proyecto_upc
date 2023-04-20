#language:es
##APP: DITO
##MODULO:
##CREADOR: PATRICIA CABELLO
##CODIGO: AT-DT050
##GDAP: GDAP-1380
##SPRINT CREADO: SP1
##FUNCIONALIDAD: REALIZAR UN ALTA DUO CON INTERNET + VOZ
##FRECUENCIA: NO ESPECIFICA
##TAG : @DITO
##DATA: REUSABLE
##ENCARGADO: Patricia
##FECMOD: 13/04/2023
@BERSERKERS @DoneDevOps @DoneDevOpsPI15SP1
Característica: AT-DT050_CAPL con Alta Dúo BB y VOZ con instalación FTTH por Canal Tiendas

  @AltaBByVozConInstalacionFtthTiendas
  Esquema del escenario: Alta Dúo BB y VOZ con instalación FTTH por Canal Tiendas
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
      | Toby    | Perez        | Masculino |
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
      | mz | lote | vivienda | nombreVivienda    | piso | int | conjunto             | conjHabit  |
      | A  | 1    | EDIFICIO | Flores            | 1    | 1   | URBANIZACION POPULAR | conjunto a |
    Y        presiono el boton consultar cobertura
    Y        selecciono tipo de oferta
    Y        selecciono el tipo de plan fija "<plan_hogar>"
    Y        selecciono el plan "<nombrePlan>"
    E        inicio su registro
    Y        valido que me encuentre en la pantalla agendamiento
    Y        ingreso los datos de agendamiento
    Y        presiono el boton confirmar agendamiento
    Y        ingreso un correo electronico "prueba@gmail.com"
    Y        ingreso nuevamente el correo electronico "prueba@gmail.com"
    Y        doy click en datos del cliente
    Y        completo los datos solicitados
      | fechaNac   | estadoCivil | nacionalidad |
      | 25/05/1991 | Soltero     | Peru      |
    Y        doy clic para validar contrato Movil
    Y        me muestra en pantalla el contrato solicitado
    Cuando   doy clic en si acepto
    Y        doy clic en continuar
    Y        presiono el boton Registrar venta
    Entonces visualizo en pantalla el mensaje de exito de la venta generada

    Ejemplos:
      | tipoUsuario     | userName     | password         | msgHome    | tipoDocumento | documento  | departamento | provincia | distrito | direccion                     | referencia | plan_hogar     | nombrePlan                                |
      | usuario externo | evillanuevag | #o2Wy23oA1458     | Bienvenid@ | CE            | 1020304050 | 15           | 1501      | 150116   | JIRON JULIO CESAR TELLO 469   | Casa       | Duo            | DÚO MOVISTAR VOZ INTERNET RA D22 1000 MBPS |
