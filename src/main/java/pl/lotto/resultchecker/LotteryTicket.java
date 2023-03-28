package pl.lotto.resultchecker;

import lombok.Builder;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;


@Builder
public record LotteryTicket(List<Integer> numbers, String lotteryId, LocalDateTime drawDate) {
}
