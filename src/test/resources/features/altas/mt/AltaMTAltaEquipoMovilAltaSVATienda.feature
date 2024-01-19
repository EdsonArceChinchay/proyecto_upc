#language:es
##CREADOR: CARLOS RUIZ
##APP: DITO
##MODULO:
##FUNCIONALIDAD:
##ESTADO:
##CODIGO: AT-DT
##GDAP: GDAP-1426
##SPRINT CREADO: PI17-SPPI
##FRECUENCIA:
##TAG : BERSERKERS
##DATA:
##ENCARGADO:
##FECMOD: 19/01/2024

@BERSERKERS @DoneDevOps @DoneDevOpsPI17 @RegresionLegacy

Característica: AT-DT0 _ Alta MT + Alta Equipo Movil + Alta SVA con documento CE por Tienda

  @AltaMTEquipoSVA
  Esquema del escenario: Alta MT + Alta Equipo Movil + Alta SVA con documento CE por Tienda
    Dado     que abro la pagina de movistar
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
      | nombres     | apellidos    | genero   |
      | Maria Luisa | Perez Zapata | Femenino |
    Y        selecciono el boton Linea Nueva Hogar
    Y        selecciono el boton Linea Nueva Movil
    Y        cierro el popup de validación de estado de contraseña única
    Y        cierro pop up de Cliente Exonerado
    Y        selecciono el boton Mostrar ofertas
    Entonces me muestra la pantalla para ingresar la direccion
    Y        selecciono el departamento donde sera la instalacion "<departamento>"
    Y        selecciono la provincia donde sera la instalacion "<provincia>"
    Y        selecciono el distrito donde sera la instalacion "<distrito>"
    Y        ingreso la direccion donde sera la instalacion "<direccion>"
    Y        ingreso la referencia de la direccion "<referencia>"
    Y        presiono el boton Consultar ubicacion
    Y        presiono el boton consultar cobertura
    #Entonces me muestra la pantalla de ofertas sugeridos
    Y        selecciono tipo de oferta
    Y        selecciono el plan "<nombrePlan>" Movistar Total
    Y        selecciono añadir equipos
    Y        ingreso el tiempo de permanencia"Permanencia de 12 meses"
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
    Y        doy click en datos del cliente
    Y        ingreso los datos del cliente
      | fechaNac   | estadoCivil | nacionalidad |
      | 11/02/1990 | Casado      | Albania      |
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
      | tipoUsuario     | userName  | password     | msgHome    | tiendaAsesor              | tipoDocumento | documento | departamento | provincia | distrito | direccion                   | referencia | tipoOferta     | nombrePlan                                | correo           |
      | usuario externo | nishuizas | $t3l3f0n1c4$ | Bienvenid@ | Tiendas Franquicia Prueba | CE            | 991000232 | 15           | 1501      | 150116   | JIRON JULIO CESAR TELLO 469 | INKAFARMA  | MOVISTAR TOTAL | TRÍO HD 400 MBPS RA + ILIMITADO 135 GB RA | correo@gmail.com |