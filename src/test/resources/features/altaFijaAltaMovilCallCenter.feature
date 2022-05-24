#language:es
@BERSERKERS @DoneDevOps @DoneDevOpsPI11

Característica: Alta Fija + Alta Movil por Call Center

  Antecedentes:
    Dado     que abro la pagina de movistar

  @AltaFijaMovilCallCenter
  Esquema del escenario: Alta fija mas alta movil por Call Center con DNI sin productos asociados sin biometria
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
    Y        ingreso la informacion del lugar de instalacion
      | mz | lote |vivienda     |nombreVivienda|piso | int | conjunto            | conjHabit |
      | A  | 1    |alex mancilla|alex mancilla |1    | 1   | URBANIZACION POPULAR| casa      |
    Y        presiono el boton consultar cobertura
    Entonces me muestra la pantalla de ofertas sugeridos
    Y        selecciono tipo de oferta
    Y        selecciono el tipo de plan "<tipoPlan>"
    Y        valido el detalle de la seleccion
    Cuando   doy clic a iniciar registro
    Y        valido que me encuentre en la pantalla agendamiento
    Y        escojo un turno de agendamiento
    Y        ingreso datos del contacto en la pantalla agendamiento "999888777"
    Y        doy clic en confirmar agendamiento
    Y        doy clic nuevamente en confirmar
#    Y        selecciono el departamento donde sera la entrega "<departamento>"
#    Y        selecciono la provincia donde sera la entrega "<provincia>"
#    Y        selecciono el distrito donde sera la entrega "<distrito>"
#    Y        ingreso la direccion donde sera la entrega "<direccion>"
#    Y        ingreso la referencia de la direccion de entrega "<referencia>"
    Y        presiono Consultar ubicacion
    Y        ingreso la informacion del lugar de instalacion
      | mz | lote |vivienda     |nombreVivienda|piso | int | conjunto            | conjHabit |
      | A  | 1    |alex mancilla|alex mancilla |1    | 1   | URBANIZACION POPULAR| casa      |
    Y        presiono el boton consultar cobertura
    Y        selecciono el tipo de entrega "Delivery Express"
    Y        ingreso el telefono de contacto "658745259"
    Y        ingreso las instrucciones a considerar de la entrega "En la cuadra 8 a la derecha"
    Y        doy clic en confirmar delivery
    Y        selecciono el metodo de pago "Contra entrega"
    Y        ingreso un correo electronico "hola@gmail.com"
    Y        ingreso nuevamente el correo electronico "hola@gmail.com"
    Y        doy click en validar identidad del titular
    Y        ingreso los datos solicitados para la validacion del cliente
            | nombreMadre   | nombrePadre   | distritoNac   |
            | <nombreMadre> | <nombrePadre> | <distritoNac> |
    Entonces valido que me muestre el boton con el texto de identidad validada
    Y        doy clic para validar contrato Movil
    Y        me muestra en pantalla el contrato solicitado
    Cuando   doy clic en si acepto
    Y        doy clic en finalizar registro
    Entonces visualizo en pantalla el mensaje de exito

    Ejemplos:
      | tipoUsuario     | userName    | password       | msgHome    | tiendaAsesor                     | tipoDocumento | documento | departamento | provincia | distrito | direccion                     | referencia | tipoOferta     | tipoPlan            | correo           | tipoValidacion | nombreMadre | nombrePadre | distritoNac |
      | usuario externo | jpachaot    | $t3l3f0n1c4$   | Bienvenid@ |  CANAL ONLINE-CALL CENTER GSS    | DNI           | 75504508  | 15           | 1501      | 150136   | Calle Condesa de Chinchon 107 | Casa       | MOVISTAR TOTAL | HD 70 Mbps + 26 Gb | correo@gmail.com | discapacitado  | ELIZABETH   | JORGE       | LIMA        |


  @AltaFijaMovilCallCenter2
  Esquema del escenario: Alta fija mas alta movil por Call Center con DNI sin productos asociados sin biometria
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
    Y        ingreso la informacion del lugar de instalacion
      | mz | lote |vivienda     |nombreVivienda|piso | int | conjunto            | conjHabit |
      | A  | 1    |alex mancilla|alex mancilla |1    | 1   | URBANIZACION POPULAR| casa      |
    Y        presiono el boton consultar cobertura
    Entonces me muestra la pantalla de ofertas sugeridos
    Y        selecciono tipo de oferta
    Y        selecciono el tipo de plan "<tipoPlan>"
    Y        valido el detalle de la seleccion
    Cuando   doy clic a iniciar registro
    Y        valido que me encuentre en la pantalla agendamiento
    Y        ingreso datos del contacto en la pantalla agendamiento "999888777"
    Y        doy clic en confirmar agendamiento
    Y        selecciono el departamento donde sera la entrega "<departamento>"
    Y        selecciono la provincia donde sera la entrega "<provincia>"
    Y        selecciono el distrito donde sera la entrega "<distrito>"
    Y        ingreso la direccion donde sera la entrega "<direccion>"
    Y        ingreso la referencia de la direccion de entrega "<referencia>"
    Y        presiono Consultar ubicacion
    Y        ingreso los datos del lugar de entrega
      | mz | lote | piso | int | conjunto | conjHabit |
      | A  | 1    | 1    | 1   | UR       | casa      |
    Y        presiono el boton confirmar ubicacion
    Y        selecciono el tipo de entrega "Delivery Express"
    Y        ingreso el telefono de contacto "658745259"
    Y        ingreso las instrucciones a considerar de la entrega "En la cuadra 8 a la derecha"
    Y        doy clic en confirmar delivery
    Y        completo los datos solicitados "<correo>"
    Y        doy click en validar identidad del titular
    Y        ingreso los datos solicitados para la validacion del cliente
      | nombreMadre   | nombrePadre   | distritoNac   |
      | <nombreMadre> | <nombrePadre> | <distritoNac> |
    Entonces valido que me muestre el boton con el texto de identidad validada
    Y        doy clic para validar contrato Movil
    Y        me muestra en pantalla el contrato solicitado
    Cuando   doy clic en si acepto
    Y        doy clic en finalizar registro
    Entonces visualizo en pantalla el mensaje de exito

    Ejemplos:
      | tipoUsuario     | userName    | password       | msgHome    | tiendaAsesor                     | tipoDocumento | documento | departamento | provincia | distrito | direccion                     | referencia | tipoOferta     | tipoPlan            | correo           | nombreMadre | nombrePadre | distritoNac |
      | usuario externo | jpachaot    | $t3l3f0n1c4$   | Bienvenid@ |  CANAL ONLINE-CALL CENTER GSS    | DNI           | 75504508  | 15           | 1501      | 150136   | Calle Condesa de Chinchon 107 | Casa       | MOVISTAR TOTAL | HD 100 Mbps + 26 Gb | correo@gmail.com | ELIZABETH   | JORGE       | LIMA        |
#      | usuario externo | jpachaot    | $t3l3f0n1c4$   | Bienvenid@ |  CANAL ONLINE-CALL CENTER GSS    | DNI           | 75504508  | 15           | 1501      | 150136   | Calle Condesa de Chinchon 107 | Casa       | MOVISTAR TOTAL | HD 70 Mbps + 26 Gb  | correo@gmail.com | ELIZABETH   | JORGE       | LIMA        |
