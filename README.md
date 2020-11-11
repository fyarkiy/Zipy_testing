"# Zity_testing" 
##Task
Собрать акционные предложения с 3 категорий на выбор по 100 товаров. Парсить товары только со скидкой, записывать полученный результат в CSV файл. Чем больше уникальных полей получится взять у товара, тем лучше.
Проект должен запускаться без каких либо дополнительных действий (скачал, запустил, получил результат).

Java version : 8
Фреймворки запрещены (в том числе и Selenium)
Вспомогательные библиотеки разрешены.

##Project Structure
Class Util has all Constants used in the project.
Commodity is a model for Products retrieved from web. It has appropriate Dto.
Storage class is used to store retrieved from Website data.
Dao class is used to add and retrieve data from Storage.
Service package includes: 
(a) Mapper to map DTO to model
(b) Product data process to retrieve data from web
(c) parser to split retrieved info into right fields
(d) reader to read data from jsoup
(e) writer to download data to csv file (using super CSV).
(f) log4J is used for logging

##Implementation Details
- class Util has predefined: 
(a) web-page name (https://www.allegro.pl/strefaokazji/selected) 
(b) name of three selected categories
(c) classes of selected fields
(d) array list is used to store data but potentially it can be replaced by real database.  
In case new category has to be added - only this class needs to be changed (add new category into required Maps). In case new fields need to be added - appropriate Maps have to be changed. But also class Commodities, Dto and Mapper are to be adjusted appropriately. No need to change Reader, Writer, Parser ro Service classes.  
- several "Setting..Service" classes (which implements the same Interface) were set to have ability to expand number of retrieved fields if it is required in the future.  

##Launch Guide
- Install JDK 1.8, Maven, tomcat.
- change output file name in Util.Class (constant OUTPUT_FILE) if you want to save it in another directory.
- run main method on Main.class.

###Author

Felix Yaroslavskiy
https://github.com/fyarkiy/Zity_testing
