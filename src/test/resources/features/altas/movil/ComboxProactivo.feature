#language:es
##CREADOR:
##APP: DITO
##MODULO:
##FUNCIONALIDAD:
##ESTADO:
##CODIGO: AT-DT032
##GDAP: GDAP-575
##SPRINT CREADO:
##FRECUENCIA:
##TAG : BERSERKERS
##DATA:
##ENCARGADO:
##FECMOD: 31/03/2023

@carlos
@BERSERKERS @DoneDevOps @DoneDevOpsPI15

Característica: AT-DT032_Alta Movil por Combo Proactivo

  Antecedentes:

    Dado     que abro la pagina de movistar

  @AltaFijaMovilComboProactivo_HappyPath
  Esquema del escenario: Alta  movil Combo Proactivo con Nuevo Cliente Extranjero
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
      | nombres | apellidos   | genero   |
      | Ana     | Lopez Lopez | femenino |
    Y        selecciono el boton Linea Nueva Movil
    Y        selecciono el boton Mostrar ofertas
    Y        selecciono el plan "Postpago" que desea
    Y        doy click en el boton Siguiente
    Y valido que este en la pagina de ofertas sugeridas
    Y         selecciono el boton de eleccion de planes
    Y         selecciono el plan movil "<planMovil>"
    Y         selecciono la opcion "<tipoPlanes>"
    Y         doy click en el boton seleccionar oferta
    Y         selecciono añadir equipos
    Y         ingreso el tiempo de permanencia"<tiempoPermanencia>"
    Y         ingreso el tipo de pago "<tipoPago>"
    Y         busco el equipo "<nombreEquipo>"
    Y         doy click en el boton seleccionar
    Y         selecciono la cartilla Linea Nueva
    Y        doy click en iniciar registro
    Y        ingreso un correo electronico "hola@gmail.com"
    Y        ingreso nuevamente el correo electronico "hola@gmail.com"
    Y        doy click en datos del cliente
    Y        selecciono completar los datos del cliente
      | fechaNac   | estadoCivil | nacionalidad | departamento | provincia | distrito | direccion |
      | 12/12/1980 | soltero     | Albania      | APURIMAC     | ABANCAY   | ABANCAY  | CASA      |
    Y        doy clic para validar contrato Movil
    Y        me muestra en pantalla el contrato solicitado
    Cuando   doy clic en si acepto
    Y        doy clic en continuar
    Y        me muestra pantalla para Descargar contrato
    Y        doy clic para descargar el contrato
    Y        doy clic en Registrar venta
    Entonces visualizo en pantalla el mensaje de exito de la venta generada
    #Y        valido que se muestre el detalle del pedido

    Ejemplos:
      | tipoUsuario     | userName     | password      | msgHome    | tiendaAsesor | tipoDocumento | documento  | tipoPlanes                            | nombreEquipo                           | planMovil | tiempoPermanencia | tipoPago             |
      | usuario externo | evillanuevag | #o2Wy23oA1458 | Bienvenid@ | MOQUEGUA     | CE            | 1000440045 | RV Plan Ilimitado Mi Movistar S/114.9 | IPHONE 11 PRO MAX GRIS MWHJ2LZ/A 256GB | Postpago  | sin permanencia   | Financiado 12 cuotas |


  @AltaFijaMovilComboProactivo_Caso02
  Esquema del escenario: Alta  movil Combo Proactivo con Nuevo Cliente Extranjero
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
    Y        selecciono el boton Linea Nueva Movil
    Y        selecciono el boton Mostrar ofertas
    Y        selecciono el plan "Postpago" que desea
    Y        doy click en el boton Siguiente
    Y        valido que este en la pagina de ofertas sugeridas
    Y         selecciono el boton de eleccion de planes
    Y         selecciono el plan movil "<planMovil>"
    Y         selecciono la opcion "<tipoPlanes>"
    Y         doy click en el boton seleccionar oferta
    Y         selecciono añadir equipos
    Y         ingreso el tiempo de permanencia"<tiempoPermanencia>"
    Y         ingreso el tipo de pago "<tipoPago>"
    Y         busco el equipo "<nombreEquipo>"
    Y         doy click en el boton seleccionar
    Y         selecciono la cartilla Linea Nueva
    Y        doy click en iniciar registro
    Y        ingreso un correo electronico "hola@gmail.com"
    Y        ingreso nuevamente el correo electronico "hola@gmail.com"
    Y        doy click en datos del cliente
    Y        selecciono completar los datos del cliente
      | fechaNac   | estadoCivil | nacionalidad | departamento | provincia | distrito | direccion |
      | 12/12/1980 | soltero     | Albania      | APURIMAC     | ABANCAY   | ABANCAY  | CASA      |
    Y        doy clic para validar contrato Movil
    Y        me muestra en pantalla el contrato solicitado
    Cuando   doy clic en si acepto
    Y        doy clic en continuar
    Y        me muestra pantalla para Descargar contrato
    Y        doy clic para descargar el contrato
    Y        doy clic en Registrar venta
    Entonces visualizo en pantalla el mensaje de exito de la venta generada
    Y        valido que se muestre el detalle del pedido
    Ejemplos:
      | tipoUsuario     | userName     | password     | msgHome    | tiendaAsesor | tipoDocumento | documento  | tipoPlanes                               | nombreEquipo                           | planMovil | tiempoPermanencia | tipoPago             |
      | usuario externo | evillanuevag | #o2Wy23oA1458 | Bienvenid@ | MOQUEGUA     | CE            | 10000444046 | RV Plan Ilimitado Mi Movistar S/75.90 II | IPHONE 11 PRO MAX GRIS MWHJ2LZ/A 256GB | Postpago  | 12 meses          | Financiado 18 cuotas |


  @AltaFijaMovilComboProactivo_Caso03
  Esquema del escenario: Alta  movil Combo Proactivo con Nuevo Cliente Extranjero
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
    Y        selecciono el boton Linea Nueva Movil
    Y        selecciono el boton Mostrar ofertas
    Y        selecciono el plan "Postpago" que desea
    Y        doy click en el boton Siguiente
    Y valido que este en la pagina de ofertas sugeridas
    Y         selecciono el boton de eleccion de planes
    Y         selecciono el plan movil "<planMovil>"
    Y         selecciono la opcion "<tipoPlanes>"
    Y         doy click en el boton seleccionar oferta
    Y         selecciono añadir equipos
    Y         ingreso el tiempo de permanencia"<tiempoPermanencia>"
    Y         ingreso el tipo de pago "<tipoPago>"
    Y         busco el equipo "<nombreEquipo>"
    Y         doy click en el boton seleccionar
    Y         selecciono la cartilla Linea Nueva
    Y        doy click en iniciar registro
    Y        ingreso un correo electronico "hola@gmail.com"
    Y        ingreso nuevamente el correo electronico "hola@gmail.com"
    Y        doy click en datos del cliente
    Y        selecciono completar los datos del cliente
      | fechaNac   | estadoCivil | nacionalidad | departamento | provincia | distrito | direccion |
      | 12/12/1980 | soltero     | Albania      | APURIMAC     | ABANCAY   | ABANCAY  | CASA      |
    Y        doy clic para validar contrato Movil
    Y        me muestra en pantalla el contrato solicitado
    Cuando   doy clic en si acepto
    Y        doy clic en continuar
    Y        me muestra pantalla para Descargar contrato
    Y        doy clic para descargar el contrato
    Y        doy clic en Registrar venta
    Entonces visualizo en pantalla el mensaje de exito de la venta generada
    Y        valido que se muestre el detalle del pedido
    Ejemplos:
      | tipoUsuario     | userName     | password     | msgHome    | tiendaAsesor | tipoDocumento | documento  | tipoPlanes                            | nombreEquipo                           | planMovil | tiempoPermanencia | tipoPago   |
      | usuario externo | evillanuevag | #o2Wy23oA1458 | Bienvenid@ | MOQUEGUA     | CE            | 1004440045 | RV Plan Ilimitado Mi Movistar S/114.9 | IPHONE 12 PRO MAX GRIS MGDC3LZ/A 256GB | Postpago  | 12 meses          | Al contado |


  @AltaFijaMovilComboProactivo_Caso04
  Esquema del escenario: Alta  movil Combo Proactivo con Nuevo Cliente Extranjero
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
    Y        selecciono el boton Linea Nueva Movil
    Y        selecciono el boton Mostrar ofertas
    Y        selecciono el plan "Postpago" que desea
    Y        doy click en el boton Siguiente
    Y valido que este en la pagina de ofertas sugeridas
    Y         selecciono el boton de eleccion de planes
    Y         selecciono el plan movil "<planMovil>"
    Y         selecciono la opcion "<tipoPlanes>"
    Y         doy click en el boton seleccionar oferta
    Y         selecciono añadir equipos
    Y         ingreso el tiempo de permanencia"<tiempoPermanencia>"
    Y         ingreso el tipo de pago "<tipoPago>"
    Y         busco el equipo "<nombreEquipo>"
    Y         doy click en el boton seleccionar
    Y         selecciono la cartilla Linea Nueva
    Y        doy click en iniciar registro
    Y        ingreso un correo electronico "hola@gmail.com"
    Y        ingreso nuevamente el correo electronico "hola@gmail.com"
    Y        doy click en datos del cliente
    Y        selecciono completar los datos del cliente
      | fechaNac   | estadoCivil | nacionalidad | departamento | provincia | distrito | direccion |
      | 12/12/1980 | soltero     | Albania      | APURIMAC     | ABANCAY   | ABANCAY  | CASA      |
    Y        doy clic para validar contrato Movil
    Y        me muestra en pantalla el contrato solicitado
    Cuando   doy clic en si acepto
    Y        doy clic en continuar
    Y        me muestra pantalla para Descargar contrato
    Y        doy clic para descargar el contrato
    Y        doy clic en Registrar venta
    Entonces visualizo en pantalla el mensaje de exito de la venta generada
    Y        valido que se muestre el detalle del pedido

    Ejemplos:
      | tipoUsuario     | userName     | password     | msgHome    | tiendaAsesor | tipoDocumento | documento  | tipoPlanes                               | nombreEquipo     | planMovil | tiempoPermanencia | tipoPago             |
      | usuario externo | evillanuevag | #o2Wy23oA1458 | Bienvenid@ | MOQUEGUA     | CE            | 1000936045 | RV Plan Ilimitado Mi Movistar S/55.9 III | HUAWEI P10 NEGRO | Postpago  | 12 meses          | Financiado 18 cuotas |


  @AltaFijaMovilComboProactivo_Caso05
  Esquema del escenario: Alta  movil Combo Proactivo con Nuevo Cliente Extranjero
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
    Y        selecciono el boton Linea Nueva Movil
    Y        selecciono el boton Mostrar ofertas
    Y        selecciono el plan "Postpago" que desea
    Y        doy click en el boton Siguiente
    Y valido que este en la pagina de ofertas sugeridas
    Y         selecciono el boton de eleccion de planes
    Y         selecciono el plan movil "<planMovil>"
    Y         selecciono la opcion "<tipoPlanes>"
    Y         doy click en el boton seleccionar oferta
    Y         selecciono añadir equipos
    Y         ingreso el tiempo de permanencia"<tiempoPermanencia>"
    Y         ingreso el tipo de pago "<tipoPago>"
    Y         busco el equipo "<nombreEquipo>"
    Y         doy click en el boton seleccionar
    Y         selecciono la cartilla Linea Nueva
    Y        doy click en iniciar registro
    Y        ingreso un correo electronico "hola@gmail.com"
    Y        ingreso nuevamente el correo electronico "hola@gmail.com"
    Y        doy click en datos del cliente
    Y        selecciono completar los datos del cliente
      | fechaNac   | estadoCivil | nacionalidad | departamento | provincia | distrito | direccion |
      | 12/12/1980 | soltero     | Albania      | APURIMAC     | ABANCAY   | ABANCAY  | CASA      |
    Y        doy clic para validar contrato Movil
    Y        me muestra en pantalla el contrato solicitado
    Cuando   doy clic en si acepto
    Y        doy clic en continuar
    Y        me muestra pantalla para Descargar contrato
    Y        doy clic para descargar el contrato
    Y        doy clic en Registrar venta
    Entonces visualizo en pantalla el mensaje de exito de la venta generada
    Y        valido que se muestre el detalle del pedido
    Ejemplos:
      | tipoUsuario     | userName     | password     | msgHome    | tiendaAsesor | tipoDocumento | documento  | tipoPlanes                           | nombreEquipo                   | planMovil | tiempoPermanencia | tipoPago             |
      | usuario externo | evillanuevag | #o2Wy23oA1458 | Bienvenid@ | MOQUEGUA     | CE            | 1007890045 | RV Plan Ilimitado Mi Movistar S/85.9 | SAMSUNG GXY A20 NEGRO SM-A205G | Postpago  | sin permanencia   | Financiado 12 cuotas |


  @AltaFijaMovilComboProactivo_Caso06
  Esquema del escenario: Alta  movil Combo Proactivo con Nuevo Cliente Extranjero
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
    Y        selecciono el boton Linea Nueva Movil
    Y        selecciono el boton Mostrar ofertas
    Y        selecciono el plan "Postpago" que desea
    Y        doy click en el boton Siguiente
    Y valido que este en la pagina de ofertas sugeridas
    Y         selecciono el boton de eleccion de planes
    Y         selecciono el plan movil "<planMovil>"
    Y         selecciono la opcion "<tipoPlanes>"
    Y         doy click en el boton seleccionar oferta
    Y         selecciono añadir equipos
    Y         ingreso el tiempo de permanencia"<tiempoPermanencia>"
    Y         ingreso el tipo de pago "<tipoPago>"
    Y         busco el equipo "<nombreEquipo>"
    Y         doy click en el boton seleccionar
    Y         selecciono la cartilla Linea Nueva
    Y        doy click en iniciar registro
    Y        ingreso un correo electronico "hola@gmail.com"
    Y        ingreso nuevamente el correo electronico "hola@gmail.com"
    Y        doy click en datos del cliente
    Y        selecciono completar los datos del cliente
      | fechaNac   | estadoCivil | nacionalidad | departamento | provincia | distrito | direccion |
      | 12/12/1980 | soltero     | Albania      | APURIMAC     | ABANCAY   | ABANCAY  | CASA      |
    Y        doy clic para validar contrato Movil
    Y        me muestra en pantalla el contrato solicitado
    Cuando   doy clic en si acepto
    Y        doy clic en continuar
    Y        me muestra pantalla para Descargar contrato
    Y        doy clic para descargar el contrato
    Y        doy clic en Registrar venta
    Entonces visualizo en pantalla el mensaje de exito de la venta generada
    Y        valido que se muestre el detalle del pedido
    Ejemplos:
      | tipoUsuario     | userName     | password     | msgHome    | tiendaAsesor | tipoDocumento | documento  | tipoPlanes                              | nombreEquipo                       | planMovil | tiempoPermanencia | tipoPago   |
      | usuario externo | evillanuevag | #o2Wy23oA1458 | Bienvenid@ | MOQUEGUA     | CE            | 1078980045 | RV Plan Ilimitado Mi Movistar S/65.9 II | IPHONE XS MAX MT532LZ/A 256GB GRIS | Postpago  | sin permanencia   | Al contado |


  @AltaFijaMovilComboProactivo_Caso07
  Esquema del escenario: Alta  movil Combo Proactivo con Nuevo Cliente Extranjero
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
    Y        selecciono el boton Linea Nueva Movil
    Y        selecciono el boton Mostrar ofertas
    Y        selecciono el plan "Postpago" que desea
    Y        doy click en el boton Siguiente
    Y valido que este en la pagina de ofertas sugeridas
    Y         selecciono el boton de eleccion de planes
    Y         selecciono el plan movil "<planMovil>"
    Y         selecciono la opcion "<tipoPlanes>"
    Y         doy click en el boton seleccionar oferta
    Y         selecciono añadir equipos
    Y         ingreso el tiempo de permanencia"<tiempoPermanencia>"
    Y         ingreso el tipo de pago "<tipoPago>"
    Y         busco el equipo "<nombreEquipo>"
    Y         doy click en el boton seleccionar
    Y         selecciono la cartilla Linea Nueva
    Y        doy click en iniciar registro
    Y        ingreso un correo electronico "hola@gmail.com"
    Y        ingreso nuevamente el correo electronico "hola@gmail.com"
    Y        doy click en datos del cliente
    Y        selecciono completar los datos del cliente
      | fechaNac   | estadoCivil | nacionalidad | departamento | provincia | distrito | direccion |
      | 12/12/1980 | soltero     | Albania      | APURIMAC     | ABANCAY   | ABANCAY  | CASA      |
    Y        doy clic para validar contrato Movil
    Y        me muestra en pantalla el contrato solicitado
    Cuando   doy clic en si acepto
    Y        doy clic en continuar
    Y        me muestra pantalla para Descargar contrato
    Y        doy clic para descargar el contrato
    Y        doy clic en Registrar venta
    Entonces visualizo en pantalla el mensaje de exito de la venta generada
    Y        valido que se muestre el detalle del pedido

    Ejemplos:
      | tipoUsuario     | userName     | password     | msgHome    | tiendaAsesor | tipoDocumento | documento  | tipoPlanes                           | nombreEquipo                        | planMovil | tiempoPermanencia | tipoPago   |
      | usuario externo | evillanuevag | #o2Wy23oA1458 | Bienvenid@ | MOQUEGUA     | CE            | 1000000045 | RV Plan Ilimitado Mi Movistar S/99.9 | SAMSUNG GXY S20 PLUS NEGRO SM-G985F | Postpago  | sin permanencia   | Al contado |


  @AltaFijaMovilComboProactivo_Caso08
  Esquema del escenario: Alta  movil Combo Proactivo con Nuevo Cliente Extranjero
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
    Y        selecciono el boton Linea Nueva Movil
    Y        selecciono el boton Mostrar ofertas
    Y        selecciono el plan "Postpago" que desea
    Y        doy click en el boton Siguiente
    Y valido que este en la pagina de ofertas sugeridas
    Y         selecciono el boton de eleccion de planes
    Y         selecciono el plan movil "<planMovil>"
    Y         selecciono la opcion "<tipoPlanes>"
    Y         doy click en el boton seleccionar oferta
    Y         selecciono añadir equipos
    Y         ingreso el tiempo de permanencia"<tiempoPermanencia>"
    Y         ingreso el tipo de pago "<tipoPago>"
    Y         busco el equipo "<nombreEquipo>"
    Y         doy click en el boton seleccionar
    Y         selecciono la cartilla Linea Nueva
    Y        doy click en iniciar registro
    Y        ingreso un correo electronico "hola@gmail.com"
    Y        ingreso nuevamente el correo electronico "hola@gmail.com"
    Y        doy click en datos del cliente
    Y        selecciono completar los datos del cliente
      | fechaNac   | estadoCivil | nacionalidad | departamento | provincia | distrito | direccion |
      | 12/12/1980 | soltero     | Albania      | APURIMAC     | ABANCAY   | ABANCAY  | CASA      |
    Y        doy clic para validar contrato Movil
    Y        me muestra en pantalla el contrato solicitado
    Cuando   doy clic en si acepto
    Y        doy clic en continuar
    Y        me muestra pantalla para Descargar contrato
    Y        doy clic para descargar el contrato
    Y        doy clic en Registrar venta
    Entonces visualizo en pantalla el mensaje de exito de la venta generada
    Y        valido que se muestre el detalle del pedido
    Ejemplos:
      | tipoUsuario     | userName     | password     | msgHome    | tiendaAsesor | tipoDocumento | documento  | tipoPlanes                            | nombreEquipo                          | planMovil | tiempoPermanencia | tipoPago             |
      | usuario externo | evillanuevag | #o2Wy23oA1458 | Bienvenid@ | MOQUEGUA     | CE            | 1000000045 | RV Plan Ilimitado Mi Movistar S/149.9 | SAMSUNG GXY S10 NEGRO SM-G973FZ 128GB | Postpago  | sin permanencia   | Financiado 18 cuotas |


  @AltaFijaMovilComboProactivo_Caso09
  Esquema del escenario: Alta  movil Combo Proactivo con Nuevo Cliente Extranjero
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
    Y        selecciono el boton Linea Nueva Movil
    Y        selecciono el boton Mostrar ofertas
    Y        selecciono el plan "Postpago" que desea
    Y        doy click en el boton Siguiente
    Y valido que este en la pagina de ofertas sugeridas
    Y         selecciono el boton de eleccion de planes
    Y         selecciono el plan movil "<planMovil>"
    Y         selecciono la opcion "<tipoPlanes>"
    Y         doy click en el boton seleccionar oferta
    Y         selecciono añadir equipos
    Y         ingreso el tiempo de permanencia"<tiempoPermanencia>"
    Y         ingreso el tipo de pago "<tipoPago>"
    Y         busco el equipo "<nombreEquipo>"
    Y         doy click en el boton seleccionar
    Y         selecciono la cartilla Linea Nueva
    Y        doy click en iniciar registro
    Y        ingreso un correo electronico "hola@gmail.com"
    Y        ingreso nuevamente el correo electronico "hola@gmail.com"
    Y        doy click en datos del cliente
    Y        selecciono completar los datos del cliente
      | fechaNac   | estadoCivil | nacionalidad | departamento | provincia | distrito | direccion |
      | 12/12/1980 | soltero     | Albania      | APURIMAC     | ABANCAY   | ABANCAY  | CASA      |
    Y        doy clic para validar contrato Movil
    Y        me muestra en pantalla el contrato solicitado
    Cuando   doy clic en si acepto
    Y        doy clic en continuar
    Y        me muestra pantalla para Descargar contrato
    Y        doy clic para descargar el contrato
    Y        doy clic en Registrar venta
    Entonces visualizo en pantalla el mensaje de exito de la venta generada
    Y        valido que se muestre el detalle del pedido
    Ejemplos:
      | tipoUsuario     | userName     | password     | msgHome    | tiendaAsesor | tipoDocumento | documento  | tipoPlanes                            | nombreEquipo                       | planMovil | tiempoPermanencia | tipoPago             |
      | usuario externo | evillanuevag | #o2Wy23oA1458 | Bienvenid@ | MOQUEGUA     | CE            | 1000000045 | RV Plan Ilimitado Mi Movistar S/114.9 | SAMSUNG GXY J2 CORE NEGRO SM-J260M | Postpago  | sin permanencia   | Financiado 12 cuotas |


  @AltaFijaMovilComboProactivo_Caso10
  Esquema del escenario: Alta  movil Combo Proactivo con Nuevo Cliente Extranjero
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
    Y        selecciono el boton Linea Nueva Movil
    Y        selecciono el boton Mostrar ofertas
    Y        selecciono el plan "Postpago" que desea
    Y        doy click en el boton Siguiente
    Y valido que este en la pagina de ofertas sugeridas
    Y         selecciono el boton de eleccion de planes
    Y         selecciono el plan movil "<planMovil>"
    Y         selecciono la opcion "<tipoPlanes>"
    Y         doy click en el boton seleccionar oferta
    Y         selecciono añadir equipos
    Y         ingreso el tiempo de permanencia"<tiempoPermanencia>"
    Y         ingreso el tipo de pago "<tipoPago>"
    Y         busco el equipo "<nombreEquipo>"
    Y         doy click en el boton seleccionar
    Y         selecciono la cartilla Linea Nueva
    Y        doy click en iniciar registro
    Y        ingreso un correo electronico "hola@gmail.com"
    Y        ingreso nuevamente el correo electronico "hola@gmail.com"
    Y        doy click en datos del cliente
    Y        selecciono completar los datos del cliente
      | fechaNac   | estadoCivil | nacionalidad | departamento | provincia | distrito | direccion |
      | 12/12/1980 | soltero     | Albania      | APURIMAC     | ABANCAY   | ABANCAY  | CASA      |
    Y        doy clic para validar contrato Movil
    Y        me muestra en pantalla el contrato solicitado
    Cuando   doy clic en si acepto
    Y        doy clic en continuar
    Y        me muestra pantalla para Descargar contrato
    Y        doy clic para descargar el contrato
    Y        doy clic en Registrar venta
    Entonces visualizo en pantalla el mensaje de exito de la venta generada
    Y        valido que se muestre el detalle del pedido

    Ejemplos:
      | tipoUsuario     | userName     | password     | msgHome    | tiendaAsesor | tipoDocumento | documento  | tipoPlanes                            | nombreEquipo             | planMovil | tiempoPermanencia | tipoPago             |
      | usuario externo | evillanuevag | #o2Wy23oA1458 | Bienvenid@ | MOQUEGUA     | CE            | 1000000045 | RV Plan Ilimitado Mi Movistar S/149.9 | HUAWEI P30 AZUL ELLE-L04 | Postpago  | 12 meses          | Financiado 12 cuotas |


  @AltaFijaMovilComboProactivo_Caso11
  Esquema del escenario: Alta  movil Combo Proactivo con Nuevo Cliente Extranjero
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
    Y        selecciono el boton Linea Nueva Movil
    Y        selecciono el boton Mostrar ofertas
    Y        selecciono el plan "Postpago" que desea
    Y        doy click en el boton Siguiente
    Y valido que este en la pagina de ofertas sugeridas
    Y         selecciono el boton de eleccion de planes
    Y         selecciono el plan movil "<planMovil>"
    Y         selecciono la opcion "<tipoPlanes>"
    Y         doy click en el boton seleccionar oferta
    Y         selecciono añadir equipos
    Y         ingreso el tiempo de permanencia"<tiempoPermanencia>"
    Y         ingreso el tipo de pago "<tipoPago>"
    Y         busco el equipo "<nombreEquipo>"
    Y         doy click en el boton seleccionar
    Y         selecciono la cartilla Linea Nueva
    Y        doy click en iniciar registro
    Y        ingreso un correo electronico "hola@gmail.com"
    Y        ingreso nuevamente el correo electronico "hola@gmail.com"
    Y        doy click en datos del cliente
    Y        selecciono completar los datos del cliente
      | fechaNac   | estadoCivil | nacionalidad | departamento | provincia | distrito | direccion |
      | 12/12/1980 | soltero     | Albania      | APURIMAC     | ABANCAY   | ABANCAY  | CASA      |
    Y        doy clic para validar contrato Movil
    Y        me muestra en pantalla el contrato solicitado
    Cuando   doy clic en si acepto
    Y        doy clic en continuar
    Y        me muestra pantalla para Descargar contrato
    Y        doy clic para descargar el contrato
    Y        doy clic en Registrar venta
    Entonces visualizo en pantalla el mensaje de exito de la venta generada
    Y        valido que se muestre el detalle del pedido
    Ejemplos:
      | tipoUsuario     | userName     | password     | msgHome    | tiendaAsesor | tipoDocumento | documento  | tipoPlanes                            | nombreEquipo             | planMovil | tiempoPermanencia | tipoPago             |
      | usuario externo | evillanuevag | #o2Wy23oA1458 | Bienvenid@ | MOQUEGUA     | CE            | 1000000045 | RV Plan Ilimitado Mi Movistar S/149.9 | HUAWEI Y9S NEGRO STK-LX3 | Postpago  | 12 meses          | Financiado 18 cuotas |


  @AltaFijaMovilComboProactivo_Caso12
  Esquema del escenario: Alta  movil Combo Proactivo con Nuevo Cliente Extranjero
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
    Y        selecciono el boton Linea Nueva Movil
    Y        selecciono el boton Mostrar ofertas
    Y        selecciono el plan "Postpago" que desea
    Y        doy click en el boton Siguiente
    Y valido que este en la pagina de ofertas sugeridas
    Y         selecciono el boton de eleccion de planes
    Y         selecciono el plan movil "<planMovil>"
    Y         selecciono la opcion "<tipoPlanes>"
    Y         doy click en el boton seleccionar oferta
    Y         selecciono añadir equipos
    Y         ingreso el tiempo de permanencia"<tiempoPermanencia>"
    Y         ingreso el tipo de pago "<tipoPago>"
    Y         busco el equipo "<nombreEquipo>"
    Y         doy click en el boton seleccionar
    Y         selecciono la cartilla Linea Nueva
    Y        doy click en iniciar registro
    Y        ingreso un correo electronico "hola@gmail.com"
    Y        ingreso nuevamente el correo electronico "hola@gmail.com"
    Y        doy click en datos del cliente
    Y        selecciono completar los datos del cliente
      | fechaNac   | estadoCivil | nacionalidad | departamento | provincia | distrito | direccion |
      | 12/12/1980 | soltero     | Albania      | APURIMAC     | ABANCAY   | ABANCAY  | CASA      |
    Y        doy clic para validar contrato Movil
    Y        me muestra en pantalla el contrato solicitado
    Cuando   doy clic en si acepto
    Y        doy clic en continuar
    Y        me muestra pantalla para Descargar contrato
    Y        doy clic para descargar el contrato
    Y        doy clic en Registrar venta
    Entonces visualizo en pantalla el mensaje de exito de la venta generada
    Y        valido que se muestre el detalle del pedido
    Ejemplos:
      | tipoUsuario     | userName     | password     | msgHome    | tiendaAsesor | tipoDocumento | documento  | tipoPlanes                            | nombreEquipo              | planMovil | tiempoPermanencia | tipoPago             |
      | usuario externo | evillanuevag | #o2Wy23oA1458 | Bienvenid@ | MOQUEGUA     | CE            | 1000000045 | RV Plan Ilimitado Mi Movistar S/149.9 | APPLE IPHONE 6S 16GB GRIS | Postpago  | 12 meses          | Financiado 18 cuotas |


  @AltaFijaMovilComboProactivo_Caso13
  Esquema del escenario: Alta  movil Combo Proactivo con Nuevo Cliente Extranjero
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
    Y        selecciono el boton Linea Nueva Movil
    Y        selecciono el boton Mostrar ofertas
    Y        selecciono el plan "Postpago" que desea
    Y        doy click en el boton Siguiente
    Y valido que este en la pagina de ofertas sugeridas
    Y         selecciono el boton de eleccion de planes
    Y         selecciono el plan movil "<planMovil>"
    Y         selecciono la opcion "<tipoPlanes>"
    Y         doy click en el boton seleccionar oferta
    Y         selecciono añadir equipos
    Y         ingreso el tiempo de permanencia"<tiempoPermanencia>"
    Y         ingreso el tipo de pago "<tipoPago>"
    Y         busco el equipo "<nombreEquipo>"
    Y         doy click en el boton seleccionar
    Y         selecciono la cartilla Linea Nueva
    Y        doy click en iniciar registro
    Y        ingreso un correo electronico "hola@gmail.com"
    Y        ingreso nuevamente el correo electronico "hola@gmail.com"
    Y        doy click en datos del cliente
    Y        selecciono completar los datos del cliente
      | fechaNac   | estadoCivil | nacionalidad | departamento | provincia | distrito | direccion |
      | 12/12/1980 | soltero     | Albania      | APURIMAC     | ABANCAY   | ABANCAY  | CASA      |
    Y        doy clic para validar contrato Movil
    Y        me muestra en pantalla el contrato solicitado
    Cuando   doy clic en si acepto
    Y        doy clic en continuar
    Y        me muestra pantalla para Descargar contrato
    Y        doy clic para descargar el contrato
    Y        doy clic en Registrar venta
    Entonces visualizo en pantalla el mensaje de exito de la venta generada
    Y        valido que se muestre el detalle del pedido
    Ejemplos:
      | tipoUsuario     | userName     | password     | msgHome    | tiendaAsesor | tipoDocumento | documento  | tipoPlanes                           | nombreEquipo                  | planMovil | tiempoPermanencia | tipoPago   |
      | usuario externo | evillanuevag | #o2Wy23oA1458 | Bienvenid@ | MOQUEGUA     | CE            | 1000000045 | RV Plan Ilimitado Mi Movistar S/85.9 | HUAWEI P30 LITE NEGRO MAR-LX3 | Postpago  | sin permanencia   | Al contado |