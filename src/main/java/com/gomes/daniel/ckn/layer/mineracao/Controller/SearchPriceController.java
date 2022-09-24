package com.gomes.daniel.ckn.layer.mineracao.Controller;

import com.gomes.daniel.ckn.layer.mineracao.Controller.FunctionController;
import com.gomes.daniel.ckn.layer.mineracao.Service.SearchPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


@Controller
public class SearchPriceController implements FunctionController {

    @Autowired
    SearchPriceService priceService;

    @Override
    public void execute() {
        priceService.lookForPrice();
    }

}

	
