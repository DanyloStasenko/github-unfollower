**[Application under development]**

This application will detect users, who are not following You while You following them



**How to use**

1. Configure following properties in code:
   `WINDOWS_CHROME_DRIVER_LOCATION` - location of chrome driver
   `WINDOWS_CHROME_PROFILE_PATH` - location of chrome profiles

2. Launch Spring-boot application using gradle command
3. Close Chrome. Application will try to open Chrome with Your profile, to avoid logging-in, storing passwords, etc. If Chrome will be opened - Exception will be thrown (Chrome already is use, or something like that)
4. Send POST request:
   `localhost:8080/test`
   with body: 
   `{`
   	`"username": "https://github.com/DanyloStasenko?tab=followers"`
   `}`

**NOTE:** URL to Your page

Enjoy!