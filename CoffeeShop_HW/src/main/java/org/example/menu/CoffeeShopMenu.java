package org.example.menu;

import org.example.dao.assortementDAO.AssortementDaoImpl;
import org.example.dao.clientDAO.ClientDaoImpl;
import org.example.dao.personalDAO.PersonalDaoImpl;
import org.example.dao.personalPositionDAO.PersonalPositionDaoImpl;
import org.example.dao.typeAssortementDAO.TypeAssortementDaoImpl;
import org.example.model.*;
import org.example.service.busines.assortement.AssortementService;
import org.example.service.busines.assortement.AssortementServiceImpl;
import org.example.service.busines.client.ClientService;
import org.example.service.busines.client.ClientServiceImpl;
import org.example.service.busines.personal.PersonalService;
import org.example.service.busines.personal.PersonalServiceImpl;
import org.example.service.busines.personalPosition.PersonalPositionService;
import org.example.service.busines.personalPosition.PersonalPositionServiceImpl;
import org.example.service.busines.typeAssortement.TypeAssortementService;
import org.example.service.busines.typeAssortement.TypeAssortementServiceImpl;
import org.example.utils.Input;
import org.example.utils.TestUtils;

import java.time.LocalDate;
import java.util.List;

public class CoffeeShopMenu {
    private static TypeAssortementService typeAssortementService;
    private static AssortementService assortementService;
    private static ClientService clientService;
    private static PersonalPositionService personalPositionService;
    private static PersonalService personalService;

    static {
        typeAssortementService = new TypeAssortementServiceImpl(new TypeAssortementDaoImpl());
        assortementService = new AssortementServiceImpl(new AssortementDaoImpl());
        clientService = new ClientServiceImpl(new ClientDaoImpl());
        personalPositionService = new PersonalPositionServiceImpl(new PersonalPositionDaoImpl());
        personalService = new PersonalServiceImpl(new PersonalDaoImpl());
    }


    public void show() {
        System.out.println("CoffeeShop menu:");
        ShowMenu.show();
    }

    public int getChoice() {
        int maxChoice = ShowMenu.getSizeMenu();
        return Input.inputInteger(
                "\nPlease enter the number menu: ",
                "Invalid choice, need from " + ShowMenu.MIN_MENU_NUM + " to " + maxChoice,
                ShowMenu.MIN_MENU_NUM,
                maxChoice
        );
    }

    public boolean execute(int choiceMenu) {
        switch (choiceMenu) {
            case 1:
                menuItem1Execute();
                break;

            case 2:
                menuItem2Execute();
                break;

            case 3:
                menuItem3Execute();
                break;

            case 4:
                menuItem4Execute();
                break;

            case 5:
                menuItem5Execute();
                break;

            case 6:
                menuItem6Execute();
                break;

            case 7:
                menuItem7Execute();
                break;

            case 8:
                menuItem8Execute();
                break;

            case 9:
                menuItem9Execute();
                break;

            case 10:
                menuItem10Execute();
                break;

            case 11:
                menuItem11Execute();
                break;

            case 12:
                menuItem12Execute();
                break;

            case 13:
                menuItem13Execute();
                break;

            case 14:
                menuItem14Execute();
                break;

            case 15:
                menuItem15Execute();
                break;

            default:
                return false;
        }
        return true;
    }


    public static void menuItem1Execute() {
        // Добавление ассортимента

        String nameEn = Input.inputString(
                "Введите название на англ: ",
                "Не должно быть пустой..."
        );
        String nameRu = Input.inputString(
                "Введите название на рус: ",
                "Не должно быть пустой..."
        );

        double minPrice = 10;
        double maxPrice = 100000;
        double price = Input.inputDouble(
                "Введите цену: ",
                "Цена от " + minPrice + " до " + maxPrice + "...",
                minPrice,
                maxPrice
        );

        List<TypeAssortement> types = typeAssortementService.getAllTypeAssortement();
        types.forEach(t -> System.out.println(t.getId() + " - " + t.getName()));
        int minId = 1;
        int maxId = 100000;
        int idTypeAssortement = Input.inputInteger(
                "Введите id вида ассортимента: ",
                "Id от " + minId + " до " + maxId + "...",
                minId, maxId
        );

        try {
            Assortement assortement = new Assortement(0, nameEn, nameRu, price, idTypeAssortement);
            assortementService.addAssortement(assortement);
            System.out.println("Ассортимент успешно добавлен!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void menuItem2Execute() {
        // Добавление бариста
        addPersonal("Бариста");
    }

    public static void menuItem3Execute() {
        // Добавление кондитера
        addPersonal("Кондитер");
    }

    public static void menuItem4Execute() {
        // Добавление клиента

        String name = Input.inputString("Введите имя: ", "Не должно быть пустым...");
        String surname = Input.inputString("Введите фамилию: ", "Не должно быть пустым...");
        String patronymic = Input.inputString("Введите отчество: ", "Не должно быть пустым...");

        System.out.println("Дата рождения:");
        int day = Input.inputInteger(
                "Введите число: ",
                "Неверный ввод, нужно от 1 до 31",
                1, 31
        );
        int month = Input.inputInteger(
                "Введите месяц: ",
                "Неверный ввод, нужно от 1 до 12",
                1, 12
        );
        int year = Input.inputInteger(
                "Введите год: ",
                "Неверный ввод, нужно от 1900 до " + (TestUtils.CURRENT_YEAR - 10),
                1, (TestUtils.CURRENT_YEAR - 10)
        );
        LocalDate birthday = LocalDate.of(year, month, day);

        String numTel = Input.inputString("Введите номер телефона: ", "Не должно быть пустым...");
        String email = Input.inputString("Введите email: ", "Не должно быть пустым...");
        int discount = Input.inputInteger(
                "Введите скидку: ",
                "Неверный ввод, нужно от 1 до 10",
                1, 10
        );

        try {
            Client client = new Client(0, name, surname, patronymic, birthday, numTel, email, discount);
            clientService.addClient(client);
            System.out.println("Клиент успешно добавлен!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void menuItem5Execute() {
        // Изменить email кондитеру

        List<Personal> personals = personalService.getPersonalsByPosition("Кондитер");
        personals.forEach(p -> System.out.println(p.getId() + " - " + p.getName() + " - " + p.getEmail()));

        Personal personal = getPersonalByInputId();
        if (personal == null) {
            return;
        }

        String email = Input.inputString("Введите email: ", "Не должно быть пустым...");

        try {
            personalService.updatePersonalEmail(personal, email);
            System.out.println("Email кондитера успешно изменён!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void menuItem6Execute() {
        // Изменить номер тел баристу

        List<Personal> personals = personalService.getPersonalsByPosition("Бариста");
        personals.forEach(p -> System.out.println(p.getId() + " - " + p.getName() + " - " + p.getNumTel()));

        Personal personal = getPersonalByInputId();
        if (personal == null) {
            return;
        }

        String numTel = Input.inputString("Введите номер тел: ", "Не должен быть пустым...");

        try {
            personalService.updatePersonalNumTel(personal, numTel);
            System.out.println("Номер тел баристы успешно изменён!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void menuItem7Execute() {
        // Изменить скидку клиента

        List<Client> clients = clientService.getAllClients();
        clients.forEach(c -> System.out.println(c.getId() + " - " + c.getName() + " - " + c.getDiscount()));

        int idClient = getInputId("Введите id клиента: ");
        Client client = clientService.getClientById(idClient);

        int discount = Input.inputInteger(
                "Введите скидку: ",
                "Неверный ввод, нужно от 1 до 10",
                1, 10
        );

        try {
            clientService.updateClientDiscount(client, discount);
            System.out.println("Скидка клиента успешно изменена!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void menuItem8Execute() {
        // Удалить десерт

        List<Assortement> assortements = assortementService.getAssortementsByType("Десерт");
        assortements.forEach(a -> System.out.println(a.getId() + " - " + a.getNameRu() + " - " + a.getPrice()));

        int idAssortement = getInputId("Введите id ассортимента: ");

        String text = assortementService.deleteAssortementById(idAssortement)
                ? "Десерт успешно удалён!"
                : "При удалении десерта, что-то пошло не так...";
        System.out.println(text);
    }

    public static void menuItem9Execute() {
        // Удалить официанта
        deletePersonalByPosition("Официант");
    }

    public static void menuItem10Execute() {
        // Удалить бариста
        deletePersonalByPosition("Бариста");
    }

    public static void menuItem11Execute() {
        // Удалить клиента

        List<Client> clients = clientService.getAllClients();
        clients.forEach(c -> System.out.println(c.getId() + " - " + c.getName() + " - " + c.getDiscount()));

        int idClient = getInputId("Введите id клиента: ");

        String text = clientService.deleteClientById(idClient)
                ? "Клиент успешно удалён!"
                : "При удалении клиента, что-то пошло не так...";
        System.out.println(text);
    }

    public static void menuItem12Execute() {
        // Вывод напитков
        List<Assortement> assortements = assortementService.getAssortementsByType("Напиток");
        assortements.forEach(System.out::println);
    }

    public static void menuItem13Execute() {
        // Вывод десертов
        List<Assortement> assortements = assortementService.getAssortementsByType("Десерт");
        assortements.forEach(System.out::println);
    }

    public static void menuItem14Execute() {
        // Вывод баристов
        List<Personal> personals = personalService.getPersonalsByPosition("Бариста");
        personals.forEach(System.out::println);
    }

    public static void menuItem15Execute() {
        // Вывод официантов
        List<Personal> personals = personalService.getPersonalsByPosition("Официант");
        personals.forEach(System.out::println);
    }


    private static void addPersonal(String positionName) {
        // информация о персонале
        String name = Input.inputString("Введите имя: ", "Не должно быть пустым...");
        String surname = Input.inputString("Введите фамилию: ", "Не должно быть пустым...");
        String patronymic = Input.inputString("Введите отчество: ", "Не должно быть пустым...");
        String numTel = Input.inputString("Введите номер телефона: ", "Не должно быть пустым...");
        String email = Input.inputString("Введите email: ", "Не должно быть пустым...");

        // получение id позиции
        int idPosition = personalPositionService.getPersonalPositionByName(positionName).getId();

        try {
            Personal personal = new Personal(0, name, surname, patronymic, numTel, email, idPosition);
            personalService.addPersonal(personal);
            System.out.println("Персонал '" + positionName + "' успешно добавлен!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static int getInputId(String text) {
        int minId = 1;
        int maxId = 100000;
        return Input.inputInteger(
                text,
                "Id от " + minId + " до " + maxId + "...",
                minId, maxId
        );
    }

    private static Personal getPersonalByInputId() {
        int idPersonal = getInputId("Введите id кондитера: ");

        Personal personal = personalService.getPersonalById(idPersonal);
        if (personal == null) {
            System.out.println("Бариста не найден...");
            return null;
        }

        return personal;
    }

    private static void deletePersonalByPosition(String position) {
        List<Personal> personals = personalService.getPersonalsByPosition(position);
        personals.forEach(p -> System.out.println(p.getId() + " - " + p.getName() + " - " + p.getNumTel()));

        int idPersonal = getInputId("Введите id " + position.toLowerCase() + ": ");

        String text = personalService.deletePersonalById(idPersonal)
                ? position + " успешно удалён по причине увольнения!"
                : "При удалении " + position.toLowerCase() + ", что-то пошло не так...";
        System.out.println(text);
    }
}
