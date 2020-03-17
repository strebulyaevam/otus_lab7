Feature: I can open habr home page with correct content

  Scenario: Open habr.com home page
    When HomePage is open
    Then page title should be "Лучшие публикации за сутки / Хабр"


  Scenario: Top bar is on the home page
    Given HomePage is open
    When Top bar is opened
    Then Top bar contains items
           | Все потоки        |
           | Разработка        |
           | Научпоп           |
           | Администрирование |
           | Дизайн            |
           | Менеджмент        |
           | Маркетинг         |


  Scenario: First item of Top bar is selected
       Given HomePage is open
       When Top bar is opened
       Then Top bar item "Все потоки" is selected


  @Test
  Scenario Outline:
        Given HomePage is open
        When Top bar item "<name>" is clicked
        Then Top bar item "<name>" is selected
        And Title contains "<name>"
        Examples:
           | name              |
           | Разработка        |
           | Научпоп           |
           | Администрирование |
           | Дизайн            |
           | Менеджмент        |
           | Маркетинг         |

