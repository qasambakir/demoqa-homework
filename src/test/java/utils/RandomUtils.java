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

    // Генерация случайного месяца
    public static String getRandomBirthMonth() {
        String[] months = {"January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"};
        return getRandomItemFromArray(months);
    }

    // Генерация случайного года
    public static String getRandomBirthYear() {
        int year = random.nextInt(30) + 1970;  // генерируем год от 1970 до 2000
        return String.valueOf(year);
    }

    // Генерация случайного дня рождения
    public static String getRandomBirthDay() {
        return String.format("%02d", random.nextInt(28) + 1);  // день от 01 до 28, с ведущим нулем
    }

    public static String getRandomState() {
        String[] states = {"NCR", "Uttar Pradesh", "Haryana", "Rajasthan"};
        return getRandomItemFromArray(states);
    }

    public static String getRandomCity(String state) {
        switch (state) {
            case "NCR":
                String[] ncrCities = {"Delhi", "Gurgaon", "Noida"};
                return getRandomItemFromArray(ncrCities);
            case "Uttar Pradesh":
                String[] upCities = {"Agra", "Lucknow", "Merrut"};
                return getRandomItemFromArray(upCities);
            case "Haryana":
                String[] haryanaCities = {"Karnal", "Panipat"};
                return getRandomItemFromArray(haryanaCities);
            case "Rajasthan":
                String[] rajasthanCities = {"Jaipur", "Jaiselmer"};
                return getRandomItemFromArray(rajasthanCities);
            default:
                throw new IllegalArgumentException("Unknown state: " + state);
        }
    }

    // Выбор картинки
    public static String getRandomPicturePath() {
        String[] pictures = {"image.png", "image1.png", "image3.png"};
        return getRandomItemFromArray(pictures);
    }
}
