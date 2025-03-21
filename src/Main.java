import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> toDoList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            menuOperatins();
            System.out.print("Ваш выбор : ");
            String input = scanner.nextLine();
            int operations = Integer.parseInt(input);

            if (operations == 0) {
                System.out.println("Программа завершена!");
                return;
            }
            switch (operations) {
                case 1:
                    System.out.print("Введите название задачи : ");
                    String caseName = scanner.nextLine();
                    toDoList.add(caseName);
                    System.out.println("Добавленно!");

                    System.out.println();
                    break;
                case 2:
                    break;
                case 3:
                    System.out.print("Введите номер для удаления: ");
                    String delete = scanner.nextLine();
                    int deleteNumber = Integer.parseInt(delete);
                    if (deleteNumber == 0 || deleteNumber > toDoList.size()) {
                        System.out.println("Нет дела с таким номером! ");
                        break;
                    } else {
                        System.out.println("Удаленно! ");
                        toDoList.remove(deleteNumber - 1);
                        break;
                    }
                case 4:
                    System.out.print("Введите текст задачи для удаления : ");
                    String deleteCase = scanner.nextLine();
                    if (toDoList.contains(deleteCase)) {
                        toDoList.remove(deleteCase);
                        System.out.println("Удаленно ! ");
                    } else {
                        System.out.println("Такого дела нет !");
                    }
                    break;
                case 5:
                    System.out.print("Введите ключевое слово для удаления задач : ");
                    String theKeyWord = scanner.nextLine();
                    ArrayList<String> copyKeyToDolist = new ArrayList<>(toDoList);
                    for (String str : copyKeyToDolist) {
                        if (str.toLowerCase().contains(theKeyWord.toLowerCase())) {
                            toDoList.remove(str);
                        }
                    }
                    System.out.println("Все возможные совпадения удаленны !");
                    break;
            }
            printingToDoList(toDoList);
        }

    }

    public static void menuOperatins() {
        System.out.println("Выберите операцию:\n");

        System.out.println("0. Выход из программы \n" +
                "1. Добавить дело \n" +
                "2. Показать дела \n" +
                "3. Удалить дело по номеру \n" +
                "4. Удалить дело по названию \n" +
                "5. Удалить дело по ключевому слову \n");
    }

    public static void printingToDoList(ArrayList<String> toDoList) {
        System.out.println("Ваш список дел! ");
        if (toDoList.isEmpty()) {
            System.out.println("Список дел пуст !");
        }
        int count = 0;
        for (int i = 0; i < toDoList.size(); i++) {
            count++;
            System.out.println(count + ". " + toDoList.get(i));
        }
        System.out.println();

    }
}
