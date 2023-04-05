package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import web.models.Users;
import web.service.UsersService;

import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UsersController {
    private final UsersService usersService;

    public UsersController(UsersService userService) {
        this.usersService = userService;
    }

    @GetMapping()
    public String show(Model User) {
        User.addAttribute("users", usersService.show());
        return "users";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("person", usersService.showid(id));
        return "show";
    }

    @GetMapping("/new")
    public String newPerson(@ModelAttribute("person") Users person) {
        return "new";
    }

    @PostMapping()
    public String create(@ModelAttribute("person") @Valid Users person,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "/new";
        usersService.save(person);
        return "redirect:/users";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("person", usersService.showid(id));
        return "edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("person") @Valid Users person,
                         BindingResult bindingResult, @PathVariable("id") int id) {
        if (bindingResult.hasErrors())
            return "/edit";
        usersService.update(id, person);
        return "redirect:/users";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        usersService.delete(id);
        return "redirect:/users";
    }
}
