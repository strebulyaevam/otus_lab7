Feature: I can use  habr.com main menu to get the content

  Scenario: Main menu is on the home page
    When HomePage is open
    Then Main menu contains items
           | СТАТЬИ   |
           | НОВОСТИ  |
           | ХАБЫ     |
           | АВТОРЫ   |
           | КОМПАНИИ |


  @Test
  Scenario: First item of Main menu is selected
       Given HomePage is open
       When Main Menu is opened
       Then Main menu item "Статьи" is selected


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


  Scenario: Button "Войти" dispaly the correct page
       Given HomePage is open
       And Top bar is opened
       When button Войти is clicked
       Then LoginPage is displayed


  @Test
  Scenario: Button "Регистрация" dispaly the correct page
       Given HomePage is open
       And Top bar is opened
       When button Регистрация is clicked
       Then RegistrationPage is displayed