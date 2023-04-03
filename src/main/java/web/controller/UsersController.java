package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.models.Users;
import web.service.UsersService;

@Controller
@RequestMapping("/users")
public class UsersController {
    private final UsersService usersService;

    public UsersController(UsersService userService) {
        this.usersService = userService;
    }
    /*private final UsersServiceImpl usersService;
    @Autowired
    public UsersController(UsersServiceImpl usersService) {
        this.usersService = usersService;
    }*/

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
    public String create(@ModelAttribute("person")Users person) {
        usersService.save(person);
        return "redirect:/users";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("person", usersService.showid(id));
        return "edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("person") Users person, @PathVariable("id") int id) {
        usersService.update(id, person);
        return "redirect:/users";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        usersService.delete(id);
        return "redirect:/users";
    }
}
