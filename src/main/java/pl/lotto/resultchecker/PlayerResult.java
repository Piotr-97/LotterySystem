package pl.lotto.resultchecker;


import lombok.Builder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import pl.lotto.numberreceiver.dto.LotteryTicketDto;

import java.time.LocalDateTime;
import java.util.List;

@Document
@Builder

public record PlayerResult(@Id  String id, List<Integer> winningNumbers, LotteryTicket lotteryTicket, LocalDateTime drawDate) {
}
