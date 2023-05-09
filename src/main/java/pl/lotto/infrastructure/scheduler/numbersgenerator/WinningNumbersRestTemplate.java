package pl.lotto.infrastructure.scheduler.numbersgenerator;


import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
@AllArgsConstructor
public class WinningNumbersRestTemplate implements WinningNumbersGenerableProxy {

    private final RestTemplate restTemplate;
    @Value("${winning-numbers.url}")
    private String winningNumbersUrl;

    @Override
    public List<Integer> generateWinningNumberList() {
        restTemplate.exchange(winningNumbersUrl+"/gennerate", HttpMethod.GET, (HttpEntity<?>) null, (Class<Object>) null);
        return List.of();
    }
}
