Feature: I can open habr home page with correct content

  Scenario: Open habr.com home page
    Given Browser "Chrome" is open
    When I open "https://habr.com/"
    Then page title should be "Лучшие публикации за сутки / Хабр"


  Scenario: Top bar is on the home page
    Given HomePage is open
    When Top bar is open
    Then Top bar contains items
      | Все потоки        |
      | Разработка        |
      | Научпоп           |
      | Администрирование |
      | Дизайн            |
      | Менеджмент        |
      | Маркетинг         |
