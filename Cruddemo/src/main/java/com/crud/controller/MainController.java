package com.crud.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.crud.dao.UserDao;
import com.crud.model.UserModel;

@Controller

public class MainController {

    @Autowired    
    UserDao userdao;
        
    @RequestMapping("/")
    public String home() {
    	return "home";
    }
    @RequestMapping("/userform")    
    public String showform(Model m){    
    	UserModel user = new UserModel();
        m.addAttribute("command", user);  
        return "userform";   
    }    
    
    @RequestMapping(value="/save",method = RequestMethod.POST)    
    public String save(@ModelAttribute("usr") UserModel user){    
        userdao.save(user);    
        return "redirect:/viewuser"; 
    }    
   
    @RequestMapping("/viewuser")    
    public String viewuser(Model m){    
        List<UserModel> list=userdao.list();    
        m.addAttribute("list",list);  
        return "viewuser";    
    }    
    
    @RequestMapping(value="/editemp/{id}")    
    public String edit(@PathVariable int id, Model m){    
        UserModel user=userdao.get(id);    
        m.addAttribute("command",user);  
        return "useredit";    
    }    
       
    @RequestMapping(value="/editsave",method = RequestMethod.POST)    
    public String editsave(@ModelAttribute("usr") UserModel user){    
        userdao.update(user);    
        return "redirect:/viewuser";    
    }    
    
    @RequestMapping(value="/deleteuser/{id}",method = RequestMethod.GET)    
    public String delete(@PathVariable int id){    
        userdao.delete(id);    
        return "redirect:/viewuser";    
    }     
}

