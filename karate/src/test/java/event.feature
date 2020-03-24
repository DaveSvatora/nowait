Feature: Nowait Event Related Tests

Scenario: Add new Event

* def eventJson = {"eventName": "hello","eventDate": "2020-03-24"}
* print 'the value of eventJson is:', eventJson

Given url 'http://localhost:8080/event'
And request eventJson
When method post
Then status 201
And match response == {"eventNum":5,"eventName":"hello","eventDate":"2020-03-24"}

Scenario: Retrieve all Events

Given url 'http://localhost:8080/events'
When method get
Then status 200
And match response[0] == {"eventNum":1,"eventName":"hello","eventDate":"2020-03-24"}