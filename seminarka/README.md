#TIC-TAC-TOE

JSP, Servlet & JPA

##User stories
- [x] As a player, I want to be able to play hot-seat tic-tac-toes.
- [x] As the first player, I want to play as X.
- [x] As the second player, I want to play as O.
- [x] As a player, I want to be able to win the game by placing 3 Xs or Os in a row.
- [x] As a player I want to be able to draw the game, if nor I nor the enemy place 3 symbols in a row.
- [x] As a player, I want to be able to see the history of all played games.
- [x] As a player, I want to be able to see the history of locally played games.
- [x] As a player, I want to be able to see theoretical winning rates.
- [x] As a player, I want to be able to see the winning rates of all played games.
- [x] As a player, I want to be able to see the winning rates of locally played games.
- [ ] As a player, I want to be able to clear local history.
- [ ] As a player, I want to be able to restart the game without reloading the whole page.
- [ ] As a player, I want to be able to go back to the game page without using the browser's 'go back' button.


## Requirements
- Jetty Server
- Maven

## Tested in browsers:
- Desktop
  - Microsoft Edge (version 95.0.1020.44) 64-bit
  
  - FIXME: None


- Mobile
  - Microsoft Edge Mobile (version 95.0.1020.48)
  - Google Chrome Mobile (version 95.0.4638.74)
  
  - FIXME: History layout overlap, works only in portrait mode

##How to run
###IntelliJ Idea

- Click on 'Add configuration...'
- Click on '+'
- Select 'Jetty Server' -> 'Local'
- Insert into 'VM Options':
  > --add-opens java.base/java.lang=ALL-UNNAMED
- Select 'Deployment' tab
- Click on '+'
- Select 'Artifact'
- Select 'seminarka:war exploded'
- OK
- OK
- Run 