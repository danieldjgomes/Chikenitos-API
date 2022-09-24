package com.gomes.daniel.ckn.layer.mineracao.Controller;

import com.gomes.daniel.ckn.layer.mineracao.Service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ReportController implements FunctionController {

    @Autowired
    private ReportService reportService;

    @Override
    public void execute() {

    }
}
