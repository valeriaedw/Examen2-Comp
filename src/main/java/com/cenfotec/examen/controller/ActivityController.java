package com.cenfotec.examen.controller;

import com.cenfotec.examen.domain.Activity;
import com.cenfotec.examen.service.activity.ActivityService;
import com.cenfotec.examen.service.workshop.WorkShopService;
import com.cenfotec.examen.domain.WorkShop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.time.LocalTime;
import java.util.Optional;

@Controller
public class ActivityController {
    @Autowired
    ActivityService activityService;
    @Autowired
    WorkShopService workShopService;

    @RequestMapping(value="/registra_actividades/{id}")
    public String recoverForAddActivity(Model model, @PathVariable long id) {
        Optional<WorkShop> workShop = workShopService.get(id);
        Activity newActivity = new Activity();
        if (workShop.isPresent()) {
            newActivity.setWorkshop(workShop.get());
            model.addAttribute("workshop",workShop.get());
            model.addAttribute("activity",newActivity);
            return "registra_actividades";
        }
        return "notfound";
    }

    @RequestMapping(value="/registra_actividades/{id}", method = RequestMethod.POST)
    public String saveActivity(Activity activity, Model model, @PathVariable long id) {
        Optional<WorkShop> workShop = workShopService.get(id);
        if (workShop.isPresent()) {
            LocalTime total = sumaDuracion(workShop.get().getDuracionTotal(), activity.getHour());

            workShop.get().setDuracionTotal(total);
            workShopService.save(workShop.get());

            activity.setWorkshop(workShop.get());
            activityService.save(activity);
            return "index";
        }
        return "notfound";
    }

    private LocalTime sumaDuracion(LocalTime duracionActual, LocalTime newTime){
        Integer actualHour = duracionActual.getHour();
        Integer actualMinute = duracionActual.getMinute();
        Integer newHour = newTime.getHour();
        Integer newMinute = newTime.getMinute();

        Integer hour = actualHour += newHour;
        Integer minute = actualMinute += newMinute;

        return LocalTime.of(hour,minute);
    }
}
