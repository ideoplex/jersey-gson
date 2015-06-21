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

Read about the project (from most recent to oldest):

1. [DataTables and Selenium](http://ideoplex.com/2015/06/14/datatables-and-selenium/)
1. [Bootstrap Modals and Selenium](http://ideoplex.com/2015/06/07/bootstrap-modals-and-selenium/)
1. [DataTables ajax error handling](http://ideoplex.com/2014/11/16/datatables-ajax-error-handling/)
1. [DataTables Column Render](http://ideoplex.com/2014/10/23/datatables-column-render/)
1. [Modal Dialog for Jersey, Gson and DataTables](http://ideoplex.com/2014/10/12/modal-dialog-for-jersey-gson-and-datatables/)
1. [Jersey, Gson, DataTables](http://ideoplex.com/2014/10/04/jersey-gson-and-datatables/)
