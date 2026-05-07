package com.programacion.taller3;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class TestTokenizerMain {

    public static final String PATH = "C:/Clases/Decimo Semestre/Taller 3/Taller3 1/Taller3/01.embeddings/the-verdict.txt";

    public static List<Pair> vocabulary() throws Exception {
        String raw_text = Files.readString(Paths.get(PATH));
        String regex = "(?=[,.:;?_!\"()']|--|\\s)|(?<=[,.:;?_!\"()']|--|\\s)";
        var tokens = raw_text.split(regex);

        var all_words = Stream.of(tokens)
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .distinct()
                .sorted()
                .toList();

        AtomicInteger counter = new AtomicInteger(0);
        return all_words.stream()
                .map(it -> new Pair(counter.getAndIncrement(), it))
                .toList();
    }

    public static List<Pair> vocabularyEx() throws Exception {
        List<Pair> baseVocab = vocabulary();
        List<String> words = new ArrayList<>(baseVocab.stream().map(Pair::token).toList());

        words.add("<|endoftext|>");
        words.add("<|unk|>");

        AtomicInteger counter = new AtomicInteger(0);
        return words.stream()
                .map(it -> new Pair(counter.getAndIncrement(), it))
                .toList();
    }

    public static void main(String[] args) throws Exception {
        System.out.println("--- TESTING V1 ---");
        List<Pair> vocab = vocabulary();
        SimpleTokenizerV1 tokenizer1 = new SimpleTokenizerV1(vocab);
        var textV1 = "\"It's the last he painted...\"";
        System.out.println("V1 IDs: " + tokenizer1.encode(textV1));

        System.out.println("\n--- TESTING V2 ---");
        var vocabEx = vocabularyEx();
        vocabEx.stream().skip(Math.max(0, vocabEx.size() - 5)).forEach(System.out::println);

        var text1 = "Hello, do you like tea?";
        var text2 = "In the sunlit terraces of the palace.";
        String combinedText = text1 + " <|endoftext|> " + text2;

        SimpleTokenizerV2 tokenizer2 = new SimpleTokenizerV2(vocabEx);
        var ids2 = tokenizer2.encode(combinedText);

        System.out.println("Encoded IDs: " + ids2);
        System.out.println("DECODED: " + tokenizer2.decode(ids2));
    }
}
