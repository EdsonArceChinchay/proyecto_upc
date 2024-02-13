#language:es

##CREADOR:
##APP: DITO
##MODULO:
##FUNCIONALIDAD:
##ESTADO:
##CODIGO: AT-DT075
##GDAP: GDAP-603
##SPRINT CREADO:
##FRECUENCIA:
##TAG : BERSERKERS
##DATA:
##ENCARGADO:
##FECMOD: 30/03/2023

@BERSERKERS @DoneDevOps
Característica: AT-DT075_Migra MT con cambio de velocidad en canal call center

  @MigraMTcambioVelocidad
  Esquema del escenario:  Realizar migra MT cambio de velocidad  canal call center
    Dado     que abro la pagina de movistar
    Cuando   presiono el boton Iniciar Sesion
    Y        selecciono el tipo de usuario "<tipoUsuario>"
    Y        ingreso el usuario "<userName>"
    Y        ingreso el password "<password>"
    Y        presiono el boton Continuar hacia el home
    Y        valido el login exitoso mediante el mensaje "<msgHome>"
    #Y        valido que se presente la tienda "<tiendaAsesor>"
    Cuando   selecciono el tipo de documento "<tipoDocumento>"
    Y        ingreso el documento "<documento>"
    Y        doy click en el boton consultar
    Y        selecciono la cartilla del plan MT
    Y        selecciono el boton Mostrar ofertas
    Y        doy click en el boton "Confirmar direccion"
    Y        cierro popup de error
    #Y        Selecciono una linea movil y mostrar ofertas
    #Y        selecciono el boton Mostrar ofertas
    #Y        selecciono tipo de oferta
    #Y        selecciono un plan Movistar Total "<nombrePlan>"
    Y        selecciono el nombre de plan movistar total
    Y        valido que este en la seccion de registro
    Cuando   doy clic a iniciar registro
    Y        valido que me encuentre en la pantalla agendamiento
    Y        ingreso los datos de agendamiento
    Y        presiono el boton confirmar agendamiento
    Y        ingreso un correo electronico "<correo>"
    Y        ingreso nuevamente el correo electronico "<correo>"
    Y        doy clic para validar contrato hogar
    Y        me muestra en pantalla el contrato solicitado
    Cuando   doy clic en si acepto
    Y        doy click en el boton de continuar
    Y        presiono el boton Registrar venta
    #    Y        presiono el boton descargar contrato
    Y        presiono el boton Registrar venta
    Entonces visualizo en pantalla el mensaje de exito de la venta generada
    Y        valido que se muestre el detalle del pedido
    Ejemplos:

      | tipoUsuario     | userName | password     | msgHome    | tiendaAsesor              | tipoDocumento | documento  | nombrePlan                      | correo            |
      | usuario externo | userNameCC | passCC | Bienvenid@ | PRUEBAS SIST CALLIN VENTA | CE            | 1042465107 | Mono BA 1 Gb RV + 95 Gb RV | tester@tester.com |

