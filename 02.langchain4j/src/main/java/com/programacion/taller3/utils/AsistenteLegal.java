package com.programacion.taller3.utils;

import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.V;

public interface AsistenteLegal {
//    String responder(String pregunta);
//
//    @SystemMessage("Eres un asistente legal experto en leyes de Ecuador")
//    @UserMessage("Responde a la pregunta con argumentos legales: {{pregunta}}")
//    String consultar(@V("pregunta") String pregunta);
//
//    @SystemMessage("Eres un asistente legal en temas de educacion superior")
//    @UserMessage("""
//            Responde a la pregunta con argumentos legales: {{pregunta}}
//            Si no tienes la respuesta, utiliza la seccion de Datos que se incluye aqui
//            DATOS
//            -----
//            AtomicInteger count = new AtomicInteger(1);
//
//                    var chatModel = OpenAiStreamingChatModel.builder()
//                            .apiKey(System.getenv("api-key-real"))
//                            .modelName("llama-2-7b-chat.Q4_0.gguf")
//                            .baseUrl("http://localhost:8080")
//                            .logRequests(true)
//                            .logResponses(true)
//                            .build();
//
//                    chatModel.chat("Que es Langchain4J?", new MystreamingChatResponseHandler(count));
//
//                    while (true) {
//            """)
//    String consultar(@V("pregunta") String pregunta);

    //Tesis
    @SystemMessage("""
            Eres un auditor legal estricto y experto en la Ley Orgánica de Protección de Datos Personales (LOPDP) de Ecuador.
            Tu objetivo es analizar cláusulas, procesos de recolección de datos o arquitecturas de sistemas (como ERPs o CRMs) 
            para verificar su estricto cumplimiento con la ley. 
            Debes identificar riesgos de privacidad, evaluar principios como el consentimiento explícito y la minimización de datos, 
            y dar recomendaciones claras.
            Responde siempre con un tono formal, profesional, estructurado y citando los principios de la normativa ecuatoriana.
            """)
    @UserMessage("""
            Por favor, analiza el siguiente fragmento de texto o proceso y genera un reporte de cumplimiento LOPDP:
            
            TEXTO/PROCESO A ANALIZAR:
            -------------------------
            {{texto}}
            """)
    String auditarCumplimiento(@V("texto") String texto);
}
