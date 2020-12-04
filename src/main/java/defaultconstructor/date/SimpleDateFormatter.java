package defaultconstructor.date;

public class SimpleDateFormatter {

    private CountryCode defaultCountry;

    public SimpleDateFormatter() {
        this.defaultCountry = CountryCode.HU;
    }

    public String formatDateString(SimpleDate simpleDate) {
        return formatDateStringByCountryCode(CountryCode.HU, simpleDate);
    }

    public String formatDateStringByCountryCode (CountryCode countryCode, SimpleDate simpleDate) {
        StringBuilder sb = new StringBuilder();
        if (countryCode == CountryCode.HU) {
            sb.append(simpleDate.getYear()).append("-").append(simpleDate.getMonth()).append("-").append(simpleDate.getDay());
        } else if (countryCode == CountryCode.EN) {
            sb.append(simpleDate.getDay()).append("-").append(simpleDate.getMonth()).append("-").append(simpleDate.getYear());
        } else if (countryCode == CountryCode.US) {
            sb.append(simpleDate.getMonth()).append("-").append(simpleDate.getDay()).append("-").append(simpleDate.getYear());
        }
        return sb.toString();
    }
}
