# utvverk-grupp1


author danijela 
 här vi bygger vår Swing application
 
## Användning
 
  Beroende på grund vilken knapp man trycker på, sker olika händelser.
 
 -När man klickar på knappen "List" visas alla kontakter som finns i kontaktboken.
 
 -Om man vill leta efter eller lägga till en kontakt i boken behöver man först att
 skriva uppgifter i textrutorna och efteråt klicka på en lämplig knapp.
 
 -Om man klickar på knappen "Search" kan man leta efter kontakter i kontaktboken. 
 Om kontakten inte finns i boken visas ett felmeddelande.
 
-När man klickar på knappen "Delete" raderas en kontakt från kontaktboken. Naturligtvis behöver man först 
 välja vilken kontakt som man vill radera i JTextArea. Det gör man genom att markera raden med muspekaren.
 För att se resultatet behöver man att klicka knappen "lista" en gång till.
 
 Alla resultat ser man i textArea som har horisontell och vertikal scroll.
 
## Bygginstruktioner

krav: maven, java >= 1.8

Klona det här repot och kör mvn package.
Kör sedan<br> java -jar target/utvverk-grupp1-1.0-SNAPSHOT.jar

 