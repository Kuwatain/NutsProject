public class UltimateFeeCalculator {

    /**
     * Proceed calculations on payment taxes for a person
     *
     * @param income                              - Income of the person
     * @param isZeroIncluded                      - Does the person pay for zero income
     * @param isThousandIncludedAsCompleteHundred - Is person paying additional taxes for first thousand
     * @param isHundredsBelowThousandIncluded     - Is person paying additional taxes for income below thousand
     * @param isFivePercentAddedToFee             - Is person paying additional 5%
     * @return - Final nuts taxes person has to pay
     */
    public int proceed(
            double income,
            boolean isZeroIncluded,
            boolean isThousandIncludedAsCompleteHundred,
            boolean isHundredsBelowThousandIncluded,
            boolean isFivePercentAddedToFee
    ) {
        int fee = 0;
        double incomeToCount;

        if (income <= 0) fee = isZeroIncluded ? 150 : 0;

        if (income > 0 && income < 1000) fee = 150;

        //TODO Could be not included, to clarify requirement
        if (income >= 1000) {

            double additionalFee = isThousandIncludedAsCompleteHundred ? 10 : 0;
            incomeToCount = income - 1000;

            if (isHundredsBelowThousandIncluded) {
                additionalFee = 0;
                incomeToCount = income;
            }

            double hundredsFee = Math.ceil(incomeToCount / 100);

            additionalFee = additionalFee + 10 * hundredsFee;

            fee = 150 + (int) additionalFee;
        }

        //TODO Could be not included, to clarify requirement
        if (income >= 10000) {
            if (isFivePercentAddedToFee) {
                fee = (int) Math.ceil(fee * 1.05);
            }
            fee = fee + (int) Math.ceil(income * 0.05);
        }

        System.out.println("\tResult fee: " + fee);
        return fee;
    }
}
