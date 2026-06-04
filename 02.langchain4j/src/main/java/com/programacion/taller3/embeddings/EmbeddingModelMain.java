package com.programacion.taller3.embeddings;

import dev.langchain4j.data.embedding.Embedding;
import dev.langchain4j.model.embedding.onnx.OnnxEmbeddingModel;
import dev.langchain4j.model.embedding.onnx.PoolingMode;
import dev.langchain4j.model.embedding.onnx.allminilml6v2.AllMiniLmL6V2EmbeddingModel;
import dev.langchain4j.model.output.Response;

import java.nio.file.Paths;


public class EmbeddingModelMain {
    static void main() {
//        var pathToModel = Paths.get("C:/tools/Embeddings/model.onnx");
//        var pathTokenizer = Paths.get("C:/tools/Embeddings/tokenizer.json");
//
//        OnnxEmbeddingModel model = new OnnxEmbeddingModel(pathToModel, pathTokenizer, PoolingMode.MEAN);

        AllMiniLmL6V2EmbeddingModel model = new AllMiniLmL6V2EmbeddingModel();

        Response<Embedding> reponse = model.embed("Hola, como estas?");
        Embedding embedding = reponse.content();
        System.out.println("Dimension: " + embedding.vector().length);
        System.out.println(embedding.vectorAsList());
    }
}
