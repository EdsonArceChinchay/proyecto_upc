#language:es

##CREADOR: Edson Arce
##APP: DITO
##MODULO:
##FUNCIONALIDAD: CAMBIO
##ESTADO: ACTIVO
##CODIGO: AT-DT105
##GDAP: GDAP-893
##SPRINT CREADO:
##FRECUENCIA: DIARIO
##TAG : BERSERKERS
##DATA: UNICA VEZ
##ENCARGADO: VICTOR CARPIO
##FECMOD: 23/12/2023

@BERSERKERS @DoneDevOps
Característica: AT-DT105_Portabilidad Call Center validar opción de tienda

  Antecedentes:
    Dado     que abro la pagina de movistar

  @PortabilidadSoloChip @MVP16 @Global
  Esquema del escenario: Portabilidad solo chip postpago
    Cuando   presiono el boton Iniciar Sesion
    Y        selecciono el tipo de usuario "<tipoUsuario>"
    Y        ingreso el usuario "<userName>"
    Y        ingreso el password "<password>"
    Y        ingreso el captcha
    Y        presiono el boton Continuar hacia el home
    Entonces valido el login exitoso mediante el mensaje "<msgHome>"
    Y        valido que se presente la tienda "<tiendaAsesor>"
    Cuando   selecciono el tipo de documento "<tipoDocumento>"
    Y        ingreso el documento "<documento>"
    Y        doy click en el boton consultar
    Y        cierro el popup de contraseña Única
    Y        doy click en el boton portabilidad
    Y        presiono el boton Mostrar ofertas
    Y        ingreso numero de telefono para portar "<numero>"
    Y        escojo tipo de linea "Prepago"
    Y        escojo tipo de operador "BITEL"
    Y        doy click en el boton Consultar Portabilidad
    #Y        valido los servicios
    #  | telefono  | Fecha_Sig  | Fecha_FinMes |
    #  | 920956347 | 2023-01-24 | 2023-01-31   |
    Y        doy tiempo extra
    Y        selecciono el plan "Postpago" que desea
    Y        doy click en el boton Siguiente
    Y        valido que este en la pagina de ofertas sugeridas
    Y        selecciono tipo de oferta
    Y        selecciono el tipo de plan movil "<tipoPlanMovil>"
    Y        selecciono un plan movil "<nombrePlan>"
    Y        doy click en iniciar registro
    Y        selecciono el departamento donde sera la instalacion "15"
    Y        selecciono la provincia donde sera la instalacion "1501"
    Y        selecciono el distrito donde sera la instalacion "150116"
    Y        ingreso la direccion donde sera la instalacion "JIRON JULIO CESAR TELLO 469"
    Y        ingreso la referencia de la direccion "INKAFARMA"
    Y        presiono Consultar ubicacion
    Y        ingreso la informacion del lugar de instalacion
      | mz  | vivienda | nombreVivienda  | piso | int | conjunto             | conjHabit  |
      | A  | EDIFICIO | Familia Barreto | 1    | 1   | URBANIZACION POPULAR | conjunto b |
    Y        presiono el boton consultar cobertura
    Y        selecciono un tipo de entrega "Delivery Regular 48 horas"
    Y        selecciono el horario de entrega "3pm-7pm"
    Y        ingreso el telefono de contacto "658745259"
    Y        ingreso las instrucciones a considerar de la entrega "En la cuadra 8 a la derecha"
    Y        doy clic en confirmar delivery
    Y        valido que este en la seccion completa los datos solicitados
    Y        selecciono el metodo de pago "Contra entrega"
    Y        ingreso un correo electronico "jlopez@mail.com"
    Y        ingreso nuevamente el correo electronico "jlopez@mail.com"
    Y        doy click en validar identidad del titular
    Y        ingreso los datos solicitados para la validacion del cliente
      | nombrePadre   | nombreMadre   | distritoNac   |
      | <nombrePadre> | <nombreMadre> | <distritoNac> |
    #Entonces valido que me muestre el boton con el texto de identidad validada
    Y        doy clic para validar contrato hogar
    Y        me muestra en pantalla el contrato solicitado
    Cuando   doy clic en si acepto
    Y        doy click en Finalizar registro
    Entonces visualizo en pantalla el mensaje de exito de la venta generada
    Y        valido que se muestre el detalle del pedido
    Dado     regreso a la pagina de inicio
    Entonces valido el login exitoso mediante el mensaje "Bienvenid@"
    Y        me dirijo a la bandeja de Back Office
    Y         busco por el documento
    Y        selecciono la solicitud
    Y        cargo el audio en la web
    Y        apruebo la solicitud
    Ejemplos:
      | tipoUsuario     | userName | password     | msgHome    | tiendaAsesor              | tipoDocumento | documento | numero    | tipoPlanMovil | nombrePlan                        | nombreMadre | nombrePadre | distritoNac |
      #| usuario externo | jpachaot | $t3l3f0n1c4$ | Bienvenid@ | PRUEBAS SIST CALLIN VENTA | DNI           | 75102009  | 920956347 | Postpago      | Plan Ilimitado Mi Movistar S/69.9 |
      | usuario interno |   |   | Bienvenid@ | ntt data qan call in venta cc | DNI           | 45770292  | 918416062 | Postpago      | RV Plan Ilimitado Mi Movistar S/ 69.9 V | SABINA        | AVELINO      | ANCO HUALLO    |

