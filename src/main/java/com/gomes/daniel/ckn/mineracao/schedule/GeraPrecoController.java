package com.gomes.daniel.ckn.mineracao.schedule;


import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@EnableScheduling
public class GeraPrecoController {
    private final GeraPrecoService buscarPrecoService;

    @Scheduled(cron = "0 0 0 * * *") // Diario: 00:15
    public void lookForPrice() {
        buscarPrecoService.pesquisarPreco();
    }

}
