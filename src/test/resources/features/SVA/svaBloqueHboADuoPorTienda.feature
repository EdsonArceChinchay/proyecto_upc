#language:es
@BERSERKERS @DoneDevOps @svaBloqueHboDuoPorTienda @AT-DT108

Característica: sva bloque hbo a duo por Tienda
  Yo como asesor de Tienda
  Quiero agregar un bloque hbo a un cliente con parque duo a un usuario con CE

  Antecedentes:
    Dado     que abro la pagina de movistar

  @svaBloqueHboDuoPorTienda
  Esquema del escenario: Alta de un bloque hbo a un cliente con parque duo a un usuario con CE y productos asociados sin biometria
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
      | tipoUsuario     | userName    | password       | msgHome    | tiendaAsesor | tipoDocumento | documento  | departamento | provincia | distrito | direccion                   | referencia | tipoOferta     | nombrePlan                                     | sva | correo           |
      | usuario externo | evillanuevag | $t3l3f0n1c4$ | Bienvenid@ | CAJAMARCA    | CE            | 1042465027 | 15           | 1501      | 150116   | JIRON JULIO CESAR TELLO 460 | PISO 1     | MOVISTAR TOTAL | TRÍO MOV. VOZ INTERNET ESTANDAR HD RA D22 50 MBPS | HBO  | prueba@prueba.com |


