#language:es
##CREADOR: CARLOS RUIZ
##APP: DITO
##MODULO:
##FUNCIONALIDAD:
##ESTADO:
##CODIGO: AT-DT0
##GDAP: GDAP-1425
##SPRINT CREADO: PI18_SP1
##FRECUENCIA:
##TAG : BERSERKERS
##DATA:
##ENCARGADO: CARLOS RUIZ
##FECMOD: 19/01/2024

@BERSERKERS @DoneDevOps @RegresionLegacy

Característica: AT-DT0 _Completa Planta Fija Trio + Alta Movil + Alta equipo movil + SVA con documento CE en tienda

  @CompletaMovilEquipoSVAT
  Esquema del escenario: Completa Planta Fija Trio + Alta Movil + Alta Equipo Movil+ Alta SVA con documento CE en tienda
    Dado     que abro la pagina de movistar
    Cuando   presiono el boton Iniciar Sesion
    Y        selecciono el tipo de usuario "<tipoUsuario>"
    Y        ingreso el usuario "<userName>"
    Y        ingreso el password "<password>"
    Y        ingreso el captcha
    Y        presiono el boton Continuar hacia el home
    Entonces valido el login exitoso mediante el mensaje "<msgHome>"
    Y        valido que se presente la tienda "<tiendaAsesor>"
    Cuando   selecciono el tipo de documento "<tipoDocumento>"
    Y        ingreso el documento "<documento>"
    Y        doy click en el boton consultar
    #Y        valido que muestre el nombre completo del cliente "<nombreCliente>"
    Y        selecciono el boton de la Linea Hogar Existente
    Y        selecciono el boton Linea Nueva Movil
    Y        cierro el popup de validación de estado de contraseña única
    Y        cierro pop up de Cliente Exonerado
    Y        selecciono el boton Mostrar ofertas
    Entonces me muestra la pantalla para verificar la direccion
    Y        presiono el boton Confirmar direccion
    Y        selecciono tipo de oferta
    Y        selecciono el plan "<nombrePlan>" Movistar Total
    Y        selecciono añadir equipos
    Y        ingreso el tiempo de permanencia"Sin permanencia"
    Y        ingreso el tipo de pago "Al Contado"
    Y        busco el equipo "SAMSUNG GXY A34 NEGRO A346M 128GB"
    Y        doy click en el boton seleccionar
    Y        doy click en el boton Ir a movistar total
    Y        doy click en agregar "PACK ANTIVIRUS MCAFEE"
    Cuando   doy clic a iniciar registro
    Y        valido que me encuentre en la pantalla agendamiento
    Y        ingreso los datos de agendamiento
    Y        presiono el boton confirmar agendamiento
    Y        ingreso un correo electronico "<correo>"
    Y        ingreso nuevamente el correo electronico "<correo>"
    Y        doy click en el boton confirmar
    Y        doy clic para validar contrato Movil
    Y        me muestra en pantalla el contrato solicitado
    Cuando   doy clic en si acepto
    Y        doy clic en continuar
    Y        presiono el boton Registrar venta
    Entonces visualizo en pantalla el mensaje de exito de la venta generada
    Y        doy click en ver detalle del pedido
    Y        valido que se muestre el detalle del pedido del "Servicio Hogar"
    Y        valido que se muestre el detalle del pedido del "Servicio Móvil"
    Ejemplos:
      | tipoUsuario     | userName  | password     | msgHome    | tiendaAsesor              | tipoDocumento | documento | nombrePlan                                | correo           |
      | usuario externo | nishuizas | $t3l3f0n1c4$ | Bienvenid@ | Tiendas Franquicia Prueba | CE            | 153426984 | Trío HD 200 Mbps RA + Ilimitado 135 Gb RA | correo@gmail.com |