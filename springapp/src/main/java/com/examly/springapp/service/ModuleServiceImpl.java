package com.examly.springapp.service;

import com.examly.springapp.model.Module;
import com.examly.springapp.repository.ModuleRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ModuleServiceImpl implements ModuleService {
    
    private ModuleRepo moduleRepo;
    
    public ModuleServiceImpl(ModuleRepo moduleRepo) {
        this.moduleRepo = moduleRepo;
    }
    
    @Override
    public Module addModule(Module module) {
        if(module == null) return null;
        return moduleRepo.save(module);
    }
    
    @Override
    public List<Module> getAllModules() {
        return moduleRepo.findAll();
    }
    
    @Override
    public Module getModuleById(Long id) {
        return moduleRepo.findById(id).orElse(null);
    }
    
    @Override
    public Module updateModule(Long id, Module module) {
        Optional<Module> existingModule = moduleRepo.findById(id);
        if(!existingModule.isPresent()) {
            return null;
        }
        Module m = existingModule.get();
        m.setModuleName(module.getModuleName());
        m.setDescription(module.getDescription());
        return moduleRepo.save(m);
    }
    
    @Override
    public boolean deleteModule(Long id) {
        if(moduleRepo.existsById(id)) {
            moduleRepo.deleteById(id);
            return true;
        }
        return false;
    }
}
