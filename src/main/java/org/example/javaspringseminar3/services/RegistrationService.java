package org.example.javaspringseminar3.services;

import org.example.javaspringseminar3.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {
    public DataProcessingService getDataProcessingService() {
        return dataProcessingService;
    }
    public UserService getUserService() { return userService; }
    public NotificationService getNotificationService() { return notificationService; }

    @Autowired
    private DataProcessingService dataProcessingService;
    //Поля UserService, NotificationService
    @Autowired
    private UserService userService;
    @Autowired
    private NotificationService notificationService;

    //Метод processRegistration
    public void processRegistration(String name, int age, String email) {
        dataProcessingService.getRepository().getUsers().add(userService.createUser(name, age, email));
        notificationService.sendNotification("User created");
    }
}
