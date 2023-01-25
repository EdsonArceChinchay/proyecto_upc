#language:es
@BERSERKERS @DoneDevOps @DoneDevOpsPI14

Característica: Alta Movil Postpago Canal Tienda


  Antecedentes:
	Dado     que abro la pagina de movistar

  @AltaMovilPostpagoCanalTienda
  Esquema del escenario: Alta Movil Postpago
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
	  | nombres        | apellidos      | genero    |
	  | Estela Rosario | Lopez Manrique | femenino  |
#    Y        cierro popup de aviso
	Y        valido que muestre el nombre completo del cliente "Estela Rosario Lopez Manrique"
	Y        selecciono el boton Linea Nueva Movil
	Y        selecciono el boton Mostrar ofertas
	Y        selecciono el plan "Postpago" que desea
	Y        doy click en el boton Siguiente
	Y        valido que este en la pagina de ofertas sugeridas
	Y        selecciono tipo de oferta
	Y        selecciono el tipo de plan movil "<tipoPlanMovil>"
	Y        selecciono la opcion "<tipoPlanes>"
	Y        doy click en el boton seleccionar oferta
	Y        selecciono la cartilla Linea Nueva
	Y        doy click en iniciar registro
	Y        valido que este en la seccion completa los datos solicitados
	Y        ingreso un correo electronico "estelalopez@mail.com"
	Y        ingreso nuevamente el correo electronico "estelalopez@mail.com"
	Y        doy click en datos del cliente
	Y        selecciono completar los datos del cliente
	  | fechaNac   | estadoCivil | nacionalidad | departamento | provincia | distrito      | direccion         |
	  | 26/07/1985 | soltero     | Alemania     | LIMA         | LIMA      | SAN MIGUEL    | CALLE SAN MARTIN  |
	Y        doy click en el boton confirmar
	Y        doy clic para validar contrato hogar
	Y        me muestra en pantalla el contrato solicitado
	Cuando   doy clic en si acepto
	Y        doy click en el boton de continuar
	Y        doy clic en Registrar venta
	Y        cierro popup de error
	Entonces visualizo en pantalla el mensaje de exito de la venta generada
	Ejemplos:
	  | tipoUsuario     | userName    | password       | msgHome    | tiendaAsesor      | tipoDocumento | documento   | tipoPlanMovil | tipoPlanes                           |
	  | usuario externo | lterrazosce | Telefonica2021 | Bienvenid@ | TIENDA SAN MIGUEL | CE            | 1000000112  | Postpago      | Plan Ilimitado Mi Movistar S/99.9 IV |