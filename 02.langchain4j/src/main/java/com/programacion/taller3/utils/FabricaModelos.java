package com.programacion.taller3.utils;

import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.model.openai.OpenAiChatModel;

public class FabricaModelos {

    public static ChatModel obtenerModelo(String proveedor) {
        switch (proveedor.toLowerCase()) {
            case "gemini":
                return OpenAiChatModel.builder()
                        .apiKey(System.getenv("GEMINI_API_KEY"))
                        .modelName("gemini-2.5-flash")
                        .baseUrl("https://generativelanguage.googleapis.com/v1beta/")
                        .logRequests(false).logResponses(false).build();
            case "groq":
                return OpenAiChatModel.builder()
                        .apiKey(System.getenv("GROQ_API_KEY"))
                        .modelName("llama-3.1-8b-instant")
                        .baseUrl("https://api.groq.com/openai/v1")
                        .logRequests(false).logResponses(false).build();
            case "local":
            default:
                return OpenAiChatModel.builder()
                        .apiKey("ignorar") // El modelo local no necesita key real
                        .modelName("llama-2-7b-chat.Q4_0.gguf")
                        .baseUrl("http://localhost:8080/v1")
                        .logRequests(true).logResponses(true).build();
        }
    }
}