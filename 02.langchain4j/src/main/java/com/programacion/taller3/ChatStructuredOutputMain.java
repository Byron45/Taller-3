package com.programacion.taller3;

import dev.langchain4j.service.AiServices;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.V;

record Persona(String nombre, int edad, String ciudad) {
}

interface Extractor {
    @UserMessage("Extrae la informacion de: {{texto}}")
    Persona extraerPersona(@V("texto") String texto);
}

public class ChatStructuredOutputMain {

    static void main() {
        var model = ChatMain.chatModel();

        Extractor extractor = AiServices.builder(Extractor.class)
                .chatModel(model).build();

        Persona p = extractor.extraerPersona(
                "Soy Maria, tengo 30 años y vivo en Quito"
        );

        System.out.println(p);

    }
}
