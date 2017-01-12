package com.laowang.controller;

import com.laowang.exception.NotFindException;
import com.laowang.pojo.Account;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Arrays;
import java.util.List;

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

    @GetMapping
    public String list(Model model){
        Account account = new Account();
        account.setUserName("jack");
        account.setAge(23);

        Account account2 = new Account();
        account2.setUserName("Rose");
        account2.setAge(22);

        List<Account> accountList = Arrays.asList(account,account2);
        model.addAttribute("accountList",accountList);
        return "user/list";
    }

    @GetMapping("/new")
    public String newUser() {
        return "user/add";
    }

    @PostMapping("/new")
    public String saveUser(Account account,
                           RedirectAttributes redirectAttributes) {
        System.out.println(account);

        redirectAttributes.addFlashAttribute("message","添加成功");
        return "redirect:/user";
    }

    @RequestMapping(value = "/check/{userName}",method = RequestMethod.GET,
                        produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String check(@PathVariable String userName){
        if(userName.equals("asd")){
            return "不可用";
        }else{
            return "可用";
        }
    }

    @RequestMapping(value = "/api/{id:\\d+}",method = RequestMethod.GET)
    @ResponseBody
    public Account findById(@PathVariable Integer id) {
        Account account = new Account();
        account.setUserName("李四");
        account.setAge(23);
        return account;
    }


    @RequestMapping(value = "/upload",method = RequestMethod.GET)
    public String fileUpload() {
        return "user/upload";
    }

    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    public String saveFile(String name, MultipartFile file) {
        System.out.println("Name:" + name);
        if(!file.isEmpty()) {
            //上传表单控件的name属性值
            System.out.println("getName:" + file.getName());
            //上传文件的原始名称
            System.out.println("getOriginalFilename:" + file.getOriginalFilename());
            //文件大小（字节）
            System.out.println("size: " + file.getSize());
            //文件的MIME类型
            System.out.println("ContentType:" + file.getContentType());

            //InputStream inputStream = file.getInputStream();
        }
        return "redirect:/user";
    }

    @RequestMapping("/u-{id:\\d+}")
    public String showUser(@PathVariable Integer id) {
        if(id == 100) {
            throw new NotFindException();
        }
        return "redirect:/user";
    }



}
