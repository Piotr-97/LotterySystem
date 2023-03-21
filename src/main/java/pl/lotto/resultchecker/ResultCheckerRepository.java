package pl.lotto.resultchecker;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface ResultCheckerRepository  extends MongoRepository<LotteryTicket,String> {


    LotteryTicket findWinningTicketById(String lotteryId);

    boolean existsWinningTicketByDrawDate(LocalDateTime drawDate);

    LotteryTicket findWinningTicketByDrawDate(LocalDateTime drawDate);
}
