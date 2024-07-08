#language:es
##CREADOR: Andres Michilot
##APP: DITO
##MODULO:
##FUNCIONALIDAD:
##ESTADO:
##CODIGO:
##GDAP: GDAP-1430
##SPRINT CREADO: PI18_SP1
##FRECUENCIA:
##TAG: BERSERKERS
##DATA:
##ENCARGADO:
##FECMOD: 24/01/2024

@BERSERKERS @DoneDevOps

Característica: Migracion de MT a MT + Alta Equipo Movil + Alta SVA con documento CE el canal Tienda

  @MigracionMTaMT_Equipo_SVA_Tiendas
  Esquema del escenario: Migracion de MT a MT + Alta Equipo Movil + Alta SVA con documento CE el canal Tienda
    Dado     que abro la pagina de movistar
    Cuando   presiono el boton Iniciar Sesion
    Y        selecciono el tipo de usuario "<tipoUsuario>"
    Y        ingreso el usuario "<userName>"
    Y        ingreso el password "<password>"
    Y        ingreso el captcha
    Y        presiono el boton Continuar hacia el home
    Y        valido el login exitoso mediante el mensaje "<msgHome>"
	#Y        valido que se presente la tienda "<tiendaAsesor>"
    Cuando   selecciono el tipo de documento "<tipoDocumento>"
    Y        ingreso el documento "<documento>"
    Y        doy click en el boton Consultar
    #Y        selecciono la cartilla del plan activo
    Y        Selecciono la cartilla del plan Motvistar Total
    Y        selecciono el boton Mostrar ofertas
    #Y        verifico la direccion "JULIO CESAR TELLO,469,LINCE,LIMA" actual del servicio
    Y        doy click en el boton "Confirmar direccion"
    Y        luego doy click en la cartilla ir a Movistar Total
    Y        valido que este en el resumen de venta
    Cuando   doy click en el boton Agregar SVA
    Y        valido que me encuentre en la pantalla "Añade tus servicios adicionales (SVA's)"
    Y        agrego SVA internet "Seguridad Total Residencial"
    Y        doy click en el boton Guardar cambios
    Y        selecciono añadir equipos
    E        ingreso permanencia, tipo de pago y equipo
      | permanencia     | tipoPago   | equipoName |
      | Sin permanencia | Al Contado | SAMSUNG    |
    Y        presiono el boton Ver detalle valido contenido y selecciono
    Y        luego doy click en la cartilla ir a Movistar Total
    Y        valido que este en el resumen de venta
    Cuando   doy clic a iniciar registro
    Y        valido que este en la seccion completa los datos solicitados
    Y        ingreso un correo electronico "<correo>"
    Y        ingreso nuevamente el correo electronico "<correo>"
    Y        doy clic para validar contrato hogar
    Y        me muestra en pantalla el contrato solicitado
    Y        imprimo el texto del contrato solicitado
    Cuando   doy clic en si acepto
    Y        doy click en el boton de continuar
    Y        presiono el boton Registrar venta
    Entonces visualizo en pantalla el mensaje de exito de la venta generada
    Y        doy click en ver detalle del pedido
    Y        valido que se muestre el detalle del pedido de "Servicio Hogar"
    Y        valido que se muestre el detalle del pedido de "Servicio Móvil"

    Ejemplos:
      | tipoUsuario     | userName   | password | msgHome    | tiendaAsesor      | tipoDocumento | documento  | correo              |
      | usuario externo | userNameST | passST   | Bienvenid@ | TIENDA SAN MIGUEL | CE            | 1042464769 | automation@mail.com |
