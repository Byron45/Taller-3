//package com.programacion.taller3;
//
//import com.programacion.taller3.utils.AsistenteLegal;
//import dev.langchain4j.model.chat.ChatModel;
//import dev.langchain4j.service.AiServices;
//
//public class ChatAiServiceMain {
//    static void main() {
//        var model = ChatMain.chatModel();
//        var asistente = AiServices.create(AsistenteLegal.class, model);
//
//        var respuesta = asistente.consultar("¿Cual es el plazo de prescripcion para deudas civiles");
//        System.out.printf(respuesta);
//
//        //--
//
//        System.out.println("------------");
//        respuesta = asistente.responder("¿Cual es el plazo de prescripcion para deudas civiles");
//        System.out.printf(respuesta);
//
//    }
//}
