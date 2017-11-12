//package kafka;
//
//import org.apache.kafka.clients.consumer.*;
//import java.util.Arrays;
//import java.util.Properties;
//
//public class KafkaDataConsumer {
//
//    public static void main(String[] args) {
//
//        Properties props = new Properties();
//        props.put("bootstrap.servers", "localhost:9092");
//        props.put("group.id", "mygroup");
//        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
//        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
//
//        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);
//        consumer.subscribe(String.valueOf(Arrays.asList("topic4")));
//
//        boolean running = true;
//        while (running) {
//            ConsumerRecords<String, String> records = (ConsumerRecords<String, String>) consumer.poll(100);
//            for (ConsumerRecord<String, String> record : records) {
//                try {
//                    System.out.println(record.value());
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//        consumer.close();
//    }
//
//}
