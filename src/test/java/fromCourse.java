//public class BasicLocatorsTest {
//    private WebDriver driver;
//
//    @BeforeMethod
//    public void setup() {
//        driver = new BrowserService().getDriver();
//    }
//
//    @AfterMethod
//    public void tearDown() {
//        driver.quit();
//    }
//
//    @Test
//    public void basicLocatorsTest_1() {
//        driver.get(ReadProperties.getUrl());
//
//        // Find webElement by ID
//        driver.findElement(By.id("name")).sendKeys(ReadProperties.username());
//
//        // Find webElement by Name
//        driver.findElement(By.name("password")).sendKeys(ReadProperties.password());
//
//        // Find webElement by TagName
//        driver.findElement(By.tagName("button")).click();
//    }
//
//    @Test
//    public void basicLocatorsTest_2() {
//        driver.get(ReadProperties.getUrl());
//
//        // Find webElement by linkText
//        driver.findElement(By.linkText("Forgot your password?")).click();
//
//        // Find webElement by className
//        driver.findElement(By.className("forgot_passwordpage-request-cancel")).click();
//
//        // Find webElement by partialLinkText
//        driver.findElement(By.partialLinkText("your password?")).click();
//    }



//public class CssLocatorTest {
//    private WebDriver driver;
//
//    @BeforeMethod
//    public void setup() {
//        driver = new BrowserService().getDriver();
//    }
//
//    @AfterMethod
//    public void tearDown() {
//        driver.quit();
//    }
//
//    @Test
//    public void cssLocatorTest() {
//        driver.get("file:/Users/aleksandr.trostyanko/Documents/Work/TeachMeSkills/Groups/aqa25onl/aqa25_onl/src/test/resources/index.html");
//
//        // Поиск по id
//        Assert.assertTrue(driver.findElement(By.cssSelector("#my-Address")).isDisplayed());
//        Assert.assertTrue(driver.findElement(By.id("my-Address")).isDisplayed());               // Аналог
//
//        // Поиск по class name
//        Assert.assertTrue(driver.findElement(By.cssSelector(".newsletter")).isDisplayed());
//        Assert.assertTrue(driver.findElement(By.className("newsletter")).isDisplayed());        // Аналог
//
//        // Поиск по нескольким значениям в аттрибуте class
//        Assert.assertTrue(driver.findElement(By.cssSelector(".noSel.newsletter")).isDisplayed());
//
//        // Поиск по tag name
//        Assert.assertTrue(driver.findElement(By.cssSelector("h1")).isDisplayed());
//        Assert.assertTrue(driver.findElement(By.tagName("h1")).isDisplayed());                  // Аналог
//
//        // Поиск по tag и значению из аттрибута class
//        Assert.assertTrue(driver.findElement(By.cssSelector("div.intro")).isDisplayed());
//
//        // Использование 2х уровневой иерархии для поиска дочернего элемента через findElement
//        WebElement parent = driver.findElement(By.id("helpIntro"));
//        WebElement child = parent.findElement(By.tagName("div"));
//        Assert.assertEquals(1, driver.findElements(By.cssSelector("#helpIntro div")).size());
//        Assert.assertEquals(2, driver.findElements(By.cssSelector("#Lastname .markup")).size());
//
//        // Использование 3х уровневой иерархии для поиска дочернего элемента
//        Assert.assertEquals(2, driver.findElements(By.cssSelector("div.intro #Lastname .markup")).size());
//
//        // Поиск всех элементов с тэгом h1 или p
//        Assert.assertEquals(8, driver.findElements(By.cssSelector("h1, p")).size());
//
//        // Поиск всех элементов с тэгом p у которых непосредственный родитель с тэгом div
//        Assert.assertEquals(6, driver.findElements(By.cssSelector("div > p")).size());
//
//        // Поиск всех элементов с тэгом p которые идут сразу за элементом с тэго ul
//        Assert.assertEquals(1, driver.findElements(By.cssSelector("ul + p")).size());
//
//        // Поиск всех элементов с тэгом div которые являются братьями элементу с тэгом p и идут после тэга p
//        Assert.assertEquals(2, driver.findElements(By.cssSelector("p ~ div")).size());
//
//        // Поиск всех элементов у которых присутствует аттрибут title
//        Assert.assertEquals(1, driver.findElements(By.cssSelector("[title]")).size());
//
//        // Поиск всех элементов у которых присутствует аттрибут style с конкретным значением
//        Assert.assertEquals(1, driver.findElements(By.cssSelector("[style='overflow: auto;']")).size());
//
//        // Поиск всех элементов у которых присутствует аттрибут id со значением заканчивающимся на какое-то value
//        Assert.assertEquals(1, driver.findElements(By.cssSelector("[id$='ess']")).size());
//
//        // Поиск всех элементов у которых присутствует аттрибут id со значением начинающимся на какое-то слово
//        Assert.assertEquals(1, driver.findElements(By.cssSelector("[id|=my]")).size());
//
//        // Поиск всех элементов у которых присутствует аттрибут id со значением начинающимся на какое-то value
//        Assert.assertEquals(2, driver.findElements(By.cssSelector("[id^=L]")).size());
//
//        // Поиск всех элементов у которых присутствует аттрибут title со значением содержащим слово целиком
//        Assert.assertEquals(1, driver.findElements(By.cssSelector("[title~=beautiful]")).size());
//
//        // Поиск всех элементов у которых присутствует аттрибут title со значением содержащим какой текст
//        Assert.assertEquals(1, driver.findElements(By.cssSelector("[title*=beaut]")).size());
//
//        // Поиск всех disabled элементов
//        Assert.assertEquals(1, driver.findElements(By.cssSelector(":disabled")).size());
//        //Assert.assertEquals(1, driver.findElements(By.cssSelector("button:disabled")).size());
//
//        // Поиск всех enabled элементов
//        Assert.assertEquals(8, driver.findElements(By.cssSelector(":enabled")).size());
//
//        // Поиск всех выборанных элементов
//        Assert.assertEquals(1, driver.findElements(By.cssSelector("input[name='rr']:checked")).size());
//        Assert.assertEquals(2, driver.findElements(By.cssSelector(":checked")).size());
//
//        // Поиск всех элементов c пустым телом
//        Assert.assertEquals(16, driver.findElements(By.cssSelector(":empty")).size());
//
//        // Поиск элемента с тэгом p и которым является первым дочерним элементом
//        Assert.assertEquals(1, driver.findElements(By.cssSelector("p:first-child")).size());
//        Assert.assertEquals(1, driver.findElements(By.cssSelector("li:first-child")).size());
//
//        // Поиск элемента с тэгом p и которым является последним дочерним элементом
//        Assert.assertEquals(2, driver.findElements(By.cssSelector("p:last-child")).size());
//
//        // Поиск элемента с тэгом p и которым является n-ым дочерним элементом
//        Assert.assertEquals(1, driver.findElements(By.cssSelector("p:nth-child(2)")).size());
//    }


//public class XPathLocatorsTest {
//    private WebDriver driver;
//
//    @BeforeMethod
//    public void setup() {
//        driver = new BrowserService().getDriver();
//    }
//
//    @AfterMethod
//    public void tearDown() {
//        driver.quit();
//    }
//
//    @Test
//    public void xpathLocatorTest() {
//        driver.get("file:/Users/aleksandr.trostyanko/Documents/Work/TeachMeSkills/Groups/aqa25onl/aqa25_onl/src/test/resources/index.html");
//
//        // Абсолютный xpath
//        Assert.assertTrue(driver.findElement(By.xpath("/html/body/div[1]/div/div/div[5]/form/div[1]/div[2]/input")).isDisplayed());
//
//        // Все эелемнты на странице начина с HTML
//        driver.findElements(By.xpath("//*"));
//
//        // Поиска по tagName
//        Assert.assertTrue(driver.findElement(By.xpath("//h1")).isDisplayed());
//        Assert.assertTrue(driver.findElement(By.tagName("h1")).isDisplayed());
//
//        // h4 на один уровень ниже родительского form
//        Assert.assertTrue(driver.findElement(By.xpath("//form/h4")).isDisplayed());
//        Assert.assertTrue(driver.findElement(By.cssSelector("form > h4")).isDisplayed());
//
//        // input на любом уровене ниже родительского form
//        Assert.assertTrue(driver.findElement(By.xpath("//form//input")).isDisplayed());
//        Assert.assertTrue(driver.findElement(By.cssSelector("form input")).isDisplayed());
//
//        // Поиск элемента с тэгом div у которого есть атрибут id
//        Assert.assertTrue(driver.findElement(By.xpath("//div[@id]")).isDisplayed());
//        // Поиск элемента с любым тэгом у которого есть атрибут id
//        Assert.assertTrue(driver.findElement(By.xpath("//*[@id]")).isDisplayed());
//
//        // Поиск элемента у которого есть аттрибут id cо значением top-logo
//        Assert.assertTrue(driver.findElement(By.id("cc2")).isDisplayed());
//        Assert.assertTrue(driver.findElement(By.cssSelector("#cc2")).isDisplayed());
//        Assert.assertTrue(driver.findElement(By.xpath("//*[@id = 'cc2']")).isDisplayed());
//
//        Assert.assertTrue(driver.findElement(By.xpath("//*[@class = 'noSel']")).isDisplayed());
//
//        // Поиск элемента у которого есть атрибут method cо значением и атрибут target со значением
//        Assert.assertTrue(driver.findElement(By.xpath("//*[@method='post' and @target='_blank']")).isDisplayed());
//
//        // Поиск элемента у которого есть атрибут method cо значением или атрибут target со значением
//        Assert.assertTrue(driver.findElement(By.xpath("//*[@method='post' or @target='_blank']")).isDisplayed());
//
//        // Поиск элемента у которого значение аттрибута начинается с
//        Assert.assertTrue(driver.findElement(By.xpath("//p[starts-with(@title, 'Hell')]")).isDisplayed());
//
//        // Поиск элемента у которого значение аттрибута содержит подстроку
//        Assert.assertTrue(driver.findElement(By.xpath("//p[contains(@title, 'beaut')]")).isDisplayed());
//
//        // Поиск элемента у которого текстовое значение содержит равно
//        Assert.assertTrue(driver.findElement(By.xpath("//h4[text() = 'Subscribe to my newsletter:']")).isDisplayed());
//        Assert.assertTrue(driver.findElement(By.xpath("//h4[. = 'Subscribe to my newsletter:']")).isDisplayed());
//
//        // Поиск элемента у которого текстовое значение содержит подстроку
//        Assert.assertTrue(driver.findElement(By.xpath("//*[contains(text(), 'catego')]")).isDisplayed());
//
//        // Поиск элемента по индексу
//        Assert.assertTrue(driver.findElement(By.xpath("//ul/li[3]")).isDisplayed());
//    }
//
//    @Test
//    public void axesXPathTest() {
//        driver.get("file:/Users/aleksandr.trostyanko/Documents/Work/TeachMeSkills/Groups/aqa25onl/aqa25_onl/src/test/resources/index.html");
//
//        // Поиск родителя у элемента с тэгом h1
//        Assert.assertTrue(driver.findElement(By.xpath("//h1/..")).isDisplayed());
//        Assert.assertTrue(driver.findElement(By.xpath("//h1/parent::div")).isDisplayed());
//
//        // Поиск всех предков с тэгом div у элемента с тэгом h1
//        Assert.assertTrue(driver.findElement(By.xpath("//h1/ancestor::div")).isDisplayed());
//
//        // Использование child - все дочерние элементы с тэго a от div
//        Assert.assertTrue(driver.findElement(By.xpath("//div/h1")).isDisplayed());
//        Assert.assertTrue(driver.findElement(By.xpath("//div/child::h1")).isDisplayed());
//
//        // Использование descendant - все дочерние элементы с тэго a от div
//        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='noSel']//ul")).isDisplayed());
//        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='noSel']//descendant::ul")).isDisplayed());
//
//        //Использование following - Выбирает всё в документе после закрытия тэга текущего узла
//        Assert.assertTrue(driver.findElement(By.xpath("//form/div[@class='noSel']/following::h4")).isDisplayed());
//
//        //Использование following-sibling - Выбирает все узлы одного уровня после текущего узла
//        Assert.assertTrue(driver.findElement(By.xpath("//form/div[@class='noSel']/following-sibling::div")).isDisplayed());
//
//        //Использование preceding- Выбирает все узлы, которые появляются перед текущим узлом в документе
//        Assert.assertTrue(driver.findElement(By.xpath("//input[@type=\"email\"]/preceding::h4")).isDisplayed());
//
//        //Использование preceding-sibling - Выбирает все узлы одного уровня до текущего узла
//        Assert.assertTrue(driver.findElement(By.xpath("//input[@type=\"email\"]/preceding::div[@style='overflow:auto;']/preceding-sibling::h4")).isDisplayed());
//
//
//        //Гонки на виражах
//        Assert.assertTrue(driver.findElement(By.xpath("//input[@type='text']/ancestor::div[@class='noSel newsletter']/form/h4[text() = 'Newscategories:']")).isDisplayed());
//    }