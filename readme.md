## Приложение QuizApp

### Удалось:

1. Экран прохождения викторины
1. Экран истории
1. Получение данных по Api с Retrofit
1. Применить MVP архитектуру

Видео: [schoolresult.mp3](VIDEO/)

### Model

Все находится в ```model.api```. ```QuizResponse``` и ```QuizData``` -- это модели приходящих данных. ```ApiService```, ```RetrofitClient```, ```GetData``` -- для Retrofit.

```model.quiz``` -- классы для самих викторин, их результатов и истории.

### Presenter

Управляет состояниями экранов: ```ScreenStatus``` и ```HistoryScreenStatus``` -- возможные состояния. 

```LoadQuiz``` -- загружает данные по api и формирует из них Quiz, Questions, History. Он получает запрос из view, работает с model и отправляет результат во view.

### View

```navigation```, ```theme``` -- для навигации и тем.

```HistotyScreen```, ```MainScreen```, ```ResultScreen``` -- это сами экраны. *(ResultScreen не используется)*