# kafka-event-producer
Write page view event to kafka topic

Steps to run
1) Copy the jar "kafka.event.producer-1.0-SNAPSHOT.jar" present in target folder to your local
2) Make sure you have zookeeper, Kafka running on your local
3) Create a Kafka topic
4) Execute "java -jar kafka.event.producer-1.0-SNAPSHOT.jar <CSV_FILE_WITH_DATA> <TOPIC_NAME>"

Note - Data in csv should have 4 columns (look at attached sample csv file: viewEvent.csv)
     - Data is read from csv file, converted to json object
     - Data written to Kafka topic is in json format
