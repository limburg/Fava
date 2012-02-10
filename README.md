# Installatie #

Installeer maven2 (http://maven.apache.org/)
Als men Eclipse gebruikt, voer het volgende uit in de Fava directory: 

	mvn eclipse:eclipse

Eventueel bij compilatie fouten (ontbrekende libraries) kan het volgende uitgevoerd worden:

	mvn clean install


# Compile CUP/JFlex #

Voor het compileren dient het volgende uitgevoerd te worden: 

	mvn clean compile
	
Als men Eclipse gebruikt, dien je het project te refreshen.


# Testen van Fava bestanden #

De meegeleverde test.fava kan standaard worden aangeroepen als volgt: 

	mvn exec:java
	
Vanuit Eclipse kan men een run-configuratie aanmaken met program-parameter: test.fava (of ieder ander bestand welke in de test directory staat).