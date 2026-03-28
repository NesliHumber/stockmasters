package com.stockmasters.app.controller;

import com.stockmasters.app.model.User;
import com.stockmasters.app.repository.UserRepository;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin") // 🔥 cleaner base path
public class AdminController {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AdminController(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    // =========================
    // ✅ DASHBOARD
    // =========================
    @GetMapping("/dashboard")
    public String adminDashboard(Model model) {

        long totalUsers = userRepository.count();
        model.addAttribute("totalUsers", totalUsers);

        return "admin-dashboard"; // your file name
    }

    // =========================
    // ✅ LIST USERS
    // =========================
    @GetMapping("/users")
    public String usersPage(Model model) {

        model.addAttribute("users", userRepository.findAll());

        return "admin-users"; // your file name
    }

    // =========================
    // ✅ SHOW ADD FORM
    // =========================
    @GetMapping("/users/add")
    public String showAddUserForm(Model model) {

        model.addAttribute("user", new User());

        return "admin-add-user"; // create this HTML
    }

    // =========================
    // ✅ SAVE NEW USER
    // =========================
    @PostMapping("/users/add")
    public String addUser(@ModelAttribute User user) {

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);

        return "redirect:/admin/users";
    }

    // =========================
    // ✅ SHOW EDIT FORM
    // =========================
    @GetMapping("/users/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {

        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user ID"));

        model.addAttribute("user", user);

        return "amin-edit-user"; // create this HTML
    }

    // =========================
    // ✅ UPDATE USER
    // =========================
    @PostMapping("/users/edit/{id}")
    public String updateUser(@PathVariable Long id, @ModelAttribute User updatedUser) {

        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user ID"));

        existingUser.setUsername(updatedUser.getUsername());
        existingUser.setRole(updatedUser.getRole());

        userRepository.save(existingUser);

        return "redirect:/admin/users";
    }

    // =========================
    // ✅ DELETE USER
    // =========================
    @GetMapping("/users/delete/{id}")
    public String deleteUser(@PathVariable Long id) {

        userRepository.deleteById(id);

        return "redirect:/admin/users";
    }
}