package com.laowang.controller;

import com.laowang.pojo.Account;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
public class UserController {

   // @RequestMapping("/add")
    @RequestMapping(value = "/add",method = RequestMethod.GET)
    public String add(){
        return "user/add";
    }

    @RequestMapping(value = "/add" , method = RequestMethod.POST)
    public String save(Account account , String address){
        System.out.println(address+account.getUserName());
        return "redirect:/home";
    }
  /*  @RequestMapping(value = "/{id:\\d+}/{type}",method =RequestMethod.GET )
    public String show(@PathVariable Integer id,
                       @PathVariable String type,
                       Model model){
        System.out.println(id+type);
        model.addAttribute("id",id);
        model.addAttribute("type",type);
        return "user/show";

    }*/
    @RequestMapping(value = "/{id:\\d+}/{types}",method = RequestMethod.GET)
    public ModelAndView showUser(@PathVariable Integer id,
                                 @PathVariable(name = "types") String type) {
        System.out.println("ID:" + id + " Type:" + type);

        /*ModelAndView mav = new ModelAndView();
        mav.setViewName("user/show");
        mav.addObject("id",id);
        mav.addObject("type",type);*/

        return new ModelAndView("user/show","id",id);
    }



}
