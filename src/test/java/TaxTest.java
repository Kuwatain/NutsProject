import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TaxTest {

    UltimateFeeCalculator calc = new UltimateFeeCalculator();

    @DataProvider(name = "testProvider")
    public static Object[][] primeNumbers() {
        return new Object[][]{
                {-1, false, false, false, false, 0},
                {-1, true, false, false, false, 150},

                {0, false, false, false, false, 0},
                {0, true, false, false, false, 150},

                {999, false, false, false, false, 150},

                {1000, false, false, false, false, 150},
                {1000, false, true, false, false, 160},

                {1001, false, false, false, false, 160},
                {1001, false, true, false, false, 170},

                {1000, false, false, true, false, 250},
                {1001, false, false, true, false, 260},

                {10000, false, true, false, false, 1560},
                {10000, false, true, false, true, 1613},
                {10000, false, false, true, true, 1708},
                {10000, false, false, true, false, 1650},
                {10000, false, false, false, false, 1550},
                {10000, false, false, false, true, 1603},

                {10001, false, true, false, false, 1571},
                {10001, false, true, false, true, 1625},
                {10001, false, false, true, true, 1719},
                {10001, false, false, true, false, 1661},
                {10001, false, false, false, false, 1561},
                {10001, false, false, false, true, 1614}
        };
    }

    @Test(dataProvider = "testProvider")
    public void testTaxes(
            int income,
            boolean isZeroIncluded,
            boolean isThousandIncludedAsCompleteHundred,
            boolean isHundredsBelowThousandIncluded,
            boolean isFivePercentAddedToFee,
            int expectedResult
    ) {
        int result = calc.proceed(
                income,
                isZeroIncluded,
                isThousandIncludedAsCompleteHundred,
                isHundredsBelowThousandIncluded,
                isFivePercentAddedToFee
        );

        Assert.assertEquals(result, expectedResult);
    }
}
