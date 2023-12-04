package org.testtask.testtask1;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class BracketsCheckerTest {
    private BracketsChecker bracketsChecker;

    @BeforeMethod
    public void setUp(){
        bracketsChecker = new BracketsChecker();
    }

    @DataProvider
    public Object[][] bracketsProvider(){
        return new Object[][]{
                {"()", true},
                {"[]", true},
                {"{}", true},
                {"(()", false},
                {"())", false},
                {"[[]", false},
                {"[]]", false},
                {"{{}", false},
                {"{}}", false},
                {"([])", true},
                {"[()]", true},
                {"aaaa[dddd(ssss)cccc]", true},
                {"aa[ss[dd(cc[vv)bb]nn]nnn", false},
                {"aaaaaa", true}
        };
    }

    @Test(dataProvider = "bracketsProvider")
    public void testIsBalanced(String input, boolean expected){
        assertEquals(bracketsChecker.isBalanced(input), expected);
    }
}
