#language:es
##CREADOR:
##APP: DITO
##MODULO:
##FUNCIONALIDAD:
##ESTADO: ACTIVO
##CODIGO: AT-DT025
##GDAP: GDAP-1007
##SPRINT CREADO:
##FRECUENCIA:
##TAG : BERSERKERS
##DATA: REUSABLE
##ENCARGADO:
##FECMOD: 09/04/2024

@BERSERKERS @DoneDevOps @DoneDevOpsPI14 @AltaMovil
Característica: AT-DT025_Alta Movil Postpago con documento CE por Canal Tienda

  @AltaMovilPostpagoCanalTienda
  Esquema del escenario: Alta Movil Postpago con documento CE por Canal Tienda
    Dado     que abro la pagina de movistar
    Cuando   presiono el boton Iniciar Sesion
    Y        selecciono el tipo de usuario "<tipoUsuario>"
    Y        ingreso el usuario "<userName>"
    Y        ingreso el password "<password>"
    E        ingreso el captcha
    Y        presiono el boton Continuar hacia el home
    Entonces valido el login exitoso mediante el mensaje "<msgHome>"
    Y        valido que se presente la tienda "<tiendaAsesor>"
    Cuando   selecciono el tipo de documento "<tipoDocumento>"
    Y        ingreso el documento "<documento>"
    Y        doy click en el boton Consultar
    Y        cierro popup de error
    Y        ingreso los datos del nuevo cliente
      | nombres        | apellidos      | genero   |
      | Estela Rosario | Lopez Manrique | femenino |
#    Y        cierro popup de aviso
    Y        valido que muestre el nombre completo del cliente "Estela Rosario Lopez Manrique"
    Y        selecciono el boton Linea Nueva Movil
    Y        cierro el popup de validación de estado de contraseña única
    Y        selecciono el boton Mostrar ofertas
    Y        selecciono el plan "Postpago" que desea
    Y        doy click en el boton Siguiente
    Y        valido que este en la pagina de ofertas sugeridas
    Y        selecciono tipo de oferta
    Y        selecciono el tipo de plan movil "<tipoPlanMovil>"
    Y        selecciono la opcion "<tipoPlanes>"
    Y        doy click en el boton seleccionar oferta
    Y        selecciono la cartilla Linea Nueva
    Y        doy click en el boton Iniciar registro
    Y        valido que este en la seccion completa los datos solicitados
    Y        ingreso correo electronico "estelalopez@mail.com"
    Y        ingreso nuevamente el correo electronico "estelalopez@mail.com"
    Y        doy click en datos del cliente
    Y        selecciono completar los datos del cliente
      | fechaNac   | estadoCivil | nacionalidad | departamento | provincia | distrito   | direccion            |
      | 26/07/1995 | soltero     | Alemania     | LIMA         | LIMA      | SAN MIGUEL | CALLE SAN MARTIN 399 |
	#Y        doy click en el boton confirmar
    Y        doy clic para validar contrato hogar
    Y        me muestra en pantalla el contrato solicitado
    Y        imprimo el texto del contrato solicitado
    Cuando   doy clic en si acepto
    Y        doy click en el boton de continuar
    Y        doy clic en Registrar venta
    Entonces visualizo en pantalla el mensaje de exito de la venta generada
    Y        doy click en ver detalle del pedido
    Y        valido que se muestre el detalle del pedido de "Servicio Móvil"
    Y        valido que se muestre el detalle del pedido de "Información adicional"
    Ejemplos:
      | tipoUsuario     | userName   | password | msgHome    | tiendaAsesor              | tipoDocumento | documento  | tipoPlanMovil | tipoPlanes                 |
      | usuario externo | userNameST | passST   | Bienvenid@ | Tiendas Franquicia Prueba | CE            | 1100000112 | Postpago      | Plan Ilimitado Mi Movistar |