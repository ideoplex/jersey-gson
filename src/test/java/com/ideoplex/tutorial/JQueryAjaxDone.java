package com.ideoplex.tutorial;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class JQueryAjaxDone implements ExpectedCondition<Boolean> {

    public static final JQueryAjaxDone CONDITION = new JQueryAjaxDone();

    public Boolean apply(WebDriver driver)
    {
        String jscript = "return window.jQuery != undefined && jQuery.active === 0";
        return (Boolean)((JavascriptExecutor) driver).executeScript(jscript);
    }

}
