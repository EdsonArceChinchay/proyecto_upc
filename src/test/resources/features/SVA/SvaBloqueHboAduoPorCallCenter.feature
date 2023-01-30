#language:es
@BERSERKERS @DoneDevOps @svaBloqueHboDuoPorCallCenter

Característica: Sva bloque HBO a duo por Call Center
  Quiero agregar un bloque hbo a un cliente con parque duo a un usuario con CE

  Antecedentes:
    Dado     que abro la pagina de movistar

  @svaBloqueHboDuoPorCallCenter
  Esquema del escenario: Alta de un bloque hbo a un cliente con parque duo a un usuario con CE
    Cuando   presiono el boton Iniciar Sesion
    Y        selecciono el tipo de usuario "<tipoUsuario>"
    Y        ingreso el usuario "<userName>"
    Y        ingreso el password "<password>"
    Y        presiono el boton Continuar hacia el home
    Entonces valido el login exitoso mediante el mensaje "<msgHome>"
    Cuando   selecciono el tipo de documento "<tipoDocumento>"
    Y        ingreso el documento "<documento>"
    Y        doy click en el boton consultar
    Y        cierro popup de error
    Cuando   doy click en ver detalle
    Y        doy click en el boton Agregar sva fija
    Y         seleccionamos agregar Bloque HBO
    Cuando   doy clic a iniciar registro
    Y        ingreso un correo electronico "<correo>"
    Y        ingreso nuevamente el correo electronico "<correo>"
    Y        doy clic para validar contrato hogar
    Y        me muestra en pantalla el contrato solicitado
    Cuando   doy clic en si acepto
    Y        doy clic en continuar
    Y        presiono el boton Registrar venta
    Entonces visualizo en pantalla el mensaje de exito de la venta generada

    Ejemplos:
      | tipoUsuario     | userName    | password       | msgHome    | tiendaAsesor                | tipoDocumento | documento  | departamento | provincia | distrito | direccion                   | referencia | tipoOferta     | nombrePlan                                     | sva | correo           |
      | usuario externo | jpachaot | $t3l3f0n1c4$ | Bienvenid@ |  CANAL ONLINE-CALL CENTER GSS    | CE            | 142536409 | 15           | 1501      | 150116   | JIRON JULIO CESAR TELLO 460 | PISO 1     | MOVISTAR TOTAL | TRÍO MOV. VOZ INTERNET ESTANDAR HD RA D22 50 MBPS | HBO  | prueba@prueba.com |
