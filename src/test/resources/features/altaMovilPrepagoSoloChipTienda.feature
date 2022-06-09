#language:es
@BERSERKERS @DoneDevOps @DoneDevOpsPI11

Característica: Alta Movil Prepago solo chip Tienda


  Antecedentes:
    Dado     que abro la pagina de movistar

  @AltaMovilPrepagoSoloChipTienda_CE
  Esquema del escenario: Alta pura MT por call center con nuevo cliente con documento CE
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
    Y        selecciono el boton Mostrar ofertas
    Y        selecciono la oferta de plan movil "<oferta>"
    Y        selecciono plan prepago "<nombrePlan>"
    E        inicio registro
    Y        ingreso un correo electronico "hola@gmail.com"
    Y        ingreso nuevamente el correo electronico "hola@gmail.com"
    Y        doy click en datos del cliente
    Y        completo datos del cliente
      | fechaNac   | nacionalidad | estado_civil | departamento | provincia | distrito   | direccion                     |
      | 12/12/1980 | Alemania     | Casado       | LIMA         | LIMA      | SAN MIGUEL | Calle Condesa de Chinchon 107 |
    Y        doy clic para validar contrato Movil
    Y        me muestra en pantalla el contrato solicitado
    Cuando   doy clic en si acepto
    Y        presiono continuar
    Y        presiono el boton descargar contrato
    Y        presiono el boton Registrar venta
    Entonces visualizo en pantalla el mensaje de exito de la venta generada

    Ejemplos:
      | tipoUsuario     | userName    | password       | msgHome    | tiendaAsesor      | tipoDocumento | documento  | oferta       | nombrePlan         |
      | usuario externo | lterrazosce | Telefonica2021 | Bienvenid@ | TIENDA SAN MIGUEL | CE            | 1000000006 | PLAN CONTROL | Preplan            |
      | usuario externo | lterrazosce | Telefonica2021 | Bienvenid@ | TIENDA SAN MIGUEL | CE            | 1000000006 | PLAN CONTROL | Prepago con Tarifa |
