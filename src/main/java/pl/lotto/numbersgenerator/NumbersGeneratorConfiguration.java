package pl.lotto.numbersgenerator;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.lotto.drawdategenerator.DrawDateGeneratorFacade;
import pl.lotto.infrastructure.scheduler.numbersgenerator.WinningNumbersGenerableProxy;

@Configuration
public class NumbersGeneratorConfiguration {



    @Bean
    public  NumbersGeneratorFacade numbersGeneratorFacade(WinningNumberRepository winningNumberRepository, DrawDateGeneratorFacade drawDateGeneratorFacade, WinningNumbersGenerableProxy winningNumbersGenerableProxy){
        return new NumbersGeneratorFacade(winningNumbersGenerableProxy,winningNumberRepository,drawDateGeneratorFacade);
    }

    @Bean
    public WinningNumbersGenerableProxy winningNumbersGenerable(){
        return new WinningNumberGeneratorProxy();
    }

 /*  public NumbersGeneratorFacade numbersGeneratorFacadeForTest(WinningNumberRepository winningNumberRepository, DrawDateGeneratorFacade drawDateGeneratorFacade){
        WinningNumberGenerator winningNumberGenerator = new WinningNumberGenerator();
        return  new NumbersGeneratorFacade(winningNumberGenerator,winningNumberRepository,drawDateGeneratorFacade);
    }
*/


}
