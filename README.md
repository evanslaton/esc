# Esc
Java 401 Midterm Project

The Team: [Daniel Logerstedt](https://github.com/daniellogerstedt), [Pablo Rosales](https://github.com/Pablito14), [Jeff Borda](https://github.com/jeffborda) and [Evan Slaton](https://github.com/evanslaton)

![Esc Logo](assets/esc-logo.png)

## Description
Esc ([pronounced /əˈskāp/](https://www.merriam-webster.com/dictionary/escape?pronunciation&lang=en_us&dir=e&file=escape01)) is an app that allows a user to compose a message, specify a time the user wants to receive that message, and then delivers that message as an SMS at the specified time.

Practicle Application:
* When you commit to a social engagement and want to have an excuse to leave early
* To send yourself a reminder
* To impress someone who might have visual access to your phone

## User Stories
* As a user, I want to be able to signup so that I don't have to re-enter my personal information each time I visit the app.
* As a user, I want my personal information to be stored safely so only I can access it.
* As a user, I want to be able to login so that I can access my personal data.
* As a user, I want to be able to send myself a text message (that I wrote) at a time that I specified, so I can use the text as an excuse to get out of uncomfortable situations, remind myself to do something or impress someone.
* As a developer, I want to ensure that user data is stored safely.
* As a developer, I want the system to check the database once a minute to check which messages need to be sent.

### Stretch
* As a user, I want to be able to send **someone else** a text message (that I wrote) at a time that I specified, so **they** can use the text as an excuse to get out of uncomfortable situations, remind themselves to do something or impress someone.
* As a developer, I want users to interface with a clean and simple front-end.


## Possible Features
* Dead Man's Switch: sends a message to someone after a specified set of time, if the user doesn't respond, sends an SMS to the people the user specified

## Third Party Resources:
* [Twilio](https://www.twilio.com/docs/sms)

## License
MIT License
