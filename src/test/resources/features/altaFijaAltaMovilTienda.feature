#language:es
@BERSERKERS @DoneDevOps @DoneDevOpsPI11

Característica: Alta Fija + Alta Movil

  Antecedentes:
    Dado     que abro la pagina de movistar
    Y        me logueo con las credenciales en la aplicacion
            | tipoUsuario     | userName    | password       |
            | usuario externo | lterrazosce | Telefonica2021 |
    Entonces valido el login exitoso mediante el mensaje "Bienvenid@"
    Y        valido que se presente la tienda "TIENDA SAN MIGUEL"


  @AltaFijaTienda
  Esquema del escenario: Alta Tienda con DNI sin productos asociados
    Cuando   selecciono el tipo de documento "<tipoDocumento>"
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
    Y        ingreso los datos del lugar de instalacion
            | mz | lote | piso | int | conjunto | conjHabit |
            | A  | 1    | 1    | 1   | UR       | casa      |
    Y        presionamos el boton Consultar Cobertura
    Entonces me muestra la pantalla de ofertas sugeridos
    Y        selecciono el tipo de oferta "<tipoOferta>"
    Y        selecciono el tipo de plan "<tipoPlan>"
    Y        valido el detalle de la seleccion
    Cuando   doy clic a iniciar registro
    Y        seleciono la fecha y hora del agendamiento
    Entonces me muestra el detalle de la instalacion
    Y        doy clic en confirmar
    Y        completo los datos solicitados "<correo>"
    Y        doy click en validar identidad del titular
    Y        elijo el tipo de validacion a realizar "<tipoValidacion>"
    Y        ingreso los datos solicitados para la validacion del cliente
             | nombreMadre   | nombrePadre   | nombrePadre   |
             | <nombreMadre> | <nombrePadre> | <nombrePadre> |
    Entonces valido que me muestre el boton con el texto de identidad validada
    Y        doy clic en continuar
    Y        me muestra en pantalla el contrato solicitado
    Cuando   doy clic en si acepto
    Entonces visualizo en pantalla el mensaje de exito
    Y        muestro en consola el numero de registro generado
    Y        doy clic para ver el contrato PDF

    Ejemplos:
      | tipoDocumento | documento | departamento | provincia | distrito | direccion                     | referencia | tipoOferta     |tipoPlan   | dniSupervisor | correo                          | tipoValidacion | nombreMadre | nombrePadre | nombrePadre |
      | DNI           | 43078337  | 15           | 1501      | 150136   | Calle Condesa de Chinchon 107 | Casa       | MOVISTAR TOTAL |PLAN NUEVO |               | capacitacionprueba576@gmail.com |                | nombreMadre | nombrePadre | nombrePadre |
