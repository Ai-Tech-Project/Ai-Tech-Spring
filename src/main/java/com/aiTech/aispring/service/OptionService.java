package com.aiTech.aispring.service;

import com.aiTech.aispring.entity.Option;
import com.aiTech.aispring.repository.OptionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OptionService implements IService<Option> {

    private final OptionRepository repo;

    @Override
    public List<Option> retrieveAll() {
        return repo.findAll();
    }

    @Override
    public Option retrieve(String id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Option add(Option Option) {
        return repo.save(Option);
    }

    @Override
    public void remove(String id) {
        repo.deleteById(id);
    }

    @Override
    public Option modify(Option Option) {
        return repo.save(Option);
    }
}
