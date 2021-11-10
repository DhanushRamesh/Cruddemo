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
//@RequestMapping(value="/")
public class MainController {

    @Autowired    
    UserDao userdao;//will inject dao from XML file    
        
    /*It displays a form to input data, here "command" is a reserved request attribute  
     *which is used to display object data into form  
     */    
    @RequestMapping("/")
    public String home() {
    	return "home";
    }
    @RequestMapping("/userform")    
    public String showform(Model m){    
        m.addAttribute("command", new UserModel());  
        return "userform";   
    }    
    /*It saves object into database. The @ModelAttribute puts request data  
     *  into model object. You need to mention RequestMethod.POST method   
     *  because default request is GET*/    
    @RequestMapping(value="/save",method = RequestMethod.POST)    
    public String save(@ModelAttribute("emp") UserModel user){    
        userdao.save(user);    
        return "redirect:/viewuser";//will redirect to viewemp request mapping    
    }    
    /* It provides list of employees in model object */    
    @RequestMapping("/viewuser")    
    public String viewuser(Model m){    
        List<UserModel> list=userdao.list();    
        m.addAttribute("list",list);  
        return "viewuser";    
    }    
    /* It displays object data into form for the given id.   
     * The @PathVariable puts URL data into variable.*/    
    @RequestMapping(value="/editemp/{id}")    
    public String edit(@PathVariable int id, Model m){    
        UserModel user=userdao.get(id);    
        m.addAttribute("command",user);  
        return "useredit";    
    }    
    /* It updates model object. */    
    @RequestMapping(value="/editsave",method = RequestMethod.POST)    
    public String editsave(@ModelAttribute("emp") UserModel user){    
        userdao.update(user);    
        return "redirect:/viewuser";    
    }    
    /* It deletes record for the given id in URL and redirects to /viewemp */    
    @RequestMapping(value="/deleteemp/{id}",method = RequestMethod.GET)    
    public String delete(@PathVariable int id){    
        userdao.delete(id);    
        return "redirect:/viewuser";    
    }     
}

