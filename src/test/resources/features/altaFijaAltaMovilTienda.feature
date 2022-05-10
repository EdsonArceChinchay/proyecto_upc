#language:es
@BERSERKERS @DoneDevOps @DoneDevOpsPI11

Característica: Alta Fija + Alta Movil

  Antecedentes:
    Dado     que abro la pagina de movistar

  @AltaFijaTienda
  Esquema del escenario: Alta Tienda con DNI sin productos asociados sin biometria
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
    Y        ingreso los datos del lugar de instalacion
            | mz | lote | piso | int | conjunto | conjHabit |
            | A  | 1    | 1    | 1   | UR       | casa      |
    Y        presionamos el boton Consultar Cobertura
    Entonces me muestra la pantalla de ofertas sugeridos
    Y        selecciono el tipo de oferta "<tipoOferta>"
    Y        selecciono el tipo de plan "<tipoPlan>"
    Y        valido el detalle de la seleccion
    Cuando   doy clic a iniciar registro
    Y        valido que me encuentre en la pantalla agendamiento
    Y        ingreso datos del contacto en la pantalla agendamiento "999888777"
    Y        doy clic en confirmar agendamiento
    Entonces me muestra el detalle de la instalacion
    Y        doy clic en confirmar
    Y        completo los datos solicitados "<correo>"
    Y        doy click en validar identidad del titular
    Y        elijo el tipo de validacion a realizar "<tipoValidacion>"
    Y        ingreso los datos del supervisor
             | numdoc   | user        | password     |
             | 42770472 | rdelatorreg | $t3l3f0n1c4$ |
    Y        ingreso los datos solicitados para la validacion del cliente
            | nombreMadre   | nombrePadre   | distritoNac   |
            | <nombreMadre> | <nombrePadre> | <distritoNac> |
    Entonces valido que me muestre el boton con el texto de identidad validada
    Y        doy clic para validar contrato Movil
    Y        me muestra en pantalla el contrato solicitado
    Cuando   doy clic en si acepto
    Y        doy clic en continuar
    Entonces visualizo en pantalla el mensaje de exito


    Ejemplos:
      | tipoUsuario     | userName    | password       | msgHome    | tiendaAsesor | tipoDocumento | documento | departamento | provincia | distrito | direccion                     | referencia | tipoOferta     | tipoPlan            | correo           | tipoValidacion | nombreMadre | nombrePadre | distritoNac |
      | usuario externo | lterrazosce | Telefonica2021 | Bienvenid@ | SAN MIGUEL   | DNI           | 75769642  | 15           | 1501      | 150136   | Calle Condesa de Chinchon 107 | Casa       | MOVISTAR TOTAL | HD 100 Mbps + 26 Gb | correo@gmail.com | discapacitado  | MARIBEL     | JOSE        | SULLANA     |
