using System;
using System.Text;
using System.Collections.Generic;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using OpenQA.Selenium;
using NUnit.Framework;
using OpenQA.Selenium.Firefox;

namespace csharpHomeWork
{
    
    [TestClass]
    public class TestFireFox
    {
        private IWebDriver driver;

        [SetUp]
        public void set()
        {
            this.driver = new FirefoxDriver();
        }
        [Test]
        public void FF()
        {
            // почему то всплавал alert для basic авторизации, эту  строчку наверное можно считать  костылем.
            this.driver.Url = "http://localhost:81/lifecart/admin/";

            this.driver.FindElement(By.Name("username")).Clear();
            this.driver.FindElement(By.Name("username")).SendKeys("admin");
            this.driver.FindElement(By.Name("password")).Clear();
            this.driver.FindElement(By.Name("password")).SendKeys("admin");
            this.driver.FindElement(By.Name("login")).Click();

        }
        [TearDown]
        public void close()
        {
            this.driver.Quit();
            this.driver = null;
        }
    }
}
