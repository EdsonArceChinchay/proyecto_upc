#language:es
@BERSERKERS @DoneDevOps @DoneDevOpsPI14

Característica: Realizar una Alta movil Postpago (linea + equipo) con Delivery en Tambo
  sin cobertura por canal Call Center

  Antecedentes:
    Dado     que abro la pagina de movistar


     # Realizar una Alta movil Postpago (linea + equipo) con
     #Delivery en Tambo sin cobertura por canal Call Center

  @AltaMovilPostPagoDeliveryCallCenter_Carlos01_HAPPYPATH
  Esquema del escenario: Alta fija mas alta movil por Call Center con DNI sin productos asociados sin biometria
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
    Y         selecciono el boton de eleccion de planes
    Y         selecciono el plan movil "<planMovil>"
    Y         selecciono la opcion "<tipoPlanes>"
    Y         doy click en el boton seleccionar oferta
    Y         selecciono añadir equipos
    Y         ingreso el tiempo de permanencia"<timpoPermanencia>"
    Y         busco el equipo "<nombreEquipo>"
    Y         doy click en el boton seleccionar
    Y         selecciono la cartilla Linea Nueva
    Y        doy click en iniciar registro
    Entonces    me muestra la pantalla de Delivery de linea nueva
    Y     selecciono el departamento donde sera la instalacion "<departamento>"
    Y        selecciono la provincia donde sera la instalacion "<provincia>"
    Y        selecciono el distrito donde sera la instalacion "<distrito>"
    Y        ingreso la direccion donde sera la instalacion "<direccion>"
    Y        ingreso la referencia de la direccion "<referencia>"
    Y        presiono el boton Consultar ubicacion
    Y        ingreso la informacion del lugar de instalacion
      | mz | lote | vivienda      | nombreVivienda | piso | int | conjunto             | conjHabit |
      | A  | 1    | alex mancilla | alex mancilla  | 1    | 1   | URBANIZACION POPULAR | casa      |
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
      | tipoUsuario     | userName | password     | msgHome    | tiendaAsesor                 | tipoDocumento | documento  | departamento | provincia | distrito | direccion                     | referencia | tipoOferta     | tipoPlan           | correo           | tipoValidacion | nombreMadre | nombrePadre | distritoNac | tipoPlanes                           | planMovil | timpoPermanencia | nombreEquipo                       |
      | usuario externo | jpachaot | $t3l3f0n1c4$ | Bienvenid@ | CANAL ONLINE-CALL CENTER GSS | CE            | 1000000045 | 15           | 1501      | 150136   | Calle Condesa de Chinchon 107 | Casa       | MOVISTAR TOTAL | HD 70 Mbps + 26 Gb | correo@gmail.com | discapacitado  | ELIZABETH   | JORGE       | LIMA        | RV Plan Ilimitado Mi Movistar S/99.9 | Postpago  | Sin permanencia  | IPHONE XS MAX MT532LZ/A 256GB GRIS |

