package com.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

public class ProducerWithCallback {
    private static final Logger log= LoggerFactory.getLogger(Producer.class.getSimpleName());
    public static void main(String[] args) {
        log.info("I am the producer");

        // set the property
        Properties properties=new Properties();
        properties.setProperty("bootstrap.servers","127.0.0.1:9092");
        // creating producer property
        properties.setProperty("key.serializer", StringSerializer.class.getName());
        properties.setProperty("value.serializer",StringSerializer.class.getName());

        // create producer
        KafkaProducer<String,String> producer=new KafkaProducer<>(properties);

        //create producer record
        ProducerRecord<String,String> producerRecord=
                new ProducerRecord<>("java_demo","Hello-world");

        //send data
        producer.send(producerRecord);

        //close producer
        producer.close();
    }
}
