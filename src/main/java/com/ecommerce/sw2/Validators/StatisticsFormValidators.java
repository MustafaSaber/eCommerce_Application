package com.ecommerce.sw2.Validators;

import com.ecommerce.sw2.Models.Domain.Statistics;
import com.ecommerce.sw2.Models.Repository.StatisticsRepository;
import com.ecommerce.sw2.forms.StatisticsForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class StatisticsFormValidators implements Validator {

    @Autowired
    StatisticsRepository statisticsRepository;

    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.equals(StatisticsForm.class);
    }

    @Override
    public void validate(@Nullable Object o, Errors errors) {
        StatisticsForm statisticsForm = (StatisticsForm) o;
        validate(errors , statisticsForm);
    }

    public void validate(Errors errors , StatisticsForm statisticsForm)
    {
        if(errors.hasFieldErrors()) return;

        Optional<Statistics> alreadyTheir = null;
        alreadyTheir  = statisticsRepository.findByEntityAndAttributeAndFunction(statisticsForm.getTable() , statisticsForm.getColumn() , statisticsForm.getFunction());
        if(alreadyTheir.isPresent())
        {
            errors.reject("msg.DublicateStat");
        }

    }

}
