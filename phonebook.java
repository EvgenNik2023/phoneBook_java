import java.util.*;



public class phonebook {

    public static void main(String[] args) {

        HashMap<String, List<String>> phoneBook = new HashMap<>();



        // Добавляем записи в телефонную книгу

        addEntry(phoneBook, "Иванов", "123456");

        addEntry(phoneBook, "Петров", "987654");

        addEntry(phoneBook, "Сидоров", "456123");

        addEntry(phoneBook, "Иванов", "111111");

        addEntry(phoneBook, "Иванов", "222222");

        addEntry(phoneBook, "Сидоров", "789456");



        // Выводим телефонную книгу, отсортированную по убыванию числа телефонов

        printPhoneBook(phoneBook);

    }



    public static void addEntry(HashMap<String, List<String>> phoneBook, String name, String phone) {

        // Если запись с таким именем уже есть в телефонной книге,

        // то добавляем новый номер в список

        if (phoneBook.containsKey(name)) {

            List<String> phones = phoneBook.get(name);

            phones.add(phone);

        }
        else {

            // Если записи с таким именем еще нет, создаем новую запись

            List<String> phones = new ArrayList<>();

            phones.add(phone);

            phoneBook.put(name, phones);

        }

    }



    public static void printPhoneBook(HashMap<String, List<String>> phoneBook) {

        // Создаем список записей из телефонной книги

        List<Map.Entry<String, List<String>>> entries = new ArrayList<>(phoneBook.entrySet());



        // Сортируем список по убыванию числа телефонных номеров

        entries.sort((e1, e2) -> Integer.compare(e2.getValue().size(), e1.getValue().size()));



        // Выводим отсортированные записи на экран

        for (Map.Entry<String, List<String>> entry : entries) {

            String name = entry.getKey();

            List<String> phones = entry.getValue();

            System.out.println(name + ": " + phones.size() + " номер(а)");

            for (String phone : phones) {

                System.out.println(phone);

            }

            System.out.println();

        }

    }

}