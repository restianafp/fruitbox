package com.bootcamp.fruitbox.controller;

import com.bootcamp.fruitbox.dto.FruitDto;
import com.bootcamp.fruitbox.entity.Fruit;
import com.bootcamp.fruitbox.service.FruitService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping
public class DashboardController {

    private FruitService fruitService;

    @GetMapping("/")
    public String showDashboardPage(Model model){
        List<FruitDto> fruitList = fruitService.getAll();
        model.addAttribute("fruits", fruitList);
        return "index";
    }

    @GetMapping("delete/{id}")
    public String deleteFruitData(@PathVariable("id") Long id){
        fruitService.softDelete(id);
        return "redirect:/";
    }

    @GetMapping("input")
    public String showInputPage(Model model){
        model.addAttribute("fruit", new FruitDto());
        return "form-input";
    }

    @PostMapping("addFruit")
    public String addFruit(@ModelAttribute("fruit") FruitDto fruitDto){
        fruitService.create(fruitDto);
        return "redirect:/";
    }

    @GetMapping("edit/{id}")
    public String showEditPage(@PathVariable("id") Long id, Model model){
        FruitDto fruit = fruitService.getById(id);
        model.addAttribute("fruit", fruit);
        return "form-update";
    }

    @PostMapping("edit/{id}")
    public String editFruit(@PathVariable("id") Long id, @ModelAttribute("fruit") FruitDto fruitDto){
        fruitService.update(id, fruitDto);
        return "redirect:/";
    }
}
