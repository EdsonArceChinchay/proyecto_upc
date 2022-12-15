#language:es

Característica: Portabilidad Solo Chip Call Center Delivery en Tambo
  Quiero realizar una portabilidad por call center

  Antecedentes:
    Dado     que abro la pagina de movistar

  @PortabilidadSoloChip
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
      | Telefono  | Fecha_Sig  | Fecha_FinMes |
      | 920956355 | 2022-12-16 | 2022-12-31   |
    Y doy tiempo extra



    Ejemplos:
      | tipoUsuario     | userName | password     | msgHome    | tiendaAsesor                 | tipoDocumento | documento | numero    |
      | usuario externo | jpachaot | $t3l3f0n1c4$ | Bienvenid@ | CANAL ONLINE-CALL CENTER GSS | DNI           | 75102009  | 920956355 |

