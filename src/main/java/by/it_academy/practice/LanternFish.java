package by.it_academy.practice;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Maxim Tereshchenko
 */
class LanternFish {

    public static void main(String[] args) throws IOException {
        System.out.println(lanternFishAfter80Days(initialState1())); //5934
        System.out.println(lanternFishAfter80Days(initialState2())); //358214

        System.out.println(lanternFishAfter256Days(initialState1())); //26984457539
        System.out.println(lanternFishAfter256Days(initialState2())); //1622533344325
    }

    private static List<Integer> initialState1() {
        List<Integer> initialState = new ArrayList<>();
        initialState.add(3);
        initialState.add(4);
        initialState.add(3);
        initialState.add(1);
        initialState.add(2);
        return initialState;
    }

    private static List<Integer> initialState2() throws IOException {
        String line = Files.readString(Paths.get("src/main/resources/LanternFish.txt"));
        List<Integer> initialState = new ArrayList<>();

        for (String part : line.split(",")) {
            initialState.add(Integer.valueOf(part));
        }

        return initialState;
    }

    /**
     * Мимо проплывает огромная стая анчоусов. Они должны быстро размножаться, чтобы достичь такого большого количества —
     * может быть, экспоненциально быстро? Вы должны смоделировать скорость их размножения, чтобы быть уверенным.
     * Каждый анчоус создает нового анчоуса раз в 7 дней.
     * Тем не менее этот процесс необязательно синхронизирован между каждой рыбой — у одной рыбы может остаться 2 дня
     * до появления новой рыбы, а у другой — 4. Таким образом, вы можете смоделировать каждую рыбу как одно число,
     * представляющее количество дней до появления новой рыбы.
     * Кроме того, вы полагаете, что новым анчоусам наверняка потребуется немного больше времени, прежде чем они
     * смогут производить больше анчоусов: еще два дня для первого цикла.
     * Итак, предположим, что у вас есть анчоус со значением внутреннего таймера 3:
     * Через день его внутренний таймер станет равным 2.
     * Еще через день его внутренний таймер станет равным 1.
     * Еще через день его внутренний таймер станет равным 0.
     * Еще через день его внутренний таймер сбрасывается на 6, и появляется новый анчоус с внутренним таймером 8.
     * Через день у первой рыбы будет внутренний таймер 5, а у второй - 7.
     * Поняв, что вы пытаетесь сделать, подводная лодка автоматически выдает список возрастов нескольких сотен
     * находящихся рядом анчоусов (входные данные). Например, предположим, что вам дали следующий список:
     * 3,4,3,1,2
     * Этот список означает, что первая рыба имеет внутренний таймер 3, вторая рыба имеет внутренний таймер 4
     * и так далее до пятой рыбы, у которой внутренний таймер равен 2. Моделирование этих рыб в течение нескольких
     * дней будет происходить следующим образом:
     * Исходное состояние: 3,4,3,1,2
     * Через 1 день: 2,3,2,0,1
     * Через 2 дня: 1,2,1,6,0,8
     * Через 3 дня: 0,1,0,5,6,7,8
     * Через 4 дня: 6,0,6,4,5,6,7,8,8
     * Через 5 дней: 5,6,5,3,4,5,6,7,7,8
     * Через 6 дней: 4,5,4,2,3,4,5,6,6,7
     * Через 7 дней: 3,4,3,1,2,3,4,5,5,6
     * Через 8 дней: 2,3,2,0,1,2,3,4,4,5
     * Через 9 дней: 1,2,1,6,0,1,2,3,3,4,8
     * Через 10 дней: 0,1,0,5,6,0,1,2,2,3,7,8
     * Через 11 дней: 6,0,6,4,5,6,0,1,1,2,6,7,8,8,8
     * Через 12 дней: 5,6,5,3,4,5,6,0,0,1,5,6,7,7,7,8,8
     * Через 13 дней: 4,5,4,2,3,4,5,6,6,0,4,5,6,6,6,7,7,8,8
     * Через 14 дней: 3,4,3,1,2,3,4,5,5,6,3,4,5,5,5,6,6,7,7,8
     * Через 15 дней: 2,3,2,0,1,2,3,4,4,5,2,3,4,4,4,5,5,6,6,7
     * Через 16 дней: 1,2,1,6,0,1,2,3,3,4,1,2,3,3,3,4,4,5,5,6,8
     * Через 17 дней: 0,1,0,5,6,0,1,2,2,3,0,1,2,2,2,3,3,4,4,5,7,8
     * Через 18 дней: 6,0,6,4,5,6,0,1,1,2,6,0,1,1,1,2,2,3,3,4,6,7,8, 8,8,8
     * Каждый день 0 становится 6 и добавляет новую 8 в конец списка, а каждое другое число уменьшается на 1,
     * если оно присутствовало в начале дня.
     * В этом примере через 18 дней осталось 26 рыб. Через 80 дней их будет 5934.
     * Найдите способ прогнозировать рост популяции анчоусов. Сколько анчоусов будет через 80 дней?
     */
    private static int lanternFishAfter80Days(List<Integer> initialState) {
        return 0;
    }

    /**
     * Предположим, что анчоусы живут вечно и имеют неограниченную пищу и пространство. Захватят ли они весь океан?
     * Через 256 дней в приведенном выше примере всего будет 26984457539 анчоусов!
     * Сколько анчоусов будет через 256 дней?
     */
    private static long lanternFishAfter256Days(List<Integer> initialState) {
        return 0;
    }
}
