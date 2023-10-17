#language:es
##CREADOR: Edson Arce
##APP: DITO
##MODULO:
##FUNCIONALIDAD: CAMBIO
##ESTADO: ACTIVO
##CODIGO: AT-DT069
##GDAP: GDAP-1141
##SPRINT CREADO:
##FRECUENCIA: DIARIO
##TAG : BERSERKERS
##DATA: REUSABLE
##ENCARGADO: Maria Sanchez
##FECMOD: 31/08/2023

@BERSERKERS @DoneDevOps
Característica: AT-DT069_Migracion de Mono a Mono por el canal Call Center

  Antecedentes:
    Dado     que abro la pagina de movistar

  @MigracionMonoAMonoSVACallCenter @MVP19  @Global @General
  Esquema del escenario: Migracion (mono a mono) + sva en canal CALL CENTER
    Cuando   presiono el boton Iniciar Sesion
    Y        selecciono el tipo de usuario "<tipoUsuario>"
    Y        ingreso el usuario "<userName>"
    Y        ingreso el password "<password>"
    Y        presiono el boton Continuar hacia el home
    Y         valido el login exitoso mediante el mensaje "<msgHome>"
   # Y        valido que se presente la tienda "<tiendaAsesor>"
    Cuando   selecciono el tipo de documento "<tipoDocumento>"
    Y        ingreso el documento "<documento>"
    Y        doy click en el boton consultar
    Y        selecciono la cartilla del plan activo
    Y        selecciono el boton Mostrar ofertas
    #Y        verifico la direccion "SAN MIGUEL,LIMA ,LIMA PE" actual del servicio
    Y        doy click en el boton "Confirmar direccion"
    Y        selecciono tipo de oferta
    Y        selecciono el tipo de plan Hogar "<tipoPlanHogar>"
    Y        selecciono la oferta "<plan>"
    Y        doy click en Cambiar plan hogar
    Y        valido que este en la seccion de registro
    Entonces doy click en Agregar Sva
    Y        doy click en agregar Bloque "<bloque>"
    Y        doy click en Guardar cambios
    Cuando   doy clic a iniciar registro
    Y        ingreso un correo electronico "<correo>"
    Y        ingreso nuevamente el correo electronico "<correo>"
    Y        doy clic para validar contrato hogar
    Y        me muestra en pantalla el contrato solicitado
    Cuando   doy clic en si acepto
    Y        doy click en el boton de continuar
    Entonces visualizo en pantalla el mensaje de exito de la venta generada

    Ejemplos:
      | tipoUsuario     | userName | password     | msgHome    | tipoDocumento | documento | correo            | tipoPlanHogar | plan                    | bloque |
      | usuario externo | jpachaot | $t3l3f0n1c4$ | Bienvenid@ | CE            | 123456766 | tester@tester.com | Mono          | TV HOGAR DIGITAL RA M23 | FOX    |