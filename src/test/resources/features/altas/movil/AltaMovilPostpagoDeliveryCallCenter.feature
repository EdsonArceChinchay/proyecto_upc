#language:es
@BERSERKERS @DoneDevOps @DoneDevOpsPI14 @DROP35

Característica: Realizar una Alta movil Postpago (linea + equipo) con Delivery en Tambo
  sin cobertura por canal Call Center

  Antecedentes:
    Dado     que abro la pagina de movistar


     # Realizar una Alta movil Postpago (linea + equipo) con
     #Delivery en Tambo sin cobertura por canal Call Center

  @AltaMovilPostPagoDeliveryCallCenter
  Esquema del escenario: Alta movil Postpago por Call Center con DNI sin productos asociados sin biometria
    Dado  presiono el boton Iniciar Sesion
    Y        selecciono el tipo de usuario "usuario externo"
    Y        ingreso el usuario "<userName>"
    Y        ingreso el password "<password>"
    Y        presiono el boton Continuar hacia el home
    Entonces valido el login exitoso mediante el mensaje "<msgHome>"
    Y        valido que se presente la tienda "<tiendaAsesor>"
    Cuando   selecciono el tipo de documento "<tipoDocumento>"
    Y        ingreso el documento "<documento>"
    Y        doy click en el boton consultar
    Entonces ingreso los datos del cliente a registrar
      | nombres | apellidos   | genero   |
      | Ana     | Lopez Lopez | femenino |
    Y        selecciono el boton Linea Nueva Movil
    Y        selecciono el boton Mostrar ofertas
	Y        selecciono el plan_movil Postpago
    Y        selecciono el boton de eleccion de planes
    Y        selecciono el plan movil "<planMovil>"
    Y        selecciono la opcion "<tipoPlanes>"
    Y        doy click en el boton seleccionar oferta
    Y        selecciono añadir equipos
    Y        ingreso el tiempo de permanencia"<timpoPermanencia>"
    Y        ingreso el tipo de pago "<tipoPago>"
    Y        busco el equipo "<nombreEquipo>"
    Y        doy click en el boton seleccionar
    Y        selecciono la cartilla Linea Nueva
    Y        doy click en iniciar registro
    Entonces me muestra la pantalla de Delivery de linea nueva
    Y        selecciono el departamento donde sera la instalacion "<departamento>"
    Y        selecciono la provincia donde sera la instalacion "<provincia>"
    Y        selecciono el distrito donde sera la instalacion "<distrito>"
    Y        ingreso la direccion donde sera la instalacion "<direccion>"
    Y        ingreso la referencia de la direccion "<referencia>"
    Y        presiono el boton Consultar ubicacion
    Y        ingreso la informacion del lugar de instalacion
      | mz | lote | vivienda      | nombreVivienda | piso | int | conjunto             | conjHabit |
      | A1  | 11    | alex mancilla | alex mancilla  | 1    | 1   | URBANIZACION POPULAR | casa      |
    Y        presiono el boton consultar cobertura
	Y        selecciono un tipo de entrega "Delivery Regular 48 horas"
	Y        selecciono el horario de entrega "2pm-7pm"
    Y        ingreso el telefono de contacto "658745259"
    Y        ingreso las instrucciones a considerar de la entrega "En la cuadra 8 a la derecha"
    Y        doy clic en confirmar delivery
    Y        selecciono el metodo de pago "Contra entrega"
    Y        ingreso un correo electronico "hola@gmail.com"
    Y        ingreso nuevamente el correo electronico "hola@gmail.com"
    Y        doy click en datos del cliente
    Y        ingreso los datos del cliente
      | fechaNac   | estadoCivil | nacionalidad |
      | 12/12/1980 | Casado      | Albania      |
    Y        doy click en el boton confirmar
    Entonces doy clic para validar contrato Movil
    Y        me muestra en pantalla el contrato solicitado
    Cuando   doy clic en si acepto
    Y        doy click en el boton de continuar
    Entonces visualizo en pantalla el mensaje de exito de la venta generada
    Y        valido que se muestre el detalle del pedido
	Ejemplos:
      | tipoUsuario     | userName | password     | msgHome    | tiendaAsesor                 | tipoDocumento | documento  | departamento | provincia | distrito | direccion                     | referencia | tipoPlanes                                         | planMovil | timpoPermanencia | nombreEquipo                       | tipoPago   |
      | usuario externo | jpachaot | $t3l3f0n1c4$ | Bienvenid@ | CANAL ONLINE-CALL CENTER GSS | CE            | 1000000045 | 15           | 1501      | 150136   | Calle Condesa de Chinchon 107 | Casa       | RV Plan Ilimitado Mi Movistar S/99.9 IV | Postpago  | Sin permanencia  | HUAWEI P30 LITE NEGRO MAR-LX3 | Financiado 12 cuotas |
#
#  @AltaMovilPostPagoDeliveryCallCenter_Caso02
#  Esquema del escenario: Alta movil Postpago por Call Center con DNI sin productos asociados sin biometria
#    Dado  presiono el boton Iniciar Sesion
#    Y        selecciono el tipo de usuario "usuario externo"
#    Y        ingreso el usuario "<userName>"
#    Y        ingreso el password "<password>"
#    Y        presiono el boton Continuar hacia el home
#    Entonces valido el login exitoso mediante el mensaje "<msgHome>"
#    Y        valido que se presente la tienda "<tiendaAsesor>"
#    Cuando   selecciono el tipo de documento "<tipoDocumento>"
#    Y        ingreso el documento "<documento>"
#    Y        doy click en el boton consultar
#    Entonces ingreso los datos del cliente a registrar
#      | nombres | apellidos   | genero   |
#      | Ana     | Lopez Lopez | femenino |
#    Y        selecciono el boton Linea Nueva Movil
#    Y        selecciono el boton Mostrar ofertas
#    Y         selecciono el boton de eleccion de planes
#    Y         selecciono el plan movil "<planMovil>"
#    Y         selecciono la opcion "<tipoPlanes>"
#    Y         doy click en el boton seleccionar oferta
#    Y         selecciono añadir equipos
#    Y         ingreso el tiempo de permanencia"<timpoPermanencia>"
#    Y         ingreso el tipo de pago "<tipoPago>"
#    Y         busco el equipo "<nombreEquipo>"
#    Y         doy click en el boton seleccionar
#    Y         selecciono la cartilla Linea Nueva
#    Y        doy click en iniciar registro
#    Entonces    me muestra la pantalla de Delivery de linea nueva
#    Y     selecciono el departamento donde sera la instalacion "<departamento>"
#    Y        selecciono la provincia donde sera la instalacion "<provincia>"
#    Y        selecciono el distrito donde sera la instalacion "<distrito>"
#    Y        ingreso la direccion donde sera la instalacion "<direccion>"
#    Y        ingreso la referencia de la direccion "<referencia>"
#    Y        presiono el boton Consultar ubicacion
#    Y        ingreso la informacion del lugar de instalacion
#      | mz | lote | vivienda      | nombreVivienda | piso | int | conjunto             | conjHabit |
#      | A  | 1    | alex mancilla | alex mancilla  | 1    | 1   | URBANIZACION POPULAR | casa      |
#    Y        presiono el boton consultar cobertura
#    Y        selecciono el tipo de entrega "Delivery Express"
#    Y        ingreso el telefono de contacto "658745259"
#    Y        ingreso las instrucciones a considerar de la entrega "En la cuadra 8 a la derecha"
#    Y        doy clic en confirmar delivery
#    Y        selecciono el metodo de pago "Contra entrega"
#    Y        ingreso un correo electronico "hola@gmail.com"
#    Y        ingreso nuevamente el correo electronico "hola@gmail.com"
#    Y        doy click en datos del cliente
#    Y        ingreso los datos del cliente
#      | fechaNac   | estadoCivil | nacionalidad |
#      | 12/12/1980 | Casado      | Albania      |
#    Y       doy click en el boton confirmar
#    Entonces doy clic para validar contrato Movil
#    Y        me muestra en pantalla el contrato solicitado
#    Cuando   doy clic en si acepto
#    Y        doy clic en finalizar registro
#    Entonces visualizo en pantalla el mensaje de exito
#
#    Ejemplos:
#      | tipoUsuario     | userName | password     | msgHome    | tiendaAsesor                 | tipoDocumento | documento  | departamento | provincia | distrito | direccion                     | referencia | tipoPlanes                            | planMovil | timpoPermanencia | nombreEquipo                       | tipoPago   |
#      | usuario externo | jpachaot | $t3l3f0n1c4$ | Bienvenid@ | CANAL ONLINE-CALL CENTER GSS | CE            | 1000000045 | 15           | 1501      | 150136   | Calle Condesa de Chinchon 107 | Casa       | RV Plan Ilimitado Mi Movistar S/114.9 | Postpago  | 12 meses  | APPLE IPHONE 6S 16GB GRIS | Al contado |
#
#  @AltaMovilPostPagoDeliveryCallCenter_Caso03
#  Esquema del escenario: Alta movil Postpago por Call Center con DNI sin productos asociados sin biometria
#    Dado  presiono el boton Iniciar Sesion
#    Y        selecciono el tipo de usuario "usuario externo"
#    Y        ingreso el usuario "<userName>"
#    Y        ingreso el password "<password>"
#    Y        presiono el boton Continuar hacia el home
#    Entonces valido el login exitoso mediante el mensaje "<msgHome>"
#    Y        valido que se presente la tienda "<tiendaAsesor>"
#    Cuando   selecciono el tipo de documento "<tipoDocumento>"
#    Y        ingreso el documento "<documento>"
#    Y        doy click en el boton consultar
#    Entonces ingreso los datos del cliente a registrar
#      | nombres | apellidos   | genero   |
#      | Ana     | Lopez Lopez | femenino |
#    Y        selecciono el boton Linea Nueva Movil
#    Y        selecciono el boton Mostrar ofertas
#    Y         selecciono el boton de eleccion de planes
#    Y         selecciono el plan movil "<planMovil>"
#    Y         selecciono la opcion "<tipoPlanes>"
#    Y         doy click en el boton seleccionar oferta
#    Y         selecciono añadir equipos
#    Y         ingreso el tiempo de permanencia"<timpoPermanencia>"
#    Y         ingreso el tipo de pago "<tipoPago>"
#    Y         busco el equipo "<nombreEquipo>"
#    Y         doy click en el boton seleccionar
#    Y         selecciono la cartilla Linea Nueva
#    Y        doy click en iniciar registro
#    Entonces    me muestra la pantalla de Delivery de linea nueva
#    Y     selecciono el departamento donde sera la instalacion "<departamento>"
#    Y        selecciono la provincia donde sera la instalacion "<provincia>"
#    Y        selecciono el distrito donde sera la instalacion "<distrito>"
#    Y        ingreso la direccion donde sera la instalacion "<direccion>"
#    Y        ingreso la referencia de la direccion "<referencia>"
#    Y        presiono el boton Consultar ubicacion
#    Y        ingreso la informacion del lugar de instalacion
#      | mz | lote | vivienda      | nombreVivienda | piso | int | conjunto             | conjHabit |
#      | A  | 1    | alex mancilla | alex mancilla  | 1    | 1   | URBANIZACION POPULAR | casa      |
#    Y        presiono el boton consultar cobertura
#    Y        selecciono el tipo de entrega "Delivery Express"
#    Y        ingreso el telefono de contacto "658745259"
#    Y        ingreso las instrucciones a considerar de la entrega "En la cuadra 8 a la derecha"
#    Y        doy clic en confirmar delivery
#    Y        selecciono el metodo de pago "Contra entrega"
#    Y        ingreso un correo electronico "hola@gmail.com"
#    Y        ingreso nuevamente el correo electronico "hola@gmail.com"
#    Y        doy click en datos del cliente
#    Y        ingreso los datos del cliente
#      | fechaNac   | estadoCivil | nacionalidad |
#      | 12/12/1980 | Casado      | Albania      |
#    Y       doy click en el boton confirmar
#    Entonces doy clic para validar contrato Movil
#    Y        me muestra en pantalla el contrato solicitado
#    Cuando   doy clic en si acepto
#    Y        doy clic en finalizar registro
#    Entonces visualizo en pantalla el mensaje de exito
#
#    Ejemplos:
#      | tipoUsuario     | userName | password     | msgHome    | tiendaAsesor                 | tipoDocumento | documento  | departamento | provincia | distrito | direccion                     | referencia | tipoPlanes                            | planMovil | timpoPermanencia | nombreEquipo                       | tipoPago   |
#      | usuario externo | jpachaot | $t3l3f0n1c4$ | Bienvenid@ | CANAL ONLINE-CALL CENTER GSS | CE            | 1000000045 | 15           | 1501      | 150136   | Calle Condesa de Chinchon 107 | Casa       | RV Plan Ilimitado Mi Movistar S/114.9 | Postpago  | 12 meses  | SAMSUNG GXY A20 NEGRO SM-A205G | Financiado 18 cuotas |
#
#  @AltaMovilPostPagoDeliveryCallCenter_Caso04
#  Esquema del escenario: Alta movil Postpago por Call Center con DNI sin productos asociados sin biometria
#    Dado  presiono el boton Iniciar Sesion
#    Y        selecciono el tipo de usuario "usuario externo"
#    Y        ingreso el usuario "<userName>"
#    Y        ingreso el password "<password>"
#    Y        presiono el boton Continuar hacia el home
#    Entonces valido el login exitoso mediante el mensaje "<msgHome>"
#    Y        valido que se presente la tienda "<tiendaAsesor>"
#    Cuando   selecciono el tipo de documento "<tipoDocumento>"
#    Y        ingreso el documento "<documento>"
#    Y        doy click en el boton consultar
#    Entonces ingreso los datos del cliente a registrar
#      | nombres | apellidos   | genero   |
#      | Ana     | Lopez Lopez | femenino |
#    Y        selecciono el boton Linea Nueva Movil
#    Y        selecciono el boton Mostrar ofertas
#    Y         selecciono el boton de eleccion de planes
#    Y         selecciono el plan movil "<planMovil>"
#    Y         selecciono la opcion "<tipoPlanes>"
#    Y         doy click en el boton seleccionar oferta
#    Y         selecciono añadir equipos
#    Y         ingreso el tiempo de permanencia"<timpoPermanencia>"
#    Y         ingreso el tipo de pago "<tipoPago>"
#    Y         busco el equipo "<nombreEquipo>"
#    Y         doy click en el boton seleccionar
#    Y         selecciono la cartilla Linea Nueva
#    Y        doy click en iniciar registro
#    Entonces    me muestra la pantalla de Delivery de linea nueva
#    Y     selecciono el departamento donde sera la instalacion "<departamento>"
#    Y        selecciono la provincia donde sera la instalacion "<provincia>"
#    Y        selecciono el distrito donde sera la instalacion "<distrito>"
#    Y        ingreso la direccion donde sera la instalacion "<direccion>"
#    Y        ingreso la referencia de la direccion "<referencia>"
#    Y        presiono el boton Consultar ubicacion
#    Y        ingreso la informacion del lugar de instalacion
#      | mz | lote | vivienda      | nombreVivienda | piso | int | conjunto             | conjHabit |
#      | A  | 1    | alex mancilla | alex mancilla  | 1    | 1   | URBANIZACION POPULAR | casa      |
#    Y        presiono el boton consultar cobertura
#    Y        selecciono el tipo de entrega "Delivery Express"
#    Y        ingreso el telefono de contacto "658745259"
#    Y        ingreso las instrucciones a considerar de la entrega "En la cuadra 8 a la derecha"
#    Y        doy clic en confirmar delivery
#    Y        selecciono el metodo de pago "Contra entrega"
#    Y        ingreso un correo electronico "hola@gmail.com"
#    Y        ingreso nuevamente el correo electronico "hola@gmail.com"
#    Y        doy click en datos del cliente
#    Y        ingreso los datos del cliente
#      | fechaNac   | estadoCivil | nacionalidad |
#      | 12/12/1980 | Casado      | Albania      |
#    Y       doy click en el boton confirmar
#    Entonces doy clic para validar contrato Movil
#    Y        me muestra en pantalla el contrato solicitado
#    Cuando   doy clic en si acepto
#    Y        doy clic en finalizar registro
#    Entonces visualizo en pantalla el mensaje de exito
#    Ejemplos:
#      | tipoUsuario     | userName | password     | msgHome    | tiendaAsesor                 | tipoDocumento | documento  | departamento | provincia | distrito | direccion                     | referencia | tipoPlanes                            | planMovil | timpoPermanencia | nombreEquipo                       | tipoPago   |
#      | usuario externo | jpachaot | $t3l3f0n1c4$ | Bienvenid@ | CANAL ONLINE-CALL CENTER GSS | CE            | 1000000045 | 15           | 1501      | 150136   | Calle Condesa de Chinchon 107 | Casa       | RV Plan Ilimitado Mi Movistar S/149.9 | Postpago  | 12 meses | IPHONE 11 PRO MAX GRIS MWHJ2LZ/A 256GB | Financiado 12 cuotas |
#
#
#  @AltaMovilPostPagoDeliveryCallCenter_Caso05
#  Esquema del escenario: Alta movil Postpago por Call Center con DNI sin productos asociados sin biometria
#    Dado  presiono el boton Iniciar Sesion
#    Y        selecciono el tipo de usuario "usuario externo"
#    Y        ingreso el usuario "<userName>"
#    Y        ingreso el password "<password>"
#    Y        presiono el boton Continuar hacia el home
#    Entonces valido el login exitoso mediante el mensaje "<msgHome>"
#    Y        valido que se presente la tienda "<tiendaAsesor>"
#    Cuando   selecciono el tipo de documento "<tipoDocumento>"
#    Y        ingreso el documento "<documento>"
#    Y        doy click en el boton consultar
#    Entonces ingreso los datos del cliente a registrar
#      | nombres | apellidos   | genero   |
#      | Ana     | Lopez Lopez | femenino |
#    Y        selecciono el boton Linea Nueva Movil
#    Y        selecciono el boton Mostrar ofertas
#    Y         selecciono el boton de eleccion de planes
#    Y         selecciono el plan movil "<planMovil>"
#    Y         selecciono la opcion "<tipoPlanes>"
#    Y         doy click en el boton seleccionar oferta
#    Y         selecciono añadir equipos
#    Y         ingreso el tiempo de permanencia"<timpoPermanencia>"
#    Y         ingreso el tipo de pago "<tipoPago>"
#    Y         busco el equipo "<nombreEquipo>"
#    Y         doy click en el boton seleccionar
#    Y         selecciono la cartilla Linea Nueva
#    Y        doy click en iniciar registro
#    Entonces    me muestra la pantalla de Delivery de linea nueva
#    Y     selecciono el departamento donde sera la instalacion "<departamento>"
#    Y        selecciono la provincia donde sera la instalacion "<provincia>"
#    Y        selecciono el distrito donde sera la instalacion "<distrito>"
#    Y        ingreso la direccion donde sera la instalacion "<direccion>"
#    Y        ingreso la referencia de la direccion "<referencia>"
#    Y        presiono el boton Consultar ubicacion
#    Y        ingreso la informacion del lugar de instalacion
#      | mz | lote | vivienda      | nombreVivienda | piso | int | conjunto             | conjHabit |
#      | A  | 1    | alex mancilla | alex mancilla  | 1    | 1   | URBANIZACION POPULAR | casa      |
#    Y        presiono el boton consultar cobertura
#    Y        selecciono el tipo de entrega "Delivery Express"
#    Y        ingreso el telefono de contacto "658745259"
#    Y        ingreso las instrucciones a considerar de la entrega "En la cuadra 8 a la derecha"
#    Y        doy clic en confirmar delivery
#    Y        selecciono el metodo de pago "Contra entrega"
#    Y        ingreso un correo electronico "hola@gmail.com"
#    Y        ingreso nuevamente el correo electronico "hola@gmail.com"
#    Y        doy click en datos del cliente
#    Y        ingreso los datos del cliente
#      | fechaNac   | estadoCivil | nacionalidad |
#      | 12/12/1980 | Casado      | Albania      |
#    Y       doy click en el boton confirmar
#    Entonces doy clic para validar contrato Movil
#    Y        me muestra en pantalla el contrato solicitado
#    Cuando   doy clic en si acepto
#    Y        doy clic en finalizar registro
#    Entonces visualizo en pantalla el mensaje de exito
#    Ejemplos:
#      | tipoUsuario     | userName | password     | msgHome    | tiendaAsesor                 | tipoDocumento | documento  | departamento | provincia | distrito | direccion                     | referencia | tipoPlanes                            | planMovil | timpoPermanencia | nombreEquipo                       | tipoPago   |
#      | usuario externo | jpachaot | $t3l3f0n1c4$ | Bienvenid@ | CANAL ONLINE-CALL CENTER GSS | CE            | 1000000045 | 15           | 1501      | 150136   | Calle Condesa de Chinchon 107 | Casa       | RV Plan Ilimitado Mi Movistar S/85.9 | Postpago  | 12 meses  | HUAWEI P30 AZUL ELLE-L04 | Financiado 12 cuotas |
#
#  @AltaMovilPostPagoDeliveryCallCenter_Caso06
#  Esquema del escenario: Alta movil Postpago por Call Center con DNI sin productos asociados sin biometria
#    Dado  presiono el boton Iniciar Sesion
#    Y        selecciono el tipo de usuario "usuario externo"
#    Y        ingreso el usuario "<userName>"
#    Y        ingreso el password "<password>"
#    Y        presiono el boton Continuar hacia el home
#    Entonces valido el login exitoso mediante el mensaje "<msgHome>"
#    Y        valido que se presente la tienda "<tiendaAsesor>"
#    Cuando   selecciono el tipo de documento "<tipoDocumento>"
#    Y        ingreso el documento "<documento>"
#    Y        doy click en el boton consultar
#    Entonces ingreso los datos del cliente a registrar
#      | nombres | apellidos   | genero   |
#      | Ana     | Lopez Lopez | femenino |
#    Y        selecciono el boton Linea Nueva Movil
#    Y        selecciono el boton Mostrar ofertas
#    Y         selecciono el boton de eleccion de planes
#    Y         selecciono el plan movil "<planMovil>"
#    Y         selecciono la opcion "<tipoPlanes>"
#    Y         doy click en el boton seleccionar oferta
#    Y         selecciono añadir equipos
#    Y         ingreso el tiempo de permanencia"<timpoPermanencia>"
#    Y         ingreso el tipo de pago "<tipoPago>"
#    Y         busco el equipo "<nombreEquipo>"
#    Y         doy click en el boton seleccionar
#    Y         selecciono la cartilla Linea Nueva
#    Y        doy click en iniciar registro
#    Entonces    me muestra la pantalla de Delivery de linea nueva
#    Y     selecciono el departamento donde sera la instalacion "<departamento>"
#    Y        selecciono la provincia donde sera la instalacion "<provincia>"
#    Y        selecciono el distrito donde sera la instalacion "<distrito>"
#    Y        ingreso la direccion donde sera la instalacion "<direccion>"
#    Y        ingreso la referencia de la direccion "<referencia>"
#    Y        presiono el boton Consultar ubicacion
#    Y        ingreso la informacion del lugar de instalacion
#      | mz | lote | vivienda      | nombreVivienda | piso | int | conjunto             | conjHabit |
#      | A  | 1    | alex mancilla | alex mancilla  | 1    | 1   | URBANIZACION POPULAR | casa      |
#    Y        presiono el boton consultar cobertura
#    Y        selecciono el tipo de entrega "Delivery Express"
#    Y        ingreso el telefono de contacto "658745259"
#    Y        ingreso las instrucciones a considerar de la entrega "En la cuadra 8 a la derecha"
#    Y        doy clic en confirmar delivery
#    Y        selecciono el metodo de pago "Contra entrega"
#    Y        ingreso un correo electronico "hola@gmail.com"
#    Y        ingreso nuevamente el correo electronico "hola@gmail.com"
#    Y        doy click en datos del cliente
#    Y        ingreso los datos del cliente
#      | fechaNac   | estadoCivil | nacionalidad |
#      | 12/12/1980 | Casado      | Albania      |
#    Y       doy click en el boton confirmar
#    Entonces doy clic para validar contrato Movil
#    Y        me muestra en pantalla el contrato solicitado
#    Cuando   doy clic en si acepto
#    Y        doy clic en finalizar registro
#    Entonces visualizo en pantalla el mensaje de exito
#    Ejemplos:
#      | tipoUsuario     | userName | password     | msgHome    | tiendaAsesor                 | tipoDocumento | documento  | departamento | provincia | distrito | direccion                     | referencia | tipoPlanes                            | planMovil | timpoPermanencia | nombreEquipo                       | tipoPago   |
#      | usuario externo | jpachaot | $t3l3f0n1c4$ | Bienvenid@ | CANAL ONLINE-CALL CENTER GSS | CE            | 1000000045 | 15           | 1501      | 150136   | Calle Condesa de Chinchon 107 | Casa       | RV Plan Ilimitado Mi Movistar S/55.9 III | Postpago  | 12 meses  | IPHONE XS MAX MT532LZ/A 256GB GRIS | Financiado 12 cuotas |
#
#  @AltaMovilPostPagoDeliveryCallCenter_Caso07
#  Esquema del escenario: Alta movil Postpago por Call Center con DNI sin productos asociados sin biometria
#    Dado  presiono el boton Iniciar Sesion
#    Y        selecciono el tipo de usuario "usuario externo"
#    Y        ingreso el usuario "<userName>"
#    Y        ingreso el password "<password>"
#    Y        presiono el boton Continuar hacia el home
#    Entonces valido el login exitoso mediante el mensaje "<msgHome>"
#    Y        valido que se presente la tienda "<tiendaAsesor>"
#    Cuando   selecciono el tipo de documento "<tipoDocumento>"
#    Y        ingreso el documento "<documento>"
#    Y        doy click en el boton consultar
#    Entonces ingreso los datos del cliente a registrar
#      | nombres | apellidos   | genero   |
#      | Ana     | Lopez Lopez | femenino |
#    Y        selecciono el boton Linea Nueva Movil
#    Y        selecciono el boton Mostrar ofertas
#    Y         selecciono el boton de eleccion de planes
#    Y         selecciono el plan movil "<planMovil>"
#    Y         selecciono la opcion "<tipoPlanes>"
#    Y         doy click en el boton seleccionar oferta
#    Y         selecciono añadir equipos
#    Y         ingreso el tiempo de permanencia"<timpoPermanencia>"
#    Y         ingreso el tipo de pago "<tipoPago>"
#    Y         busco el equipo "<nombreEquipo>"
#    Y         doy click en el boton seleccionar
#    Y         selecciono la cartilla Linea Nueva
#    Y        doy click en iniciar registro
#    Entonces    me muestra la pantalla de Delivery de linea nueva
#    Y     selecciono el departamento donde sera la instalacion "<departamento>"
#    Y        selecciono la provincia donde sera la instalacion "<provincia>"
#    Y        selecciono el distrito donde sera la instalacion "<distrito>"
#    Y        ingreso la direccion donde sera la instalacion "<direccion>"
#    Y        ingreso la referencia de la direccion "<referencia>"
#    Y        presiono el boton Consultar ubicacion
#    Y        ingreso la informacion del lugar de instalacion
#      | mz | lote | vivienda      | nombreVivienda | piso | int | conjunto             | conjHabit |
#      | A  | 1    | alex mancilla | alex mancilla  | 1    | 1   | URBANIZACION POPULAR | casa      |
#    Y        presiono el boton consultar cobertura
#    Y        selecciono el tipo de entrega "Delivery Express"
#    Y        ingreso el telefono de contacto "658745259"
#    Y        ingreso las instrucciones a considerar de la entrega "En la cuadra 8 a la derecha"
#    Y        doy clic en confirmar delivery
#    Y        selecciono el metodo de pago "Contra entrega"
#    Y        ingreso un correo electronico "hola@gmail.com"
#    Y        ingreso nuevamente el correo electronico "hola@gmail.com"
#    Y        doy click en datos del cliente
#    Y        ingreso los datos del cliente
#      | fechaNac   | estadoCivil | nacionalidad |
#      | 12/12/1980 | Casado      | Albania      |
#    Y       doy click en el boton confirmar
#    Entonces doy clic para validar contrato Movil
#    Y        me muestra en pantalla el contrato solicitado
#    Cuando   doy clic en si acepto
#    Y        doy clic en finalizar registro
#    Entonces visualizo en pantalla el mensaje de exito
#    Ejemplos:
#      | tipoUsuario     | userName | password     | msgHome    | tiendaAsesor                 | tipoDocumento | documento  | departamento | provincia | distrito | direccion                     | referencia | tipoPlanes                            | planMovil | timpoPermanencia | nombreEquipo                       | tipoPago   |
#      | usuario externo | jpachaot | $t3l3f0n1c4$ | Bienvenid@ | CANAL ONLINE-CALL CENTER GSS | CE            | 1000000045 | 15           | 1501      | 150136   | Calle Condesa de Chinchon 107 | Casa       | RV Plan Ilimitado Mi Movistar S/75.90 II | Postpago  | 12 meses  | IPHONE 12 PRO MAX GRIS MGDC3LZ/A 256GB | Al contado |
#
#  @AltaMovilPostPagoDeliveryCallCenter_Caso08
#  Esquema del escenario: Alta movil Postpago por Call Center con DNI sin productos asociados sin biometria
#    Dado  presiono el boton Iniciar Sesion
#    Y        selecciono el tipo de usuario "usuario externo"
#    Y        ingreso el usuario "<userName>"
#    Y        ingreso el password "<password>"
#    Y        presiono el boton Continuar hacia el home
#    Entonces valido el login exitoso mediante el mensaje "<msgHome>"
#    Y        valido que se presente la tienda "<tiendaAsesor>"
#    Cuando   selecciono el tipo de documento "<tipoDocumento>"
#    Y        ingreso el documento "<documento>"
#    Y        doy click en el boton consultar
#    Entonces ingreso los datos del cliente a registrar
#      | nombres | apellidos   | genero   |
#      | Ana     | Lopez Lopez | femenino |
#    Y        selecciono el boton Linea Nueva Movil
#    Y        selecciono el boton Mostrar ofertas
#    Y         selecciono el boton de eleccion de planes
#    Y         selecciono el plan movil "<planMovil>"
#    Y         selecciono la opcion "<tipoPlanes>"
#    Y         doy click en el boton seleccionar oferta
#    Y         selecciono añadir equipos
#    Y         ingreso el tiempo de permanencia"<timpoPermanencia>"
#    Y         ingreso el tipo de pago "<tipoPago>"
#    Y         busco el equipo "<nombreEquipo>"
#    Y         doy click en el boton seleccionar
#    Y         selecciono la cartilla Linea Nueva
#    Y        doy click en iniciar registro
#    Entonces    me muestra la pantalla de Delivery de linea nueva
#    Y     selecciono el departamento donde sera la instalacion "<departamento>"
#    Y        selecciono la provincia donde sera la instalacion "<provincia>"
#    Y        selecciono el distrito donde sera la instalacion "<distrito>"
#    Y        ingreso la direccion donde sera la instalacion "<direccion>"
#    Y        ingreso la referencia de la direccion "<referencia>"
#    Y        presiono el boton Consultar ubicacion
#    Y        ingreso la informacion del lugar de instalacion
#      | mz | lote | vivienda      | nombreVivienda | piso | int | conjunto             | conjHabit |
#      | A  | 1    | alex mancilla | alex mancilla  | 1    | 1   | URBANIZACION POPULAR | casa      |
#    Y        presiono el boton consultar cobertura
#    Y        selecciono el tipo de entrega "Delivery Express"
#    Y        ingreso el telefono de contacto "658745259"
#    Y        ingreso las instrucciones a considerar de la entrega "En la cuadra 8 a la derecha"
#    Y        doy clic en confirmar delivery
#    Y        selecciono el metodo de pago "Contra entrega"
#    Y        ingreso un correo electronico "hola@gmail.com"
#    Y        ingreso nuevamente el correo electronico "hola@gmail.com"
#    Y        doy click en datos del cliente
#    Y        ingreso los datos del cliente
#      | fechaNac   | estadoCivil | nacionalidad |
#      | 12/12/1980 | Casado      | Albania      |
#    Y       doy click en el boton confirmar
#    Entonces doy clic para validar contrato Movil
#    Y        me muestra en pantalla el contrato solicitado
#    Cuando   doy clic en si acepto
#    Y        doy clic en finalizar registro
#    Entonces visualizo en pantalla el mensaje de exito
#    Ejemplos:
#      | tipoUsuario     | userName | password     | msgHome    | tiendaAsesor                 | tipoDocumento | documento  | departamento | provincia | distrito | direccion                     | referencia | tipoPlanes                            | planMovil | timpoPermanencia | nombreEquipo                       | tipoPago   |
#      | usuario externo | jpachaot | $t3l3f0n1c4$ | Bienvenid@ | CANAL ONLINE-CALL CENTER GSS | CE            | 1000000045 | 15           | 1501      | 150136   | Calle Condesa de Chinchon 107 | Casa       | RV Plan Ilimitado Mi Movistar S/99.9 | Postpago  | Sin permanencia  | HUAWEI P10 NEGRO | Financiado 12 cuotas |
#
#  @AltaMovilPostPagoDeliveryCallCenter_Caso09
#  Esquema del escenario: Alta movil Postpago por Call Center con DNI sin productos asociados sin biometria
#    Dado  presiono el boton Iniciar Sesion
#    Y        selecciono el tipo de usuario "usuario externo"
#    Y        ingreso el usuario "<userName>"
#    Y        ingreso el password "<password>"
#    Y        presiono el boton Continuar hacia el home
#    Entonces valido el login exitoso mediante el mensaje "<msgHome>"
#    Y        valido que se presente la tienda "<tiendaAsesor>"
#    Cuando   selecciono el tipo de documento "<tipoDocumento>"
#    Y        ingreso el documento "<documento>"
#    Y        doy click en el boton consultar
#    Entonces ingreso los datos del cliente a registrar
#      | nombres | apellidos   | genero   |
#      | Ana     | Lopez Lopez | femenino |
#    Y        selecciono el boton Linea Nueva Movil
#    Y        selecciono el boton Mostrar ofertas
#    Y         selecciono el boton de eleccion de planes
#    Y         selecciono el plan movil "<planMovil>"
#    Y         selecciono la opcion "<tipoPlanes>"
#    Y         doy click en el boton seleccionar oferta
#    Y         selecciono añadir equipos
#    Y         ingreso el tiempo de permanencia"<timpoPermanencia>"
#    Y         ingreso el tipo de pago "<tipoPago>"
#    Y         busco el equipo "<nombreEquipo>"
#    Y         doy click en el boton seleccionar
#    Y         selecciono la cartilla Linea Nueva
#    Y        doy click en iniciar registro
#    Entonces    me muestra la pantalla de Delivery de linea nueva
#    Y     selecciono el departamento donde sera la instalacion "<departamento>"
#    Y        selecciono la provincia donde sera la instalacion "<provincia>"
#    Y        selecciono el distrito donde sera la instalacion "<distrito>"
#    Y        ingreso la direccion donde sera la instalacion "<direccion>"
#    Y        ingreso la referencia de la direccion "<referencia>"
#    Y        presiono el boton Consultar ubicacion
#    Y        ingreso la informacion del lugar de instalacion
#      | mz | lote | vivienda      | nombreVivienda | piso | int | conjunto             | conjHabit |
#      | A  | 1    | alex mancilla | alex mancilla  | 1    | 1   | URBANIZACION POPULAR | casa      |
#    Y        presiono el boton consultar cobertura
#    Y        selecciono el tipo de entrega "Delivery Express"
#    Y        ingreso el telefono de contacto "658745259"
#    Y        ingreso las instrucciones a considerar de la entrega "En la cuadra 8 a la derecha"
#    Y        doy clic en confirmar delivery
#    Y        selecciono el metodo de pago "Contra entrega"
#    Y        ingreso un correo electronico "hola@gmail.com"
#    Y        ingreso nuevamente el correo electronico "hola@gmail.com"
#    Y        doy click en datos del cliente
#    Y        ingreso los datos del cliente
#      | fechaNac   | estadoCivil | nacionalidad |
#      | 12/12/1980 | Casado      | Albania      |
#    Y       doy click en el boton confirmar
#    Entonces doy clic para validar contrato Movil
#    Y        me muestra en pantalla el contrato solicitado
#    Cuando   doy clic en si acepto
#    Y        doy clic en finalizar registro
#    Entonces visualizo en pantalla el mensaje de exito
#
#    Ejemplos:
#      | tipoUsuario     | userName | password     | msgHome    | tiendaAsesor                 | tipoDocumento | documento  | departamento | provincia | distrito | direccion                     | referencia | tipoPlanes                            | planMovil | timpoPermanencia | nombreEquipo                       | tipoPago   |
#      | usuario externo | jpachaot | $t3l3f0n1c4$ | Bienvenid@ | CANAL ONLINE-CALL CENTER GSS | CE            | 1000000045 | 15           | 1501      | 150136   | Calle Condesa de Chinchon 107 | Casa       | RV Plan Ilimitado Mi Movistar S/65.9 II | Postpago  | 12 meses | SAMSUNG GXY S10 NEGRO SM-G973FZ 128GB | Financiado 12 cuotas |
