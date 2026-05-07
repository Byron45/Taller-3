package com.programacion.taller3;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import com.knuddels.jtokkit.Encodings;
import com.knuddels.jtokkit.api.Encoding;
import com.knuddels.jtokkit.api.EncodingRegistry;
import com.knuddels.jtokkit.api.ModelType;

import ai.djl.ndarray.NDArray;
import ai.djl.ndarray.NDManager;
import ai.djl.ndarray.types.Shape;
import dev.langchain4j.data.embedding.Embedding;
import dev.langchain4j.model.embedding.EmbeddingModel;
import dev.langchain4j.model.embedding.onnx.allminilml6v2q.AllMiniLmL6V2QuantizedEmbeddingModel;
import dev.langchain4j.model.output.Response;

public class EmbeddingTest {

    public static final String PATH = "C:/Clases/Decimo Semestre/Taller 3/Taller3 1/Taller3/01.embeddings/the-verdict.txt";

    public static void main(String[] args) throws Exception {

        String raw_text = Files.lines(Paths
                .get(PATH)).reduce(String::concat).orElse("");

        EncodingRegistry registry = Encodings.newDefaultEncodingRegistry();
        Encoding tokenizer = registry.getEncodingForModel(ModelType.TEXT_DAVINCI_003);

        // generacion de (inputTokens, targetTokens)
        List<DatasetItem> dataset = new ArrayList<>();

        List<Integer> tokensIds = tokenizer.encode(raw_text).boxed();

        int maxLength = 4;

        IntStream.range(0, tokensIds.size() - maxLength).forEach(i -> {
            var inputChunk = tokensIds.subList(i, i + maxLength);
            var targetChunk = tokensIds.subList(i + 1, i + maxLength + 1);
            dataset.add(new DatasetItem(inputChunk, targetChunk));
        });

        int vocabSize = 50257;
        int outputDim = 256;

        try (NDManager manager = NDManager.newBaseManager()) {
            NDArray weights = manager.randomUniform(-1.0f, 1.0f,
                    new Shape(vocabSize, outputDim));

            dataset.stream().limit(3).forEach(item -> {
                var input = item.input().stream()
                        .mapToLong(Integer::longValue)
                        .toArray();

                NDArray indices = manager.create(input);

                NDArray embedding = weights.get(indices);

                System.out.println("--------------------------------------------------");
                System.out.println("Input indices:" + Arrays.toString(input));
                System.out.println("Embedding output shape:" + embedding);

            });

            EmbeddingModel embeddingModel = new AllMiniLmL6V2QuantizedEmbeddingModel();
            var text = "Hello world!";

            Response<Embedding> response = embeddingModel.embed(text);
            float[] vector = response.content().vector();

            System.out.println("Embedding size:" + vector.length);
            System.out.println(Arrays.toString(vector));
        }

    }

}
