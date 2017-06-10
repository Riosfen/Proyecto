Para realizar este proyecto se ha utilizado una Base de Datos que puedes encontrar
en la carpeta: "BD" (u329292900_proye.sql) importalo en tu propio servidor.

He rellenado la DB con un generador que se puede encontrar en esta dirección: 
	-> http://www.generatedata.com/?lang=es#t1

Tambien se ha utilizado el JRE JavaSE-1.8.

Se han utilizado 17 .jar:

	->Estos son para Hibrenate
		1- antlr-2.7.7.jar
		2- commons-collections-3.2.1.jar
		3- dom4j-1.6.1.jar
		4- hibernate-commons-annotations-4.0.1.Final.jar
		5- hibernate-core-4.1.0.Final.jar
		6- hibernate-entitymanager-4.1.0.Final.jar
		7- hibernate-jpa-2.0-api-1.0.1.Final.jar
		8- javassist-3.15.0-GA.jar
		9- jboss-logging-3.1.0.CR2.jar
		10- jboss-transaction-api_1.1_spec-1.0.0.Final.jar
		
	->Estos son para que funcionen las validaciones de Hibernate
		11- joda-time-2.9.5.jar
		12- jsoup-1.8.3.jar
		13- hibernate-validator-4.3.0.Final.jar
		14- hibernate-validator-annotation-processor-4.3.0.Final.jar
		15- hibernate-validator-cdi-5.4.1.Final.jar
		
	->Este para poder conectar con la base de datos (MySQL)
		16- mysql-connector-java-5.1.5-bin.jar
		
	->Este es del calendario
		17- jcalendar-1.4.jar