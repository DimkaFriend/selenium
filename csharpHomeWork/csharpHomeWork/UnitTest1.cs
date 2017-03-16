using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using OpenQA.Selenium;
using NUnit.Framework;
using OpenQA.Selenium.Chrome;

namespace csharpHomeWork
{
    [TestClass]
    public class UnitTest1
    {
        private IWebDriver driver;

        [SetUp]
        public void set() 
        {
            this.driver = new ChromeDriver();
        }
        [Test]
        public void TestMethod1()
        {
            // почему то всплавал alert для basic авторизации, эту  строчку наверное можно считать  костылем.
            this.driver.Url = "http://admin:admin@localhost:81/lifecart/admin/";
            
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
