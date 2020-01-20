package app.parts.controller;

import app.parts.model.Part;
import app.parts.service.PartService;
import app.parts.service.PartServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class PartsController {
    private PartService partService;
    private int page;

    @Autowired
    public void setPartService(PartService partService) {
        this.partService = partService;
    }

   /* @RequestMapping(method = RequestMethod.GET)
    public ModelAndView allParts() {
        List<Part> parts = partService.allParts();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("part");
        modelAndView.addObject("partsList", parts);
        return modelAndView;
    }*/
   //Додаємо подання по 10 записів на сторінку
   @RequestMapping(value = "/", method = RequestMethod.GET)
   public ModelAndView allFilms(@RequestParam(defaultValue = "1") int page) {
       List<Part> parts = partService.allParts(page);
       int partsCount = partService.partsCount();
       int pagesCount = (partsCount + 9)/10;
       ModelAndView modelAndView = new ModelAndView();
       modelAndView.setViewName("part");
       modelAndView.addObject("page", page);
       modelAndView.addObject("partsList", parts);
       modelAndView.addObject("partsCount", partsCount);
       modelAndView.addObject("pagesCount", pagesCount);
       this.page = page;
       //modelAndView.setViewName("redirect:/?page=" + this.page);
       return modelAndView;
   }
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView editPage(@PathVariable("id") int id) {
        Part part = partService.getById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editPage");
        modelAndView.addObject("part", part);
        return modelAndView;
    }
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public ModelAndView editFilm(@ModelAttribute("part") Part part) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");
        partService.edit(part);
        return modelAndView;
    }
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView addPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editPage");
        return modelAndView;
    }
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView addFilm(@ModelAttribute("part") Part part) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");
        partService.add(part);
        return modelAndView;
    }
    @RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
    public ModelAndView deleteFilm(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");
        Part part = partService.getById(id);
        partService.delete(part);
        return modelAndView;
    }
}
