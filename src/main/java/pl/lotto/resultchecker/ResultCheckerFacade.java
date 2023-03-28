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

        List<LotteryTicketDto> lotteryTicketDtos = winnerChecker.checkWinningTickets(allNumbersFromUsersDto, winningNumber);
        List<LotteryTicket> lotteryTickets = lotteryTicketDtos.stream()
                .map(lotteryTicketDto -> LotteryTicket.builder()
                        .drawDate(drawTime)
                        .lotteryId(lotteryTicketDto.lotteryId())
                        .numbers(lotteryTicketDto.numbers()).build())
                .collect(Collectors.toList());

        List<PlayerResult> playerResultList = lotteryTickets.stream().map(lotteryTicket -> PlayerResult.builder()
                .winningNumbers(winningNumber.winningNumbers())
                .drawDate(drawTime)
                .lotteryTicket(lotteryTicket)
                .build()).collect(Collectors.toList());
        resultCheckerRepository.saveAll(playerResultList);
        return lotteryTicketDtos;
    }


    public boolean isWinner(String lotteryId) {
        PlayerResult playerResult =  resultCheckerRepository.findPlayerResultById(lotteryId);
        WinningNumbersDto winningNumber = numbersGeneratorFacade.generateWinningNumbers();
        return winnerChecker.isTicketWinning(playerResult.lotteryTicket(), winningNumber);
    }


    public boolean areGeneratedWinnersByDate(LocalDateTime drawTime){
        return resultCheckerRepository.existsPlayerResultByDrawDate(drawTime);
    }
}
