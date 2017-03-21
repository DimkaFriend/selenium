using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using OpenQA.Selenium.Firefox;
using OpenQA.Selenium;
using NUnit.Framework;

namespace csharpHomeWork
{
    [TestClass]
    public class FFNaghtly
    {
        private IWebDriver driver;

        [SetUp]
        public void set()
        {
            
            FirefoxOptions opt = new FirefoxOptions();
            opt.BrowserExecutableLocation = @"D:\Mozilla_Firefox_Nightly\firefox.exe";
            this.driver = new FirefoxDriver(opt);
        }
        [Test]
        public void FFNaghtlyTesT()
        {
           
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
