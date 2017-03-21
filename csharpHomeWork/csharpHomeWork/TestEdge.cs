using System;
using System.Text;
using System.Collections.Generic;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using OpenQA.Selenium;
using OpenQA.Selenium.Edge;
using NUnit.Framework;

namespace csharpHomeWork
{
   
    [TestClass]
    public class TestEdge
    {
        private IWebDriver driver;

        [SetUp]
        public void set()
        {
            this.driver = new EdgeDriver();
        }
        [Test]
        public void Edge()
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
