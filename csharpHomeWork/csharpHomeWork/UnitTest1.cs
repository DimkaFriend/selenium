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
            this.driver.Url = "https://www.youtube.com/";
        }
        [TearDown]
        public void close() 
        {
            this.driver.Quit();
            this.driver = null;
        }
    }
}
