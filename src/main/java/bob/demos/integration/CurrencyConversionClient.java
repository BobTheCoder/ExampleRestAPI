package bob.demos.integration;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "CurrencyConversionClient", url = "https://frankfurter.app")
public interface CurrencyConversionClient {

    @RequestMapping(method = RequestMethod.GET, value = "/latest")
    ConvertedCurrency getCurrencyConversion(@RequestParam(value="amount") long amount,
                                            @RequestParam(value="from") String origCurrency,
                                            @RequestParam(value="destCurrency") String destCurrency);
}
