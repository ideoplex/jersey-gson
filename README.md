jersey-gson
===========

Sample java web application with jersey and gson that displays a list of users in a [Datatables](http://datatables.net/) table. The application retrieves the users via Datatables ajax.

Users can be added via a [Bootstrap](http://getbootstrap.com/) Modal dialog. Users are kept in memory and are not persisted.

The application tests demonstrate the use of [Selenium](http://www.seleniumhq.org/) automation for the addition of users.

The application can be run from the command line via:

```
mvn jetty:run
```

You can run the selenium tests in another window via:

```
mvn test
```

If you prefer Google Chrome, then install the [ChromeDriver](https://code.google.com/p/selenium/wiki/ChromeDriver) and:

```
mvn test -Dbrowser=chrome
```
