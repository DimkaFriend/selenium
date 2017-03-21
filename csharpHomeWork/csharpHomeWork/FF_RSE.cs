using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using OpenQA.Selenium.Firefox;
using NUnit.Framework;
using OpenQA.Selenium;
using OpenQA.Selenium.Remote;

namespace csharpHomeWork
{
    [TestClass]
    public class FF_RSE
    {
        private IWebDriver driver;

        [SetUp]
        public void set()
        {
            //DesiredCapabilities caps = new DesiredCapabilities();
            FirefoxOptions opt = new FirefoxOptions();
            opt.BrowserExecutableLocation = @"D:\Mozilla_Firefox_RSE\firefox.exe";
            this.driver = new FirefoxDriver(opt);//@"D:\Mozilla_Firefox_RSE\firefox.exe"
        }
        [Test]
        public void FFRSE()
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
