package com.programacion.taller3;

import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.model.openai.OpenAiChatModel;

public class ChatMain {

    //Groq
//    static String base_url = "https://api.groq.com/openai/v1";
//    static String key = System.getenv("GROQ_API_KEY");
//    static String model = "llama-3.1-8b-instant";

    //Gemini
//    static String base_url = "https://generativelanguage.googleapis.com/v1beta/";
//    static String key = System.getenv("GEMINI_API_KEY");
//    static String model = "gemini-3-flash-preview";

    //Local LLama
//    static String base_url = "http://localhost:8080";
//    static String key = System.getenv("api-key-real");
//    static String model = "llama-2-7b-chat.Q4_0.gguf";

    //Local Gema
    static String base_url = "http://localhost:8080";
    static String key = System.getenv("api-key-real");
    static String model = "gemma-4-E4B-it-Q4_K_S.gguf";


    public static ChatModel chatModel() {

        return OpenAiChatModel.builder()
                .apiKey(key)
                .modelName(model)
                .baseUrl(base_url)
                .logRequests(true)
                .logResponses(true)
                .build();
    }

    static void main() {

        ChatModel chatModel = ChatMain.chatModel();
        var respuesta = chatModel.chat("Que es Encapsulamiento en programacion?");
        System.out.println("[respuesta]");
        System.out.println(respuesta);
    }
}

