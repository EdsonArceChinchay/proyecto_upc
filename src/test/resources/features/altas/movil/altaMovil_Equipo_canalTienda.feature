#language:es
##CREADOR:
##APP: DITO
##MODULO:
##FUNCIONALIDAD:
##ESTADO:
##CODIGO: AT-DT030
##GDAP: GDAP-585
##SPRINT CREADO:
##FRECUENCIA:
##TAG : BERSERKERS
##DATA:
##ENCARGADO:
##FECMOD: 30/03/2023

@BERSERKERS @DoneDevOps @DoneDevOpsPI11 @DROP-G03

Característica: AT-DT030_AltaMovil + equipo

  Antecedentes:
    Dado     que abro la pagina de movistar

  @AltaMovil_Equipo_tienda @Sanity28
  Esquema del escenario: Alta Movil con Equipo con canal Tienda con documento CE
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
      | nombres | apellidos   | genero   |
      | Ana     | Lopez Lopez | femenino |
    Y        selecciono el boton Linea Nueva Movil
    Y cierro el popup de validación de estado de contraseña única
    Y        selecciono el boton Mostrar ofertas
    Y        selecciono el plan_movil Prepago
    Y        selecciono el boton de eleccion de planes
    Y        selecciono la opcion "<tipoPlanes>"
    Y        doy click en el boton seleccionar oferta
    Y        selecciono añadir equipos
    Y        ingreso el tiempo de permanencia"<timpoPermanencia>"
    Y        ingreso el tipo de pago "<tipoPago>"
    Y        busco el equipo "<nombreEquipo>"
    Y        doy click en el boton seleccionar
    Y        selecciono la cartilla Linea Nueva
    Y        doy click en iniciar registro
    Y        ingreso un correo electronico "hola@gmail.com"
    Y        ingreso nuevamente el correo electronico "hola@gmail.com"
    Y        doy click en datos del cliente
    Y        selecciono completar los datos del cliente
      | fechaNac   | estadoCivil | nacionalidad | departamento | provincia | distrito | direccion |
      | 12/12/1980 | soltero     | Albania      | APURIMAC     | ABANCAY   | ABANCAY  | CASA      |
    Entonces doy clic para validar contrato Movil
    Y        me muestra en pantalla el contrato solicitado
    Cuando   doy clic en si acepto
    Y        doy click en el boton de continuar
    Y        presiono en el boton de Registrar Venta
    Entonces visualizo en pantalla el mensaje de exito de la venta generada
    #Y        valido que se muestre el detalle del pedido
    Ejemplos:

      | tipoUsuario     | userName     | password     | msgHome    | tipoDocumento | documento  | departamento | provincia | distrito | direccion                     | referencia | tipoOferta     | tipoPlanes | timpoPermanencia | nombreEquipo                  | tipoPago             |
      | usuario externo | evillanuevag | $Telefonica2099% | Bienvenid@ | CE            | 1012454446 | 15           | 1501      | 150116   | Avenida Julio Cesar Tello 460 | Inkafarma  | MOVISTAR TOTAL | Prepago    | Sin permanencia  | XIAOMI REDMI NOTE 9 PRO VERDE | Financiado 12 cuotas |

  @AltaMovil_Equipo_tienda_2 @Sanity28
  Esquema del escenario: Alta Movil con Equipo con canal Tienda con documento CE
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
    Y        cierro popup de error
    Y        ingreso los datos del cliente a registrar
      | nombres | apellidos   | genero   |
      | Ana     | Lopez Lopez | femenino |
    Y        selecciono el boton Linea Nueva Movil
    Y cierro el popup de validación de estado de contraseña única
    Y        selecciono el boton Mostrar ofertas
    Y        selecciono el plan_movil Prepago
    Y        selecciono el boton de eleccion de planes
    Y        selecciono la opcion "<tipoPlanes>"
    Y        doy click en el boton seleccionar oferta
    Y        selecciono añadir equipos
    Y        ingreso el tiempo de permanencia"<timpoPermanencia>"
    Y        ingreso el tipo de pago "<tipoPago>"
    Y        busco el equipo "<nombreEquipo>"
    Y        doy click en el boton seleccionar
    Y        selecciono la cartilla Linea Nueva
    Y        doy click en iniciar registro
    Y        ingreso un correo electronico "hola@gmail.com"
    Y        ingreso nuevamente el correo electronico "hola@gmail.com"
    Y        doy click en datos del cliente
    Y        selecciono completar los datos del cliente
      | fechaNac   | estadoCivil | nacionalidad | departamento | provincia | distrito | direccion |
      | 12/12/1980 | soltero     | Albania      | APURIMAC     | ABANCAY   | ABANCAY  | CASA      |
    Entonces doy clic para validar contrato Movil
    Y        me muestra en pantalla el contrato solicitado
    Cuando   doy clic en si acepto
    Y        doy click en el boton de continuar
    Y        presiono en el boton de Registrar Venta
    Entonces visualizo en pantalla el mensaje de exito de la venta generada
    #Y        valido que se muestre el detalle del pedido
    Ejemplos:

      | tipoUsuario     | userName    | password       | msgHome    | tiendaAsesor      | tipoDocumento | documento   | departamento | provincia | distrito | direccion                     | referencia | tipoOferta     | tipoPlanes | timpoPermanencia | nombreEquipo | tipoPago             |
      | usuario externo | lterrazosce | Telefonica2021 | Bienvenid@ | TIENDA SAN MIGUEL | CE            | 10342164046 | 15           | 1501      | 150116   | Avenida Julio Cesar Tello 460 | Inkafarma  | MOVISTAR TOTAL | Prepago    | 12 meses         | HUAWEI P30   | Financiado 12 cuotas |