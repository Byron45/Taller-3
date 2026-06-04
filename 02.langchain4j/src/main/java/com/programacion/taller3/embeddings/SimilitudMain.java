package com.programacion.taller3.embeddings;

import dev.langchain4j.data.embedding.Embedding;
import dev.langchain4j.model.embedding.onnx.allminilml6v2.AllMiniLmL6V2EmbeddingModel;
import dev.langchain4j.store.embedding.CosineSimilarity;

public class SimilitudMain {

    static void main() {
        AllMiniLmL6V2EmbeddingModel model = new AllMiniLmL6V2EmbeddingModel();

        Embedding e1 = model.embed("¿Cual es el area de un circulo de radio 5?").content();
        Embedding e2 = model.embed("Obtiene la fecha y hora actual").content();
        Embedding e3 = model.embed("Cacula el area de un circulo dado su radio").content();

        //Calcular similitud coseno
        double sim12 = CosineSimilarity.between(e1, e2);
        double sim13 = CosineSimilarity.between(e1, e3);

        System.out.println("perros vs caninos " + sim12);
        System.out.println("perros vs clima " + sim13);

    }
}
