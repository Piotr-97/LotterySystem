package pl.lotto.resultchecker;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import pl.lotto.numberreceiver.dto.AllNumbersFromUsersDto;
import pl.lotto.numberreceiver.dto.LotteryTicketDto;
import pl.lotto.numbersgenerator.WinningNumbersDto;

class WinnerChecker {

    List<LotteryTicketDto> getTickets(AllNumbersFromUsersDto allNumbersFromUsersDto) {
        return new ArrayList<>(allNumbersFromUsersDto.allNumbers());

    }


  /*  List<LotteryTicketDto> checkWinningTickets(AllNumbersFromUsersDto allNumbersFromUsersDto, WinningNumbersDto winningNumber) {
        return allNumbersFromUsersDto.allNumbers()
                .stream()
                .filter(ticket -> ticket.numbers().equals(winningNumber.winningNumbers()))
                .collect(Collectors.toList());

    }*/





    boolean isTicketWinning(LotteryTicket lotteryTicket, WinningNumbersDto winningNumbersDto) {
        return lotteryTicket.numbers().equals(winningNumbersDto.winningNumbers());
    }
}
