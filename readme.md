Програма використовує MySql сервер баз даних 
Для налаштування доступу до бази необхідно в директорії:
Java Resources -> src/main/resources - > project.properties змінити значення під користувача: 
jdbc.url=jdbc:mysql://localhost:3306/"назва бази даних" 
jdbc.user="ім'я користувача" 
jdbc.pass="пароль користувача"

Для запуску програми використовується сервер jetty.
Для його запуску необхідно в вікні  Run -> RunConfiguration в полі Goal
ввести рядок запуску: jetty:run, і запустити програму
