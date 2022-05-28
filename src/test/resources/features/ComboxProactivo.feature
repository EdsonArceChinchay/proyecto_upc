#language:es
@BERSERKERS @DoneDevOps @DoneDevOpsPI15

Característica: Alta Fija + Alta Movil por Retail

  Antecedentes:
    Dado     que abro la pagina de movistar


  @AltaFijaMovilRetail_CE_Nuevo_Carlos02
  Esquema del escenario: Alta fija mas alta movil Retail con Nuevo Cliente Extranjero
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
    Y         selecciono el boton de eleccion de planes
    Y         selecciono el plan movil "<planMovil>"
    Y         selecciono la opcion "<tipoPlanes>"
    Y         doy click en el boton seleccionar oferta
    Y         selecciono añadir equipos
    Y         ingreso el tiempo de permanencia"<timpoPermanencia>"
    Y         busco el equipo "<nombreEquipo>"
    Y         selecciono la cartilla Linea Nueva
    Y        doy clic a iniciar registro
    Y        completo los datos solicitados "<correo>"
    Y        doy click en datos del cliente
    Y        completo los datos del cliente
      | fechaNac   | estadoCivil |
      | 12/12/1980 | soltero     |
    Y        doy clic para validar contrato Movil
    Y        me muestra en pantalla el contrato solicitado
    Cuando   doy clic en si acepto
    Y        doy clic en continuar
    Y        me muestra pantalla para Descargar contrato
    Y        doy clic para descargar el contrato
    Y        doy clic en Registrar venta
    Entonces visualizo en pantalla el mensaje de exito de la venta generada

    Ejemplos:
      | tipoUsuario     | userName | password     | msgHome    | tiendaAsesor | tipoDocumento | documento  | departamento | provincia | distrito | direccion                     | referencia | tipoOferta     | tipoPlanes                            | correo           | nombreEquipo                       | planMovil | timpoPermanencia |
      | usuario externo | vsiguass | $t3l3f0n1c4$ | Bienvenid@ | MOQUEGUA     | CE            | 1000000045 | 15           | 1501      | 150136   | Calle Condesa de Chinchon 107 | Casa       | MOVISTAR TOTAL | RV Plan Ilimitado Mi Movistar S/149.9 | correo@gmail.com | IPHONE XS MAX MT532LZ/A 256GB GRIS | Postpago  | 12 Meses          |


  @AltaComboProactivo_CarlosOriginal
  Esquema del escenario: Alta Combo por Proactivo con Carnet de Extranjeria
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
    Entonces ingreso los datos del cliente a registrar
      | nombres | apellidos   | genero   |
      | Ana     | Lopez Lopez | femenino |
#
#    Y        doy click en el boton Crear Cliente
#    Y        le doy click el boton Linea Nueva Movil
#    Y        le doy click el boton Mostrar ofertas
#    Entonces me muestra la pantalla de ofertas sugeridos
#    Y        le doy click en el boton Reversa de Cartilla
#    Y        le doy click en el boton Postpago
#    Y        le doy click en la cartilla de un combo Postpago
#    Y        le doy click en el boton Seleccionar Oferta
#    Y        le doy click en el boton Linea Nueva
#    Entonces valido el detalle de la seleccion
#    Y        le doy click en el boton Iniciar Registro
#    Y        ingreso correo electronico "<correo>"
#    Y        ingreso nuevamente el correo electronico "<correo>"
#   # Y        selecciono la opcion de Compartir datos personales
#   # Y        selecciono la opcion de Filtrar paginas con contenido adulto
#    Y        le doy click al boton Datos del Cliente
#    Entonces valido que aparezca el formulario para completar los datos
#    Y        ingreso los datos solicitados del cliente
#      | fecha      | nacionalidad |estadocivil |departamento|provincia  | distrito | direccion              |
#      | 24/05/2022 | Venezuela    |Soltero     |Lima        |Lima       | Lima     |  Av. Pedro de Osma 301 |
#    Y        le doy click boton Confirmar
#    Entonces valido que me muestre el boton con el check de identidad validada
#    Y        doy clic para validar contrato Movil
#    Y        me muestra en pantalla el contrato solicitado
#    Cuando   doy clic en si acepto
#    Y        doy clic en el boton Continuar
#    Entonces visualizo en pantalla el mensaje de Estas a un paso de registrar el servicio movil
#    Y        le doy click en el boton Descargar Contrato
#    Y        le doy click en el boton Descargar
#    Y        valido que se abra una nueva página con el contrato
#    Y cierro esta pagina y le doy click en Cerrar la ventana de Contratos
#    Entonces valido que me muestre el boton con el check de Descargar Contrato
#    Y        le doy click en el boton Registrar Venta
#    Entonces visualizo en pantalla el mensaje de exito
    Ejemplos:
      | tipoUsuario     | userName | password     | msgHome    | tiendaAsesor | tipoDocumento | documento  | departamento | provincia | distrito | direccion                     | referencia | tipoOferta     | tipoPlan            | correo           |
      | usuario externo | vsiguass | $t3l3f0n1c4$ | Bienvenid@ | MOQUEGUA     | CE            | 1000000006 | 15           | 1501      | 150136   | Calle Condesa de Chinchon 107 | Casa       | MOVISTAR TOTAL | HD 100 Mbps + 26 Gb | correo@gmail.com |

