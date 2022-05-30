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

    Ejemplos:
      | tipoUsuario     | userName    | password       | msgHome    | tiendaAsesor      | tipoDocumento | documento  | departamento | provincia | distrito | direccion                     | referencia | oferta       | nombrePlan | correo           |
      | usuario externo | lterrazosce | Telefonica2021 | Bienvenid@ | TIENDA SAN MIGUEL | CE            | 1000000003 | 15           | 1501      | 150136   | Calle Condesa de Chinchon 107 | Casa       | PLAN CONTROL | Preplan    | correo@gmail.com |
