package com.example.appplantorabackend.components;


import com.example.appplantorabackend.entity.User;
import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

@Component
public class Auditing implements AuditorAware<User> {
    @Override
    public Optional<User> getCurrentAuditor() {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (user == null)
            return Optional.empty();
        return Optional.of(user);
    }
}
