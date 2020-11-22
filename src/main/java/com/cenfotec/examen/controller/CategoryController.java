package com.cenfotec.examen.controller;

import com.cenfotec.examen.domain.Category;
import com.cenfotec.examen.service.category.CategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Optional;

@Controller
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @RequestMapping("/")
    public String home(Model model){
        return "index";
    }

    @RequestMapping(value = "/registra_categorias",  method = RequestMethod.GET)
    public String insertarPage(Model model) {
        model.addAttribute(new Category());
        return "registra_categorias";
    }

    @RequestMapping(value = "/registra_categorias",  method = RequestMethod.POST)
    public String insertarCategory(Category category, BindingResult result, Model model) {
        categoryService.save(category);
        return "index";
    }

    @RequestMapping("/lista_categorias")
    public String listar(Model model) {
        model.addAttribute("categories",categoryService.getAll());
        return "lista_categorias";
    }

    @RequestMapping("/editar_categorias/{id}")
    public String buscarCategoryId(Model model, @PathVariable long id) {
        Optional<Category> possibleData = categoryService.get(id);
        if (possibleData.isPresent()) {
            model.addAttribute("categoryToEdit",possibleData.get());
            return "editar_categorias";
        }
        return "notfound";
    }

    @RequestMapping(value="/editar_categorias/{id}",  method = RequestMethod.POST)
    public String salvarCategoryEdit(Category category, Model model, @PathVariable long id) {
        categoryService.save(category);
        return "index";
    }


}
