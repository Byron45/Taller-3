package com.programacion.taller3;

import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.model.openai.OpenAiChatModel;

public class ChatMain {

    static String base_url = "https://api.groq.com/openai/v1";
    static String key = System.getenv("GROQ_API_KEY");
    static String model = "llama-3.1-8b-instant";

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
        var respuesta = chatModel.chat("Que es Langchain4J?");
        System.out.println("[respuesta]");
        System.out.println(respuesta);
    }
}

