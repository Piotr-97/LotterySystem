package pl.lotto.resultchecker;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import pl.lotto.numberreceiver.NumberReceiverFacade;
import pl.lotto.numberreceiver.dto.AllNumbersFromUsersDto;
import pl.lotto.numberreceiver.dto.LotteryTicketDto;
import pl.lotto.numbersgenerator.NumbersGeneratorFacade;
import pl.lotto.numbersgenerator.WinningNumbersDto;

public class ResultCheckerFacade {
    private final NumberReceiverFacade numberReceiverFacade;
    private final NumbersGeneratorFacade numbersGeneratorFacade;

    private final WinnerChecker winnerChecker;
    private final ResultCheckerRepository resultCheckerRepository;

    public ResultCheckerFacade(NumberReceiverFacade numberReceiverFacade, NumbersGeneratorFacade numbersGeneratorFacade, WinnerChecker winnerChecker, ResultCheckerRepository resultCheckerRepository) {
        this.numberReceiverFacade = numberReceiverFacade;
        this.numbersGeneratorFacade = numbersGeneratorFacade;
        this.winnerChecker = winnerChecker;
        this.resultCheckerRepository = resultCheckerRepository;
    }

    public List<LotteryTicketDto> checkWinners(LocalDateTime drawTime) {
        AllNumbersFromUsersDto allNumbersFromUsersDto = numberReceiverFacade.usersNumbers(drawTime);
        WinningNumbersDto winningNumber = numbersGeneratorFacade.generateWinningNumbers();
    //Do poprawienia save all


        List<LotteryTicketDto> lotteryTicketDtos = winnerChecker.checkWinningTickets(allNumbersFromUsersDto, winningNumber);
        lotteryTicketDtos.stream()
                .map(lotteryTicketDto -> LotteryTicket.builder()
                        .drawDate(drawTime)
                        .lotteryId(lotteryTicketDto.lotteryId())
                        .numbers(n).collect(Collectors.toList());
        resultCheckerRepository.save( LotteryTicket.builder()
                .drawDate(drawTime)
                .lotteryId(l)
                .numbers(winningNumber.winningNumbers()).build());

        return lotteryTicketDtos;
    }

    //Tutaj blad
    public boolean isWinner(String lotteryId) {
        LotteryTicket lotteryTicket =  resultCheckerRepository.findWinningTicketById(lotteryId);
        WinningNumbersDto winningNumber = numbersGeneratorFacade.generateWinningNumbers();
        return winnerChecker.isTicketWinning(lotteryTicket, winningNumber);
    }


    public boolean areGeneratedWinnersByDate(LocalDateTime drawTime){
        return resultCheckerRepository.existsWinningTicketByDrawDate(drawTime);
    }
}
