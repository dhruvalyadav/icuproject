
package com.ibidlogistics.ibliv.controller;

import com.ibidlogistics.ibliv.model.Linestubes;
import com.ibidlogistics.ibliv.repository.Linestubesrepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class LinestubesController {
     @Autowired
    Linestubesrepository linestuberepository;
     
    @GetMapping("/getalllinestubes")
    public List<Linestubes> getalllinestubes()
    {
        return this.linestuberepository.findAll();
    } 
    
    @GetMapping("/getalllinestubesbyorder")
    public List<Linestubes> getalllinestubesbyorder()
    {
        return this.linestuberepository.findAllByOrder();
    } 
     
    @PostMapping("/savelinetube")
    public Linestubes savelinetube(@RequestBody Linestubes linestube){
        return this.linestuberepository.save(linestube);
    }
}
