#language:es
@BERSERKERS @DoneDevOps @DoneDevOpsPI11

Característica: Alta Trio MT - Upfront Tienda

   @AltaTriomt
  Esquema del escenario: Alta trio Mt
    Dado     que abro la pagina de movistar
    Cuando   presiono el boton Iniciar Sesion
    Y        selecciono el tipo de usuario "<tipoUsuario>"
    Y        ingreso el usuario "<userName>"
    Y        ingreso el password "<password>"
    Y        presiono el boton Continuar hacia el home
    Entonces valido el login exitoso mediante el mensaje "<msgHome>"
    Y        valido que se presente la tienda "<tiendaAsesor>"
    Y        selecciono el tipo de documento "<tipoDocumento>"
    Y        ingreso el documento "<documento>"
    Y        doy click en el boton consultar
    Ejemplos:
      |tipoUsuario    |userName    |password      |msgHome   |tiendaAsesor      |tipoDocumento |documento |
      |usuario externo|lterrazosce |Telefonica2021|Bienvenid@|TIENDA SAN MIGUEL |DNI           |74414338  |