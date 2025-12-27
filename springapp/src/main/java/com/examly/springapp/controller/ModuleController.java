package com.examly.springapp.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.examly.springapp.model.Module;
import com.examly.springapp.service.ModuleService;

import java.util.List;

@RestController
@RequestMapping("/api/modules")
public class ModuleController {
    
    private ModuleService moduleService;
    
    public ModuleController(ModuleService moduleService) {
        this.moduleService = moduleService;
    }
    
    @PostMapping
    public ResponseEntity<Module> addModule(@RequestBody Module module) {
        Module m = moduleService.addModule(module);
        if(m == null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(m, HttpStatus.CREATED);
    }
    
    @GetMapping
    public ResponseEntity<List<Module>> getAllModules() {
        List<Module> modules = moduleService.getAllModules();
        if(modules == null || modules.isEmpty()) return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(modules, HttpStatus.OK);
    }
    
    @GetMapping("/{moduleId}")
    public ResponseEntity<Module> getModuleById(@PathVariable Long moduleId) {
        Module module = moduleService.getModuleById(moduleId);
        if(module == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(module, HttpStatus.OK);
    }
    
    @PutMapping("/{moduleId}")
    public ResponseEntity<Module> updateModule(@PathVariable Long moduleId, @RequestBody Module module) {
        Module m = moduleService.updateModule(moduleId, module);
        if(m == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(m, HttpStatus.OK);
    }
    
    @DeleteMapping("/{moduleId}")
    public ResponseEntity<Void> deleteModule(@PathVariable Long moduleId) {
        boolean deleted = moduleService.deleteModule(moduleId);
        if(!deleted) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
