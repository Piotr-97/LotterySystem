package pl.lotto.numbersgenerator;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.lotto.drawdategenerator.DrawDateGeneratorFacade;

@Configuration
public class NumbersGeneratorConfiguration {



    @Bean
    public  NumbersGeneratorFacade numbersGeneratorFacade(WinningNumberRepository winningNumberRepository, DrawDateGeneratorFacade drawDateGeneratorFacade, WinningNumbersGenerable winningNumbersGenerable){
        return new NumbersGeneratorFacade(winningNumbersGenerable,winningNumberRepository,drawDateGeneratorFacade);
    }

    @Bean
    public  WinningNumbersGenerable winningNumbersGenerable(){
        return new WinningNumberGenerator();
    }

 /*  public NumbersGeneratorFacade numbersGeneratorFacadeForTest(WinningNumberRepository winningNumberRepository, DrawDateGeneratorFacade drawDateGeneratorFacade){
        WinningNumberGenerator winningNumberGenerator = new WinningNumberGenerator();
        return  new NumbersGeneratorFacade(winningNumberGenerator,winningNumberRepository,drawDateGeneratorFacade);
    }
*/


}
