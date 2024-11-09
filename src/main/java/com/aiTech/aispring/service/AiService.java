package com.aiTech.aispring.service;

import com.aiTech.aispring.config.FastApiProperties;
import com.aiTech.aispring.entity.Question;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class AiService {

    private final WebClient.Builder webClientBuilder;
    private final FastApiProperties fastApiProperties;

    public AiService(WebClient.Builder webClientBuilder, FastApiProperties fastApiProperties) {
        this.webClientBuilder = webClientBuilder;
        if (this.webClientBuilder == null) {
            throw new IllegalStateException("WebClient.Builder is not initialized");
        }
        this.fastApiProperties = fastApiProperties;
    }


    public Mono<String> predictChat(Question question) {
        // Construire l'URL finale en ajoutant le préfixe
        String url = fastApiProperties.getBaseUrl() + "/questions/add_question";

        return webClientBuilder.build()
                .post()
                .uri(url)
                .bodyValue(question)
                .retrieve()
                .bodyToMono(Question.class)
                .map(Question::getAnswer_text);
    }




}
