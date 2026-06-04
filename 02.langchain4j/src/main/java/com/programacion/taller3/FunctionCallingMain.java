package com.programacion.taller3;

import dev.langchain4j.agent.tool.P;
import dev.langchain4j.agent.tool.Tool;
import dev.langchain4j.service.AiServices;
import dev.langchain4j.service.SystemMessage;

import java.time.LocalDateTime;

class Herramientas {

    @Tool("Obtiene la fecha y hora actual")
        //herramienta de contexto
    String obtenerFechaHora() {
        return LocalDateTime.now().toString();
    }

    @Tool("Consulta el area de un circulo dado su radio")
    double calcularAreaCirculo(@P("El radio del circulo") double radio) {
        return Math.PI * radio * radio;

    }
}

interface AssitenteConTools {
    @SystemMessage("Eres un asistente util. Usa las herramientas disponibles")
    String chat(String mensaje);
}

public class FunctionCallingMain {

    static void main() {
        var model = ChatMain.chatModel();

        var service = AiServices.builder(AssitenteConTools.class)
                .chatModel(model)
                .tools(new Herramientas())
                .build();

        var respuesta = service.chat("Que hora es?");
        System.out.println(respuesta);

        respuesta = service.chat("¿Cual es el area de un circulo de radio 5 cm?");
        System.out.println(respuesta);
    }
}
