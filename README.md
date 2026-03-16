# Jakarta EE WebSocket Lab
I den här labben har jag byggt en webbapplikation med **Jakarta EE**.

## Arkitektur
Applikationen är byggd med en **lagerarkitektur** och består av fyra delar:
- Entity
- Repository
- Service
- Web

Först skapade jag en **AppUser-klass** som representerar en användare i systemet.
Användarna sparas i en **PostgreSQL-databas**, och jag använder **JPA** för att kommunicera med databasen.
Repository-klassen ansvarar för att **spara och hämta användare** från databasen.

## Login
Applikationen har också en **login-funktion** där användaren skriver in sitt **username och password**.
Login-logiken ligger i:
- `AppUserService`
- `AppUserloginBean`
Om användarnamn eller lösenord är fel visas ett **felmeddelande**.
Om login är korrekt skickas användaren vidare till **chattsidan**.
Jag använder **SessionScoped** för login-beanen.  
Det betyder att när användaren loggar in sparas användaren i sessionen, så att applikationen vet **vem som är inloggad tills användaren loggar ut**.

## WebSocket
Efter login kommer användaren till en **WebSocket-sida**.
För detta skapade jag en **separat WebSocket-applikation** som kopplar upp sig mot en WebSocket-server.
Med WebSocket kan klienten och servern skicka meddelanden till varandra i **realtid**, vilket betyder att meddelanden kan skickas direkt utan att sidan behöver laddas om.

## Sammanfattning
Den här applikationen visar hur man kan kombinera:
- databashantering
- login och session
- realtidskommunikation med WebSocket i en **Jakarta EE webbapplikation**.
