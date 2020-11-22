package com.cenfotec.examen.controller;

import com.cenfotec.examen.domain.Category;
import com.cenfotec.examen.domain.WorkShop;
import com.cenfotec.examen.service.category.CategoryService;
import com.cenfotec.examen.service.workshop.WorkShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Optional;

@Controller
public class WorkShopController {
    @Autowired
    WorkShopService workShopService;
    @Autowired
    CategoryService categoryService;

    @RequestMapping(value = "/registra_workshops",  method = RequestMethod.GET)
    public String insertarPage(Model model) {
        model.addAttribute(new WorkShop());

        List<Category> list = categoryService.getAll();
        model.addAttribute("category",list);
        return "registra_workshops";
    }

    @RequestMapping(value = "/registra_workshops",  method = RequestMethod.POST)
    public String insertarWorkshop(WorkShop workShop,BindingResult result, Model model) {

        workShopService.save(workShop);
        return "index"; //PONERLE HOME
    }

    @RequestMapping("/lista_workshops")
    public String listar(Model model) {
        model.addAttribute("workshops",workShopService.getAll());
        return "lista_workshops";
    }

    @RequestMapping("/editar_workshops/{id}")
    public String buscarWorkshop(Model model, @PathVariable long id) {
        Optional<WorkShop> possibleData = workShopService.get(id);
        List<Category> list = categoryService.getAll();
        model.addAttribute("category",list);
        if (possibleData.isPresent()) {
            model.addAttribute("workShopToEdit",possibleData.get());
            return "editar_workshops";
        }
        return "notfound";
    }

    @RequestMapping(value="/editar_workshops/{id}",  method = RequestMethod.POST)
    public String salvarWorshopEdit(WorkShop workShop, Model model, @PathVariable long id) {
        workShopService.save(workShop);
        return "index";
    }

    @RequestMapping(value="/detalle_workshop/{id}")
    public String verActividad(Model model, @PathVariable long id) {
        Optional<WorkShop> possibleData = workShopService.get(id);
        if (possibleData.isPresent()) {
            model.addAttribute("workShopData",possibleData.get());
            return "detalle_workshop";
        }
        return "notfound";
    }

    @GetMapping("/lista_workshop_categoria")
    public String listarCategoria(Model model,String category) {

        if(category != null){
            model.addAttribute("workshops",workShopService.findByCategory(category));
        }else{
            model.addAttribute("workshops",workShopService.getAll());
        }

        return "lista_workshop_categoria";
    }

    @GetMapping("/lista_workshop_autor")
    public String listarAutor(Model model,String autor) {

        if(autor != null){
            model.addAttribute("workshops",workShopService.findByAutor(autor));
        }else{
            model.addAttribute("workshops",workShopService.getAll());
        }

        return "lista_workshop_autor";
    }

    @GetMapping("/lista_workshop_keyword")
    public String listarKeyword(Model model,String keyword) {

        if(keyword != null){
            model.addAttribute("workshops",workShopService.findByKeyword(keyword));
        }else{
            model.addAttribute("workshops",workShopService.getAll());
        }

        return "lista_workshop_keyword";
    }




}
