# Тестовый проект по расчету налогообложения любителей орехов

## Требования:

```
Каждый житель должен оплатить в казну 150 орехов.

С дохода от 1000 орехов до 10000 дополнительно платится 10 орехов с каждой полной или неполной сотни.

С дохода сверх 10000 нужно еще оплатить 5% с округлением до целого ореха
```

## Результат проверок

### Необходимо уточнить границы дохода
- Из ТЗ неясно какая граница дохода включительная, какая нет
- Влияет на большинство проверок

### Проверка при доходе 1-1000(не включительно) орехов.
Ожидаемый результат: 150

Предположительно, должно быть значение дохода
- В соответствии с ТЗ ожидаемый результат при отрицательном доходе: 150, т.к. при первом условии каждый житель должен оплатить 150 орехов, независимо от дохода(не указано)
- Также при доходе равном 0 ожидаемый результат: 150
- По ТЗ не очевидно статичный это налог из контекста предположительно 2 варианта
- Налог взимается независимо от значения дохода
- Налог взимается при значении дохода меньше 1000
- Вопрос: Должен ли житель платить налог с отрицательного дохода(Работа в убыток\кредит и тд)?
- Вопрос: Должен ли житель платить налог с нулевой прибыли?

### Проверка при доходе от 1000 до 10 000 орехов.
- Доход 1000, Ожидаемый результат: Необходимо уточнить учитывается 1000 как полная сотня(Влияет на последующие расчеты)
  - Фактически 1000 - является полной сотней, тогда ожидаемый результат: 160
  - Если не учитывается, ожидаемый результат: 150
  - Необходимо уточнить учитываются ли сотни до 1000, тогда результат увеличивается на 100, Ожидаемый результат: 250
- Доход 1001, учитывая неясность в ТЗ есть Три исхода
  - Если 1000 учитывается как первая полная сотня, в таком случае ожидаемый результат: 170(1000 - первая полная сотня, 1001 - вторая не полная сотня)
  - Если не 1000 учитывается как первая полная сотня, ожидаемый результат: 160(1001 - первая неполная сотня)
  - Если учитываются сотни до 1000, Ожидаемый результат: 260 


### Проверка при доходе больше 10 000 орехов.
- Доход 10000, Ожидаемый результат: Зависит от предыдущих расчетов
    - Необходимо уточнить от чего именно добавляется 5%, от налогов или доходов
    
## Стратегический ход :)
<details>
  <summary>Spoiler warning</summary>
    Написать Сергею Мартыненко

    https://software-testing.ru/forum/index.php?/topic/38062-kak-poluchit-opyt-testirovaniia/
</details>