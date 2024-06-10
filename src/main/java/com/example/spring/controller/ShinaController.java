package com.example.spring.controller;

import com.example.spring.model.*;
import com.example.spring.service.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.Console;
import java.time.LocalTime;
import java.util.*;


@RequestMapping("/")
@AllArgsConstructor
@RestController
//@CrossOrigin(origins = "http://localhost:3000/")
public class ShinaController {

    private ОбъемService объемService;
    private ПоставщикиService поставщикиService;
    private ИнформацияОТовареService информацияОТовареService;
    private ПользовательService пользовательService;
    private КонтактноеЛицоService контактноеЛицоService;
    private КлиентService клиентService;
    private final PasswordEncoder passwordEncoder;
    private ЗаказService заказService;
    private СоставЗаказаService составЗаказаService;
    private СпособДоставкиService способДоставкиService;

    @PostMapping("/orders")
    public ResponseEntity<Map<String, Object>> createOrder(@RequestBody Map<String, Object> orderData) {
        // Получение списка товаров в корзине из переданных данных
        List<Map<String, Object>> cartItems = (List<Map<String, Object>>) orderData.get("items");
        Map<String, Object> response = new HashMap<>();
        System.out.println(orderData);
        // Вывод информации о товарах в корзине в консоль
        for (Map<String, Object> item : cartItems) {
            System.out.println("Товар: " + item.get("productId") + ", Количество: " + item.get("quantity"));
        }
        System.out.println("Код_клиента" + orderData.get("clientCode"));
        // Получение данных из JSON
        try {
            int clientCode = (int) orderData.get("clientCode");
            String paymentStatus = (String) orderData.get("paymentStatus");
            String deliveryAddress = (String) orderData.get("deliveryAdress");
            String deliveryStatus = (String) orderData.get("deliveryStatus");
            String deliveryTimeFrom = (String) orderData.get("deliveryTimeFrom");
            String deliveryTimeTo = (String) orderData.get("deliveryTimeTo");

            // Сохранение способа доставки в базу данных
            СпособДоставки deliveryMethod = new СпособДоставки();
            deliveryMethod.setНазваниеСпособа(deliveryStatus);
            deliveryMethod.setАдресДоставки(deliveryAddress);
            deliveryMethod.setУдобноеВремяПолученияНачало(LocalTime.parse(deliveryTimeFrom));
            deliveryMethod.setУдобноеВремяПолученияКонец(LocalTime.parse(deliveryTimeTo));
            способДоставкиService.saveСпособДоставки(deliveryMethod);

            // Сохранение заказа
            Заказ order = new Заказ();
            order.setField(клиентService.findById(clientCode));
            order.setField1(deliveryMethod);
            order.setСтатусОплаты(paymentStatus);
            заказService.saveЗаказ(order);

            // Сохранение состава заказа
            for (Map<String, Object> item : cartItems) {
                СоставЗаказа orderItem = new СоставЗаказа();
                orderItem.setКодЗаказа(order);
                orderItem.setКодИнформацииОТоваре(информацияОТовареService.findById((int) item.get("productId")));
                orderItem.setКоличество((int) item.get("quantity"));
                составЗаказаService.saveСоставЗаказа(orderItem);
            }

            response.put("message", "Order created successfully");
            return ResponseEntity.ok(response);
        }
        catch (Exception e) {
            response.put("error", "Order not create");
            return ResponseEntity.internalServerError().body(response);
        }
    }
    @PostMapping("lk")
    public ResponseEntity<Map<String, Object>> updateLk(@RequestBody Map<String, Object> lkData) {
        try {
            int clientCode = (int) lkData.get("clientId");



            String firm = (String) lkData.get("firm");
            String mainOrganization = (String) lkData.get("main_organization");
            String inn = (String) lkData.get("inn");
            String kpp = (String) lkData.get("kpp");
            String address = (String) lkData.get("adress");
            String region = (String) lkData.get("region");
            String companyFormUR = (String) lkData.get("companyFormUR");
            String companyFormIP = (String) lkData.get("companyFormIP");
            String clientSurname = (String) lkData.get("client_surname");
            String clientName = (String) lkData.get("client_name");
            String clientPatronymic = (String) lkData.get("client_patronymic");
            String phoneNumber = (String) lkData.get("phone_number");
            String email = (String) lkData.get("email");

                клиентService.updateКлиент(clientCode, firm, mainOrganization, inn, kpp, address, region, companyFormUR, companyFormIP,
                        clientSurname, clientName, clientPatronymic, phoneNumber, email);


            Map<String, Object> response = new HashMap<>();
            response.put("message", "Client information updated successfully");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            Map<String, Object> response = new HashMap<>();
            response.put("error", "Error updating client information");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }
    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(@RequestBody LoginRequest loginRequest){
            System.out.println(loginRequest.getUsername() + "  " + loginRequest.getPassword());
            Optional<Пользователь> user = пользовательService.findByЛогин(loginRequest.getUsername());
            if (user != null && passwordEncoder.matches(loginRequest.getPassword(), user.get().getПароль())) {
                Клиент client = клиентService.findByПользователь(user.get());
                System.out.println(client.getField3().getИмя());
                System.out.println(user.get().getId());
                System.out.println(client.getId());
                Map<String, Object> response = new HashMap<>();
                response.put("id", client.getId());
                response.put("company", client.getНаименование());
                response.put("companyForm", client.getField1());
                response.put("companyMain", client.getField());
                response.put("inn", client.getИнн());
                response.put("kpp", client.getКпп());
                response.put("name", client.getField3().getИмя());
                response.put("surname", client.getField3().getФамилия());
                response.put("otche", client.getField3().getОтчество());
                response.put("email", client.getField3().getEmail());
                response.put("phone", client.getField3().getТелефон());
                response.put("region", client.getРегион());
                response.put("adres", client.getАдрес());

                return ResponseEntity.ok(response);


            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
            }

    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody RegistrationData registrationData) {
        try {
            if (пользовательService.existsByЛогин(registrationData.getLogin())) {
                return ResponseEntity.badRequest().body("Данный логин уже занят");
            }
            // Создание сущности Пользователь
            Пользователь пользователь = new Пользователь();
            пользователь.setЛогин(registrationData.getLogin());
            пользователь.setПароль(passwordEncoder.encode(registrationData.getPassword()));
            пользователь.setНазваниеРоли("Пользователь");
            Пользователь savedПользователь = пользовательService.saveПользователь(пользователь);

            // Создание сущности КонтактноеЛицо
            КонтактноеЛицо контактноеЛицо = new КонтактноеЛицо();
            контактноеЛицо.setФамилия(registrationData.getLastName());
            контактноеЛицо.setИмя(registrationData.getFirstName());
            контактноеЛицо.setОтчество(registrationData.getPatronymic() == "" ? null : registrationData.getPatronymic());
            контактноеЛицо.setEmail(registrationData.getEmail());
            контактноеЛицо.setТелефон(registrationData.getPhone());
            КонтактноеЛицо savedКонтактноеЛицо = контактноеЛицоService.saveКонтактноеЛицо(контактноеЛицо);

            // Создание сущности Клиент
            Клиент клиент = new Клиент();
            клиент.setАдрес(registrationData.getAddress());
            клиент.setНаименование(registrationData.getCompanyName());
            клиент.setИнн(registrationData.getInn());
            клиент.setКпп(registrationData.getKpp());
            клиент.setРегион(registrationData.getRegion());
            клиент.setПользователь(savedПользователь);
            клиент.setField1(registrationData.isCompany() ? "Юрлицо" : "Физлицо");
            клиент.setField(registrationData.isCompany() ? registrationData.getCompanyName() : registrationData.getMainCompany());
            клиент.setField3(savedКонтактноеЛицо);
            клиентService.saveКлиент(клиент);

            return ResponseEntity.ok("Регистрация прошла успешно");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Ошибка при регистрации: " + e.getMessage());
        }
    }

    @Getter
    @Setter
    static class RegistrationData {
        private String login;
        private String password;
        private String companyName;
        private String address;
        private String region;
        private String inn;
        private Integer kpp;
        private String lastName;
        private String firstName;
        private String patronymic;
        private String email;
        private String phone;
        private boolean isCompany;
        private String mainCompany;
    }

    @Getter
    @Setter
    public static class LoginRequest {
        private String username;
        private String password;
    }

    @GetMapping("/data")
    public List<Object[]> getProductInfo(Model model) {
        return информацияОТовареService.findAllWithName();
    }
}

