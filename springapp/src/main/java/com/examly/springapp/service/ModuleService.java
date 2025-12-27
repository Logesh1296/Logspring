package com.examly.springapp.service;

import com.examly.springapp.model.Module;
import java.util.List;

public interface ModuleService {
    Module addModule(Module module);
    List<Module> getAllModules();
    Module getModuleById(Long id);
    Module updateModule(Long id, Module module);
    boolean deleteModule(Long id);
}
