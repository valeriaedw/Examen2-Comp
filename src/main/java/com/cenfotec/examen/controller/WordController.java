package com.cenfotec.examen.controller;

import com.cenfotec.examen.domain.WorkShop;
import com.cenfotec.examen.service.workshop.WorkShopService;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@RestController
@RequestMapping("/report/{id}")
public class WordController{
    @Autowired
    WorkShopService workShopService;

    @GetMapping
    public void getGeneratedDocument(HttpServletResponse response, @PathVariable long id) throws IOException {
        response.setHeader("Content-disposition","attachment; filename=test.docx");

        Optional<WorkShop> workShopData = workShopService.get(id);
        if (workShopData.isPresent()){
            WorkShop workshop = workShopData.get();
            XWPFDocument document = new XWPFDocument();

            XWPFParagraph body = document.createParagraph();
            XWPFRun bodyRun = body.createRun();
            bodyRun.setText("Taller: "+ workshop.getName()+ "\n"+"Autor: "+ workshop.getAutor()+"\nObjetivo: "+workshop.getObjetivo()+
                    "\nCategoria: "+ workshop.getCategory().getName()+"\nPalabras clave: "+workshop.getKeyword1() + " " +workshop.getKeyword2()+
                    " "+workshop.getKeyword3() + "\nActividades: " + workshop.getActivity().toString());

            document.write(response.getOutputStream());



        }

    }


}
