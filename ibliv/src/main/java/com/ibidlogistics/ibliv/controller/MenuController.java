
package com.ibidlogistics.ibliv.controller;

import com.ibidlogistics.ibliv.model.Menudetails;
import org.springframework.beans.factory.annotation.Autowired;
import com.ibidlogistics.ibliv.repository.MenudeatailsRepository;
import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class MenuController {
    @Autowired
    MenudeatailsRepository menurepository;
    
    @GetMapping("/getallmenuitems")
    public List<Menudetails> getallmenuitems()
    {
        return this.menurepository.findAll();
    }
    
    @GetMapping("/getallmenuitemsbymenuoreder")
    public List<Menudetails> getallmenuitemsbymenuoreder()
    {
        return this.menurepository.findAllByOrder();
    }
    
    @GetMapping("/getallmenuitemsmenunamebymenuoreder/{mainname}")
    public List<Menudetails> getallmenuitemsmenunamebymenuoreder(@PathVariable("mainname") String mainname)
    {
        return this.menurepository.findByMainnameWithOrder(mainname);
    }
}
