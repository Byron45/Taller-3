package com.programacion.taller3;

import com.programacion.taller3.utils.AsistenteLegal;
import com.programacion.taller3.utils.FabricaModelos;
import dev.langchain4j.service.AiServices;

public class PrototipoLopdpMain {

    public static void main(String[] args) {
        String proveedorElegido = "local";

        var model = FabricaModelos.obtenerModelo(proveedorElegido);
        var auditor = AiServices.create(AsistenteLegal.class, model);

        String casoPrueba = "Para acceder al sistema ERP y consultar sus calificaciones, " +
                "el estudiante debe aceptar obligatoriamente que la universidad " +
                "comparta su historial médico y financiero con empresas de marketing " +
                "de terceros de forma indefinida y sin opción a revocatoria o eliminación.";

        System.out.println("Iniciando auditoría LOPDP con el modelo: " + proveedorElegido.toUpperCase());
        System.out.println("Analizando caso...\n");

        String reporte = auditor.auditarCumplimiento(casoPrueba);

        System.out.println("================ REPORTE ================");
        System.out.println(reporte);
        System.out.println("=========================================");
    }
}