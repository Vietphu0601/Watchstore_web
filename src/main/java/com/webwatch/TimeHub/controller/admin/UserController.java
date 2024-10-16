package com.webwatch.TimeHub.controller.admin;

import com.webwatch.TimeHub.domain.Role;
import com.webwatch.TimeHub.domain.User;
import com.webwatch.TimeHub.service.IRoleService;
import com.webwatch.TimeHub.service.IUploadService;
import com.webwatch.TimeHub.service.IUserService;
import com.webwatch.TimeHub.service.impl.RoleService;
import com.webwatch.TimeHub.service.impl.UserService;
import com.webwatch.TimeHub.util.message.MessageUtil;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UserController {

    private final IUserService userService;
    private final IRoleService roleService;
    private final MessageUtil messageUtil;
    private final IUploadService uploadService;
    PasswordEncoder passwordEncoder;

    public UserController(
            UserService userService,
            RoleService roleService,
            IUploadService uploadService,
            MessageUtil messageUtil,
            PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.roleService = roleService;
        this.messageUtil = messageUtil;
        this.uploadService = uploadService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/admin/user")
    public String getUserPage(
            Model model,
            @RequestParam(defaultValue = "1", name = "page") int page,
            HttpServletRequest request) {
        if (request.getParameter("message") != null) {
            Map<String, String> message = messageUtil.getMessage(request.getParameter("message"));
            model.addAttribute("messageResponse", message.get("message"));
            model.addAttribute("alert", message.get("alert"));
        }
        Pageable pageable = PageRequest.of(page - 1, 10);
        Page<User> pageUsers = this.userService.findAll(pageable);
        List<User> users = pageUsers.getContent();
        model.addAttribute("users", users);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", pageUsers.getTotalPages());
        return "admin/user/show";
    }

    @GetMapping("/admin/user/create")
    public String getCreateUserPage(Model model) {
        List<Role> roles = roleService.findAll();
        model.addAttribute("newUser", new User());
        model.addAttribute("roles", roles);
        return "admin/user/create";
    }

    @PostMapping("/admin/user/create")
    public String createUser(
            Model model,
            @ModelAttribute("newUser") @Valid User newUser,
            BindingResult newUserBindingResult,
            @RequestParam("avatarFile") MultipartFile avatarFile) {
        // validate
        List<FieldError> errors = newUserBindingResult.getFieldErrors();
        for (FieldError error : errors) {
            System.out.println(error.getField() + " - " + error.getDefaultMessage());
        }
        if (newUserBindingResult.hasErrors()) {
            List<Role> roles = roleService.findAll();
            model.addAttribute("roles", roles);
            return "admin/user/create";
        }

        String avatar = this.uploadService.handleSaveFile(avatarFile, "avatar");
        String hashPassword = this.passwordEncoder.encode(newUser.getPassword());
        newUser.setAvatar(avatar);
        newUser.setPassword(hashPassword);
        this.userService.handleSaveUser(newUser);

        return "redirect:/admin/user";
    }

    @GetMapping("/admin/user/{id}")
    public String getUserDetailPage(
            Model model,
            @PathVariable("id") Long id) {
        User user = this.userService.findUserById(id);
        model.addAttribute("user", user);
        return "admin/user/detail";
    }

    @GetMapping("/admin/user/update/{id}")
    public String getUpdateUserPage(
            Model model,
            @PathVariable("id") long id) {
        User currentUser = this.userService.findUserById(id);
        model.addAttribute("currentUser", currentUser);
        return "admin/user/update";
    }

    @PostMapping("/admin/user/update")
    public String UpdateUser(
            Model model,
            @ModelAttribute("currentUser") User user,
            @RequestParam("avatarUpdateFile") MultipartFile avatarUpdateFile) {
        User updateUser = this.userService.findUserById(user.getId());
        if (updateUser != null) {
            String avatar = this.uploadService.handleSaveFile(avatarUpdateFile, "avatar");
            if (avatar != "") {
                updateUser.setAvatar(avatar);
            }
            updateUser.setAddress(user.getAddress());
            updateUser.setFullName(user.getFullName());
            updateUser.setPhone(user.getPhone());
            this.userService.handleSaveUser(updateUser);
        }
        return "redirect:/admin/user";
    }

    @DeleteMapping("/admin/user/delete/{userId}")
    public ResponseEntity<String> DeleteUser(@PathVariable("userId") Long id) {
        this.userService.deleteUser(id);
        return ResponseEntity.ok("User was deleted successfully");
    }
}
