#language:es
<<<<<<< HEAD

  # CREADOR: Edson Arce

Característica: Portabilidad Solo Chip Call Center Delivery en Tambo (Negativo)
=======
@BERSERKERS @DoneDevOps @AT-DT105
Característica: Portabilidad Solo Chip Call Center Delivery en Tambo
  Quiero realizar una portabilidad por call center
>>>>>>> 555beea0be65bc959f8b0e12d82448473ba083d9

  Antecedentes:
    Dado     que abro la pagina de movistar

  @PortabilidadSoloChip @MVP16 @Global
  Esquema del escenario: Portabilidad solo chip postpago y permanencia 12 meses con DNI, en canal call center y delivery Tambo con direccion de Lima sin cobertura, validar que solo figure la opcion de tienda,web front end. (NEGATIVO)
    Cuando   presiono el boton Iniciar Sesion
    Y        selecciono el tipo de usuario "<tipoUsuario>"
    Y        ingreso el usuario "<userName>"
    Y        ingreso el password "<password>"
    Y        presiono el boton Continuar hacia el home
    Entonces valido el login exitoso mediante el mensaje "<msgHome>"
  # Y        valido que se presente la tienda "<tiendaAsesor>"
    Cuando   selecciono el tipo de documento "<tipoDocumento>"
    Y        ingreso el documento "<documento>"
    Y        doy click en el boton consultar
    Y        doy click en el boton portabilidad
    Y        presiono el boton Mostrar ofertas
    Y        ingreso numero de telefono para portar "<numero>"
    Y        escojo tipo de linea "Postpago"
    Y        escojo tipo de operador "OPERADOR DE PRUEBA"
    Y        doy click en el boton Consultar Portabilidad
    Y        valido los servicios
      | telefono  | Fecha_Sig  | Fecha_FinMes |
      | 920956347 | 2022-12-24 | 2022-12-31   |
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
    Y        ingreso la direccion donde sera la instalacion "Jiron Julio Cesar Tello 460"
    Y        ingreso la referencia de la direccion "INKAFARMA"
    Y        presiono Consultar ubicacion
    Y        ingreso la informacion del lugar de instalacion
      | mz | lote | vivienda | nombreVivienda  | piso | int | conjunto             | conjHabit  |
      | A  | 1    | EDIFICIO | Familia Barreto | 1    | 1   | URBANIZACION POPULAR | conjunto b |
    Y        presiono el boton consultar cobertura
    Y        selecciono un tipo de entrega "Delivery Regular 48 horas"
    Y        selecciono el horario de entrega "2pm-7pm"
    Y        ingreso el telefono de contacto "658745259"
    Y        ingreso las instrucciones a considerar de la entrega "En la cuadra 8 a la derecha"
    Ejemplos:
      | tipoUsuario     | userName | password     | msgHome    | tiendaAsesor                 | tipoDocumento | documento  |numero |tipoPlanMovil|nombrePlan|
      | usuario externo | jpachaot | $t3l3f0n1c4$ | Bienvenid@ | CANAL ONLINE-CALL CENTER GSS | DNI            | 75102009 |920956347| Postpago      | Plan Ilimitado Mi Movistar S/69.9 |

