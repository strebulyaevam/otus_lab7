Feature: I can use  habr.com main menu to get the content

  Scenario: Main menu is on the home page
    When HomePage is open
    Then Main menu contains items
           | СТАТЬИ   |
           | НОВОСТИ  |
           | ХАБЫ     |
           | АВТОРЫ   |
           | КОМПАНИИ |


  Scenario: First item of Main menu is selected
       Given HomePage is open
       When Main Menu is opened
       Then "Статьи" is selected


  @Test
  Scenario Outline:
       Given HomePage is open
       When Main menu item "<name>" is clicked
       Then Main menu item "<name>" is selected
       Examples:
           | name     |
           | Статьи   |
           | Новости  |
           | Хабы     |
           | Авторы   |
           | Компании |
