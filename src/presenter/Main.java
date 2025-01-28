package presenter;


import org.example.models.AnimalNurseryView;
import org.example.models.AnimalRegistryService;


import java.util.Scanner;

public class Main {
    public Main(){
    }

    public static void main(String[] args){
        Scanner console = new Scanner(System.in);
        System.out.println("Реестр домашних животных");
        AnimalRegistryService animalRegistryService = new AnimalRegistryService();
        AnimalNurseryView animalNurseryView = new AnimalNurseryView();
        new AnimalPresenter(animalRegistryService,animalNurseryView);
        boolean obs = true;
        while (obs){
            System.out.println("""
                    Что желаете
                    1 - Завести новое животное
                    2 - Увидеть список команд, которое выполняет животное
                    3 - Обучить животное новым командам
                    4 - Вывести всех животных питомника
                    5 - Выйти
                    """);
            String choice = console.nextLine();
            String name_animal = null;
            String birthday = null;
            double weight = 0;
            String type_animal = null;
            String new_skill = null;
            switch (choice){
                case "1" -> {
                    System.out.println("Для этого вам необходимо ввести " +
                            "имя животного, дату его рождения " +
                            "вес животного, а также а также род животного ");
                    System.out.println("Введите имя животного: ");
                    name_animal = console.nextLine();
                    try {
                        System.out.println("Введите дату рождения животного в формате (2022-01-10): ");
                        if(console.nextLine().length() == 10){
                            birthday = console.nextLine();
                            System.out.println("Введите вес животного: ");
                            weight = Double.parseDouble(console.nextLine());
                            System.out.println("Введите род животного (Кошка Собака Хомяк Лошадь Верблюд Осёл): ");
                            type_animal = console.nextLine();
                        }
                        else {
                            System.out.println("Вы ввели не корректные данные повторите ввод");
                        }


                    }
                    catch (Exception e){
                        System.out.println("Данные введены не верно");
                    }
                    finally {
                        System.out.println("Повторите ввод");
                    }


                    animalNurseryView.getanimla(name_animal,birthday,weight,type_animal);


                }
                case "2" -> {
                    System.out.println("Введите имя животного чьи способности Вас интересуют");
                    name_animal = console.nextLine();
                    try {
                        animalRegistryService.get_command_animal(name_animal);
                    }
                    finally {
                        System.out.println("К сожалению в нашем питомнике нет такого животного");
                    }


                }
                case "3" -> {
                    System.out.println("Введите имя животного кого хотите обучить");
                    name_animal = console.nextLine();
                    System.out.println("Введите команду которой нужно обучить животное");
                    new_skill = console.nextLine();
                    try {
                        animalRegistryService.learn_command_animal(name_animal,new_skill);
                    }
                    finally {
                        System.out.println("К сожалению в нашем питомнике нет такого животного");
                    }

                }
                case "4" -> {
                    animalNurseryView.loadAnimals();
                }
                case "5" -> {
                    String by = "До свидания";
                    System.out.println("\n" + by.toUpperCase());
                    obs = false;
                }



            }

        }

    }

}