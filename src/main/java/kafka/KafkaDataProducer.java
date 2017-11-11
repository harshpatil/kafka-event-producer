package kafka;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Properties;

public class KafkaDataProducer {

    public static void main(String[] args) throws Exception {

        Properties properties = new Properties();
        properties.put("bootstrap.servers", "localhost:9092");
        properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        KafkaProducer<String, String> producer = new KafkaProducer<>(properties);

        String csvFile = args[0];
        BufferedReader bufferedReader = null;
        String line = "";
        try {
            bufferedReader = new BufferedReader(new FileReader(csvFile));
            while ((line = bufferedReader.readLine()) != null) {

                String[] field = line.split(",");
                ViewEvent viewEvent = new ViewEvent(field[0], field[1], field[2], field[3]);
                ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
                String jsonObject = ow.writeValueAsString(viewEvent);
                ProducerRecord<String, String> record = new ProducerRecord(args[1], jsonObject);
                producer.send(record);
            }
            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            producer.close();
            bufferedReader.close();
        }
        producer.close();
    }
}
