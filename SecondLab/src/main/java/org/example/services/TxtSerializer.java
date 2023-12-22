package org.example.services;


import model.Bird;
import model.Fish;
import model.Reptile;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TxtSerializer<T> implements Serializer<T> {
    @Override
    public void serialize(T entity, String filename) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write(convertToTxt(entity));
        }
    }

    private String convertToTxt(T entity) {
        if (entity instanceof Bird bird) {
            return String.format("Bird: name=%s, age=%d, sex=%s, wingspan=%s, beakType=%s\n",
                    bird.getName(),bird.getAge(), bird.getSex(), bird.getWingspan(), bird.getBeakType());
        }

        else if (entity instanceof Fish fish) {
            return String.format("Fish: name=%s, age=%d, sex=%s, scaleType=%s, swimmingSpeed=%d\n",
                    fish.getName(),fish.getAge(), fish.getSex(), fish.getScaleType(), fish.getSwimmingSpeed());
        }

        else if (entity instanceof Reptile reptile) {
            return String.format("Reptile: name=%s, age=%d, sex=%s, scaleType=%s, tailLength=%d\n",
                    reptile.getName(),reptile.getAge(), reptile.getSex(), reptile.getScaleType(), reptile.getTailLength());
        }

        throw new RuntimeException("The instance must be Bird, Fish or Reptile" );
    }


    @Override
    public T deserialize(String filename, Class<T> entityType) throws IOException {
        String content = new String(Files.readAllBytes(Path.of(filename)));
        return convertFromTxt(content, entityType);
    }

    private T convertFromTxt(String content, Class<T> entityType) {
        if (entityType == Bird.class) {
            return (T) convertBirdFromTxt(content);
        } else if (entityType == Fish.class) {
            return (T) convertFishFromTxt(content);
        } else if (entityType == Reptile.class) {
            return (T) convertReptileFromTxt(content);
        }

        return null;
    }

    private Bird convertBirdFromTxt(String content) {
        Pattern pattern = Pattern.compile("Bird: name=(.*), age=(\\d+), sex=(.*), wingspan=(.*), beakType=(.*)");

        Matcher matcher = pattern.matcher(content);

        if (matcher.find()) {
            String name = matcher.group(1);
            int age = Integer.parseInt(matcher.group(2));
            String sex = matcher.group(3);
            int wingspan = Integer.parseInt(matcher.group(4));
            String beakType = matcher.group(5);

            return new Bird(name, age, sex, wingspan, beakType);
        }

        throw new RuntimeException("Incorrect representation of class Bird");

    }

    private Fish convertFishFromTxt(String content) {
        Pattern pattern = Pattern.compile("Fish: name=(.*), age=(\\d+), sex=(.*), scaleType=(.*), swimmingSpeed=(\\d+)");
        Matcher matcher = pattern.matcher(content);

        if (matcher.find()) {
            String name = matcher.group(1);
            int age = Integer.parseInt(matcher.group(2));
            String sex = matcher.group(3);
            String scaleType = matcher.group(4);
            int swimmingSpeed = Integer.parseInt(matcher.group(5));

            return new Fish(name, age, sex, scaleType, swimmingSpeed);
        }
        throw new RuntimeException("Incorrect representation of class Fish");
    }

    private Reptile convertReptileFromTxt(String content) {
        Pattern pattern = Pattern.compile("Reptile: name=(.*), age=(\\d+), sex=(.*), scaleType=(.*), tailLength=(\\d+)");
        Matcher matcher = pattern.matcher(content);

        if (matcher.find()) {
            String name = matcher.group(1);
            int age = Integer.parseInt(matcher.group(2));
            String sex = matcher.group(3);
            String scaleType = matcher.group(4);
            int tailLength = Integer.parseInt(matcher.group(5));

            return new Reptile(name, age, sex, scaleType, tailLength);
        }
        throw new RuntimeException("Incorrect representation of class Reptile");
    }
}
