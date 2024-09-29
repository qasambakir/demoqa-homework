package utils;

import java.util.Random;

public class RandomUtils {

    private static final Random random = new Random();

    // Метод для случайного выбора элемента из массива
    public static String getRandomItemFromArray(String[] items) {
        int index = random.nextInt(items.length);
        return items[index];
    }

    // Генерация случайного пола
    public static String getRandomGender() {
        String[] genders = {"Male", "Female", "Other"};
        return getRandomItemFromArray(genders);
    }

    // Генерация случайного предмета
    public static String getRandomSubject() {
        String[] subjects = {"Maths", "Chemistry", "Commerce", "Economics"};
        return getRandomItemFromArray(subjects);
    }

    // Генерация Хобби
    public static String getRandomHobby() {
        String[] hobbies = {"Sports", "Reading", "Music"};
        return getRandomItemFromArray(hobbies);
    }
}
