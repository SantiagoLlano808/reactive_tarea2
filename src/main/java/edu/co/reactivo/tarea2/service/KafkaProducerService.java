package edu.co.reactivo.tarea2.service;

import edu.co.reactivo.tarea2.model.Producto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {
    private final Logger LOGGER = LoggerFactory.getLogger(KafkaProducerService.class);

    private final KafkaTemplate<String, String> kafkaTemplate;

    public KafkaProducerService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendKey(String topico, Integer key, Producto producto ){
        var future = kafkaTemplate.send(topico, key.toString(), producto.toString());

        future.whenComplete((resultadoEnvio, excepcion) -> {
            if(excepcion != null){
                LOGGER.error(excepcion.getMessage());
                future.completeExceptionally(excepcion);
            } else {
                future.complete(resultadoEnvio);
            }
            LOGGER.info("Producto enviado al topico de Kafka con id"+ producto);
        });
    }

    public void send(String topico, Producto producto){
        var future = kafkaTemplate.send(topico, producto.toString());

        future.whenComplete((resultadoEnvio, excepcion) -> {
            if(excepcion != null){
                LOGGER.error(excepcion.getMessage());
                future.completeExceptionally(excepcion);
            } else {
                future.complete(resultadoEnvio);
            }
            LOGGER.info("Producto enviado al topico de Kafka "+ producto);
        });

    }
}
