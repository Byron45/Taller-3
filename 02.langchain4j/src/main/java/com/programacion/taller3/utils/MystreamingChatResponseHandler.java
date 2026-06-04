package com.programacion.taller3.utils;

import dev.langchain4j.model.chat.response.ChatResponse;
import dev.langchain4j.model.chat.response.StreamingChatResponseHandler;

import java.util.concurrent.atomic.AtomicInteger;

public class MystreamingChatResponseHandler implements StreamingChatResponseHandler {

    private AtomicInteger count;

    public MystreamingChatResponseHandler(AtomicInteger count) {
        this.count = count;

    }

    @Override
    public void onPartialResponse(String partialResponse) {
        System.out.println(partialResponse);
        System.out.flush();
    }

    @Override
    public void onCompleteResponse(ChatResponse completeResponse) {
        System.out.println();
        System.out.println("[Generacion completa]");

        count.getAndDecrement();

    }

    @Override
    public void onError(Throwable error) {
        error.printStackTrace();

    }
}
