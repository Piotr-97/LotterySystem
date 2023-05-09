package pl.lotto.infrastructure.scheduler.numbersgenerator;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import pl.lotto.drawdategenerator.dto.DrawDateDto;

import java.util.List;

@FeignClient(name = "winningnumbers", url = "${winning-numbers.url}")
public interface WinningNumbersGenerableProxy {



    @GetMapping("/generate")
    List<Integer> generateWinningNumberList(@RequestBody DrawDateDto drawDateDto);

}
