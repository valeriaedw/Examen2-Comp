package com.cenfotec.examen.controller;


import com.cenfotec.examen.domain.Category;
import com.cenfotec.examen.domain.WorkShop;
import com.cenfotec.examen.service.workshop.WorkShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class JsonController {
    @Autowired
    WorkShopService workshopservice;

    @RequestMapping(value = "/datatable_list", method = RequestMethod.GET)
    public List<WorkShop> list (Model model) {
        return workshopservice.getAll();


    }




}
