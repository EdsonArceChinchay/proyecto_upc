#language: es

##CREADOR:
##APP: DITO
##MODULO:
##FUNCIONALIDAD:
##ESTADO:
##CODIGO: AT-DT109
##GDAP: GDAP-728
##SPRINT CREADO:
##FRECUENCIA:
##TAG : BERSERKERS
##DATA:
##ENCARGADO:
##FECMOD: 30/03/2023
@BERSERKERS @DoneDevOps @DoneDevOpsPI13

  Característica: AT-DT109_Flujo de sva en el canal Call Center

    Antecedentes:
      Dado     que abro la pagina de movistar

    @SvaCallCenter
    Esquema del escenario: Sva en el canal Call Center
      Cuando   presiono el boton Iniciar Sesion
      Y        selecciono el tipo de usuario "<tipoUsuario>"
      Y        ingreso el usuario "<userName>"
      Y        ingreso el password "<password>"
      Y        presiono el boton Continuar hacia el home
      Y        valido el login exitoso mediante el mensaje "<msgHome>"
      Y        valido que se presente la tienda "<tiendaAsesor>"
      Cuando   selecciono el tipo de documento "<tipoDocumento>"
      Y        ingreso el documento "<documento>"
      Y        doy click en el boton consultar
      Cuando   doy click en ver detalle
      Y        doy click en el boton Agregar sva fija
      Y        elegimos sva
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
      #Y        presiono el boton Registrar venta
      Entonces visualizo en pantalla el mensaje de exito de la venta generada

      Ejemplos:
        | tipoUsuario     | userName  | password     | msgHome    | tiendaAsesor                  | tipoDocumento | documento | correo           |
        | usuario externo | jpachaot  | $t3l3f0n1c4$ | Bienvenid@ | CANAL ONLINE-CALL CENTER GSS  | CE            | 120906347 | correo@gmail.com |