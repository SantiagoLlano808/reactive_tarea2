package edu.co.reactivo.tarea2;

import edu.co.reactivo.tarea2.model.Producto;
import edu.co.reactivo.tarea2.service.KafkaProducerService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Tarea2Application implements CommandLineRunner{
	private final KafkaProducerService kafkaProducerService;

	public Tarea2Application(KafkaProducerService kafkaProducerService) {
		this.kafkaProducerService = kafkaProducerService;
	}

	public static void main(String[] args) {
		SpringApplication.run(Tarea2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception{
		producerData();
	}

	private void producerData(){
		Producto producto = new Producto(100, "Guayos Nike", "Guayos para futbol",
				true, 1, "Branchos", 300000.00, 10);
		Producto producto2 = new Producto(101, "Guayos Puma", "Guayos para futbol",
				true, 1, "Branchos", 200000.00, 12);
		String topico = "Productos-2023-8";
		kafkaProducerService.sendKey(topico, producto.getId(), producto);
		kafkaProducerService.sendKey(topico, producto2.getId(), producto2);
	}

}
