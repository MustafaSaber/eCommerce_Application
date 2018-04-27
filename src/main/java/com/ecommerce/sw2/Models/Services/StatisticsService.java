package com.ecommerce.sw2.Models.Services;

import com.ecommerce.sw2.Models.Domain.Statistics;
import com.ecommerce.sw2.forms.StatisticsForm;
import org.springframework.stereotype.Service;

import java.util.Collection;

public interface StatisticsService {

    Statistics AddStat(StatisticsForm statisticsForm);
    Collection<Statistics> GetAllStats();
}
