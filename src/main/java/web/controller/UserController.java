package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.User;
import web.service.UserService;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String showAllUsers(Model model) {
        model.addAttribute("users", userService.showAllUsers());
        return "users";
    }

    @PostMapping("/addUser")
    public String addUser(
            @RequestParam("name") String name,
            @RequestParam("lastname") String lastName,
            @RequestParam("age") Integer age) {

        User user = new User(name, lastName, age);
        userService.save(user);
        return "redirect:/";
    }

    @GetMapping("/editUser")
    public String editUser(@RequestParam("id") Long id, Model model) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "editUser";
    }

    @PostMapping("/updateUser")
    public String updateUser(
            @RequestParam("id") Long id,
            @RequestParam("name") String name,
            @RequestParam("lastname") String lastName,
            @RequestParam("age") Integer age) {

        User user = userService.getUserById(id);
        if (user != null) {
            user.setName(name);
            user.setLastName(lastName);
            user.setAge(age);
            userService.update(user);
        }
        return "redirect:/";
    }

    @GetMapping("/deleteUser")
    public String deleteUser(@RequestParam("id") Long id) {
        User user = userService.getUserById(id);
        if (user != null) {
            userService.delete(user);
        }
        return "redirect:/";
    }
}