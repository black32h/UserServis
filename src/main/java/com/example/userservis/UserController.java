package com.example.userservis;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/users")
class UserController {

    private final Map<Long, User> users = new HashMap<>(); // Імітація бази даних
    private long currentId = 1; // Лічильник для унікальних ідентифікаторів

    // Створити нового користувача
    @PostMapping
    public User createUser(@RequestBody User user) {
        user.setId(currentId++);
        users.put(user.getId(), user);
        return user;
    }

    // Отримати інформацію про користувача за ID
    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) {
        return users.getOrDefault(id, null);
    }

    // Оновити інформацію про користувача
    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User updatedUser) {
        if (users.containsKey(id)) {
            updatedUser.setId(id);
            users.put(id, updatedUser);
            return updatedUser;
        } else {
            return null; // Якщо користувача не знайдено
        }
    }

    // Видалити користувача
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {
        if (users.remove(id) != null) {
            return "Користувача видалено.";
        } else {
            return "Користувача з таким ID не знайдено.";
        }
    }
}
