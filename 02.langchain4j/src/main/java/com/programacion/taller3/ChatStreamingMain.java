package com.programacion.taller3;

import com.programacion.taller3.utils.MystreamingChatResponseHandler;
import dev.langchain4j.model.openai.OpenAiStreamingChatModel;

import java.util.concurrent.atomic.AtomicInteger;

public class ChatStreamingMain {
    static void main() {

        AtomicInteger count = new AtomicInteger(1);

        var chatModel = OpenAiStreamingChatModel.builder()
                .apiKey(System.getenv("GROQ_API_KEY"))
                .modelName("llama-3.1-8b-instant")
                .baseUrl("https://api.groq.com/openai/v1")
                .logRequests(true)
                .logResponses(true)
                .build();

        chatModel.chat("Que es Langchain4J?", new MystreamingChatResponseHandler(count));

        while (true) {

        }


    }
}
