package com.ecommerce.sw2.Controllers;

import com.ecommerce.sw2.Models.Domain.Statistics;
import com.ecommerce.sw2.Models.Services.StatisticsService;
import com.ecommerce.sw2.Validators.StatisticsFormValidators;
import com.ecommerce.sw2.forms.StatisticsForm;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class AdminController {

    /*
    We need to transfer every admin function here
     */

    @Autowired
    private StatisticsService statisticsService;


    @Autowired
    private StatisticsFormValidators statisticsFormValidators;

    @InitBinder("statisticsForm")
    public void StatisticsFormInitBinder(WebDataBinder dataBinder) { dataBinder.addValidators(statisticsFormValidators); }

    @RequestMapping(value = "/addstat" , method = RequestMethod.POST)
    public ResponseEntity<?> addStat(@Valid @RequestBody StatisticsForm statisticsForm , BindingResult bindingResult)
    {
        if(bindingResult.hasErrors())
        {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("name", "null");
            return ResponseEntity.ok().body(jsonObject);
        }
        return ResponseEntity.ok().body(statisticsService.AddStat(statisticsForm));
    }

}
