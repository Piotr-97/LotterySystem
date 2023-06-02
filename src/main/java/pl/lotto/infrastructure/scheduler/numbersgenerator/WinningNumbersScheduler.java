package pl.lotto.infrastructure.scheduler.numbersgenerator;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import pl.lotto.drawdategenerator.dto.DrawDateDto;
import pl.lotto.numbersgenerator.NumbersGeneratorFacade;

@Component
@AllArgsConstructor
public class WinningNumbersScheduler {


    private final WinningNumbersGenerableProxy winningNumbersGenerableProxy;


    @Scheduled(cron = "*/2 * * * * *")

    public void generateWinningNumbers(){
         winningNumbersGenerableProxy.generateWinningNumberList();
    }

}
