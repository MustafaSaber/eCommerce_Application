package com.ecommerce.sw2.Models.Services;

import com.ecommerce.sw2.Models.Domain.Statistics;
import com.ecommerce.sw2.Models.Repository.StatisticsRepository;
import com.ecommerce.sw2.forms.StatisticsForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class StatisticsServiceImp implements StatisticsService{
    @Autowired
    StatisticsRepository statisticsRepository;

    @Override
    public Statistics AddStat(StatisticsForm statisticsForm) {

        Statistics statistic = new Statistics(statisticsForm.getTable() , statisticsForm.getColumn() , statisticsForm.getFunction());
        return statisticsRepository.save(statistic);
    }

    @Override
    public Collection<Statistics> GetAllStats() {
        return statisticsRepository.findAll();
    }
}
