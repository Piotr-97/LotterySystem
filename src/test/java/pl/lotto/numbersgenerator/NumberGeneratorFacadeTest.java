package pl.lotto.numbersgenerator;

import static org.assertj.core.api.Assertions.assertThat;
import static pl.lotto.numbersgenerator.WinningNumberGeneratorProxy.MAX_NUMBER;

import static org.mockito.ArgumentMatchers.any;

public class NumberGeneratorFacadeTest {
/*
    @Test
    public void should_return_number_in_range_1_between_99() {
        //given
        WinningNumberRepository winningNumberRepository = new NumbersGeneratorRepositoryTestImpl();
        DrawDateGeneratorFacade drawDateGeneratorFacade = Mockito.mock(DrawDateGeneratorFacade.class);
        NumbersGeneratorFacade numbersGeneratorFacade = new NumbersGeneratorConfiguration().numbersGeneratorFacadeForTest(winningNumberRepository,drawDateGeneratorFacade);
        LocalDateTime drawDate = LocalDateTime.of(2022, Month.NOVEMBER, 19, 20, 0, 0);
        when(drawDateGeneratorFacade.generateNextDrawDate(any())).thenReturn(DrawDateDto.builder().drawDate(drawDate).build());
        //when
        WinningNumbersDto winningNumbersDto = numbersGeneratorFacade.generateWinningNumbers();
        //then
        List<Integer> winningNumbers = winningNumbersDto.winningNumbers();
        assertThat(winningNumbers.stream().noneMatch(this::isInRange)).isTrue();
    }

    @Test
    public void should_have_exactly_six_numbers() {
        //given
        WinningNumberRepository winningNumberRepository = new NumbersGeneratorRepositoryTestImpl();
        DrawDateGeneratorFacade drawDateGeneratorFacade = Mockito.mock(DrawDateGeneratorFacade.class);
        NumbersGeneratorFacade numbersGeneratorFacade = new NumbersGeneratorConfiguration().numbersGeneratorFacadeForTest(winningNumberRepository,drawDateGeneratorFacade);
        LocalDateTime drawDate = LocalDateTime.of(2022, Month.NOVEMBER, 19, 20, 0, 0);
        when(drawDateGeneratorFacade.generateNextDrawDate(any())).thenReturn(DrawDateDto.builder().drawDate(drawDate).build());
        //when
        List<Integer> winningNumbers = numbersGeneratorFacade.generateWinningNumbers().winningNumbers();
        //then

        assertThat(winningNumbers).isNotEmpty();
        assertThat(winningNumbers).hasSize(6);

    }*/

    private boolean isInRange(Integer number) {
        return number > MAX_NUMBER || number < 1;
    }

}
