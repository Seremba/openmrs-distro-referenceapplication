package org.openmrs.reference;

import org.junit.Before;
import org.junit.Test;
import org.openmrs.reference.page.FindPatientPage;
import org.openmrs.reference.page.HeaderPage;
import org.openmrs.reference.page.HomePage;
import org.openmrs.uitestframework.test.TestBase;
import org.junit.*;
import static org.junit.Assert.*;


/**
 * Created by nata on 16.06.15.
 */

    public class RecentlyPatientTest extends TestBase {
    private HomePage homePage;
    private HeaderPage headerPage;
    private FindPatientPage findPatientPage;


    @Before
    public void setUp() throws Exception {
        homePage = new HomePage(driver);
        loginPage.loginAsAdmin();
        assertPage(homePage);
        headerPage = new HeaderPage(driver);
        findPatientPage = new FindPatientPage(driver);

    }

    @Test
    public void testRecentlyPatientTest() throws Exception {
        homePage.clickOnFindPatientRecord();
        findPatientPage.enterPatient("Bob Smith");
        headerPage.clickOnHomeIcon();
        homePage.clickOnFindPatientRecord();
        assertNotNull(findPatientPage.PATIENT_SEARCH_RESULT);
    }



    @After
    public void tearDown() throws Exception {
        headerPage.clickOnHomeIcon();
        headerPage.logOut();
    }

}
