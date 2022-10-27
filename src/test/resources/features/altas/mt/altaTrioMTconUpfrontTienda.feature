#language:es
@BERSERKERS @DoneDevOps @DoneDevOpsPI11

Característica: Alta Trio MT - Upfront Tienda

  Antecedentes:
    Dado     que abro la pagina de movistar

#  @AltaTriomt
#  Esquema del escenario: Alta trio Mt
#    Dado     que abro la pagina de movistar
#    Cuando   presiono el boton Iniciar Sesion
#    Y        selecciono el tipo de usuario "<tipoUsuario>"
#    Y        ingreso el usuario "<userName>"
#    Y        ingreso el password "<password>"
#    Y        presiono el boton Continuar hacia el home
#    Entonces valido el login exitoso mediante el mensaje "<msgHome>"
##    Y        valido que se presente la tienda "<tiendaAsesor>"
#    Y        selecciono el tipo de documento "<tipoDocumento>"
#    Y        ingreso el documento "<documento>"
#    Y        doy click en el boton consultar
#    Y        ingreso los datos del cliente a registrar
#      | nombres | apellidos   | genero   |
#      | Ana     | Lopez Lopez | femenino |
#    Y        doy click en el boton linea nueva
#    Y        selecciono el boton Mostrar ofertas
#    Y        selecciono el departamento donde sera la instalacion "<departamento>"
#    Y        selecciono la provincia donde sera la instalacion "<provincia>"
#    Y        selecciono el distrito donde sera la instalacion "<distrito>"
#    Y        ingreso la direccion donde sera la instalacion "<direccion>"
#    Y        ingreso la referencia de la direccion "<referencia>"
#    Y        presiono el boton Consultar ubicacion
#    Y        ingreso la informacion del lugar de instalacion
#      | mz | lote | vivienda | nombreVivienda   | piso | int | conjunto             | conjHabit  |
#      | A  | 1    | EDIFICIO | Familia Huancari | 1    | 1   | URBANIZACION POPULAR | conjunto b |
#    Y        presiono el boton consultar cobertura
#    Entonces me muestra la pantalla de ofertas sugeridos
#    Y        doy click en el boton Ir a movistar total
#    Y        valido el detalle de la seleccion
#    Cuando   doy clic a iniciar registro
#    Y        valido que me encuentre en la pantalla agendamiento
#    Y        ingreso los datos de agendamiento
#    Y        presiono el boton confirmar agendamiento
#    Y        ingreso un correo electronico "hola@gmail.com"
#    Y        ingreso nuevamente el correo electronico "hola@gmail.com"
#    Y        doy click en datos del cliente
#    Y        completo los datos solicitados
#      | fechaNac   | nacionalidad | estado_civil |
#      | 12/12/1980 | Alemania     | Casado       |
#    Y        doy clic para validar contrato Movil
#    Y        doy click en validar identidad del titular
#    Y        elijo el tipo de validacion a realizar "<tipoValidacion>"
#    Y        ingreso los datos del supervisor
#      | numdoc   | user        | password     |
#      | 42770472 | rdelatorreg | $t3l3f0n1c4$ |
#    Y        ingreso los datos solicitados para la validacion del cliente
#      | nombreMadre   | nombrePadre   | distritoNac   |
#      | <nombreMadre> | <nombrePadre> | <distritoNac> |
#    Entonces valido que me muestre el boton con el texto de identidad validada
#    Y        doy clic para validar contrato Movil
#    Y        me muestra en pantalla el contrato solicitado
#    Cuando   doy clic en si acepto
#    Y        doy clic en continuar
#    Y        doy clic en Registrar venta
#    Entonces visualizo en pantalla el mensaje de exito de la venta generada
##    Y        valido que se muestre el detalle del pedido
#
#    Ejemplos:
#      | tipoUsuario     | userName    | password       | msgHome    | tiendaAsesor | tipoDocumento | documento   | departamento | provincia | distrito | direccion                   | referencia | mz | lote | piso | int | conjunto | conjHabit | numContacto | correo           | tipoValidacion | nombreMadre | nombrePadre | distritoNac            |
#      | usuario externo | lterrazosce | Telefonica2021 | Bienvenid@ | CAJAMARCA    | CE            | 12312342388 | 15           | 1501      | 150116   | Jiron Julio Cesar Tello 460 | Inkafarma  | a  | 2    | 2    | 1   | UR       | casa      | 942434295   | eloy.m@gmail.com | discapacitado  | CARMEN      | FRANCISCO   | SAN JUAN DE LURIGANCHO |


  @AltaTriomt
  Esquema del escenario: Alta trio Mt
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
      | mz | lote | vivienda | nombreVivienda | piso | int | conjunto             | conjHabit |
      | A  | 1    | casa     | alex mancilla  | 1    | 1   | URBANIZACION POPULAR | casa      |
    Y        presiono el boton consultar cobertura
    #Entonces me muestra la pantalla de ofertas sugeridos
   # Y        selecciono tipo de oferta
    Y        selecciono un plan Movistar Total "<nombrePlan>"
    Y        valido el detalle de la seleccion
    Cuando   doy clic a iniciar registro
    Y        valido que me encuentre en la pantalla agendamiento
    Y        ingreso los datos de agendamiento
    Y        presiono el boton confirmar agendamiento
    Y        presiono Consultar ubicacion
    Y        ingreso la informacion del lugar de instalacion
      | mz | lote | vivienda | nombreVivienda | piso | int | conjunto             | conjHabit |
      | A  | 1    | casa     | alex mancilla  | 1    | 1   | URBANIZACION POPULAR | casa      |
    Y        Consulto ubicacion
    Y        selecciono un tipo de entrega "Delivery Regular 48 horas"
    Y        selecciono horario "2pm-7pm"
    E        ingreso telefono del titular "998877665"
    E        ingreso instrucciones de delivery "cerca al parque"
    Y        doy clic en confirmar delivery
    E         ingreso correo de verificacion "<correo>"
    Y        doy click en datos del cliente
    Y        ingreso los datos del cliente
      | fechaNac   | estadoCivil | nacionalidad |
      | 12/12/1980 | Divorciado  | Alemania     |
    Y        doy click en el boton confirmar
    Y        doy clic para validar contrato Movil
    Y        me muestra en pantalla el contrato solicitado
    Cuando   doy clic en si acepto
    Y        doy click en el boton de continuar
    Y        presiono el boton Registrar venta
    Entonces visualizo en pantalla el mensaje de exito de la venta generada
    Ejemplos:
      | tipoUsuario     | userName | password     | msgHome    | tiendaAsesor                 | tipoDocumento | documento   | departamento | provincia | distrito | direccion                   | referencia | tipoOferta     | nombrePlan   | correo           |
      | usuario externo | lterrazosce | $t3l3f0n1c4$ | Bienvenid@ | CANAL ONLINE-CALL CENTER GSS | CE            | 1042445068 | 15           | 1501      | 150116   | JIRON JULIO CESAR TELLO 460 | Inkafarma  | MOVISTAR TOTAL | HD 500 Mbps + 95Gb | correo@gmail.com |


