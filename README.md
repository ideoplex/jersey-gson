jersey-gson
===========

Sample java web application with jersey and gson that displays a list of users in a [Datatables](http://datatables.net/) table.
The application retrieves the users via Datatables ajax.
User edits are submitted to the server and successful response is applied to the local data set in the browser.
Long cell text will be truncated with an ellipsis.

Users can be added via a [Bootstrap](http://getbootstrap.com/) Modal dialog. Users are kept in memory and are not persisted.

The application tests demonstrate the use of [Selenium](http://www.seleniumhq.org/) automation for the addition of users.

The application can be run from the command line via:

```
mvn jetty:run
```

[Maven](https://maven.apache.org/) is configured to autostart/autostop jetty
for the selenium test. Please halt any "mvn jetty:run" invocations before
running the tests via:

```
mvn test
```

If you prefer Google Chrome, then install the [ChromeDriver](https://code.google.com/p/selenium/wiki/ChromeDriver) and:

```
mvn test -Dbrowser=chrome
```

Read about the project (from most recent to oldest):

1. [jersey-gson Content-Type Woes](https://ideoplex.com/2015/10/31/jersey-gson-content-type-woes/)
1. [Autostart Jetty in Maven](https://ideoplex.com/2015/10/25/autostart-jetty-in-maven/)
1. [DataTables, Bootstrap and Text Overflow](https://ideoplex.com/2015/08/16/datatables-bootstrap-and-text-overflow/)
1. [DataTables edit Locally](https://ideoplex.com/2015/07/12/datatables-edit-locally/)
1. [jQuery Ajax and Selenium](https://ideoplex.com/2015/06/21/jquery-ajax-and-selenium/)
1. [DataTables and Selenium](https://ideoplex.com/2015/06/14/datatables-and-selenium/)
1. [Bootstrap Modals and Selenium](https://ideoplex.com/2015/06/07/bootstrap-modals-and-selenium/)
1. [DataTables ajax error handling](https://ideoplex.com/2014/11/16/datatables-ajax-error-handling/)
1. [DataTables Column Render](https://ideoplex.com/2014/10/23/datatables-column-render/)
1. [Modal Dialog for Jersey, Gson and DataTables](https://ideoplex.com/2014/10/12/modal-dialog-for-jersey-gson-and-datatables/)
1. [Jersey, Gson, DataTables](https://ideoplex.com/2014/10/04/jersey-gson-and-datatables/)
1. [DataTables, Bootstrap and Text Overflow](https://ideoplex.com/2015/08/16/datatables-bootstrap-and-text-overflow/)
